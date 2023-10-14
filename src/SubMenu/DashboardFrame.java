/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SubMenu;

import java.util.Date;
import java.text.SimpleDateFormat;
import SubMenu.popUp.popUp_ketikkode;
import SubMenu.popUp.popUp_konfirmasi;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import koneksi.Connect;  // assuming the Connect class is in the koneksi package
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author perlengkapan
 */
public class DashboardFrame extends javax.swing.JInternalFrame {
    public void tanggal() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        tgl_profit.setText(s.format(d));
        tgl_profitCuci.setText(s.format(d));
        tgl_totalAmbilBaju.setText(s.format(d));
    }
    private DefaultTableModel model;


    /** Creates new form DashboardFrame */
    public DashboardFrame() {
        initComponents();
        tanggal();
        tampilTabel();
        totalProfit(profit);
        totalCucian(profitCuci);
        totalCucianAmbil(totalAmbilBaju);
        //ilangin border
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bif = (BasicInternalFrameUI) this.getUI();
        bif.setNorthPane(null);
        
    }
    //membuat kontrukstor yang berfungsi untuk membuat model tabel
   private void tampilTabel() {
    ActionListener taskPerformer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel tb = new DefaultTableModel();
            tb.addColumn("No");
            tb.addColumn("Nama Customer");
            tb.addColumn("Paket");
            tb.addColumn("Jumlah Satuan");
            tb.addColumn("Tanggal Transaksi");
            tb.addColumn("Total Harga");
            tb.addColumn("Bayar");
            tb.addColumn("Status");
            jTable1.setModel(tb);

            try {
                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;
                conn = Connect.GetConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select a.nama, p.tipe_paket, d.total_qty, t.tgl_transaksi, t.total, t.tunai, d.status from akun a\n" +
                        "join transaksi t on a.id_akun=t.id_akun\n" +
                        "join detail_transaksi d on t.id_transaksi=d.id_transaksi\n" +
                        "join paket p on d.id_paket = p.id_paket;");
                int number = 1;
                while (rs.next()) {
                    String s = String.valueOf(number);
                    tb.addRow(new Object[]{
                            s,
                            rs.getString("nama"),
                            rs.getString("tipe_paket"),
                            rs.getString("total_qty"),
                            rs.getString("tgl_transaksi"),
                            rs.getString("total"),
                            rs.getString("tunai"),
                            rs.getString("status"),
                    });
                    number++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(DashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
    new Timer(1000, taskPerformer).start();
}
   
    private void totalProfit(JLabel jlabel) {
        ActionListener taskPerformer;
        taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;
                
                try {
                    conn = Connect.GetConnection(); 
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("SELECT SUM(total) as total_hari_ini FROM transaksi WHERE DATE(tgl_transaksi) = CURDATE()"); 
                    while (rs.next()) {
                        int totalHariIni = 0;
                        totalHariIni = rs.getInt("total_hari_ini");
                        System.out.println(totalHariIni);
                        jlabel.setText("Rp " + totalHariIni);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(DashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        new Timer(1000, taskPerformer).start();
    }
    
    private void totalCucian(JLabel jlabel) {
        ActionListener taskPerformer;
        taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;
                try {
                    conn = Connect.GetConnection(); 
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("SELECT SUM(berat) as total_hari_ini FROM detail_transaksi WHERE DATE(tgl_pesan) = CURDATE()"); 

                    while (rs.next()) {                     
                        String columnData = null;
                        int totalHariIni = 0;
                        totalHariIni = rs.getInt("total_hari_ini");                        
                        System.out.println(totalHariIni);
                        jlabel.setText(totalHariIni + " KG");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(DashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        new Timer(1000, taskPerformer).start();
    }
    
    private void totalCucianAmbil(JLabel jlabel) {
        ActionListener taskPerformer;
        taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;
                try {
                    conn = Connect.GetConnection(); 
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("SELECT COUNT(*) as total_hari_ini FROM detail_transaksi WHERE status = 'sudah diambil' and DATE(tgl_pesan) = CURDATE()");
                    while (rs.next()) {
                        int totalHariIni = 0;
                        totalHariIni = rs.getInt("total_hari_ini"); 
                        System.out.println(totalHariIni);
                        jlabel.setText(totalHariIni + "");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(DashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        new Timer(1000, taskPerformer).start();
    }
    
   
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tgl_totalAmbilBaju = new javax.swing.JLabel();
        tgl_profitCuci = new javax.swing.JLabel();
        tgl_profit = new javax.swing.JLabel();
        konfirmasiPengambilan = new javax.swing.JLabel();
        totalAmbilBaju = new javax.swing.JLabel();
        profitCuci = new javax.swing.JLabel();
        profit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        background2 = new javax.swing.JLabel();
        profit1 = new javax.swing.JLabel();

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/layout/Template InternalFrame.jpg"))); // NOI18N

        jLabel2.setText("jLabel2");

        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 1080, 220));

        tgl_totalAmbilBaju.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tgl_totalAmbilBaju.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tgl_totalAmbilBaju, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 200, 150, 30));

        tgl_profitCuci.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tgl_profitCuci.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tgl_profitCuci, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 150, 30));

        tgl_profit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tgl_profit.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(tgl_profit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 170, 30));

        konfirmasiPengambilan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                konfirmasiPengambilanMouseClicked(evt);
            }
        });
        getContentPane().add(konfirmasiPengambilan, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 560, 370, 60));

        totalAmbilBaju.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        totalAmbilBaju.setForeground(new java.awt.Color(255, 255, 255));
        totalAmbilBaju.setText("totalAmbil");
        getContentPane().add(totalAmbilBaju, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 70, 180, 90));

        profitCuci.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        profitCuci.setForeground(new java.awt.Color(255, 255, 255));
        profitCuci.setText("PendapatanCuci");
        getContentPane().add(profitCuci, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 190, 80));

        profit.setBackground(new java.awt.Color(255, 255, 255));
        profit.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        profit.setForeground(new java.awt.Color(255, 255, 255));
        profit.setText("Pendapatan");
        profit.setMaximumSize(new java.awt.Dimension(100, 16));
        profit.setPreferredSize(new java.awt.Dimension(100, 16));
        getContentPane().add(profit, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 240, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/layout/Dashboard Page.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        background2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/layout/Template InternalFrame.jpg"))); // NOI18N
        getContentPane().add(background2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        profit1.setBackground(new java.awt.Color(255, 255, 255));
        profit1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        profit1.setForeground(new java.awt.Color(255, 255, 255));
        profit1.setText("Pendapatan");
        profit1.setMaximumSize(new java.awt.Dimension(100, 16));
        profit1.setPreferredSize(new java.awt.Dimension(100, 16));
        getContentPane().add(profit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 100, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void konfirmasiPengambilanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_konfirmasiPengambilanMouseClicked
        // TODO add your handling code here:
        popUp_konfirmasi popup = new popUp_konfirmasi();
        popup.setVisible(true);
    }//GEN-LAST:event_konfirmasiPengambilanMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel background2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel konfirmasiPengambilan;
    private javax.swing.JLabel profit;
    private javax.swing.JLabel profit1;
    private javax.swing.JLabel profitCuci;
    private javax.swing.JLabel tgl_profit;
    private javax.swing.JLabel tgl_profitCuci;
    private javax.swing.JLabel tgl_totalAmbilBaju;
    private javax.swing.JLabel totalAmbilBaju;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
//        throw new UnsupportedOperationException(""); //To change body of generated methods, choose Tools | Templates.
    }

}
