package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_12851 {
	static int N;
	static int K;
	static int count = 0;
	static int[] cnt = new int[100001];
	static int[] check = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

	
		bfs();


		System.out.println(check[K]-1);
		System.out.println(cnt[K]);

	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		check[N] = 1;
		cnt[N] = 1;

		while (!q.isEmpty()) {
			int temp = q.poll();

			for (int i = 0; i < 3; i++) {
				int next;

				if (i == 0) {
					next = temp + 1;
				} else if (i == 1) {
					next = temp - 1;
				} else {
					next = temp * 2;
				}

//범위 벗어 나지 않는곳만 탐색
                if(0 <= next && next <= 100000){
                    
//                   다음지점이 현재까지 찾은 최소값인 경우
                    if(check[next] == check[temp] + 1){
//                       현재 위치까지 최소값으로 오는 만큼의 경우의수를 더해줌
                        cnt[next] += cnt[temp];
                        continue;
                    }
                    
                    
                    
                    if(check[next] == 0 || check[next] > check[temp] + 1){
                      
                        check[next] = check[temp] + 1;
               
                        cnt[next] = cnt[temp];
                        q.add(next);
                    }
                }
			}

		}
	}
}