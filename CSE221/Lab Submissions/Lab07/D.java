import java.io.*;
import java.util.*;

public class D {
    static class Node implements Comparable<Node> {
        int id;
        long cost;
        Node(int id, long cost) {
            this.id = id;
            this.cost = cost;
        }
        public int compareTo(Node other) {
            return Long.compare(this.cost, other.cost);
        }
    }
    static final long INF = Long.MAX_VALUE / 4;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        StringTokenizer tok = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());
        int source = Integer.parseInt(tok.nextToken());
        int target = Integer.parseInt(tok.nextToken());

        long[] nodeWeight = new long[n + 1];
        tok = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= n; i++) {
            nodeWeight[i] = Long.parseLong(tok.nextToken());
        }
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            tok = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tok.nextToken());
            int to = Integer.parseInt(tok.nextToken());
            adj[from].add(to);
        }

        long[] best = new long[n + 1];
        Arrays.fill(best, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        best[source] = nodeWeight[source];
        pq.add(new Node(source, best[source]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.id;
            long curCost = cur.cost;
            if (curCost != best[u]) continue;
            if (u == target) break;

            for (int nxt : adj[u]) {
                long candidate = curCost + nodeWeight[nxt];
                if (candidate < best[nxt]) {
                    best[nxt] = candidate;
                    pq.add(new Node(nxt, candidate));
                }
            }
        }

        pw.println(best[target] >= INF ? -1 : best[target]);
        pw.flush();
    }
}