package View;

import Controller.BillController;
import Controller.DetailBillController;
import Model.DetailBill;
import Model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ItemBill extends JButton implements ActionListener {
    DetailBillController dbC = new DetailBillController();
    public static int id = 1, sum = 0;
    List<DetailBill> list;
    BillController bC = new BillController();
    JButton sub;
    JLabel nametag;
    public ItemBill(DefaultTableModel tbl, String MaHD) {
        this.setBackground(new Color(189, 107, 9));
        this.setForeground(Color.WHITE);
//        this.setBorder(BorderFactory.createLineBorder(new Color(189,107,9), 10));
        this.setPreferredSize(new Dimension(70, 30));
        this.setLayout(null);
        this.setName(MaHD);

        nametag = new JLabel(MaHD);
        nametag.setFont(new Font("Tahoma", Font.PLAIN, 15));
        nametag.setForeground(Color.white);
        nametag.setBounds(4, 3, 40, 20);

        sub = new JButton("x");
        sub.setBackground(null);
        sub.setForeground(Color.WHITE);
        sub.setBorder(null);
        sub.setPreferredSize(new Dimension(20, 20));
        sub.setBounds(40, 3, 25, 20);
        sub.setFocusPainted(false);
        sub.addActionListener(this);

        id = Integer.valueOf(nametag.getText().substring(2));
        ViewSell.idHd = id;

        this.add(sub);
        this.add(nametag);
        this.setVisible(true);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                id = Integer.valueOf(nametag.getText().substring(2));
                ViewSell.idHd = id;
                try {
                    showDetailBill(tbl);
                    ViewSell.sumMoneyTf = sum;
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public void showDetailBill(DefaultTableModel tbl) throws Exception {
        tbl.setRowCount(0);
        list = dbC.selectAll();
        // SQL laays tong ra
        sum = 0;
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
            sum += d.getMoney();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sub) {
            try {
                bC.delete(id);
                this.setVisible(false);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
