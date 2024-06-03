class Solution {
    void dfs(int i,int j,int[][] board,int m,int n){
        board[i][j] = 5;
        int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
        for(int[] d: dir){
            int nx = i + d[0];
            int ny = j + d[1];
            if(nx>=0 && nx<m && ny>=0 && ny<n && board[nx][ny]==1){
                dfs(nx,ny,board,m,n);
            }
        }
    }
    public int numEnclaves(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        for(int i=0;i<m;i++){
            if(board[i][0]==1) dfs(i,0,board,m,n);
            if(board[i][n-1]==1) dfs(i,n-1,board,m,n);
            
        }
        for(int j=0;j<n;j++){
            if(board[0][j]==1) dfs(0,j,board,m,n);
            if(board[m-1][j]==1) dfs(m-1,j,board,m,n);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1) count++;
            }
        }
        return count;
    }
}