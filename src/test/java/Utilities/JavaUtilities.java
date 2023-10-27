package Utilities;

import java.util.Random;

public class JavaUtilities {
	
	public int getRandomNumber() {
		Random ran= new Random();
		return ran.nextInt(1000);
	}

}
