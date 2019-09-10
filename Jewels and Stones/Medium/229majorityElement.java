import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        if(nums.length==0){
            return list;
        }else if(nums.length == 2 && nums[0] !=nums[1]){
            list.add(nums[0]);
            list.add(nums[1]);
            return list;
        }
        int count = 0;
        int cur = nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==cur){
                count++;
            }
            if(nums[i]!=cur||i==nums.length-1){
                if(count>nums.length/3){
                    list.add(cur);
                    count=1;
                }else{
                    count=1;
                }
                cur=nums[i];
            }
        }
        return list;
    }
}