package Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ {

	public static void main(String args[]){


		Player p = new Player();
		p.score = 5;

		Player p1 = new Player();
		p1.score = 4;

		Player p2 = new Player();
		p2.score = 6;
		Player p3 = new Player();
		p3.score = 7;
		Player p4 = new Player();
		p4.score = 10;


		PriorityQueue<Player> pq = new PriorityQueue<Player>(new Comparator<Player>() {
			@Override
			public int compare(Player o1, Player o2) {
				return  o2.score - o1.score;
			}
		});

		pq.offer(p);
		pq.offer(p1);
		pq.offer(p2);
		pq.offer(p3);
		pq.offer(p4);

		while(!pq.isEmpty())
			System.out.println(pq.poll().score);

	}


}

class Player{

	String name;
	int score;
	Player(){

	}

}
