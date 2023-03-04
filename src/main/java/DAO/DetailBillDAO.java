package DAO;

import Model.DetailBill;
import Model.Item;
import View.ViewSell;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class DetailBillDAO{
    int check;
    public boolean insert(Item item) throws Exception {
        Connection connect = new DBConnect().getConnect();
        String insert = "INSERT INTO `cthoadon`(`MaSP`, `MaHD`, `TenSP`, `DonGia`, `SoLuong`, `ThanhTien`) VALUES (?, ?, ?, ? ,? ,?)";
        PreparedStatement ps = connect.prepareStatement(insert);
        ps.setString(1, item.getId());
        ps.setInt(2, item.getMaHD());
        ps.setString(3, item.getName());
        ps.setInt(4, item.getCost());
        ps.setInt(5, item.getQuantity());
        ps.setInt(6, item.getAmount());
        check = ps.executeUpdate();
        return check > 0;
    }
    public List<DetailBill> selectAll() throws Exception {
        Connection connect = new DBConnect().getConnect();
        String select = "SELECT * FROM cthoadon WHERE MaHD = " + ViewSell.idHd;
        PreparedStatement ps = connect.prepareStatement(select);
        ResultSet result = ps.executeQuery(select);
        List<DetailBill> listDetailBill = new ArrayList<>();
        while(result.next()) {
            DetailBill d = new DetailBill(
                    result.getString("MaSP"),
                    result.getString("TenSP"),
                    result.getInt("SoLuong"),
                    result.getInt("DonGia"),
                    result.getInt("SoLuong") * result.getInt("DonGia")
            );
            listDetailBill.add(d);
        }
        connect.close();
        return listDetailBill;
    }
    public List<DetailBill> select(String id) throws Exception {
        Connection connect = new DBConnect().getConnect();
        String select = "SELECT * FROM `cthoadon` WHERE `MaHD` = " + id + ";";
        PreparedStatement ps = connect.prepareStatement(select);
//        ps.setString(1, id);
        ResultSet result = ps.executeQuery(select);
        List<DetailBill> list = new ArrayList<>();
        while(result.next()) {
            DetailBill d = new DetailBill(
                result.getString("MaSP"),
                result.getString("TenSP"),
                result.getInt("DonGia"),
                result.getInt("SoLuong"),
                result.getInt("ThanhTien")
            );
            list.add(d);
        }
        connect.close();
        result.close();
        return list;
    }
    public int count(DetailBill detailBill) throws Exception {
        Connection connect = new DBConnect().getConnect();
        String query = "SELECT SoLuong FROM `cthoadon` WHERE MaSP = ? and MaHD = ?;";
        PreparedStatement ps = connect.prepareStatement(query);
        ps.setString(1, detailBill.getIdProduct());
        ps.setInt(2, detailBill.getIdBill());
        ResultSet result = ps.executeQuery();
        if (result.next())
            return result.getInt("SoLuong");
        result.close();
        connect.close();
        return 0;
    }
    public boolean countQuantity(DetailBill detailBill) throws Exception {
        Connection connect = new DBConnect().getConnect();
        String update = "UPDATE cthoadon SET SoLuong = SoLuong + 1, ThanhTien = SoLuong * DonGia WHERE MaHD = ? and MaSP = ?;";
        PreparedStatement ps = connect.prepareStatement(update);
        ps.setInt(1, detailBill.getIdBill());
        ps.setString(2, detailBill.getIdProduct());
        check = ps.executeUpdate();
        connect.close();
        return check > 0;
    }
    public int getSumMoney(int idHd) throws Exception {
        Connection connect = new DBConnect().getConnect();
        String select = "SELECT SUM(ThanhTien) AS TongTien FROM cthoadon WHERE MaHD = ?;";
        PreparedStatement ps = connect.prepareStatement(select);
        ps.setInt(1, idHd);
        ResultSet result = ps.executeQuery();
        if(result.next()) {
            return result.getInt("TongTien");
        }
        return 0;
    }
}
