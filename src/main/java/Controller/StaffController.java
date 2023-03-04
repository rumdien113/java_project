package Controller;

import DAO.StaffDAO;
import Model.Staff;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class StaffController {
    StaffDAO dao = new StaffDAO();
    public boolean insert(Staff s) throws Exception {
        String getID = dao.SelectLast();
        String sliceID = dao.SelectLast().substring(2, getID.length());
        String id = "NV" + (Integer.valueOf(sliceID) + 1);

        s.setId(id);
        return dao.insert(s);
    }
    public boolean update(Staff s) throws Exception {
        return dao.update(s);
    }
    public boolean Delete(String s) throws Exception {
        return dao.Delete(s);
    }
    public List<Staff> selectAll() throws Exception {
        return dao.selectAll();
    }
    public void Search(DefaultTableModel tbl, String name, String part, String status) throws Exception {
        dao.search(tbl, name, part, status);
    }
}
