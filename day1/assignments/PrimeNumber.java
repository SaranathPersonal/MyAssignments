package week1.day1.assignments;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int intnumber = 13;
		boolean flag = true;

		

		for (int i = 2; i <intnumber; i++) {

			if (intnumber % i == 0) {

				
				flag = false;
				break;
			}

		}
		if (flag) {
			System.out.println(intnumber + " is  a prime number");
			
		}
		else
			System.out.println(intnumber + " is not  a prime number");
	}

}
