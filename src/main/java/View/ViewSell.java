package View;

import DAO.DBConnect;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import static javax.swing.ScrollPaneConstants.COLUMN_HEADER;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

public class ViewSell extends JPanel implements ActionListener {

    ViewSellCient sellCutomer;
    ViewSellShip sellShip;
    JPanel info, order, listHD, client, bill, paint, list;
    JLabel namesp, types, wait, ship,
            phoneNumber, score, name, money, note,
            sumMoney, sumBill, moneyOfClient, excessCash, typePay, status, ans, address;
    JTextField text,
            sdttf, nametf, scoretf, moneytf, notetf,
            sumMoneytf, sumBilltf, moneyOfClienttf, excessCashtf, addresstf;
    JButton btn, add, sub, cancel, cleave, shipbtn, pay,
            search, plus,
            hd1, hd2, hd3, hd4, hd5, hd6, hd7, hd8;
    JRadioButton exchange;
    JComboBox show, typePaycb;
    JScrollPane listsp;
    JTable waitTb, shipTb, listHdTb, productTb;
    JScrollPane jone, jtwo, jthree;
    String listHDstr = "HD", sCheck = "HD008";
    DefaultTableModel producttbl, waittbl, shiptbl, billtbl;
    Font font = new Font("Tahoma", Font.BOLD, 15);
    int number_listHD = 1;

    public ViewSell() {
//        this.setSize(1660, 1030);
        this.setLayout(new BorderLayout());

        info = new JPanel();
        info.setBackground(new Color(255, 248, 220));
        info.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        info.setPreferredSize(new Dimension(650, 1025));
        info.setLayout(null);

        namesp = new JLabel();
        namesp.setText("Tên sản phẩm");
        namesp.setBounds(5, 5, 200, 30);
        namesp.setFont(font);

        types = new JLabel("Loại sản phẩm");
        types.setBounds(400, 5, 200, 30);
        types.setFont(font);

        text = new JTextField(20);
        text.setBounds(5, 40, 300, 30);

        btn = new JButton("Tìm");
        btn.setBounds(310, 40, 75, 30);
        btn.setBackground(Color.WHITE);

        show = new JComboBox<>(new String[] {"Tất cả", "Trà trái cây", "Đá xay", "Bánh", "Cafe"});
        show.setBounds(400, 40, 200, 30);
        show.setBackground(Color.WHITE);

        listsp = new JScrollPane();
        listsp.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
//        productTb = new JTable();
//        producttbl = new DefaultTableModel();
//        productTb.setModel(producttbl);
//
//        producttbl.addColumn("Mã sản phẩm");
//        producttbl.addColumn("Tên sản phẩm");
//        producttbl.addColumn("Giá");

        list = new JPanel();
        list.setLayout(new FlowLayout(FlowLayout.LEADING));

        try {
            ShowProduct();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        list.add(new Item("SP1", "Bạc xỉu", 20000));
//        list.add(new Item("SP2", "Đá xay", 25000));
        listsp.setBounds(5, 80, 640, 400);
        listsp.setViewportView(list);

        wait = new JLabel("Hóa đơn chờ:");
        wait.setBounds(5, 480, 200, 30);
        wait.setFont(font);

        waitTb = new JTable();
        jone = new JScrollPane();
        waitTb.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
//                        {null, null, null, null, null, null}
//                        {null, null, null, null, null, null},
//                        {null, null, null, null, null, null},
//                        {null, null, null, null, null, null}
                },
                new String[]{
                        "Mã HD", "Người tạo", "Khách hàng", "TG tạo", "Trạng thái", "Ghi chú"
                }
        ));
        jone.setBounds(5, 515, 640, 120);
        jone.setViewportView(waitTb);

        ship = new JLabel("Hóa đơn giao:");
        ship.setBounds(5, 640, 200, 30);
        ship.setFont(font);

        shipTb = new JTable();
        shipTb.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Mã HD", "Người tạo", "Khách hàng", "TG tạo", "Trạng thái", "Ghi chú"
                }
        ));
        jtwo = new JScrollPane();
        jtwo.setBounds(5, 675, 640, 120);
        jtwo.setViewportView(shipTb);

        info.add(namesp);
        info.add(types);
        info.add(text);
        info.add(btn);
        info.add(show);
        info.add(listsp);
        info.add(wait);
        info.add(jone);
        info.add(ship);
        info.add(jtwo);

