package lab10;

import java.util.Arrays;

/**
 * 
 * COMP 3021
 * 
This is a class that prints the maximum value of a given array of 90 elements

This is a single threaded version.

Create a multi-thread version with 3 threads:

one thread finds the max among the cells [0,29] 
another thread the max among the cells [30,59] 
another thread the max among the cells [60,89]

Compare the results of the three threads and print at console the max value.

 * 
 * @author valerio
 *
 */
public class FindMax {
	// this is an array of 90 elements
	// the max value of this array is 9999
	static int[] array = { 1, 34, 5, 6, 343, 5, 63, 5, 34, 2, 78, 2, 3, 4, 5, 234, 678, 543, 45, 67, 43, 2, 3, 4543,
			234, 3, 454, 1, 2, 3, 1, 9999, 34, 5, 6, 343, 5, 63, 5, 34, 2, 78, 2, 3, 4, 5, 234, 678, 543, 45, 67, 43, 2,
			3, 4543, 234, 3, 454, 1, 2, 3, 1, 34, 5, 6, 5, 63, 5, 34, 2, 78, 2, 3, 4, 5, 234, 678, 543, 45, 67, 43, 2,
			3, 4543, 234, 3, 454, 1, 2, 3 };
	
	
	public static void main(String[] args) {
		new FindMax().printMax();
	}

	public void printMax() {
		// this is a single threaded version
		int max[] = new int[3];
		max[0] = findMax(0, 29);
		T1 tt1 = new T1(30,59);
		T2 tt2 = new T2(60,89);
		Thread t1 = new Thread(tt1);
		Thread t2 = new Thread(tt2);
		t1.start();
		t2.start();
		try {
			t1.join(); // wait until t1 is done
			t2.join();
			} catch (InterruptedException ie) {
			ie.printStackTrace();
			}
		max[1] = tt1.getOutput();
		max[2] = tt2.getOutput();
		
		Arrays.sort(max);
		
		System.out.println("the max value is " + max[max.length-1]);
	}

	/**
	 * returns the max value in the array within a give range [begin,range]
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	private int findMax(int begin, int end) {
		// you should NOT change this function
		int max = array[begin];
		for (int i = begin + 1; i <= end; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}
	
	class T1 implements Runnable{
		private int input1;
		private int input2;
		private int output;
		
		public T1(int input, int end) {
			this.input1 = input;
			this.input2 = end;
			}
			public int getOutput() {
			return output;
			}
			@Override
			public void run(){
			 output = findMax(input1, input2);
		}
	}
	
	class T2 implements Runnable{
		private int input1;
		private int input2;
		private int output;
		
		public T2(int input, int end) {
			this.input1 = input;
			this.input2 = end;
			}
			public int getOutput() {
			return output;
			}
			@Override
			public void run(){
			 output = findMax(input1, input2);
		}
	}
}
