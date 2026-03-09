import java.io.*;
import java.util.*;

public class B{

    static class Edge {
        int to;
        int w;
        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static class Node implements Comparable<Node> {
        int v;
        long dist;
        Node(int v, long dist) {
            this.v = v;
            this.dist = dist;
        }
        @Override
        public int compareTo(Node other) {
            return Long.compare(this.dist, other.dist);
        }
    }

    static final long INF = Long.MAX_VALUE / 4;

    static long[] dijkstra(int n, int src, ArrayList<Edge>[] g) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[src] = 0;
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.v;
            long d = cur.dist;
            if (d != dist[u]) continue;

            for (Edge e : g[u]) {
                long nd = d + e.w;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    pq.add(new Node(e.to, nd));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            g[u].add(new Edge(v, w));
        }

        long[] distS = dijkstra(N, S, g);
        long[] distT = dijkstra(N, T, g);

        long bestTime = INF;
        int bestNode = -1;

        for (int v = 1; v <= N; v++) {
            if (distS[v] == INF || distT[v] == INF) continue;
            long meetTime = Math.max(distS[v], distT[v]);
            if (meetTime < bestTime || (meetTime == bestTime && v < bestNode)) {
                bestTime = meetTime;
                bestNode = v;
            }
        }

        if (bestNode == -1) {
            out.println(-1);
        } else {
            out.println(bestTime + " " + bestNode);
        }

        out.flush();
    }
}