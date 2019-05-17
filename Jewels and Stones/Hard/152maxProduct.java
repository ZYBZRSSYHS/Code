class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0)return 0;
        if(nums.length == 1)return nums[0];
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        int retVal;
        retVal = max[0] = min[0] = nums[0];

        for(int i=1;i<nums.length;i++){
            max[i] = Math.max(nums[i], Math.max(nums[i]*max[i-1], nums[i]*min[i-1]));
            min[i] = Math.min(nums[i], Math.min(nums[i]*max[i-1], nums[i]*min[i-1]));
            retVal = Math.max(retVal, max[i]);
        }
        return retVal;
    }
}