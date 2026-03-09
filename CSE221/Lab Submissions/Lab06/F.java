import java.io.*;
import java.util.*;

public class F {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        List<Integer>[] primeFactors = new ArrayList[5001];
        for (int i = 0; i <= 5000; i++) primeFactors[i] = new ArrayList<>();

        for (int i = 2; i <= 5000; i++) {
            int x = i;
            for (int p = 2; p * p <= x; p++) {
                if (x % p == 0) {
                    primeFactors[i].add(p);
                    while (x % p == 0) x /= p;
                }
            }
            if (x > 1 && x != i) primeFactors[i].add(x);
        }

        StringBuilder out = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            if (s == t) {
                out.append(0).append('\n');
                continue;
            }
            if (s > t) {
                out.append(-1).append('\n');
                continue;
            }

            int[] dist = new int[t + 1];
            Arrays.fill(dist, -1);

            Queue<Integer> q = new LinkedList<>();
            q.add(s);
            dist[s] = 0;

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int p : primeFactors[cur]) {
                    int next = cur + p;
                    if (next <= t && dist[next] == -1) {
                        dist[next] = dist[cur] + 1;
                        q.add(next);
                    }
                }
            }

            out.append(dist[t]).append('\n');
        }

        System.out.print(out.toString());
    }
}