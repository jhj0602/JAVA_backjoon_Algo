package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_3986 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			char [] strchar = str.toCharArray();
			int len = strchar.length;
			Stack<Character> stack = new Stack<>();
			for (int j = 0; j <len; j++) {
				if (!stack.isEmpty()) {
					if (stack.peek() == strchar[j]) {
						stack.pop();
					} else {
						stack.push(strchar[j]);
					}

				} else {
					stack.push(strchar[j]);
				}
				
			}
			if(stack.isEmpty()) {
				count++;
			}
		}
	
		System.out.println(count);
	}

}