class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(String string : strs){
            char[] c = string.toCharArray();
            Arrays.sort(c);
            String sorted = String.valueOf(c);

            if(map.containsKey(sorted)){
                map.get(sorted).add(string);
            } else {
                map.computeIfAbsent(sorted, key -> new ArrayList<>()).add(string);
            }
        }

        for(List<String> list : map.values()){
            result.add(list);
        }

        return result;
    }
}
