class Solution {
    public int countPrimes(int n) {
        if(n<2){
            return 0;
        }
        boolean[] sum = new boolean[n];
        int ans=0;
        for(int i=2;i*i<n;i++){
            if(!sum[i]){
                for(int j=i*i;j<n;j+=i){
                    if(sum[j]){
                        continue;
                    }
                    ++ans;
                    sum[j]=true;
                }
            }
        }
        return n-ans-2;
    }
}