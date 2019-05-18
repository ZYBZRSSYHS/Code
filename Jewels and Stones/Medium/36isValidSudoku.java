import java.util.HashMap;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<String,Boolean> map = new HashMap<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                char num = board[i][j];
                if(num =='.'){
                    continue;
                }
                String rowKey = i+"row"+num;
                String colKey = j+"col"+num;
                int groupIndex = i/3+j/3*3;
                String groupKey = groupIndex + "group" +num;
                if(map.getOrDefault(rowKey, false)||map.getOrDefault(colKey, false)||map.getOrDefault(groupKey, false)){
                    return false;
                }
                map.put(rowKey, true);
                map.put(colKey, true);
                map.put(groupKey, true);
            }
        }
        return true;
    }
}