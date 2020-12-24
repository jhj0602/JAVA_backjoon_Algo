package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Gridy_1138 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int num = Integer.parseInt(br.readLine());

		ArrayList<Integer> list = new ArrayList<>();
		int[] arr = new int[num + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=num;i>=1;i--) {
			list.add(arr[i],i);
		}
		for (int i = 0; i < num; i++) {
			System.out.print(list.get(i)+" ");
		}
	}

}
