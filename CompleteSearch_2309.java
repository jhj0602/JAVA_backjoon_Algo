package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CompleteSearch_2309 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int [] arr = new int[9];
		boolean check = false;

		for (int i = 0; i < 9; i++) {
			arr[i]= Integer.parseInt(br.readLine());
			sum += arr[i];
			
		}
		for (int i = 0; i < 9; i++) {
			if (check) {
				break;
			}
			for (int j = 0; j < 9; j++) {
				if (i == j) {
					continue;
				}
				if (sum - arr[i] - arr[j] == 100) {
					arr[i]=0;
							arr[j]=0;
					check = true;
					break;
				}
			}

		}
		Arrays.sort(arr);
		for (int i = 0 ;i< 9; i++) {
			if(arr[i]!=0)
			System.out.println(arr[i]);
		}

	}

}
