class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int mul = 1;

        for (int i = 0; i < nums.length; i++) {
	        res[i] = mul;
	        mul *= nums[i];
        }

        mul = 1;

        for(int i = nums.length - 1; i >= 0; i--) {
            res[i] *= mul;
            mul *= nums[i];
        }

        return res;
    }
}  
