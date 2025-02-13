package java_2025.Feb.Study;

class 마법의_엘리베이터 {
    public int solution(int storey) {
        int answer = 0;
        String[] str = String.valueOf(storey).split("");
        int n = str.length;

        int cur = 1;
        int number = storey;
        while(cur<=n){
            int prevPow = (int)Math.pow(10, cur-1); // 10
            int pow = (int)Math.pow(10, cur); // 100 이라면,
            int nextPow = (int)Math.pow(10, cur+1); // 1000

            int mod = number%pow;
            if(mod>(5*prevPow)){
                answer += (pow-mod)/prevPow;
                number += (pow-mod);
            } else if(cur<n&&mod==(5*prevPow)) {
                int next = number%nextPow/pow;
                if(next>=5){
                    answer += (pow-mod)/prevPow;
                    number += (pow-mod);
                } else {
                    answer += mod/prevPow;
                    number -= mod;
                }
            } else {
                answer += mod/prevPow;
                number -= mod;
            }
            cur++;
        }

        String[] newStr = String.valueOf(number).split("");
        if(n<newStr.length){
            int idx = 0;
            while(idx<newStr.length-1){
                answer += Integer.parseInt(newStr[idx++]);
            }
        }

        return answer;
    }
}