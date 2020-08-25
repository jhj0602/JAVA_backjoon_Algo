import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSBFS_1260 {
	static int[][] map;
	static boolean[] visit;
	static int n, m, v;
	static List<Integer>[] node;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		visit = new boolean[n + 1];
		node = new List[n + 1];
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
		for (int i = 0; i < n; i++) {
			Collections.sort(node[i]);
		}
		
		visit[v] = true;
		System.out.print(v + " ");
		dfs(v);
		visit = new boolean[n + 1];
		System.out.println();
		bfs();

	}

	public static void dfs(int v) {
		for (int i = 0; i < node[v].size(); i++) {
			int childNode = node[v].get(i);
			if (!visit[childNode]) {
				visit[childNode] = true;
				System.out.print(childNode + " ");
				dfs(childNode);
			}
		}
	}

	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visit[v]=true;
        System.out.print(v+" ");
        while(!queue.isEmpty()) {
        	int temp = queue.poll();
        	for(int i=0;i<node[temp].size();i++) {
        		int childNode = node[temp].get(i);
        		if(!visit[childNode]) {
        			queue.offer(childNode);
        			System.out.print(childNode+" ");
        			visit[childNode]=true;
        		}
        	}
        }
	}

}
