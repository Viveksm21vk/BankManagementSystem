package bankmanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {
    static long random;
    JLabel formno,personDetails,name,fname,dob,gender,email,state,city,marry,address,pincode;
    JTextField name1,fname1,email1,state1,city1,address1,pincode1;
    JDateChooser date;
    JRadioButton male,female,yes,no,other;
    ButtonGroup marrygroup,gendergroup;
    JButton next;
    SignupOne(){
        Random ran =new Random(); 
        random = Math.abs((ran.nextLong()%9000L + 1000L));
        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 1");
        setLayout(null);
         
        formno = new JLabel("APPLICATION FORM NO. " + random );
        formno.setFont(new Font("Raleway", Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        personDetails = new JLabel("Page 1: Personal Details" );
        personDetails.setFont(new Font("Raleway", Font.BOLD,22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);
        
        name = new JLabel("Name:" );
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        name1 = new JTextField();
        name1.setFont(new Font("Raleway",Font.BOLD,14));
        name1.setBounds(300,140,400,30);
        add(name1);
        
        fname = new JLabel("Father's Name:" );
        fname.setFont(new Font("Raleway", Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fname1 = new JTextField();
        fname1.setFont(new Font("Raleway",Font.BOLD,14));
        fname1.setBounds(300,190,400,30);
        add(fname1);
        
        dob = new JLabel("Date of Birth:" );
        dob.setFont(new Font("Raleway", Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        date = new JDateChooser();
        date.setBounds(300,249,400,30);
        date.setForeground(Color.black);
        add(date);
        
        gender = new JLabel("Gender:" );
        gender.setFont(new Font("Raleway", Font.BOLD,20));
        gender.setBounds(100,290,100,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.white);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450,290,100,30);
        female.setBackground(Color.white);
        add(female);
        
        gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        email = new JLabel("Email Address:" );
        email.setFont(new Font("Raleway", Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
        email1 = new JTextField();
        email1.setFont(new Font("Raleway",Font.BOLD,14));
        email1.setBounds(300,340,400,30);
        add(email1);
        
        marry = new JLabel("Marital Status:" );
        marry.setFont(new Font("Raleway", Font.BOLD,20));
        marry.setBounds(100,390,200,30);
        add(marry);
        
        yes = new JRadioButton("Married");
        yes.setBounds(300,390,100,30);
        yes.setBackground(Color.white);
        add(yes);
        
        no = new JRadioButton("Unmarried");
        no.setBounds(450,390,100,30);
        no.setBackground(Color.white);
        add(no);
        
        other = new JRadioButton("Other");
        other.setBounds(600,390,100,30);
        other.setBackground(Color.white);
        add(other);
        
        marrygroup = new ButtonGroup();
        marrygroup.add(yes);
        marrygroup.add(no);
        marrygroup.add(other);
        
        address = new JLabel("Address:" );
        address.setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        address1 = new JTextField();
        address1.setFont(new Font("Raleway",Font.BOLD,14));
        address1.setBounds(300,440,400,30);
        add(address1);
        
        city = new JLabel("City:" );
        city.setFont(new Font("Raleway", Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        city1 = new JTextField();
        city1.setFont(new Font("Raleway",Font.BOLD,14));
        city1.setBounds(300,490,400,30);
        add(city1);
        
        state = new JLabel("State:" );
        state.setFont(new Font("Raleway", Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        state1 = new JTextField();
        state1.setFont(new Font("Raleway",Font.BOLD,14));
        state1.setBounds(300,540,400,30);
        add(state1);
        
        pincode = new JLabel("Pin Code:" );
        pincode.setFont(new Font("Raleway", Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        pincode1 = new JTextField();
        pincode1.setFont(new Font("Raleway",Font.BOLD,14));
        pincode1.setBounds(300,590,400,30);
        add(pincode1);
        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setVisible(true);
        setLocation(350,10);
    }
    public void actionPerformed(ActionEvent ae){
        String formno1 = ""+random;
        String name2 = name1.getText();
        String fname2 =fname1.getText();
        String dob2 = ((JTextField) date.getDateEditor().getUiComponent()).getText();
        String gender2 = null;
        if(male.isSelected()){
            gender2 = "Male";
        }else if (female.isSelected()){
            gender2 = "Female";
        }
        String email2 = email1.getText();
        String marital2 = null;
        if (yes.isSelected()){
            marital2 = "Married";
        }else if(no.isSelected()){
            marital2 = "Unmarried";
        }else if(other.isSelected()){
            marital2= "Other";
        }
        String address2 = address1.getText();
        String city2 = city1.getText();
        String state2 = state1.getText();
        String pincode2 = pincode1.getText();
        
        try{
            if(name2.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else if (fname2.equals("")){
                JOptionPane.showMessageDialog(null,"Father Name is Required");
            }else if (dob2.equals("")){
                JOptionPane.showMessageDialog(null,"Date of Birth is Required");
            }else if (email2.equals("")){
                JOptionPane.showMessageDialog(null,"Email is Required");
            }else if (city2.equals("")){
                JOptionPane.showMessageDialog(null,"City Name is Required");
            }else if (state2.equals("")){
                JOptionPane.showMessageDialog(null,"State Name is Required");
            }else if (address2.equals("")){
                JOptionPane.showMessageDialog(null,"Address is Required");
            }else if (pincode2.equals("")){
                JOptionPane.showMessageDialog(null,"Pincode is Required");
            }else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno1+"','"+name2+"','"+fname2+"','"+dob2+"','"+gender2+"','"+email2+"','"+marital2+"','"+address2+"','"+city2+"', '"+state2+"', '"+pincode2+"');";                c.s.executeUpdate(query);
            }                
        }catch(Exception e){    
            System.out.println(e);
        }
        if (ae.getSource()==next){
            setVisible(false);
            new SignupTwo().setVisible(true);
        }
    }

}
