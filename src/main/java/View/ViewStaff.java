package View;

//import com.raven.datechooser.DateChooser;
//import com.raven.datechooser.EventDateChooser;
//import com.raven.datechooser.SelectedAction;
//import com.raven.datechooser.SelectedDate;

import Controller.StaffController;
import DAO.DBConnect;
import DAO.StaffDAO;
import Model.Staff;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.List;


public class ViewStaff extends JPanel implements ActionListener {

    StaffController stC = new StaffController();
    JPanel info, list;
    JLabel picturelb, info_idlb, info_namelb, info_sexlb, info_birthlb, info_maillb, info_sdtlb, info_partlb, info_notelb, info_statuslb,
            list_namelb, list_partlb, list_statuslb;
    JTextField info_idtf, info_nametf, info_birthtf, info_mailtf, info_sdttf,
            list_nametf;
    JTextArea info_notetf;
    JComboBox info_partcb, info_statuscb, list_partcb, list_statuscb;
    JButton addbtn, updatebtn, deletebtn, search;
//    JDateChooser calendar;
    JScrollPane listScroll;
    JTable listTableStaff;
    JRadioButton male, female;
    ButtonGroup sexBg;
    Font font= new Font("Tahoma", Font.BOLD, 20);
    Font font1= new Font("Tahoma", Font.BOLD, 15);
    String[] listStaff = {"Tất cả", "Thu ngân", "Pha chế", "Quản lí"};
//    public DateChooser dateChooser;
    String id, name, sex, birth, mail, sdt, part, status, idtmp;
    DefaultTableModel tbl = new DefaultTableModel();
    public ViewStaff() {
        this.setLayout(new BorderLayout());
//                ĐÂY NÈ MÁAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
//===========================================================================
//        dateChooser = new DateChooser();
//        dateChooser.addEventDateChooser(new EventDateChooser() {
//            @Override
//            public void dateSelected(SelectedAction action, SelectedDate date) {
//                System.out.println(date.getDay() + "-" + date.getMonth() + "-" + date.getYear());
//                if (action.getAction() == SelectedAction.DAY_SELECTED) {
//                    dateChooser.hidePopup();
//                }
//            }
//        });
//=============================================================================

        info = new JPanel();
        info.setBackground(new Color(255,248,220));
        info.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        info.setPreferredSize(new Dimension(650, 1025));
        info.setLayout(null);

        picturelb = new JLabel();
        picturelb.setBounds(300, 10, 150, 150);
        picturelb.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        picturelb.setBackground(Color.green);
        picturelb.setOpaque(true);

        info_idlb = new JLabel("Mã NV:");
        info_idlb.setFont(font);
        info_idlb.setBounds(20, 170, 150, 25);

        info_idtf = new JTextField();
        info_idtf.setBounds(200, 170, 370, 25);

        info_namelb = new JLabel("Họ tên:");
        info_namelb.setFont(font);
        info_namelb.setBounds(20, 215, 150, 25);

        info_nametf = new JTextField();
        info_nametf.setBounds(200, 215, 370, 25);

        info_sexlb = new JLabel("Giới tính:");
        info_sexlb.setFont(font);
        info_sexlb.setBounds(20, 260, 170, 25);

        //      =========================================================
        male = new JRadioButton("Nam");
        male.setFont(font);
        male.setBounds(200, 260, 75, 25);
        male.setBackground(null);
        male.setActionCommand("Nam");

        female = new JRadioButton("Nữ");
        female.setFont(font);
        female.setBounds(300, 260, 75, 25);
        female.setBackground(null);
        female.setActionCommand("Nữ");

        sexBg = new ButtonGroup();
        sexBg.add(male);
        sexBg.add(female);

        info_birthlb = new JLabel("Ngày sinh:");
        info_birthlb.setFont(font);
        info_birthlb.setBounds(20, 300, 120, 25);

        info_birthtf = new JTextField();
        info_birthtf.setBounds(200, 300, 370, 25);

        info_maillb = new JLabel("Email:");
        info_maillb.setFont(font);
        info_maillb.setBounds(20, 340, 120, 25);

        info_mailtf = new JTextField();
        info_mailtf.setBounds(200, 340, 370, 25);

        info_sdtlb = new JLabel("SĐT:");
        info_sdtlb.setFont(font);
        info_sdtlb.setBounds(20, 380, 120, 25);

        info_sdttf = new JTextField();
        info_sdttf.setBounds(200, 380, 370, 25);

        info_partlb = new JLabel("Vai trò:");
        info_partlb.setFont(font);
        info_partlb.setBounds(20, 460, 120, 25);

        info_partcb = new JComboBox<>(new String[] {"Quản lí", "Thu ngân", "Pha chế"});
        info_partcb.setBounds(200, 460, 370, 25);
        info_partcb.addActionListener(this);

        info_notelb = new JLabel("Ghi chú:");
        info_notelb.setFont(font);
        info_notelb.setBounds(20, 500, 120, 25);

        info_notetf = new JTextArea();
        info_notetf.setBounds(200, 500, 370, 100);
        info_notetf.setBorder(BorderFactory.createLineBorder(Color.black));

        info_statuslb = new JLabel("Trạng thái");
        info_statuslb.setFont(font);
        info_statuslb.setBounds(20, 610, 120, 25);

        info_statuscb = new JComboBox<>(new String[] {"Đang làm", "Nghỉ phép"});
        info_statuscb.setBounds(200, 610, 370, 25);
        info_statuscb.addActionListener(this);

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
        info.add(info_idlb);
        info.add(info_idtf);
        info.add(info_namelb);
        info.add(info_nametf);
        info.add(info_sexlb);
        info.add(male);
        info.add(female);
        info.add(info_birthlb);
        info.add(info_birthtf);
        info.add(info_maillb);
        info.add(info_mailtf);
        info.add(info_sdtlb);
        info.add(info_sdttf);
        info.add(info_partlb);
        info.add(info_partcb);
        info.add(info_notelb);
        info.add(info_notetf);
        info.add(info_statuslb);
        info.add(info_statuscb);
        info.add(addbtn);
        info.add(updatebtn);
        info.add(deletebtn);

//=========================================================================

        list = new JPanel();
        list.setBackground(new Color(255,248,220));
        list.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        list.setPreferredSize(new Dimension(650, 1025));
        list.setLayout(null);

        list_namelb = new JLabel("Tên nhân viên");
        list_namelb.setBounds(20, 60, 125, 25);
        list_namelb.setFont(font1);

        list_nametf = new JTextField();
        list_nametf.setBounds(20, 90, 225, 25);

        search = new JButton("Tìm");
        search.setBackground(Color.WHITE);
        search.setBounds(250, 90, 75, 25);
        search.setFont(font1);
        search.addActionListener(this);

        list_partlb = new JLabel("Vai trò");
        list_partlb.setFont(font1);
        list_partlb.setBounds(330, 60, 125, 25);

        list_partcb = new JComboBox<>(listStaff);
        list_partcb.setBounds(330, 90, 150, 25);

        list_statuslb = new JLabel("Trạng thái");
        list_statuslb.setBounds(485, 60, 150, 25);
        list_statuslb.setFont(font1);

        list_statuscb = new JComboBox<>(new String[] {"Tất cả", "Đang làm", "Nghỉ phép"});
        list_statuscb.setBounds(485, 90, 150, 25);

        listTableStaff = new JTable();
        listTableStaff.setModel(tbl);
        listScroll = new JScrollPane();

        tbl.addColumn("Mã NV");
        tbl.addColumn("Tên NV");
        tbl.addColumn("Giới tính");
        tbl.addColumn("Ngày sinh");
        tbl.addColumn("Email");
        tbl.addColumn("SĐT");
        tbl.addColumn("Chức vụ");
        tbl.addColumn("Trạng thái");
//===================  ĐANG LÀM  =============================
//        listTableStaff.addMouseListener(this);
        try {
            StaffList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        MouseClicked mouseClicked = new MouseClicked();
        listTableStaff.addMouseListener(mouseClicked);

        listScroll.setBounds(10, 130, 625, 550);
        listScroll.setViewportView(listTableStaff);

        list.add(list_namelb);
        list.add(list_nametf);
        list.add(search);
        list.add(list_partlb);
        list.add(list_partcb);
        list.add(list_statuslb);
        list.add(list_statuscb);
        list.add(listScroll);

        this.add(info, BorderLayout.WEST);
        this.add(list, BorderLayout.EAST);

        this.setVisible(true);
    }
//==============================================================================
//==============================================================================
    void input() {
        id = info_idtf.getText();
        name = info_nametf.getText();
        sex = sexBg.getSelection().getActionCommand();
        birth = info_birthtf.getText();
        mail = info_mailtf.getText();
        sdt = info_sdttf.getText();
        part = (String) info_partcb.getSelectedItem();
        status = (String) info_statuscb.getSelectedItem();
    }
    void inputReset() {
        info_idtf.setText("");
        info_nametf.setText("");
        sexBg.setSelected(male.getModel(), false);
        sexBg.setSelected(female.getModel(), false);
        info_birthtf.setText("");
        info_mailtf.setText("");
        info_sdttf.setText("");
        info_partcb.setSelectedItem(0);
        info_statuscb.setSelectedItem(0);
    }
    public void StaffList() throws Exception {
        tbl.setRowCount(0);
        List<Staff> listS = stC.selectAll();
        for (Staff s : listS) {
            Object Staffs[] = {
                    s.getId(),
                    s.getName(),
                    s.getSex(),
                    s.getBirth(),
                    s.getMail(),
                    s.getSdt(),
                    s.getPart(),
                    s.getStatus()
            };
            tbl.addRow(Staffs);
            tbl.fireTableDataChanged();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addbtn) {
            input();
            Staff s = new Staff(id, name, sex, birth, mail, sdt, part, status);
            try {
                stC.insert(s);
                StaffList();
                inputReset();
                JOptionPane.showMessageDialog(null, "Thêm thành công");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        if(e.getSource() == updatebtn) {
            input();
            try {
                Staff s = new Staff(id,name, sex, birth, mail, sdt, part, status);
                stC.update(s);
                StaffList();
                inputReset();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
            }
        }
        if(e.getSource() == deletebtn) {
            input();
            try {
                stC.Delete(id);
                StaffList();
                inputReset();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Xóa không thành công");
            }
        }

        if(e.getSource() == search) {
            name = list_nametf.getText();
            part = (String) list_partcb.getSelectedItem();
            status = (String) list_statuscb.getSelectedItem();
            try {
                stC.Search(tbl, name, part, status);
                list_nametf.setText("");
                list_partcb.setSelectedItem(0);
                list_statuscb.setSelectedItem(0);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private class MouseClicked extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            int selectRow = listTableStaff.getSelectedRow();
            if (selectRow >= 0) {
                info_idtf.setText(tbl.getValueAt(selectRow, 0).toString());
                info_nametf.setText(tbl.getValueAt(selectRow, 1).toString());
                male.setSelected(tbl.getValueAt(selectRow, 2).equals("Nam"));
                female.setSelected(tbl.getValueAt(selectRow, 2).equals("Nữ"));
                info_birthtf.setText(tbl.getValueAt(selectRow, 3).toString());
                info_mailtf.setText(tbl.getValueAt(selectRow, 4).toString());
                info_sdttf.setText(tbl.getValueAt(selectRow, 5).toString());
                info_partcb.setSelectedItem(tbl.getValueAt(selectRow, 6));
                info_statuscb.setSelectedItem(tbl.getValueAt(selectRow, 7));
                idtmp = info_idtf.getText();
            }
        }
    }
}