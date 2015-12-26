package interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	int n = 0;
    	if (intervals == null) return new ArrayList<Interval>();
    	if ((n = intervals.size()) == 0) {
    		intervals.add(newInterval);
    		return intervals;
    	}
    	
    	int cur = 0;
        for (; cur < n; ++cur) {
        	if (intervals.get(cur).start >= newInterval.start) {
        		break;
        	}
        }
        
        intervals.add(cur, newInterval);
        int prev = cur - 1;
        // We added one element, so in for loop, i < n + 1
        for (int i = cur; i < n + 1; ++i) {
        	if (i >= 1 && overlapped(intervals.get(prev), intervals.get(i))) {
        		intervals.set(prev, new Interval(intervals.get(prev).start, 
        				intervals.get(prev).end > intervals.get(i).end ? intervals.get(prev).end : intervals.get(i).end));
        	} else {
        		intervals.set(++prev, intervals.get(i));
        	}
        }    
        
        return intervals.subList(0, prev + 1);
    }
    
    private boolean overlapped(Interval a, Interval b) {
    	return a.start <= b.start ? a.end >= b.start : overlapped(b, a);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,2));
		intervals.add(new Interval(3,5));
		intervals.add(new Interval(6,7));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(12,16));
		
		Interval newInterval = new Interval(4,9);
		InsertInterval insertInterval = new InsertInterval();
		List<Interval> res = insertInterval.insert(intervals, newInterval);
		for (Interval i : res) {
			System.out.println("[" + i.start + ", " + i.end + "]");
		}
	}

}
