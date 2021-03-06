package array;

public class Fibonacci {

	static int no = 10;//Performance can be observed for recursive vs recursiveDP if no=50 or so.
	public static void main(String[] s) {
		
		long curr = System.currentTimeMillis();

		System.out.print( "fiboRecursive - " + fiboRecursive(no) );

		long diff1 = System.currentTimeMillis() - curr;
		curr = System.currentTimeMillis();

		System.out.println(" (" + diff1 + " ms)");

		System.out.print( "fiboRecursiveDP - " + fiboRecursiveDP(no) );

		long diff2 = System.currentTimeMillis() - curr;
		curr = System.currentTimeMillis();

		System.out.println(" (" + diff2 + " ms)");

		System.out.print( "fiboLoop - " + fiboLoop(no) );

		long diff3 = System.currentTimeMillis() - curr;
		System.out.println(" (" + diff3 + " ms)");
	}

	static int fiboRecursive(int no) {

		if(no == 0 || no == 1) return no; 

		return fiboRecursive(no-1) + fiboRecursive(no-2);
	}

	static int[] fiboArr = new int[no+1];
	
	static int fiboRecursiveDP(int no) {

		if(fiboArr[no] != 0) return fiboArr[no];

		if(no <= 1) {
			fiboArr[no] = no;
		} else {
			fiboArr[no] = fiboRecursiveDP(no-1) + fiboRecursiveDP(no-2);
		}

		return fiboArr[no];
	}

	static int fiboLoop(int n) 
	{ 
		/* Declare an array to store Fibonacci numbers. */
		int f[] = new int[n+1]; // 1 extra to handle case, n = 0 
		int i; 

		/* 0th and 1st number of the series are 0 and 1*/
		f[0] = 0; 
		f[1] = 1; 

		for (i = 2; i <= n; i++) 
		{ 
			f[i] = f[i-1] + f[i-2]; 
		} 

		return f[n]; 
	} 

}
