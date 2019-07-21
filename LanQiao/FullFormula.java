import java.util.Vector;

/**
 *
 * 看这个算式：
 * ☆☆☆ + ☆☆☆ = ☆☆☆
 * 如果每个五角星代表 1 ~ 9 的不同的数字。
 * 这个算式有多少种可能的正确填写方法？
 * 173 + 286 = 459
 * 295 + 173 = 468
 * 173 + 295 = 468
 * 183 + 492 = 675
 * 以上都是正确的填写法！
 * 注意：
 * 111 + 222 = 333 是错误的填写法！
 * 因为每个数字必须是不同的！
 * 也就是说：1~9中的所有数字，每个必须出现且仅出现一次！
 * 注意：
 * 不包括数字“0”！
 * 注意：
 * 满足加法交换率的式子算两种不同的答案。
 * 所以答案肯定是个偶数！
 *
 * 注意：
 * 只要求计算不同的填法的数目
 * 不要求列出所有填写法
 * 更不要求填写源代码！
 *
 */
public class FullFormula {
    public static int count;

    public static void main(String[] args){
        Vector<Character> sourse = new Vector<Character>();
        Vector<Character> result = new Vector<Character>();
        for(int i=1;i<=9;i++){
            sourse.add((char)('0'+i));
        }
        AllType(sourse,result);
        System.out.println(count);
    }

    public static void AllType(Vector<Character> sourse,Vector<Character>result){
        if(sourse.size()==0){
            int a=(result.elementAt(0)-'0')*100+(result.elementAt(1)-'0')*10+result.elementAt(2)-'0';
            int b=(result.elementAt(3)-'0')*100+(result.elementAt(4)-'0')*10+result.elementAt(5)-'0';
            int c=(result.elementAt(6)-'0')*100+(result.elementAt(7)-'0')*10+result.elementAt(8)-'0';
            if(a+b==c){
                System.out.printf("%d + %d = %d \n",a,b,c);
                count++;
            }
        }else {
            for(int i=0;i<sourse.size();i++){
                result.add(sourse.elementAt(i));
                sourse.remove(i);
                AllType(sourse,result);
                sourse.add(i,result.elementAt(result.size()-1));
                result.remove(result.size()-1);
            }
        }
    }
}
