package DAO;

import Controller.ProductController;
import Model.Product;
import View.ViewProduct;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class ProductDAO implements IDAO<Product> {

    Product product = new Product();
    int check, cost;
    String id, name, type, status, idtmp;
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

//    @Override
//    public void Select(DefaultTableModel tbl) throws Exception {
//        Connection connect = new DBConnect().getConnect();
//        String select = "SELECT * FROM `sanpham`";
//        Statement sta = connect.createStatement();
//        result = sta.executeQuery(select);
//
//        tbl.setRowCount(0);
//
//        while ((result.next())) {
//            Object Products[] = {
//                    result.getString("MaSP"),
//                    result.getString("TenSP"),
//                    result.getString("LoaiSP"),
//                    result.getString("GiaSP"),
//                    result.getString("TrangThai")
//            };
//            tbl.addRow(Products);
//            tbl.fireTableDataChanged();
//        }
//        result.close();
//        connect.close();
//    }

    @Override
    public void Search(DefaultTableModel tbl, String name, String type, String status) throws Exception {
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
//        if (name.equals("")) result = sta.executeQuery(select2);
//        if (type.equals("Tất cả")) result = sta.executeQuery(select);
//        else result = sta.executeQuery(select1);

        tbl.setRowCount(0);

        while ((result.next())) {
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
