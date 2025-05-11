import java.util.Arrays;
import java.util.Scanner;

 public class Zero_One_Knapsack {// O(2^n) b/c each item has choice to include the item or exclude 
  // In greedy -- we have done it for Fractional knapsack...
  //but here we learn about 0-1Knapsack & unbounded Knapsack
   static int knapsack(int val[],int wt[],int W,int n){
    // base case 
    if(W == 0 || n == 0){
      return 0;
    }
    if(W>= wt[n-1]){// valid case-- i.e including option is on here n-1 == index of items in wt[]
      // now having choice to include or exclude which item
      // include
       int ans1 = val[n-1] + knapsack(val, wt, W-wt[n-1], n-1);
      //exclude
     int ans2 = knapsack(val, wt, W, n-1);
     return Math.max(ans1,ans2);
    }else{// invalid case-- i.e excluding option only
     return  knapsack(val, wt, W, n-1); 
    }
   }

   // Sol--3 Tabluation 
   static int knapsack3(int val[],int wt[],int W,int n){
      int dp[][] = new int[n+1][W+1];
      // i) initialization
      for(int i = 0; i<=n; i++){
       if(i == 0){// when there is no item
        for(int j = 0; j<=W; j++){//then there is no filling of items into the knapsack 
          dp[i][j] = 0;
        }
       }else{// when there is full knapsack i.e no space is left in the knapsack
        dp[i][0] = 0; // then we can't take any more from items 
       }
      }
      // ii) Meaning dp[i][j] -- it tell how much MaxProfit can it has from i -total no.of item into j-kg capacity of knapsack
    // iii) filling 
    for(int i = 1;i<=n; i++){
      for(int j = 1;j<=W; j++){
          // here each item has 2 choice -- i.e. either an item should include or exclude based on capacity avialabe in the kanpsack
        if(j >= wt[i-1]){// valid --i.e include
         // again we have 2 choice which item should include or exclude so that we can get maxProfit out of knapsack
         // case-1: include
         int profit1 = val[i-1] + dp[i-1][j-wt[i-1]];
         // case-2 : exclude 
         int profit2 = dp[i-1][j];
        dp[i][j] = Math.max(profit1,profit2);
        }else{// invalid--i.e exclude based on avialablity of space in the knapsack
          dp[i][j] = dp[i-1][j];
        }
      }
    }
   System.out.println("The value in dp[][] are : ");
   printDP(dp);
      return dp[n][W];
   }

  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the total no. of items that you have : ");
    int nItems =  sc.nextInt();
    System.out.print("Enter the maximum capacity of your knapsack : ");
    int capacity =  sc.nextInt();
    int dp[][] = new int[nItems+1][capacity+1];
    // fill dp[][] with -1 means has no any profit
    for(int i = 0;i<dp.length; i++){
       Arrays.fill(dp[i],-1);
    }
    System.out.println("Now insert the weight with value of each item : ");
    int wtItem[] = new int[nItems];
    int valItem[] = new int[nItems];

    for(int i =0;i<nItems; i++){
      wtItem[i] = sc.nextInt();
      valItem[i] = sc.nextInt();
    }
    // System.out.println("\nMaximum profit after selling the items from knapsack : "+knapsack2(valItem, wtItem, capacity, nItems,dp));
    System.out.println("\nMaximum profit after selling the items from knapsack : "+knapsack3(valItem, wtItem, capacity, nItems));
   // System.out.println("The value in dp[][] are : ");
   // printDP(dp);

    // System.out.println("\nMaximum profit after selling the items from knapsack : "+knapsack(valItem, wtItem, capacity, nItems));
    // int val[] = {15,14,10,45,30};
    // int wt[] = {2,5,1,3,4};
    // int maxCapacity = 7;
    // int res = knapsack(val, wt, maxCapacity, val.length);
    // System.out.println("Max-earning : "+ res);
  }
  static void printDP(int dp[][]){
     for(int i = 0;i<dp.length; i++){
      System.out.print("[");
      for(int j = 0; j<dp[0].length; j++){
        System.out.print(dp[i][j] + " ");
      }
      System.out.println("],");
    }
  }
 //sol--2 Memoization
    static int knapsack2(int val[],int wt[],int W,int n,int dp[][]){// o(n*W)
    // base case 
    if(W == 0 || n == 0){
      return 0;
    }

    if(dp[n][W] != -1){// at this point we have already max profit calculated
       return dp[n][W];
    }

    if(W>= wt[n-1]){// valid case-- i.e including option is on here n-1 == index of items in wt[]
      // now having choice to include or exclude which item
      // include
       int ans1 = val[n-1] + knapsack2(val, wt, W-wt[n-1], n-1,dp);
      //exclude
     int ans2 = knapsack2(val, wt, W, n-1,dp);

     dp[n][W] = Math.max(ans1,ans2);
    }else{// invalid case-- i.e excluding option only
    dp[n][W] =   knapsack2(val, wt, W, n-1,dp); 
    }
    return dp[n][W];
   }
}
