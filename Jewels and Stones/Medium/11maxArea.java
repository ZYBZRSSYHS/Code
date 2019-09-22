class Solution {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int max = 0;
        while(l<r){
            if(max<Math.min(height[l], height[r])*(r-l)){
                max=Math.min(height[l], height[r])*(r-l);
            }
            if(height[l]>height[r]){
                r--;
            }else{
                l++;
            }
        }
        return max;
    }
}