/**********************************************
Workshop #9
Course: JAC 444
Last Name: Mastache
First Name: Citlalli
ID: 126275189
Section: SAB
This assignment represents my own work in accordance with Seneca Academic Policy.
electronically signed by: Citlalli Mastache
Date: // ENTER DATE
**********************************************/

package cmastache;

public class Matrix implements Runnable{	
	final int size = 2000;
	long sequentialTime = 0; // sequential execution time 
	long parallelTime = 0; // parallel execution time
	double[][] m1 = new double[size][size];
	double[][] m2 = new double[size][size];
	double[][] mTotal = new double[size][size];
	
	// sets matrix values to numbers 1 through 1999
	public void setMatrix() {
		int num = 0;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				m1[i][j] = num;
				m2[i][j] = num;
				num++;
			}
		}	
	}
	
	// getter methods
	public double[][] getM1() {
		return m1;
	}
	public double[][] getM2() {
		return m2;
	}
	public double getTimeS() {
		return sequentialTime;
	}
	public double getParallelTime() {
		return parallelTime;
	}
	
	// starting two threads that add together matrixes and joining them together again
	public double[][] parallelAddMatrix(double[][] a, double[][] b) {
		Thread t1 = new Thread(new Matrix());
		Thread t2 = new Thread(new Matrix());
		
		// thread one start
		t1.run();
		try {
			t1.join();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		// thread two start
		t2.run();	
		try {
			t2.join();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return mTotal;
	}
	
	// calculating execution time in milliseconds
	public double[][] sequentialAddMatrix(double[][] a, double[][] b) {
		long start = System.currentTimeMillis();
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				mTotal[i][j] = a[i][j] + b[i][j];
			}
		}
		long end = System.currentTimeMillis();
		sequentialTime = end - start;
		
		return mTotal;
	}
	
	@Override
	public void run() {		
		setMatrix();
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				mTotal[i][j] = getM1()[i][j] + getM2()[i][j];
			}
		}
		long end = System.currentTimeMillis();
		parallelTime = end - start;
	}
	
	public void displayResults() {
		System.out.println("Executing parallel method...");
		parallelAddMatrix(getM1(), getM2());
		System.out.println("Execution time for parallel method: " + parallelTime);
		
		setMatrix();
		
		System.out.println("Executing sequential method...");
		sequentialAddMatrix(getM1(), getM2());
		System.out.println("Execution time for sequential method: " + sequentialTime);
	}
}
