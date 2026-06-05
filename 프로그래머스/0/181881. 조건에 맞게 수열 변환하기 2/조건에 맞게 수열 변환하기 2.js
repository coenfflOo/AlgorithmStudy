function solution(arr) {
    var change = true;
    var answer = 0;
    while(change){
        change = false;
        for(let i=0; i<arr.length; i++){
            if(arr[i]>=50&&arr[i]%2==0){
                arr[i]/=2;
                change = true;
            } else if(arr[i]<50&&arr[i]%2==1){
                arr[i] = arr[i]*2+1;
                change = true;
            }
        }
        answer++;
    }
    return answer-1;
}