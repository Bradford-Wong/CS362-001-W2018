package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"deleteAppt", "getApptRange"};// The list of the of methods to be tested in the Appt class

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
     * Generate Random Tests that tests TimeTable Class.
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
				
				
				int startHour2 = ValuesGenerator.getRandomIntBetween(random, -20, 100); 
				int startMinute2 = ValuesGenerator.getRandomIntBetween(random, -20, 150);
				int startDay2 = ValuesGenerator.getRandomIntBetween(random, -20, 70);
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
					int startHour3 = ValuesGenerator.getRandomIntBetween(random, -20, 100); 
					int startMinute3 = ValuesGenerator.getRandomIntBetween(random, -20, 150);
					int startDay3 = ValuesGenerator.getRandomIntBetween(random, -20, 70);
					 int startMonth3=ValuesGenerator.getRandomIntBetween(random, 1, 11);
					 int startYear3=ValuesGenerator.RandInt(random);
				 String title3="Pizza Party";
				 String description3="This is my pizza party.";
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
					String methodName = TimeTableRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("deleteAppt")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);	
							 int thisDay=ValuesGenerator.RandInt(random);
							 int thisMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
							 int thisYear=ValuesGenerator.RandInt(random);
							 GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
							 CalDay calday = new CalDay(today);
							 calday.addAppt(appt);
							 calday.addAppt(appt3);
							 TimeTable timetable = new TimeTable();
							 LinkedList<Appt> listAppts = new LinkedList<Appt>();
							 listAppts.add(appt);
							 listAppts.add(appt3);
							 listAppts.add(appt);
							 timetable.deleteAppt(listAppts, appt3);
							 timetable.deleteAppt(listAppts, appt);
							 timetable.deleteAppt(listAppts, null);
							 timetable.deleteAppt(null, appt);
							 //assertEquals(null, timetable.deleteAppt(null, appt));

						}else if (methodName.equals("getApptRange")){
							   String newTitle=(String) ValuesGenerator.getString(random);
							   appt.setTitle(newTitle);	
								 int thisDay=ValuesGenerator.RandInt(random);
								 int thisMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
								 int thisYear=ValuesGenerator.RandInt(random);
								 int nextDay=ValuesGenerator.RandInt(random);
								 GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
								 GregorianCalendar tomorrow = new GregorianCalendar(thisYear, thisMonth, thisDay+3);
								 CalDay calday = new CalDay(today);
								 calday.addAppt(appt);
								 calday.addAppt(appt3);
								 TimeTable timetable = new TimeTable();
								 LinkedList<Appt> listAppts = new LinkedList<Appt>();
								 listAppts.add(appt3);
								 listAppts.add(appt);
								 listAppts.add(appt3);
								 listAppts.add(appt);
						
								timetable.getApptRange(listAppts, today, tomorrow);
					
								 
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
