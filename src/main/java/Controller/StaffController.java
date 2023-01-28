package Controller;

import DAO.StaffDAO;
import Model.Staff;

import javax.swing.table.DefaultTableModel;

public class StaffController {
    StaffDAO dao = new StaffDAO();

    public boolean insert(Staff staff) throws Exception {
        boolean check = dao.insert(staff);
        return check;
    }
//    public void Select(DefaultTableModel tbl) throws Exception {
//        dao.Select(tbl);
//    }
    public void Search(DefaultTableModel tbl, String name, String part, String status) throws Exception {
        dao.Search(tbl, name, part, status);
    }
}
