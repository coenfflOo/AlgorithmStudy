package java_2025.Jan.swea;

class UserSolution {

    private static int n, m;
    private static int[][] bit;
    private static final int MAX_M = 20;

    // 지도 각 행의 1 비트 위치를 저장할 리스트
    // (정렬리스트 방식에서 사용)
    private static int[][] mapPos;
    private static int[] mapPosLen;

    public void init(int N, int M, int[][] Map) {
        n = N;
        m = M;
        bit = new int[N][N - M + 1];

        // 비트마스크화
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum = (sum << 1) | Map[i][j];
            }
            bit[i][0] = sum;
            for (int j = 1; j <= N - M; j++) {
                sum = ((sum << 1) & ((1 << M) - 1)) | Map[i][j + M - 1];
                bit[i][j] = sum;
            }
        }

        // 정렬리스트(각 행에서 1인 열만 모음)
        // 최악의 경우 한 행에 1000개 1이 있을 수 있으니, 2차원 배열 동적할당
        mapPos = new int[N][N];
        mapPosLen = new int[N];
        for (int i = 0; i < N; i++) {
            int idx = 0;
            for (int j = 0; j < N; j++) {
                if (Map[i][j] == 1) {
                    mapPos[i][idx++] = j;
                }
            }
            mapPosLen[i] = idx;
        }
    }

    public Solution.Result findTreasureChest(int[][] Pieces) {
        Solution.Result res = new Solution.Result();
        Point pivot = null;
        int countOnes = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (Pieces[i][j] == 9) {
                    Pieces[i][j] = 1;
                    pivot = new Point(i, j);
                }
                if (Pieces[i][j] == 1) countOnes++;
            }
        }

        int[][][] rotated = new int[4][m][m];
        rotated[0] = Pieces;
        for (int i = 1; i < 4; i++) {
            rotated[i] = rotate(rotated[i - 1]);
        }

        // "밀집도" 기준으로 어느 방식을 쓸지 결정
        // 여기서는 예시로 "조각의 1 비트가 전체 m*m의 절반 이상"이면 비트마스크,
        // 그 미만이면 정렬리스트 사용
        int threshold = (m*m)/2;
        boolean useBitMask = (countOnes >= threshold);

        if (useBitMask) {
            // 비트마스크 방식
            for (int rtt = 0; rtt < 4; rtt++) {
                int[] rowMask = new int[m];
                int[] bitCount = new int[m];
                for (int i = 0; i < m; i++) {
                    int mask = 0;
                    for (int j = 0; j < m; j++) {
                        mask = (mask << 1) | rotated[rtt][i][j];
                    }
                    rowMask[i] = mask;
                    bitCount[i] = Integer.bitCount(mask);
                }
                int anchor = 0;
                for (int i = 1; i < m; i++) {
                    if (bitCount[i] > bitCount[anchor]) anchor = i;
                }

                for (int si = 0; si <= n - m; si++) {
                    int anchorRow = si + anchor;
                    for (int sj = 0; sj <= n - m; sj++) {
                        if (((rowMask[anchor] ^ bit[anchorRow][sj]) & rowMask[anchor]) == 0) {
                            if (checkAllBitMask(rowMask, anchor, si, sj)) {
                                Point rp = rotatePivot(pivot, rtt);
                                res.y = si + rp.i;
                                res.x = sj + rp.j;
                                updateMap(rowMask, si, sj);
                                return res;
                            }
                        }
                    }
                }
            }
        } else {
            // 정렬리스트 방식
            // 먼저 조각 각 행의 1 위치를 추출
            // rotated[rtt][i][j] == 1인 j를 모으기
            for (int rtt = 0; rtt < 4; rtt++) {
                int[][] pPos = new int[m][m];
                int[] pPosLen = new int[m];
                for (int i = 0; i < m; i++) {
                    int idx = 0;
                    for (int j = 0; j < m; j++) {
                        if (rotated[rtt][i][j] == 1) {
                            pPos[i][idx++] = j;
                        }
                    }
                    pPosLen[i] = idx;
                }
                // 앵커 행(1 비트 가장 많은 행)
                int anchor = 0;
                for (int i = 1; i < m; i++) {
                    if (pPosLen[i] > pPosLen[anchor]) anchor = i;
                }

                for (int si = 0; si <= n - m; si++) {
                    int rowMap = si + anchor;
                    // mapPos[rowMap]와 pPos[anchor]를 통해 가능한 offset(sj)을 구함
                    // 즉, mapPos[rowMap][x] - pPos[anchor][y]가 동일한 offset을 만들 수 있는가?
                    // 모든 1비트를 만족시켜야 하므로, "anchor" 행 전체 1에 대해 동일 offset이어야 함
                    // 여기서는 "투포인터" 방식으로 offset 후보를 전부 찾고, 
                    // 그 offset에 대해 나머지 행을 검사
                    int alen = mapPosLen[rowMap];
                    int plen = pPosLen[anchor];
                    if (alen == 0 && plen > 0) continue;
                    int[] mapArr = mapPos[rowMap];
                    int[] patArr = pPos[anchor];

                    // 가능한 offset을 찾으려면, patArr[0]과 mapArr를 기준으로 순회
                    // offset = mapArr[x] - patArr[0]
                    // 이 offset이 valid하려면, for all k in patArr, mapArr[x + k - 0]에 k가 있어야 ... 
                    // 하지만 이렇게 하면 매번 전체 patArr를 검사 -> O(alen * plen^2)
                    // 앵커 행만 보면 O(alen * plen) 정도. 그래도 m=20이면 plen 최대 20이므로 괜찮을 수도 있음

                    // 간단구현: mapArr의 모든 원소 ma에 대해 offset = ma - patArr[0]로 잡고,
                    // patArr 모든 원소가 (ma - patArr[0] + patArr[k]) 형태로 mapArr에 존재하는지 확인
                    // -> 이진탐색 O(plen log alen)
                    // -> alen * plen log alen. (alen은 최대 N=1000, plen은 최대 20)
                    // -> 대략 1000 * 20 * log(1000) = 1000 * 20 * 10 = 200k, 충분히 빠름

                    offsetsLoop:
                    for (int x = 0; x < alen; x++) {
                        int offset = mapArr[x] - patArr[0];
                        if (offset < 0 || offset > n - m) continue;
                        for (int pp = 1; pp < plen; pp++) {
                            int need = patArr[pp] + offset;
                            if (!binarySearch(mapArr, 0, alen, need)) {
                                continue offsetsLoop;
                            }
                        }
                        // 여기까지 왔으면 앵커 행 만족
                        // 나머지 행 검사
                        if (checkAllList(pPos, pPosLen, anchor, si, offset, rowMap)) {
                            Point rp = rotatePivot(pivot, rtt);
                            res.y = si + rp.i;
                            res.x = offset + rp.j;
                            // 맵 갱신(조각 배치)
                            updateMapList(pPos, pPosLen, si, offset);
                            return res;
                        }
                    }
                }
            }
        }
        return res;
    }

    // ------------------- (A) 비트마스크용 함수들 -------------------

    private boolean checkAllBitMask(int[] rowMask, int anchor, int si, int sj) {
        for (int i = 0; i < m; i++) {
            if (i == anchor) continue;
            int row = si + i;
            if (((rowMask[i] ^ bit[row][sj]) & rowMask[i]) != 0) {
                return false;
            }
        }
        return true;
    }

    private void updateMap(int[] rowMask, int si, int sj) {
        for (int i = 0; i < m; i++) {
            bit[si + i][sj] &= ~rowMask[i];
        }
    }

    // ------------------- (B) 정렬리스트용 함수들 -------------------

    private boolean checkAllList(int[][] pPos, int[] pPosLen, int anchor, int si, int offset, int anchorRowMap) {
        for (int i = 0; i < m; i++) {
            if (i == anchor) continue;
            int rowMap = si + i;
            int alen = mapPosLen[rowMap];
            if (alen == 0 && pPosLen[i] > 0) return false;
            int[] mapArr = mapPos[rowMap];
            int plen = pPosLen[i];
            int[] patArr = pPos[i];
            for (int pp = 0; pp < plen; pp++) {
                int need = patArr[pp] + offset;
                if (!binarySearch(mapArr, 0, alen, need)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void updateMapList(int[][] pPos, int[] pPosLen, int si, int offset) {
        // 비트마스크 방식에서는 bit[][]를 직접 갱신하지만,
        // 정렬리스트 방식이라면 원래 Map에 대해 1->0 처리를 해줘야 함
        // 그러나 문제 사양에 따라 "조각을 놓으면 Map에서 해당 위치를 0으로 만든다" 정도만
        // 되어 있으면 되므로, 여기서는 bit[][]와 mapPos를 모두 갱신해야 함

        // 간단히 bit[][]도 갱신해주는 로직
        // (조각의 각 행 i, 각 1 위치 pPos[i][k] + offset)에 대해 0으로 만든다
        for (int i = 0; i < m; i++) {
            int row = si + i;
            int plen = pPosLen[i];
            for (int pp = 0; pp < plen; pp++) {
                int col = pPos[i][pp] + offset;
                // 기존 bit[row][*] 갱신
                int colBlock = col - (m - 1);
                if (colBlock < 0) colBlock = 0;
                for (int c = colBlock; c <= col && c <= n - m; c++) {
                    int shift = col - c;
                    if (shift < m) {
                        bit[row][c] &= ~(1 << (m - 1 - shift));
                    }
                }
                // mapPos[row]에서도 col 제거
                removeOneFromMapPos(row, col);
            }
        }
    }

    // mapPos[row]에서 특정 col 하나 제거
    // col 개수가 최대 1000개이고 m=20이라 크게 부담은 아님 (단순 삭제 O(alen))
    private void removeOneFromMapPos(int row, int col) {
        int alen = mapPosLen[row];
        int[] arr = mapPos[row];
        // 이진탐색으로 col 위치 찾아서 shift
        int left = 0, right = alen - 1;
        int pos = -1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] == col) {
                pos = mid;
                break;
            } else if (arr[mid] < col) left = mid + 1;
            else right = mid - 1;
        }
        if (pos >= 0) {
            System.arraycopy(arr, pos+1, arr, pos, alen - pos - 1);
            mapPosLen[row]--;
        }
    }

    private boolean binarySearch(int[] arr, int start, int end, int val) {
        int left = start, right = end - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] == val) return true;
            else if (arr[mid] < val) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    // ------------------- 공통 유틸 -------------------

    private int[][] rotate(int[][] src) {
        int[][] ret = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                ret[i][j] = src[m - 1 - j][i];
            }
        }
        return ret;
    }

    private Point rotatePivot(Point p, int k) {
        switch (k) {
            case 1: return new Point(p.j, m - 1 - p.i);
            case 2: return new Point(m - 1 - p.i, m - 1 - p.j);
            case 3: return new Point(m - 1 - p.j, p.i);
        }
        return new Point(p.i, p.j);
    }

    private class Point {
        int i, j;
        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}