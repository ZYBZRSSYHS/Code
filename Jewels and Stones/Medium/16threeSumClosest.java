class Solution{
    public int threeSumClosest(int[] nums,int target){
        Arrays.sort(nums);
        int n = nums.length;
        int res = nums[0]+nums[1]+nums[n-1];
        for(int i=0;i<n-2;i++){
            if(i>0&&nums[i]==nums[i-1])
            continue;
            int left = i+1;
            int right = n-1;
            while(left<right){
                int cur = nums[i] + nums[left] +nums[right];
                if(cur == target)
                return target;
                if(Math.abs(res-target)>Math.abs(cur-target))
                res = cur;
                if(cur>target)
                right -=1;
                if(cur<target)
                left+=1;
            }
        }
        return res;
    }
}