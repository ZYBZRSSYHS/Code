class Solution {
    public String convertToTitle(int n) {
        String az="#ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] cz = az.toCharArray();

        StringBuilder sb = new StringBuilder();

        while(n>0){
            if(n%26==0){
                sb.append('Z');
                n=n/26-1;
            }else{
            sb.append(cz[n%26]);
            n=n/26;
            }
        }
        return sb.reverse().toString();
    }
}