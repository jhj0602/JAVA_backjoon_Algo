package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_5586 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int JOIcnt = 0;
		int IOIcnt = 0;
		
		for(int i=0;i<=str.length()-3;i++) {

			   String division = str.substring(i,i+3);
			   if(division.equals("JOI")) {
				   JOIcnt++;
				   }
			   else if(division.equals("IOI")) {
				   IOIcnt++;
			   }
			}
		System.out.println(JOIcnt);
		System.out.println(IOIcnt);
	        
		}

}


