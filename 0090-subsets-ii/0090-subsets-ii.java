class Solution {
    static void backtrack(int start,int[] nums,List<Integer> al,List<List<Integer>> res){
        res.add(new ArrayList<>(al));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            al.add(nums[i]);
            backtrack(i+1,nums,al,res);
            al.remove(al.size()-1);
        }
        

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0,nums,new ArrayList<>(),res);
        return res;
    }
}

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// class Solution {
//     static void backtrack(int start, int[] nums, List<Integer> al, List<List<Integer>> res) {
//         res.add(new ArrayList<>(al)); // Add the current subset to the result list
        
//         for (int i = start; i < nums.length; i++) {
//             // If the current element is the same as the previous one and the previous one was not included in the current subset, skip this element
//             if (i > start && nums[i] == nums[i - 1]) continue;
            
//             al.add(nums[i]); // Include the current element in the subset
//             backtrack(i + 1, nums, al, res); // Recur with the next element
//             al.remove(al.size() - 1); // Backtrack and remove the last element added
//         }
//     }
    
//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//         List<List<Integer>> res = new ArrayList<>();
//         Arrays.sort(nums); // Sort the array to handle duplicates
//         backtrack(0, nums, new ArrayList<>(), res);
//         return res;
//     }
// }
