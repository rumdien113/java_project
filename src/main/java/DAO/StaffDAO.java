package DAO;

import Model.Staff;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StaffDAO implements IDAO<Staff>{
    Staff staff = new Staff();
//    String id, name, sex, birth, mail, sdt, part, status;
    int check;
    ResultSet result;

    public boolean insert(Staff s) throws Exception {
//        System.out.println(s.toString());
        Connection connect = new DBConnect().getConnect();
        String insert = "INSERT INTO `nhanvien`(`MaNV`, `TenNV`, `GioiTinh`, `NgaySinh`, `Email`, `Sdt`, `ChucVu`, `TrangThai`, `Luong`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = connect.prepareStatement(insert);

            ps.setString(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getSex());
            ps.setString(4, s.getBirth());
            ps.setString(5, s.getMail());
            ps.setString(6, s.getSdt());
            ps.setString(7, s.getPart());
            ps.setString(8, s.getStatus());
            ps.setInt(9, s.getSalary());
            check = ps.executeUpdate();
        return check > 0;
    }

//    @Override
//    public void Select(DefaultTableModel tbl) throws Exception {
//        Connection connect = new DBConnect().getConnect();
//        String query = "Select `MaNV`, `TenNV`, `GioiTinh`, `NgaySinh`, `Email`, `Sdt`, `ChucVu`, `TrangThai` from nhanvien";
//        Statement sta = connect.createStatement();
//        result = sta.executeQuery(query);
//
//        tbl.setRowCount(0);
//
//        while (result.next()) {
//            Object Staffs[] = {
//                    result.getString("MaNV"),
//                    result.getString("TenNV"),
//                    result.getString("GioiTinh"),
//                    result.getString("NgaySinh"),
//                    result.getString("Email"),
//                    result.getString("Sdt"),
//                    result.getString("ChucVu"),
//                    result.getString("TrangThai")
//            };
//            tbl.addRow(Staffs);
//            tbl.fireTableDataChanged();
//        }
//        result.close();
//        connect.close();
//    }

    @Override
    public void Search(DefaultTableModel tbl, String name, String part, String status) throws Exception {
        Connection connect = new DBConnect().getConnect();
        String select = "SELECT * FROM nhanvien";
        String select1 = "SELECT * FROM nhanvien WHERE TrangThai = '" + status + "'";
        String select2 = "SELECT * FROM nhanvien WHERE ChucVu = '" + part + "'";
        String select3 = "SELECT * FROM nhanvien WHERE ChucVu = '" + part + "' and TrangThai = '" + status + "'";
        String select4 = "SELECT * FROM nhanvien WHERE TenNV = '" + name + "'";

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
//        if (name.equals("")) result = sta.executeQuery(select2);
//        if (type.equals("Tất cả")) result = sta.executeQuery(select);
//        else result = sta.executeQuery(select1);

        tbl.setRowCount(0);

        while ((result.next())) {
            Object Staffs[] = {
                    result.getString("MaNV"),
                    result.getString("TenNV"),
                    result.getString("GioiTinh"),
                    result.getString("NgaySinh"),
                    result.getString("Email"),
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
