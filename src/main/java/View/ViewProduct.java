package View;

import Controller.ProductController;
import DAO.DBConnect;
import Model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.*;
import java.util.List;

public class ViewProduct extends JPanel implements ActionListener {

    ViewSell viewSell = new ViewSell();
    ProductController pdC = new ProductController();
    JPanel info, list;
    JLabel picturelb, idlb, namelb, typelb, moneylb, definelb, notelb, statuslb,
           list_namelb, list_typelb, list_statuslb;
    JTextField idtf, nametf, costtf, definetf, notetf,
               list_nametf;
    JComboBox typecb, statuscb, list_typecb, list_statuscb;
    JButton addbtn, updatebtn, deletebtn, search;
    JScrollPane listScroll;
    JTable listTableProduct;
    Font font= new Font("Tahoma", Font.BOLD, 20);
    DefaultTableModel tbl = new DefaultTableModel();
    String id,  name, type, status, idtmp;
    int cost;
    public ViewProduct() {
        this.setLayout(new BorderLayout());

        info = new JPanel();
        info.setBackground(new Color(255,248,220));
        info.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        info.setPreferredSize(new Dimension(650, 1025));
        info.setLayout(null);

        picturelb = new JLabel();
        picturelb.setBounds(200, 10, 150, 150);
        picturelb.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        picturelb.setBackground(Color.green);
        picturelb.setOpaque(true);

        idlb = new JLabel("Mã sản phẩm:");
        idlb.setFont(font);
        idlb.setBounds(20, 170, 150, 25);

        idtf = new JTextField();
        idtf.setBounds(200, 170, 370, 25);

        namelb = new JLabel("Tên sản phẩm:");
        namelb.setFont(font);
        namelb.setBounds(20, 220, 150, 25);

        nametf = new JTextField();
        nametf.setBounds(200, 220, 370, 25);

        typelb = new JLabel("Loại sản phẩm:");
        typelb.setFont(font);
        typelb.setBounds(20, 280, 170, 25);

        typecb = new JComboBox<>(new String[] {"Tất cả", "Trà trái cây", "Đá xay", "Bánh", "Cafe"});
        typecb.setBounds(200, 280, 370, 25);
        typecb.setFont(new Font("Tahoma", Font.BOLD, 15));

        moneylb = new JLabel("Đơn giá:");
        moneylb.setFont(font);
        moneylb.setBounds(20, 330, 120, 25);

        costtf = new JTextField();
        costtf.setBounds(200, 330, 370, 25);

        definelb = new JLabel("Mô tả:");
        definelb.setFont(font);
        definelb.setBounds(20, 380, 120, 25);

        definetf = new JTextField();
        definetf.setBounds(200, 380, 370, 100);

        notelb = new JLabel("ghi chú:");
        notelb.setFont(font);
        notelb.setBounds(20, 500, 120, 25);

        notetf = new JTextField();
        notetf.setBounds(200, 500, 370, 100);

        statuslb = new JLabel("Trạng thái:");
        statuslb.setFont(font);
        statuslb.setBounds(20, 620, 120, 25);

        statuscb = new JComboBox<>(new String[] {"Đang bán", "Ngừng bán"});
        statuscb.setBounds(200, 620, 370, 25);
        statuscb.setFont(new Font("Tahoma", Font.BOLD, 15));

        addbtn = new JButton("Thêm");
        addbtn.setFont(new Font("Tahoma", Font.BOLD, 30));
        addbtn.setBackground(Color.WHITE);
        addbtn.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        addbtn.setBounds(200, 650, 180, 70);
        addbtn.addActionListener(this);

        updatebtn = new JButton("Cập nhật");
        updatebtn.setFont(new Font("Tahoma", Font.BOLD, 30));
        updatebtn.setBackground(Color.WHITE);
        updatebtn.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        updatebtn.setBounds(390, 650, 180, 70);
        updatebtn.addActionListener(this);

        deletebtn = new JButton("Xóa");
        deletebtn.setFont(new Font("Tahoma", Font.BOLD, 30));
        deletebtn.setBackground(Color.WHITE);
        deletebtn.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        deletebtn.setBounds(200, 730, 180, 70);
        deletebtn.addActionListener(this);

        info.add(picturelb);
        info.add(idlb);
        info.add(idtf);
        info.add(namelb);
        info.add(nametf);
        info.add(typelb);
        info.add(typecb);
        info.add(moneylb);
        info.add(costtf);
        info.add(definelb);
        info.add(definetf);
        info.add(notelb);
        info.add(notetf);
        info.add(statuslb);
        info.add(statuscb);
        info.add(addbtn);
        info.add(updatebtn);
        info.add(deletebtn);

//=========================================================================

        list = new JPanel();
        list.setBackground(new Color(255,248,220));
        list.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        list.setPreferredSize(new Dimension(650, 1025));
        list.setLayout(null);

        list_namelb = new JLabel("Tên sản phẩm");
        list_namelb.setBounds(20, 10, 125, 25);
        list_namelb.setFont(new Font("Tahoma", Font.BOLD, 15));

        list_nametf = new JTextField();
        list_nametf.setBounds(20, 40, 225, 25);

        search = new JButton("Tìm");
        search.setBackground(Color.WHITE);
        search.setBounds(250, 40, 75, 25);
        search.setFont(new Font("Tahoma", Font.BOLD, 15));
        search.addActionListener(this);

        list_typelb = new JLabel("Loại sản phẩm");
        list_typelb.setFont(new Font("Tahoma", Font.BOLD, 15));
        list_typelb.setBounds(330, 10, 125, 25);

        list_typecb = new JComboBox<>(new String[] {"Tất cả", "Trà trái cây", "Đá xay", "Bánh", "Cafe"});
        list_typecb.setBounds(330, 40, 150, 25);

        list_statuslb = new JLabel("Trạng thái");
        list_statuslb.setBounds(485, 10, 150, 25);
        list_statuslb.setFont(new Font("Tahoma", Font.BOLD, 15));

        list_statuscb = new JComboBox<>(new String[] {"Tất cả", "Đang bán", "Ngừng bán"});
        list_statuscb.setBounds(485, 40, 150, 25);

        listTableProduct = new JTable();
        listTableProduct.setModel(tbl);
        listScroll = new JScrollPane();

        tbl.addColumn("Mã SP");
        tbl.addColumn("Tên SP");
        tbl.addColumn("Loại SP");
        tbl.addColumn("Đơn giá");
        tbl.addColumn("Trạng thái");

        try {
            ProductList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        MouseClick mouseClick = new MouseClick();
        listTableProduct.addMouseListener(mouseClick);

        listScroll.setBounds(10, 80, 625, 725);
        listScroll.setViewportView(listTableProduct);

        list.add(list_namelb);
        list.add(list_nametf);
        list.add(search);
        list.add(list_typelb);
        list.add(list_typecb);
        list.add(list_statuslb);
        list.add(list_statuscb);
        list.add(listScroll);

        this.add(info, BorderLayout.WEST);
        this.add(list, BorderLayout.EAST);

        this.setVisible(true);
    }

//============================================================
//============================================================

    public void input() {
        id = idtf.getText();
        name = nametf.getText();
        type = (String) typecb.getSelectedItem();
        cost = Integer.parseInt(costtf.getText());
        status = (String) statuscb.getSelectedItem();
    }
     public void inputReset() {
        idtf.setText("");
        nametf.setText("");
        typecb.setSelectedItem(0);
        costtf.setText("0đ");
        statuscb.setSelectedItem(0);
    }

    public void ProductList() throws Exception {
        tbl.setRowCount(0);
        List<Product> list = pdC.selectAll();
        for(Product p : list) {
            Object Products[] = {
                    p.getId(),
                    p.getName(),
                    p.getType(),
                    p.getCost(),
                    p.getStatus()
            };
            tbl.addRow(Products);
            tbl.fireTableDataChanged();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addbtn) {
            input();
            Product p = new Product("", name, type, cost, status);
            try {
                pdC.insert(p);
                ProductList();
                inputReset();
                JOptionPane.showMessageDialog(null, "Thêm thành công");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        if(e.getSource() == updatebtn) {
            input();
            try {
                Product p = new Product(id, name, type, cost, status);
                pdC.update(p);
                ProductList();
                inputReset();
                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        if(e.getSource() == deletebtn) {
            input();
            try {
                pdC.delete(id);
                ProductList();
                inputReset();
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        if(e.getSource() == search) {
            name = list_nametf.getText();
            type = (String) list_typecb.getSelectedItem();
            status = (String) list_statuscb.getSelectedItem();
            try {
                pdC.search(tbl, name, type, status);
                list_nametf.setText("");
                list_typecb.setSelectedItem(0);
                list_statuscb.setSelectedItem(0);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private class MouseClick extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            int selectRow = listTableProduct.getSelectedRow();
            if (selectRow >= 0) {
                idtf.setText(tbl.getValueAt(selectRow, 0).toString());
                nametf.setText(tbl.getValueAt(selectRow, 1).toString());
                typecb.setSelectedItem(tbl.getValueAt(selectRow, 2));
                costtf.setText(tbl.getValueAt(selectRow, 3).toString());
                statuscb.setSelectedItem(tbl.getValueAt(selectRow, 4));
                idtmp = idtf.getText();
            }
        }
    }
}
