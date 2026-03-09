import java.io.*;
import java.util.*;

public class G {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) words[i] = br.readLine().trim();

        List<Integer>[] g = new ArrayList[26];
        for (int i = 0; i < 26; i++) g[i] = new ArrayList<>();
        int[] indeg = new int[26];
        boolean[] used = new boolean[26];

        for (String w : words)
            for (char c : w.toCharArray())
                used[c - 'a'] = true;

        for (int i = 0; i < n - 1; i++) {
            String a = words[i], b = words[i + 1];
            int len = Math.min(a.length(), b.length());
            int j = 0;
            while (j < len && a.charAt(j) == b.charAt(j)) j++;
            if (j == len) {
                if (a.length() > b.length()) {
                    System.out.print(-1);
                    return;
                }
            } else {
                int u = a.charAt(j) - 'a';
                int v = b.charAt(j) - 'a';
                g[u].add(v);
                indeg[v]++;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < 26; i++)
            if (used[i] && indeg[i] == 0)
                pq.add(i);

        StringBuilder res = new StringBuilder();
        while (!pq.isEmpty()) {
            int u = pq.poll();
            res.append((char) (u + 'a'));
            for (int v : g[u]) {
                indeg[v]--;
                if (indeg[v] == 0) pq.add(v);
            }
        }

        int countUsed = 0;
        for (boolean b : used) if (b) countUsed++;

        if (res.length() != countUsed) {
            System.out.print(-1);
            return;
        }

        System.out.print(res.toString());
    }
}