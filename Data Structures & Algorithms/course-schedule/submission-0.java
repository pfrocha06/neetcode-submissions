class Solution {
    HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int course = 0; course < numCourses; course++) {
            adjacencyList.put(course, new ArrayList<>());
        }

        for(int[] req : prerequisites){
            adjacencyList.get(req[0]).add(req[1]);
        }
        
        for(int course = 0; course < numCourses; course++){
            if (!dfs(course)) return false;
        }

        return true;
    }

    public boolean dfs(int course){
        if(set.contains(course)) return false;
        if(adjacencyList.get(course).isEmpty()) return true;

        set.add(course);
        
        for(int req : adjacencyList.get(course)){
            if (!dfs(req)) return false;
        }

        set.remove(course);
        adjacencyList.put(course, new ArrayList<>());
        return true;

    }
}
