import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/*
下面代码模拟了一套扑克牌（初始排序A~K，共13张）的操作过程。
操作过程是：
手里拿着这套扑克牌，从前面拿一张放在后面，再从前面拿一张放桌子上，再从前面拿一张放在后面，....
如此循环操作，直到剩下最后一张牌也放在桌子上。
下面代码的目的就是为了求出最后桌上的牌的顺序。
初始的排列如果是A,2,3...K，则最后桌上的顺序为：
[2, 4, 6, 8, 10, Q, A, 5, 9, K, 7, 3, J]
请分析代码逻辑，并推测划线处的代码。
答案写在 “解答.txt” 文件中
注意：只写划线处应该填的内容，划线前后的内容不要抄写。
*/
public class MobilePoker {

    public static void main(String[] args){
        List arr = new Vector();
        arr.addAll(Arrays.asList("A","2","3","4","5","6","7","8","9","10","J","Q","K"));
        System.out.println(moveCard(arr));
    }

    public static List moveCard(List src){
        if(src == null){
            return null;
        }
        List dst = new Vector();

        while(true){
            if(src.size()==0){
                break;
            }
            src.add(src.remove(0));
            dst.add(src.remove(0));
        }
        return dst;
    }
}
