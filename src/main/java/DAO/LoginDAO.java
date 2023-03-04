package DAO;

import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO{
    ResultSet result;
    public String selectpw(String id) throws Exception {
        Connection connect = new DBConnect().getConnect();
        String select = "SELECT MatKhau FROM `nhanvien` WHERE MaNV = ?";
        PreparedStatement ps = connect.prepareStatement(select);
        ps.setString(1, id);
        result = ps.executeQuery();
        if (result.next())
            return result.getString("MatKhau");
        result.close();
        connect.close();
        return "";
    }
    public String selectName(String id) throws Exception {
        Connection connect = new DBConnect().getConnect();
        String select = "SELECT MaNV, TenNV FROM `nhanvien` WHERE MaNV = ?";
        PreparedStatement ps = connect.prepareStatement(select);
        ps.setString(1, id);
        result = ps.executeQuery();
        if (result.next())
            return result.getString("MaNV") + result.getString("TenNV");
        result.close();
        connect.close();
        return "";
    }
}
