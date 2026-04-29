package java_2026.April;
import java.util.*;
import java.io.*;
import java.lang.*;
public class pro_TripRoute {
    public String[] solution(String[][] tickets) {
        // 출발지 -> 도착지 목록 (알파벳 순 자동 정렬을 위해 PriorityQueue 사용)
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for(String[] t: tickets){
            String start = t[0];
            String end = t[1];

            // 출발지가 map에 없으면 새로 추가
            if(!map.containsKey(start)){
                map.put(start, new PriorityQueue<>());
            }
            map.get(start).offer(end);
        }

        List<String> list = new ArrayList<>();
        dfs("ICN", map, list);

        // dfs 결과가 역순으로 쌓이므로, 뒤에서부터 꺼내 answer 배열에 채움
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(list.size()-1-i);
        }
        return answer;
    }

    private static void dfs(String airport, Map<String, PriorityQueue<String>> map, List<String> result) {
        PriorityQueue<String> pq = map.get(airport);

        // 현재 공항에서 출발하는 항공권이 없으면 (최종 목적지)
        // 바로 result에 추가하고 종료
        if (pq == null) {
            result.add(airport);
            return;
        }

        // 갈 수 있는 곳을 알파벳 순으로 하나씩 꺼내며 DFS 탐색
        // PriorityQueue이므로 poll()할 때마다 알파벳 가장 앞선 목적지가 나옴
        while(!pq.isEmpty()){
            String next = pq.poll();
            dfs(next, map, result);
        }

        // 더 이상 갈 곳이 없을 때 현재 공항을 result에 추가
        // → 재귀가 깊이 들어갔다 나오면서 역순으로 쌓이는 구조
        result.add(airport);
    }
}
