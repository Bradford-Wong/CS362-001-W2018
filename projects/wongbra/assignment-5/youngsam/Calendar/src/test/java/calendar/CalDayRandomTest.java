package calendar;

import java.util.GregorianCalendar;
import org.junit.Test;


import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Random;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"addAppt"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur 
        }	
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur 
        }	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
				
				 int startHour2 = ValuesGenerator.RandInt(random); //Randomizes input for the start hour to include values out of bounds
					int startMinute2 = ValuesGenerator.RandInt(random);
					int startDay2 = ValuesGenerator.RandInt(random);
					 int startMonth2=ValuesGenerator.getRandomIntBetween(random, 1, 11);
					 int startYear2=ValuesGenerator.RandInt(random);
				 String title2="Birthday Party";
				 String description2="This is my birthday party.";
				// System.out.println("Random day is " + startDay2);
				 Appt appt2 = new Appt(startHour2,
				          startMinute2 ,
				          startDay2 ,
				          startMonth2 ,
				          startYear2 ,
				          title2,
				         description2);
				 //System.out.println("Made it out");
				 	//create random range for variables
					int startHour = ValuesGenerator.getRandomIntBetween(random, -20, 100); 
					int startMinute = ValuesGenerator.getRandomIntBetween(random, -20, 150);
					int startDay = ValuesGenerator.getRandomIntBetween(random, -20, 70);
					 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
					 int startYear=ValuesGenerator.RandInt(random);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 //Construct a new Appointment object with the initial data	 
				 Appt appt = new Appt(startHour,
				          startMinute ,
				          startDay ,
				          startMonth ,
				          startYear ,
				          title,
				         description);
				 int startHour3=ValuesGenerator.RandInt(random);
				 int startMinute3=ValuesGenerator.RandInt(random);
				 int startDay3=ValuesGenerator.RandInt(random);;
				 int startMonth3=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear3=ValuesGenerator.RandInt(random);
				 String title3="Birthday Party";
				 String description3="This is my birthday party.";
				 //Construct a new Appointment object with the initial data	 
				 Appt appt3 = new Appt(startHour3,
				          startMinute3 ,
				          startDay3 ,
				          startMonth3 ,
				          startYear3 ,
				          title3,
				         description3);
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = CalDayRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("addAppt")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);	
							 int thisDay=ValuesGenerator.RandInt(random);
							 int thisMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
							 int thisYear=ValuesGenerator.RandInt(random);
							 GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
							 CalDay calday = new CalDay(today);
							 calday.addAppt(appt);
							 calday.addAppt(appt);
							 
							 

						}
				}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
		}catch(NullPointerException e){
				
			}
		 
		 
	 

		System.out.println("Done testing...");
	 }
}
