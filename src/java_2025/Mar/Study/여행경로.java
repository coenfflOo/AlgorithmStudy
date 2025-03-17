package java_2025.Mar.Study;
import java.util.*;
public class 여행경로 {
    public String[] solution(String[][] tickets) {
        TreeMap<String, PriorityQueue<String>> graph = new TreeMap<>();
        for (String[] ticket : tickets) {
            graph.putIfAbsent(ticket[0], new PriorityQueue<>());
            graph.get(ticket[0]).add(ticket[1]);
        }

        List<String> route = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push("ICN");

        while (!stack.isEmpty()) {
            String current = stack.peek();
            if (graph.containsKey(current) && !graph.get(current).isEmpty()) {
                stack.push(graph.get(current).poll());
            } else {
                route.add(0,stack.pop());
            }
        }

        return route.toArray(new String[0]);
    }
}
