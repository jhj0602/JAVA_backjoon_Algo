package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_2748 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
				if (i== 1) {
					dp[i][j] = dp[i - 1][j] + dp[i][j];
				} else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i][j];
				} else {//Áß°£°ª 
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + dp[i][j];
				}
				if (sum < dp[i][j]) {
					sum = dp[i][j];
				}
			}

		}
		System.out.println(sum);

	}

}