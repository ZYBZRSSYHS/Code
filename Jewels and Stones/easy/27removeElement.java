class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0;
        for(int j:nums){
            if(nums[j]!=val){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }
}