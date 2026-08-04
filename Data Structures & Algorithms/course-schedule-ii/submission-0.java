class Solution {
    private final Map<Integer, List<Integer>> graph = new HashMap<>();
    private final Set<Integer> visiting = new HashSet<>();
    private final Set<Integer> visited = new HashSet<>();
    private final List<Integer> order = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int course = 0; course < numCourses; course++) {
            graph.put(course, new ArrayList<>());
        }

        for (int[] req : prerequisites) {
            int course = req[0];
            int prerequisite = req[1];

            graph.get(course).add(prerequisite);
        }

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course)) {
                return new int[0];
            }
        }

        return order.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private boolean dfs(int course) {
        if (visiting.contains(course)) {
            return false;
        }

        if (visited.contains(course)) {
            return true;
        }

        visiting.add(course);

        for (int prerequisite : graph.get(course)) {
            if (!dfs(prerequisite)) {
                return false;
            }
        }

        visiting.remove(course);
        visited.add(course);

        order.add(course);

        return true;
    }
}