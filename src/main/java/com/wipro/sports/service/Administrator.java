package com.wipro.sports.service;

import java.util.*;

import com.wipro.sports.bean.GroundBookingBean;
import com.wipro.sports.dao.GroundBookingDAO;
import com.wipro.sports.util.InvalidInputException;

public class Administrator {

    GroundBookingDAO dao = new GroundBookingDAO();

    public String addRecord(GroundBookingBean b) {

        try {
            if(b==null || b.getTeamName()==null || b.getBookingDate()==null)
                throw new InvalidInputException();

            if(b.getTeamName().length()<2)
                return "INVALID TEAM NAME";

            if(dao.recordExists(b.getTeamName(), b.getBookingDate()))
                return "ALREADY EXISTS";

            String id = dao.generateRecordID(
                b.getTeamName(), b.getBookingDate());

            b.setRecordId(id);
            return dao.createRecord(b);

        } catch(Exception e) {
            return "INVALID INPUT";
        }
    }

    public GroundBookingBean viewRecord(String team, Date d) {
        return dao.fetchRecord(team, d);
    }

    public List<GroundBookingBean> viewAllRecords() {
        return dao.fetchAllRecords();
    }
}
