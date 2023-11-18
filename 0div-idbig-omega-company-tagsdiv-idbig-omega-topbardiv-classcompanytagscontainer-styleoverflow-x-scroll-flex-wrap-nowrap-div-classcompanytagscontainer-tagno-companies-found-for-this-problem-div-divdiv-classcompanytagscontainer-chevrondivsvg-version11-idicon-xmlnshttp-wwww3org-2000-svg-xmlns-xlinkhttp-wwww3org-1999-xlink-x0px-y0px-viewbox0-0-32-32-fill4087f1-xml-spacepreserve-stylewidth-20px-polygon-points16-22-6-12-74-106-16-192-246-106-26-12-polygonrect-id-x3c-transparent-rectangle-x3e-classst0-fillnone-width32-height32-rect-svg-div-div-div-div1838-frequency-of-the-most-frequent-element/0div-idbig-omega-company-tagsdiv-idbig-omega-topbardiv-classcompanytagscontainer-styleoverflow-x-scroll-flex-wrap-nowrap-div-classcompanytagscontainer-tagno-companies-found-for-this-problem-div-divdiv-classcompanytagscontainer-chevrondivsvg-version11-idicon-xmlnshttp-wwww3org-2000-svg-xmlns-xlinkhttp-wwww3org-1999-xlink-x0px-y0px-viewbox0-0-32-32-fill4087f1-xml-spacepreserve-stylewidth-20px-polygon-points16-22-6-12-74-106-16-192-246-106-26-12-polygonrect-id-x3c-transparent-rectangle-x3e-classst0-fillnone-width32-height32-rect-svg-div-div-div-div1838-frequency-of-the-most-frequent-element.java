class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        int left = 0;
        int n = nums.length; 
        int curSum = 0;
        
        for(int right = 0; right < n; right++){
            int target = nums[right];
            curSum += nums[right];
            
            if((right - left + 1) * target - curSum > k){
                curSum -= nums[left];
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}