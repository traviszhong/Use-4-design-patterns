<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>User Main Page - Banking System</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	
		function balancecheck(){
		
			document.getElementById("balance").submit();
		}
		
		function paybill(){
			document.getElementById("extransfer").submit();
		}
		function transfer(){
			document.getElementById("intransfer").submit();
		}
	
	</script>
  </head>
  
  <body>
    Login Successfully!<br><br>
    Hi, ${j_username}<br>
    What you can do is:<br><br>
    <form id="balance" action="<%=path%>/balancecheck" method="post">  
    	<input type="hidden" name="username" id="username" value="${j_username}" />  
    	<input type="button" name="button" id="balancebutton" value="Check Account Balance"
			class="btn" onclick="balancecheck()" />
    </form>
    <form id="extransfer" action="<%=path%>/externaltransfer" method="post">  
    	<input type="hidden" name="username" id="username" value="${j_username}" />  
    	<input type="button" name="button" id="balancebutton" value="Make External Transfer"
			class="btn" onclick="paybill()" />
    </form>
    <form id="intransfer" action="<%=path%>/internaltransfer" method="post">  
    	<input type="hidden" name="username" id="username" value="${j_username}" />  
    	<input type="button" name="button" id="balancebutton" value="Make Internal Transfer"
			class="btn" onclick="transfer()" />
    </form>
  </body>
</html>
