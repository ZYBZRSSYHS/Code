class Solution {
    public boolean checkPossibility(int[] nums) {
        if(nums.length<3){
            return true;
        }
        int ans = 0;
        for(int i=nums.length-2;i>=0;i--){
            if(ans>1){
                return false;
            }
            if(nums[i]<=nums[i+1]){
                continue;
            }
            if(i+2<nums.length && nums[i]>nums[i+2]){
                nums[i]=nums[i+1];
            }
            ans++;
        }
        return ans<2;
    }
}