package DAO;

import Model.Item;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ItemDAO implements IDAO<Item> {

    int check;
    ResultSet result;

    @Override
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

    @Override
    public List<Item> selectAll() throws Exception {
        return null;
    }

//    @Override
//    public String SelectLast() throws Exception {
//        return "0";
//    }

    @Override
    public void search(DefaultTableModel tbl, String name, String type, String status) throws Exception {

    }
}
