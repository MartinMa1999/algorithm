package Advanced;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    // Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
    // determine if a person could attend all meetings.

    // 按照start时间排序，然后依次遍历

    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return true;
        }

        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        for(int i = 0; i < intervals.length - 1; i++){
            int[] array = intervals[i];
            int[] next = intervals[i + 1];
            if(next[0] < array[1]){
                return false;
            }
        }
        return true;
    }
}
