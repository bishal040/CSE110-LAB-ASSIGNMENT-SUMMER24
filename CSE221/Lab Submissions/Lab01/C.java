import java.io.*;
import java.util.*;

public class C {
  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine().trim());
      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int i = 0; i < n; i++) {
        int num = Integer.parseInt(st.nextToken());
        long result = (long) num * (num + 1) / 2;
        System.out.println(result);
      }

    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}