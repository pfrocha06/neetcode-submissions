class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sm = new HashMap<>();
        Map<Character, Integer> tm = new HashMap<>();

        for (char c : s.toCharArray()) {
            sm.put(c, sm.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            tm.put(c, tm.getOrDefault(c, 0) + 1);
        }

        return sm.equals(tm);

    }
}
