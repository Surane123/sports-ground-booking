package com.wipro.sports.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.wipro.sports.bean.GroundBookingBean;
import com.wipro.sports.service.Administrator;

public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    Administrator admin = new Administrator();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String op = req.getParameter("operation");

        try {

            if ("newRecord".equals(op)) {

                GroundBookingBean b = new GroundBookingBean();
                b.setTeamName(req.getParameter("teamName"));
                b.setGroundName(req.getParameter("groundName"));

                Date d = new SimpleDateFormat("yyyy-MM-dd")
                        .parse(req.getParameter("bookingDate"));

                b.setBookingDate(d);
                b.setTimeSlot(req.getParameter("timeSlot"));
                b.setRemarks(req.getParameter("remarks"));

                String r = admin.addRecord(b);

                if (r.equals("FAIL") || r.contains("INVALID"))
                    res.sendRedirect("error.html");
                else
                    res.sendRedirect("success.html");
            }

            else if ("viewRecord".equals(op)) {

                String team = req.getParameter("teamName");

                Date d = new SimpleDateFormat("yyyy-MM-dd")
                        .parse(req.getParameter("bookingDate"));

                GroundBookingBean b = admin.viewRecord(team, d);

                req.setAttribute("bean", b);

                RequestDispatcher rd =
                        req.getRequestDispatcher("displayGroundBooking.jsp");
                rd.forward(req, res);
            }

            else if ("viewAllRecords".equals(op)) {

                List<GroundBookingBean> list = admin.viewAllRecords();

                req.setAttribute("list", list);

                req.getRequestDispatcher("displayAllGroundBookings.jsp")
                   .forward(req, res);
            }

        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("error.html");
        }
    }
}
