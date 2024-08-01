package bankmanagementsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel label,image;
    JButton amount1,amount2,amount3,amount4,amount5,amount6,amount7;
    String pin;

    FastCash(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 960, 1080);
        add(image);

        label= new JLabel("SELECT WITHDRAWL AMOUNT");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System", Font.BOLD, 16));

        amount1 = new JButton("Rs 100");
        amount2 = new JButton("Rs 500");
        amount3 = new JButton("Rs 1000");
        amount4 = new JButton("Rs 2000");
        amount5 = new JButton("Rs 5000");
        amount6 = new JButton("Rs 10000");
        amount7 = new JButton("BACK");

        setLayout(null);

        label.setBounds(235, 400, 700, 35);
        image.add(label);

        amount1.setBounds(170, 499, 150, 35);
        image.add(amount1);

        amount2.setBounds(390, 499, 150, 35);
        image.add(amount2);

        amount3.setBounds(170, 543, 150, 35);
        image.add(amount3);

        amount4.setBounds(390, 543, 150, 35);
        image.add(amount4);

        amount5.setBounds(170, 588, 150, 35);
        image.add(amount5);

        amount6.setBounds(390, 588, 150, 35);
        image.add(amount6);

        amount7.setBounds(390, 633, 150, 35);
        image.add(amount7);

        amount1.addActionListener(this);
        amount2.addActionListener(this);
        amount3.addActionListener(this);
        amount4.addActionListener(this);
        amount5.addActionListener(this);
        amount6.addActionListener(this);
        amount7.addActionListener(this);

        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //k
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } String num = "17";
            if (ae.getSource() != amount7 && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == amount7) {
                this.setVisible(false);
                new Transactions(pin).setVisible(true);
            }else{
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
