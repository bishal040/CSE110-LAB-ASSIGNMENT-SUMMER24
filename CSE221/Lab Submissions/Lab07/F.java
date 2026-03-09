import java.io.*;
import java.util.*;

public class F {

    static class Edge {
        int to, w;
        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static class State implements Comparable<State> {
        int node;
        long dist;
        State(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
        public int compareTo(State o) {
            return Long.compare(this.dist, o.dist);
        }
    }

    static final long INF = Long.MAX_VALUE / 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        long[] best = new long[n + 1];
        long[] second = new long[n + 1];
        Arrays.fill(best, INF);
        Arrays.fill(second, INF);

        PriorityQueue<State> pq = new PriorityQueue<>();
        best[s] = 0;
        pq.add(new State(s, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int u = cur.node;
            long d = cur.dist;
            if (d > second[u]) continue;

            for (Edge e : graph[u]) {
                long nd = d + e.w;
                if (nd < best[e.to]) {
                    second[e.to] = best[e.to];
                    best[e.to] = nd;
                    pq.add(new State(e.to, nd));
                } else if (nd > best[e.to] && nd < second[e.to]) {
                    second[e.to] = nd;
                    pq.add(new State(e.to, nd));
                }
            }
        }

        pw.println(second[t] >= INF ? -1 : second[t]);
        pw.flush();
    }
}