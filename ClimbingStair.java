import java.util.Scanner;

public class ClimbingStair {
  // climbing stair based fabonacci logic of dp for 2 choice i)---> climb by 1 stair , ii)  climb by 2stairs
 // sol.-2 -- using DP -- Recurr. + Memoization
 static int climbWays2(int n,int ways[]){
    if(n == 0 || n==1){
        return 1;
    }
    if(ways[n] != 0){
        return ways[n];
    }
    ways[n] = climbWays(n-1) + climbWays(n-2);
    return ways[n];
 }

 // sol.-3 -- using DP -- Tabulation -- Table + loop
 static int climbWays3(int n){
    int ways[] = new int[n+1];
    // step-i) --  initialization
    ways[0] = 1;
    ways[1] = 1;
   // step iii) loop -- filling from small to large
   for(int i = 2; i<=n; i++ ){
   // step ii) meaning of each index in your mind
    ways[i] = ways[i-1] + ways[i-2];
   }
   return ways[n];
 }
  public static void main(String[] args) {
   @SuppressWarnings("resource")
    Scanner sc = new Scanner(System.in);
   System.out.print("Enter the no. of stairs to reach from ground : ");
   int n = sc.nextInt();
  // int dp[] = new int[n+1];
   //int ways1 = climbWays(n);
   //int ways2 = climbWays2(n,dp);
   int ways3 = climbWays3(n);

   System.out.println("Total no. of ways to climb to "+n+"th stairs : "+ways3); 
  }    
  // sol-1 --  by recurrsion
  static int climbWays(int n){// O(2^n)
    // base case 
  if(n == 1){
    return 1;
  }else if(n == 2){
    return 2;
  }
    return (climbWays(n-1) + climbWays(n-2));
  }
}
