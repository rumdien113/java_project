package View;

import Controller.DetailBillController;
import Controller.ItemController;
import DAO.DBConnect;
import Model.DetailBill;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Item extends JButton {
    ItemController iC = new ItemController();
    DetailBillController dbC = new DetailBillController();
    JLabel pic, text, desc;
    int quantity = 1;
    public static Integer MaHD;
    public Item(String idSP, String name, int cost, DefaultTableModel tbl) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setSize(120, 250);
        this.setBackground(new Color(189,107,9));
        this.setBorder(BorderFactory.createLineBorder(new Color(189,107,9), 10));
        this.setName(idSP);

        pic = new JLabel(new ImageIcon("D:\\CafeDev\\src\\main\\java\\Image\\product\\Bacxiu.jpg"));
//        pic.setBounds(5, 5, 50, 50);

        text = new JLabel(name);
        text.setBounds(5, 60, 50, 20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Tahoma", Font.BOLD, 13));
//        text.setIconTextGap(-20);

        desc = new JLabel(String.valueOf(cost));
//        desc.setBounds(5, 75, 50, 20);
        desc.setFont(new Font("Tahoma", Font.BOLD, 13));
        desc.setForeground(Color.WHITE);

        this.add(pic);
        this.add(text);
        this.add(desc);
        this.setVisible(true);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Boolean check;
                MaHD = ViewSell.idHd;
                Model.Item item = new Model.Item(MaHD, idSP, name, cost, quantity, cost*quantity);
                Model.DetailBill detailBill = new Model.DetailBill(idSP, MaHD);
                try {
                    if (dbC.count(detailBill) == 0)
                        check = dbC.insert(item); //nếu bằng 0 thì thêm sp
                    else
                        check = dbC.countQuantity(detailBill); //nếu có rồi thì update soluong
                    if (check)
                        JOptionPane.showMessageDialog(null, "Thêm thành công");
                    dbC.getSumMoney(MaHD); //này muốn cập nhật lại cái bảng thông tin nhưng bị sai logic :)))
//                    showDetailBill(tbl); //hiển thị bảng nhưng đang bị shy
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public void showDetailBill(DefaultTableModel tbl) throws Exception {
        tbl.setRowCount(0);
        List<DetailBill> list = dbC.selectAll();
        System.out.println("Hello LOL");
        for (DetailBill d : list) {
            Object DetailBill[] = {
                    d.getIdProduct(),
                    d.getNameProduct(),
                    d.getQuantity(),
                    d.getCost(),
                    d.getMoney()
            };
            tbl.addRow(DetailBill);
            tbl.fireTableDataChanged();
        }
    }
}
