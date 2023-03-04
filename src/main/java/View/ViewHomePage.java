package View;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ViewHomePage extends JFrame implements ActionListener {
    private ViewLogin login;
    private ViewSell sellContent;
    private ViewBill billContent;
    private ViewProduct productContent;
    private ViewPromotion promotionContent;
    private ViewStatistic statisticContent;
    private ViewStaff staffContent;
    JPanel Header, AllContent, SideBar, Content;
    JPanel logo, button;
    JButton shift, changePassword, logOut, exit;
    JButton homePage, sell, bill, product, promotion, statistical, staff;
    //      trang chủ, bán hàng, hóa đơn, sản phẩm, khuyến mãi, thống kê, nhân viên
    JLabel logoLabel, nameTag, home_content, timeDate;
    ImageIcon logoIM, homeIM, sellIM, billIM, productIM, promoIM, statistIM, staffIM, contentHomePage;
    Color coffee = new Color(156, 112, 85);
    Color white = new Color(255, 255, 255);
    Font fontButton = new Font("Italic", Font.BOLD, 20);
    Calendar calendar;
    SimpleDateFormat timeFormat;
    String time;
//    CardLayout cl = new CardLayout();
    public static String idStaff, nameStaff;

    public ViewHomePage(String id, String username) {
        idStaff = id; nameStaff = username;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setSize(1920, 1080);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setLayout(new BorderLayout(5, 5));

        logoIM = new ImageIcon("D:\\CafeDev\\src\\main\\java\\Image\\coffee.png");
        homeIM = new ImageIcon("D:\\CafeDev\\src\\main\\java\\Image\\home.png");
        sellIM = new ImageIcon("D:\\CafeDev\\src\\main\\java\\Image\\buy.png");
        billIM = new ImageIcon("D:\\CafeDev\\src\\main\\java\\Image\\bill.png");
        productIM = new ImageIcon("D:\\CafeDev\\src\\main\\java\\Image\\glass.png");
        promoIM = new ImageIcon("D:\\CafeDev\\src\\main\\java\\Image\\sell.png");
        statistIM = new ImageIcon("D:\\CafeDev\\src\\main\\java\\Image\\statistical.png");
        staffIM = new ImageIcon("D:\\CafeDev\\src\\main\\java\\Image\\staff.png");
        contentHomePage = new ImageIcon("D:\\CafeDev\\src\\main\\java\\Image\\Content_homePage.png");

        AllContent = new JPanel();
        AllContent.setLayout(new BorderLayout(5, 5));

        //===============================Header===============================
        Header = new JPanel();
        Header.setLayout(null);
        Header.setBackground(coffee);
        Header.setPreferredSize(new Dimension(1660, 40));

        shift = new JButton("Giao ca");
        shift.setBounds(10, 3, 100, 30);
        shift.setBackground(white);
        shift.setFocusPainted(false);
        shift.addActionListener(this);

        changePassword = new JButton("Đổi mật khẩu");
        changePassword.setBackground(white);
        changePassword.setFocusPainted(false);
        changePassword.setBounds(120, 3, 150, 30);

        logOut = new JButton("Đăng xuất");
        logOut.setBackground(white);
        logOut.setFocusPainted(false);
        logOut.setBounds(280, 3, 100, 30);

        nameTag = new JLabel("Welcome to cafe dev - " + username);
        ViewSell.namestaff = nameStaff;
        ViewSell.idstaff = idStaff;
        nameTag.setFont(new Font("Tahoma", Font.PLAIN, 20));
        nameTag.setForeground(white);
        nameTag.setBounds(390, 3, 700, 30);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        time = timeFormat.format(Calendar.getInstance().getTime());

        timeDate = new JLabel(time);
        timeDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
        timeDate.setForeground(white);
        timeDate.setBounds(1050, 3, 150, 30);

        exit = new JButton("Thoát");
        exit.setBackground(white);
        exit.setFocusPainted(false);
        exit.setBounds(1200, 3, 75, 30);
        exit.addActionListener(this);

        Header.add(shift);
        Header.add(changePassword);
        Header.add(logOut);
        Header.add(nameTag);
        Header.add(timeDate);
        Header.add(exit);

        //===============================Content===============================
        Content = new JPanel();
//        Content.setLayout(cl);
        Content.setBackground(new Color(255,248,220));

        home_content = new JLabel();
        home_content.setIcon(contentHomePage);

        AllContent.add(Header, BorderLayout.NORTH);
        AllContent.add(Content, BorderLayout.CENTER);

        //===============================Sidebar===============================
        logoLabel = new JLabel(logoIM);

        SideBar = new JPanel();
        SideBar.setBackground(coffee);
        SideBar.setPreferredSize(new Dimension(225, 1080));
        SideBar.setLayout(new BorderLayout(0, 0));

        logo = new JPanel();
        logo.setPreferredSize(new Dimension(255, 200));
        logo.setBackground(coffee);
        logo.add(logoLabel);

        button = new JPanel();
        button.setPreferredSize(new Dimension(225, 880));
        button.setLayout(new GridLayout(7, 1));

        homePage = new JButton("Trang chủ");
        homePage.setIcon(homeIM);
        homePage.setBackground(coffee);
        homePage.setFont(fontButton);
        homePage.setForeground(white);
        homePage.setBorder(BorderFactory.createRaisedBevelBorder());
        homePage.setSize(160, 30);
        homePage.setFocusPainted(false);
        homePage.addActionListener(this);

        sell = new JButton("Bán hàng");
        sell.setIcon(sellIM);
        sell.setBackground(coffee);
        sell.setFont(fontButton);
        sell.setForeground(white);
        sell.setBorder(BorderFactory.createRaisedBevelBorder());
        sell.setSize(160, 30);
        sell.setFocusPainted(false);
        sell.addActionListener(this);

        bill = new JButton("Hóa đơn");
        bill.setIcon(billIM);
        bill.setBackground(coffee);
        bill.setFont(fontButton);
        bill.setForeground(white);
        bill.setBorder(BorderFactory.createRaisedBevelBorder());
        bill.setSize(160, 30);
        bill.setFocusPainted(false);
        bill.addActionListener(this);

        product = new JButton("Sản phẩm");
        product.setIcon(productIM);
        product.setBackground(coffee);
        product.setFont(fontButton);
        product.setForeground(white);
        product.setBorder(BorderFactory.createRaisedBevelBorder());
        product.setSize(160, 30);
        product.setFocusPainted(false);
        product.addActionListener(this);

        promotion = new JButton("Khuyến mãi");
        promotion.setIcon(promoIM);
        promotion.setBackground(coffee);
        promotion.setFont(fontButton);
        promotion.setForeground(white);
        promotion.setBorder(BorderFactory.createRaisedBevelBorder());
        promotion.setSize(160, 30);
        promotion.setFocusPainted(false);
        promotion.addActionListener(this);

        statistical = new JButton("Thống kê");
        statistical.setIcon(statistIM);
        statistical.setBackground(coffee);
        statistical.setFont(fontButton);
        statistical.setForeground(white);
        statistical.setBorder(BorderFactory.createRaisedBevelBorder());
        statistical.setSize(160, 30);
        statistical.setFocusPainted(false);
        statistical.addActionListener(this);

        staff = new JButton("Nhân viên");
        staff.setIcon(staffIM);
        staff.setBackground(coffee);
        staff.setFont(fontButton);
        staff.setForeground(white);
        staff.setBorder(BorderFactory.createRaisedBevelBorder());
        staff.setSize(160, 30);
        staff.setFocusPainted(false);
        staff.addActionListener(this);

//        SideBar.add(logoLabel);
        SideBar.add(logo, BorderLayout.NORTH);
        SideBar.add(button, BorderLayout.CENTER);

        button.add(homePage);
        button.add(sell);
        button.add(bill);
        button.add(product);
        button.add(promotion);
        button.add(statistical);
        button.add(staff);

        this.add(SideBar, BorderLayout.WEST);
        this.add(AllContent, BorderLayout.CENTER);
        this.setVisible(true);

//        setTime();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == shift)
            login = new ViewLogin();
        if (e.getSource() == exit)
            System.exit(0);
        if (e.getSource() == homePage) {
            Content.removeAll();
            Content = new JPanel();
            Content.revalidate();
            Content.repaint();
        }
        if (e.getSource() == sell) {
            Content.removeAll();
            sellContent = new ViewSell();
            Content.add(sellContent);
            Content.revalidate();
            Content.repaint();
        }
        if (e.getSource() == product) {
            Content.removeAll();
            productContent = new ViewProduct();
            Content.add(productContent);
            Content.revalidate();
            Content.repaint();
        }
        if (e.getSource() == staff) {
            Content.removeAll();
            staffContent = new ViewStaff();
            Content.add(staffContent);
            Content.revalidate();
            Content.repaint();
        }
        if (e.getSource() == bill) {
            Content.removeAll();
            billContent = new ViewBill();
            Content.add(billContent);
            Content.revalidate();
            Content.repaint();
        }
        if (e.getSource() == promotion) {
            Content.removeAll();
            promotionContent = new ViewPromotion();
            Content.add(promotionContent);
            Content.revalidate();
            Content.repaint();
        }
        if (e.getSource() == statistical) {
            Content.removeAll();
            statisticContent = new ViewStatistic();
            Content.add(statisticContent);
            Content.revalidate();
            Content.repaint();
        }
    }
    public void setTime() {
        while(true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeDate.setText(time);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
