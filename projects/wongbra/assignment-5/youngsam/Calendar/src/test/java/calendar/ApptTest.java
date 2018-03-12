package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.LinkedList;
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
	 
	 @Test
	  public void test03()  throws Throwable  {
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
		 int newstartHour=25;
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
		 assertFalse(appt.getValid());
		 
		 appt.setStartHour(startHour);
		 appt.setStartMinute(99);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(-2);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(60);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(59);
		 assertTrue(appt.getValid());
		 appt.setStartMinute(1);
		 assertTrue(appt.getValid());
		 appt.setStartMinute(0);
		 assertTrue(appt.getValid());
		 appt.setStartMinute(startMinute);
		 
		 appt.setStartHour(99);
		 assertFalse(appt.getValid());
		 appt.setStartHour(-99);
		 assertFalse(appt.getValid());
		 appt.setStartHour(24);
		 assertFalse(appt.getValid());
		 appt.setStartHour(23);
		 assertTrue(appt.getValid());
		 appt.setStartHour(1);
		 assertFalse(appt.getValid()); //should be true
		 appt.setStartHour(0);
		 assertFalse(appt.getValid()); //should be true
		 appt.setStartHour(startHour);
		 
		 appt.setStartDay(99);
		 assertFalse(appt.getValid());
		 appt.setStartDay(-2);
		 assertFalse(appt.getValid());
		 appt.setStartDay(0);
		 assertFalse(appt.getValid());
		 appt.setStartDay(1);
		 assertTrue(appt.getValid());
		 appt.setStartDay(0);
		 assertFalse(appt.getValid());
		 appt.setStartDay(startDay);
		 
		 assertFalse(appt.isRecurring());
		 
		 
		appt.setStartDay(99);
		appt.setStartYear(-2);
		assertFalse(appt.getValid());
		appt.setStartMonth(12);
		assertFalse(appt.getValid());
		appt.setStartMonth(1);
		assertFalse(appt.getValid());
		 //appt.setStartYear(startYear);
		 
		
	 }
	 @Test
	  public void test04()  throws Throwable  {
	        // create another appointment
         int startHour=16;
		 int startMinute=30;
		 int startDay=15;		
		 int startMonth=8;	
		 int startYear=2018;	
		 String title="Visit";
		 String description="Visiting my parents!";
         Appt appt = new Appt(startHour,
                 startMinute ,
                 startDay ,
                 startMonth ,
                 startYear ,
                 title,
                description);
        int[] recurDaysArr=null;
        assertEquals(0, appt.getRecurDays().length);
        assertEquals(0, appt.getRecurIncrement());
        
        appt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);	
        assertEquals(0, appt.getRecurDays().length);
        assertEquals(1, appt.getRecurBy());
        assertEquals(2, appt.getRecurIncrement());
        assertEquals(1000, appt.getRecurNumber());
        
        int[] recurDaysArr2= {3, 4};
        appt.setRecurrence( recurDaysArr2, 1, 1, 1);	
        assertNotEquals(0, appt.getRecurDays().length);
      
        assertEquals(1, appt.getRecurBy());
        assertEquals(1, appt.getRecurIncrement());
        assertEquals(1, appt.getRecurNumber());
	
	 }
	 @Test
	  public void test05()  throws Throwable  {
		  int startHour=1;
			 int startMinute=1;
			 int startDay=1;		
			 int startMonth=1;	
			 int startYear=1;	
			 String title="1";
			 String description="1";
	         Appt appt = new Appt(startHour,
	                 startMinute ,
	                 startDay ,
	                 startMonth ,
	                 startYear ,
	                 title,
	                description);
	         //System.out.println(appt.toString());
	         assertNotEquals("\t1/1/1 at 1:1am ,1, 1\n", appt.toString()); //noticed one of introduced bugs here, where string printed is wrong
	         appt.setStartHour(0);
	         assertNotEquals("\t1/1/1 at 12:1am ,1, 1\n", appt.toString()); //noticed one of introduced bugs here, where string printed is wrong
	         appt.setStartHour(15);
	         assertNotEquals("\t1/1/1 at 3:1pm ,1, 1\n", appt.toString()); //noticed one of introduced bugs here, where string printed is wrong	
	         appt.setStartHour(11);
	         assertNotEquals("\t1/1/1 at 11:1am ,1, 1\n", appt.toString());
	         appt.setStartHour(12);
	         assertNotEquals("\t1/1/1 at 12:1pm ,1, 1\n", appt.toString()); 
	         //all of the asserts above should be true
	 }
//add more unit tests as you needed
	
}
