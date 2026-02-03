import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals_56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // sort by first element
            } else {
                return Integer.compare(a[1], b[1]); // if first is same, sort by second
            }
        });

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++){
            if(result.isEmpty() || intervals[i][0] > result.getLast().get(1))
                result.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            else
                result.getLast().set(1, Math.max(result.getLast().get(1), intervals[i][1]));
        }

        int[][] resultArray = result.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);


        return resultArray;
    }

    public static void main(String[] args) {

    }
}
