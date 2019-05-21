class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,res,0,new ArrayList<Integer>());
        return res;
    }
    private void backtrack(int[] candidates, int target,List<List<Integer>> res,int i,ArrayList<Integer> tmp_list){
        if(target<0)return;
        if(target == 0){
            res.add(new ArrayList<>(tmp_list));
            return;
        }
        for(int start = i;start<candidates.length;start++){
            if(target<0)break;
            tmp_list.add(candidates[start]);
            backtrack(candidates,target-candidates[start],res,start,tmp_list);
            tmp_list.remove(tmp_list.size()-1);
        }
    }
}