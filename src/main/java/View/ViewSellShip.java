package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewSellShip extends JFrame implements ActionListener {

    JLabel namelb, sdtlb, moneylb, addresslb;
    JTextField nametf, sdttf, moneytf, addresstf;
    JButton confirm;
    Font font = new Font("Tahoma", Font.BOLD, 15);

    public ViewSellShip() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Dev Coffee: Giao hàng");
        this.setLayout(null);
        this.setSize(515, 450);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(255, 248, 220));

        namelb = new JLabel("Họ và tên:");
        namelb.setFont(font);
        namelb.setBounds(5, 10, 150, 20);

        nametf = new JTextField();
        nametf.setBounds(5, 35, 490, 30);

        sdtlb = new JLabel("Số điện thoại:");
        sdtlb.setFont(font);
        sdtlb.setBounds(5, 70, 150, 20);

        sdttf = new JTextField();
        sdttf.setBounds(5, 95, 490, 30);

        moneylb = new JLabel("Phí ship:");
        moneylb.setFont(font);
        moneylb.setBounds(5, 130, 150, 20);

        moneytf = new JTextField("0đ");
        moneytf.setBounds(5, 155, 490, 30);

        addresslb = new JLabel("Địa chỉ:");
        addresslb.setFont(font);
        addresslb.setBounds(5, 190, 150, 20);

        addresstf = new JTextField();
        addresstf.setBounds(5, 215, 490, 100);

        confirm = new JButton("Xác nhận");
        confirm.setBounds(150, 325, 200, 50);
        confirm.setBackground(Color.WHITE);
        confirm.setFont(font);

        this.add(namelb);
        this.add(nametf);
        this.add(sdtlb);
        this.add(sdttf);
        this.add(moneylb);
        this.add(moneytf);
        this.add(addresslb);
        this.add(addresstf);
        this.add(confirm);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
