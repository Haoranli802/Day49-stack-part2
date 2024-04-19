class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < len * 2; i++){
            while(!stack.isEmpty() && nums[i % len] > nums[stack.peek()]){
                int index = stack.pop();
                res[index] = nums[i % len];
            }
            stack.push(i % len);
        }
        return res;
    }
}
//O(N), O(N)
