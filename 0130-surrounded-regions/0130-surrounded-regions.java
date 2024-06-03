class Solution {
    public void dfs(int i,int j,char[][] board,int m,int n){
        board[i][j] = '*';
        int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
        for(int[] d: dir){
            int nx = i +d[0];
            int ny = j+ d[1];
            if(nx>=0 && nx<m && ny>0 && ny<n && board[nx][ny]=='O') {
                dfs(nx,ny,board,m,n);
            }
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            if(board[i][0]=='O') dfs(i,0,board,m,n);
            if(board[i][n-1]=='O') dfs(i,n-1,board,m,n);
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O') dfs(0,j,board,m,n);
            if(board[m-1][j]=='O') dfs(m-1,j,board,m,n);
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O') board[i][j] = 'X';
                else if(board[i][j]=='*') board[i][j] = 'O';
            }
        }
        
    }
}