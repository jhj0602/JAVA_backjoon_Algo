package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap_1655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> Maxqueue = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> Minqueue = new PriorityQueue<>();

		int swap = 0;

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (Maxqueue.isEmpty()) {
				Maxqueue.add(num);
			
			} else if (Maxqueue.size() == Minqueue.size())
				Maxqueue.add(num);
			else {
				Minqueue.add(num);
			}
			if (!Minqueue.isEmpty() && !Maxqueue.isEmpty()) {
				if ((Maxqueue.peek()<= Minqueue.peek())==false) {
					swap = Maxqueue.peek();
					Maxqueue.poll();
					Maxqueue.add(Minqueue.peek());
					Minqueue.poll();
					Minqueue.add(swap);
				}
			}
			sb.append(Maxqueue.peek() + "\n");
		}
		System.out.println(sb);
	}

}
