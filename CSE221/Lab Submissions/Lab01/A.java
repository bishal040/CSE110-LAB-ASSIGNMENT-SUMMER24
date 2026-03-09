import java.util.*;
public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for(int i=0; i<n; i++){
      int num = sc.nextInt();
      oddOrEven(num);
    }
    sc.close();
  }
  private static void oddOrEven(int num){
    if(num%2==0){
      System.out.println(num + " is an Even number.");
      return;
    }
    System.out.println(num + " is an Odd number.");
  }
}
