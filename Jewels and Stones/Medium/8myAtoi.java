class Solution{
    public int myAtoi(String str){
        String strr = str.trim();
        String strrr = null;

        if(strr !=null && strr.isEmpty()== false){
            char f = strr.charAt(0);
            if(f>='0' && f<='9'||f=='+'||f=='-'){
                strrr = strr.substring(0,1);
                for(int i=1;i<strr.length();i++){
                    if(strr.charAt(i)>='0' && strr.charAt(i)<='9'){
                        strrr = strr.substring(0,i+1);
                    }else{break;}
                }
            }
        }
        if(strrr == null || strrr.equals("+")||strrr.equals("-"))
        return 0;
        int num = 0;
        try{
            num = Integer.parseInt(strrr);
        }catch(Exception e){
            if(strrr.charAt(0)=='-')
            return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
        return num;
    }
}