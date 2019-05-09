class Solution{
    public int searchInsert(int []nums,int target){
        int left = 0;
        int right = nums.length;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]<target)left = mid +1;
            else right = mid;
        }
        return left;
    }
}
// class Solution {
//     public int searchInsert(int[] nums, int target) {
//         return binarySearch(nums, target, 0, nums.length-1);
//     }
//     private int binarySearch(int[] nums,int target,int begin,int end){
//         int mid = (begin+end)/2;
//         if(nums[mid]==target){
//             return mid;
//         }
//         if(begin+1==end||end==0){
//             if(target<nums[begin]){
//                 return begin;
//             }else if(target > nums[end]){
//                 return end+1;
//             }else{
//                 return end;
//             }
//         }
//         if(nums[mid]>target){
//             return binarySearch(nums,target,begin,mid);
//         }else{
//             return binarySearch(nums,target,mid,end);
//         }
//     }
// }