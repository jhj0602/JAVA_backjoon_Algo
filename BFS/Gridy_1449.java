package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gridy_1449 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(reader.readLine());
		int num = Integer.parseInt(st.nextToken());
		int tape = Integer.parseInt(st.nextToken());
		boolean location[] = new boolean[1001];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < num; i++) {
			int pos = Integer.parseInt(st.nextToken());
			location[pos] = true;
		}
		int result = 0;
		for (int i = 0; i < location.length; i++) {
			if (location[i]) {
				i += tape - 1;
				result++;
			}
		}

		System.out.println(result);
	}
}