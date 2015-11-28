package sid.hacker.array;

import java.util.Scanner;

public class DiagonalDifferenceSolution {

	public static void main(String[] args) {
		
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];

        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                a[i][j] = in.nextInt();
                if(i == j){
                    primaryDiagonalSum += a[i][j];
                }
                if((i+j) == n-1){
                	secondaryDiagonalSum += a[i][j];
                }
            }
        }
        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonalSum));
	}

}
