/**
 *
在实际的开发工作中，对字符串的处理是最常见的编程任务。
本题目即是要求程序对用户输入的串进行处理。具体规则如下：

把每个单词的首字母变为大写。
把数字与字母之间用下划线字符（_）分开，使得更清晰
把单词中间有多个空格的调整为1个空格。
例如：
用户输入：
you and me what cpp2005program
则程序输出：
You And Me What Cpp_2005_program
用户输入：
this is a 99cat
则程序输出：
This Is A 99_cat

我们假设：用户输入的串中只有小写字母，空格和数字，不含其它的字母或符号。
每个单词间由1个或多个空格分隔。
假设用户输入的串长度不超过200个字符。
 * 
 */

import java.util.Vector;

import com.sun.java_cup.internal.runtime.Scanner;

public class StringProcessing{
    public static void main(String [] args){
        java.util.Scanner sc = new Scanner(System.in);
        String string=sc.nextLine();
        Vector<Character>vector = new Vector<Character>();
        for(int i=0;i<string.length();i++){
            vector.add(string.charAt(i));
        }
        try{
            int index = 0;
            while(index<vector.size()){
                if(index==0&&vector.elementAt(index)>='a'&&vector.elementAt(index)<='z'){
                    vector.set(index, (char)(vector.elementAt(index)-('a'-'A')));
                }else if(vector.elementAt(index-1)==' ' && vector.elementAt(index)==' '){
                    vector.remove(index);
                    index--;
                }else if(vector.elementAt(index-1)==' ' && (vector.elementAt(index)>='a' && vector.elementAt(index)<='z')){
                    vector.set(index, (char)(vector.elementAt(index)-('a'-'A')));
                }else if(vector.elementAt(index+1)>='a' && vector.elementAt(index-1)<='z' && (vector.elementAt(index)>='0' && vector.elementAt(index)<='9')){
                    vector.add(index,'_');
                    index++;
                }
                index++;
            }
            for(int i=0;i<vector.size();i++){
                System.out.print(vector.elementAt(i));
            }
            System.out.println();
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
    }
}