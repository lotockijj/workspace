<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>index7.jsp</title>
</head>
<body>

	<div id='showCD'></div>
	<br>
	<input type="button" onclick="previous()" value="<<">
	<input type="button" onclick="next()" value=">>">

	<script>
		var i = 0;
		var x;
		displayCD(i);

		function displayCD(i) {
			var xmlhttp = new XMLHttpRequest();
			xmlhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					myFunction(this, i);
				}
			};
			xmlhttp.open("GET", "cd_catalog.xml", true);
			xmlhttp.send();
		}

		function myFunction(xml, i) {
			var xmlDoc = xml.responseXML;
			x = xmlDoc.getElementsByTagName("CD");
			document.getElementById("showCD").innerHTML = "Artist: "
					+ x[i].getElementsByTagName("ARTIST")[0].childNodes[0].nodeValue
					+ "<br>Title: "
					+ x[i].getElementsByTagName("TITLE")[0].childNodes[0].nodeValue
					+ "<br>Year: "
					+ x[i].getElementsByTagName("YEAR")[0].childNodes[0].nodeValue;
		}

		function next() {
			if (i < x.length - 1) {
				i++;
				displayCD(i);
			}
		}

		function previous() {
			if (i > 0) {
				i--;
				displayCD(i);
			}
		}
	</script>

</body>
</html>