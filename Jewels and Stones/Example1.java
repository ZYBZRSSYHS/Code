public int[] twoSun(int[] nums,int target){
    Map<Integer,Integer> map = new HashMap<>();
    for(int i=0;i<nums.length;i++){
        map.put(nums[i],i);
    }
    for(int i=0;i<nums.length;i++){
        int oomplement = target-nums[i];
        if(map.containsKey(complement)&&map.get(complement)!=i){
            return new int[]{
                i,map.get(complement)
            }
        }throw new IllegalArgumentException("No two sum solution");
    }
}