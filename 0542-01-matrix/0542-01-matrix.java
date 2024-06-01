class Pair{
    int i;
    int j;
    Pair(int i,int j){
        this.i = i;
        this.j = j;
    }
}
class PairwInt{
    Pair p;
    int step;
    PairwInt(Pair p,int step){
        this.p = p;
        this.step = step;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] dist = new int[m][n];
        Queue<PairwInt> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    Pair p = new Pair(i,j);
                    vis[i][j] = true;
                    q.add(new PairwInt(p,0));
                }
                else{
                    vis[i][j] = false;
                }
            }
        }
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            PairwInt pair = q.poll();
            int i = pair.p.i;
            int j = pair.p.j;
            int step = pair.step;
            dist[i][j] = step;
            for(int[] d: dir){
                int nx = i + d[0];
                int ny = j + d[1];
                if(nx>=0 && nx<m && ny>=0 && ny<n && !vis[nx][ny]){
                    vis[nx][ny] = true;
                    Pair p1 = new Pair(nx,ny);
                    q.add(new PairwInt(p1,step+1));
                }
            }
        }
        return dist;
        
    }
}