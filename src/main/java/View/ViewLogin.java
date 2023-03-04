package View;

import Controller.LoginController;
import View.ViewHomePage;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewLogin extends JFrame implements ActionListener {
    LoginController lC = new LoginController();
    JPanel logo, login;
    JLabel logolb, nameloginlb, passlb;
    JTextField namelogintf;
    JPasswordField passtf;
    JButton loginbtn, cancelbtn;
    Font font = new Font("Tahoma", Font.BOLD, 15);
    String username, password;
    ImageIcon logoIM = new ImageIcon("D:\\CafeDev\\src\\main\\java\\Image\\coffeeWhite.png");

    public ViewLogin() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Dev Coffee: Đăng nhập");
        this.setLayout(new BorderLayout());
        this.setSize(600, 400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(138, 107, 99));

        logo = new JPanel();
        logo.setPreferredSize(new Dimension(304, 400));
        logo.setBackground(null);

        logolb = new JLabel(logoIM);
        logolb.setBackground(null);

        logo.add(logolb);
//============================================================================
        login = new JPanel();
        login.setPreferredSize(new Dimension(296, 400));
        login.setLayout(null);
        login.setBackground(null);

        nameloginlb = new JLabel("Mã nhân viên:");
        nameloginlb.setFont(font);
        nameloginlb.setForeground(Color.WHITE);
        nameloginlb.setBounds(10, 50, 150, 20);

        namelogintf = new JTextField();
        namelogintf.setBounds(10, 75, 250, 30);

        passlb = new JLabel("Mật khẩu:");
        passlb.setFont(font);
        passlb.setForeground(Color.WHITE);
        passlb.setBounds(10, 120, 150, 20);

        passtf = new JPasswordField();
        passtf.setBounds(10, 155, 250, 30);

        loginbtn = new JButton("Đăng nhập");
        loginbtn.setBackground(Color.WHITE);
        loginbtn.setBounds(10, 230, 120, 40);
        loginbtn.setFont(font);
        loginbtn.addActionListener(this);

        cancelbtn = new JButton("Thoát");
        cancelbtn.setBackground(Color.WHITE);
        cancelbtn.setBounds(150, 230, 120, 40);
        cancelbtn.setFont(font);
        cancelbtn.addActionListener(this);

        login.add(nameloginlb);
        login.add(namelogintf);
        login.add(passlb);
        login.add(passtf);
        login.add(loginbtn);
        login.add(cancelbtn);

        this.add(logo, BorderLayout.WEST);
        this.add(login, BorderLayout.CENTER);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelbtn) {
//            this.setVisible(false);
            System.exit(0);
        }
        if (e.getSource() == loginbtn) {
            username = namelogintf.getText();
            password = String.valueOf(passtf.getPassword());
            try {
                if (password.equals(lC.selectpw(username))) {
                    ViewHomePage v = new ViewHomePage(lC.selectName(username).substring(0, 5), lC.selectName(username).substring(5));
                    this.setVisible(false);
                }
                else
                    JOptionPane.showMessageDialog(null, "Sai mật khẩu!!!");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
