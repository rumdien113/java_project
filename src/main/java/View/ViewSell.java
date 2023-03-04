package View;

import Controller.BillController;
import Controller.DetailBillController;
import DAO.DBConnect;
import Model.Bill;
import Model.DetailBill;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static javax.swing.ScrollPaneConstants.*;

public class ViewSell extends JPanel implements ActionListener {
    BillController bC = new BillController();
    JPanel info, order, listHD, bill, paint, list;
    JLabel namesp, types, wait, ship,
            phoneNumber, score, name, money, note,
            sumMoney, moneyOfClient, excessCash, typePay, status, ans;
    JTextField text,
            sdttf, nametf, scoretf, moneytf, notetf,
            sumMoneytf, moneyOfClienttf, excessCashtf;
    JButton searchbtn, add, cancel, check, shipbtn, pay,
            search, plus;
    JRadioButton exchange;
    JComboBox show, typePaycb;
    JScrollPane listsp;
    JTable waitTb, billTb;
    public DefaultTableModel waittbl, billtbl;
    JScrollPane jone, jthree;
    String type, names, id;
    Font font = new Font("Tahoma", Font.BOLD, 15);
    public static int idHd = 1, sumMoneyTf;
    public static String namestaff, idstaff;
    SimpleDateFormat dateFormat;
    String date;

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

        searchbtn = new JButton("Tìm");
        searchbtn.setBounds(310, 40, 75, 30);
        searchbtn.setBackground(Color.WHITE);
        searchbtn.setFocusPainted(false);

        show = new JComboBox<>(new String[] {"Tất cả", "Trà trái cây", "Đá xay", "Bánh", "Cafe"});
        show.setBounds(400, 40, 200, 30);
        show.setBackground(Color.WHITE);

        listsp = new JScrollPane();
        listsp.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);

        list = new JPanel();
        list.setPreferredSize(new Dimension(640, 1000));
        list.setLayout(new FlowLayout(FlowLayout.LEADING));