//===============================================================================
        order = new JPanel();

        order.setBackground(new Color(255, 248, 220));
        order.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        order.setPreferredSize(new Dimension(650, 1025));
        order.setLayout(null);

        add = new JButton("+");
        add.setBackground(Color.WHITE);
        add.setBounds(520, 5, 45, 30);
        add.addActionListener(this);

        sub = new JButton("-");
        sub.setBackground(Color.WHITE);
        sub.setBounds(570, 5, 45, 30);
        sub.addActionListener(this);
        //==========================================
        listHD = new JPanel();
        listHD.setLayout(new FlowLayout(FlowLayout.LEADING));
        listHD.setBounds(5, 40, 625, 30);
        listHD.setBackground(null);

        paint = new JPanel();
        paint.setBounds(5, 70, 625, 4);
        paint.setBackground(Color.GRAY);

        hd1 = new JButton("HD001");
        hd1.setVisible(false);
        hd1.setBackground(Color.WHITE);
        hd1.addActionListener(this);

        hd2 = new JButton("HD002");
        hd2.setVisible(false);
        hd2.setBackground(Color.WHITE);
        hd2.addActionListener(this);

        hd3 = new JButton("HD003");
        hd3.setVisible(false);
        hd3.setBackground(Color.WHITE);
        hd3.addActionListener(this);

        hd4 = new JButton("HD004");
        hd4.setVisible(false);
        hd4.setBackground(Color.WHITE);
        hd4.addActionListener(this);

        hd5 = new JButton("HD005");
        hd5.setVisible(false);
        hd5.setBackground(Color.WHITE);
        hd5.addActionListener(this);

        hd6 = new JButton("HD006");
        hd6.setVisible(false);
        hd6.setBackground(Color.WHITE);
        hd6.addActionListener(this);

        hd7 = new JButton("HD007");
        hd7.setVisible(false);
        hd7.setBackground(Color.WHITE);
        hd7.addActionListener(this);

        hd8 = new JButton("HD008");
        hd8.setVisible(false);
        hd8.setBackground(Color.WHITE);
        hd8.setName("HD008");
        hd8.addActionListener(this);

        listHD.add(hd1);
        listHD.add(hd2);
        listHD.add(hd3);
        listHD.add(hd4);
        listHD.add(hd5);
        listHD.add(hd6);
        listHD.add(hd7);
        listHD.add(hd8);

        //==========================================

        listHdTb = new JTable();
        listHdTb.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Mã HD", "Người tạo", "Khách hàng", "TG tạo", "Trạng thái", "Ghi chú"
                }
        ));
        jthree = new JScrollPane();
        jthree.setBounds(5, 80, 640, 180);
        jthree.setViewportView(shipTb);

//=====================================================================

        client = new JPanel();
        client.setBackground(Color.WHITE);
        client.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        client.setLayout(null);
        client.setBounds(5, 265, 320, 430);

        phoneNumber = new JLabel("Số điện thoại:");
        phoneNumber.setBounds(5, 5, 200, 20);
        phoneNumber.setFont(font);

        sdttf = new JTextField();
        sdttf.setBounds(5, 35, 225, 30);

        search = new JButton();
        search.setBounds(235, 35, 75, 30);
        search.setBackground(Color.WHITE);

        name = new JLabel("Họ và tên:");
        name.setFont(font);
        name.setBounds(5, 75, 200, 20);

        nametf = new JTextField();
        nametf.setBounds(5, 105, 225, 30);

        plus = new JButton("+");
        plus.setBounds(235, 105, 75, 30);
        plus.setBackground(Color.WHITE);
        plus.addActionListener(this);

        score = new JLabel("Điểm tích lũy:");
        score.setFont(font);
        score.setBounds(5, 145, 200, 20);

        exchange = new JRadioButton("Đổi điểm");
        exchange.setBounds(210, 145, 100, 20);
        exchange.setFont(font);
        exchange.setBackground(null);

        scoretf = new JTextField();
        scoretf.setBounds(5, 175, 310, 30);

        money = new JLabel("Tiền khác:");
        money.setFont(font);
        money.setBounds(5, 215, 200, 20);

        moneytf = new JTextField("0 đ");
        moneytf.setBounds(5, 245, 310, 30);

        note = new JLabel("Ghi chú:");
        note.setFont(font);
        note.setBounds(5, 285, 200, 20);

        notetf = new JTextField();
        notetf.setBounds(5, 315, 310, 100);

        client.add(phoneNumber);
        client.add(sdttf);
        client.add(search);
        client.add(name);
        client.add(nametf);
        client.add(plus);
        client.add(score);
        client.add(exchange);
        client.add(scoretf);
        client.add(money);
        client.add(moneytf);
        client.add(note);
        client.add(notetf);

