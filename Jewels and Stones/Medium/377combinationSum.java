class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(nums.length==0){
            return 0;
        }
        int[] dp = new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int num:nums){
                if(i>=num && i-num>=0 && i-num<=target){
                    dp[i]+=dp[i-num];
                }
            }
        }
        return dp[target];
    }
}