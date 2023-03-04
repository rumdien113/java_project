package DAO;

import Model.Product;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class ProductDAO implements IDAO<Product> {
    int check;
    ResultSet result;
    @Override
    public boolean insert(Product product) throws Exception {
        // SQL Insert
        Connection connect = new DBConnect().getConnect();
        String insert = "INSERT INTO `sanpham`(`MaSP`, `TenSP`, `LoaiSP`, `GiaSP`, `TrangThai`) VALUES (? ,? ,? ,? ,?)";
        PreparedStatement ps = connect.prepareStatement(insert);
        ps.setString(1, product.getId());
        ps.setString(2, product.getName());
        ps.setString(3, product.getType());
        ps.setInt(4, product.getCost());
        ps.setString(5, product.getStatus());
        check = ps.executeUpdate();
        return check > 0;
    }
    public boolean update(Product p) throws Exception {
        Connection connect = new DBConnect().getConnect();
        String update = "UPDATE sanpham SET MaSP = ?, TenSP = ?, LoaiSP = ?, GiaSP = ?, TrangThai = ? WHERE MaSP = ?";
        PreparedStatement ps = connect.prepareStatement(update);
        ps.setString(1, p.getId());
        ps.setString(2, p.getName());
        ps.setString(3, p.getType());
        ps.setInt(4, p.getCost());
        ps.setString(5, p.getStatus());
        ps.setString(6, p.getId());
        check = ps.executeUpdate();
        connect.close();
        return check > 0;
    }
    public boolean delete(String id) throws Exception {
        Connection connect = new DBConnect().getConnect();
        String delete = "DELETE FROM sanpham WHERE MaSP = ?";
        PreparedStatement ps = connect.prepareStatement(delete);
        ps.setString(1, id);
        check = ps.executeUpdate();
        connect.close();
        return check > 0;
    }
    @Override
    public List<Product> selectAll() throws Exception {
        Connection connect = new DBConnect().getConnect();
        String select = "SELECT * FROM `sanpham` WHERE 1";
        PreparedStatement ps = connect.prepareStatement(select);
        ResultSet result = ps.executeQuery(select);
        List<Product> listProduct = new ArrayList<>();
        while(result.next()) {
            Product p = new Product(
                    result.getString("MaSP"),
                    result.getString("TenSP"),
                    result.getString("LoaiSP"),
                    result.getInt("GiaSP"),
                    result.getString("TrangThai")
            );
            listProduct.add(p);
        }
        connect.close();
        return listProduct;
    }
    public String selectLast() throws Exception{
        Connection connect = new DBConnect().getConnect();
        String query = "SELECT MaSP FROM `sanpham` ORDER BY MaSP DESC LIMIT 1";
        PreparedStatement ps = connect.prepareStatement(query);
        result = ps.executeQuery();
        result.next();
        String ans = result.getString("MaSP");
        result.close();
        connect.close();
        return ans;
    }
    @Override
    public void search(DefaultTableModel tbl, String name, String type, String status) throws Exception {
        Connection connect = new DBConnect().getConnect();
        String select = "SELECT * FROM sanpham";
        String select1 = "SELECT * FROM sanpham WHERE TrangThai = '" + status + "'";
        String select2 = "SELECT * FROM sanpham WHERE LoaiSP = '" + type + "'";
        String select3 = "SELECT * FROM sanpham WHERE LoaiSP = '" + type + "' and TrangThai = '" + status + "'";
        String select4 = "SELECT * FROM sanpham WHERE TenSP = '" + name + "'";

        Statement sta = connect.createStatement();
        if (name.equals("")) {
            if (type.equals("Tất cả")) {
                if (status.equals("Tất cả"))
                    result = sta.executeQuery(select);
                else result = sta.executeQuery(select1);
            } else if (status.equals("Tất cả"))
                result = sta.executeQuery(select2);
                    else result = sta.executeQuery(select3);
        } else result = sta.executeQuery(select4);

        tbl.setRowCount(0);

        while (result.next()) {
            Object Products[] = {
                    result.getString("MaSP"),
                    result.getString("TenSP"),
                    result.getString("LoaiSP"),
                    result.getString("GiaSP"),
                    result.getString("TrangThai")
            };
            tbl.addRow(Products);
            tbl.fireTableDataChanged();
        }
        result.close();
        connect.close();
    }

}
