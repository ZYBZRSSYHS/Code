class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(o1,o2)->o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0]);
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] a:people){
            list.add(a[1],a);
        }
        return list.toArray(new int[list.size()][2]);
    }
}