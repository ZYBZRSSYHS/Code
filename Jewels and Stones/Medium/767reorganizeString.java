class Solution{
    public String reorganizeString(String S){
        int length = S.length();
        if(length==1){
            return S;
        }
        int[] arr = new int[26];
        int max_length = 0;
        for(char c:S.toCharArray()){
            if(max_length<++arr[c-'a']){
                max_length=arr[c-'a'];
            }
        }
        if(max_length>(length+1)/2){
            return "";
        }

        char[] ret = new char[S.length()];
        int even = 0,odd=1;

        for(int i=0;i<26;i++){
            while(arr[i]>0&&arr[i]<(length/2+1)&&odd<length){
                ret[odd]=(char)(i+'a');
                arr[i]--;
                odd += 2;
            }
            while(arr[i]>0){
                ret[even] = (char)(i+'a');
                arr[i]--;
                even += 2;
            }
        }
        
        return new String(ret);
    }
}