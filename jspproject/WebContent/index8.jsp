<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>The XMLHttpRequest Object</h1>
	<p>
		<b>Status: </b> <span id="A1"></span>
	</p>
	<p>
		<b>Status text: </b> <span id="A2"></span>
	</p>
	<p>
		<b>Response: </b> <span id="A3"></span>
	</p>
	<button onclick="loadDoc('note.xml')">Get XML data</button>
	<script type="text/javascript">
		function loadDoc(url) {
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					document.getElementById('A1').innerHTML = this.status;
					document.getElementById('A2').innerHTML = this.statusText;
					document.getElementById('A3').innerHTML = this.responseText;
				}
			};
			xhttp.open("GET", url, true);
			xhttp.send();
		}
	</script>
</body>
</html>