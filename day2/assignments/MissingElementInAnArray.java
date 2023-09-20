package week1.day2.assignments;

import java.util.Arrays;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 7, 6, 8 };
		boolean flag;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i++) {
			flag = true;
			for (int j = 0; j < arr.length - 1; j++) {
				if (i == arr[j]) {
					flag = false;
					break;

				}

			}
			if (flag) {
				System.out.println(i);
			}
		}

	}

}
