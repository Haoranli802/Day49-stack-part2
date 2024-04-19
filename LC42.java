class Solution {
    public int trap(int[] height) {
        int res = 0;
        int maxLeft = height[0];
        int maxRight = height[height.length - 1];
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            if(maxLeft > maxRight){
                res += maxRight - height[right];
                right --;
            }
            else{
                res += maxLeft - height[left];
                left++;
            }
        }
        return res;
    }
}


class Solution {
    public int trap(int[] height) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < height.length; i++){
            if(stack.isEmpty() || height[i] < height[stack.peek()]){
                stack.push(i);
            }
            else if(height[i] == height[stack.peek()]){
                stack.pop();
                stack.push(i);
            }
            else{
                while(height[i] > height[stack.peek()]){
                    int mid = stack.pop();
                    if(stack.isEmpty()) break;
                    int h = height[stack.peek()];
                    h = Math.min(h, height[i]);
                    int w = i - stack.peek() - 1;
                    int curRes = (h - height[mid]) * w;
                    res += curRes;
                }
                stack.push(i);
            }
        }
        return res;
    }
}
