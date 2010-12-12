<%@page import="ch.unine.CMS.model.MachineBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ch.unine.CMS.model.MachineKindBean"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="ch.unine.CMS.model.SessionFactoryUtil"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	<style>
	#feedback { font-size: 1.4em; }
	#selectable .ui-selecting { background: #FECA40; }
	#selectable .ui-selected { background: #F39814; color: white; }
	#selectable { list-style-type: none; margin: 0; padding: 0; }
	#selectable li {float: left; width: 100px; height: 80px; text-align: center; }
	</style>
	
	<style>
	#toolbar {
		padding: 10px 4px;
	}
	</style>
	
    <script type="text/javascript">
	$(function(){
		//Acoordion specification
		$( "#accordion" ).accordion();
		
		//--------------------
		// New Machine 
		//--------------------
		
		$( "#AddMachine" ).button({
			icons: {
				primary: "ui-icon-plus"
			}
		});
		
		$( "#AddMachine" ).click(function() {
			$( "#newMachineDialog" ).dialog( "open" );
			return false;
		});
		
		$( "#radio" ).buttonset();
		
		//New machine generation dialog
		$('#newMachineDialog').dialog({
			autoOpen: false,
			modal: true,
			resizable: false,
			open: function(event, ui) { $(".ui-dialog-titlebar-close").hide(); },
			draggable: false,
			buttons: {
				"OK": function() {
					$.ajax( {
				      type: "POST",
				      url: "/CMS/MachineController",
				      data: {fct : 'createMachine',ip : $("#machineIP").val(), machineKind : $('input[type=radio][name=machineKind]:checked').attr('value')},
				      success: function(data){
				    	  if(data == "OK"){
				    	  	$('#newMachineDialog').dialog("close");
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
		// New Machine Kind 
		//--------------------
		
		$( "#AddMachineKind" ).button({
			icons: {
				primary: "ui-icon-plus"
			}
		});
		
		$( "#AddMachineKind" ).click(function() {
			$( "#newMachineKindDialog" ).dialog( "open" );
			return false;
		});
		
		//New machine generation dialog
		$('#newMachineKindDialog').dialog({
			autoOpen: false,
			modal: true,
			resizable: false,
			open: function(event, ui) { $(".ui-dialog-titlebar-close").hide(); },
			draggable: false,
			buttons: {
				"OK": function() {
					$.ajax( {
				      type: "POST",
				      url: "/CMS/MachineController",
				      data: {fct : 'createMachineKind',name : $("#machineKindName").val(), description : $("#machineKindDescription").val()},
				      success: function(data){
				    	  if(data == "OK"){
				    	  	$('#newMachineKindDialog').dialog("close");
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
	</script>
	<!--  New Machine Kind Dialog Box -->
	<div id="newMachineKindDialog" title="Create Machine generation">
		<form>
		<fieldset>
			<label for="machineKindName">name</label>
			<input type="text" name="machineKindName" id="machineKindName" class="text ui-widget-content ui-corner-all" />
			<label for="machineKindDescription">description</label>
			<input type="text" name="machineKindDescription" id="machineKindDescription" class="text ui-widget-content ui-corner-all" />
		</fieldset>
		</form>
	</div>

	<!--  New Machine Dialog Box -->
	<div id="newMachineDialog" title="Create Machine">
		<form id="radioForm">
		<fieldset>
			<label for="machineIP">IP</label>
			<input type="text" name="machineIP" id="machineIP" class="text ui-widget-content ui-corner-all" />
			
			<!--  <label for="machineKind">Machine generation</label> -->
			
			<% 
			//Get hibernate session
			Session sessionHibernate =  SessionFactoryUtil.getInstance().getCurrentSession();
			//Begin transaction
			Transaction tx = sessionHibernate.beginTransaction();
			//Create query
			Criteria crit = sessionHibernate.createCriteria(MachineKindBean.class);
			List cats = crit.list();
			//Create query
			crit = sessionHibernate.createCriteria(MachineBean.class);
			//get the lists
			List machines = crit.list();
			//end transaction
			tx.commit();
			//counter
			int i = 0;
			//Iterate answer
	        for (Iterator it = cats.iterator(); it.hasNext();) {
	        	MachineKindBean m = (MachineKindBean) it.next();
				out.print("<input type='radio' id='radio" + i +"' name='machineKind' class='text ui-widget-content ui-corner-all' value='" + m.getId().toString() + "'/>");
				out.println("<label for='radio" + i + "'>" + m.getName() + "</label>");
			}
			%>
			
		</fieldset>
		</form>
	</div>

	<span id="toolbar" class="ui-widget-header ui-corner-all">
		<button id="AddMachine">Machine</button>
		<button id="AddMachineKind">Machine Generation</button>
	</span>
	
	<div id="accordion">
	<!--  Create machines view -->
	
	<%
	//Iterate answer
    for (Iterator it = cats.iterator(); it.hasNext();) {
    	MachineKindBean m = (MachineKindBean) it.next();
		out.print("<h3><a href='#'>" + m.getName() +  " " + m.getDescription() + "</a></h3>");
		out.print("<div>");
		out.print("<ol id='selectable'>");
			for(Iterator itMachines = machines.iterator(); itMachines.hasNext();){
				MachineBean machine = (MachineBean) itMachines.next();
				if(machine.getMachineKindId() == m.getId()){
					out.print("<li class='ui-state-default'><div style='width:100px; height:80px;' class='ui-widget-content'>");
					out.print(machine.getIP()); 
					out.print("</div></li>");
				}
			}
		out.print("</ol></div>");
	}
	%>
	</div>