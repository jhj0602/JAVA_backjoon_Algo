package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS_11403 {
	static int[][] map;
	static int n;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}

		}
		for (int i = 1; i <= n; i++) {
			int[] Route = new int[n + 1];
			DFS(i, Route, false);
			for (int j = 1; j <= n; j++) {
				sb.append(Route[j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	public static void DFS(int x, int[] Route, boolean visit) {
		if (visit) {
			Route[x] = 1;
		}
		for (int i = 1; i <= n; i++) {
			if (map[x][i] == 1 && Route[i] == 0) {
				DFS(i, Route, true);
			}
		}
	}
}