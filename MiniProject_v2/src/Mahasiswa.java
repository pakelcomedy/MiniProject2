import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.Config;

public class Mahasiswa extends javax.swing.JFrame {
    
    public Mahasiswa() {
        initComponents();
        load_table();
        kosong();
    }
    private void load_table() {
      // membuat tampilan model tabel
      DefaultTableModel model = new DefaultTableModel();
      model.addColumn("No");
      model.addColumn("NIM");
      model.addColumn("Nama");
      model.addColumn("Jurusan");
      model.addColumn("Alamat");
      model.addColumn("Phone");
      model.addColumn("Password");

      // menampilkan data database kedalam tabel
      try {
          int no = 1; // initialize no to 1
          String sql = "SELECT * FROM mhs JOIN akun ON mhs.nim = akun.nim";
          java.sql.Connection conn = (Connection) Config.configDB();
          java.sql.Statement stm = conn.createStatement();
          java.sql.ResultSet res = stm.executeQuery(sql);

          while (res.next()) {
              model.addRow(new Object[]{no++, res.getString("mhs.nim"), res.getString("mhs.nama"), res.getString("mhs.jurusan"), res.getString("mhs.alamat"), res.getString("mhs.phone"), res.getString("akun.password")});
          }

          Table1.setModel(model); // set the model to jTable1
      } catch (Exception e) {
          // Log the error or print the stack trace for debugging
          e.printStackTrace();
          JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
      }
    }

    private void kosong() {
        // Assuming these are your components
        txt_nim.setText(null);
        txt_name.setText(null);
        ComboBox1.setSelectedItem(null);
        txt_alamat.setText(null);
        txt_phone.setText(null);
        txt_password.setText(null);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_nim = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_alamat = new javax.swing.JTextField();
        txt_phone = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        btn_tambah = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        ComboBox1 = new javax.swing.JComboBox<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Data Mahasiswa");

        jLabel2.setText("NIM");

        jLabel3.setText("Nama");

        jLabel4.setText("Jurusan");

        jLabel5.setText("Alamat");

        jLabel6.setText("Phone");

        jLabel7.setText("Password");

        txt_nim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nimActionPerformed(evt);
            }
        });

        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });

        txt_alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_alamatActionPerformed(evt);
            }
        });

        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_logout.setText("Logout");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NIM", "Nama", "Jurusan", "Alamat", "Phone"
            }
        ));
        Table1.setRowHeight(30);
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Table1);

        ComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teknologi Informasi", "Kesehatan", "Pertanian", "Peternakan" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_nim)
                    .addComponent(txt_name)
                    .addComponent(txt_alamat)
                    .addComponent(txt_phone)
                    .addComponent(txt_password)
                    .addComponent(ComboBox1, 0, 248, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_tambah)
                    .addComponent(btn_edit)
                    .addComponent(btn_hapus)
                    .addComponent(btn_clear)
                    .addComponent(btn_logout))
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(197, 197, 197))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tambah))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_edit))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btn_hapus)
                    .addComponent(ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clear))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_logout))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void txt_nimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nimActionPerformed
    }//GEN-LAST:event_txt_nimActionPerformed
    private void txt_alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_alamatActionPerformed
    }//GEN-LAST:event_txt_alamatActionPerformed
    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
    }//GEN-LAST:event_txt_nameActionPerformed
    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
 try {
        // Establish a try-with-resources block to ensure proper resource closure
        try (Connection conn = Config.configDB()) {
            // Insert into "mhs" table
            String sql1 = "INSERT INTO mhs (Nama, NIM, Jurusan, Alamat, Phone) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pst1 = conn.prepareStatement(sql1)) {
                pst1.setString(1, txt_name.getText());
                pst1.setString(2, txt_nim.getText());
                pst1.setString(3, ComboBox1.getSelectedItem().toString());
                pst1.setString(4, txt_alamat.getText());
                pst1.setString(5, txt_phone.getText());
                pst1.executeUpdate();
            }

            // Insert into "akun" table
            String sql2 = "INSERT INTO akun (NIM, Password) VALUES (?, ?)";
            try (PreparedStatement pst2 = conn.prepareStatement(sql2)) {
                pst2.setString(1, txt_nim.getText());
                pst2.setString(2, txt_password.getText());
                pst2.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        e.printStackTrace();  // Print the stack trace for debugging purposes
    }
    }//GEN-LAST:event_btn_tambahActionPerformed
    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
