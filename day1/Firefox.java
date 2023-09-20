package week1.day1;

public class Firefox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 float browserVersion = 100.2f;
	 String browserName = "firefox";
	 boolean isVisible = true ;
	 int releaseYear = 2001; 
	 char browserLogo = 'f' ;
	 System.out.println(browserVersion);
	 System.out.println(browserName);
	 System.out.println(isVisible);
	 System.out.println(releaseYear);
	 System.out.println(browserLogo);
	 if (releaseYear>2000) {
		 System.out.println("greater than 2000");
		System.err.println("Error Check");
	 }else 
		 System.out.println("less than 2000");
		 
	}

}
