/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SubMenu.popUp;
import java.awt.Color;

/**
 *
 * @author Shila
 */
public class popUp_konfirmasi extends javax.swing.JFrame {

    /**
     * Creates new form popUp
     */
    public popUp_konfirmasi() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit = new javax.swing.JLabel();
        code = new javax.swing.JLabel();
        barcode = new javax.swing.JLabel();
        ketikKodee = new javax.swing.JLabel();
        ketikKode = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 280, 30, 30));

        code.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                codeMouseClicked(evt);
            }
        });
        getContentPane().add(code, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, 160, 20));

        barcode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barcodeMouseClicked(evt);
            }
        });
        getContentPane().add(barcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 430, 140, 30));

        ketikKodee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ketikKodeeMouseClicked(evt);
            }
        });
        getContentPane().add(ketikKodee, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 230, 220, 40));

        ketikKode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ketikKodeMouseClicked(evt);
            }
        });
        getContentPane().add(ketikKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 200, 20));

        jLabel1.setBackground(new Color (0,0,0,0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/img/popUp/popUp Pengambilan.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ketikKodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ketikKodeMouseClicked
        // TODO add your handling code here:

        //buka internalFrame
//        popUp_ketikkode popup = new popUp_ketikkode();
//        jLabel1.add(popup);
//        popup.setVisible(true);
    }//GEN-LAST:event_ketikKodeMouseClicked

    private void ketikKodeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ketikKodeeMouseClicked
        // TODO add your handling code here:
//        jLabel1.removeAll();
//        popUp_ketikkode popup = new popUp_ketikkode();
////        jLabel1.add(popup);
//        popup.setVisible(true);
    }//GEN-LAST:event_ketikKodeeMouseClicked

    private void codeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_codeMouseClicked
        // TODO add your handling code here:
//        jLabel1.setVisible(false);
        dispose();
        popUp_ketikkode popup = new popUp_ketikkode();
        popup.setVisible(true);
    }//GEN-LAST:event_codeMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_exitMouseClicked

    private void barcodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barcodeMouseClicked
        // TODO add your handling code here:
        dispose();
        popUp_scanbarcode popup = new popUp_scanbarcode();
        popup.setVisible(true);
    }//GEN-LAST:event_barcodeMouseClicked

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
            java.util.logging.Logger.getLogger(popUp_konfirmasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(popUp_konfirmasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(popUp_konfirmasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(popUp_konfirmasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new popUp_konfirmasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barcode;
    private javax.swing.JLabel code;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel ketikKode;
    private javax.swing.JLabel ketikKodee;
    // End of variables declaration//GEN-END:variables
}
