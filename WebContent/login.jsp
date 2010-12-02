<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <script type="text/javascript">
	$(function(){
		$('#dialog').dialog({
			autoOpen: false,
			modal: true,
			closeOnEscape: false,
			resizable: false,
			open: function(event, ui) { $(".ui-dialog-titlebar-close").hide(); },
			draggable: false,
			buttons: {
				"Login": function() {
					$.ajax( {
				      type: "POST",
				      url: "/CMS/AuthenticationController",
				      data: {login : $("#login").val(), passwd : $("#password").val()},
				      success: function(data) {
				    	  $('#dialog').dialog("close"); 
				      },
				      error: function(data){
				    	  
				      }
				    })
					//
				} 
			}
		});
		
		$( "#dialog" ).dialog( "open" );
	})
	</script>

 
<div id="dialog" title="Login to CMS">
	<!--  <p class="validateTips">All form fields are required.</p>-->

	<form>
	<fieldset>
		<label for="login">login</label>
		<input type="text" name="login" id="login" class="text ui-widget-content ui-corner-all" />
		<label for="password">Password</label>
		<input type="password" name="password" id="password" value="" class="text ui-widget-content ui-corner-all" />
	</fieldset>
	</form>
</div>