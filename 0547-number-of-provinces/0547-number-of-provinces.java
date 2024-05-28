class Solution {
    private void dfs(int i,List<List<Integer>> al,boolean[] vis){
        vis[i] = true;
        for(int node: al.get(i)){
            if(!vis[node]){
                dfs(node,al,vis);
            }
        }
    }
    public int findCircleNum(int[][] edges) {
        int count = 0;
        List<List<Integer>> al = new ArrayList<>();
        boolean[] vis = new boolean[edges.length];
        for(int i=0;i<edges.length;i++){
            al.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            for(int j=0;j<edges[0].length;j++){
                if(edges[i][j]==1){
                    al.get(i).add(j);
                    al.get(j).add(i);
                }
            }
        }
        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                dfs(i,al,vis);
                count++;
            }
        }

        return count;
    }
}