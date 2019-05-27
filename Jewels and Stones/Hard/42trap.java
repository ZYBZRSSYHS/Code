class Solution {
    public int trap(int[] height) {
        if(height==null || height.length==0)return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for(int i=0;i<height.length;i++){
            while(!stack.isEmpty()&&height[stack.peek()]<height[i]){
                int tmp = stack.pop();
                if(stack.isEmpty())break;
                res+=(Math.min(height[i],height[stack.peek()])-height[tmp])*(i-stack.peek()-1);
            }
            stack.push(i);
        }
        return res;
    }
}