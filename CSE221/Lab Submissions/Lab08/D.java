import java.io.*;
import java.util.*;

public class D {
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
        if (line == null || line.isEmpty()) return;

        int n = Integer.parseInt(line.trim());
        Task[] tasks = new Task[n];

        for (int i = 0; i < n; i++) {
            String taskLine = br.readLine();
            if (taskLine == null) break;
            StringTokenizer st = new StringTokenizer(taskLine);
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tasks[i] = new Task(s, e);
        }

        Arrays.sort(tasks, new Comparator<Task>(){
            @Override
            public int compare(Task t1, Task t2){
                if(t1.end != t2.end){
                    return Integer.compare(t1.end, t2.end);
                }
                return Integer.compare(t1.start, t2.start);
            }
        });
        List<Task> result = new ArrayList<>();
        int LastEndTime = -1;
        for(int i = 0 ; i < n ; i++){
            if(tasks[i].start > LastEndTime){
                result.add(tasks[i]);
                LastEndTime = tasks[i].end;
            }
        }
        out.println(result.size());
        for (Task t : result) {
            out.println(t.start + " " + t.end);
        }
        out.flush();
        out.close();
    }
}