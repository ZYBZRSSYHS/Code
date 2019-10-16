class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = (1+len)*len/2;
        for(int i=0;i<len;i++){
            sum-=nums[i];
        }
        return sum;
    }
}