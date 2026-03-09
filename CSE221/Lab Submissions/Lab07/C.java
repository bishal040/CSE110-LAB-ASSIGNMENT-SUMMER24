import java.io.*;
import java.util.*;

public class C{

    static class Edge {
        int to, w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }

    static class State implements Comparable<State> {
        int v;
        long d;
        State(int v, long d) { this.v = v; this.d = d; }
        public int compareTo(State o) { return Long.compare(this.d, o.d); }
    }

    static final long INF = Long.MAX_VALUE / 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            g[u].add(new Edge(v, w));
            g[v].add(new Edge(u, w));
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(new State(1, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int u = cur.v;
            long d = cur.d;
            if (d != dist[u]) continue;

            for (Edge e : g[u]) {
                long cand = Math.max(dist[u], e.w);
                if (cand < dist[e.to]) {
                    dist[e.to] = cand;
                    pq.add(new State(e.to, cand));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            long ans = (dist[i] >= INF) ? -1 : dist[i];
            if (i > 1) sb.append(' ');
            sb.append(ans);
        }
        out.println(sb.toString());
        out.flush();
    }
}