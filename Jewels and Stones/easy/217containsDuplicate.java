import java.util.stream.Collectors;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).boxed().
        collect(Collectors.toMap(x->x, x->1,
        Integer::sum)).values().stream().
        anyMatch(x->x>1);
    }
}