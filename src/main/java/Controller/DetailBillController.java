package Controller;

import DAO.DetailBillDAO;
import Model.DetailBill;
import Model.Item;

import java.util.List;

public class DetailBillController {
    private DetailBillDAO dao;
    public DetailBillController() {
        dao = new DetailBillDAO();
    }
    public boolean insert(Item item) throws Exception {
        return dao.insert(item);
    }

    public List<DetailBill> selectAll() throws Exception {
        return dao.selectAll();
    }
    public List<DetailBill> select(String id) throws Exception {
        return dao.select(id);
    }
    public int count(DetailBill detailBill) throws Exception {
        return dao.count(detailBill);
    }
    public boolean countQuantity(DetailBill detailBill) throws Exception {
        return dao.countQuantity(detailBill);
    }
    public int getSumMoney(int idHd) throws Exception {
        return dao.getSumMoney(idHd);
    }
}
