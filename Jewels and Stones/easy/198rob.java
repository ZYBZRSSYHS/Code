class Solution {
    public int rob(int[] nums) {
        int currenmax=0;
        int premax = 0;
        for(int i:nums){
            //获取目前遍历数组下标的最大值
            int temp = currenmax;
            //更新最大值，要么新增并且使用上一个最大值，或者继续使用当前最大值
            currenmax = Math.max(premax+i,currenmax);
            //此时获得上一个最大值，即没更新的数值最大的情况
            premax=temp;
        }
        return currenmax;
    }
}