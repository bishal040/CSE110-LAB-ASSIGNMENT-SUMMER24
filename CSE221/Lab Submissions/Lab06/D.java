import java.io.*;
import java.util.*;

public class D {
    static int N;
    static ArrayList<int[]>[] g;

    static int[] bfs(int src) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(src);
        dist[src] = 0;
        int far = src;

        while (!q.isEmpty()) {
            int u = q.poll();
            far = u;
            for (int[] e : g[u]) {
                int v = e[0];
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
        return new int[]{far, dist[far]};
    }

    static int[] bfsWithParent(int src, int[] parent) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        Arrays.fill(parent, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(src);
        dist[src] = 0;
        int far = src;

        while (!q.isEmpty()) {
            int u = q.poll();
            far = u;
            for (int[] e : g[u]) {
                int v = e[0];
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    parent[v] = u;
                    q.add(v);
                }
            }
        }
        return new int[]{far, dist[far]};
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            g[u].add(new int[]{v});
            g[v].add(new int[]{u});
        }

        int a = bfs(1)[0];
        int[] parent = new int[N + 1];
        int[] res = bfsWithParent(a, parent);
        int b = res[0];
        int len = res[1];

        System.out.println(len);
        System.out.println(a + " " + b);
    }
}