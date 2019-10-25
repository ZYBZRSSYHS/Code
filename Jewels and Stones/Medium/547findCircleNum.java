class Solution {

    public void dfs(int[][] M,int[] hel,int i){
        for(int j=0;j<M.length;j++){
            if(M[i][j]==1 && hel[j]==0){
                hel[j]=1;
                dfs(M,hel,j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        int[] hel = new int[M.length];
        int count=0;
        for(int i=0;i<hel.length;i++){
            if(hel[i]==0){
                count++;
                dfs(M,hel,i);
            }
        }
        return count;
    }
}