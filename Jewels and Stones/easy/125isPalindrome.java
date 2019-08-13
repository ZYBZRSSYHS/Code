class Solution {
    public boolean isPalindrome(String s) {
        String tmp = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        String rev_tmp = new StringBuffer(tmp).reverse().toString();
        return tmp.equals(rev_tmp);
    }
}