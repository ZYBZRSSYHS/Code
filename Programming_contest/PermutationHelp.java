import java.util.ArrayList;

public class Solution{
    public ArrayList<String> PermutatinHelp(StringBuilder str){
        ArrayList<String> result = new ArrayList<String>();
        if(str.length()==1){
            result.add(str.toString());
        }else{
            for(int i=0;i<str.length();i++){
                if(i==0||str.charAt(i)!=str.charAt(0)){
                    char temp = str.charAt(i);
                    str.setCharAt(i, str.charAt(0));
                    str.setCharAt(0, temp);
                    ArrayList<String> newResult = PermutatinHelp(new StringBuilder(str.substring(1)));
                        for(int j=0;j<newResult.size();j++){
                            result.add(str.substring(0,1)+newResult.get(j));
                        }
                        temp = str.charAt(0);
                        str.setCharAt(0, str.charAt(i));
                        str.setCharAt(i, temp);
                }
            }
        }
        return result;
    }
    public ArrayList<String> Permutation(String str){
        StringBuilder strBuilder = new StringBuilder(str);
        ArrayList<String> result = PermutatinHelp(strBuilder);
        return result;
    }
}