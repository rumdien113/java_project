package Controller;

import DAO.SaleDAO;
import Model.Sale;

import java.util.List;

public class SaleController {
    SaleDAO dao = new SaleDAO();

    public boolean insert(Sale sale) throws Exception {
        boolean check = dao.insert(sale);
        return check;
    }
    public boolean update(Sale s) throws Exception {
        return dao.update(s);
    }
    public boolean Promotion(int value, String type, String start, String end) throws Exception {
        return dao.Promotion(value, type, start, end);
    }
    public List<Sale> selectAll() throws Exception {
        return dao.selectAll();
    }
}
