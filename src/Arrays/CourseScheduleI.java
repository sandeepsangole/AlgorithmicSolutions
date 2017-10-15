package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class CourseScheduleI {

	public static void main(String args[]) {
		CourseScheduleI obj = new CourseScheduleI();
		int[][] test1 = {
				    //        c  p
				            { 1, 0 },
				            { 2, 1 },

				{ 3, 1 },
				            { 4, 2 },
				            { 4, 3 },
				            { 5, 4 }
		};

		//	System.out.println(obj.canFinishBFS(6, test1));


		System.out.println(obj.canFinishBFS(6, test1));
	}

	public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
		if (prerequisites == null) {
			throw new IllegalArgumentException("illegal prerequisites array");
		}
		int len = prerequisites.length;
		if (numCourses == 0 || len == 0) {
			return true;
		}
		// counter for number of prerequisites
		int[] pCounter = new int[ numCourses ];
		for (int i = 0; i < len; i++) {
			pCounter[ prerequisites[ i ][ 0 ] ]++;
		}
		//store courses that have no prerequisites
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (pCounter[ i ] == 0) {
				queue.add(i);
			}
		}


		// number of courses that have no prerequisites
		int numNoPre = queue.size();
		while (!queue.isEmpty()) {
			int top = queue.remove();


			for (int i = 0; i < len; i++) {
				// if a course’s prerequisite can be satisfied by a course in queue
				if (prerequisites[ i ][ 1 ] == top) {
					pCounter[ prerequisites[ i ][ 0 ] ]--;
					if (pCounter[ prerequisites[ i ][ 0 ] ] == 0) {
						numNoPre++;
						queue.add(prerequisites[ i ][ 0 ]);
					}
				}
			}
		}
		return numNoPre == numCourses;
	}

	public boolean canFinishDFS(int numCourses, int[][] prerequisites) {

		if (prerequisites == null) {
			throw new IllegalArgumentException("illegal prerequisites array");
		}
		int len = prerequisites.length;
		if (numCourses == 0 || len == 0) {
			return true;
		}
		//track visited courses
		int[] visit = new int[ numCourses ];

		// use the map to store what courses depend on a course
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for (int[] a : prerequisites) {
			if (map.containsKey(a[ 1 ])) {
				map.get(a[ 1 ]).add(a[ 0 ]);
			} else {
				ArrayList<Integer> l = new ArrayList<Integer>();
				l.add(a[ 0 ]);
				map.put(a[ 1 ], l);
			}
		}

		for (int i = 0; i < numCourses; i++) {
			if (!canFinishDFS(map, visit, i))
				return false;
		}
		return true;
	}

	private boolean canFinishDFS(HashMap<Integer, ArrayList<Integer>> map, int[]
			visit, int i) {
		if (visit[ i ] == -1)
			return false;
		if (visit[ i ] == 1)
			return true;
		visit[ i ] = -1;
		if (map.containsKey(i)) {
			for (int j : map.get(i)) {
				if (!canFinishDFS(map, visit, j))
					return false;
			}
		}
		visit[ i ] = 1;
		return true;
	}
}