//=====================================================================

        bill = new JPanel();
        bill.setBackground(Color.WHITE);
        bill.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        bill.setLayout(null);
        bill.setBounds(335, 265, 310, 430);

        sumMoney = new JLabel("Tổng tiền sản phẩm:");
        sumMoney.setBounds(5, 5, 200, 20);
        sumMoney.setFont(font);

        sumMoneytf = new JTextField();
        sumMoneytf.setBounds(5, 35, 300, 30);

        sumBill = new JLabel("Tổng tiền sản phẩm:");
        sumBill.setBounds(5, 75, 200, 20);
        sumBill.setFont(font);

        sumBilltf = new JTextField();
        sumBilltf.setBounds(5, 105, 300, 30);

        moneyOfClient = new JLabel("Tiền khách trả:");
        moneyOfClient.setBounds(5, 145, 125, 20);
        moneyOfClient.setFont(font);

        moneyOfClienttf = new JTextField();
        moneyOfClienttf.setBounds(5, 175, 140, 30);

        excessCash = new JLabel("Tiền thừa:");
        excessCash.setBounds(165, 145, 200, 20);
        excessCash.setFont(font);

        excessCashtf = new JTextField();
        excessCashtf.setBounds(165, 175, 140, 30);

        typePay = new JLabel("Loại TT:");
        typePay.setBounds(5, 215, 100, 20);
        typePay.setFont(font);

        typePaycb = new JComboBox(new String[]{"Tiền mặt", "chuyển khoảng"});
        typePaycb.setBounds(5, 245, 140, 30);

        status = new JLabel("Trạng thái:");
        status.setBounds(165, 215, 200, 20);
        status.setFont(font);

        ans = new JLabel("hello");
        ans.setBounds(165, 250, 200, 30);
        ans.setFont(new Font("Calibri", Font.BOLD, 30));

        address = new JLabel("Địa chỉ:");
        address.setFont(font);
        address.setBounds(5, 285, 200, 20);

        addresstf = new JTextField();
        addresstf.setBounds(5, 315, 300, 100);

        bill.add(sumMoney);
        bill.add(sumMoneytf);
        bill.add(sumBill);
        bill.add(sumBilltf);
        bill.add(moneyOfClient);
        bill.add(moneyOfClienttf);
        bill.add(excessCashtf);
        bill.add(excessCash);
        bill.add(typePay);
        bill.add(typePaycb);
        bill.add(status);
        bill.add(ans);
        bill.add(address);
        bill.add(addresstf);

//======================================================================

        cancel = new JButton("Hủy");
        cancel.setBackground(Color.WHITE);
        cancel.setBounds(5, 700, 70, 80);
        cancel.setFont(new Font("Calibri", Font.BOLD, 20));
        cancel.addActionListener(this);

        cleave = new JButton("Tách");
        cleave.setBackground(Color.WHITE);
        cleave.setBounds(80, 700, 120, 80);
        cleave.setFont(new Font("Calibri", Font.BOLD, 20));
        cleave.addActionListener(this);

        shipbtn = new JButton("Giao hàng");
        shipbtn.setBackground(Color.WHITE);
        shipbtn.setBounds(205, 700, 120, 80);
        shipbtn.setFont(new Font("Calibri", Font.BOLD, 20));
        shipbtn.addActionListener(this);

        pay = new JButton("Thanh toán");
        pay.setBackground(Color.WHITE);
        pay.setBounds(335, 700, 310, 80);
        pay.setFont(new Font("Calibri", Font.BOLD, 30));
        pay.addActionListener(this);

        order.add(add);
        order.add(sub);
        order.add(listHD);
        order.add(paint);
        order.add(jthree);
        order.add(client);
        order.add(bill);
        order.add(cancel);
        order.add(cleave);
        order.add(shipbtn);
        order.add(pay);

        this.add(info, BorderLayout.WEST);
        this.add(order, BorderLayout.EAST);
