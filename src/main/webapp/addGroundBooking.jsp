<!DOCTYPE html>
<html>
<head>
<title>Add Ground Booking</title>
</head>
<body>

<h2>Add Ground Booking</h2>

<form action="MainServlet" method="post">

<input type="hidden" name="operation" value="newRecord">

Team Name:
<input type="text" name="teamName" required><br><br>

Ground Name:
<input type="text" name="groundName" required><br><br>

Booking Date:
<input type="date" name="bookingDate" required><br><br>

Time Slot:
<input type="text" name="timeSlot"><br><br>

Remarks:
<input type="text" name="remarks"><br><br>

<input type="submit" value="Add Booking">

</form>

</body>
</html>
