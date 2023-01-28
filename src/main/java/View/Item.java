package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Item extends JButton implements MouseListener {

    JLabel pic, text, desc;

    public Item(String s, String name, int cost) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setSize(120, 250);
        this.setBackground(new Color(189,107,9));
        this.setBorder(BorderFactory.createLineBorder(new Color(189,107,9), 10));
        this.setName(s);

        pic = new JLabel(new ImageIcon("D:\\CafeDev\\src\\main\\java\\Image\\product\\Bacxiu.jpg"));
//        pic.setBounds(5, 5, 50, 50);

        text = new JLabel(name);
        text.setBounds(5, 60, 50, 20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
//        text.setIconTextGap(-20);

        desc = new JLabel(String.valueOf(cost));
//        desc.setBounds(5, 75, 50, 20);
        desc.setFont(new Font("Tahoma", Font.BOLD, 20));
        desc.setForeground(Color.WHITE);

        this.add(pic);
        this.add(text);
        this.add(desc);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