//        try {
//            ShowProduct();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        this.setVisible(true);
    }

    public void ShowProduct() throws Exception {
        Connection connect = new DBConnect().getConnect();
        String query = "SELECT `MaSP`, `TenSP`, `GiaSP` FROM `sanpham` WHERE 1";
        Statement sta = connect.createStatement();
        ResultSet result = sta.executeQuery(query);

//        producttbl.setRowCount(0);

        while(result.next()) {

            list.add(new Item(result.getString("MaSP"), result.getString("TenSP"), result.getInt("GiaSP")));
//            Object Products[] = {
//                result.getString("MaSP"),
//                result.getString("TenSP"),
//                result.getInt("GiaSP")
//            };
//            producttbl.addRow(Products);
//            producttbl.fireTableDataChanged();
        }
        result.close();
        connect.close();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add && number_listHD == 1) {
            hd1.setVisible(true);
            System.out.println(number_listHD);
            number_listHD++;
            return;
        }
        if (e.getSource() == add && number_listHD == 2) {
            hd2.setVisible(true);
            System.out.println(number_listHD);
            number_listHD++;
            return;
        }
        if (e.getSource() == add && number_listHD == 3) {
            hd3.setVisible(true);
            System.out.println(number_listHD);
            number_listHD++;
            return;
        }
        if (e.getSource() == add && number_listHD == 4) {
            hd4.setVisible(true);
            System.out.println(number_listHD);
            number_listHD++;
            return;
        }
        if (e.getSource() == add && number_listHD == 5) {
            hd5.setVisible(true);
            System.out.println(number_listHD);
            number_listHD++;
            return;
        }
        if (e.getSource() == add && number_listHD == 6) {
            hd6.setVisible(true);
            System.out.println(number_listHD);
            number_listHD++;
            return;
        }
        if (e.getSource() == add && number_listHD == 7) {
            hd7.setVisible(true);
            System.out.println(number_listHD);
            number_listHD++;
            return;
        }
        if (e.getSource() == add && number_listHD == 8) {
            hd8.setVisible(true);
            System.out.println(number_listHD);
            number_listHD = 1;
        }
        if (e.getSource() == sub && sCheck.equals("HD001")) {
            hd1.setVisible(false);
        }
        if (e.getSource() == sub && sCheck.equals("HD002")) {
            hd2.setVisible(false);
        }
        if (e.getSource() == sub && sCheck.equals("HD003")) {
            hd3.setVisible(false);
        }
        if (e.getSource() == sub && sCheck.equals("HD004")) {
            hd4.setVisible(false);
        }
        if (e.getSource() == sub && sCheck.equals("HD005")) {
            hd5.setVisible(false);
        }
        if (e.getSource() == sub && sCheck.equals("HD006")) {
            hd6.setVisible(false);
        }
        if (e.getSource() == sub && sCheck.equals("HD007")) {
            hd7.setVisible(false);
        }
        if (e.getSource() == sub && sCheck.equals("HD008")) {
            hd8.setVisible(false);
        }
        if (e.getSource() == hd1) {
            sCheck = "HD001";
        }
        if (e.getSource() == hd2) {
            sCheck = "HD002";
        }
        if (e.getSource() == hd3) {
            sCheck = "HD003";
        }
        if (e.getSource() == hd4) {
            sCheck = "HD004";
        }
        if (e.getSource() == hd5) {
            sCheck = "HD005";
        }
        if (e.getSource() == hd6) {
            sCheck = "HD006";
        }
        if (e.getSource() == hd7) {
            sCheck = "HD007";
        }
        if (e.getSource() == hd8) {
            sCheck = "HD008";
        }

        if (e.getSource() == plus) {
            sellCutomer = new ViewSellCient();
        }

        if (e.getSource() == shipbtn) {
            sellShip = new ViewSellShip();
        }
    }
}
