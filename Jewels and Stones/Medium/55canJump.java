class Solution {
    public boolean canJump(int[] nums) {
        int leftIndex = nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]+i>=leftIndex){
                leftIndex=i;
            }
        }
        return leftIndex==0;
    }
}