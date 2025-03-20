package java_2025.Mar.Study;

public class 카펫 {
    private int g,s;
    public int[] solution(int brown, int yellow) {
        g = 0;
        s = 0;
        int area = brown+yellow;
        for (int width = (int) Math.sqrt(area); width <= area; width++) {
            if (area % width == 0 ) {
                int height = area / width;
                if(width<height) continue;

                if ((width * 2) + (height - 2) * 2 == brown && (width - 2) * (height - 2) == yellow) {
                    g = width;
                    s = height;
                    break;
                }
            }
        }
        return new int[]{g,s};
    }
}
