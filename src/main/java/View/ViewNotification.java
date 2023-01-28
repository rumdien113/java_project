package View;

import javax.swing.*;
import java.awt.*;

public class ViewNotification extends JFrame {

    JLabel noti;

    public ViewNotification (String s) {
        this.setSize(300, 200);
        this.setTitle("CafeDev: Thông báo");
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        noti = new JLabel(s);
        noti.setVerticalAlignment(JLabel.CENTER);
        noti.setHorizontalAlignment(JLabel.CENTER);
        noti.setFont(new Font("Calibri", Font.BOLD, 25));

        this.add(noti);
        this.setVisible(true);
    }
}
