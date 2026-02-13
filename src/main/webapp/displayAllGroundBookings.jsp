<%@ page import="java.util.*,com.wipro.sports.bean.GroundBookingBean" %>

<html>
<body>

<h2>All Ground Bookings</h2>

<%
List<GroundBookingBean> list =
(List<GroundBookingBean>)request.getAttribute("list");

if(list == null || list.isEmpty()){
%>

<h3>No records available!</h3>

<%
} else {
%>

<table border="1">
<tr>
<th>ID</th>
<th>Team</th>
<th>Ground</th>
<th>Date</th>
<th>Slot</th>
<th>Remarks</th>
</tr>

<%
for(GroundBookingBean b : list){
%>

<tr>
<td><%= b.getRecordId() %></td>
<td><%= b.getTeamName() %></td>
<td><%= b.getGroundName() %></td>
<td><%= b.getBookingDate() %></td>
<td><%= b.getTimeSlot() %></td>
<td><%= b.getRemarks() %></td>
</tr>

<%
}
%>

</table>

<%
}
%>

<br>
<a href="menu.html">Back to Menu</a>

</body>
</html>
