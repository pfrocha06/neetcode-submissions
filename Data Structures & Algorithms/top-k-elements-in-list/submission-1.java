class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int n : nums){
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> Integer.compare(freq.get(a), freq.get(b)));
        
        for(int n : freq.keySet()){
            heap.offer(n);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[k];

        for(int i = 0; i < k; i++){
            result[i] = heap.poll();
        }

        return result;
    }
}
