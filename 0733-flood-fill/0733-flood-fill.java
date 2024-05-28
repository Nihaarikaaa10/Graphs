// class Solution {
//     private void dfs(int sr,int sc,int[][] image,int[][] grid, int col,int m,int n,int org){
//         grid[sr][sc] = col;
//         int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
//         for(int[] d: dir){
//             int nx = sc + d[0];
//             int ny = sr + d[1];
//             if(nx>=0 && nx<m && ny>=0 && ny<n && image[nx][ny]==org && grid[nx][ny]!=col){
//                 dfs(nx,ny,image,grid,col,m,n,org);
//             }
//         }
//     }
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         int m = image.length;
//         int n = image[0].length;
//         int org = image[sc][sr];
//         int[][] grid = new int[m][n];
//         for(int i =0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 grid[i][j] = image[i][j];
//             }
//         }
//         dfs(sc,sr,image,grid,color,m,n,org);
//         return grid;
        
//     }
// }
class Solution {
    private void dfs(int sr, int sc, int[][] image, int color, int org, int m, int n) {
        image[sr][sc] = color;
        int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        for (int[] d : dir) {
            int nx = sr + d[0];
            int ny = sc + d[1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && image[nx][ny] == org) {
                dfs(nx, ny, image, color, org, m, n);
            }
        }
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int org = image[sr][sc];
        if (org != color) {  // To prevent infinite loop if the new color is the same as the original color
            dfs(sr, sc, image, color, org, m, n);
        }
        return image;
    }
}
