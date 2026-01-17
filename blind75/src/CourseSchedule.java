import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) q.offer(i);
        }


        List<Integer> topoSort = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            topoSort.add(curr);

            for (int it : adj.get(curr)){
                indegree[it]--;
                if(indegree[it] == 0) q.offer(it);
            }
        }

        if(topoSort.size() == numCourses) return true;

        return false;
    }

    public static void main(String[] args) {

    }
}
