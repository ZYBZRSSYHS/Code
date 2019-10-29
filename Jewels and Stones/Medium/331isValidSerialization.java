import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution{
    public boolean isValidSerialization(String preorder){
        Pattern pattern = Pattern.compile("[^,#]+,#,#");
        Matcher matcher = pattern.matcher(preorder);

        while(!"#".equals(preorder) && matcher.find()){
            preorder=matcher.replaceAll("#");
            matcher=pattern.matcher(preorder);
        }
        return "#".equals(preorder);
    }
}