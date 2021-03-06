class Solution {
    public int strStr(String haystack, String needle) {
        char[] hayArr = haystack.toCharArray();
        char[] needArr=needle.toCharArray();
        int i=0;
        int j=0;
        while(i<hayArr.length && j<needArr.length){
            if(hayArr[i] == needArr[j]){
                i++;
                j++;
            }else{
                i=i-j+1;
                j=0;
            }
        }
        if(j == needArr.length){
            return i-j;
        }else{
            return -1;
        }
    }
}