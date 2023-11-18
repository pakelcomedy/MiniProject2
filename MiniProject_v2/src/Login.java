import javax.swing.JOptionPane;
import java.sql.Connection;
import koneksi.Config;

public class Login extends javax.swing.JFrame {
    public Login() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_nim = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_password = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Register = new javax.swing.JButton();
        Login = new javax.swing.JButton();
        Frame = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nim.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_nim.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txt_nim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nimActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nim, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 167, 31));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, -1, -1));

        txt_password.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_password.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 167, 31));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("PASSWORD");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("NIM");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, -1));

        Register.setText("REGISTER");
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });
        getContentPane().add(Register, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, -1, -1));

        Login.setText("LOGIN");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        getContentPane().add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, -1, -1));

        Frame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Frame/Frame 1.png"))); // NOI18N
        getContentPane().add(Frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void txt_nimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nimActionPerformed
    }//GEN-LAST:event_txt_nimActionPerformed
    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
    }//GEN-LAST:event_txt_passwordActionPerformed
    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
    try {
        String sql = "SELECT * FROM akun WHERE nim=? AND password=?";
        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);

        pst.setString(1, txt_nim.getText());
        pst.setString(2, txt_password.getText());

        java.sql.ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            if (txt_nim.getText().equals(rs.getString("nim")) && txt_password.getText().equals(rs.getString("password"))) {
                JOptionPane.showMessageDialog(null, "Berhasil login");
                this.setVisible(false);
//                new Mahasiswa().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "NIM atau password salah");
            }
        } else {
            JOptionPane.showMessageDialog(null, "NIM atau password salah");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
            new Mahasiswa().setVisible(true);
    }//GEN-LAST:event_LoginActionPerformed

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed
        this.setVisible(false);
        new Register().setVisible(true);
    }//GEN-LAST:event_RegisterActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Frame;
    private javax.swing.JButton Login;
    private javax.swing.JButton Register;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txt_nim;
    private javax.swing.JTextField txt_password;
    // End of variables declaration//GEN-END:variables
}