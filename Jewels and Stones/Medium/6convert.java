class Solution{
   public String convert(String s, int numRows) {
        if(s==null||s.length()<=1)
        return s;
        int mod = numRows>2?numRows*2-2:numRows;
        StringBuilder[] builders = new StringBuilder[numRows];
        for(int i=0;i<s.length();i++){
            int index = i%mod;
            if(index>=numRows){
                index = 2*numRows-index-2;
            }
            if(builders[index]==null)
            builders[index]=new StringBuilder();
            builders[index].append(s.charAt(i));
        }
        StringBuilder res = new StringBuilder();
        for(int i=0;i<numRows;i++){
            if(builders[i]!=null){
                res.append(builders[i]);
            }
        }
        return res.toString();
    }
}