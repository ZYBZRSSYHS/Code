class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor==0){
            return -1;
        }else if(dividend==0){
            return 0;
        }else if(dividend==Integer.MIN_VALUE && divisor==-1){
        return Integer.MAX_VALUE;
        }
        boolean negetive = (dividend^divisor)<0;
        int res = 0,div_count=1;
        long dividend_tmp = Math.abs((long)dividend);
        long divisor_tmp = Math.abs((long)divisor);

        while(dividend_tmp>=divisor_tmp){
            dividend_tmp-=divisor_tmp;
            res+=div_count;

            if(dividend_tmp<Math.abs(divisor))break;

            if(dividend_tmp-divisor_tmp<divisor_tmp){
                divisor_tmp=Math.abs(divisor);
                div_count=1;
                continue;
            }
            divisor_tmp+=divisor_tmp;
            div_count+=div_count;
        }
        return negetive? 0-res:res;
    }
}