import java.math.BigInteger;

/**
 * 大整型计算，二十一位数的水仙花数，以及运算时间
 * 128468643043731391252
 * 449177399146038697307
 * 4.834s
 */

class Daffodil{
    public static int size;
    public static int array[] ={0,1,2,3,4,5,6,7,8,9};
    public static BigInteger powArray[] = new BigInteger[10];
    public static int usedTimes[]  = new int[10];
    public static BigInteger iPowSizeMultiplyj[][];
    public static BigInteger MAX;
    public static BigInteger MIN;

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        Daffodil.size=21;
        Daffodil.init();
        Daffodil.exhaustion(9, 0, BigInteger.valueOf(0));

        long endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime)/1000f+"s");
    }

    public static void init(){
        for(int i=0;i<10;i++){
            powArray[i]=(new BigInteger(""+i).pow(size));
        }
        MIN = (new BigInteger("10")).pow(size-1);
        MAX = (new BigInteger("10").pow(size).add(new BigInteger("-1")));

        iPowSizeMultiplyj=new BigInteger[10][size+1];

        for(int i=0;i<10;i++){
            iPowSizeMultiplyj[i][0]=BigInteger.valueOf(0);
            for(int j=1;j<size+1;j++){
                iPowSizeMultiplyj[i][j]=iPowSizeMultiplyj[i][j-1].add(powArray[i]);
            }
        }
    }
    public static void exhaustion(int arrayIndex,int used,BigInteger current){
        if(current.compareTo(MAX)>1){
            return;
        }
        if(used == size){
            if(current.compareTo(MIN)<0){
                return;
            }else{
                String s = current+"";
                int avaliableValueUsed[] = new int[10];
                for(int i=0;i<s.length();i++){
                    avaliableValueUsed[s.charAt(i)-'0']++;
                }
                for(int i=0;i<10;i++){
                    if(usedTimes[i]!=avaliableValueUsed[i]){
                        return;
                    }
                }
                System.out.println(current);
                return;
            }
        }
        if(arrayIndex==0){
            usedTimes[0]=size-used;
            exhaustion(-1, size, current);
            usedTimes[0]=0;
            return;
        }
        if(current.add(iPowSizeMultiplyj[arrayIndex][size-used]).compareTo(MIN)<0){
            return;
        }
        if(arrayIndex>=0){
            for(int i=0;i<=size-used;i++){
                if(current.add(iPowSizeMultiplyj[arrayIndex][i]).compareTo(MAX)>0){
                    return;
                }
                usedTimes[arrayIndex]=i;
                exhaustion(arrayIndex-1, used+i, current.add(iPowSizeMultiplyj[arrayIndex][i]));
                usedTimes[arrayIndex]=0;
            }
        }else{
            return;
        }
    }

}