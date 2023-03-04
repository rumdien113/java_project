package DAO;

import Model.Product;
import Model.Sale;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SaleDAO implements IDAO<Sale> {

    int check;
    ResultSet result;

    @Override
    public boolean insert(Sale sale) throws Exception {
        Connection connect = new DBConnect().getConnect();
        String insert = "INSERT INTO `khuyenmai`(MaKM, TenKM, LoaiKM, GiaTri, NBD, NKT, TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connect.prepareStatement(insert);

        ps.setString(1, sale.getIdSale());
        ps.setString(2, sale.getNameSale());
        ps.setString(3, sale.getTypeSale());
        ps.setInt(4, sale.getCostSale());
        ps.setString(5, sale.getStartDaySale());
        ps.setString(6, sale.getEndDaySale());
        ps.setString(7, sale.getStatusSale());
        check = ps.executeUpdate();
        return check > 0;
    }
    public boolean update(Sale s) throws Exception {
        Connection connect = new DBConnect().getConnect();
        String update = "UPDATE khuyenmai SET MaKM = ?, TenKM = ?, LoaiKM = ?, GiaTri = ?, NBD = ?, NKT = ?, TrangThai = ? WHERE MaKM = ?";
        PreparedStatement ps = connect.prepareStatement(update);
        ps.setString(1, s.getIdSale());
        ps.setString(2, s.getNameSale());
        ps.setString(3, s.getTypeSale());
        ps.setInt(4, s.getCostSale());
        ps.setString(5, s.getStartDaySale());
        ps.setString(6, s.getEndDaySale());
        ps.setString(7, s.getStatusSale());
        ps.setString(8, s.getIdSale());
        check = ps.executeUpdate();
        connect.close();
        return check > 0;
    }
    @Override
    public List<Sale> selectAll() throws Exception {
        Connection connect = new DBConnect().getConnect();
        String query = "SELECT `MaKM`, `TenKM`, `LoaiKM`, `GiaTri`, `NBD`, `NKT`, `TrangThai` FROM `khuyenmai` WHERE 1";
        PreparedStatement ps = connect.prepareStatement(query);
        ResultSet result = ps.executeQuery(query);
        List<Sale> listSale = new ArrayList<>();
        while (result.next()) {
            Sale s = new Sale(
                    result.getString("MaKM"),
                    result.getString("TenKM"),
                    result.getString("LoaiKM"),
                    result.getInt("GiaTri"),
                    result.getString("NBD"),
                    result.getString("NKT"),
                    result.getString("TrangThai")
            );
            listSale.add(s);
        }
        connect.close();
        return listSale;
    }

    @Override
    public void search(DefaultTableModel tbl, String name, String type, String status) throws Exception {

    }
    public boolean Promotion(int value, String type, String start, String end) throws Exception {
        Connection connect = new DBConnect().getConnect();
        System.out.println(value/100);
        String update = "UPDATE sanpham SET GiaSP = GiaSP - (GiaSP * " + value/100 + ") WHERE DATE(NOW()) BETWEEN '" + start + "' AND '" + end + "';";
        String update1 = "UPDATE sanpham SET GiaSP = GiaSP - " + value + " WHERE DATE(NOW()) BETWEEN '" + start + "' AND '" + end + "';";
        Statement sta = connect.createStatement();
        if (type.equals("%")) {
            check = sta.executeUpdate(update);
        } else if (type.equals("Tiền")) {
            check = sta.executeUpdate(update1);
        }
        connect.close();
        return check > 0;
    }
}
