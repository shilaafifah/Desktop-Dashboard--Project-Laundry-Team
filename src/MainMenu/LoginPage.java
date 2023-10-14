/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainMenu;

import koneksi.Connect;
import com.mysql.cj.jdbc.Driver;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author perlengkapan
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form SplashScreen
     */
    public LoginPage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        btn_login = new javax.swing.JLabel();
        btn_lupaPass = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_username.setBackground(new java.awt.Color(217, 217, 217));
        txt_username.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        txt_username.setForeground(new java.awt.Color(0, 0, 0));
        txt_username.setBorder(null);
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 300, 30));

        txt_password.setBackground(new java.awt.Color(217, 217, 217));
        txt_password.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        txt_password.setForeground(new java.awt.Color(0, 0, 0));
        txt_password.setBorder(null);
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 300, 30));

        btn_login.setFont(new java.awt.Font("Poppins Medium", 0, 20)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_login.setText("Login");
        btn_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loginMouseClicked(evt);
            }
        });
        getContentPane().add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 540, 340, 40));

        btn_lupaPass.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btn_lupaPass.setForeground(new java.awt.Color(0, 0, 0));
        btn_lupaPass.setText("Lupa Password ?");
        btn_lupaPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_lupaPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_lupaPassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_lupaPassMouseExited(evt);
            }
        });
        getContentPane().add(btn_lupaPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, -1, 70));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/layout/Login Page.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseClicked
        String username = txt_username.getText();
        String password = txt_password.getText();
        
        try {
            Connection conn = Connect.GetConnection();
            String sql = "SELECT * FROM akun WHERE username = '"+username+"' AND PASSWORD = '"+password+"'";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery(sql);
            
            if (res.next()) {
                JOptionPane.showMessageDialog(null, "Berhasil Login!");
                this.setVisible(false);
                MenuUtama mu = new MenuUtama();
                mu.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Username atau Password salah, silahkan cek kembali!");
                txt_username.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error login");
            System.out.println(username);
            System.out.println(password);
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btn_loginMouseClicked

    private void btn_lupaPassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_lupaPassMouseEntered
        btn_lupaPass.setForeground(Color.blue);
    }//GEN-LAST:event_btn_lupaPassMouseEntered

    private void btn_lupaPassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_lupaPassMouseExited
        btn_lupaPass.setForeground(Color.black);
    }//GEN-LAST:event_btn_lupaPassMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel btn_login;
    private javax.swing.JLabel btn_lupaPass;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}