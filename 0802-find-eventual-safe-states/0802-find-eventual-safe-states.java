class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        int m = graph.length;
        int n = graph[0].length;
        for(int i=0;i<m;i++){
            adj.add(new ArrayList<>());
        }
        
        int[] inDegree = new int[m];
        for(int i=0;i<m;i++){
            for(int it: graph[i]){
                adj.get(it).add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            al.add(node);
            for(int it: adj.get(node)){
                inDegree[it]--;
                
                if(inDegree[it]==0){
                    q.add(it);
                }
            }
        }
        Collections.sort(al);
        return al;
    }
}