package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class SignupThree extends JFrame implements ActionListener{
    JLabel l1,type,card,pinno,number,number2,card1,card2,services;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    ButtonGroup account;
    JButton submit,cancel;
    SignupThree(){
        setLayout(null);
        
        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        type = new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.white);
        r1.setBounds(100,180,150,20);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.white);
        r2.setBounds(350,180,200,20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.white);
        r3.setBounds(100,220,150,20);
        add(r3);
        
        r4 = new JRadioButton("Recuring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.white);
        r4.setBounds(350,220,200,20);
        add(r4);
        
        account = new ButtonGroup();
        account.add(r1);
        account.add(r2);
        account.add(r3);
        account.add(r4);
        
        card = new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);
        
        number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);
        
        card1 = new JLabel("Your 16-digit Card Number");
        card1.setFont(new Font("Raleway",Font.BOLD,12));
        card1.setBounds(100,330,300,20);
        add(card1);
        
        pinno = new JLabel("PIN Number");
        pinno.setFont(new Font("Raleway",Font.BOLD,22));
        pinno.setBounds(100,370,200,30);
        add(pinno);
        
        number2 = new JLabel("XXXX");
        number2.setFont(new Font("Raleway",Font.BOLD,22));
        number2.setBounds(330,370,300,30);
        add(number2);
        
        card2 = new JLabel("Your 4-digit Pin Number");
        card2.setFont(new Font("Raleway",Font.BOLD,12));
        card2.setBounds(100,400,300,20);
        add(card2);
        
        services = new JLabel("Services Required");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,450,400,20);
        add(services);
        
        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.white);
        c1.setFont(new Font("raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);
        
        c4 = new JCheckBox("Email and SMS Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);
        
        c5 = new JCheckBox("Check Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.white);
        c7.setFont(new Font("raleway",Font.BOLD,12));
        c7.setBounds(100,680,600,30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String formno1 = ""+SignupOne.random;
        if (ae.getSource()== submit){
            String accountType = null;
            if (r1.isSelected()){
                accountType = "Saving Account";
            } else if (r2.isSelected()){
                accountType = "Fixed Deposit Account";
            }else if (r3.isSelected()){
                accountType = "Current Account";
            }else if (r4.isSelected()){
                accountType = "Recuring Deposit Account";
            }
            Random ran = new Random();
            String cardnumber = ""+Math.abs((ran.nextLong()%90000000L+5040936000000000L)); 
            String pinnumber = ""+Math.abs((ran.nextLong()%9000L+1000L));
            String facility = "";
            if(c1.isSelected()){
                facility =facility +" ATM Card";
            }else if (c2.isSelected()){
                facility=facility+" Internet Banking";
            }else if(c3.isSelected()){
                facility=facility+" Mobile Banking";
            }else if(c4.isSelected()){
                facility=facility+" Email and SMS alerts";
            }else if(c5.isSelected()){
                facility=facility+" Check Book";
            }else if(c6.isSelected()){
                facility=facility+" E-Statement";
            }
            System.out.println(facility);
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is requored");
                }else{    
                    Conn c=new Conn();
                    String query1 = "insert into signup3 values('"+formno1+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"');";
                    String query2 = "insert into login values('"+formno1+"','"+cardnumber+"','"+pinnumber+"');";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number: "+cardnumber+" \n Pin: "+ pinnumber);
                }
            }catch(Exception e){
                System.out.println(e);
            }
            setVisible(false);
            new Login().setVisible(true);
        }else if (ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }   
    }    

    
}
