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

		<title>Banking System</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<script type="text/javascript">
	
		function logincheck(){
	    	var w = screen.availWidth-10;
	    	var h = screen.availHeight-35;

			var j_username = document.getElementById("j_username").value;
			var j_password = document.getElementById("j_password").value;
			if(j_username==""||j_password==""){
		 		alert("Please Enter Username & Password!");
		 		return;
			}
	
		
			document.getElementById("loginform").submit();
		}
	
	</script>
	</head>

	<body>
		<form id="loginform" action="<%=path%>/login"
			method="POST">
			<ul>
				<li>
					<label>
						UserName:
						<input type="text" name="j_username" id="j_username" tabindex="1"
							class="inp"
							onkeypress="if(event.keyCode==13) document.all.j_password.focus();" />
					</label>
				</li>
				<li>
					<label>
						Password:
						<input type="password" name="j_password" id="j_password"
							tabindex="2" class="inp"
							onkeypress="if(event.keyCode==13) document.all.j_captcha_response.focus();" />
					</label>
				</li>
				<li>
					<input type="button" name="button" id="button" value="Login"
						tabindex="6" class="btn" onclick="logincheck()" />
				</li>
			</ul>
		</form>
	</body>
</html>
