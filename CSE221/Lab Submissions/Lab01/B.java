import java.io.*;
import java.util.*;

public class B {
  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());

      for (int i = 0; i < n; i++) {
        String str = br.readLine();
        solveMath(str);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void solveMath(String str) {
    double result;
    String[] token = str.split(" ");

    if (token[2].equals("+")) {
      result = Double.parseDouble(token[1]) + Double.parseDouble(token[3]);
    } else if (token[2].equals("-")) {
      result = Double.parseDouble(token[1]) - Double.parseDouble(token[3]);
    } else if (token[2].equals("*")) {
      result = Double.parseDouble(token[1]) * Double.parseDouble(token[3]);
    } else if (token[2].equals("/")) {
      result = Double.parseDouble(token[1]) / Double.parseDouble(token[3]);
    } else {
      return;
    }

    System.out.printf("%.6f\n", result);
  }
}