package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CompleteSearch_7568 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());

		}
		for (int i = 0; i < N; i++) {// 비교할거
			int cnt = 1;

			for (int j = 0; j < N; j++) {// 비교 대상
				if (i == j) {
					continue;
				}
				if ((arr[i][0] < arr[j][0] & arr[i][1] < arr[j][1])) {// 모두클때
					cnt++;
				}

			}
			System.out.print(cnt);
		}
	}

}
