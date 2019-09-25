class Solution {
    public String getHint(String secret, String guess) {
        int[] arr = new int[10];
        int[] brr = new int[10];
        int maxa=0;
        int mini=0;
        for(int i=0;i<secret.length();i++){
            
            if(secret.charAt(i)==(guess.charAt(i))){
                maxa++;
            }else{
                arr[secret.charAt(i)-'0']++;
                brr[guess.charAt(i)-'0']++;
            }
        }
        for(int i=0;i<10;i++){
            mini+=Math.min(arr[i], brr[i]);
        }

        return maxa+"A"+mini+"B";
    }
}