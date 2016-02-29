<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>External Tranfer - Banking System</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<script type="text/javascript">
	
		function transfercheck(){
			var amount = document.getElementById("amount").value;
			var account_number = document.getElementById("account_number").value;
			var balance = ${balance};
			if(amount==""||account_number==""){
		 		alert("Please Enter amount & the destination account number!");
		 		return;
			}
			if(!isfloat(amount)){
				alert("Amount should only be float numbers");
				return;
			}
			if(amount > balance){
				alert("Transfer amount can not be greater than your balance");
				return;
			}
			
		// Amount should be checked here, can no greater than the balance;
		
			document.getElementById("externaltransferform").submit();
		}
		function isfloat(oNum){
	  		if(!oNum) return false;
	  		var strP=/^\d+(\.\d+)?$/;
	  		if(!strP.test(oNum)) return false;
	  		try{
	  			if(parseFloat(oNum)!=oNum) return false;
	  		}catch(ex){
	    		return false;
	  		}
	  		return true;
		}
	
	</script>

	</head>

	<body>
		${username},
		<br>
		Your Balance: $${balance}
		<br>
		<form id="externaltransferform"
			action="<%=path%>/externaltransfercommit" method="POST">
			<ul>
				<li>
					<label>
						Amount to Transfer:
						<input type="text" name="amount" id="amount" tabindex="1"
							class="inp"
							onkeypress="if(event.keyCode==13) document.all.account_number.focus();" />
					</label>
				</li>
				<li>
					<label>
						Account Number:
						<input type="text" name="account_number" id="account_number"
							tabindex="2" class="inp"
							onkeypress="if(event.keyCode==13) document.all.button.focus();" />
					</label>
				</li>
				<li>
					<input type="hidden" name="username" id="username"
						value="${username}" />
					<input type="button" name="button" id="button" value="Transfer"
						tabindex="6" class="btn" onclick="transfercheck()" />
				</li>
			</ul>
		</form>
	</body>
</html>
