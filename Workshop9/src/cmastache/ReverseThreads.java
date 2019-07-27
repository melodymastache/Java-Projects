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

public class ReverseThreads implements Runnable {
	Thread t;
	// keyword "synchronized" ensures consistency in output
	synchronized void displayThreads() {
		int num = 50; // number of threads
		for (int i = num; i > 0; i--) { // reverse order
			// display thread number 
			t = new Thread();
			try {
				// makes the thread dormant for 400 (milli? nano?) seconds before attempting to execute again
				Thread.sleep(400);
			}
			catch (Exception e) {
				// prints error message in case of failure
				System.out.println("Thread did not execute. ERRCODE: " + e);
			}
			t.start();
			System.out.println("Hello from Thread " + i + "!");
		}
	}
	
	@Override
	public void run() {	
		displayThreads();
	}
}
