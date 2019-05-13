import java.util.ArrayList;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        for(int i=0;i<1<<n;i++){
            ret.add(i^i>>1);
        }
        return ret;
    }

}