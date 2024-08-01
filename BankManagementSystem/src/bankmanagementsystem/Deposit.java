package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Deposit extends JFrame implements ActionListener {
    JTextField amount;
    JButton deposit,back;
    JLabel text,image;
    String pin;
    Deposit(String pin){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        this.pin=pin;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        image= new JLabel(i3);
        image.setBounds(0, 0, 960, 1080);
        add(image);
        
        text= new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(190,350,400,35);
        image.add(text);
        
        amount= new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(190,420,320,25);
        image.add(amount);
        
        deposit = new JButton("DEPOSIT");
        deposit.setBounds(390,588,150,35);
        deposit.addActionListener(this);
        image.add(deposit);
        
        
        back = new JButton("BACK");
        back.setBounds(390,633,150,35);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(960,1080);
        setUndecorated(true);
        setLocation(500,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{        
            String amount1 = amount.getText();
            Date date = new Date();
            if(ae.getSource()==deposit){
                if(amount.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    Conn c1 = new Conn();
                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount1+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount1+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }else if(ae.getSource()==back){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
 
}
