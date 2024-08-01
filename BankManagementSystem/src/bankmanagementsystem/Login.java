package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    JButton login, signup, clear;
    JTextField card;
    JPasswordField pin1;
    Login(){
        //Frame f = new Frame();
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Railway", Font.BOLD,28));
        cardno.setBounds(120,150,150,40);
        add(cardno);
        
        card = new JTextField();
        card.setBounds(300,160,230,30);
        card.setFont(new Font("Arial",Font.BOLD,14));
        add(card);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Railway", Font.BOLD,28));
        pin.setBounds(120,220,250,40);
        add(pin);
        
        pin1 = new JPasswordField();
        pin1.setBounds(300,230,230,30);
        pin1.setFont(new Font("Arial",Font.BOLD,14));
        add(pin1);
        
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        signup= new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);   
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            card.setText("");
            pin1.setText("");
        }else if (ae.getSource() == login){
            Conn co = new Conn();
            String cardnumber = card.getText();
            String pinnumber = pin1.getText();
            String query = "select *from login where card_No ='"+cardnumber+"' and pin_No = '"+pinnumber+"';";
            try{
                ResultSet rs=co.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Card Number or PIN Number");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }else if (ae.getSource()== signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String [] args){
        new Login();
    }
}
