<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Contact Manager</h2>
	<form:form method="post" action="addQuestion.html">
		<table>
			<tr>
				<td><form:label path="author">Who are you?</form:label></td>
				<td><form:input path=”author” /></td>
			</tr>
			<tr>
				<td><form:label path="subject">Subject</form:label></td>
				<td><form:input path="subject" /></td>
			</tr>
			<tr>
				<td><form:label path="message">You Question</form:label></td>
				<td><form:textarea path="message" /></td>
			</tr>
			<tr>
				<td colspan=”2”><input type=”submit” value=”Submit your question”/>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>