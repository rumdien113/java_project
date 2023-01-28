package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewPromotion extends JPanel implements ActionListener {

    JPanel info, list;
    JLabel picturelb, idlb, namelb, typelb, valuelb, dayStartlb, dayEndlb, statuslb,
           promotionlb, productlb, type1lb;
    JTextField idtf, nametf, valuetf, dayStarttf, dayEndtf,
               promotiontf, producttf;
    JComboBox typecb, statuscb, type1cb, status1cb;
    JButton addbtn, updatebtn, deletebtn, search1, search2;
    JScrollPane scroll, scroll1;
    JTable promotionTable, productTable;
    JCheckBox check;
    Font font= new Font("Tahoma", Font.BOLD, 20);
    DefaultTableModel tbl = new DefaultTableModel();
    DefaultTableModel tbl1 = new DefaultTableModel();

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

        valuetf = new JTextField();
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

        typecb = new JComboBox<>(new String[] {"%", "Tiền"});
        typecb.setFont(font);
        typecb.setBackground(Color.WHITE);
        typecb.setBounds(255, 45, 100, 30);

        statuslb = new JLabel("Trạng thái");
        statuslb.setFont(font);
        statuslb.setBounds(375, 10, 150, 25);

        statuscb = new JComboBox(new String[] {"Tất cả", "Đang áp dụng", "Ngừng áp dụng"});
        statuscb.setFont(font);
        statuscb.setBackground(Color.WHITE);
        statuscb.setBounds(375, 45, 250, 30);

        promotionTable = new JTable();
        promotionTable.setModel(tbl);
        scroll = new JScrollPane();

        tbl.addColumn("Mã KM");
        tbl.addColumn("Tên KM");
        tbl.addColumn("Loại KM");
        tbl.addColumn("Giá trị");
        tbl.addColumn("Trạng thái");

        scroll.setBounds(10, 85, 615, 200);
        scroll.setViewportView(promotionTable);

        productlb = new JLabel("Tìm sản phẩm");
        productlb.setFont(font);
        productlb.setBounds(10, 300, 170, 25);

        producttf = new JTextField();
        producttf.setBounds(10, 335, 180, 30);

        search2 = new JButton("Tìm");
        search2.setBackground(Color.WHITE);
        search2.setFont(new Font("Tahoma", Font.BOLD, 20));
        search2.setBounds(195, 335, 80, 30);
        search2.addActionListener(this);

        type1lb = new JLabel("Loại sản phẩm");
        type1lb.setFont(font);
        type1lb.setBounds(285, 300, 150, 25);

        type1cb = new JComboBox<>(new String[] {"%", "Tiền"});
        type1cb.setFont(font);
        type1cb.setBackground(Color.WHITE);
        type1cb.setBounds(285, 335, 200, 30);

        check = new JCheckBox("Tất cả");
        check.setFont(font);
        check.setBackground(null);
        check.setBounds(490, 335, 150, 30);

        productTable = new JTable();
        productTable.setModel(tbl1);
        scroll1 = new JScrollPane();

        tbl1.addColumn("Mã SP");
        tbl1.addColumn("Tên SP");
        tbl1.addColumn("Giá cũ");
        tbl1.addColumn("Giá mới");
        tbl1.addColumn("");

        scroll1.setBounds(10, 375, 615, 400);
        scroll1.setViewportView(productTable);

        list.add(promotionlb);
        list.add(promotiontf);
        list.add(typelb);
        list.add(typecb);
        list.add(statuslb);
        list.add(statuscb);
        list.add(scroll);
        list.add(productlb);
        list.add(producttf);
        list.add(search2);
        list.add(type1lb);
        list.add(type1cb);
        list.add(check);
        list.add(scroll1);

        this.add(info, BorderLayout.WEST);
        this.add(list, BorderLayout.EAST);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
