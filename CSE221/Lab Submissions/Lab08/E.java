import java.io.*;
import java.util.*;

public class E {
    static class Task {
        int start, end;
        Task(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            String nextLine = br.readLine();
            while (nextLine != null && nextLine.isEmpty()) nextLine = br.readLine();
            if (nextLine == null) break;

            StringTokenizer st = new StringTokenizer(nextLine);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Task[] tasks = new Task[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                tasks[i] = new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(tasks, (a, b) -> {
                if (a.end != b.end) return Integer.compare(a.end, b.end);
                return Integer.compare(a.start, b.start);
            });

            TreeMap<Integer, Integer> people = new TreeMap<>();
            people.put(-1, m); 

            int count = 0;
            for (int i = 0; i < n; i++) {
                Integer lastEnd = people.lowerKey(tasks[i].start);
                if (lastEnd != null) {
                    count++;
                    int val = people.get(lastEnd);
                    if (val == 1) people.remove(lastEnd);
                    else people.put(lastEnd, val - 1);
                    people.put(tasks[i].end, people.getOrDefault(tasks[i].end, 0) + 1);
                }
            }
            out.println(count);
        }
        out.flush();
        out.close();
    }
}