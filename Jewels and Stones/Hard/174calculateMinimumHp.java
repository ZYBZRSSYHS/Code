class Solution{
    public int calculateMinimumHP(int[][] dungeon){
        if(dungeon==null||dungeon.length==0){
            return 0;
        }
        int row = dungeon.length;
        int col = dungeon[0].length;

        int[][] dp = new int[row][col];

        dp[row-1][col-1] = dungeon[row-1][col-1]>0?1:-dungeon[row-1][col-1]+1;
        
        for(int i=col-2;i>=0;i--){
            dp[row-1][i] = dungeon[row-1][i]>=dp[row-1][i+1]?1:dp[row-1][i+1]-dungeon[row-1][i];
        }
        for(int i=row-2;i>=0;i--){
            dp[i][col-1] = dungeon[i][col-1]>=dp[i+1][col-1]?1:dp[i+1][col-1]-dungeon[i][col-1];
        }
        for(int i=row-2;i>=0;i--){
            for(int j=col-2;j>=0;j--){
                dp[i][j] = (dungeon[i][j]>=Math.min(dp[i][j+1],dp[i+1][j]))?1:Math.min(dp[i][j+1],dp[i+1][j])-dungeon[i][j];
            }
        }
        return dp[0][0];
    }
}