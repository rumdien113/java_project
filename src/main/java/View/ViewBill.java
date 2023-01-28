package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewBill extends JPanel {

    JPanel bill_list, bill_info;
    JLabel billIdlb, statuslb,
           listTitle, listId, listClient, listSdt, listTime, listType, listStatus, listSumMoney, listSubMoney, listMoney,
           infoTitle, infoId, infoClient, infoSdt, infoTime, infoType, infoStatus, infoSumMoney, infoSubMoney, infoMoney;
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

        bill_list = new JPanel();
        bill_list.setLayout(null);
        bill_list.setBackground(new Color(255,248,220)  );
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
        tbl.addColumn("Khách hàng");
        tbl.addColumn("Thời gian xuất HD");
        tbl.addColumn("Tổng tiền");
        tbl.addColumn("Địa chỉ");
        tbl.addColumn("Trạng thái");

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

        listClient = new JLabel("Khách hàng:");
        listClient.setFont(font1);
        listClient.setBounds(10, 80, 100, 25);
        listClient.setBackground(Color.WHITE);

        infoClient = new JLabel("X");
        infoClient.setFont(font1);
        infoClient.setBounds(180, 80, 100, 25);
        infoClient.setBackground(Color.WHITE);

        listSdt = new JLabel("SĐT:");
        listSdt.setFont(font1);
        listSdt.setBounds(10, 110, 100, 25);
        listSdt.setBackground(Color.WHITE);

        infoSdt = new JLabel("X");
        infoSdt.setFont(font1);
        infoSdt.setBounds(180, 110, 100, 25);
        infoSdt.setBackground(Color.WHITE);

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
        listStatus.setBounds(400, 50, 150, 25);
        listStatus.setBackground(Color.WHITE);

        infoStatus = new JLabel("X");
        infoStatus.setFont(new Font("Calibri", Font.BOLD, 30));
        infoStatus.setBounds(400, 80, 150, 35);
        infoStatus.setBackground(Color.WHITE);

        listSumMoney = new JLabel("Tổng tiền SP:");
        listSumMoney.setFont(font1);
        listSumMoney.setBounds(400, 110, 150, 25);
        listSumMoney.setBackground(Color.WHITE);

        infoSumMoney = new JLabel("X");
        infoSumMoney.setFont(font1);
        infoSumMoney.setBounds(530, 110, 150, 25);
        infoSumMoney.setBackground(Color.WHITE);

        listSubMoney = new JLabel("Chi phí khác:");
        listSubMoney.setFont(font1);
        listSubMoney.setBounds(400, 140, 150, 25);
        listSubMoney.setBackground(Color.WHITE);

        infoSubMoney = new JLabel("X");
        infoSubMoney.setFont(font1);
        infoSubMoney.setBounds(530, 140, 150, 25);
        infoSubMoney.setBackground(Color.WHITE);

        listMoney = new JLabel("Tổng tiền HD:");
        listMoney.setFont(font1);
        listMoney.setBounds(400, 170, 150, 25);
        listMoney.setBackground(Color.WHITE);

        infoMoney = new JLabel("X");
        infoMoney.setFont(font1);
        infoMoney.setBounds(530, 170, 150, 25);
        infoMoney.setBackground(Color.WHITE);

        listTable = new JTable();
        listTable.setModel(tbl1);
        listBill = new JScrollPane();

        tbl1.addColumn("Tên SP");
        tbl1.addColumn("Đơn Giá");
        tbl1.addColumn("Số lượng");
        tbl1.addColumn("Thành tiền");
        tbl1.addColumn("Ghi chú");

        listBill.setBounds(590, 50, 700, 250);
        listBill.setViewportView(listTable);

        bill_info.add(listTitle);
        bill_info.add(listId);
        bill_info.add(infoId);
        bill_info.add(listClient);
        bill_info.add(infoClient);
        bill_info.add(listSdt);
        bill_info.add(infoSdt);
        bill_info.add(listTime);
        bill_info.add(infoTime);
        bill_info.add(listType);
        bill_info.add(infoType);
        bill_info.add(listStatus);
        bill_info.add(infoStatus);
        bill_info.add(listSumMoney);
        bill_info.add(infoSumMoney);
        bill_info.add(listSubMoney);
        bill_info.add(infoSubMoney);
        bill_info.add(listMoney);
        bill_info.add(infoMoney);
        bill_info.add(listBill);

        this.add(bill_list, BorderLayout.NORTH);
        this.add(bill_info, BorderLayout.SOUTH);
        this.setVisible(true);
    }
}
