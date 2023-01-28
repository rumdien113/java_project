package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewSellCient extends JFrame implements ActionListener {

    JPanel info, list;
    JLabel idlb, namelb, sdtlb, scorelb, addresslb;
    JScrollPane showlist;
    JTextField idtf, nametf, sdttf, scoretf, addresstf;
    JButton addbtn, updatebtn;
    JTable listClient;
    Font font = new Font("Tahoma", Font.BOLD, 15);
    public ViewSellCient() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Dev Coffee: Khách hàng");
        this.setLayout(new BorderLayout(5, 5));
        this.setSize(805, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        info = new JPanel();
        info.setLayout(null);
        info.setPreferredSize(new Dimension(400, 550));
        info.setBackground(new Color(255,248,220));
        info.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        idlb = new JLabel("Mã KH:");
        idlb.setBounds(10, 10, 100, 20);
        idlb.setFont(font);

        idtf = new JTextField();
        idtf.setBounds(10, 35, 380, 30);

        namelb = new JLabel("Tên KH:");
        namelb.setBounds(10, 70, 100, 20);
        namelb.setFont(font);

        nametf = new JTextField();
        nametf.setBounds(10, 95, 380, 30);

        sdtlb = new JLabel("SĐT:");
        sdtlb.setBounds(10, 130, 100, 20);
        sdtlb.setFont(font);

        sdttf = new JTextField();
        sdttf.setBounds(10, 155, 380, 30);

        scorelb = new JLabel("Điểm TL:");
        scorelb.setBounds(10, 190, 100, 20);
        scorelb.setFont(font);

        scoretf = new JTextField("0");
        scoretf.setBounds(10, 215, 380, 30);

        addresslb = new JLabel("Địa chỉ:");
        addresslb.setBounds(10, 250, 100, 20);
        addresslb.setFont(font);

        addresstf = new JTextField();
        addresstf.setBounds(10, 275, 380, 150);

        addbtn = new JButton("Thêm");
        addbtn.setFont(new Font("Tahoma", Font.BOLD, 25));
        addbtn.setBounds(50, 440, 150, 50);
        addbtn.setBackground(Color.WHITE);

        updatebtn = new JButton("Cập nhật");
        updatebtn.setFont(new Font("Tahoma", Font.BOLD, 25));
        updatebtn.setBounds(220, 440, 150, 50);
        updatebtn.setBackground(Color.WHITE);

        info.add(idlb);
        info.add(idtf);
        info.add(namelb);
        info.add(nametf);
        info.add(sdtlb);
        info.add(sdttf);
        info.add(scorelb);
        info.add(scoretf);
        info.add(addresslb);
        info.add(addresstf);
        info.add(addbtn);
        info.add(updatebtn);

//==========================================================================

        list = new JPanel();
        list.setPreferredSize(new Dimension(400, 550));
        list.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        list.setBackground(new Color(255,248,220));
        list.setLayout(null);

        listClient = new JTable();
        showlist = new JScrollPane();
        listClient.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Mã KH", "Tên KH", "SĐT", "Điểm"
                }
        ));
        showlist.setBounds(5, 10, 375, 530);
        showlist.setViewportView(listClient);

        list.add(showlist);

        this.add(info, BorderLayout.WEST);
        this.add(list, BorderLayout.CENTER);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
