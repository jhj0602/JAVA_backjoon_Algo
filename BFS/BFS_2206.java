package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class  BFS_2206{

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] arr;
	static int M, N,minpath=Integer.MAX_VALUE;
	

	static boolean[][][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[2][N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(line.charAt(j) + "");

			}

		}
		BFS();
		if (minpath == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(minpath);
	}

	static void BFS() {
		Queue<DOT> q = new LinkedList<DOT>();
		q.offer(new DOT(0, 0, 1, 0));

		while (!q.isEmpty()) {
			DOT dot = q.poll();
			int x = dot.x;
			int y = dot.y;
			int cnt = dot.cnt;
			int jump = dot.jump;
			if (x == N - 1 && y == M - 1) {
				minpath = Math.min(minpath, cnt);
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = dot.x + dx[i];
				int nextY = dot.y + dy[i];
				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {

					if (jump == 1) {// jump가 1인 visit배열이 아니면
						if (!visit[jump][nextX][nextY] && arr[nextX][nextY] == 0) {
							visit[jump][nextX][nextY] = true;// 방문체크
							q.offer(new DOT(nextX, nextY, cnt+1, jump));
						}
					} else {// 벽을 안부섯는데 상 하 좌 우가 1이면 벽 뿌시기
						if (arr[nextX][nextY] == 1) {
							if (!visit[jump + 1][nextX][nextY]) {
								visit[jump + 1][nextX][nextY] = true;
								q.offer(new DOT(nextX, nextY, cnt+1, jump+1));

							}
						} else if (arr[nextX][nextY] == 0) {
							if (!visit[jump][nextX][nextY]) {
								visit[jump][nextX][nextY] = true;
								q.offer(new DOT(nextX, nextY, cnt+1, jump));
							}
						}

					}

				}
			}
		}
	}
}

class DOT {
	int x;// row
	int y;// col
	int cnt;
	int jump;

	DOT(int x, int y, int cnt, int jump) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.jump = jump;
	}
}