try {
    String sql = "DELETE FROM mhs WHERE nim = ?";
    String sqll = "DELETE FROM akun WHERE nim = ?";

    try (Connection conn = Config.configDB();
         PreparedStatement pst = conn.prepareStatement(sql);
         PreparedStatement pstl = conn.prepareStatement(sqll)) {

        pst.setString(1, txt_nim.getText()); // Assuming txt_nim is the JTextField for nim
        pstl.setString(1, txt_nim.getText()); // Assuming txt_nim is the JTextField for nim

        int rowsDeletedMhs = pst.executeUpdate();
        int rowsDeletedAkun = pstl.executeUpdate();

        if (rowsDeletedMhs > 0 && rowsDeletedAkun > 0) {
            JOptionPane.showMessageDialog(this, "Berhasil dihapus");
        } else {
            JOptionPane.showMessageDialog(this, "Data tidak ditemukan");
        }
    }

    load_table();
    kosong();

} catch (SQLException e) {
    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    e.printStackTrace();  // Print the stack trace for debugging purposes
}
    }//GEN-LAST:event_btn_hapusActionPerformed
    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
    int baris = Table1.rowAtPoint(evt.getPoint());

    String nim = Table1.getValueAt(baris, 1).toString();
    txt_nim.setText(nim);
    txt_nim.setEnabled(false);

    if (Table1.getValueAt(baris, 2) == null) {
        txt_name.setText("");
    } else {
        txt_name.setText(Table1.getValueAt(baris, 2).toString());

        if (Table1.getValueAt(baris, 3) == null) {
            // Assuming you wanted to set ComboBox1's selected item to an empty string
            ComboBox1.setSelectedItem("");
        } else {
            ComboBox1.setSelectedItem(Table1.getValueAt(baris, 3).toString());

            if (Table1.getValueAt(baris, 4) == null) {
                txt_alamat.setText("");
            } else {
                txt_alamat.setText(Table1.getValueAt(baris, 4).toString());

                if (Table1.getValueAt(baris, 5) == null) {
                    txt_phone.setText("");
                } else {
                    txt_phone.setText(Table1.getValueAt(baris, 5).toString());

                    if (Table1.getValueAt(baris, 6) == null) {
                        txt_password.setText("");
                    } else {
                        txt_password.setText(Table1.getValueAt(baris, 6).toString());
                    }
                }
            }
        }
    }
    }//GEN-LAST:event_Table1MouseClicked

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
    }//GEN-LAST:event_jScrollPane2MouseClicked
    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
    try {
        String sql = "UPDATE mhs INNER JOIN akun ON akun.nim = mhs.nim " +
                     "SET mhs.nama = ?, mhs.jurusan = ?, mhs.alamat = ?, mhs.phone = ? " +
                     "WHERE mhs.nim = ?";

        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);

        pst.setString(1, txt_name.getText());
        pst.setString(2, (String) ComboBox1.getSelectedItem());
        pst.setString(3, txt_alamat.getText());
        pst.setString(4, txt_phone.getText());
        pst.setString(5, txt_nim.getText());

        pst.executeUpdate();

        JOptionPane.showMessageDialog(null, "Data berhasil di edit");

        // Refresh the table after editing
        load_table();
        kosong();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Perubahan Data Gagal: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
    kosong();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
    this.setVisible(false);
    new Login().setVisible(true);
    }//GEN-LAST:event_btn_logoutActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mahasiswa().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox1;
    private javax.swing.JTable Table1;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_alamat;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_nim;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_phone;
    // End of variables declaration//GEN-END:variables
}