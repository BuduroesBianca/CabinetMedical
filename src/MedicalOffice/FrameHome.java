package MedicalOffice;

//import statement
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class FrameHome extends JFrame
{
    //declare variable
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    //main method
    public static void main(String[] args)
    {
	  /* It posts an event (Runnable)at the end of Swings event list and is
		processed after all other GUI events are processed.*/
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                //try - catch block
                try
                {
                    //Create object of OldWindow
                    FrameHome frame = new FrameHome();
                    //set frame visible true
                    frame.setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public FrameHome()//constructor
    {
        //set frame title
        setTitle("Home");
        //set default close operation
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //set bounds of the frame
        setBounds(100, 100, 700, 500);

        //create object of JPanel
        contentPane = new JPanel();
        //set border
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0,0));
        contentPane.setBackground(Color.decode("#FFFFFF"));
        //set ContentPane
        setContentPane(contentPane);
        //set null
        contentPane.setLayout(null);

        //create object of JButton and set label on it
        JButton btnPacients = new JButton("Pacients");
        JButton btnDoctors = new JButton("Doctors");
        JButton btnAppointments = new JButton("Appointments");
        //add actionListener
        btnPacients.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                //call the object of NewWindow and set visible true
                FramePacients frame = new FramePacients();
                frame.setVisible(true);
                //set default close operation
                //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });
        btnDoctors.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                //call the object of NewWindow and set visible true
                FrameDoctors frame = new FrameDoctors();
                frame.setVisible(true);
                //set default close operation
                //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });

        btnAppointments.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                //call the object of NewWindow and set visible true
                FrameAppointments frame = new FrameAppointments();
                frame.setVisible(true);
                //set default close operation
                //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });

        //set font of the Button
        btnPacients.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
        btnPacients.setBackground(Color.decode("#E24748"));
        btnPacients.setForeground(Color.WHITE);
        //set bounds of the Button
        btnPacients.setBounds(90, 100, 500, 50);
        //add Button into contentPane
        contentPane.add(btnPacients);
        btnPacients.setVisible(true);

        btnDoctors.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
        btnDoctors.setBackground(Color.decode("#2F3A56"));
        btnDoctors.setForeground(Color.WHITE);
        //set bounds of the Button
        btnDoctors.setBounds(90, 200, 500, 50);
        //add Button into contentPane
        contentPane.add(btnDoctors);
        btnDoctors.setVisible(true);

        btnAppointments.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
        btnAppointments.setBackground(Color.decode("#406D96"));
        btnAppointments.setForeground(Color.WHITE);
        //set bounds of the Button
        btnAppointments.setBounds(90, 300, 500, 50);
        //add Button into contentPane
        contentPane.add(btnAppointments);


    }
}
