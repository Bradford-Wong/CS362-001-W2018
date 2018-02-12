package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

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
		 assertEquals(5, calday.getMonth());
		 assertEquals(29, calday.getDay());
		 assertEquals(2018, calday.getYear());
		 
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
		 assertEquals(0, calday.getSizeAppts());
		 calday.addAppt(appt);
		 calday.iterator();
		 CalDay invalid = new CalDay();
		 invalid.iterator();
		 assertEquals(29, calday.getDay());
		 assertEquals(1, calday.getSizeAppts());
		 
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
		 assertTrue(calday.getAppts().isEmpty());
		 calday.addAppt(appt);
		 assertFalse(calday.getAppts().isEmpty());
		 
		 assertNotEquals(null, calday.toString()); //very difficult to test the actual result since it's difficult to type the expected output in here so I'm just testing that it's not null
		// System.out.println(calday.toString());
		 
	 }
	 
	 @Test
	  public void test03()  throws Throwable  {
		 int thisDay=29;
		 int thisMonth=5;
		 int thisYear=2018;
		 GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		 CalDay calday = new CalDay(today);
		 assertEquals(5, calday.getMonth());
		 assertEquals(29, calday.getDay());
		 assertEquals(2018, calday.getYear());
		 
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
		 assertEquals(0, calday.getSizeAppts());
		 calday.addAppt(appt);
		 assertEqual("java.util.LinkedList$ListItr@9e725a", calday.iterator());
		 
		 //System.out.println(calday.iterator());
		 calday.addAppt(appt);
		 assertEquals(2, calday.getSizeAppts());
		 calday.addAppt(appt);
		 assertEquals(3, calday.getSizeAppts());
		 assertEqual("java.util.LinkedList$ListItr@9e725a", calday.iterator());
		 
		 
		 //assertEquals("1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.", calday.t());
	 }
	 @Test
	  public void test04()  throws Throwable  {
		 CalDay calday2 = new CalDay();
		 assertFalse(calday2.isValid());
		 //assertEquals(null, calday2.getSizeAppts());
		 assertEquals(null, calday2.iterator());
		 assertEquals("", calday2.toString());
	 }
	 
	 @Test
	  public void test05()  throws Throwable  {
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
		 
		 assertEquals("	 --- 5/29/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"	1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n" + 
		 		" \n" + 
		 		"", calday.toString());
		 
		 assertEquals(1, calday.getSizeAppts());
		 Appt appt2 = new Appt(20,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 calday.addAppt(appt2);
		 assertEquals(	"\t1/15/2018 at 8:30pm ,Birthday Party, This is my birthday party.\n", calday.getAppts().getFirst().toString());
		 Appt appt3 = new Appt(21,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 calday.addAppt(appt3);
		 assertEquals(3, calday.getSizeAppts());
		 assertEquals(	"\t1/15/2018 at 8:30pm ,Birthday Party, This is my birthday party.\n", calday.getAppts().getFirst().toString());

		 Appt appt4 = new Appt(20,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 calday.addAppt(appt4);
		 assertEquals(4, calday.getSizeAppts());
		 assertEquals(	"\t1/15/2018 at 8:30pm ,Birthday Party, This is my birthday party.\n", calday.getAppts().getFirst().toString());
		 
		 Appt appt5 = new Appt(10,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 calday.addAppt(appt5);
		 assertEquals(5, calday.getSizeAppts());
		 assertEquals(	"\t1/15/2018 at 10:30am ,Birthday Party, This is my birthday party.\n", calday.getAppts().getFirst().toString());
	
		 Appt appt6 = new Appt(23,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 calday.addAppt(appt6);
		 assertEquals(6, calday.getSizeAppts());
		 assertEquals(	"\t1/15/2018 at 10:30am ,Birthday Party, This is my birthday party.\n", calday.getAppts().getFirst().toString());
		 assertNotEquals(null, calday.iterator());
	 }
//add more unit tests as you needed	
	private void assertEqual(Object object, Iterator<?> iterator) {
		// TODO Auto-generated method stub
		
	}
}
