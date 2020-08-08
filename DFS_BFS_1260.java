package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class DFS_BFS_1260 {
	static int[][] map;
	static boolean[] visit;
	static int n, m, v;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		visit = new boolean[n + 1];
		int num1, num2;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());
			map[num1][num2] = map[num2][num1] = 1;

		}
		dfs(v);
		ResetVisit();
		bfs(v);

	}

	public static void ResetVisit() {
		for (int i = 1; i < n + 1; i++) {
			visit[i] = false;
		}
		System.out.println();
	}

	public static void dfs(int d) {
		visit[d] = true;
		System.out.print(d + " ");
		for (int i = 1; i < n + 1; i++) {
			if (map[d][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
	}

	public static void bfs(int b) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(b);// 맨끝에다가 데이터를 집어넣어줌 peek() 맨앞에 데이터를 보는것
		visit[b] = true;
		while (!queue.isEmpty()) {// isEmpty 비엇는지 확인하는것
			b = queue.poll(); // 가장먼저 보관한 값 꺼내고 반환
			System.out.print(b + " ");
			for (int i = 1; i < n + 1; i++) {
				if (map[b][i] == 1 && !visit[i]) {
					queue.offer(i);//자료를 보관하는 큐 메소드
					visit[i] = true;
				}
			}
		}
	
	}

}
