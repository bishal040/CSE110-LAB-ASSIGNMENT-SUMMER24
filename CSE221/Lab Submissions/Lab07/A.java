import java.io.*;
import java.util.*;

public class A {

    static class Edge {
        int to;
        long w;
        Edge(int to, long w) {
            this.to = to;
            this.w = w;
        }
    }

    static class Node implements Comparable<Node> {
        int v;
        long d;
        Node(int v, long d) {
            this.v = v;
            this.d = d;
        }
        public int compareTo(Node o) {
            return Long.compare(this.d, o.d);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            int[] u = new int[M];
            int[] v = new int[M];
            long[] w = new long[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) u[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) v[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) w[i] = Long.parseLong(st.nextToken());

            List<Edge>[] graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                graph[u[i]].add(new Edge(v[i], w[i]));
            }

            long[] dist = new long[N + 1];
            int[] parent = new int[N + 1];
            Arrays.fill(dist, Long.MAX_VALUE);
            Arrays.fill(parent, -1);

            PriorityQueue<Node> pq = new PriorityQueue<>();
            dist[S] = 0;
            pq.add(new Node(S, 0));

            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                if (cur.d > dist[cur.v]) continue;

                for (Edge e : graph[cur.v]) {
                    if (dist[e.to] > dist[cur.v] + e.w) {
                        dist[e.to] = dist[cur.v] + e.w;
                        parent[e.to] = cur.v;
                        pq.add(new Node(e.to, dist[e.to]));
                    }
                }
            }

            if (dist[D] == Long.MAX_VALUE) {
                pw.println(-1);
                pw.flush();  
                pw.close(); 
               return;
            }

            pw.println(dist[D]);

            List<Integer> path = new ArrayList<>();
            for (int cur = D; cur != -1; cur = parent[cur]) {
                path.add(cur);
            }
            Collections.reverse(path);

            for (int x : path) {
                pw.print(x + " ");
            }
            pw.println();
        

        pw.flush();
        pw.close();
    }
}