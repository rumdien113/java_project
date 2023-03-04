package DAO;

import Model.Bill;
import View.ViewSell;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class BillDAO implements IDAO<Bill>{
    int check;
    String insert;
    ResultSet result;

    @Override
    public boolean insert(Bill bill) throws Exception {
        Connection connect = new DBConnect().getConnect();
        insert = "INSERT INTO `hoadon` (`MaHD`, `MaNV`, `TenNV`, `NgayXuatHD`, `LoaiThanhToan`, `TongTien`, `TrangThai`) VALUES (?, ?, ?, ?, ?, ?, 'Chưa thanh toán')";
        PreparedStatement ps = connect.prepareStatement(insert);
        ps.setInt(1, bill.getIdBill());
        ps.setString(2, bill.getIdStaff());
        ps.setString(3, bill.getNamestaff());
        ps.setString(4, bill.getDateBill());
        ps.setString(5, bill.getTypePay());
        ps.setInt(6, bill.getTotalMoney());
        check = ps.executeUpdate();
        return check > 0;
    }
    @Override
    public List<Bill> selectAll() throws Exception {
        Connection connect = new DBConnect().getConnect();
        String select = "SELECT MaHD FROM hoadon WHERE TrangThai = 'Chưa thanh toán'";
        PreparedStatement ps = connect.prepareStatement(select);
        ResultSet result = ps.executeQuery(select);
        List<Bill> ListBill = new ArrayList<>();
        while (result.next()) {
            Bill b = new Bill(
                    result.getInt(1)
            );
            ListBill.add(b);
        }
        connect.close();
        result.close();
        return ListBill;
    }
    public List<Bill> select() throws Exception {
        Connection connect = new DBConnect().getConnect();
        String select = "SELECT * FROM `hoadon` WHERE 1";
        PreparedStatement ps = connect.prepareStatement(select);
        result = ps.executeQuery(select);
        List<Bill> list = new ArrayList<>();
        while(result.next()) {
            Bill b = new Bill(
                    result.getInt("MaHD"),
                    result.getString("TenNV"),
                    result.getString("NgayXuatHD"),
                    result.getString("LoaiThanhToan"),
                    result.getInt("TongTien"),
                    result.getString("TrangThai")
            );
            list.add(b);
        }
        result.close();
        connect.close();
        return list;
    }
    public Integer selectLast() throws Exception {
        Connection connect = new DBConnect().getConnect();
        String select = "SELECT MaHD FROM `hoadon` ORDER BY MaHD DESC LIMIT 1";
        PreparedStatement ps = connect.prepareStatement(select);
        result = ps.executeQuery();
        if (result.next())
            return result.getInt("MaHD");
        result.close();
        connect.close();
        return 0;
    }
    public boolean delete(Integer id) throws Exception {
        Connection connect = new DBConnect().getConnect();
        String delete = "DELETE FROM `hoadon` WHERE MaHD = ?";
        PreparedStatement ps = connect.prepareStatement(delete);
        ps.setInt(1, id);
        check = ps.executeUpdate();
        connect.close();
        return check > 0;
    }
    @Override
    public void search(DefaultTableModel tbl, String name, String type, String status) throws Exception {

    }
    public boolean updateBill(Bill bill) throws Exception{
        Connection connect = new DBConnect().getConnect();
        String update = "UPDATE hoadon SET MaNV = ?, TenNV = ?, NgayXuatHD = ?, LoaiThanhToan = ?, TongTien = ?, TrangThai = 'Đã thanh toán' WHERE MaHD = ?";
        PreparedStatement ps = connect.prepareStatement(update);
        ps.setString(1, bill.getIdStaff());
        ps.setString(2, bill.getNamestaff());
        ps.setString(3, bill.getDateBill());
        ps.setString(4, bill.getTypePay());
        ps.setInt(5, bill.getTotalMoney());
        ps.setInt(6, bill.getIdBill());
        check = ps.executeUpdate();
        connect.close();
        return check > 0;
    }

    public int selectSumMoney(String day) throws Exception {
        Connection connect = new DBConnect().getConnect();
        String select = "";
        switch (day) {
            case "today":
                select = "SELECT SUM(TongTien) FROM hoadon WHERE DATE(NOW()) = CURDATE();";
                break;
            case "week":
                select = "SELECT SUM(TongTien) FROM hoadon WHERE NOW() >= DATE_SUB(CURDATE(), INTERVAL 7 DAY);";
                break;
            case "month":
                select = "SELECT SUM(TongTien) FROM hoadon WHERE NOW() >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH);";
                break;
        }
        PreparedStatement ps = connect.prepareStatement(select);
        result = ps.executeQuery();
        if (result.next())
            return result.getInt("SUM(TongTien)");
        connect.close();
        result.close();
        return 0;
    }
    public int selectMoneyDayToDay(String start, String end) throws Exception {
        Connection connect = new DBConnect().getConnect();
        String select = "SELECT SUM(TongTien) FROM hoadon WHERE DATE(NOW()) BETWEEN ? AND ?";
        PreparedStatement ps = connect.prepareStatement(select);
        System.out.println(start);
        System.out.println(end);
        ps.setString(1, start);
        ps.setString(2, end);
        result = ps.executeQuery();
        if (result.next())
            return result.getInt("SUM(TongTien)");
        connect.close();
        result.close();
        return 0;
    }
    public int selectBill(String day) throws Exception {
        Connection connect = new DBConnect().getConnect();
        String select = "";
        switch (day) {
            case "today":
                select = "SELECT COUNT(MaHD) FROM hoadon WHERE DATE(NOW()) = CURDATE()";
                break;
            case "week":
                select = "SELECT COUNT(MaHD) FROM hoadon WHERE NOW() >= DATE_SUB(CURDATE(), INTERVAL 7 DAY);";
                break;
            case "month":
                select = "SELECT COUNT(MaHD) FROM hoadon WHERE NOW() >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH);";
                break;
        }
        PreparedStatement ps = connect.prepareStatement(select);
        result = ps.executeQuery();
        if (result.next())
            return result.getInt("COUNT(MaHD)");
        connect.close();
        result.close();
        return 0;
    }
    public int selectBillDayToDay(String start, String end) throws Exception {
        Connection connect = new DBConnect().getConnect();
        String select = "SELECT COUNT(MaHD) FROM hoadon WHERE DATE(NOW()) BETWEEN ? AND ?";
        PreparedStatement ps = connect.prepareStatement(select);
        ps.setString(1, start);
        ps.setString(2, end);
        result = ps.executeQuery();
        if (result.next())
            return result.getInt("COUNT(MaHD)");
        connect.close();
        result.close();
        return 0;
    }
}
