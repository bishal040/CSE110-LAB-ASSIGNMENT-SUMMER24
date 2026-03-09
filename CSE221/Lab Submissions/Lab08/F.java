import java.io.*;
import java.util.*;

public class F {
    static class Task {
        int duration;
        int deadline;

        public Task(int duration, int deadline) {
            this.duration = duration;
            this.deadline = deadline;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String line = br.readLine();
        if (line == null) return;
        int n = Integer.parseInt(line.trim());

        Task[] tasks = new Task[n];

        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            int a = Integer.parseInt(parts[0]); 
            int d = Integer.parseInt(parts[1]); 
            tasks[i] = new Task(a, d);
        }

        Arrays.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return Integer.compare(t1.duration, t2.duration);
            }
        });

        long currentTime = 0;
        long totalReward = 0;

        for (Task task : tasks) {
            currentTime += task.duration;
            totalReward += (long) task.deadline - currentTime;
        }

        out.println(totalReward);
        out.flush();
        out.close();
    }
}