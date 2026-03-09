import java.io.*;
import java.util.*;

public class E {
public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(br.readLine().trim());
String[] s = br.readLine().trim().split(" ");
int[] arr = new int[n];
for (int i = 0; i < n; i++) {
    arr[i] = Integer.parseInt(s[i]);
}
long inversions = 0;
for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
        if (arr[i] > arr[j]) {
            inversions++;
        }
    }
}

if (inversions % 2 != 0) {
    System.out.println("NO");
    return;
}
int maxOps = n * n;
int[][] ops = new int[maxOps][2];
int opCount = 0;

boolean swapped = true;
int safety = 0; 
while (swapped && safety++ < n * n) {
    swapped = false;
for (int i = 0; i <= n - 3; i++) {
if (arr[i] > arr[i + 1] || arr[i] > arr[i + 2] || arr[i + 1] > arr[i + 2]) {
    if (opCount >= maxOps) {
        System.out.println("NO");
        return;
    }
    int temp = arr[i];
    arr[i] = arr[i + 2];
    arr[i + 2] = arr[i + 1];
    arr[i + 1] = temp;

    ops[opCount][0] = i + 1;
    ops[opCount][1] = i + 3;
    opCount++;
    swapped = true;
}
}
}
for (int i = 0; i < n - 1; i++) {
    if (arr[i] > arr[i + 1]) {
        System.out.println("NO");
        return;
    }
}
System.out.println("YES");
System.out.println(opCount);
for (int i = 0; i < opCount; i++) {
    System.out.println(ops[i][0] + " " + ops[i][1]);
}
}
}