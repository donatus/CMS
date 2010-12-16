<link rel='stylesheet' type='text/css' href='../fullcalendar/fullcalendar.css' /> 


<script type='text/javascript'> 
 
	$(document).ready(function() {
	
		$('#calendar').fullCalendar({
		
			// US Holidays
			events: $.fullCalendar.gcalFeed('http://www.google.com/calendar/feeds/stefan.donnet%40gmail.com/private-8f87f457c0599b0397740932a3d2bab3/basic'),
			
			eventClick: function(event) {
				// opens events in a popup window
				window.open(event.url, 'gcalevent', 'width=700,height=600');
				return false;
			},
			
			loading: function(bool) {
				if (bool) {
					$('#loading').show();
				}else{
					$('#loading').hide();
				}
			},
			className:       'gcal-event',
            editable:        true,
            theme: true
			
		});
		
	});
 
</script> 
<style type='text/css'> 
		
	#loading {
		position: absolute;
		top: 5px;
		right: 5px;
		}
 
</style> 
<div id='loading' style='display:none'>loading...</div> 
<div id='calendar'></div> 
