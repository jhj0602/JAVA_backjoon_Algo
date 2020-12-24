package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_2606 {
	static int n,m;//컴퓨터 수 , 간선쌍
	static List<Integer>[] node;
	static int count=0;
	static boolean[] visit;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n= Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		node = new List[n + 1];
		visit = new boolean[n + 1];
		for (int i = 0; i < n + 1; i++) {
			node[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			node[x].add(y);
			node[y].add(x);
		}
		System.out.println(bfs());

	}
	public static int bfs() {
		int v=1;
		Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visit[v]=true;
        while(!queue.isEmpty()) {
        	int temp = queue.poll();
        	for(int i=0;i<node[temp].size();i++) {
        		int childNode = node[temp].get(i);
        		if(!visit[childNode]) {
        			queue.offer(childNode);
        			count++;
        			visit[childNode]=true;
        		}
        	}
        }
		return count;
	}

}
