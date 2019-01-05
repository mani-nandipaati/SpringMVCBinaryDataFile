<html>
<head>
<title>Spring MVC Project for Books and Subjects</title>
</head>
<body>
	<h1>A simple Spring MVC</h1>
	<p style="color:green;">
	${ message }
	</p>
	<a href="bookForm"> New Book</a>
	<br>
	<form action="search" method="post">
	Please select search type
	<input type="radio" name="searchType" value="book" checked="checked">Book
	<input type="radio" name="searchType" value="subject">Subject
	<br><br>
	Enter Id to search: <input type="text" name="id">
	<br><br>
	<input type="submit" value="submit">
	</form>
</body>
</html>