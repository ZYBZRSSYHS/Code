/*
以下的静态方法实现了：把串s中第一个出现的数字的值返回。
如果找不到数字，返回-1
例如：
s = "abc24us43"  则返回2
s = "82445adb5"  则返回8
s = "ab"   则返回-1
请分析代码逻辑，并推测划线处的代码。
答案写在 “解答.txt” 文件中
注意：只写划线处应该填的内容，划线前后的内容不要抄写。
*/
public class FirstNum {
    public static int getFirstNum(String s){
        if(s==null||s.length()==0){
            return -1;
        }
        char c =  s.charAt(0);
        if(c>='0' && c<='9'){
            return s.charAt(0)-'0';
        }
        return getFirstNum(s.substring(1));
    }
    public static void main(String[] args){
        String s1="abc24ui";
        String s2 = "8244qw";
        String s3 = "ab";
        System.out.println(getFirstNum(s1));
        System.out.println(getFirstNum(s2));
        System.out.println(getFirstNum(s3));
    }
}
