package View;

import Controller.BillController;
import Controller.DetailBillController;
import Model.Bill;
import Model.DetailBill;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewBill extends JPanel {
    BillController bC = new BillController();
    DetailBillController dbC = new DetailBillController();
    JPanel bill_list, bill_info;
    JLabel billIdlb, statuslb,
           listTitle, listId, listTime, listType, listStatus, listMoney,
           infoTitle, infoId, infoTime, infoType, infoStatus, infoMoney;
    JScrollPane table, listBill;
    JTable billTable, listTable;
    JButton searchbtn;
    JTextField billIdtf;
    JComboBox statuscb;
    DefaultTableModel tbl = new DefaultTableModel();
    DefaultTableModel tbl1 = new DefaultTableModel();
    Font font = new Font("Calibri", Font.BOLD, 20);
    Font font1 = new Font("Calibri", Font.PLAIN, 20);
    public ViewBill() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.setLocation(0, 0);
        this.setPreferredSize(new Dimension(1300, 820));

        bill_list = new JPanel();
        bill_list.setLayout(null);
        bill_list.setBackground(new Color(255,248,220));
        bill_list.setPreferredSize(new Dimension(650, 410));

        billIdlb = new JLabel("Mã HD:");
        billIdlb.setFont(font);
        billIdlb.setBounds(10, 20, 100, 25);

        billIdtf = new JTextField();
        billIdtf.setBounds(10, 45, 400, 25);

        searchbtn = new JButton("Tìm");
        searchbtn.setBackground(Color.WHITE);
        searchbtn.setBounds(420, 45, 75, 25);

        statuslb = new JLabel("Trạng thái:");
        statuslb.setFont(font);
        statuslb.setBounds(505, 20, 150, 25);

        statuscb = new JComboBox(new String[] {"Tất cả", "Hoàn thành", "Chưa giao"});
        statuscb.setBounds(505, 45, 150, 25);
        statuscb.setBackground(Color.WHITE);

        billTable = new JTable();
        billTable.setModel(tbl);
        table = new JScrollPane();

        tbl.addColumn("Mã HD");
        tbl.addColumn("Nhân viên");
        tbl.addColumn("Thời gian xuất HD");
        tbl.addColumn("Loại thanh toán");
        tbl.addColumn("Tổng tiền");
        tbl.addColumn("Trạng thái");

        try {
            showBill();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        MouseClick mouseClick = new MouseClick();
        billTable.addMouseListener(mouseClick);

        table.setBounds(10, 80, 1280, 310);
        table.setViewportView(billTable);

        bill_list.add(billIdlb);
        bill_list.add(billIdtf);
        bill_list.add(searchbtn);
        bill_list.add(statuslb);
        bill_list.add(statuscb);
        bill_list.add(table);

//===============================================================================

        bill_info = new JPanel();
        bill_info.setLayout(null);
        bill_info.setBackground(new Color(255,248,220));
        bill_info.setPreferredSize(new Dimension(650, 410));

        listTitle = new JLabel("Chi tiết hóa đơn");
        listTitle.setFont(new Font("Calibri", Font.BOLD, 25));
        listTitle.setBounds(300, 10, 200, 30);

        listId = new JLabel("Mã HD:");
        listId.setFont(font1);
        listId.setBounds(10, 50,100, 25);
        listId.setBackground(Color.WHITE);

        infoId = new JLabel("X");
        infoId.setFont(font1);
        infoId.setBounds(180, 50,100, 25);
        infoId.setBackground(Color.WHITE);

        listTime = new JLabel("Thời gian xuất HD:");
        listTime.setFont(font1);
        listTime.setBounds(10, 140, 150, 25);
        listTime.setBackground(Color.WHITE);

        infoTime = new JLabel("X");
        infoTime.setFont(font1);
        infoTime.setBounds(180, 140, 150, 25);
        infoTime.setBackground(Color.WHITE);

        listType = new JLabel("Loại thanh toán:");
        listType.setFont(font1);
        listType.setBounds(10, 170, 150, 25);
        listType.setBackground(Color.WHITE);

        infoType = new JLabel("X");
        infoType.setFont(font1);
        infoType.setBounds(180, 170, 150, 25);
        infoType.setBackground(Color.WHITE);

        listStatus = new JLabel("Trạng thái:");
        listStatus.setFont(font1);
        listStatus.setBounds(350, 50, 150, 25);
        listStatus.setBackground(Color.WHITE);

        infoStatus = new JLabel("X");
        infoStatus.setFont(new Font("Calibri", Font.BOLD, 30));
        infoStatus.setBounds(350, 80, 250, 35);
        infoStatus.setBackground(Color.WHITE);

        listMoney = new JLabel("Tổng tiền HD:");
        listMoney.setFont(font1);
        listMoney.setBounds(350, 170, 150, 25);
        listMoney.setBackground(Color.WHITE);

        infoMoney = new JLabel("X");
        infoMoney.setFont(font1);
        infoMoney.setBounds(480, 170, 150, 25);
        infoMoney.setBackground(Color.WHITE);

        listTable = new JTable();
        listTable.setModel(tbl1);
        listBill = new JScrollPane();

        tbl1.addColumn("Tên SP");
        tbl1.addColumn("Số lượng");
        tbl1.addColumn("Đơn Giá");
        tbl1.addColumn("Thành tiền");

        listBill.setBounds(590, 50, 700, 250);
        listBill.setViewportView(listTable);

        bill_info.add(listTitle);
        bill_info.add(listId);
        bill_info.add(infoId);
        bill_info.add(listTime);
        bill_info.add(infoTime);
        bill_info.add(listType);
        bill_info.add(infoType);
        bill_info.add(listStatus);
        bill_info.add(infoStatus);
        bill_info.add(listMoney);
        bill_info.add(infoMoney);
        bill_info.add(listBill);

        this.add(bill_list, BorderLayout.NORTH);
        this.add(bill_info, BorderLayout.SOUTH);
        this.setVisible(true);
    }
    public void showBill() throws Exception {
        tbl.setRowCount(0);
        List<Bill> list = bC.select();
        for (Bill b : list) {
            Object Bill[] = {
                    "HD" + b.getIdBill(),
                    b.getNamestaff(),
                    b.getDateBill(),
                    b.getTypePay(),
                    b.getTotalMoney(),
                    b.getStatus()
            };
            tbl.addRow(Bill);
            tbl.fireTableDataChanged();
        }
    }
    public void showDetailBill(String id) throws Exception {
        tbl1.setRowCount(0);
        List<DetailBill> listDB = dbC.select(id);
        for (DetailBill d : listDB) {
            Object DetailBill[] = {
                    d.getNameProduct(),
                    d.getCost(),
                    d.getQuantity(),
                    d.getMoney()
            };
            tbl1.addRow(DetailBill);
            tbl1.fireTableDataChanged();
        }
    }
    private class MouseClick extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            int selectRow = billTable.getSelectedRow();
            if (selectRow >= 0) {
                try {
                    System.out.println(tbl.getValueAt(selectRow, 0).toString().substring(2));
                    showDetailBill(tbl.getValueAt(selectRow, 0).toString().substring(2));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                infoId.setText(tbl.getValueAt(selectRow, 0).toString());
                infoTime.setText(tbl.getValueAt(selectRow, 2).toString());
                infoType.setText(tbl.getValueAt(selectRow, 3).toString());
                infoMoney.setText(tbl.getValueAt(selectRow,4).toString());
                infoStatus.setText(tbl.getValueAt(selectRow, 5).toString());
            }

        }
    }
}
