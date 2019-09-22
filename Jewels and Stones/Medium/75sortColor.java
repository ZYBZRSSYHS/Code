class Solution {
    public void sortColors(int[] nums) {
        int l=0;
        int start=0,end=nums.length-1;
        int tmp;
        while(l<=end){
            if(nums[l]==0){
                tmp=nums[start];
                nums[start++]=nums[l];
                nums[l++]=tmp;
            }else if(nums[l]==2){
                tmp=nums[end];
                nums[end--]=nums[l];
                nums[l]=tmp;
            }else l++;
        }
    }
}