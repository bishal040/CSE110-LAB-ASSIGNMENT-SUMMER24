import java.io.*;

public class C{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String[] t = br.readLine().split(" ");
        int n = Integer.parseInt(t[0]);
        int x = Integer.parseInt(t[1]);
        String[] a = br.readLine().split(" ");

        pair[] arr = new pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new pair(Integer.parseInt(a[i]), i + 1);
        }

        selectionSort(arr, n);

        for (int i = 0; i < n; i++) {
            int target = x - arr[i].value;
            int l = i + 1, r = n - 1;

            while (l < r) {
                int sum = arr[l].value + arr[r].value;

                if (sum == target) {

                    int bestR = r;
                    for (int k = r - 1; k > l; k--) {
                        if (arr[k].value == arr[bestR].value && arr[k].position < arr[bestR].position) {
                            bestR = k;
                        } else if (arr[k].value != arr[bestR].value) break;
                    }

                    pw.println(arr[i].position + " " + arr[l].position + " " + arr[bestR].position);
                    pw.flush();
                    return;
                }

                if (sum < target) l++;
                else r--;
            }
        }

        pw.println(-1);
        pw.flush();
    }

    public static void selectionSort(pair[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].value < arr[minIndex].value) {
                    minIndex = j;
                }
            }
            pair temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static class pair {
        int value;
        int position;
        pair(int v, int p) {
            value = v;
            position = p;
        }
    }
}