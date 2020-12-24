package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_1012 {
	static int T, M, N, K;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] arr;
	static boolean[][] visit;
	static int jirung = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {// 테스트 케이스
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[M][N];
			visit = new boolean[M][N];
			jirung = 0;
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[x][y] = 1;
			}
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1 & !visit[i][j]) {
						bfs(i, j);
						jirung++;

					}

				}
			}
			sb.append(jirung + "\n");
			
		}
		System.out.println(sb);

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
