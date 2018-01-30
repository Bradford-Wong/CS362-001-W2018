package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
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
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

	 @Test
	  public void test02()  throws Throwable  {
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
		 int newstartHour=22;
		 int newstartMinute=31;
		 int newstartDay=16;
		 int newstartMonth=02;
		 int newstartYear=2019;
		 String newtitle="Pizza Party";
		 String newdescription="This is my pizza party.";
		 appt.setStartHour(newstartHour);
		 appt.setStartMinute(newstartMinute);
		 appt.setStartDay(newstartDay);
		 appt.setStartMonth(newstartMonth);
		 appt.setStartYear(newstartYear);
		 appt.setTitle(newtitle);
		 appt.setDescription(newdescription);
		 
		 assertTrue(appt.getValid());
		 assertEquals(22, appt.getStartHour());
		 assertEquals(31, appt.getStartMinute());
		 assertEquals(16, appt.getStartDay());
		 assertEquals(02, appt.getStartMonth());
		 assertEquals(2019, appt.getStartYear());
		 assertEquals("Pizza Party", appt.getTitle());
		 assertEquals("This is my pizza party.", appt.getDescription());  
		 
	
		 Appt appt2 = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		 assertNotEquals(null, appt.toString()); //discovered bug from assignment 1 here
		 assertEquals(5, appt.compareTo(appt2));
		 
		 String nullTitle=null;
		 String nullDesc=null;
		 appt.setTitle(nullTitle);
		 appt.setDescription(nullDesc);
		 assertEquals("", appt.getDescription());
		 assertEquals("", appt.getDescription());
		 
	 }
//add more unit tests as you needed
	
}
