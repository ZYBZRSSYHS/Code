class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int cnt=0;
        while(m!=n){
            if(m==0){
                return 0;
            }
            m>>=1;
            n>>=1;
            cnt++;
        }
        return m<<cnt;
    }
}