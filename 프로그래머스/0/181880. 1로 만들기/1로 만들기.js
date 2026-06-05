function solution(num_list) {
    var answer = 0;
    for(let i=0; i<num_list.length; i++){
        var n = num_list[i];
        while(n!=1){
            if(n%2==0){
                n/=2;
            } else {
                n = (n-1)/2;
            }
            answer++;
        }
    }
    return answer;
}