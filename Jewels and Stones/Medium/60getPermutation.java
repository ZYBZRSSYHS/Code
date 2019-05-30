import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList<>();
        for(int i=1;i<=n;i++)
        num.add(i);
        int[] factorial = new int[n];
        factorial[0] = 1;
        for(int i=1;i<n;i++)
        factorial[i]=i*factorial[i-1];
        n--;
        StringBuilder res = new StringBuilder();
        while(n>=0){
            int t=factorial[n];
            int loc = (int) (Math.ceil((double)k/(double)t))-1;
            if(loc==-1)loc=num.size()-1;
            res.append(num.get(loc));
            num.remove(loc);
            k%=t;
            n--;
        }
        return res.toString();
    }
}