class Solution {
    public int countPrimes(int n) {
        byte[] cool = new byte[n];
        int num=0;
        for(int i=2;i<n;i++){
            cool[i]=1;
        }

        for(int i=2;i<n;i++){
            if(cool[i]==1){
                for(int j=2;i*j<n;j++){
                    cool[i*j]=0;
                }
            }
        }

        for(int i=2;i<n;i++){
            if(cool[i]==1){
                ++num;
            }
        }
        return num;
    }
}