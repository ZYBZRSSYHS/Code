class Solution {
    public String countAndSay(int n) {
        char[] a = {'1'};
        for(int i=1;i<n;i++){
            char ch = a[0];
            int num = 0;
            StringBuilder sb = new StringBuilder();
            int j=0;
            while(true){
                if(a[j]==ch){
                    num++;
                }else{
                    sb.append(num);
                    sb.append(a[j-1]);
                    ch = a[j];
                    num = 1;
                }
                j++;
                if(j>=a.length){
                    sb.append(num);
                    sb.append(a[j-1]);
                    break;
                }
            }
            a = sb.toString().toCharArray();
            sb.delete(0, sb.length());
        }
        return String.valueOf(a);
    }
}