package View;

import Controller.SaleController;
import DAO.DBConnect;
import Model.Sale;
import com.toedter.calendar.JDateChooser;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewPromotion extends JPanel implements ActionListener {

    SaleController saleC = new SaleController();
    JPanel info, list;
    JLabel picturelb, idlb, namelb, typelb, valuelb, dayStartlb, dayEndlb, statuslb,
           promotionlb;
    JTextField idtf, nametf, valuetf, dayStarttf, dayEndtf,
               promotiontf;
    JComboBox typecb, statuscb, type1cb, status1cb, type3cb;
    JButton addbtn, updatebtn, deletebtn, confirm;
    JScrollPane scroll;
    JTable promotionTable, productTable;
    JCheckBox check;
    String id,  name, type, startDay = "", endDay = "", status, idtmp;
    int value;
    Font font= new Font("Tahoma", Font.BOLD, 20);
    DefaultTableModel tbl = new DefaultTableModel();

    public ViewPromotion() {
        this.setLayout(new BorderLayout());

        info = new JPanel();
        info.setBackground(new Color(255,248,220));
        info.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        info.setPreferredSize(new Dimension(650, 1025));
        info.setLayout(null);

        picturelb = new JLabel();
        picturelb.setBounds(200, 10, 150, 150);
        picturelb.setBackground(Color.green);
        picturelb.setOpaque(true);

        idlb = new JLabel("Mã khuyễn mãi:");
        idlb.setFont(font);
        idlb.setBounds(20, 220, 170, 25);

        idtf = new JTextField();
        idtf.setBounds(220, 220, 300, 25);

        namelb = new JLabel("Tên khuyễn mãi:");
        namelb.setFont(font);
        namelb.setBounds(20, 270, 170, 25);

        nametf = new JTextField();
        nametf.setBounds(220, 270, 300, 25);

        typelb = new JLabel("Loại sản phẩm:");
        typelb.setFont(font);
        typelb.setBounds(20, 330, 170, 25);

        typecb = new JComboBox<>(new String[] {"%", "Tiền"});
        typecb.setBounds(220, 330, 300, 25);
        typecb.setFont(new Font("Tahoma", Font.BOLD, 15));

        valuelb = new JLabel("Giá trị:");
        valuelb.setFont(font);
        valuelb.setBounds(20, 380, 170, 25);

        valuetf = new JTextField("0");
        valuetf.setBounds(220, 380, 300, 25);

        dayStartlb = new JLabel("Ngày bắt đầu:");
        dayStartlb.setFont(font);
        dayStartlb.setBounds(20, 430, 170, 25);

        dayStarttf = new JTextField();
        dayStarttf.setBounds(220, 430, 250, 25);

        dayEndlb = new JLabel("Ngày kết thúc:");
        dayEndlb.setFont(font);
        dayEndlb.setBounds(20, 480, 170, 25);

        dayEndtf = new JTextField();
        dayEndtf.setBounds(220, 480, 250, 25);

        statuslb = new JLabel("Trạng thái:");
        statuslb.setFont(font);
        statuslb.setBounds(20, 530, 170, 25);

        statuscb = new JComboBox<>(new String[] {"Đang áp dụng", "Ngừng áp dụng"});
        statuscb.setBounds(220, 530, 300, 25);

        addbtn = new JButton("Thêm");
        addbtn.setFont(new Font("Tahoma", Font.BOLD, 30));
        addbtn.setBackground(Color.WHITE);
        addbtn.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        addbtn.setBounds(20, 650, 180, 70);
        addbtn.addActionListener(this);

        updatebtn = new JButton("Cập nhật");
        updatebtn.setFont(new Font("Tahoma", Font.BOLD, 30));
        updatebtn.setBackground(Color.WHITE);
        updatebtn.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        updatebtn.setBounds(210, 650, 180, 70);
        updatebtn.addActionListener(this);

        deletebtn = new JButton("Xóa");
        deletebtn.setFont(new Font("Tahoma", Font.BOLD, 30));
        deletebtn.setBackground(Color.WHITE);
        deletebtn.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        deletebtn.setBounds(400, 650, 180, 70);
        deletebtn.addActionListener(this);

        info.add(picturelb);
        info.add(idlb);
        info.add(idtf);
        info.add(namelb);
        info.add(nametf);
        info.add(typelb);
        info.add(typecb);
        info.add(valuelb);
        info.add(valuetf);
        info.add(dayStartlb);
        info.add(dayStarttf);
        info.add(dayEndlb);
        info.add(dayEndtf);
        info.add(statuslb);
        info.add(statuscb);
        info.add(addbtn);
        info.add(updatebtn);
        info.add(deletebtn);

//======================================================================
//======================================================================

        list = new JPanel();
        list.setBackground(new Color(255,248,220));
        list.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        list.setPreferredSize(new Dimension(650, 1025));
        list.setLayout(null);

        promotionlb = new JLabel("Tìm khuyến mãi");
        promotionlb.setFont(font);
        promotionlb.setBounds(10, 10, 170, 25);

        promotiontf = new JTextField();
        promotiontf.setBounds(10, 45, 230, 30);

        typelb = new JLabel("Loại KM");
        typelb.setFont(font);
        typelb.setBounds(255, 10, 100, 25);

        type1cb = new JComboBox<>(new String[] {"%", "Tiền"});
        type1cb.setFont(font);
        type1cb.setBackground(Color.WHITE);
        type1cb.setBounds(255, 45, 100, 30);

        statuslb = new JLabel("Trạng thái");
        statuslb.setFont(font);
        statuslb.setBounds(375, 10, 150, 25);

        status1cb = new JComboBox(new String[] {"Đang áp dụng", "Ngừng áp dụng"});
        status1cb.setFont(font);
        status1cb.setBackground(Color.WHITE);
        status1cb.setBounds(375, 45, 250, 30);

        promotionTable = new JTable();
        promotionTable.setModel(tbl);
        scroll = new JScrollPane();

        tbl.addColumn("Mã KM");
        tbl.addColumn("Tên KM");
        tbl.addColumn("Loại KM");
        tbl.addColumn("Giá trị");
        tbl.addColumn("Ngày bắt đầu");
        tbl.addColumn("Ngày kết thúc");
        tbl.addColumn("Trạng thái");

        try {
            SaleList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        MouseClick mouseClick = new MouseClick();
        promotionTable.addMouseListener(mouseClick);

        scroll.setBounds(10, 85, 615, 200);
        scroll.setViewportView(promotionTable);

        confirm = new JButton("Xác nhận");
        confirm.setBounds(300, 300, 150, 50);
        confirm.setFont(new Font("Calibri", Font.BOLD, 25));
        confirm.setBackground(Color.WHITE);
        confirm.addActionListener(this);

        list.add(promotionlb);
        list.add(promotiontf);
        list.add(typelb);
        list.add(type1cb);
        list.add(statuslb);
        list.add(status1cb);
        list.add(scroll);
        list.add(confirm);

        this.add(info, BorderLayout.WEST);
        this.add(list, BorderLayout.EAST);
        this.setVisible(true);
    }

    public void input() {
        id = idtf.getText();
        name = nametf.getText();
        type = (String) typecb.getSelectedItem();
        value = Integer.parseInt(valuetf.getText());
        startDay = dayStarttf.getText();
        endDay = dayEndtf.getText();
        status = (String) statuscb.getSelectedItem();
    }

    public void inputReset() {
        idtf.setText("");
        nametf.setText("");
        typecb.setSelectedItem(0);
        valuetf.setText("");
        statuscb.setSelectedItem(0);
    }

    public void SaleList() throws Exception {
        tbl.setRowCount(0);
        List<Sale> saleList = saleC.selectAll();
        for (Sale s : saleList) {
            Object Sale[] = {
                s.getIdSale(),
                s.getNameSale(),
                s.getTypeSale(),
                s.getCostSale(),
                s.getStartDaySale(),
                s.getEndDaySale(),
                s.getStatusSale()
            };
            tbl.addRow(Sale);
            tbl.fireTableDataChanged();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addbtn) {
            input();
            Sale sa = new Sale(id, name, type, value, startDay, endDay, status);
            try {
                boolean check = saleC.insert(sa);
                if (check) {
                    SaleList();
                    inputReset();
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == updatebtn) {
            input();
            try {
                Sale s = new Sale(id, name, type, value, startDay, endDay, status);
                saleC.update(s);
                SaleList();
                inputReset();
                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == deletebtn) {
            try {
                input();
                String delete = "DELETE FROM khuyenmai WHERE MaKM = '" + idtmp + "'";
                Connection connect = new DBConnect().getConnect();
                Statement sta = connect.createStatement();
                sta.executeUpdate(delete);
                sta.close();

                SaleList();
                inputReset();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Xóa không thành công");
            }
        }
        if (e.getSource() == confirm) {
            input();
            try {
                saleC.Promotion(value, type, startDay, endDay);

                JOptionPane.showMessageDialog(null, "Xác nhận thành công");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private class MouseClick extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            int selectRow = promotionTable.getSelectedRow();
            if (selectRow >= 0) {
                idtf.setText(tbl.getValueAt(selectRow, 0).toString());
                nametf.setText(tbl.getValueAt(selectRow, 1).toString());
                typecb.setSelectedItem(tbl.getValueAt(selectRow, 2));
                valuetf.setText(tbl.getValueAt(selectRow, 3).toString());
                dayStarttf.setText(tbl.getValueAt(selectRow, 4).toString());
                dayEndtf.setText(tbl.getValueAt(selectRow, 5).toString());
                statuscb.setSelectedItem(tbl.getValueAt(selectRow, 6));
                idtmp = idtf.getText();
            }
        }
    }
}
