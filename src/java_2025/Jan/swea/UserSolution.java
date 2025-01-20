package java_2025.Jan.swea;

class UserSolution {

    private static int n, m;
    private static int[][] bit;
    private static int[][] mapPos;
    private static int[] mapPosLen;

    public void init(int N, int M, int[][] Map) {
        n = N;
        m = M;
        bit = new int[N][N - M + 1];

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
				if (Pieces[i][j] == 1) {
					countOnes++;
				}
            }
        }

        int[][][] rotated = new int[4][m][m];
        rotated[0] = Pieces;
        for (int i = 1; i < 4; i++) {
            rotated[i] = rotate(rotated[i - 1]);
        }

        int threshold = (m * m) / 2;
        boolean useBitMask = (countOnes >= threshold);

        if (useBitMask) {
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
					if (bitCount[i] > bitCount[anchor]) {
						anchor = i;
					}
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
                int anchor = 0;
                for (int i = 1; i < m; i++) {
					if (pPosLen[i] > pPosLen[anchor]) {
						anchor = i;
					}
                }

                for (int si = 0; si <= n - m; si++) {
                    int rowMap = si + anchor;
                    int alen = mapPosLen[rowMap];
                    int plen = pPosLen[anchor];
					if (alen == 0 && plen > 0) {
						continue;
					}
                    int[] mapArr = mapPos[rowMap];
                    int[] patArr = pPos[anchor];

                    offsetsLoop:
                    for (int x = 0; x < alen; x++) {
                        int offset = mapArr[x] - patArr[0];
						if (offset < 0 || offset > n - m) {
							continue;
						}
                        for (int pp = 1; pp < plen; pp++) {
                            int need = patArr[pp] + offset;
                            if (!binarySearch(mapArr, alen, need)) {
                                continue offsetsLoop;
                            }
                        }
                        if (checkAllList(pPos, pPosLen, anchor, si, offset)) {
                            Point rp = rotatePivot(pivot, rtt);
                            res.y = si + rp.i;
                            res.x = offset + rp.j;
                            updateMapList(pPos, pPosLen, si, offset);
                            return res;
                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean checkAllBitMask(int[] rowMask, int anchor, int si, int sj) {
        for (int i = 0; i < m; i++) {
			if (i == anchor) {
				continue;
			}
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

    private boolean checkAllList(int[][] pPos, int[] pPosLen, int anchor, int si, int offset) {
        for (int i = 0; i < m; i++) {
			if (i == anchor) {
				continue;
			}
            int rowMap = si + i;
            int alen = mapPosLen[rowMap];
			if (alen == 0 && pPosLen[i] > 0) {
				return false;
			}
            int[] mapArr = mapPos[rowMap];
            int plen = pPosLen[i];
            int[] patArr = pPos[i];
            for (int pp = 0; pp < plen; pp++) {
                int need = patArr[pp] + offset;
                if (!binarySearch(mapArr, alen, need)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void updateMapList(int[][] pPos, int[] pPosLen, int si, int offset) {
        for (int i = 0; i < m; i++) {
            int row = si + i;
            int plen = pPosLen[i];
            for (int pp = 0; pp < plen; pp++) {
                int col = pPos[i][pp] + offset;
                int colBlock = col - (m - 1);
				if (colBlock < 0) {
					colBlock = 0;
				}
                for (int c = colBlock; c <= col && c <= n - m; c++) {
                    int shift = col - c;
                    if (shift < m) {
                        bit[row][c] &= ~(1 << (m - 1 - shift));
                    }
                }
                removeOneFromMapPos(row, col);
            }
        }
    }

    private void removeOneFromMapPos(int row, int col) {
        int alen = mapPosLen[row];
        int[] arr = mapPos[row];
        int left = 0, right = alen - 1;
        int pos = -1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] == col) {
                pos = mid;
                break;
            } else if (arr[mid] < col) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
        }
        if (pos >= 0) {
            System.arraycopy(arr, pos + 1, arr, pos, alen - pos - 1);
            mapPosLen[row]--;
        }
    }

    private boolean binarySearch(int[] arr, int end, int val) {
        int left = 0, right = end - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
			if (arr[mid] == val) {
				return true;
			} else if (arr[mid] < val) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
        }
        return false;
    }

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
            case 1:
                return new Point(p.j, m - 1 - p.i);
            case 2:
                return new Point(m - 1 - p.i, m - 1 - p.j);
            case 3:
                return new Point(m - 1 - p.j, p.i);
        }
        return new Point(p.i, p.j);
    }

    private static class Point {
        int i, j;

        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}