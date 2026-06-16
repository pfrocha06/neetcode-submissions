class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int maxProfit = 0;

        for (int right = 1; right < prices.length; right ++){
            int profit = prices[right] - prices[left];

            if (profit > maxProfit){
                maxProfit = profit;
            }if (prices[right] < prices[left]){
                left = right;
            }
        }

        return maxProfit;
    }
}
