
/*

Algorithm:
Step 1: Ask the date of birth. Input date of birth
Step 2: Ask the month of birth. Input month of birth.
Step 3: Ask the year of birth. Input year of birth.
Step 4: Check if their birth month and day is before or after today's date.
Step 5: If their birth month and date is before or equal to today's date, age is (2016 minus their birth year)
Step 6: Else age is (2017 minus their birth year).

Pseudocode:
DECLARE  Birth_year, Birth_month and Birth_date
PROMPT user for their birth year, Birth_year
PROMPT user for their birth month, Birth_month
PROMPR user for their birth date, Birth-date
IF (Birth_month is less than or equal to 5 AND Birth_date is less than or equal to 24) THEN PRINT "Your age is"+ 2017-Birth_year
ELSE PRINT "Your age is"+ (2016-Birth_year)



*/

package biswash;
import java.util.*;

public class DOB{

	public static void main(String[] args)

	{
		
		Date date = new Date();// your date
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = (cal.get(Calendar.MONTH) + 1);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int birth_year;
		int birth_month;
		int birth_date;
		char yesOrNo;
		Scanner s = new Scanner(System.in);
		boolean valid = false;
		do {

			do {
				System.out.println("what is your year of birth");
				while(!s.hasNextInt()){
					System.out.println("wrong data type. enter an integer");
					s.next();
				}
				birth_year = s.nextInt();
			} while (birth_year < 1900 || birth_year > year);

			do {
				System.out.println("what is your month of birth");
				while(!s.hasNextInt()){
					System.out.println("wrong data type. enter an integer");
					s.next();
				}
				birth_month = s.nextInt();
			} while (birth_month < 1 || birth_month > 12);

			do {
				System.out.println("what is your date of birth");
				while(!s.hasNextInt()){
					System.out.println("wrong data type. enter an integer");
					s.next();
				}
				birth_date = s.nextInt();
				if (birth_date > 0){
				switch (birth_month) 
				{
				case 1: case 3: case 5: case 7: case 8: case 10: case 12:
					if (birth_date >= 1 && birth_date <= 31) 
					{
						valid = true;
					}else{
						System.out.println("The date you entered is invalid. Try again.");
					}
					break;
				case 4: case 6: case 9: case 11:
					if (birth_date >= 1 && birth_date <= 30){
						valid=true;
					}else{
						System.out.println("The date you entered is invalid. Try again.");
					}
						break;
				case 2:
					if (birth_date > 0 && birth_date <29) 
					{
						valid=true;
					}
					else if (birth_year % 4 == 0 && birth_year % 100 !=0 && birth_date==29) 
						{
								valid = true;
						}
					else{
						
						System.out.println("The date you entered is invalid. Try again.");
					}
					break;
					}
				}
			} while (!valid);

			if (birth_month <= month) 
			{
				if (birth_month==month&& birth_date<=day){
					System.out.println("You are " + (year - birth_year)); 
				}else{
					System.out.println("Your age is " + (year - 1 - birth_year));
				}
			} else {
				System.out.println("Your age is " + (year - 1 - birth_year)); 
			}
			do {
				System.out.println("Do you want to continue with another employee's birthdate?(Y/N)");
				yesOrNo = s.next(".").charAt(0);
			} while (yesOrNo != 'Y' && yesOrNo != 'N');
		} while (yesOrNo == 'Y');
		s.close();
	}

}
