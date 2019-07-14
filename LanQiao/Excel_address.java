import java.util.Stack;

import com.sun.java_cup.internal.runtime.Scanner;

/**
 * 
 * 
Excel是最常用的办公软件。每个单元格都有唯一的地址表示。 比如：第12行第4列表示为：“D12”，第5行第255列表示为“IU5”。
事实上，Excel提供了两种地址表示方法，还有一种表示法叫做RC格式地址。
第12行第4列表示为：“R12C4”，第5行第255列表示为“R5C255”。
你的任务是：编写程序，实现从RC地址格式到常规地址格式的转换。
【输入、输出格式要求】
用户先输入一个整数n(n<100)表示接下来有n行输入数据。
接着输入的n行数据是RC格式的Excel单元格地址表示法。
程序则输出n行数据，每行是转换后的常规地址表示法。
例如：用户输入：
2
R12C4
R5C255
则程序应该输出：
D12
IU5
 */
public class Excel_address{

    public static void main(String[] args){
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        while(n>0){
            String string = sc.nextLine();
            String strings[] = stirng.split("C");
            strings[0] = strings[0].substring(1,strings[0].length());
            int Rows = Integer.parseInt(strings[0]);
            int columns = Integer.parseInt(strings[1]);
            
            Stack<Character>stack = new Stack<Character>();
            while(columns>0){
                if(columns%26==0){
                    stack.push('z');
                    columns=columns/26-1;
                }else{
                    stack.push((char)('A'-1+columns%26));
                    columns=columns/26;
                }
            }
            while(!stack.empty()){
                System.out.print(stack.pop());
            }
            System.out.println(columns);
            n--;
        }
    }
}