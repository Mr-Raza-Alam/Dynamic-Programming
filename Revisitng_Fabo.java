import java.util.Scanner;

public class Revisitng_Fabo {
    static int fibo(int n,int fib[]){// O(2^n)---expontial but now O(n)--linear
      if(n == 0 || n == 1){
        return 1;
      }
    if(fib[n] != 0){// it means fib[n] has been calculated already now just store for another level use
        return fib[n];
    }
    // if fib[n] == 0 still zero then first calculate and then store for each level 
    fib[n] = (fibo(n-1,fib) + fibo(n-2,fib));
    //return (fibo(n-1,fib) + fibo(n-2,fib));
     return fib[n];// DP
    }
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner sc = new Scanner(System.in) ;
    System.out.print("Enter a number n to get nth fabonacci number : ");
    int n = sc.nextInt();
    //int fib[] = new int[n+1];// at this java automatically store 0 to each index
    // int res = fibo(n,fib);
    int res = fibo2(n);
    System.out.println(n+"th fabonacii seris : "+res);
  }    
//let's do fibo(n) by tabulation way of DP i.e way-2
 static int fibo2(int n){// O(n)
    int dp[] = new int[n+1];
// i) initailization
    dp[1] = 1;
// ii) assign meaning to each of the dp index in your mind and i.e dp[i]-- ith fibonacci number means = sum of ith num is equal to (i-1)th + (i-2)th numbers
// iii) filling from small to large
 for(int i = 2; i<=n; i++){
   dp[i] = dp[i-1] + dp[i-2];
  }
  return dp[n];// our ans
 }
}
