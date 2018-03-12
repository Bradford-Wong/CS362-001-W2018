package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import java.util.EmptyStackException;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 int startHour1 = 8;
		 int startMinute1 = 20;
		 int startDay1 = 4;
		 int startMonth1 = 1;
		 int startYear1 = 2018;
		 String title1="Graduation party";
		 String description1="This is my graduation party";
		 
		 int startHour3 = 10;
		 int startMinute3 = 20;
		 int startDay3 = 4;
		 int startMonth3 = 1;
		 int startYear3 = 2018;
		 String title3="Pizza party";
		 String description3="This is my pizza party";
		 
		 int startHour2 = 9;
		 int startMinute2 = 30;
		 int startDay2 = 6;
		 int startMonth2 = 1;
		 int startYear2 = 2018;
		 String title2="Birthday party";
		 String description2="This is my birthday party";
		 
		 int startHour4 = 11;
		 int startMinute4 = 30;
		 int startDay4 = 8;
		 int startMonth4 = 2;
		 int startYear4 = 2018;
		 String title4="Dinner party";
		 String description4="This is my dinner party";
		 
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 Appt appt1 = new Appt(startHour1, startMinute1, startDay1, startMonth1, startYear1, title1, description1);
		 Appt appt2 = new Appt(startHour2, startMinute2, startDay2, startMonth2, startYear2, title1, description2);

		 Appt appt4 = new Appt(startHour4, startMinute4, startDay4, startMonth4, startYear4, title4, description4);
		 
		 listAppts.add(appt1);
		 listAppts.add(appt2);
		 
		 int thisYear = 2018;
		 int thisMonth = 1;
		 int thisDay = 1;
		 
		 int nextYear = 2018;
		 int nextMonth = 2;
		 int nextDay = 10;
		 

		 
		 
		 GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		 GregorianCalendar today2 = new GregorianCalendar(thisYear, thisMonth, thisDay);
		 GregorianCalendar tomorrow = new GregorianCalendar(nextYear, nextMonth, nextDay); 
		 TimeTable timeTable = new TimeTable();
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 assertNotEquals("Second date specified is not before the first date specified.", timeTable.getApptRange(listAppts, today, tomorrow));
		 assertNotNull(timeTable.getApptRange(listAppts, today, tomorrow));
		 int pv[] = {1, 0};
		 timeTable.permute(listAppts, pv);
		 //System.out.println(timeTable.permute(listAppts, pv));
		 assertEquals("[	1/4/2018 at 8:20am ,Graduation party, This is my graduation party\n" + 
		 		", 	1/6/2018 at 9:30am ,Graduation party, This is my birthday party\n" + 
		 		"]", timeTable.permute(listAppts, pv).toString());
		 timeTable.deleteAppt(listAppts, appt2);

		TimeTable nullTable = new TimeTable();
		int[] pvEmpty = new int[0];
		LinkedList<Appt> listApptsEmpty = new LinkedList<Appt>();
		assertNotNull(timeTable.permute(listApptsEmpty,pvEmpty));
		assertEquals(null, nullTable.deleteAppt(listAppts, null));

		
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
	     	/** the month the user is currently viewing **/
	     	int thisMonth;
	    	
	    	/** the year the user is currently viewing **/
	    	 int thisYear;
	    	
	    	/** todays date **/
	    	int thisDay;
	    	
	    	
	    	
			//get todays date
	    	Calendar rightnow = Calendar.getInstance();
	    	//current month/year/date is today
	    	thisMonth = rightnow.get(Calendar.MONTH)+1;
			thisYear = rightnow.get(Calendar.YEAR);
			thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
			
			 int startHour=15;
			 int startMinute=30;
			 int startDay=thisDay+1;  	
			 int startMonth=thisMonth; 	
			 int startYear=thisYear; 	
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
	         listAppts.add(appt);
	         // create another appointment
	         startHour=14;
			 startMinute=30;
			 startDay=thisDay;  	
			 startMonth=thisMonth; 	
			 startYear=thisYear; 	
			 title="Class";
			 description="Rescheduled class.";
			 //Construct a new Appointment object with the initial data	 
	         appt = new Appt(startHour,
	                  startMinute ,
	                  startDay ,
	                  startMonth ,
	                  startYear ,
	                  title,
	                 description);
	         listAppts.add(appt);
	         
	         // create another appointment
	         startHour=13;
			 startMinute=30;
			 startDay=thisDay;		
			 startMonth=thisMonth;	
			 startYear=thisYear;	
			 title="Meeting Today";
			 description="Meeting with the students.";
			 //Construct a new Appointment object with the initial data	 
	         appt = new Appt(startHour,
	                  startMinute ,
	                  startDay ,
	                  startMonth ,
	                  startYear ,
	                  title,
	                 description); 
	         
				

				listAppts.add(appt);
		     	GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
				GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
				tomorrow.add(Calendar.DAY_OF_MONTH,1);
				TimeTable timeTable=new TimeTable();
				assertEquals(1,timeTable.getApptRange(listAppts, today, tomorrow).size());
	         
	         listAppts.add(appt);


	        //Create a linked list of calendar days to return
	        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
	        assertNotEquals(null, timeTable.deleteAppt(listAppts, listAppts.get(1)));
			//LinkedList<Appt> listDeletedAppts=timeTable.deleteAppt(listAppts, listAppts.get(2));
	        assertNotNull(timeTable.getApptRange(listAppts, today, tomorrow));
	        
		
			int []recurdaysArr = new int[3];
			appt.setRecurrence(recurdaysArr,1,1,3);
			assertTrue(appt.isRecurring());
			listAppts.add(appt);
			assertEquals(1,timeTable.getApptRange(listAppts, today, tomorrow).size());

	        
	 }
	 
	 @Test
	  public void test03()  throws Throwable  {
	       TimeTable timeTable=new TimeTable();
	        
	        GregorianCalendar today = new GregorianCalendar(2018, 8, 15);
	        GregorianCalendar tomorrow = new GregorianCalendar(2018, 8, 16);
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
         LinkedList<Appt> listAppts = new LinkedList<Appt>();
        int[] recurDaysArr=new int [7];
        appt.setRecurrence( recurDaysArr, 4, 1, 3);	
		assertEquals(1,timeTable.getApptRange(listAppts, today, tomorrow).size());
		listAppts.add(appt);
		assertEquals(1,timeTable.getApptRange(listAppts, today, tomorrow).size());
		
        listAppts.add(appt);
 
        assertEquals(1,timeTable.getApptRange(listAppts, today, tomorrow).size());
        assertNotEquals(null, timeTable.getApptRange(listAppts, today, tomorrow));
        assertTrue(appt.isRecurring());
	 }
	 @Test
	  public void test04()  throws Throwable  {
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
        appt.setRecurrence( recurDaysArr, 0, 0, 0);	
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
        listAppts.add(appt);
        TimeTable timeTable=new TimeTable();
        GregorianCalendar today = new GregorianCalendar(2018, 8, 15);
        GregorianCalendar tomorrow = new GregorianCalendar(2018, 8, 16);
        assertNotEquals(null, timeTable.getApptRange(listAppts, today, tomorrow));
	 }
	 @Test
	  public void test05()  throws Throwable  {
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
       appt.setRecurrence( recurDaysArr, 0, 0, 0);	
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
       listAppts.add(appt);
       TimeTable timeTable=new TimeTable();
       GregorianCalendar today = new GregorianCalendar(2018, 8, 15);
       GregorianCalendar tomorrow = new GregorianCalendar(2018, 8, 16);
       assertNotEquals(null, timeTable.getApptRange(listAppts, today, tomorrow));
       assertEquals("[	 --- 8/15/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	8/15/2018 at 4:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		"]", timeTable.getApptRange(listAppts, today, tomorrow).toString());
	 }	 
	 
	 
	 @Test
	  public void test06()  throws Throwable  {
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
       int[] recurDaysArr={2,3,4};
       appt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);	
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
       listAppts.add(appt);
		 Appt appt2 = new Appt(20,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	     int[] recurDaysArr2={1,3,4};
	     appt2.setRecurrence( recurDaysArr2, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);	
		 listAppts.add(appt2);
		 Appt appt3 = new Appt(14,
		          startMinute ,
		          startDay ,
		          1 ,
		          startYear ,
		          title,
		         description);
		 appt3.setRecurrence( recurDaysArr2, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		 listAppts.add(appt3);
       TimeTable timeTable=new TimeTable();
       GregorianCalendar today = new GregorianCalendar(2018, 1, 15);
       GregorianCalendar tomorrow = new GregorianCalendar(2018, 8, 16);
       assertNotEquals(null, timeTable.getApptRange(listAppts, today, tomorrow));
       assertEquals("[	 --- 1/15/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 1/16/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 1/17/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 1/18/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 1/19/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 1/20/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 1/21/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 1/22/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 1/23/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 1/24/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 1/25/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 1/26/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 1/27/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 1/28/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 2/1/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 2/2/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 2/3/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 2/4/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 2/5/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 2/6/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 2/7/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 2/8/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 2/9/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 2/10/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 2/11/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 2/12/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 2/13/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 2/14/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 2/15/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 2/16/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 2/17/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 2/18/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 2/19/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 2/20/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 2/21/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 2/22/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 2/23/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 2/24/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 2/25/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 2/26/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 2/27/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 2/28/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 2/29/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 2/30/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 2/31/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 3/1/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 3/2/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 3/3/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 3/4/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 3/5/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 3/6/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 3/7/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 3/8/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 3/9/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 3/10/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 3/11/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 3/12/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 3/13/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 3/14/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 3/15/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 3/16/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 3/17/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 3/18/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 3/19/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 3/20/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 3/21/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 3/22/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 3/23/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 3/24/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 3/25/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 3/26/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 3/27/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 3/28/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 3/29/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 3/30/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 4/1/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 4/2/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 4/3/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 4/4/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 4/5/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 4/6/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 4/7/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 4/8/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 4/9/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 4/10/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 4/11/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 4/12/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 4/13/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 4/14/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 4/15/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 4/16/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 4/17/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 4/18/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 4/19/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 4/20/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 4/21/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 4/22/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 4/23/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 4/24/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 4/25/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 4/26/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 4/27/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 4/28/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 4/29/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 4/30/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 4/31/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 5/1/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 5/2/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 5/3/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 5/4/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 5/5/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 5/6/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 5/7/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 5/8/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 5/9/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 5/10/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 5/11/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 5/12/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 5/13/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 5/14/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 5/15/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 5/16/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 5/17/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 5/18/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 5/19/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 5/20/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 5/21/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 5/22/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 5/23/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 5/24/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 5/25/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 5/26/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 5/27/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 5/28/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 5/29/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 5/30/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 6/1/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 6/2/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 6/3/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 6/4/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 6/5/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 6/6/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 6/7/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 6/8/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 6/9/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 6/10/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 6/11/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 6/12/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 6/13/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 6/14/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 6/15/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 6/16/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 6/17/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 6/18/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 6/19/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 6/20/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 6/21/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 6/22/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 6/23/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 6/24/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 6/25/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 6/26/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 6/27/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 6/28/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 6/29/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 6/30/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 6/31/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 7/1/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 7/2/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 7/3/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 7/4/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 7/5/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 7/6/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 7/7/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 7/8/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 7/9/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 7/10/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 7/11/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 7/12/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 7/13/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 7/14/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 7/15/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 7/16/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 7/17/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 7/18/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 7/19/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 7/20/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 7/21/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 7/22/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 7/23/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 7/24/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 7/25/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 7/26/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 7/27/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 7/28/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 7/29/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 7/30/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 7/31/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 8/1/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 8/2/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 8/3/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 8/4/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 8/5/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 8/6/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 8/7/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 8/8/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 8/9/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 8/10/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 8/11/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 8/12/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	1/15/2018 at 2:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		", 	 --- 8/13/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 8/14/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"\n" + 
       		", 	 --- 8/15/2018 --- \n" + 
       		" --- -------- Appointments ------------ --- \n" + 
       		"	8/15/2018 at 4:30pm ,Visit, Visiting my parents!\n" + 
       		" 	8/15/2018 at 8:30pm ,Visit, Visiting my parents!\n" + 
       		" \n" + 
       		"]", timeTable.getApptRange(listAppts, today, tomorrow).toString());
	 }
	 
	 @Test
	  public void test07()  throws Throwable  {
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
       int[] recurDaysArr={2,3,4};
       appt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);	
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
       listAppts.add(appt);
       TimeTable timeTable=new TimeTable();
       GregorianCalendar today = new GregorianCalendar(2018, 8, 15);
       GregorianCalendar tomorrow = new GregorianCalendar(2018, 8, 16);
		 int pv[] = {1, 0};
		 
    
	 }
	 
	 @Test
	  public void test08()  throws Throwable  {
		 int startHour1 = 8;
		 int startMinute1 = 20;
		 int startDay1 = 4;
		 int startMonth1 = 1;
		 int startYear1 = 2018;
		 String title1="Graduation party";
		 String description1="This is my graduation party";
		 
		 int startHour3 = 10;
		 int startMinute3 = 20;
		 int startDay3 = 4;
		 int startMonth3 = 1;
		 int startYear3 = 2018;
		 String title3="Pizza party";
		 String description3="This is my pizza party";
		 
		 int startHour2 = 9;
		 int startMinute2 = 30;
		 int startDay2 = 6;
		 int startMonth2 = 1;
		 int startYear2 = 2018;
		 String title2="Birthday party";
		 String description2="This is my birthday party";
		 
		 int startHour4 = 11;
		 int startMinute4 = 30;
		 int startDay4 = 8;
		 int startMonth4 = 2;
		 int startYear4 = 2018;
		 String title4="Dinner party";
		 String description4="This is my dinner party";
		 
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 Appt appt1 = new Appt(startHour1, startMinute1, startDay1, startMonth1, startYear1, title1, description1);
		 Appt appt2 = new Appt(startHour2, startMinute2, startDay2, startMonth2, startYear2, title1, description2);

		 Appt appt4 = new Appt(startHour4, startMinute4, startDay4, startMonth4, startYear4, title4, description4);
		 
		 listAppts.add(appt1);
		 listAppts.add(appt2);
		 listAppts.add(appt4);
		 
		 int thisYear = 2018;
		 int thisMonth = 1;
		 int thisDay = 29;
		 
		 int nextYear = 2018;
		 int nextMonth = 2;
		 int nextDay = 10;
		 

		 
		 
		 GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		 GregorianCalendar today2 = new GregorianCalendar(thisYear, thisMonth, thisDay);
		 GregorianCalendar tomorrow = new GregorianCalendar(nextYear, nextMonth, nextDay); 
		 TimeTable timeTable = new TimeTable();
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 assertNotEquals("Second date specified is not before the first date specified.", timeTable.getApptRange(listAppts, today, tomorrow));
		 int pv[] = {2, 0, 1};
		 assertEquals("[	1/4/2018 at 8:20am ,Graduation party, This is my graduation party\n" + 
				", 	1/6/2018 at 9:30am ,Graduation party, This is my birthday party\n" + 
				", 	2/8/2018 at 11:30am ,Dinner party, This is my dinner party\n" + 
				"]", timeTable.permute(listAppts, pv).toString());
		 int pv2[] = {0, 40, 0};
		 assertEquals("[	1/4/2018 at 8:20am ,Graduation party, This is my graduation party\n" + 
					", 	1/6/2018 at 9:30am ,Graduation party, This is my birthday party\n" + 
					", 	2/8/2018 at 11:30am ,Dinner party, This is my dinner party\n" + 
					"]", timeTable.permute(listAppts, pv2).toString());
		// timeTable.permute(listAppts, pv);
		 
		 Appt appt3 = new Appt(90, startMinute2, startDay2, startMonth2, startYear2, title1, description2);
		 assertEquals(null, timeTable.deleteAppt(listAppts, appt3));
	 }
	 
	 @Test
	  public void test09()  throws Throwable  {
		 int startHour1 = 8;
		 int startMinute1 = 20;
		 int startDay1 = 4;
		 int startMonth1 = 1;
		 int startYear1 = 2018;
		 String title1="Graduation party";
		 String description1="This is my graduation party";
		 
		 int startHour3 = 10;
		 int startMinute3 = 20;
		 int startDay3 = 4;
		 int startMonth3 = 1;
		 int startYear3 = 2018;
		 String title3="Pizza party";
		 String description3="This is my pizza party";
		 
		 int startHour2 = 9;
		 int startMinute2 = 30;
		 int startDay2 = 6;
		 int startMonth2 = 1;
		 int startYear2 = 2018;
		 String title2="Birthday party";
		 String description2="This is my birthday party";
		 
		 int startHour4 = 11;
		 int startMinute4 = 30;
		 int startDay4 = 8;
		 int startMonth4 = 2;
		 int startYear4 = 2018;
		 String title4="Dinner party";
		 String description4="This is my dinner party";
		 
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 Appt appt1 = new Appt(startHour1, startMinute1, startDay1, startMonth1, startYear1, title1, description1);
		 Appt appt2 = new Appt(startHour2, startMinute2, startDay2, startMonth2, startYear2, title1, description2);
		 Appt appt3 = new Appt(startHour3, startMinute3, startDay3, startMonth3, startYear3, title3, description3);
		 Appt appt4 = new Appt(startHour4, startMinute4, startDay4, startMonth4, startYear4, title4, description4);
		 
		 listAppts.add(appt1);
		 listAppts.add(appt2);
		 
		 int thisYear = 2018;
		 int thisMonth = 1;
		 int thisDay = 1;
		 
		 int nextYear = 2018;
		 int nextMonth = 3;
		 int nextDay = 10;
		 

		 
		 
		 GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
		 GregorianCalendar today2 = new GregorianCalendar(thisYear, thisMonth, thisDay);
		 GregorianCalendar tomorrow = new GregorianCalendar(nextYear, nextMonth, nextDay); 
		 TimeTable timeTable = new TimeTable();
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 
		 //timeTable.deleteAppt(listAppts, appt1);
		 assertEquals("[	 --- 1/1/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/2/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/3/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/4/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"	1/4/2018 at 8:20am ,Graduation party, This is my graduation party\n" + 
		 		" \n" + 
		 		", 	 --- 1/5/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/6/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"	1/6/2018 at 9:30am ,Graduation party, This is my birthday party\n" + 
		 		" \n" + 
		 		", 	 --- 1/7/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/8/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/9/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/10/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/11/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/12/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/13/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/14/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/15/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/16/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/17/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/18/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/19/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/20/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/21/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/22/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/23/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/24/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/25/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/26/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/27/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 1/28/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/1/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/2/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/3/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/4/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/5/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/6/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/7/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/8/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/9/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/10/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/11/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/12/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/13/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/14/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/15/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/16/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/17/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/18/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/19/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/20/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/21/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/22/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/23/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/24/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/25/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/26/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/27/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/28/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/29/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/30/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 2/31/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 3/1/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 3/2/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 3/3/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 3/4/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 3/5/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 3/6/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 3/7/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 3/8/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		", 	 --- 3/9/2018 --- \n" + 
		 		" --- -------- Appointments ------------ --- \n" + 
		 		"\n" + 
		 		"]", timeTable.getApptRange(listAppts, today, tomorrow).toString());
	  }
	 
		@Test

		public void test10()  throws Throwable  {
			
			 int startHour1 = 8;
			 int startMinute1 = 20;
			 int startDay1 = 4;
			 int startMonth1 = 1;
			 int startYear1 = 2018;
			 String title1="Graduation party";
			 String description1="This is my graduation party";
			
			LinkedList<Appt> listAppts = new LinkedList<Appt>();
			
			Appt appt1 = new Appt(startHour1, startMinute1, startDay1, startMonth1, startYear1, title1, description1);
			listAppts.add(appt1);
			TimeTable timeTable=new TimeTable();
			int[] recurringDaysArr = null;
			appt1.setRecurrence(recurringDaysArr, 2, 3, 9);
			listAppts.add(appt1);

			int[] recurringDaysArr2 = {1, 2, 3}; 
			appt1.setRecurrence(recurringDaysArr2, 2, 2, -2);
			listAppts.add(appt1);
			int[] recurringDays3 = new int[0];
			appt1.setRecurrence(recurringDays3, 3, 3, 3);

			 int startHour2 = 9;
			 int startMinute2 = 12;
			 int startDay2 = 4;
			 int startMonth2 = 1;
			 int startYear2 = 2018;
			 String title2="Birthday party";
			 String description2="This is my birthday party";
			
			Appt appt2 = new Appt(startHour2, startMinute2, startDay2, startMonth2, startYear2, title2, description2);
			assertNull(timeTable.deleteAppt(listAppts,appt2));

		}


			
			
			
//add more unit tests as you needed
}


