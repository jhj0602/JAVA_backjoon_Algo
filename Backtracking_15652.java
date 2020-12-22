package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backtracking_15652 {

	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		nm(1, 0);
		System.out.println(sb);
	}

	private static void nm(int num, int count) {
		if (count == M) {
			for (int val : arr) {

				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		} else {
			for (int i = num; i <= N; i++) {
				arr[count] = i;
				nm(i, count + 1);
			}
		}
	}
}