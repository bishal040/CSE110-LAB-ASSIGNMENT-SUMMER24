import java.io.*;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        long invCount = mrgS(arr, 0, arr.length - 1);
        
        System.out.println(invCount);
    }

    public static long mrgS(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }
        
        int mid = left + (right - left) / 2;
        
        long LC = mrgS(arr, left, mid);
        long RC = mrgS(arr, mid + 1, right);
        long invCount = mrg(arr, left, mid, right);
        
        return LC + RC + invCount;
    }

    public static long mrg(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }
        
        long inversion = 0;
        
        int p = 0;
        while (p < n2 && rightArr[p] < 0) {
            p++;
        }
        
        int j_pos = p;
        int j_neg = p - 1;
        
        for (int i = 0; i < n1; i++) {
            if (leftArr[i] <= 0) continue;
            
            long l_val = (long)leftArr[i];
            
            while (j_pos < n2 && l_val > (long)rightArr[j_pos] * (long)rightArr[j_pos]) {
                j_pos++;
            }
            
            while (j_neg >= 0 && l_val > (long)rightArr[j_neg] * (long)rightArr[j_neg]) {
                j_neg--;
            }
            
            inversion += (j_pos - p);
            inversion += ((p - 1) - j_neg);
        }
        
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
        
        return inversion;
    }
}