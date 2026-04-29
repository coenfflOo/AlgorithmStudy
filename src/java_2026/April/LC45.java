package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class LC45 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
        System.out.println(canJump(new int[]{0}));
        System.out.println(canJump(new int[]{1,2}));
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;

        // remaining = 현재 위치에서 추가로 더 갈 수 있는 여유 칸 수
        int remaining = 0;

        // 마지막 전 인덱스까지만 체크 (마지막은 도착점)
        for(int i = 0; i < n-1; i++) {

            // nums[i]==0 이면 이 칸에서 점프 불가
            // remaining==0 이면 이전에서 가져온 여유도 없음
            // 둘 다 0이면 여기서 막힘!
            if(nums[i] == 0 && remaining == 0)
                return false;

            // remaining 업데이트
            // remaining-1: 한 칸 이동했으니 여유 1 감소
            // nums[i]-1: 현재 칸에서 점프 가능한 칸 수 - 1 (현재칸 제외)
            // 둘 중 더 큰 값이 다음 칸의 여유
            remaining = Math.max(remaining - 1, nums[i] - 1);
        }
        return true;
    }

//    public static boolean canJump(int[] nums) {
//        if (nums.length == 0 || nums.length == 1) return true;
//        Queue<Integer> queue = new LinkedList<>();
//        boolean[] visited = new boolean[nums.length];
//        visited[0] = true;
//        queue.add(0);
//        while(!queue.isEmpty()){
//            int cur = queue.poll();
//            for (int i = 1; i <= nums[cur]; i++) {
//                int next = cur + i;
//                if (next == nums.length - 1) return true;
//                if(next >= nums.length || visited[next]) continue;
//                visited[next] = true;
//                queue.offer(next);
//            }
//        }
//        return false;
//    }
}
