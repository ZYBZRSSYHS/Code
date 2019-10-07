class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len==1){
            return nums[0];
        }
        int pre = 0;
        int max1 = 0;
        for(int i=1;i<len;i++){
            int temp = max1;
            max1 = Math.max(pre+nums[i], max1);
            pre = temp;
        }
        pre=0;
        int max2 = 0;
        for(int i=0;i<len-1;i++){
            int temp = max2;
            max2 = Math.max(pre+nums[i], max2);
            pre = temp;
        }
        return Math.max(max1, max2);
    }
}