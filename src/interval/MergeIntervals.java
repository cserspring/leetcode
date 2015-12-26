package interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
} 

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
    	int n = 0;
    	if (intervals == null || (n = intervals.size()) < 2) return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
        	public int compare(Interval a, Interval b) {
            	return a.start == b.start ? (a.end - b.end) : (a.start - b.start);
            }
        });
        
        int cur = 0;
        for (int i = 1; i < n; ++i) {
        	if (overlapped(intervals.get(cur), intervals.get(i))) {
        		Interval newInterval = new Interval(intervals.get(cur).start, 
        				intervals.get(i).end > intervals.get(cur).end ? intervals.get(i).end : intervals.get(cur).end);
        		intervals.set(cur, newInterval);
        	} else {
        		intervals.set(++cur, intervals.get(i));
        	}
        }
        
        return intervals.subList(0, cur + 1);
    }
    
    private boolean overlapped(Interval a, Interval b) {
    	return a.start <= b.start ? a.end >= b.start : overlapped(b, a);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,4));
		intervals.add(new Interval(0,2));
		intervals.add(new Interval(3,5));
		//intervals.add(new Interval(15,18));
		MergeIntervals m = new MergeIntervals();
		List<Interval> res = m.merge(intervals);
		for (Interval i : res) {
			System.out.println("[" + i.start + ", " + i.end + "]");
		}
	}

}
