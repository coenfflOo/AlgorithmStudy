package September;

import java.util.*;
import java.io.*;

public class bj2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println(getMean(arr));
        System.out.println(getMedian(arr));
        System.out.println(getMode(arr));
        System.out.println(getRange(arr));
    }

    public static int getMean(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return Math.round((float) sum / arr.length);
    }

    public static int getMedian(int[] arr) {
        return arr[arr.length / 2];
    }

    public static int getMode(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 0;
        List<Integer> modes = new ArrayList<>();

        for (int num : arr) {
            int frequency = frequencyMap.getOrDefault(num, 0) + 1;
            frequencyMap.put(num, frequency);

            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                modes.clear();
                modes.add(num);
            } else if (frequency == maxFrequency) {
                modes.add(num);
            }
        }

        if (modes.size() == 1) {
            return modes.get(0);
        } else {
            modes.sort(null);
            return modes.get(1);
        }
    }

    public static int getRange(int[] arr) {
        return arr[arr.length - 1] - arr[0];
    }
}
