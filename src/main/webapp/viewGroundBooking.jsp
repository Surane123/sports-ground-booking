<!DOCTYPE html>
<html>
<head>
<title>View Ground Booking</title>
</head>
<body>

<h2>View Ground Booking</h2>

<form action="MainServlet" method="post">

<input type="hidden" name="operation" value="viewRecord">

Team Name:
<input type="text" name="teamName" required><br><br>

Booking Date:
<input type="date" name="bookingDate" required><br><br>

<input type="submit" value="View Booking">

</form>

</body>
</html>
