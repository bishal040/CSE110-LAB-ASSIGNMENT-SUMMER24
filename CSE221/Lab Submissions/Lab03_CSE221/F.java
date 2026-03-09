import java.util.*;

public class F {
    static int[] arr;
    static int[] result;
    static int index = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        result = new int[n];
        buildOrder(0, n - 1);
        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(result[i]);
        }
        System.out.println();
    }

    static void buildOrder(int left, int right) {
        if (left > right) return;
        int mid = (left + right) / 2;
        result[index++] = arr[mid];
        buildOrder(left, mid - 1);
        buildOrder(mid + 1, right);
    }
}