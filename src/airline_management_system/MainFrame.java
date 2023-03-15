package airline_management_system;

import javax.swing.*;
import javax.swing.plaf.synth.ColorType;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
    public  MainFrame(){
        super("AIRLINE MANAGEMENT SYSTEM");
  initialize();
    }
    private  void initialize(){
        setForeground(Color.MAGENTA);
        setLayout(null);
        JLabel NewLabel = new JLabel(" ");
        NewLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/front.jpg")));
        setBounds(0,0,1920, 990);
        add(NewLabel);

        JLabel AirlineMangementSystem = new JLabel("AIRLINE MANAGEMENT SYSTEM");
        AirlineMangementSystem.setForeground(Color.pink);
        AirlineMangementSystem.setFont(new Font("Tahoma", Font.PLAIN, 18));
        AirlineMangementSystem.setBounds(700, 60, 1000, 15 );
        NewLabel.add(AirlineMangementSystem);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu AirlineSystem = new JMenu("AIRLINE SYSTEM");
        AirlineSystem.setForeground(Color.BLUE);
        menuBar.add(AirlineSystem);

        JMenuItem FlightDetails = new JMenuItem("FLIGHT_INFO");
        AirlineSystem.add(FlightDetails);

        JMenuItem ReservationDetails = new JMenuItem("ADD_CUSTOMER_DETAILS");
        AirlineSystem.add(ReservationDetails);

        JMenuItem PassengerDetails = new JMenuItem("JOURNEY_DETAILS");
        AirlineSystem.add(PassengerDetails);

        JMenuItem SectorDetails_1 = new JMenuItem("PAYMENT_DETAILS");
        AirlineSystem.add(SectorDetails_1);

        JMenuItem Cancellation = new JMenuItem("CANCELLATION");
        AirlineSystem.add(Cancellation);

        JMenu exit = new JMenu("Logout");
        exit.setForeground(Color.RED);
        menuBar.add(exit);

        JMenuItem logout = new JMenuItem("LOGOUT");
        exit.add(logout);

        FlightDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Add_Customer();

                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }
        });
        PassengerDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Journey_Details();
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        Cancellation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Cancel();
            }
        });
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login().setVisible(true);
            }
        });
        setSize(1850, 1090);
        setVisible(true);

    }
}
