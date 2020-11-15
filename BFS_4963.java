package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_4963 {
	static int[] dx = { 0, -1, 0, 1, -1, 1, -1, 1 };
	static int[] dy = { 1, 0, -1, 0, 1, 1, -1, -1 };
	static StringBuilder sb;
	static int w;
	static int h;
	static int[][] arr;
	static boolean[][] visit;
	static Queue<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			arr = new int[h][w];
			visit = new boolean[h][w];
			q = new LinkedList<int[]>();
			if (w <= 0 || h <= 0) {
				break;
			}
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 1) {
						q.offer(new int[] { i, j });
					}

				}

			}

			int count = 0;
			while (!q.isEmpty()) {
				int y = q.peek()[0];
				int x = q.peek()[1];
				q.poll();
				if (visit[y][x]) {
					continue;
				}
				bfs(y, x);

				count++;

			}
			sb.append(count + "\n");

		}

		System.out.println(sb);

	}

	public static void bfs(int y, int x) {
		visit[y][x] = true;

		for (int i = 0; i < 8; i++) {
			int yq = y + dx[i];
			int xq = x + dy[i];

			if (xq < 0 || yq < 0 || yq >= h || xq >= w) {
				continue;// 범위가 아닐때
			}
			if (arr[yq][xq] == 0) {
				continue;// 0이면 검사할 필요없음
			}
			if (visit[yq][xq]) {
				continue;// 방문한거면 검사 필요없옹
			}
			bfs(yq, xq);

		}

	}

}
