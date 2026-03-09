import java.util.*;
public class D {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    for(int i=0; i<n; i++){
      int num = sc.nextInt();
      sc.nextLine();
      int[] nums = new int[num];
      for(int j=0; j<nums.length; j++){
        nums[j] = sc.nextInt();
      }
      checkSort(nums);
    }
  }
  private static void checkSort(int[] nums){
    boolean flag = false;
    for(int i=1;i< nums.length; i++){
      if(nums[i-1]>nums[i]){
        flag = true;
        break;
      }
    }
    if(!flag){
      System.out.println("YES");
      return;
    }
    System.out.println("NO");
  }
}
