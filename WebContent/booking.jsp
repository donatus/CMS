<%@page import="java.net.InetAddress"%>
<%@page import="ch.unine.CMS.model.EventBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="ch.unine.CMS.model.SessionFactoryUtil"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--  <link rel='stylesheet' type='text/css' href='../fullcalendar/fullcalendar.css' />--> 


<script type='text/javascript'> 
 
	$(document).ready(function() {
	
		$('#calendar').fullCalendar({
		
			// US Holidays
			events: $.fullCalendar.gcalFeed('http://www.google.com/calendar/feeds/dhrshh%40gmail.com/private-fa984c89cc7a1777baf3157ef212209f/basic'),
			
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
<style>
	#feedback { font-size: 1.4em; }
	#selectable .ui-selecting { background: #FECA40; }
	#selectable .ui-selected { background: #F39814; color: white; }
	#selectable { list-style-type: none; margin: 0; padding: 0; }
	#selectable li {float: left; width: 100px; height: 100px; text-align: center; }
	</style>
	
	<style>
	

	</style>
	
    <script type="text/javascript">
    
	$(function(){
		//Acoordion specification
		$( "#accordion" ).accordion();
		
		//--------------------
		// New Machine 
		//--------------------
		
		$( "#AddEvent" ).button({
			icons: {
				primary: "ui-icon-plus"
			}
		});
		
		$( "#AddEvent" ).click(function() {
			$( "#newMachineDialog" ).dialog( "open" );
			return false;
		});
		
		$( "#radioForm" ).buttonset();
		
		//New machine generation dialog
		$('#newEventDialog').dialog({
			autoOpen: false,
			modal: true,
			resizable: false,
			open: function(event, ui) { $(".ui-dialog-titlebar-close").hide(); },
			draggable: false,
			buttons: {
				"OK": function() {
					$.ajax( {
				      type: "POST",
				      url: "/CMS/EventController",
				      data: {fct : 'createEvent',event : $("#eventName").val(), eventStartTime : $('input[type=radio][name=eventName]:checked').attr('value')},
				      success: function(data){
				    	  if(data == "OK"){
				    	  	$('#newEventDialog').dialog("close");
				    	  	$('#tabs').tabs('load', $('#tabs').tabs('option', 'selected'));
				    	  }
				      },
				      error: function(data){
				    	  
				      }
				    })
				} 
			}
		});
		
		//--------------------
		// New Event 
		//--------------------
		
		$( "#AddEvent" ).button({
			icons: {
				primary: "ui-icon-plus"
			}
		});
		
		$( "#AddEvent" ).click(function() {
			$( "#newEventDialog" ).dialog( "open" );
			return false;
		});
		
		//New machine generation dialog
		$('#newEventDialog').dialog({
			autoOpen: false,
			modal: true,
			resizable: false,
			open: function(event, ui) { $(".ui-dialog-titlebar-close").hide(); },
			draggable: false,
			buttons: {
				"OK": function() {
					$.ajax( {
				      type: "POST",
				      url: "/CMS/EventController",
				      data: {fct : 'createEvent',name : $("#eventName").val(), description : $("#eventDescription").val()},
				      success: function(data){
				    	  if(data == "OK"){
				    	  	$('#newEventDialog').dialog("close");
				    	  	$('#tabs').tabs('load', $('#tabs').tabs('option', 'selected'));
				    	  }
				      },
				      error: function(data){
				    	  
				      }
				    })
				} 
			}
		});
		
		
		
		
	})
	
	function startTimeEvent(id){
		$.ajax( {
		      type: "POST",
		      url: "/CMS/EventController",
		      data: {fct : 'startTimeEvent',id :id},
		      success: function(data){
		    	  if(data == "OK"){
		    	  	$('#tabs').tabs('load', $('#tabs').tabs('option', 'selected'));
		    	  }
		      },
		      error: function(data){
		    	  
		      }
		    })
	}
	
	</script>
	<!--  New Event Dialog Box -->
	<div id="newEventDialog" title="Create Event">
		<form>
		<fieldset>
			<label for="eventName">name</label>
			<input type="text" name="eventName" id="eventName" class="text ui-widget-content ui-corner-all" />
			<label for="eventDescription">description</label>
			<input type="text" name="eventDescription" id="eventDescription" class="text ui-widget-content ui-corner-all" />
		</fieldset>
		</form>
	</div>

	<!--  New Event Dialog Box -->
	<div id="newEventDialog" title="Create Event Date">
		<form>
		<fieldset>
			<label for="eventDate">Date</label>
			<input type="text" name="eventDate" id="eventDate" class="text ui-widget-content ui-corner-all" />
			<div id="radioForm">
			<!--  <label for="machineKind">Machine generation</label> -->
			
			<% 
			//Get hibernate session
			Session sessionHibernate =  SessionFactoryUtil.getInstance().getCurrentSession();
			//Begin transaction
			Transaction tx = sessionHibernate.beginTransaction();
			//Create query
			Criteria crit = sessionHibernate.createCriteria(EventBean.class);
			List cats = crit.list();
			//Create query
			crit = sessionHibernate.createCriteria(EventBean.class);
			//get the lists
			List events = crit.list();
			//end transaction
			tx.commit();
			//counter
			int i = 0;
			//Iterate answer
	        for (Iterator it = cats.iterator(); it.hasNext();) {
	        	EventBean e = (EventBean) it.next();
				out.print("<input type='radio' id='radio" + i +"' name='eventName' class='text ui-widget-content ui-corner-all' value='" + e.getId().toString() + "'/>");
				out.println("<label for='radio" + i + "'>" + e.getName() + "</label>");
				i++;
			}
			%>
			</div>
		</fieldset>
		</form>
	</div>

	<span id="toolbar" align="left" class="ui-widget-header ui-corner-all ui-helper-clearfix">
		<button id="AddEvent">Event</button>
		<button id="AddEventName">Event Name</button>
	</span>
	
	<div id="accordion">
	
	<!--  Create machines view -->
	
	<%
	//Iterate answer
    for (Iterator it = cats.iterator(); it.hasNext();) {
    	EventBean e = (EventBean) it.next();
		out.print("<h3><a href='#'>" + e.getName() +  " " + e.getDescription() + "</a></h3>");
		out.print("<div>");
		out.print("<ol id='selectable'>");
			for(Iterator itEvents = events.iterator(); itEvents.hasNext();){
				EventBean event = (EventBean) itEvents.next();
				if(event.getName() == e.getName()){
					out.print("<li class='ui-state-default'><div style='width:100px; height:100px;'>");
					
					}
			}
		out.print("</ol></div>");
	}
	%>
	</div>

