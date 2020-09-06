import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_11724 {
	static int n, m;

	static List<Integer>[] node;
	static int count = 0;
	static boolean[] visit;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
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
		bfs(1);
		System.out.println(count-1);
	}

	public static void bfs(int v) {
		count++;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		visit[v] = true;
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			for (int i = 0; i < node[temp].size(); i++) {
				int childNode = node[temp].get(i);
				if (!visit[childNode]) {
					queue.offer(childNode);
					
					visit[childNode] = true;
				}
			}
		}
		for(int i=0; i<visit.length;i++) {
			if(visit[i]==false) {
				bfs(i);
			}
		}

	}

}

