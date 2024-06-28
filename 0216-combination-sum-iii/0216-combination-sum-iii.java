class Solution {
    static void backtrack(int start,int end,int sum,int k,List<Integer> al,List<List<Integer>> res){
        if(sum<0) return;
        if(al.size()==k && sum==0){
            Collections.sort(al);
            if(!res.contains(al)) res.add(new ArrayList<>(al));
            
            return;
        }
        for(int i=start;i<=end;i++){
            if(!al.contains(i)){
                al.add(i);
                backtrack(i+1,end,sum-i,k,al,res);
                al.remove(al.size()-1);

            }
            
        }
        
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1,9,n,k,new ArrayList<>(),res);
        return res;
        
    }
}