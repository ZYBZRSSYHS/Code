class Solution {
    public int hIndex(int[] citations) {

       int[] arr=new int[citations.length+1];

       for(int i:citations){
           arr[Math.min(citations.length,i)]++;
       }
       int num=citations.length;
        for(int over = arr[num];
            num>over;over+=arr[num]){
            num--;
        }
        return num;
    }
}