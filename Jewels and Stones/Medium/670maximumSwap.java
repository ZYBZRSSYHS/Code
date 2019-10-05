import java.util.Arrays;

class Solution {
    public int maximumSwap(int num) {
        int arr[] = new int[100];
        int brr[] = new int[100];
        int i=0;
        int j=0;
        int ans=0;
        while(num>0){
            int tmp = num/10;
            num/=10;
            arr[i]=tmp;
            brr[i++]=tmp;
        }
        Arrays.sort(arr);
        for(int k=i-1;k>=0;k--){
            if(arr[k]!=brr[k]){
                for(int o=0;o<i;o++){
                    if(brr[o]==arr[k]){
                        int temp = brr[0];
                        brr[o]=brr[k];
                        brr[k]=temp;
                    }
                    break;
                }
                int tmp=1;
                for(int op=i-1;op>=0;op--){
                    ans = ans*tmp+brr[op];
                    tmp*=10;
                }
                return ans;
            }
        }
        return num;
    }
}