package Lab11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersTraditional {
	
	public static List<Integer> isOdd(List<Integer> numbers) {
		List<Integer> results = new ArrayList<Integer>();
		for (int n : numbers) {
			if (n % 2 != 0) results.add(n);
		}
		return results;
	}
	
	public static List<Integer> isPrime(List<Integer> numbers) {
		List<Integer> results = new ArrayList<Integer>();
		// TODO
		// Find out all the prime numbers 
		boolean check=true;
		int n;
		for(int i=0; i< numbers.size(); i++)
		{
			check = true;
			n = numbers.get(i);
			if (n%2==0) check = false;
		    //if not, then just check the odds
		    for(int j=3;j*j<=n;j+=2) {
		        if(n%j==0)
		            check = false;
		    }
			if(check == true)
			{
				results.add(n);
			}
		}
		return results;
	}
	
	public static List<Integer> isPalindrome(List<Integer> numbers) {
		List<Integer> results = new ArrayList<Integer>();
		// TODO
		// Find out all the palindrome numbers, such as 484 and 121.
		boolean check=true;
		int n;
		int palindrome; // copied number into variable
        int reverse = 0;
		
		for(int i=0; i< numbers.size(); i++)
		{
			check = true;
			n = numbers.get(i);
			palindrome = n;
			reverse = 0;
			while (palindrome != 0) {
	            int remainder = palindrome % 10;
	            reverse = reverse * 10 + remainder;
	            palindrome = palindrome / 10;
	        }

	        // if original and reverse of number is equal means
	        // number is palindrome in Java
	        if (n != reverse) 
	            check = false;
			if(check == true)
			{
				results.add(n);
			}
		}
		
		return results;
	}
		
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(480,514,484,389,709,935,328,169,649,300,685,429,243,532,308,87,25,282,91,415);
		
		System.out.println("The odd numbers are : " + isOdd(numbers));
		System.out.println("The prime numbers are : " + isPrime(numbers));
		System.out.println("The palindrome numbers are : " + isPalindrome(numbers));
		
	}
}
