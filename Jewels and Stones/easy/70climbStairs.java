    public int climbStairs(int n){
        double sqrt=Math.sqrt(5);
        double fibn=Math.pow((1+sqrt)/2,n+1)-Math.pow((1-sqrt)/2,n+1);
        return (int)(fibn/sqrt);
    }
}