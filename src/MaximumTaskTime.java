
/*

Given different time periods during which tasks were running find the time at which maximum tasks are running.
 */

import java.util.*;


class JobInterval{
	int startTime;
	int endTime;
	JobInterval(int startTime , int endTime){
		this.startTime = startTime;
		this.endTime = endTime;
	}
}
public class MaximumTaskTime {
	public static void main(String args[]){
		MaximumTaskTime room       = new MaximumTaskTime();
		JobInterval    intervals4 = new JobInterval(2, 4);
		JobInterval    intervals1 = new JobInterval(1, 3);
		JobInterval    intervals3 = new JobInterval(5, 7);
		JobInterval    intervals2 = new JobInterval(4, 6);
	}


	public int maxTime(JobInterval[] jobIntervals ){

		int maxTime = 0;
		Arrays.sort(jobIntervals, new Comparator<JobInterval>() {
			@Override
			public int compare(JobInterval o1, JobInterval o2) {
				return o1.startTime - o2.startTime;
			}

		});

		return maxTime;
	}
}
