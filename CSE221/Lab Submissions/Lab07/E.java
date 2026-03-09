import java.io.*;
import java.util.*;

public class E {

    static class Edge {
        int to, w;
        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static class State implements Comparable<State> {
        int node;
        int lastParity; 
        long dist;
        State(int node, int lastParity, long dist) {
            this.node = node;
            this.lastParity = lastParity;
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

        int[] u = new int[m];
        int[] v = new int[m];
        int[] w = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) u[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) v[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) w[i] = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            graph[u[i]].add(new Edge(v[i], w[i]));
        }

        long[][] dist = new long[n + 1][3];
        for (int i = 1; i <= n; i++) Arrays.fill(dist[i], INF);

        PriorityQueue<State> pq = new PriorityQueue<>();
        dist[1][2] = 0;
        pq.add(new State(1, 2, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int currNode = cur.node;
            int last = cur.lastParity;
            long d = cur.dist;
            if (d != dist[currNode][last]) continue;

            for (Edge e : graph[currNode]) {
                int parity = e.w & 1; 
                if (last != 2 && parity == last) continue;
                long nd = d + e.w;
                if (nd < dist[e.to][parity]) {
                    dist[e.to][parity] = nd;
                    pq.add(new State(e.to, parity, nd));
                }
            }
        }

        long ans = Math.min(dist[n][0], dist[n][1]);
        if (n == 1) ans = 0;

        pw.println(ans >= INF ? -1 : ans);
        pw.flush();
    }
}