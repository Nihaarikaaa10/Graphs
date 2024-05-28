class Pair{
    int i,j;
    Pair(int i,int j){
        this.i = i;
        this.j = j;
    }
    
}
class PairwTime{
    Pair p;
    int t;
    PairwTime(Pair p,int t){
        this.p = p;
        this.t = t;
    }
}
class Solution {
    public int orangesRotting(int[][] edges) {
        int m = edges.length;
        int n = edges[0].length;
        int cntFresh = 0;
        int[][]  vis = new int[m][n];
        Queue<PairwTime> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(edges[i][j]==2){
                    Pair p = new Pair(i,j);
                    q.add(new PairwTime(p,0));
                    vis[i][j] = 2;
                    // cntFresh++;
                }
                else{
                    vis[i][j] =0;
                }
                if(edges[i][j]==1){
                    cntFresh++;
                }
            }
        }
        int time =0;
        int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            PairwTime pt = q.poll();
            Pair p = pt.p;
            int t = pt.t;
            time = Math.max(time,t);
            for(int[] d: dir){
                int nx = p.i + d[0];
                int ny = p.j + d[1];
                if(nx>=0 && nx<m && ny>=0 && ny<n && edges[nx][ny]==1 && vis[nx][ny]==0){
                    vis[nx][ny] = 2;
                    q.add(new PairwTime(new Pair(nx,ny),t+1));
                    cntFresh--;
                }
            }
        }
        return cntFresh==0?time:-1;
        
        
    }
}