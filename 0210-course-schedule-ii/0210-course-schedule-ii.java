class Solution {
    public int[] findOrder(int v, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<pre.length;i++){
            adj.get(pre[i][1]).add(pre[i][0]);
        }
        int[] inDeg = new int[v];
        for(int i=0;i<v;i++){
            for(int item: adj.get(i)){
                inDeg[item]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(inDeg[i]==0) q.add(i);
        }
        List<Integer> al = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            al.add(node);
            for(int it: adj.get(node)){
                inDeg[it]--;
                if(inDeg[it]==0) q.add(it);
            }
        }
        
        if(al.size()==v){
            int[] topo = new int[v];
            for(int i=0;i<v;i++){
                topo[i] = al.get(i);
            }
            return topo;
        }
        return new int[0];
    }
}