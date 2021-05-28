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
public class FramePacients extends JFrame {

    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPacients;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtFieldToUpdate;
    private javax.swing.JTextField txtUpdatedValue;
    private javax.swing.JTextField txtSymptoms;
    private javax.swing.JTextField txtInsurance;
    private javax.swing.JTextField txtCovidTest;
    private javax.swing.JLabel jLabel20;



    PacientsDatabase db = PacientsDatabase.getDatabaseInstance();
    List<Pacient> pacients = PacientsDatabase.Read();
    Audit audit = Audit.getAuditInstance();

    private JPanel contentPane;


    public FramePacients() //constructor
    {
        initComponents();
        fetch();
    }

    private void initComponents() {

        txtFname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFieldToUpdate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtUpdatedValue = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSymptoms = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtInsurance = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCovidTest = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPacients = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtFieldToUpdate = new javax.swing.JTextField();
        txtUpdatedValue = new javax.swing.JTextField();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pacients");
        setResizable(false);


        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", Font.BOLD, 12));
        jLabel1.setText("First Name");
        jLabel1.setVisible(false);
        txtFname.setVisible(false);
        jLabel1.setOpaque(true);
        jLabel1.setBackground(Color.BLACK);
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", Font.BOLD, 12));
        jLabel2.setText("Last Name");
        jLabel2.setVisible(false);
        txtLname.setVisible(false);
        jLabel2.setOpaque(true);
        jLabel2.setBackground(Color.BLACK);
        jLabel2.setForeground(Color.WHITE);
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", Font.BOLD, 12));
        jLabel3.setText("Age");
        jLabel3.setVisible(false);
        txtAge.setVisible(false);
        jLabel3.setOpaque(true);
        jLabel3.setBackground(Color.BLACK);
        jLabel3.setForeground(Color.WHITE);
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", Font.BOLD, 12));
        jLabel4.setText("Field To Update");
        jLabel4.setVisible(false);
        txtFieldToUpdate.setVisible(false);
        jLabel4.setOpaque(true);
        jLabel4.setBackground(Color.BLACK);
        jLabel4.setForeground(Color.WHITE);
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", Font.BOLD, 12));
        jLabel5.setText("Updated Value");
        jLabel5.setVisible(false);
        txtUpdatedValue.setVisible(false);
        jLabel5.setOpaque(true);
        jLabel5.setBackground(Color.BLACK);
        jLabel5.setForeground(Color.WHITE);
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", Font.BOLD, 12));
        jLabel6.setText("Symptoms");
        jLabel6.setVisible(false);
        txtSymptoms.setVisible(false);
        jLabel6.setOpaque(true);
        jLabel6.setBackground(Color.BLACK);
        jLabel6.setForeground(Color.WHITE);
        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", Font.BOLD, 12));
        jLabel7.setText("Insurance");
        jLabel7.setVisible(false);
        txtInsurance.setVisible(false);
        jLabel7.setOpaque(true);
        jLabel7.setBackground(Color.BLACK);
        jLabel7.setForeground(Color.WHITE);
        jLabel7.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", Font.BOLD, 12));
        jLabel8.setText("CovidTest");
        jLabel8.setVisible(false);
        txtCovidTest.setVisible(false);
        jLabel8.setOpaque(true);
        jLabel8.setBackground(Color.BLACK);
        jLabel8.setForeground(Color.WHITE);
        jLabel8.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", Font.BOLD, 12));
        jLabel9.setText("Last Name");

        jLabel20 = new JLabel("Please",JLabel.CENTER);
        jLabel20.setFont(new java.awt.Font("Microsoft YaHei UI", Font.BOLD, 14));
        jLabel20.setText("Please select one of the options above");
        jLabel20.setOpaque(true);
        jLabel20.setBackground(Color.LIGHT_GRAY);
        jLabel20.setAlignmentY(JLabel.CENTER);



        tblPacients.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Id", "First Name", "Last Name", "Age", "Symptoms", "Insurance", "CovidTest"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tblPacients.setCellSelectionEnabled(true);
        tblPacients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPacientsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPacients);
        if (tblPacients.getColumnModel().getColumnCount() > 0) {
            tblPacients.getColumnModel().getColumn(0).setResizable(false);
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

        jLabel9 = new JLabel("Pacients Database",JLabel.CENTER);
        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", Font.BOLD, 18));
        //jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
       // jLabel9.setText("Pacients Database");
        jLabel9.setOpaque(true);
        jLabel9.setBackground(Color.decode("#E24748"));
        jLabel9.setForeground(Color.WHITE);
        jLabel9.setSize(1000,200);

        jScrollPane1.setOpaque(true);
        jScrollPane1.setBackground(Color.decode("#E6B0AA"));

        jScrollPane1.getViewport().setOpaque(true);
        jScrollPane1.getViewport().setBackground(Color.decode("#E6B0AA"));

        tblPacients.setBackground(Color.decode("#CD6155"));
        tblPacients.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 11));
        tblPacients.setForeground(Color.WHITE);


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
                                                                .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtFieldToUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtUpdatedValue, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtSymptoms, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtInsurance, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtCovidTest, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))

                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15)
                                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15)
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
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, 0)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtFieldToUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtUpdatedValue, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtSymptoms, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtInsurance, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtCovidTest, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(60, 60, 60)
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

        if (!txtFname.isVisible() || !txtLname.isVisible() || !txtAge.isVisible() || !txtSymptoms.isVisible() || !txtInsurance.isVisible() || !txtCovidTest.isVisible()) {
            jLabel1.setVisible(true);
            txtFname.setVisible(true);
            jLabel2.setVisible(true);
            txtLname.setVisible(true);
            jLabel3.setVisible(true);
            txtAge.setVisible(true);
            jLabel6.setVisible(true);
            txtSymptoms.setVisible(true);
            jLabel7.setVisible(true);
            txtInsurance.setVisible(true);
            jLabel8.setVisible(true);
            txtCovidTest.setVisible(true);
            jLabel4.setVisible(false);
            txtUpdatedValue.setVisible(false);
            jLabel5.setVisible(false);
            txtFieldToUpdate.setVisible(false);
            jLabel20.setVisible(false);

        } else {

            String fname = txtFname.getText().trim();
            String lname = txtLname.getText().trim();
            String age = txtAge.getText().trim();
            String symptoms = txtSymptoms.getText().trim();
            String insurance = txtInsurance.getText().trim();
            String covid = txtCovidTest.getText().trim();

            if (!fname.isEmpty() && !lname.isEmpty() && !age.isEmpty() && !symptoms.isEmpty() && !insurance.isEmpty() && !covid.isEmpty()) {

                db.addPacient(Integer.parseInt(age), fname, lname, symptoms, Boolean.parseBoolean(insurance), Boolean.parseBoolean(covid));
                clear();
                Pacient p = new Pacient(Integer.parseInt(age), fname, lname, symptoms, Boolean.parseBoolean(insurance), Boolean.parseBoolean(covid));
                pacients.add(p);
                fetchLast();
                audit.auditServicePacients("Add pacient");
                jLabel1.setVisible(false);
                txtFname.setVisible(false);

                jLabel2.setVisible(false);
                txtLname.setVisible(false);
                jLabel3.setVisible(false);
                txtAge.setVisible(false);
                jLabel6.setVisible(false);
                txtSymptoms.setVisible(false);
                jLabel7.setVisible(false);
                txtInsurance.setVisible(false);
                jLabel8.setVisible(false);
                txtCovidTest.setVisible(false);
                jLabel20.setVisible(true);

            } else {
                alert("Please fill in all the details");
            }
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {

        if (!txtFieldToUpdate.isVisible() || !txtUpdatedValue.isVisible()) {
            txtFieldToUpdate.setVisible(true);
            txtUpdatedValue.setVisible(true);
            txtLname.setVisible(true);
            txtFname.setVisible(true);
            jLabel4.setVisible(true);
            jLabel5.setVisible(true);
            jLabel1.setVisible(true);
            jLabel2.setVisible(true);
            jLabel3.setVisible(false);
            txtAge.setVisible(false);
            jLabel6.setVisible(false);
            txtSymptoms.setVisible(false);
            jLabel7.setVisible(false);
            txtInsurance.setVisible(false);
            jLabel8.setVisible(false);
            txtCovidTest.setVisible(false);
            jLabel20.setVisible(false);

        } else {

            String fname = txtFname.getText().trim();
            String lname = txtLname.getText().trim();

            String fieldToUpdate = txtFieldToUpdate.getText().trim();
            String updatedValue = txtUpdatedValue.getText().trim();

            if (!fname.isEmpty() && !lname.isEmpty() && !fieldToUpdate.isEmpty() && !updatedValue.isEmpty()) {

                PacientsDatabase.updatePacient(fname, lname, fieldToUpdate, updatedValue);
                DefaultTableModel model = (DefaultTableModel) tblPacients.getModel();
                model.setRowCount(0);
                fetch();
                alert("Update was successful");
                audit.auditServicePacients("Update Pacient");
                txtFieldToUpdate.setVisible(false);
                txtUpdatedValue.setVisible(false);
                txtLname.setVisible(false);
                txtFname.setVisible(false);
                jLabel5.setVisible(false);
                jLabel4.setVisible(false);
                jLabel1.setVisible(false);
                jLabel2.setVisible(false);
                jLabel20.setVisible(true);

            } else {
                alert("There is no such pacient", "Update error");
                clear();
            }
        }

    }

    private void tblPacientsMouseClicked(java.awt.event.MouseEvent evt) {
        int i = tblPacients.getSelectedRow();
        TableModel model = tblPacients.getModel();
        txtFname.setText(model.getValueAt(i, 1).toString());
        txtLname.setText(model.getValueAt(i, 2).toString());
        txtAge.setText(model.getValueAt(i, 3).toString());
        txtSymptoms.setText(model.getValueAt(i, 4).toString());
        txtInsurance.setText(model.getValueAt(i, 5).toString());
        txtCovidTest.setText(model.getValueAt(i, 6).toString());
    }


    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {
        jLabel20.setVisible(true);
        jLabel4.setVisible(false);
        txtUpdatedValue.setVisible(false);
        jLabel5.setVisible(false);
        txtFieldToUpdate.setVisible(false);
        jLabel1.setVisible(false);
        txtFname.setVisible(false);
        jLabel2.setVisible(false);
        txtLname.setVisible(false);
        jLabel3.setVisible(false);
        txtAge.setVisible(false);
        jLabel6.setVisible(false);
        txtSymptoms.setVisible(false);
        jLabel7.setVisible(false);
        txtInsurance.setVisible(false);
        jLabel8.setVisible(false);
        txtCovidTest.setVisible(false);

        int i = tblPacients.getSelectedRow();
        if (i >= 0) {
            int option = JOptionPane.showConfirmDialog(rootPane,
                    "Are you sure you want to Delete?", "Delete confirmation", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                TableModel model = tblPacients.getModel();

                String id = model.getValueAt(i, 0).toString();
                if (tblPacients.getSelectedRows().length == 1) {
                    db.deletePacient(Integer.parseInt(id));
                    pacients.remove(tblPacients.getSelectedRow());
                    DefaultTableModel model1 = (DefaultTableModel) tblPacients.getModel();
                    model1.setRowCount(0);
                    audit.auditServicePacients("Delete Pacient");
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
        txtFname.setText("");
        txtLname.setText("");
        txtAge.setText("");
        txtCovidTest.setText("");
        txtInsurance.setText("");
        txtSymptoms.setText("");
        txtUpdatedValue.setText("");
        txtFieldToUpdate.setText("");
    }


    private void fetchLast() {
        DefaultTableModel model = (DefaultTableModel) tblPacients.getModel();

        Pacient d = pacients.get(pacients.size()-1);
        Object[] row = new Object[7];
        row[0] = d.getId();
        row[1] = d.getFirstName();
        row[2] = d.getLastName();
        row[3] = d.getAge();
        row[4] = d.getSymptoms();
        row[5] = d.hasInsurance();
        row[6] = d.hasCovid();

        model.addRow(row);

    }

    private void fetch() {
            DefaultTableModel model = (DefaultTableModel) tblPacients.getModel();

            for (Pacient p : pacients) {

                Object[] row = new Object[7];
                row[0] = p.getId();
                row[1] = p.getFirstName();
                row[2] = p.getLastName();
                row[3] = p.getAge();
                row[4] = p.getSymptoms();
                row[5] = p.hasInsurance();
                row[6] = p.hasCovid();

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
            new FramePacients().setVisible(true);
        });
    }
}


