function solution(arr, queries) {
    for(var i=0; i<queries.length; i++){
        for(var j=queries[i][0]; j<=queries[i][1]; j++){
            arr[j]++;
        }
    }
    return arr;
}