package chapter04;

import java.util.Arrays;

public class Sol16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] word1 = {'J', 'a', 'v', 'a'};					// Java
		char[] word2 = {'C', 'o', 'u', 'r', 's', 'e'};				// Course
		
		char[] fullWord = new char[word1.length + word2.length];		// JavaCourse
		
		fullWord[0] = word1[0];
		fullWord[1] = word1[1];
		fullWord[2] = word1[2];
		fullWord[3] = word1[3];
		fullWord[4] = word2[0];
		fullWord[5] = word2[1];
		fullWord[6] = word2[2];
		fullWord[7] = word2[3];
		fullWord[8] = word2[4];
		fullWord[9] = word2[5];
		
		System.out.println("fullWord = " + Arrays.toString(fullWord));

	}

}
