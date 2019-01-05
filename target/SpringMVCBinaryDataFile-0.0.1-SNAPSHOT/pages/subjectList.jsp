<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>

<head>
<title>Spring Data</title>
</head>
<body>
	<h1>Subjects List</h1>
	<c:choose>
		<c:when test="${subjects eq null or subjects.size() eq 0}">
			<h3>No Subject Record(s) Found</h3>
		</c:when>
		<c:otherwise>
			<table border="1">
				<thead>
					<tr>
						<th>Subject#</th>
						<th>Title</th>
						<th>DurationInHours</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="e" items="${subjects}">
						<tr>
							<th>${e.subjectId}</th>
							<th>${e.subtitle }</th>
							<th>${e.durationInHours }</th>
							<td> 
							<a href="delSubject?subjectId=${e.subjectId}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>


			</table>
		</c:otherwise>
	</c:choose>
	<a href="home">Home</a>
</body>
</html>