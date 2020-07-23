package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompleteSearch_2231 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i < N; i++) {
			if (N == search(String.valueOf(i))) {

				System.out.println(i);
				return;
			}
		}

		System.out.println(0);

	}

	static int search(String N) {
		int len = N.length();

		int sum = Integer.parseInt(N);

		for (int i = 0; i < len; i++)
			sum += N.charAt(i) - '0';
		return sum;

	}

}
