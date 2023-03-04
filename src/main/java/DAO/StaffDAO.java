package DAO;

import Model.Staff;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class StaffDAO implements IDAO<Staff>{
    int check;
    ResultSet result;

    public boolean insert(Staff s) throws Exception {
        Connection connect = new DBConnect().getConnect();
        String insert = "INSERT INTO `nhanvien`(`MaNV`, `TenNV`, `GioiTinh`, `NgaySinh`, `Email`, `Sdt`, `ChucVu`, `TrangThai`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = connect.prepareStatement(insert);
        ps.setString(1, s.getId());
        ps.setString(2, s.getName());
        ps.setString(3, s.getSex());
        ps.setString(4, s.getBirth());
        ps.setString(5, s.getMail());
        ps.setString(6, s.getSdt());
        ps.setString(7, s.getPart());
        ps.setString(8, s.getStatus());
        check = ps.executeUpdate();
        connect.close();
        return check > 0;
    }
    public boolean update(Staff s) throws Exception {
        Connection connect = new DBConnect().getConnect();
        String update = "UPDATE nhanvien SET MaNV = ?, TenNV = ?, GioiTinh = ?, NgaySinh = ?, Email = ?, Sdt = ?, ChucVu =  ?, TrangThai = ? WHERE nhanvien.MaNV = ?";
        PreparedStatement ps = connect.prepareStatement(update);
        ps.setString(1, s.getId());
        ps.setString(2, s.getName());
        ps.setString(3, s.getSex());
        ps.setString(4, s.getBirth());
        ps.setString(5, s.getMail());
        ps.setString(6, s.getSdt());
        ps.setString(7, s.getPart());
        ps.setString(8, s.getStatus());
        ps.setString(9, s.getId());
        check = ps.executeUpdate();
        connect.close();
        return check > 0;
    }
    public Boolean Delete(String s) throws Exception {
        Connection connect = new DBConnect().getConnect();
        String delete = "DELETE FROM nhanvien WHERE MaNV = ?";
        PreparedStatement ps = connect.prepareStatement(delete);
        ps.setString(1, s);
        check = ps.executeUpdate();
        connect.close();
        return check > 0;
    }
    public String SelectLast() throws Exception{
        Connection connect = new DBConnect().getConnect();
        String query = "SELECT MaNV FROM `nhanvien` ORDER BY MaNV DESC LIMIT 1";
        PreparedStatement ps = connect.prepareStatement(query);
        result = ps.executeQuery();
        result.next();
        String ans = result.getString("MaNV");
        result.close();
        connect.close();
        return ans;
    }
    @Override
    public List<Staff> selectAll() throws Exception {
        Connection connect = new DBConnect().getConnect();
        String query = "Select `MaNV`, `TenNV`, `GioiTinh`, `NgaySinh`, `Email`, `Sdt`, `ChucVu`, `TrangThai` from nhanvien WHERE 1";
        PreparedStatement ps = connect.prepareStatement(query);
        ResultSet result = ps.executeQuery(query);
        List<Staff> listStaff = new ArrayList<>();
        while (result.next()) {
            Staff s = new Staff(
                    result.getString("MaNV"),
                    result.getString("TenNV"),
                    result.getString("GioiTinh"),
                    result.getString("NgaySinh"),
                    result.getString("Email"),
                    result.getString("Sdt"),
                    result.getString("ChucVu"),
                    result.getString("TrangThai")
            );
            listStaff.add(s);
        }
        connect.close();
        return listStaff;
    }
    @Override
    public void search(DefaultTableModel tbl, String name, String part, String status) throws Exception {
        Connection connect = new DBConnect().getConnect();
        String select = "SELECT `MaNV`, `TenNV`, `Sdt`, `ChucVu`, `TrangThai` FROM nhanvien";
        String select1 = "SELECT `MaNV`, `TenNV`, `Sdt`, `ChucVu`, `TrangThai` FROM nhanvien WHERE TrangThai = '" + status + "'";
        String select2 = "SELECT `MaNV`, `TenNV`, `Sdt`, `ChucVu`, `TrangThai` FROM nhanvien WHERE ChucVu = '" + part + "'";
        String select3 = "SELECT `MaNV`, `TenNV`, `Sdt`, `ChucVu`, `TrangThai` FROM nhanvien WHERE ChucVu = '" + part + "' and TrangThai = '" + status + "'";
        String select4 = "SELECT `MaNV`, `TenNV`, `Sdt`, `ChucVu`, `TrangThai` FROM nhanvien WHERE TenNV = '" + name + "'";

        Statement sta = connect.createStatement();
        if (name.equals("")) {
            if (part.equals("Tất cả")) {
                if (status.equals("Tất cả"))
                    result = sta.executeQuery(select);
                else result = sta.executeQuery(select1);
            } else if (status.equals("Tất cả"))
                result = sta.executeQuery(select2);
            else result = sta.executeQuery(select3);
        } else result = sta.executeQuery(select4);

        tbl.setRowCount(0);

        while ((result.next())) {
            Object Staffs[] = {
                    result.getString("MaNV"),
                    result.getString("TenNV"),
                    result.getString("Sdt"),
                    result.getString("ChucVu"),
                    result.getString("TrangThai")
            };
            tbl.addRow(Staffs);
            tbl.fireTableDataChanged();
        }
        result.close();
        connect.close();
    }
}
