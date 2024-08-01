
package bankmanagementsystem;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField rupee;
    JButton withdraw,back;
    JLabel withdrawl,amount,image;
    String pin,amount1;
    Withdrawl(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0, 0, 960, 1080);
        add(image);
        
        withdrawl= new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        withdrawl.setForeground(Color.WHITE);
        withdrawl.setFont(new Font("System", Font.BOLD, 16));
        
        amount = new JLabel("PLEASE ENTER YOUR AMOUNT");
        amount.setForeground(Color.WHITE);
        amount.setFont(new Font("System", Font.BOLD, 16));
        
        rupee= new JTextField();
        rupee.setFont(new Font("Raleway", Font.BOLD, 25));
        
        withdraw = new JButton("WITHDRAW");
        back= new JButton("BACK");
        
        setLayout(null);
        
        withdrawl.setBounds(190,350,400,20);
        image.add(withdrawl);
        
        amount.setBounds(190,400,400,20);
        image.add(amount);
        
        rupee.setBounds(190,450,330,30);
        image.add(rupee);
        
        withdraw.setBounds(390,588,150,35);
        image.add(withdraw);
        
        back.setBounds(390,633,150,35);
        image.add(back);
        
        withdraw.addActionListener(this);
        back.addActionListener(this);
        
        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        try{        
            amount1 = rupee.getText();
            Date date = new Date();
            if(ae.getSource()==withdraw){
                if(rupee.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    Conn c1 = new Conn();
                    
                    ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pin+"'");
                    int balance = 0;
                    while(rs.next()){
                       if(rs.getString("type").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("amount"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("amount"));
                       }
                    }
                    if(balance < Integer.parseInt(amount1)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }else if(Integer.parseInt(amount1)>10000){
                        JOptionPane.showMessageDialog(null, "Please enter balance less than 10000");
                        return;
                    }
                    
                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount1+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount1+" Debited Successfully");
                    
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