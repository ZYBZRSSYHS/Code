class Solution {
    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        int i=0,j=0;
        while(j<len){
            if(arr[i]==0){
                ++j;
            }
            ++j;
            ++i;
        }
        --i;--j;
        while(i>=0){
            if(j<len){
                arr[j]=arr[i];
            }
           if(arr[i]==0){
               arr[--j]=0;
           }
           --i;
           --j;
        }
    }
}