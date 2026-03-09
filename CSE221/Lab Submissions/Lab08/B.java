import java.io.*;
import java.util.*;
public class B {
    static int[] p;
    static int find(int x) { return p[x] == x ? x : (p[x] = find(p[x])); }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) p[i] = i;

        long minCost = 0;
        for (int[] e : edges) {
            int rootU = find(e[0]);
            int rootV = find(e[1]);
            if (rootU != rootV) {
                p[rootU] = rootV;
                minCost += e[2];
            }
        }
        out.println(minCost);
        out.flush();
    }
}