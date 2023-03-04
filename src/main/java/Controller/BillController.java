package Controller;

import DAO.BillDAO;
import Model.Bill;

import java.util.List;

public class BillController {
    BillDAO dao = new BillDAO();

    public boolean insert(Bill bill) throws Exception {
        if (dao.selectLast().equals("")) {
            bill.setIdBill(1);
        } else {
            int getID = dao.selectLast();
            int id = getID + 1;
            bill.setIdBill(id);
            bill.setTypePay("Chưa thanh toán");
            bill.setTotalMoney(0);
        }
        return dao.insert(bill);
    }
    public Integer selectLast() throws Exception {
        return dao.selectLast();
    }
    public boolean delete(Integer id) throws Exception {
        return dao.delete(id);
    }
    public boolean update(Bill bill) throws Exception {
        return dao.updateBill(bill);
    }
    public List<Bill> selectAll() throws Exception {
        return dao.selectAll();
    }
    public List<Bill> select() throws Exception {
        return dao.select();
    }
    public int selectSumMoney(String day) throws Exception {
        return dao.selectSumMoney(day);
    }
    public int selectMoneyDayToDay(String start, String end) throws Exception {
        return dao.selectMoneyDayToDay(start, end);
    }
    public int selectBill(String day) throws Exception {
        return dao.selectBill(day);
    }
    public int selectBillDayToDay(String start, String end) throws Exception {
        return dao.selectBillDayToDay(start, end);
    }
}
