class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] excludeLast = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] excludeFirst = Arrays.copyOfRange(nums, 1, nums.length);

        return Math.max(dp(excludeLast), dp(excludeFirst));
    }

    public int dp(int[] nums) {
        int house1 = 0;
        int house2 = 0;

        for(int n : nums) {
            int temp = Math.max(n + house1, house2);
            house1 = house2;
            house2 = temp;
        }

        return house2;
    }
}
