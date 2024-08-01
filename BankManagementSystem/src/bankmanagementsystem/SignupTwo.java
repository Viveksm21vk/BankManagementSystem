package bankmanagementsystem;
import java.awt.*;
import javax.swing.*;
//import java.util.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    JLabel additionalDetails,religion,category,income,education,qualification,senior,aadhar,occupy,pan,exist;
    JTextField pan1,aadhar1;
    JComboBox religion1,category1,income1,qual1,occupy1;
    JRadioButton no,yes,yes1,no1;
    ButtonGroup yesgroup1,yesgroup2;
    JButton next;
    SignupTwo(){
        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 2");
        setLayout(null);
        
        additionalDetails = new JLabel("Page 1: Additional Details" );
        additionalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        religion = new JLabel("Religion:" );
        religion.setFont(new Font("Raleway", Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);
        
        String valReligion [] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion1 = new JComboBox(valReligion);
        religion1.setBounds(300,140,400,30);
        religion1.setBackground(Color.white);
        religion1.setFont(new Font("Raleway", Font.BOLD,14));
        add(religion1);
        
        category = new JLabel("Category:" );
        category.setFont(new Font("Raleway", Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);
        
        String valCategory [] = {"SC","ST","OBC","General","Other"};
        category1 = new JComboBox(valCategory);
        category1.setBounds(300,190,400,30);
        category1.setBackground(Color.white);
        category1.setFont(new Font("Raleway", Font.BOLD,14));
        add(category1);
        
        income = new JLabel("Income:" );
        income.setFont(new Font("Raleway", Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);
        
        String valincome [] = {"less than 25000","less than 50000","less than 1Lakh","less than 2Lakh","less than 3Lakh","More than 3Lakh"};
        income1 = new JComboBox(valincome);
        income1.setBounds(300,240,400,30);
        income1.setBackground(Color.white);
        income1.setFont(new Font("Raleway", Font.BOLD,14));
        add(income1);
        
        education = new JLabel("Educational" );
        education.setFont(new Font("Raleway", Font.BOLD,20));
        education.setBounds(100,290,200,30);
        add(education);
        
        qualification = new JLabel("Qualification:" );
        qualification.setFont(new Font("Raleway", Font.BOLD,20));
        qualification.setBounds(100,320,200,30);
        add(qualification);
        
        String valqual [] = {"SSLC","PUC","Bachelor Degree","Master Degree","Ph.D","Under SSLC","Other"};
        qual1 = new JComboBox(valqual);
        qual1.setBounds(300,305,400,30);
        qual1.setBackground(Color.white);
        qual1.setFont(new Font("Raleway", Font.BOLD,14));
        add(qual1);
        
        occupy = new JLabel("Occupation:" );
        occupy.setFont(new Font("Raleway", Font.BOLD,20));
        occupy.setBounds(100,370,200,30);
        add(occupy);
        
        String valoccupy [] = {"Employed","Unemployed","Self-employed","Buissness","Student","Retired","Other"};
        occupy1 = new JComboBox(valoccupy);
        occupy1.setBounds(300,370,400,30);
        occupy1.setBackground(Color.white);
        occupy1.setFont(new Font("Raleway", Font.BOLD,14));
        add(occupy1);
      
        pan = new JLabel("PAN Number:" );
        pan.setFont(new Font("Raleway", Font.BOLD,20));
        pan.setBounds(100,420,200,30);
        add(pan);
        
        pan1 = new JTextField();
        pan1.setFont(new Font("Raleway",Font.BOLD,14));
        pan1.setBounds(300,420,400,30);
        add(pan1);
        
        aadhar = new JLabel("Aadhar Number:" );
        aadhar.setFont(new Font("Raleway", Font.BOLD,20));
        aadhar.setBounds(100,470,200,30);
        add(aadhar);
        
        aadhar1 = new JTextField();
        aadhar1.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar1.setBounds(300,470,400,30);
        add(aadhar1);
        
        senior = new JLabel("Senior Citizen:" );
        senior.setFont(new Font("Raleway", Font.BOLD,20));
        senior.setBounds(100,520,200,30);
        add(senior);
        
        yes = new JRadioButton("Yes");
        yes.setBounds(300,520,100,30);
        yes.setFont(new Font("Raleway",Font.BOLD,14));
        yes.setBackground(Color.white);
        add(yes);
        
        no = new JRadioButton("No");
        no.setBounds(450,520,100,30);
        no.setFont(new Font("Raleway",Font.BOLD,14));
        no.setBackground(Color.white);
        add(no);
        
        yesgroup1 = new ButtonGroup();
        yesgroup1.add(yes);
        yesgroup1.add(no);
        
        exist = new JLabel("Existing Account:" );
        exist.setFont(new Font("Raleway", Font.BOLD,20));
        exist.setBounds(100,570,200,30);
        add(exist);
        
        yes1 = new JRadioButton("Yes");
        yes1.setBounds(300,570,100,30);
        yes1.setFont(new Font("Raleway",Font.BOLD,14));
        yes1.setBackground(Color.white);
        add(yes1);
        
        no1 = new JRadioButton("No");
        no1.setBounds(450,570,100,30);
        no1.setFont(new Font("Raleway",Font.BOLD,14));
        no1.setBackground(Color.white);
        add(no1);
        
        yesgroup2 = new ButtonGroup();
        yesgroup2.add(yes1);
        yesgroup2.add(no1);
        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,640,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setVisible(true);
        setLocation(350,10);
    }
    public void actionPerformed(ActionEvent ae){
        String formno1 = ""+SignupOne.random;
        String religion2 = (String)religion1.getSelectedItem();
        String category2 =(String)category1.getSelectedItem();
        String income2 =(String)income1.getSelectedItem();
        String qual2=(String)qual1.getSelectedItem();
        String occupy2 =(String)occupy1.getSelectedItem();
        String pan2 = pan1.getText();
        String aadhar2 = aadhar1.getText();
        String senior1 = null;
        if(yes.isSelected()){
            senior1= "Yes";
        }else if (no.isSelected()){
            senior1 = "No";
        }
        String haveaccount = null;
        if (yes1.isSelected()){
            haveaccount = "Yes";
        }else if(no1.isSelected()){
            haveaccount = "NO";
        }
        try{
            if(religion2.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else if (category2.equals("")){
                JOptionPane.showMessageDialog(null,"Father Name is Required");
            }else if (income2.equals("")){
                JOptionPane.showMessageDialog(null,"Date of Birth is Required");
            }else if (qual2.equals("")){
                JOptionPane.showMessageDialog(null,"Email is Required");
            }else if (occupy2.equals("")){
                JOptionPane.showMessageDialog(null,"City Name is Required");
            }else if (pan2.equals("")){
                JOptionPane.showMessageDialog(null,"State Name is Required");
            }else if (aadhar2.equals("")){
                JOptionPane.showMessageDialog(null,"Address is Required");
            }else{
                Conn c = new Conn();
                String query = "insert into signup1 values('"+formno1+"','"+religion2+"','"+category2+"','"+income2+"','"+qual2+"','"+occupy2+"','"+pan2+"','"+aadhar2+"','"+senior1+"', '"+haveaccount+"');";
                c.s.executeUpdate(query);
            }                
        }catch(Exception e){    
            System.out.println(e);
        }
        if (ae.getSource()==next){
            setVisible(false);
            new SignupThree().setVisible(true);
        }
    }
 
}
