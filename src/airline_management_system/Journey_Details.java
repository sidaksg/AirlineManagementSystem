package airline_management_system;

import javax.crypto.ShortBufferException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.cert.PolicyNode;
import java.sql.ResultSet;
import java.util.jar.JarFile;

public class Journey_Details  extends JFrame {
    JTable table;
    JLabel ReservationDetails, Pnrno, Ticketid, Fcode, Jnydate,Jnytime, Source, Destination, label, label1;
    JButton Show;

    public static void main(String[] args) {
        new Journey_Details();
    }
    public  Journey_Details(){
        setTitle("JOURNEY_DETAILS");
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);
        setVisible(true);

        Source = new JLabel("Source");
        Source.setFont(new Font("Tahoma", Font.PLAIN,19));
        Source.setBounds(60, 100, 150, 27);
        add(Source);

        Destination = new JLabel("Destination");
        Destination.setFont(new Font("Tahoma", Font.PLAIN, 19));
        Destination.setBounds(60, 100, 150, 27);
        add(Destination);

        Show = new JButton("SHOW");
        Show.setBounds(680, 100, 100, 30);
        add(Show);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ReservationDetails = new JLabel("Journey Details");
        ReservationDetails.setForeground(Color.BLUE);
        ReservationDetails.setFont(new Font("Tahoma", Font.PLAIN, 19));
        ReservationDetails.setBounds(280, 27, 360, 32);
        add(ReservationDetails);

        Pnrno = new JLabel("PNR_NO");
        Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 13));
        Pnrno.setBounds(79, 270, 83, 20);
        add(Pnrno);

        Ticketid = new JLabel("TICKET_ID");
        Ticketid.setFont(new Font("Tahoma", Font.PLAIN, 19));
        Ticketid.setBounds(79, 270, 83, 20);
        add(Ticketid);
        Fcode = new JLabel("F_CODE");
        Fcode.setFont(new Font("Tahoma", Font.PLAIN, 13));
        Fcode.setBounds(297, 270, 103, 20);
        add(Fcode);

        Jnydate = new JLabel("JNY_DATE");
        Jnydate.setFont(new Font("Tahoma", Font.PLAIN, 13));
        Jnydate.setBounds(390, 270, 94, 20);
        add(Jnydate);

        Jnytime = new JLabel("JNY_TIME");
        Jnytime.setFont(new Font("Tahoma", Font.PLAIN, 13));
        Jnytime.setBounds(494, 270, 83, 20);
        add(Jnytime);

        Source = new JLabel("SOURCE");
        Source.setFont(new Font("Tahoma", Font.PLAIN, 13));
        Source.setBounds(613, 270, 94, 20);
        add(Source);

        Destination = new JLabel("DESTINATION");
        Destination.setFont(new Font("Tahoma", Font.PLAIN, 13));
        Destination.setBounds(717, 270, 94, 20);
        add(Destination);

        String[] items1 = {"BANGALORE", "MUMBAI", "CHENNAI", "PATNA","DELHI","HYDERABAD"};
        JComboBox comboBox_1 = new JComboBox(items1);
        comboBox_1.setBounds(150, 100, 150, 27);
        add(comboBox_1);

        String[] items2 = {"BANGALORE", "MUMBAI", "CHENNAI", "PATNA","DELHI","HYDERABAD"};
        JComboBox comboBox_2 = new JComboBox(items2);
        comboBox_2.setBounds(150, 100, 150, 27);
        add(comboBox_2);

        Show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String src = (String) comboBox_1.getSelectedItem();
                    String dst = (String) comboBox_2.getSelectedItem();
                    conn c = new conn();
                    String str =  "select * from reservation where src = '"+src+"' and dst = '"+dst+"'";
                    ResultSet rs =c.s.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                }catch (Exception e1){}
            }
        });
table = new JTable();
table.setBounds(38, 310, 770, 130);
add(table);

JScrollPane pane = new JScrollPane(table);
pane.setBounds(23, 250, 800, 300);
pane.setBackground(Color.cyan);
add(pane);
setSize(860, 600);
setLocation(400, 200);
setVisible(true);
    }


}
