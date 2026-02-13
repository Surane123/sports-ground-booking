package com.wipro.sports.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import com.wipro.sports.bean.GroundBookingBean;
import com.wipro.sports.util.DBUtil;

public class GroundBookingDAO {

    public boolean recordExists(String team, java.util.Date date) {
        try {
            Connection con = DBUtil.getDBConnection();
            PreparedStatement ps = con.prepareStatement(
                "select * from GROUND_BOOKING_TB where TEAMNAME=? and BOOKING_DATE=?");

            ps.setString(1, team);
            ps.setDate(2, new java.sql.Date(date.getTime()));

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            return false;
        }
    }

    public String generateRecordID(String team, java.util.Date date) throws Exception {
        Connection con = DBUtil.getDBConnection();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select GROUNDBOOK_SEQ.nextval from dual");
        rs.next();
        int seq = rs.getInt(1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String d = sdf.format(date);

        String code = team.substring(0,2).toUpperCase();

        return d + code + seq;
    }

    public String createRecord(GroundBookingBean b) {
        try {
            Connection con = DBUtil.getDBConnection();

            PreparedStatement ps = con.prepareStatement(
            "insert into GROUND_BOOKING_TB values(?,?,?,?,?,?)");

            ps.setString(1, b.getRecordId());
            ps.setString(2, b.getTeamName());
            ps.setString(3, b.getGroundName());
            ps.setDate(4, new java.sql.Date(b.getBookingDate().getTime()));
            ps.setString(5, b.getTimeSlot());
            ps.setString(6, b.getRemarks());

            int i = ps.executeUpdate();
            if(i>0) return b.getRecordId();

        } catch(Exception e){}

        return "FAIL";
    }

    public GroundBookingBean fetchRecord(String team, java.util.Date date) {
        try {
            Connection con = DBUtil.getDBConnection();
            PreparedStatement ps = con.prepareStatement(
            "select * from GROUND_BOOKING_TB where TEAMNAME=? and BOOKING_DATE=?");

            ps.setString(1, team);
            ps.setDate(2, new java.sql.Date(date.getTime()));

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                GroundBookingBean b = new GroundBookingBean();
                b.setRecordId(rs.getString(1));
                b.setTeamName(rs.getString(2));
                b.setGroundName(rs.getString(3));
                b.setBookingDate(rs.getDate(4));
                b.setTimeSlot(rs.getString(5));
                b.setRemarks(rs.getString(6));
                return b;
            }

        } catch(Exception e){}

        return null;
    }

    public List<GroundBookingBean> fetchAllRecords() {
        List<GroundBookingBean> list = new ArrayList<>();

        try {
            Connection con = DBUtil.getDBConnection();
            ResultSet rs = con.createStatement()
            .executeQuery("select * from GROUND_BOOKING_TB");

            while(rs.next()) {
                GroundBookingBean b = new GroundBookingBean();
                b.setRecordId(rs.getString(1));
                b.setTeamName(rs.getString(2));
                b.setGroundName(rs.getString(3));
                b.setBookingDate(rs.getDate(4));
                b.setTimeSlot(rs.getString(5));
                b.setRemarks(rs.getString(6));
                list.add(b);
            }

        } catch(Exception e){}

        return list;
    }
}
