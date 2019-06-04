class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits!=null && digits.length()>0)
        que(ans,"",digits);
        return ans;
    }
    private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private void que(List<String> ans,String cur,String digits){
        if(cur.length()==digits.length()){
            ans.add(cur);
            return;
        }
        int index = digits.charAt(cur.length())-'0';
        for(int i=0;i<map[index].length();i++){
            que(ans,cur+map[index].charAt(i),digits);
        }
    } 
}