import java.util.*;
public class F {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    int[] nums = new int[n];
    nums = takeArrayInput(nums);
    nums = swap(nums);
    //printArr(nums);
  }
  private static int[] takeArrayInput(int[] nums){
    Scanner sc = new Scanner(System.in);
    for(int i=0; i<nums.length; i++){
      nums[i] = sc.nextInt();
    }
    sc.close();
    return nums;
  }
  private static int[] swap(int[] nums){
    for(int i=1; i<nums.length; i++){
      if(nums[i-1]%2==0 && nums[i]%2==0){
         int temp = nums[i-1];
         nums[i-1] = nums[i];
         nums[i] = temp;
      }
      if(nums[i-1]%2!=0 && nums[i]%2!=0){
         int temp = nums[i-1];
         nums[i-1] = nums[i];
         nums[i] = temp;
      }
      System.out.print(nums[i-1] + " ");
    }
    System.out.println(nums[nums.length-1]);
    return nums;
  }
  private static void printArr(int[] arr){
    for(int i = 0; i< arr.length; i++){
      if(i!=arr.length-1){
        System.out.print(arr[i] + " ");
      }
      else{
        System.out.println(arr[i]);
      }
    }
  }
}
