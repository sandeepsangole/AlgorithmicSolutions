/*
Given a set of non-overlapping & sorted intervals, insert a new interval into the intervals (merge if necessary).

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */

package Arrays.Wed.meetup.may10;

import java.util.*;

public class InsertInterval {

	public static void main(String arg[]) {
		// [1,2],[3,5],[6,7],[8,10],[12,16]
		Interval       in1 = new Interval(1, 2);
		Interval       in2 = new Interval(3, 5);
		Interval       in3 = new Interval(6, 7);
		Interval       in4 = new Interval(8, 10);
		Interval       in5 = new Interval(12, 16);

		List<Interval> lst = new ArrayList<Interval>();
		lst.add(in1);
		lst.add(in2);

		lst.add(in3);
		lst.add(in4);
		lst.add(in5);


		InsertInterval obj = new InsertInterval();
		List<Interval> res = obj.insertInterval(lst, new Interval(4, 9));
		res.stream().forEach(interval->{
			System.out.println(interval.start+" "+interval.end);
		});

	}

	public List<Interval> insertInterval(List<Interval> intervalLst, Interval newInterval) {

		List<Interval> result = new ArrayList<Interval>();

		for (Interval in : intervalLst) {

			//new interval start after current end - add current
			if(newInterval.start > in.end){
				result.add(in);
			}
			//new inerval starts before current - add enew interval and add current as new interval
			else if(newInterval.end < in.start){
				result.add(newInterval);
				newInterval = in;
			}
			//Overlapping interval
			else if(in.start <= newInterval.end || in.end >= newInterval.start){
					newInterval = new Interval(Math.min(in.start,newInterval.start),
							Math.max(in.end,newInterval.end));

			}

		}
		result.add(newInterval);
		return result;

	}
}

class Interval {
	int start;
	int end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

