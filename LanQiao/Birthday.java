/**
 *
 * 今年的植树节（2012年3月12日），小明和他的叔叔还有小伙伴们一起去植树。
 * 休息的时候，小明的同学问他叔叔多大年纪，他叔叔说：“我说个题目，看你们谁先猜出来！”
 * “把我出生的年月日连起来拼成一个8位数（月、日不足两位前补0）正好可以被今天的年、月、日整除！”
 * 他想了想，又补充到：“再给个提示，我是6月出生的。”
 * 根据这些信息，请你帮小明算一下，他叔叔的出生年月日。
 * 答案写在“解答.txt”中，不要写在这里！
 * 格式是年月日连成的8位数。
 * 例如，如果是1948年6月12日，就写：19480612
 */
public class Birthday {
    public static void main(String[] args){
        for(int i=20120312;;i--){
            String s = ""+i;
            int year = Integer.parseInt(s.substring(0,4));
            int month=Integer.parseInt(s.substring(4,6));
            int day = Integer.parseInt(s.substring(6,8));

            if(day==0||day>31){
                continue;
            }
            if(!(i%2012==0&&i%3==0&&i%12==0)){
                continue;
            }
            if(month!=6){
                continue;
            }
            System.out.println(i);
            break;
        }
    }
}