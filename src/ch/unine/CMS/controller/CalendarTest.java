package ch.unine.CMS.controller;



import com.google.gdata.client.calendar.*;
import com.google.gdata.data.calendar.*;
import com.google.gdata.util.*;

import java.io.IOException;
import java.net.URL;

public class CalendarTest {
	public static void main(String[] args) throws IOException, ServiceException {
        CalendarService myService = new CalendarService("exampleCo-exampleApp-1.0");
        myService.setUserCredentials("dhrshh@gmail.com", "papa25031965");
            
        URL feedUrl = new URL("http://www.google.com/calendar/feeds/dhrshh%40gmail.com/private-fa984c89cc7a1777baf3157ef212209f/basic");
        CalendarFeed resultFeed = myService.getFeed(feedUrl, CalendarFeed.class);
            
        System.out.println("Your calendars:");
        System.out.println();
        
        for (int i = 0; i < resultFeed.getEntries().size(); i++) {
          CalendarEntry entry = resultFeed.getEntries().get(i);
          System.out.println("\t" + entry.getTitle().getPlainText());
        }
    
    }
}
