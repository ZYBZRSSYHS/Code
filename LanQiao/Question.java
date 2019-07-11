import java.util.Vector;

import com.sun.java_cup.internal.runtime.Scanner;

/**
 * ，如果给定N个不同字符，将这N个字符全排列，
 * 最终的结果将会是N!种。如：给定 A、B、C
 * 三个不同的字符，
 * 则结果为：ABC、ACB、BAC、BCA、CAB、CBA
 * 一共3!=3*2=6种情况。
 */
public class Question{
    public static long count=0;
    private void fullPermutation(Vector<Character>sourse,Vector<Character> result){
        if(sourse.size()==0){
            for(int i=0;i<result.size();i++){
                System.out.print(result.elementAt(i));
            }
            System.out.print("\n");
            count++;
            return;
        }
        for(int i=0;i<sourse.size();i++){
            Vector<Character>tsourse = new Vector<Character>(sourse);
            Vector<Character>tresult = new Vector<Character>(result);
            tresult.add(sourse.elementAt(i);
            tsourse.remove(i);
            new Question().fullPermutation(tsourse, tresult);
        }
    }
    public static void main(String[] args){
        java.util.Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Vector<Character> sourse = new Vector<Character>();
        Vector<Character> result = new Vector<Character>();
        for(int i=0;i<n;i++){
            sourse.add((char)('A'+i));
        }
        new Question().fullPermutation(sourse, result);
        System.out.println(Question.count);
    }
}