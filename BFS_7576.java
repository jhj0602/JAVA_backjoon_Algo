package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_7576 {
	static int M, N;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] arr;
	static boolean[][] visit;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[1000][1000];
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
				if (arr[i][j] == 1 || arr[i][j] == -1) {
					visit[i][j] = true;
				}

			}
		}

	}

	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();

		queue.add(new int[] { x, y });
		while (!queue.isEmpty()) {
			x = queue.peek()[0];
			y = queue.peek()[1];
			queue.poll();
			visit[x][y] = true;
			for (int i = 0; i < 4; i++) {
				int xq = x + dx[i];
				int yq = y + dy[i];
				if (xq >= 0 & yq >= 0 & xq < M & yq < N) {
					if (arr[xq][yq] == 1 & !visit[xq][yq]) {
						queue.add(new int[] { xq, yq });
						visit[xq][yq] = true;
					}
				}
			}

		}

	}

}
