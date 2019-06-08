class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){
            if(i!=0&&nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<nums.length;j++){
                if(j!=i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int left = j+1;
                int right = nums.length-1;
                while(left<right){
                    if(left !=j+1 && nums[left]==nums[left-1]
                    ||nums[i]+nums[j]+nums[left]+nums[right]<target){
                        left++;
                    }else if((right !=nums.length-1 && nums[right]==nums[right+1])
                    ||nums[i]+nums[j]+nums[left]+nums[right]>target){
                        right--;
                    }else{
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);

                        result.add(list);
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}