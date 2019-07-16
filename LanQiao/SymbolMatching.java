/**
 *
 * 下面的代码用于判断一个串中的括号是否匹配 所谓匹配是指不同类型的括号必须左右呼应，可以相互包含，但不能交叉
 * 例如：
 * ..(..[..]..).. 是允许的
 * ..(...[...)....].... 是禁止的
 * 对于 main 方法中的测试用例，应该输出：
 * false
 * true
 * false
 * false
 * 请分析代码逻辑，并推测划线处的代码。
 *
 */

import java.util.Stack;


public class SymbolMatching {
    public static void main(String[] args){
        System.out.println(isGoodBracker("...(..[.)..].{.(..).}..."));
        //...
    }
    public static boolean isGoodBracker(String s){
        Stack<Character> arr = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                arr.push('(');
            }else if(c == '['){
                arr.push(']');
            }else if(c == '{'){
                arr.push('}');
            }else if(c == ')' || c == ']' || c== '}'){
                if(arr.size()==0){
                    return false;
                }
                if(arr.pop()!=c){//通过打入一样的字符，可以直接进行弹出判断
                    return false;
                }
            }
        }
        if(arr.size()!=0){
            return false;
        }else return true;
    }
}
