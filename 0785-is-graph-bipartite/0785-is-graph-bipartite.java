class Solution {
    public boolean dfs(int src,int col,int[] vis,int[][] graph){
        if(col==0){
            vis[src] = 1;
        }
        else{
            vis[src] = 0;
        }
        for(int el: graph[src]){
            int newCol = (col==0)?1:0;
            if(vis[src]==vis[el]) return false;
            if(vis[el]==-1){    
                if(!dfs(el,newCol,vis,graph)) return false;
            } 
        }
        return true;
        
    }
    public boolean isBipartite(int[][] graph) {
        int[] vis = new int[graph.length];
        Arrays.fill(vis,-1);
        for(int i=0;i<graph.length;i++){
            for(int el: graph[i]){
                if(vis[el]==-1){
                    if(!dfs(el,0,vis,graph)){
                        return false;
                    }
                }
            }
        }
        return true;
        
    }
}