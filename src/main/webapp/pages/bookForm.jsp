<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>

<head>
<title>Spring Data</title>
</head>
<body>
	<h1>Book Form</h1>
	<a href="home">Home</a>
	<form:form action="bookForm" method="POST" modelAttribute="book">
		<table>

			<tr>
				<td><form:label path="bookId">Book Id</form:label></td>

				<td><form:input path="bookId" /> <form:errors path="bookId" /></td>
			</tr>

			<tr>
				<td><form:label path="title">Book Title</form:label></td>
				<td><form:input path="title" /> <form:errors path="title" />
				</td>
			</tr>

			<tr>
				<td><form:label path="price">Book Price</form:label></td>
				<td><form:input path="price" /> <form:errors path="price" /></td>
			</tr>

			<tr>
				<td><form:label path="publishDate">Book Publish Date</form:label></td>
				<td><form:input path="publishDate" type="date" /></td>
			</tr>
			<tr>
				<td><form:label path="volume">Book Volume</form:label></td>
				<td><form:input path="volume" /> <form:errors path="volume" /></td>
			</tr>

			<tr>
				<td colspan="2" style="text-align: right">
					<button>Save</button>
				</td>
			</tr>

		</table>
	</form:form>


	<a href="bookForm"> New Book</a>
	<a href="home">Home</a>
</body>
</html>