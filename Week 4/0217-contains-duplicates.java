class Solution {
    public boolean containsDuplicate(int[] nums) {

        // Most Optimal Approach
        HashMap<Integer, Integer> occur = new HashMap<>();

        for(int num : nums){
            if(occur.containsKey(num)){
                return true;
            } else {
                occur.put(num, 1);
            }
        }

        return false;
    }
}
