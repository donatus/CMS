
    <style>
	#feedback { font-size: 1.4em; }
	#selectable .ui-selecting { background: #FECA40; }
	#selectable .ui-selected { background: #F39814; color: white; }
	#selectable { list-style-type: none; margin: 0; padding: 0; }
	#selectable li {float: left; width: 100px; height: 100px; text-align: center; }
	</style>
	<style>
			html {
				overflow-y: scroll;
			}
			body {
			    margin: 0px;
			    padding: 0px;
			    font-family: "Arial", "Helvetica", "Verdana", "sans-serif";
				font-size: 10px;
			}
			
			body {
			    margin: 0px;
			    padding: 0px;
			}
			
			div#content {
			    position: absolute;
			    left: 50%;
			    width: 600px;
			    margin-top: 50px;
			    margin-left: -316px;
			    padding: 15px;
			}
			
			label, input { display:block; }
			input.text { margin-bottom:12px; width:95%; padding: .4em; }
			fieldset { padding:0; border:0; margin-top:25px; }
			h1 { font-size: 1.2em; margin: .6em 0; }
			div#users-contain { width: 350px; margin: 20px 0; }
			div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
			div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
			.ui-dialog .ui-state-error { padding: .3em; }
			.validateTips { border: 1px solid transparent; padding: 0.3em; }
			
		</style>
		<head>
		<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.6.custom.css" rel="stylesheet" />	
		<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.8.6.custom.min.js"></script>
	
    
    <script type="text/javascript">
    //<![CDATA[

    google.setOnLoadCallback(getMyFeed);
    google.load("gdata", "1");
    var myService;
    var feedUrl = "http://www.google.com/calendar/embed?src=dhrshh%40gmail.com&ctz=Europe/Zurich";

    function logMeIn() {
    	  scope = "https://www.google.com/calendar/feeds/";
    	  var token = google.accounts.user.login(scope);
    	}
    function setupMyService() {
      myService = new google.gdata.calendar.CalendarService('GoogleInc-jsguide-1.0');
		logMeIn();
    }

    function getMyFeed() {
      setupMyService();
     
      myService.getEventsFeed(feedUrl, handleMyFeed, handleError);
    }
    /* 
    * Retrieve all calendars 
    */

    // Create the calendar service object
    var calendarService = new google.gdata.calendar.CalendarService('GoogleInc-jsguide-1.0');

    // The default "allcalendars" feed is used to retrieve a list of all 
    // calendars (primary, secondary and subscribed) of the logged-in user
    var feedUri = 'http://www.google.com/calendar/embed?src=dhrshh%40gmail.com&ctz=Europe/Zurich';

    // The callback method that will be called when getAllCalendarsFeed() returns feed data
    var callback = function(result) {

      // Obtain the array of CalendarEntry
      var entries = result.feed.entry;
      
      for (var i = 0; i < entries.length; i++) {
        var calendarEntry = entries[i];
        var calendarTitle = calendarEntry.getTitle().getText();
        PRINT('Calendar title = ' + calendarTitle);
      }
    }

    // Error handler to be invoked when getAllCalendarsFeed() produces an error
    var handleError = function(error) {
      PRINT(error);
    }

    // Submit the request using the calendar service object
    calendarService.getAllCalendarsFeed(feedUri, callback, handleError);
    //]]>
    </script>
  
 
  <iframe src="https://www.google.com/calendar/b/0/embed?height=600&amp;wkst=1&amp;bgcolor=%23FFFFFF&amp;src=dhrshh%40gmail.com&amp;color=%23B1365F&amp;ctz=Pacific%2FApia" style=" border-width:0 " width="800" height="600" frameborder="0" scrolling="no"></iframe>
  