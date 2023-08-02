package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {
   public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] pre : prerequisites) {
            int c = pre[0];
            int p = pre[1];
            adjList.putIfAbsent(c, new ArrayList<>());
            adjList.get(c).add(p);
        }
        Set<Integer> visited = new HashSet<>();
        for(Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            if (!dfs(entry.getKey(), adjList, visited)) {
                return false;
            }
        }
        return true;
   }

   boolean dfs(int course, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
		List<Integer> pres = adjList.get(course);
		if (pres == null || pres.isEmpty()) return true;
		if (visited.contains(course)) return false;
		visited.add(course);
		for(int pre : pres) {
			if (!dfs(pre, adjList, visited)) return false;
		}
		adjList.put(course, new ArrayList<>());
		visited.remove(course);
		return true;
   }
}
