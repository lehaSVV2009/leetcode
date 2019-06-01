class Solution {

    // 2, [[1, 0]]
    // 0 <-- 1 

    // 2 [[1, 0], [0, 1]]
    // 0 <-> 1

    // 3 [[0, 1], [1, 2]]
    // 0 -> 1 -> 2

    // 3 [[0, 1], [1, 2], [1, 0]]
    // 0 -> 1 -> 2 -> 0

    // Is it possible to not have any prerequisites?
    // The graph is represented in edge pairs, right?
    // It is not possible to have prerequisite like [1, 1], correct?
    
    // Memory?
    // Algorithm complexity?

    // format to vertexes with edges
    // go through every vertex
    // go to all the neighbours and through all the neighbours
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length <= 1) {
            return true;
        }

        Map<Integer, List<Integer>> vertexesEdgesMap = toVertexesEdgesMap(prerequisites);

        List<Integer> checked = new ArrayList<>();
        
        for (Map.Entry<Integer, List<Integer>> vertexEdgesEntry : vertexesEdgesMap.entrySet()) {
            Integer vertex = vertexEdgesEntry.getKey();
            
            if (checked.contains(vertex)) {
                continue;
            }

            List<Integer> visited = new ArrayList<>();
            visited.add(vertex);

            if (hasClosure(visited, vertexEdgesEntry.getValue(), vertexesEdgesMap, checked)) {
                return false;
            }
        }
        
        return true;
    }

    public boolean hasClosure(List<Integer> visited, List<Integer> children, Map<Integer, List<Integer>> vertexesEdgesMap, List<Integer> checked) {
        if (children == null) {
            return false;
        }

        for (Integer child: children) {
            if (checked.contains(child)) {
                continue;
            }
            if (visited.contains(child)) {
                return true;
            }
            visited.add(child);
            if (hasClosure(visited, vertexesEdgesMap.get(child), vertexesEdgesMap, checked)) {
                return true;
            }
            visited.remove(child);
            checked.add(child);
        }

        return false;
    }
    
    public Map<Integer, List<Integer>> toVertexesEdgesMap(int[][] prerequisites) {
        Map<Integer, List<Integer>> result = new HashMap<>();

        for (int i = 0; i < prerequisites.length; ++i) {
            int[] edge = prerequisites[i];

            List<Integer> neighbours = new ArrayList<>();
            neighbours.add(edge[1]);

            result.merge(edge[0], neighbours, (oldValue, newValue) -> {
                oldValue.addAll(newValue);
                return oldValue;
            });            
        }

        return result;
    }

}