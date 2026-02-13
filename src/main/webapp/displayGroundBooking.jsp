<%@ page import="com.wipro.sports.bean.GroundBookingBean" %>

<html>
<body>

<h2>Ground Booking Details</h2>

<%
GroundBookingBean b =
(GroundBookingBean) request.getAttribute("bean");

if(b == null){
%>

<h3>No matching records exists! Please try again!</h3>

<%
} else {
%>

Record ID: <%= b.getRecordId() %><br><br>
Team Name: <%= b.getTeamName() %><br><br>
Ground Name: <%= b.getGroundName() %><br><br>
Booking Date: <%= b.getBookingDate() %><br><br>
Time Slot: <%= b.getTimeSlot() %><br><br>
Remarks: <%= b.getRemarks() %><br><br>

<%
}
%>

<a href="menu.html">Back to Menu</a>

</body>
</html>