//        MouseClick mouseClick = new MouseClick();
//        list.addMouseListener(mouseClick);

        try {
            ShowProduct();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        listsp.setBounds(5, 80, 640, 500);
        listsp.setViewportView(list);

//        wait = new JLabel("Hóa đơn chờ:");
//        wait.setBounds(5, 480, 200, 30);
//        wait.setFont(font);
//
//        waitTb = new JTable();
//        waittbl = new DefaultTableModel();
//        waitTb.setModel(waittbl);

//        waittbl.addColumn("Mã HD");
//        waittbl.addColumn("Người tạo");
//        waittbl.addColumn("Khách hàng");
//        waittbl.addColumn("TG tạo");
//        waittbl.addColumn("Trạng thái");
//
//        jone = new JScrollPane();
//        jone.setBounds(5, 515, 640, 120);
//        jone.setViewportView(waitTb);

        info.add(namesp);
        info.add(types);
        info.add(text);
        info.add(searchbtn);
        info.add(show);
        info.add(listsp);
//        info.add(wait);
//        info.add(jone);

//===============================================================================
        order = new JPanel();

        order.setBackground(new Color(255, 248, 220));
        order.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        order.setPreferredSize(new Dimension(650, 1025));
        order.setLayout(null);

        add = new JButton("+");
        add.setFocusPainted(false);
        add.setBackground(Color.WHITE);
        add.setBounds(520, 5, 45, 30);
        add.addActionListener(this);

        //==========================================
        listHD = new JPanel();
        listHD.setLayout(new FlowLayout(FlowLayout.LEADING));
        listHD.setBounds(5, 40, 625, 30);
        listHD.setBackground(null);

        paint = new JPanel();
        paint.setBounds(5, 70, 625, 4);
        paint.setBackground(Color.GRAY);

        //==========================================

        billTb = new JTable();
        billtbl = new DefaultTableModel();
        billTb.setModel(billtbl);

        billtbl.addColumn("Mã SP");
        billtbl.addColumn("Tên SP");
        billtbl.addColumn("Số Lượng");
        billtbl.addColumn("Đơn giá");
        billtbl.addColumn("Thành tiền");
        billtbl.addColumn("");

        jthree = new JScrollPane();
        jthree.setBounds(5, 80, 640, 180);
        jthree.setViewportView(billTb);

//=====================================================================

//        bill = new JPanel();
//        bill.setBackground(Color.WHITE);
//        bill.setBorder(BorderFactory.createLineBorder(Color.GRAY));
//        bill.setLayout(null);
//        bill.setBounds(335, 265, 310, 430);

        sumMoney = new JLabel("Tổng tiền sản phẩm:");
        sumMoney.setBounds(5, 280, 200, 20);
        sumMoney.setFont(font);

        sumMoneytf = new JTextField();
        sumMoneytf.setBounds(5, 310, 300, 30);

//        moneyOfClient = new JLabel("Tiền khách trả:");
//        moneyOfClient.setBounds(5, 145, 125, 20);
//        moneyOfClient.setFont(font);
//
//        moneyOfClienttf = new JTextField();
//        moneyOfClienttf.setBounds(5, 175, 150, 30);
//
//        excessCash = new JLabel("Tiền thừa:"); //set lai JLabel
//        excessCash.setBounds(165, 145, 200, 20);
//        excessCash.setFont(font);
//
//        excessCashtf = new JTextField();
//        excessCashtf.setBounds(5, 350, 140, 30);

        typePay = new JLabel("Loại TT:");
        typePay.setBounds(5, 350, 100, 20);
        typePay.setFont(font);

        typePaycb = new JComboBox(new String[]{"Tiền mặt", "chuyển khoản"});
        typePaycb.setBounds(5, 380, 140, 30);

        status = new JLabel("Trạng thái:");
        status.setBounds(5, 420, 200, 20);
        status.setFont(font);

        ans = new JLabel("Chưa thanh toán");
        ans.setBounds(5, 450, 400, 30);
        ans.setFont(new Font("Calibri", Font.BOLD, 30));


//        bill.add(moneyOfClient);
//        bill.add(moneyOfClienttf);
//        bill.add(excessCashtf);
//        bill.add(excessCash);


//======================================================================

        cancel = new JButton("Hủy");
        cancel.setBackground(Color.WHITE);
        cancel.setBounds(5, 700, 70, 80);
        cancel.setFont(new Font("Calibri", Font.BOLD, 20));
        cancel.setFocusPainted(false);
        cancel.addActionListener(this);

        check = new JButton("Check");
        check.setBackground(Color.WHITE);
        check.setBounds(85, 700, 110, 80);
        check.setFont(new Font("Calibri", Font.BOLD, 20));
        check.setFocusPainted(false);
        check.addActionListener(this);

        shipbtn = new JButton("Giao hàng");
        shipbtn.setBackground(Color.WHITE);
        shipbtn.setBounds(205, 700, 120, 80);
        shipbtn.setFont(new Font("Calibri", Font.BOLD, 20));
        shipbtn.setFocusPainted(false);
        shipbtn.addActionListener(this);

        pay = new JButton("Thanh toán");
        pay.setBackground(Color.WHITE);
        pay.setBounds(335, 700, 310, 80);
        pay.setFont(new Font("Calibri", Font.BOLD, 30));
        pay.setFocusPainted(false);
        pay.addActionListener(this);

        order.add(add);
        order.add(listHD);
        order.add(paint);
        order.add(jthree);

        order.add(sumMoney);
        order.add(sumMoneytf);
        order.add(typePay);
        order.add(typePaycb);
        order.add(status);
        order.add(ans);

        order.add(cancel);
        order.add(check);
        order.add(shipbtn);
        order.add(pay);

        this.add(info, BorderLayout.WEST);
        this.add(order, BorderLayout.EAST);

        try {
            ShowProduct();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.setVisible(true);

        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        date = dateFormat.format(Calendar.getInstance().getTime());
    }
//===================================================================================
//===================================================================================
//===================================================================================
    public void ShowProduct() throws Exception{
        Connection connect = new DBConnect().getConnect();
        String select = "SELECT `MaSP`, `TenSP`, `GiaSP` FROM `sanpham` WHERE 1";
        Statement sta = connect.createStatement();
        ResultSet result = sta.executeQuery(select);
        while(result.next()) {
            list.add(new Item(result.getString("MaSP"), result.getString("TenSP"), result.getInt("GiaSP"), billtbl));
        }
        result.close();
        connect.close();
    }
    public void input() {
        idHd = ItemBill.id;
        type = (String) typePaycb.getSelectedItem();
        names = namestaff;
        id = idstaff;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            input();
            Bill bill = new Bill(idHd, idstaff, namestaff, date, type, sumMoneyTf);
            try {
                bC.insert(bill);
                listHD.add(new ItemBill(billtbl, "HD" + bC.selectLast()));
                listHD.revalidate();
                listHD.repaint();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == pay) {
            input();
            Bill bill = new Bill(idHd, id, names, date, type, Integer.valueOf(sumMoneytf.getText()));
            try {
                bC.update(bill);
                List<Bill> ListBill = bC.selectAll();
                listHD.removeAll();
                listHD.revalidate();
                listHD.repaint();
                for (Bill b : ListBill)
                    listHD.add(new ItemBill(billtbl, "HD" + b.getIdBill()));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            JOptionPane.showMessageDialog(null, "Thanh toán thành công");
//            excessCashtf.setText(String.valueOf(Integer.valueOf(moneyOfClient.getText()) - Integer.valueOf(sumMoney.getText())));
            ans.setText("Đã thanh toán");
        }
        if (e.getSource() == check) {
            sumMoneytf.setText(String.valueOf(sumMoneyTf));

        }
    }
}
