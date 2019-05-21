class Solution {
    public int longestValidParentheses(String s) {
        int maxMatcher=0;
        int currentMatcher = 0;
        int newMatcher=0;

        char[] chars = s.toCharArray();
        while(true){
            endSuccess = true;
            newMatcher = search(chars);
            if(searchIndex >=chars.length){
                if(endSuccess){
                    currentMatcher +=newMatcher;
                    maxMatcher = Math.max(currentMatcher, maxMatcher);
                }else{
                    maxMatcher = Math.max(currentMatcher,maxMatcher);
                    maxMatcher = Math.max(newMatcher, maxMatcher);
                }
                return maxMatcher;
            }else{
                if(newMatcher==0){
                    maxMatcher = Math.max(currentMatcher, maxMatcher);
                    currentMatcher=0;
                }else{
                    currentMatcher+=newMatcher;
                }
            }
        }
    }
    private int searchIndex = 0;
    private boolean endSuccess=true;
    public int search(char[] chars){
        int currentMatcher=0;
        if(searchIndex >=chars.length){
            endSuccess = false;
            return currentMatcher;
        }
        if('('==chars[searchIndex]){
            searchIndex++;
            while(true){
                if(searchIndex==chars.length){
                    endSuccess = false;
                    return currentMatcher;
                }
                if(')'==chars[searchIndex]){
               searchIndex++;
                return currentMatcher+2;
                }else{
                int search = search(chars);
                if(endSuccess){
                currentMatcher+=search;
                }else{
                return Math.max(search, currentMatcher);
                }
                }
            }
        }else{
            endSuccess = false;
            searchIndex++;
            return currentMatcher;
        }
        
    }

}