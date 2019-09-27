class Solution {
    int cool(int n){
        int sum=0;
        while(n>0){
            int p=n%10;
            sum+=p*p;
            n=n/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int zz1=n,zz2=n;
        do{
            zz1=cool(zz1);
            zz2=cool(zz2);
            zz2=cool(zz2);
        }while(zz1!=zz2);
        return zz1==1;
    }
}