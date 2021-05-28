package MedicalOffice;


//import statement
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//create class and extend with JFrame
public class FrameAppointments extends JFrame
{

    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel label;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAppointments;
    private javax.swing.JTextField txtIdPacient;
    private javax.swing.JTextField txtIdDoctor;
    private javax.swing.JTextField txtMotive;
    private javax.swing.JTextField txtHour;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtFieldToUpdate;
    private javax.swing.JTextField txtUpdatedValue;


    AppointmentsDatabase db = AppointmentsDatabase.getDatabaseInstance1();
    List<Appointment> appointments = AppointmentsDatabase.Read();
    Audit audit = Audit.getAuditInstance();

    private JPanel contentPane;

    public FrameAppointments() //constructor
    {
        initComponents();
        fetch();
    }

    private void initComponents() {

        txtIdPacient = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtIdDoctor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMotive = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHour = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFieldToUpdate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtUpdatedValue = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jScrollPane1 = new javax.swing.JScrollPane();
        tblAppointments = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtFieldToUpdate = new javax.swing.JTextField();
        txtUpdatedValue = new javax.swing.JTextField();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Appointments");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", Font.BOLD,12)); // NOI18N
        jLabel1.setText("Id Pacient");
        jLabel1.setVisible(false);
        txtIdPacient.setVisible(false);
        jLabel1.setOpaque(true);
        jLabel1.setBackground(Color.BLACK);
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", Font.BOLD, 12)); // NOI18N
        jLabel2.setText("Id Doctor");
        jLabel2.setVisible(false);
        txtIdDoctor.setVisible(false);
        jLabel2.setOpaque(true);
        jLabel2.setBackground(Color.BLACK);
        jLabel2.setForeground(Color.WHITE);
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", Font.BOLD, 12)); // NOI18N
        jLabel3.setText("Motive");
        jLabel3.setVisible(false);
        txtMotive.setVisible(false);
        jLabel3.setOpaque(true);
        jLabel3.setBackground(Color.BLACK);
        jLabel3.setForeground(Color.WHITE);
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", Font.BOLD,12)); // NOI18N
        jLabel4.setText("Field To Update");
        jLabel4.setVisible(false);
        txtFieldToUpdate.setVisible(false);
        jLabel4.setOpaque(true);
        jLabel4.setBackground(Color.BLACK);
        jLabel4.setForeground(Color.WHITE);
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", Font.BOLD, 12)); // NOI18N
        jLabel5.setText("Updated Value");
        jLabel5.setVisible(false);
        txtUpdatedValue.setVisible(false);
        jLabel5.setOpaque(true);
        jLabel5.setBackground(Color.BLACK);
        jLabel5.setForeground(Color.WHITE);
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", Font.BOLD, 12)); // NOI18N
        jLabel6.setText("Hour");
        jLabel6.setVisible(false);
        txtHour.setVisible(false);
        jLabel6.setOpaque(true);
        jLabel6.setBackground(Color.BLACK);
        jLabel6.setForeground(Color.WHITE);
        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", Font.BOLD,12)); // NOI18N
        jLabel7.setText("Date");
        jLabel7.setVisible(false);
        txtDate.setVisible(false);
        jLabel7.setOpaque(true);
        jLabel7.setBackground(Color.BLACK);
        jLabel7.setForeground(Color.WHITE);
        jLabel7.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", Font.BOLD, 12)); // NOI18N
        jLabel9.setText("Last Name");

        jLabel20 = new JLabel("Please",JLabel.CENTER);
        jLabel20.setFont(new java.awt.Font("Microsoft YaHei UI", Font.BOLD, 14)); // NOI18N
        jLabel20.setText("Please select one of the options above");
        jLabel20.setOpaque(true);
        jLabel20.setBackground(Color.LIGHT_GRAY);
        jLabel20.setAlignmentY(JLabel.CENTER);

        tblAppointments.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "Id","Id Pacient", "Id Doctor", "Motive","Hour","Date"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false,false, false, false,false,false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAppointments.setCellSelectionEnabled(true);
        tblAppointments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAppointmentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAppointments);
        if (tblAppointments.getColumnModel().getColumnCount() > 0) {
            tblAppointments.getColumnModel().getColumn(0).setResizable(false);
        }

        btnSave.setText("Save");
        btnSave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSave.setIconTextGap(0);
        btnSave.setInheritsPopupMenu(true);
        btnSave.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
        btnSave.setBackground(Color.BLACK);
        btnSave.setForeground(Color.WHITE);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpdate.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete1.setText("Delete");
        btnDelete1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDelete1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
        btnDelete1.setBackground(Color.BLACK);
        btnDelete1.setForeground(Color.WHITE);
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        jLabel9 = new JLabel("Appointments Database",JLabel.CENTER);
        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", Font.BOLD, 18));
        //jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
        // jLabel9.setText("Pacients Database");
        jLabel9.setOpaque(true);
        jLabel9.setBackground(Color.decode("#406D96"));
        jLabel9.setForeground(Color.WHITE);
        jLabel9.setSize(1000,200);

        jScrollPane1.setOpaque(true);
        jScrollPane1.setBackground(Color.decode("#d3dde9"));

        jScrollPane1.getViewport().setOpaque(true);
        jScrollPane1.getViewport().setBackground(Color.decode("#d3dde9"));

        tblAppointments.setBackground(Color.decode("#4676b4"));
        tblAppointments.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 11));
        tblAppointments.setForeground(Color.WHITE);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(txtIdPacient, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtIdDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtMotive, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtFieldToUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtUpdatedValue, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtHour, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15)
                                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE,950,Short.MAX_VALUE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGap(20,20,20)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20,20,20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtIdPacient, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtIdDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, 0)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtMotive, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtFieldToUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtUpdatedValue, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtHour, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(90, 90, 90)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {

        if(!txtIdPacient.isVisible() || !txtIdDoctor.isVisible() || !txtMotive.isVisible() || !txtHour.isVisible() || !txtDate.isVisible()) {
            jLabel1.setVisible(true);
            txtIdPacient.setVisible(true);
            jLabel20.setVisible(false);
            jLabel2.setVisible(true);
            txtIdDoctor.setVisible(true);
            jLabel3.setVisible(true);
            txtMotive.setVisible(true);
            jLabel6.setVisible(true);
            txtHour.setVisible(true);
            jLabel7.setVisible(true);
            txtDate.setVisible(true);
            jLabel4.setVisible(false);
            txtUpdatedValue.setVisible(false);
            jLabel5.setVisible(false);
            txtFieldToUpdate.setVisible(false);

        }
        else {

            String idPacient = txtIdPacient.getText().trim();
            String idDoctor = txtIdDoctor.getText().trim();
            String motive = txtMotive.getText().trim();
            String hour = txtHour.getText().trim();
            String date = txtDate.getText().trim();


            if (!idPacient.isEmpty() && !idDoctor.isEmpty() && !motive.isEmpty() && !hour.isEmpty() && !date.isEmpty()) {

                db.addAppointment(Integer.parseInt(idPacient),Integer.parseInt(idDoctor),motive,Integer.parseInt(hour),date);
                Appointment a= new Appointment(Integer.parseInt(idPacient),Integer.parseInt(idDoctor),motive,Integer.parseInt(hour),date);
                appointments.add(a);
                clear();
                fetchLast();
                audit.auditServiceAppointments("Add Appointment");
                jLabel1.setVisible(false);
                txtIdPacient.setVisible(false);
                jLabel2.setVisible(false);
                txtIdDoctor.setVisible(false);
                jLabel3.setVisible(false);
                txtMotive.setVisible(false);
                jLabel6.setVisible(false);
                jLabel7.setVisible(false);
                txtHour.setVisible(false);
                txtDate.setVisible(false);

            } else {
                alert("Please fill in all the details");
            }
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {

        if(!txtFieldToUpdate.isVisible() || !txtUpdatedValue.isVisible())
        {
            jLabel20.setVisible(false);
            txtFieldToUpdate.setVisible(true);
            txtUpdatedValue.setVisible(true);
            txtIdDoctor.setVisible(true);
            txtIdPacient.setVisible(true);
            jLabel4.setVisible(true);
            jLabel5.setVisible(true);
            jLabel1.setVisible(true);
            jLabel2.setVisible(true);
            jLabel3.setVisible(false);
            txtMotive.setVisible(false);
            jLabel6.setVisible(false);
            jLabel7.setVisible(false);
            txtHour.setVisible(false);
            txtDate.setVisible(false);

        }
        else{

            String idPacient = txtIdPacient.getText().trim();
            String idDoctor = txtIdDoctor.getText().trim();

            String fieldToUpdate = txtFieldToUpdate.getText().trim();
            String updatedValue = txtUpdatedValue.getText().trim();

            if (!idPacient.isEmpty() && !idDoctor.isEmpty() && !fieldToUpdate.isEmpty() && !updatedValue.isEmpty()) {

                AppointmentsDatabase.updateAppointment(Integer.parseInt(idPacient),Integer.parseInt(idDoctor),fieldToUpdate,updatedValue);
                DefaultTableModel model = (DefaultTableModel) tblAppointments.getModel();
                model.setRowCount(0);
                fetch();
                alert("Update was successful");
                audit.auditServiceAppointments("Update Appointment");
                txtFieldToUpdate.setVisible(false);
                txtUpdatedValue.setVisible(false);
                txtIdDoctor.setVisible(false);
                txtIdPacient.setVisible(false);
                jLabel5.setVisible(false);
                jLabel4.setVisible(false);
                jLabel1.setVisible(false);
                jLabel2.setVisible(false);
            }
            else {
                alert("There is no such pacient", "Update error");
                clear();
            }}

    }


    private void tblAppointmentsMouseClicked(java.awt.event.MouseEvent evt) {
        int i = tblAppointments.getSelectedRow();
        TableModel model = tblAppointments.getModel();
        txtIdPacient.setText(model.getValueAt(i, 1).toString());
        txtIdDoctor.setText(model.getValueAt(i, 2).toString());
        txtMotive.setText(model.getValueAt(i, 3).toString());
        txtHour.setText(model.getValueAt(i, 4).toString());
        txtDate.setText(model.getValueAt(i, 5).toString());

    }


    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {

        jLabel20.setVisible(true);
        jLabel4.setVisible(false);
        txtUpdatedValue.setVisible(false);
        jLabel5.setVisible(false);
        txtFieldToUpdate.setVisible(false);
        jLabel1.setVisible(false);
        txtIdPacient.setVisible(false);
        jLabel2.setVisible(false);
        txtIdDoctor.setVisible(false);
        jLabel3.setVisible(false);
        txtMotive.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        txtHour.setVisible(false);
        txtDate.setVisible(false);


        int i = tblAppointments.getSelectedRow();
        if (i >= 0) {
            int option = JOptionPane.showConfirmDialog(rootPane,
                    "Are you sure you want to Delete?", "Delete confirmation", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                TableModel model = tblAppointments.getModel();

                String id = model.getValueAt(i, 0).toString();
                if (tblAppointments.getSelectedRows().length == 1) {
                    db.deleteAppointment(Integer.parseInt(id));
                    appointments.remove(tblAppointments.getSelectedRow());
                    DefaultTableModel model1 = (DefaultTableModel) tblAppointments.getModel();
                    model1.setRowCount(0);
                    audit.auditServiceAppointments("Delete Appointment");
                    fetch();
                    clear();
                }
            }
        } else {
            alert("Please select a row to delete");
        }

    }


    public void alert(String a) {
        JOptionPane.showMessageDialog(rootPane, a);
    }
    public void alert(String msg, String title) {
        JOptionPane.showMessageDialog(rootPane, msg, title, JOptionPane.ERROR_MESSAGE);
    }

    private void clear() {
        txtIdPacient.setText("");
        txtIdDoctor.setText("");
        txtMotive.setText("");
        txtDate.setText("");
        txtHour.setText("");
        txtUpdatedValue.setText("");
        txtFieldToUpdate.setText("");
    }

    private void fetchLast() {
        DefaultTableModel model = (DefaultTableModel) tblAppointments.getModel();

        Appointment a = appointments.get(appointments.size()-1);
        Object[] row = new Object[6];
        row[0] = a.getId();
        row[1] = a.getIdPacient();
        row[2] = a.getIdDoctor();
        row[3] = a.getMotive();
        row[4] = a.getHour();
        row[5] = a.getDate();


        model.addRow(row);

    }
    private void fetch() {
        DefaultTableModel model = (DefaultTableModel) tblAppointments.getModel();

        for (Appointment a : appointments) {

            Object[] row = new Object[6];
            row[0] = a.getId();
            row[1] = a.getIdPacient();
            row[2] = a.getIdDoctor();
            row[3] = a.getMotive();
            row[4] = a.getHour();
            row[5] = a.getDate();

            model.addRow(row);
        }
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePacients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePacients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePacients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePacients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new FrameAppointments().setVisible(true);
        });
    }
}


