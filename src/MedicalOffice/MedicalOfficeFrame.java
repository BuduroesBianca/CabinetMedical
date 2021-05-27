package MedicalOffice;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;

public class MedicalOfficeFrame extends JFrame {
    public MedicalOfficeFrame() throws SQLException {
        Service service = new Service();
        setTitle("Notes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 400);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        setContentPane(contentPane);
        JSplitPane splitPane = new JSplitPane();
        splitPane.setResizeWeight(0.3);
        contentPane.add(splitPane, BorderLayout.CENTER);
        final DefaultListModel<Pacient> notes = new DefaultListModel<>();
        JList<Pacient> list = new JList<>(notes);
        splitPane.setLeftComponent(list);
        JPanel panel = new JPanel();
        splitPane.setRightComponent(panel);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWeights = new double[]{1};
        gridBagLayout.rowWeights = new double[]{1, 0};
        panel.setLayout(gridBagLayout);

    }
}
