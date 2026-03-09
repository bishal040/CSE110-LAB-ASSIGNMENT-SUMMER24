import java.io.*;
import java.util.*;
public class G {
    private static class Student {
        int id;
        int mark;
        int ogIdx;
        Student(int id, int mark, int ogIdx) {
            this.id = id;
            this.mark = mark;
            this.ogIdx = ogIdx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k=0; k<T;k++) {
            int N = Integer.parseInt(br.readLine());
            String[] idStr = br.readLine().split(" ");
            String[] markStr = br.readLine().split(" ");
            Student[] students = new Student[N];
            for (int i = 0; i < N; i++) {
                students[i] = new Student(Integer.parseInt(idStr[i]), Integer.parseInt(markStr[i]), i);
            }
            Student[] sorted = Arrays.copyOf(students, N);
            for (int i = 0; i < N - 1; i++) {
                int maxIdx = i;
                for (int j = i + 1; j < N; j++) {
                    if (sorted[j].mark > sorted[maxIdx].mark || (sorted[j].mark == sorted[maxIdx].mark && sorted[j].id < sorted[maxIdx].id)) {
                        maxIdx = j;
                    }
                }
                if (i != maxIdx) {
                    Student temp = sorted[i];
                    sorted[i] = sorted[maxIdx];
                    sorted[maxIdx] = temp;
                }
            }
            int[] indexArr = new int[N];
            for (int i = 0; i < N; i++) {
                indexArr[i] = sorted[i].ogIdx;
            }
            boolean[] visited = new boolean[N];
            int minSwaps = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i] || indexArr[i] == i) {
                  continue;
                }
                int cycleSize = 0;
                int j = i;
                while (!visited[j]) {
                    visited[j] = true;
                    j = indexArr[j];
                    cycleSize++;
                }
                if (cycleSize > 0) minSwaps += (cycleSize - 1);
            }
            System.out.println("Minimum swaps: " + minSwaps);
            for (Student s : sorted) {
                System.out.println("ID: " + s.id + " Mark: " + s.mark);
            }
        }
    }
}