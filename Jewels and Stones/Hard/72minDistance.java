class Solution {
    public int minDistance(String word1, String word2) {
        StringBuilder sb1 = new StringBuilder(word1);
        StringBuilder sb2 = new StringBuilder(word2);
        int[][] dp = new int[sb1.length()+1][sb2.length()+1];

        for(int i=1;i<=sb1.length();i++){
            dp[i][0]=i;
        }

        for(int j=1;j<=sb2.length();j++){
            dp[0][j]=j;
        }

        for(int i=1;i<=sb1.length();i++){
            for(int j=1;j<=sb2.length();j++){
                if(sb1.charAt(i-1)==sb2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(dp[i][j-1],Math.min(dp[i-1][j], dp[i-1][j-1]))+1;
                }
            }
        }
        return dp[sb1.length()][sb2.length()];
    }
}