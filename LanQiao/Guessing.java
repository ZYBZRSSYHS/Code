import java.util.ArrayList;
import java.util.Vector;

import com.sun.tools.javac.util.List;
import com.sun.xml.internal.stream.Entity.ScannedEntity;

import jdk.nashorn.internal.parser.Scanner;

/**
 * 
看下面的算式：
□□ x □□ = □□ x □□□
它表示：两个两位数相乘等于一个两位数乘以一个三位数。
如果没有限定条件，这样的例子很多。
但目前的限定是：这9个方块，表示1~9的9个数字，不包含0。
该算式中1至9的每个数字出现且只出现一次！
比如：
46 x 79 = 23 x 158
54 x 69 = 27 x 138
54 x 93 = 27 x 186
.....
请编程，输出所有可能的情况！
注意：
左边的两个乘数交换算同一方案，不要重复输出！
不同方案的输出顺序不重要
 */
public class Guessing{
    public static long count = 0;
    public static java.util.List<Vector<Character>> filteredNonRedundantResults;
    private static boolean isfilter(Vector<Character> result){
        int arr = (result.elementAt(0)-'0')*10+(result.elementAt(1)-'0');
        int brr = (result.elementAt(2)-'0')*10+(result.elementAt(3)-'0');
        int crr = (result.elementAt(4)-'0')*10+(result.elementAt(5)-'0');
        int drr = (result.elementAt(6)-'0')*10+(result.elementAt(7)-'0')*10+(result.elementAt(8)-'0');
        if(arr*brr==crr*drr){
            return true;
        }
        return false;
    }

    public static void print(Vector<Character>vector){
        System.out.printf("%c%c x %c%c = %c%c x %c%c%c",vector.elementAt(0),vector.elementAt(1),
        vector.elementAt(2),vector.elementAt(3),vector.elementAt(4),vector.elementAt(5)
        ,vector.elementAt(6),vector.elementAt(7),vector.elementAt(8));
    }

    private static void fullPermutation(Vector<Character> sourse,Vector<Character> result){
        if(sourse.size()==0&&isfilter(result)){
            boolean exit = false;
            for(int i=0;i<filteredNonRedundantResults.size();i++){
                int ar = (result.elementAt(0)-'0')*10+(result.elementAt(1)-'0');
                int br = (result.elementAt(2)-'0')*10+(result.elementAt(3)-'0');
                int cr = (result.elementAt(4)-'0')*10+(result.elementAt(5)-'0');
                int dr = (result.elementAt(6)-'0')*10+(result.elementAt(7)-'0')*10+(result.elementAt(8)-'0');
                if(ar*br==cr*dr){
                    exit = true;
                    break;
                }
            }
            if(exit == false){
                filteredNonRedundantResults.add(new Vector<Character>(result));
            }
            return;
        }
        for(int i=0;i<sourse.size();i++){
            result.add(sourse.elementAt(i));
            sourse.remove(i);
            fullPermutation(sourse, result);
            sourse.add(i,result,elementAt(result.size()-1));
            result.remove(result.size()-1);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=9;
        Vector<Character> sourse = new Vector<Character>();
        Vector<Character> result = new Vector<Character>();
        for(int i=1;i<=n;i++){
            sourse.add((char)('0'+i));
        }
        Guessing.filteredNonRedundantResults = new ArrayList<Vector<Character>>();
        Guessing.fullPermutation(sourse, result);

        for(int i=0;i<Guessing.filteredNonRedundantResults.size();i++){
            Guessing.print(Guessing.filteredNonRedundantResults.get(i));
            System.out.println();
        }
    }
}