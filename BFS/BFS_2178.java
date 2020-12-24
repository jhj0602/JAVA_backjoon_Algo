package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_2178 {
	static int N, M;
	static int[][] maze;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		visited = new boolean [100][100];
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(str[j]);
								
			}
			
		}

		bfs(0, 0);
		System.out.println(maze[N - 1][M - 1]);

	}

	public static void bfs(int x, int y) {
		Queue<Integer> xq = new LinkedList<>();
		Queue<Integer> yq = new LinkedList<>();
		xq.offer(x);
		yq.offer(y);
		while (!xq.isEmpty() && !yq.isEmpty()) {
			x = xq.poll();
			y = yq.poll();
			visited[x][y] = true;
			for (int i = 0; i < 4; i++) {
				int nextx = x + dx[i];
				int nexty = y + dy[i];
				if (nextx >= 0 && nexty >= 0 && nextx < N && nexty < M) {
					if (maze[nextx][nexty] == 1 && visited[nextx][nexty]==false) {// 방문안한거
						xq.offer(nextx);
						yq.offer(nexty);
						visited[nextx][nexty] = true;
						maze[nextx][nexty]= maze[x][y]+1;
						
					}
				}
			}

		}

	}

}
