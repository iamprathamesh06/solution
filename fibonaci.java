import java.util.*;
public class fibonaci {
	
	static int fibbRec(int n){
		if(n >=0 && n <=1) return n;
		return fibbRec(n-1)+fibbRec(n-2);
	}
	
	static int fibbIter(int n){
		int first = 0,second = 1;
		int nextTerm = 0;
		if( n == first  || n  == second) return n;
		for (int i = 2;i<= n;i++){
			nextTerm = first + second;
			first = second;
			second = nextTerm;
		}
		return nextTerm;

	}
	
	
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		//For Recursion
		
		long start = System.nanoTime();
		int RecResult = fibbRec(num);
		long end = System.nanoTime();
		
		long calculatedRecursionTime =  end - start ;
		
		
		//For Iteration
		start = System.nanoTime();
		int IterResult = fibbIter(num);
		end = System.nanoTime();
		
		
		long calculatedIterationTime =  end - start ;
		
		
		
		System.out.println(RecResult + " Execution time: " +  calculatedRecursionTime);
		System.out.println(IterResult + " Execution time: " +  calculatedIterationTime);
    }
}


