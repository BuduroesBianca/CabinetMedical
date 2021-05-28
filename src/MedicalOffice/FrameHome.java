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

    private JPanel contentPane;


    public static void main(String[] args)
    {

        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    FrameHome frame = new FrameHome();
                    frame.setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    public FrameHome()//constructor
    {

        Audit audit = Audit.getAuditInstance();
        setTitle("Home");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 500);


        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0,0));
        contentPane.setBackground(Color.decode("#FFFFFF"));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnPacients = new JButton("Pacients");
        JButton btnDoctors = new JButton("Doctors");
        JButton btnAppointments = new JButton("Appointments");

        btnPacients.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                audit.auditServicePacients("Open Frame Pacients");
                FramePacients frame = new FramePacients();
                frame.setVisible(true);
            }
        });
        btnDoctors.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                audit.auditServiceDoctors("Open Frame Doctors");
                FrameDoctors frame = new FrameDoctors();
                frame.setVisible(true);
            }
        });

        btnAppointments.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                audit.auditServiceAppointments("Open Frame Appointments");
                FrameAppointments frame = new FrameAppointments();
                frame.setVisible(true);

            }
        });

        btnPacients.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
        btnPacients.setBackground(Color.decode("#E24748"));
        btnPacients.setForeground(Color.WHITE);
        btnPacients.setBounds(90, 100, 500, 50);
        contentPane.add(btnPacients);
        btnPacients.setVisible(true);

        btnDoctors.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
        btnDoctors.setBackground(Color.decode("#2F3A56"));
        btnDoctors.setForeground(Color.WHITE);
        btnDoctors.setBounds(90, 200, 500, 50);
        contentPane.add(btnDoctors);
        btnDoctors.setVisible(true);

        btnAppointments.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
        btnAppointments.setBackground(Color.decode("#406D96"));
        btnAppointments.setForeground(Color.WHITE);
        btnAppointments.setBounds(90, 300, 500, 50);
        contentPane.add(btnAppointments);


    }
}
