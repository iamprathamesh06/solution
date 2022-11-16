import java.util.*;

public class nQueen{
	
	
	static void display(int arr[][],int n){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
	static boolean isSafe(int arr[][],int x,int y,int n){
		for(int row=0;row<x;row++){
			if(arr[row][y] == 1) return false;			
		}
		
		int row = x;
		int col = y;
		while(row >= 0 && col >= 0){
			if(arr[row][col] == 1) return false;
			row--;
			col--;
		}
		
		row = x;
		col = y;
		while(row >= 0 && col < n){
			if(arr[row][col] == 1) return false;
			row--;
			col++;
		}
		
		return true;
		
	}
	
	static boolean queen(int arr[][],int row,int n){
		if(row>=n) return true;
		
		for(int col = 0;col < n;col++){
			if(isSafe(arr,row,col,n)) {
				arr[row][col] = 1;
				if(queen(arr,row+1,n)) return true;
				arr[row][col]=0; //Backtracking
			}
		}
		
		return false;
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int size = n;
		int arr[][]= new int[n][n];
		
		if(queen(arr,0,size)) display(arr,size);
		
	}
}