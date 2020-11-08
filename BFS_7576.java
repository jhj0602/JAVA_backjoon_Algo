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

	dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BFS_7576 {

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int [][] arr;
	static int M,N;
	static Queue<dot> q = new LinkedList<dot>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
				if (arr[i][j] == 1) {
					q.add(new dot(i, j));
				}

			}

		}
		bfs();
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					
					System.out.println(-1);
					return;
				}
				max = Math.max(max, arr[i][j]);
			}
		}
	
		System.out.println(max - 1);
	}

	public static void bfs( ) {
		
		
		while (!q.isEmpty()) {
			
			dot dot = q.poll();
			for (int i = 0; i < 4; i++) {
				int xq = dot.x + dx[i];
				int yq = dot.y + dy[i];

				if (xq < 0 || yq < 0 || xq >= N || yq >= M||arr[xq][yq]!=0) {
					continue;
				}
				arr[xq][yq] = arr[dot.x][dot.y] + 1;
				q.add(new dot(xq, yq));
			}

		}

		

	}

}
