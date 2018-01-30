package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
//		 
		 int thisDay=29;
		 int thisMonth=5;
		 int thisYear=2018;
		 GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		 CalDay calday = new CalDay(today);
		 
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
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
		 calday.addAppt(appt);
		 calday.iterator();
		 CalDay invalid = new CalDay();
		 invalid.iterator();
		 assertEquals(29, calday.getDay());
		 
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 int thisDay=29;
		 int thisMonth=5;
		 int thisYear=2018;
		 GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		 CalDay calday = new CalDay(today);
		 
		 int thisDay2=28;
		 int thisMonth2=4;
		 int thisYear2=2018;
		 GregorianCalendar tomorrow = new GregorianCalendar(thisYear2, thisMonth2, thisDay2);
		 
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
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
		 
		 calday.addAppt(appt);
		 assertNotEquals(null, calday.toString()); //very difficult to test the actual result since it's difficult to type the expected output in here so I'm just testing that it's not null
		 System.out.println(calday.toString());
		 
	 }
//add more unit tests as you needed	
}
