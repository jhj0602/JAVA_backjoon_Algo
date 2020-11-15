package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class dot {
	int x;
	int y;
	int z;

	dot(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class BFS_7569 {

	static int[] dx = { 0, -1, 0, 1, 0, 0 };
	static int[] dy = { 1, 0, -1, 0, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static int[][][] arr;
	static int M, N, H;
	static Queue<dot> q = new LinkedList<dot>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		arr = new int[N][M][H];
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				String[] line = br.readLine().split(" ");
				for (int j = 0; j < M; j++) {

					arr[i][j][k] = Integer.parseInt(line[j]);
					if (arr[i][j][k] == 1) {
						q.offer(new dot(i, j, k));
					}

				}
			}
		}
		bfs();
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < H; k++) {
					if (arr[i][j][k] == 0) {

						System.out.println(-1);
						System.exit(0);
					}
					max = Math.max(max, arr[i][j][k]);
				}
			}
		}

		System.out.println(max - 1);
	}

	public static void bfs() {
		int val = 0;
		while (!q.isEmpty()) {

			dot dot = q.poll();
			for (int i = 0; i < 6; i++) {
				int xq = dot.x + dx[i];
				int yq = dot.y + dy[i];
				int zq = dot.z + dz[i];
				val = arr[dot.x][dot.y][dot.z];
				if (xq < 0 || yq < 0 || zq < 0 || xq >= N || yq >= M || zq >= H || arr[xq][yq][zq] != 0) {
					continue;
				}
				arr[xq][yq][zq] = val + 1;
				q.offer(new dot(xq, yq, zq));
			}

		}

	}

}
