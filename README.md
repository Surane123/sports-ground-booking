# 🏟️ Sports Ground Booking System

A Java Web Application for managing sports ground bookings using JSP, Servlets, JDBC, and Oracle Database.  
This system allows users to add, view, and list sports ground bookings through a simple web interface.

---

## 📌 Features

- Add new ground booking
- View booking by team name and date
- View all ground bookings
- Automatic Record ID generation
- Duplicate booking prevention
- Input validation with error handling
- Layered architecture (Bean → DAO → Service → Servlet)

---

## 🧱 Tech Stack

- Java
- JSP & Servlets
- JDBC
- Oracle 11g XE
- Apache Tomcat 10
- Eclipse IDE
- HTML

---

## 📂 Project Structure

com.wipro.sports  
├── bean — GroundBookingBean.java  
├── dao — GroundBookingDAO.java  
├── service — Administrator.java  
├── servlets — MainServlet.java  
├── util — DBUtil.java, InvalidInputException.java  

webapp/  
menu.html  
addGroundBooking.jsp  
viewGroundBooking.jsp  
viewAllGroundBookings.jsp  
displayGroundBooking.jsp  
displayAllGroundBookings.jsp  
success.html  
error.html  

---

## 🗄️ Database Setup

### Create Table

```sql
CREATE TABLE GROUND_BOOKING_TB(
RECORDID VARCHAR2(12) PRIMARY KEY,
TEAMNAME VARCHAR2(40) NOT NULL,
GROUNDNAME VARCHAR2(40) NOT NULL,
BOOKING_DATE DATE NOT NULL,
TIMESLOT VARCHAR2(20),
REMARKS VARCHAR2(100)
);
```

### Create Sequence

```sql
CREATE SEQUENCE GROUNDBOOK_SEQ
START WITH 10
INCREMENT BY 1
MAXVALUE 99;
```

---

## ⚙️ Configuration

Update DB credentials in DBUtil.java

```java
DriverManager.getConnection(
 "jdbc:oracle:thin:@localhost:1521:xe",
 "sportsuser",
 "sports123"
);
```

---

## ▶️ How to Run

1. Clone the repository

git clone https://github.com/yourusername/sports-ground-booking.git

2. Import into Eclipse as Dynamic Web Project

3. Add Oracle JDBC driver (ojdbc8.jar) to Tomcat/lib

4. Configure Tomcat server in Eclipse

5. Start server

6. Open browser:

http://localhost:8081/SportsGroundBooking/menu.html

---

## 🧠 Business Logic Highlights

Record ID format:

YYYYMMDD + first 2 letters of team + sequence  
Example: 20260213TI10

- Prevents duplicate booking for same team + date
- Uses layered MVC-style structure
- DAO handles all JDBC operations

---

## 🧪 Test Cases Covered

- Add booking with valid data
- Add booking with invalid input
- Duplicate booking detection
- View specific booking
- View all bookings
- Empty database handling

---

## 🚀 Future Enhancements

- User login system
- Admin dashboard
- Booking cancellation
- Time slot validation
- UI improvements
- REST API version

---

## 👨‍💻 Author

Surender R  
Java Web Application Project — JSP / Servlet / JDBC

---

## 📄 License

This project is for educational and demonstration purposes.
