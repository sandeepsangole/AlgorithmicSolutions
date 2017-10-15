
import java.util.*;

public class MeetingRoom {

	public static void main(String args[]) {
		MeetingRoom room       = new MeetingRoom();
		Interval    intervals4 = new Interval(2, 4);
		Interval    intervals1 = new Interval(1, 3);
		Interval    intervals3 = new Interval(5, 7);
		Interval    intervals2 = new Interval(4, 6);




		Interval[] in = new Interval[] { intervals1, intervals2, intervals3 ,intervals4};

		System.out.println(room.findCountOfMeetingRooms(in));

	}

	public int findCountOfMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}

		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}

		});

		PriorityQueue<Integer> queue = new PriorityQueue();
		queue.offer(intervals[ 0 ].end);
		int count = 1;
		for (int i = 1; i < intervals.length; i++) {
			int current = intervals[ i ].start;
			System.out.println("Current : "+current +" queue.peeek() : "+queue.peek());
			if (current < queue.peek()) {
				System.out.println("Current Counted : "+current +" queue.peeek() : "+queue.peek());
				count++;
			} else {
				queue.poll();
			}

			queue.offer(intervals[ i ].end);
		}

		return count;
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