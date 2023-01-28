package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewHomePage extends JFrame implements ActionListener {
    ViewLogin login;
    ViewSell sellContent = new ViewSell();
    ViewBill billContent = new ViewBill();
    ViewProduct productContent = new ViewProduct();
    ViewPromotion promotionContent = new ViewPromotion();
    ViewStatistic statisticContent = new ViewStatistic();
    ViewStaff staffContent = new ViewStaff();

    JPanel Header, AllContent, SideBar, Content;
    JPanel logo, button;
    JButton shift, changePassword, logOut;
    JButton homePage, sell, bill, product, promotion, statistical, staff;
    //      trang chủ, bán hàng, hóa đơn, sản phẩm, khuyến mãi, thống kê, nhân viên
    JLabel logoLabel, nameTag, home_content;
    ImageIcon logoIM, homeIM, sellIM, billIM, productIM, promoIM, statistIM, staffIM, contentHomePage;
    Color coffee = new Color(156, 112, 85);
    Color white = new Color(255, 255, 255);
    Font fontButton = new Font("Italic", Font.BOLD, 20);
    CardLayout cl = new CardLayout();

    public ViewHomePage() {
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
        Header.setBackground(coffee);
        Header.setPreferredSize(new Dimension(1660, 40));

        shift = new JButton("Giao ca");
        shift.setBackground(white);
        shift.addActionListener(this);

        changePassword = new JButton("Đổi mật khẩu");
        changePassword.setBackground(white);

        logOut = new JButton("Đăng xuất");
        logOut.setBackground(white);

        nameTag = new JLabel("Welcome to cafe dev");
        nameTag.setForeground(white);

        Header.add(shift);
        Header.add(changePassword);
        Header.add(logOut);
        Header.add(nameTag);

        //===============================Content===============================
        Content = new JPanel();
        Content.setLayout(cl);
        Content.setBackground(new Color(255,248,220));

        home_content = new JLabel();
        home_content.setIcon(contentHomePage);

        Content.add("homePage", home_content);
        Content.add("sell", sellContent);
        Content.add("bill", billContent);
        Content.add("product", productContent);
        Content.add("promotion", promotionContent);
        Content.add("statistic", statisticContent);
        Content.add("staff", staffContent);

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
        homePage.addActionListener(this);

        sell = new JButton("Bán hàng");
        sell.setIcon(sellIM);
        sell.setBackground(coffee);
        sell.setFont(fontButton);
        sell.setForeground(white);
        sell.setBorder(BorderFactory.createRaisedBevelBorder());
        sell.setSize(160, 30);
        sell.addActionListener(this);

        bill = new JButton("Hóa đơn");
        bill.setIcon(billIM);
        bill.setBackground(coffee);
        bill.setFont(fontButton);
        bill.setForeground(white);
        bill.setBorder(BorderFactory.createRaisedBevelBorder());
        bill.setSize(160, 30);
        bill.addActionListener(this);

        product = new JButton("Sản phẩm");
        product.setIcon(productIM);
        product.setBackground(coffee);
        product.setFont(fontButton);
        product.setForeground(white);
        product.setBorder(BorderFactory.createRaisedBevelBorder());
        product.setSize(160, 30);
        product.addActionListener(this);

        promotion = new JButton("Khuyến mãi");
        promotion.setIcon(promoIM);
        promotion.setBackground(coffee);
        promotion.setFont(fontButton);
        promotion.setForeground(white);
        promotion.setBorder(BorderFactory.createRaisedBevelBorder());
        promotion.setSize(160, 30);
        promotion.addActionListener(this);

        statistical = new JButton("Thống kê");
        statistical.setIcon(statistIM);
        statistical.setBackground(coffee);
        statistical.setFont(fontButton);
        statistical.setForeground(white);
        statistical.setBorder(BorderFactory.createRaisedBevelBorder());
        statistical.setSize(160, 30);
        statistical.addActionListener(this);

        staff = new JButton("Nhân viên");
        staff.setIcon(staffIM);
        staff.setBackground(coffee);
        staff.setFont(fontButton);
        staff.setForeground(white);
        staff.setBorder(BorderFactory.createRaisedBevelBorder());
        staff.setSize(160, 30);
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == shift)
            login = new ViewLogin();
        if (e.getSource() == homePage)
            cl.show(Content, "homePage");
        if (e.getSource() == sell)
            cl.show(Content, "sell");
        if (e.getSource() == product)
            cl.show(Content, "product");
        if (e.getSource() == staff)
            cl.show(Content, "staff");
        if (e.getSource() == bill)
            cl.show(Content, "bill");
        if (e.getSource() == promotion)
            cl.show(Content, "promotion");
        if (e.getSource() == statistical)
            cl.show(Content, "statistic");
    }
}
