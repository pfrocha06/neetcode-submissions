class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];

            for (char ch : s.toCharArray()) {
                count[ch - 'a']++;
            }

            String key = Arrays.toString(count);

            if (!m.containsKey(key)) {
                m.put(key, new ArrayList<>());
            }

            m.get(key).add(s);
        }

        return new ArrayList<>(m.values());
    }
}