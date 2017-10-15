package Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom {

	public static void main(String args[]) {
		MeetingRoom room      = new MeetingRoom();
		Interval[]  intervals = new Interval[ 3];


		Interval intervals1 = new Interval(8, 10);
		Interval intervals2 = new Interval(12, 14);
		Interval intervals3 = new Interval(9, 11);


		intervals[ 0 ] = intervals1;
		intervals[ 1 ] = intervals2;
		intervals[ 2 ] = intervals3;

		System.out.println("Result :" + room.countOfMeetingRoomsRequired(intervals));
	}

	public int countOfMeetingRoomsRequired(Interval[] intervals) {


		java.util.Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.startTime - i2.startTime;
			}
		});


		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		int                    count = 1;

		queue.offer(intervals[ 0 ].endTime);
		for (int i = 1; i < intervals.length; i++) {
			System.out.println(intervals[ i ].startTime);
			System.out.println(queue.peek());

			if (intervals[ i ].startTime < queue.peek()) {
				count++;
			} else {
				queue.poll();
			}

			queue.offer(intervals[ i ].endTime);
		}


		return count;
	}
}

class Interval {

	int startTime;
	int endTime;

	Interval(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
}
