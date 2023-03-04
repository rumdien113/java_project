package View;

import Controller.BillController;
import Controller.OutExcel;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ViewStatistic extends JPanel implements ActionListener {
    BillController bC = new BillController();
    JPanel title, income,
           now, week, month, setting;
    JLabel titlelb, startlb, endlb,
           nametag, money, countBill, money_setting, count_setting;
    JTextField starttf, endtf, starttf1, endtf1;
    JButton btn, btn1;
    DefaultTableModel tbl = new DefaultTableModel();
    Color cafe = new Color(156, 112, 85);
    Font font = new Font("Calibri", Font.BOLD, 15);
    String start = "", end = "";
    public ViewStatistic() {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.setLocation(0, 0);
        this.setPreferredSize(new Dimension(1300, 820));

        title = new JPanel();
        title.setLayout(null);
        title.setPreferredSize(new Dimension(1300, 120));
        title.setBackground(new Color(255,248,220));

        titlelb = new JLabel("Thống kê doanh thu và sản phẩm");
        titlelb.setFont(new Font("Calibri", Font.BOLD, 35));
        titlelb.setBounds(10, 20, 500, 45);

        btn = new JButton("Xuất TK");
        btn.setBounds(1160, 10, 100, 50);
        btn.setBackground(Color.WHITE);
        btn.addActionListener(this);

        title.add(titlelb);
        title.add(btn);
//======================================================================

        income = new JPanel();
        income.setLayout(null);
        income.setBackground(new Color(255,248,220));
        income.setPreferredSize(new Dimension(1300, 350));

        now = new JPanel();
        now.setLayout(null);
        now.setBackground(cafe);
        now.setBounds(10, 10, 300, 200);

        nametag = new JLabel("Hôm nay");
        nametag.setFont(new Font("Calibri", Font.BOLD, 50));
        nametag.setForeground(Color.WHITE);
        nametag.setBounds(10, 5, 200, 50);

        money = new JLabel("Tiền");
        money.setForeground(Color.WHITE);
        money.setFont(new Font("Calibri", Font.BOLD, 25));
        money.setBounds(10, 70, 250, 40);
        try {
            money.setText("Doanh thu: " + String.valueOf(bC.selectSumMoney("today") + "đ"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        countBill = new JLabel("Số hóa đơn");
        countBill.setForeground(Color.WHITE);
        countBill.setFont(new Font("Calibri", Font.BOLD, 25));
        countBill.setBounds(10, 110, 200, 40);
        try {
            countBill.setText("Số hóa đơn: " + String.valueOf(bC.selectBill("today")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        now.add(nametag);
        now.add(money);
        now.add(countBill);
//==============================================================================
        week = new JPanel();
        week.setLayout(null);
        week.setBackground(cafe);
        week.setBounds(330, 10, 300, 200);

        nametag = new JLabel("7 ngày");
        nametag.setFont(new Font("Calibri", Font.BOLD, 50));
        nametag.setForeground(Color.WHITE);
        nametag.setBounds(10, 5, 200, 50);

        money = new JLabel("Tiền");
        money.setForeground(Color.WHITE);
        money.setFont(new Font("Calibri", Font.BOLD, 25));
        money.setBounds(10, 70, 250, 40);
        try {
            money.setText("Doanh thu: " + String.valueOf(bC.selectSumMoney("week")) + "đ");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        countBill = new JLabel("Số hóa đơn");
        countBill.setForeground(Color.WHITE);
        countBill.setFont(new Font("Calibri", Font.BOLD, 25));
        countBill.setBounds(10, 110, 200, 40);
        try {
            countBill.setText("Số hóa đơn: " + String.valueOf(bC.selectBill("week")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        week.add(nametag);
        week.add(money);
        week.add(countBill);
//===============================================================================
        month = new JPanel();
        month.setLayout(null);
        month.setBackground(cafe);
        month.setBounds(650, 10, 300, 200);

        nametag = new JLabel("Tháng");
        nametag.setFont(new Font("Calibri", Font.BOLD, 50));
        nametag.setForeground(Color.WHITE);
        nametag.setBounds(10, 5, 200, 50);

        money = new JLabel("Tiền");
        money.setForeground(Color.WHITE);
        money.setFont(new Font("Calibri", Font.BOLD, 25));
        money.setBounds(10, 70, 250, 40);
        try {
            money.setText("Doanh thu: " + String.valueOf(bC.selectSumMoney("month")) + "đ");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        countBill = new JLabel("Số hóa đơn");
        countBill.setForeground(Color.WHITE);
        countBill.setFont(new Font("Calibri", Font.BOLD, 25));
        countBill.setBounds(10, 110, 200, 40);
        try {
            countBill.setText("Số hóa đơn: " + String.valueOf(bC.selectBill("month")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        month.add(nametag);
        month.add(money);
        month.add(countBill);
//===============================================================================
        setting = new JPanel();
        setting.setLayout(null);
        setting.setBackground(cafe);
        setting.setBounds(970, 10, 300, 200);

        nametag = new JLabel("Tùy chọn");
        nametag.setFont(new Font("Calibri", Font.BOLD, 50));
        nametag.setForeground(Color.WHITE);
        nametag.setBounds(10, 5, 200, 50);

        money_setting = new JLabel("Tiền");
        money_setting.setForeground(Color.WHITE);
        money_setting.setFont(new Font("Calibri", Font.BOLD, 25));
        money_setting.setBounds(10, 70, 250, 40);

        count_setting = new JLabel("Số hóa đơn");
        count_setting.setForeground(Color.WHITE);
        count_setting.setFont(new Font("Calibri", Font.BOLD, 25));
        count_setting.setBounds(10, 110, 200, 40);

        setting.add(nametag);
        setting.add(money_setting);
        setting.add(count_setting);
//===============================================================================
        startlb = new JLabel("Từ");
        startlb.setFont(font);
        startlb.setBounds(900, 230, 40, 20);

        starttf1 = new JTextField();
        starttf1.setBounds(950, 230, 170, 20);

        endlb = new JLabel("Đến");
        endlb.setFont(font);
        endlb.setBounds(900, 260, 40, 20);

        endtf1 = new JTextField();
        endtf1.setBounds(950, 260, 170, 20);

        btn1 = new JButton("Chọn");
        btn1.setBounds(1160, 230, 100, 50);
        btn1.setBackground(Color.WHITE);
        btn1.addActionListener(this);

        income.add(now);
        income.add(week);
        income.add(month);
        income.add(setting);
        income.add(startlb);
        income.add(starttf1);
        income.add(endlb);
        income.add(endtf1);
        income.add(btn1);

//======================================================================

//        product = new JPanel();
//        product.setLayout(null);
//        product.setBackground(Color.LIGHT_GRAY);
//        product.setPreferredSize(new Dimension(1300, 350));
//
//        titlelb = new JLabel("Thống kê sản phẩm:");
//        titlelb.setFont(font);
//        titlelb.setBounds(10, 10, 300, 30);
//
//        incomeProduct = new JTable();
//        incomeProduct.setModel(tbl);
//        scroll = new JScrollPane();
//
//        tbl.addColumn("Mã SP");
//        tbl.addColumn("Tên SP");
//        tbl.addColumn("Sô Lượng");
//        tbl.addColumn("Trạng Thái");
//
//        scroll.setBounds(10, 40, 700, 300);
//        scroll.setViewportView(incomeProduct);
//
//        startlb = new JLabel("Từ");
//        startlb.setFont(font);
//        startlb.setBounds(720, 50, 40, 20);
//
//        startcal = new JDateChooser();
//        startcal.setBounds(720, 80, 200, 25);
//        startcal.setDateFormatString("YYYY-MM-DD");
//
//        endlb = new JLabel("Đến");
//        endlb.setFont(font);
//        endlb.setBounds(950, 50, 40, 20);
//
//        endcal = new JDateChooser();
//        endcal.setBounds(950, 80, 200, 25);
//        endcal.setDateFormatString("YYYY-MM-DD");
//
//        typelb = new JLabel("Loại sản phẩm");
//        typelb.setFont(font);
//        typelb.setBounds(720, 120, 150, 20);
//
//        typecb = new JComboBox<>(new String[] {"Tất cả", "Trà trái cây", "Đá xay", "Bánh", "Cafe"});
//        typecb.setBounds(720, 150, 150, 25);
//
//        statuslb = new JLabel("Trạng thái");
//        statuslb.setFont(font);
//        statuslb.setBounds(950, 120, 100, 20);
//
//        statuscb = new JComboBox<>(new String[] {"Tất cả", "Đang bán", "Ngừng bán"});
//        statuscb.setBounds(950, 150, 150, 25);
//
//        btn = new JButton("Lọc");
//        btn.setBounds(900, 180, 100, 50);
//        btn.setBackground(Color.WHITE);
//        btn.addActionListener(this);
//
//        product.add(titlelb);
//        product.add(scroll);
//        product.add(startlb);
//        product.add(startcal);
//        product.add(endlb);
//        product.add(endcal);
//        product.add(typelb);
//        product.add(statuslb);
//        product.add(typecb);
//        product.add(statuscb);
//        product.add(btn);

        this.add(title, BorderLayout.NORTH);
        this.add(income, BorderLayout.CENTER);
//        this.add(product, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Chọn")) {
            start = starttf1.getText();
            end = endtf1.getText();
            try {
                money_setting.setText("Doanh thu: " + String.valueOf(bC.selectMoneyDayToDay(start, end)));
                count_setting.setText("Số hóa đơn: " + String.valueOf(bC.selectBillDayToDay(start, end)));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getActionCommand().equals("Xuất TK")) {
            try {
                new OutExcel();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
