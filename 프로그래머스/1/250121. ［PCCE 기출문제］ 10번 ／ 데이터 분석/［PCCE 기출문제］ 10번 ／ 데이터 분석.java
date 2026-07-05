import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        PriorityQueue<Data> queue = new PriorityQueue<>();
        int index = getIndex(ext);
        int sort = getIndex(sort_by);
        for(int[] d: data){
            if(d[index]<val_ext){
                queue.offer(new Data(d,sort));
            }
        }
        int[][] answer = new int[queue.size()][4];
        int i=0;
        while(!queue.isEmpty()){
            answer[i++] = queue.poll().arr;
        }
        return answer;
    }
    
    private int getIndex(String str){
        switch(str){
            case "code":
                return 0;
            case "date":
                return 1;
            case "maximum":
                return 2;
            case "remain":
                return 3;
        }
        return -1;
    }
    
    class Data implements Comparable<Data>{
        int[] arr;
        int sortIndex;
        
        Data(int[] arr, int s){
            this.arr = arr;
            this.sortIndex = s;
        }
        
        @Override
        public int compareTo(Data o){
            return this.arr[this.sortIndex]-o.arr[o.sortIndex];
        }
    }
}