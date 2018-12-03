/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        
        if(intervals.length == 0)
            return 0;
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        
        //intervals.length must greater then 0, otherwise new PriorityQueue will fails
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(intervals.length, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return a - b;
            }
        });
        
        queue.add(intervals[0].end);
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start >= queue.peek()){
                queue.poll();
            }
            queue.add(intervals[i].end);
        }
        
        return queue.size();
    }
}
