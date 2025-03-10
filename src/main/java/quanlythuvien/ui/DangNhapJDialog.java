package quanlythuvien.ui;

import java.awt.Color;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import quanlythuvien.dao.NguoiDungDAO;
import quanlythuvien.entity.NguoiDung;
import quanlythuvien.ui.DangNhapJDialog;
import quanlythuvien.utils.Auth;
import quanlythuvien.utils.MsgBox;
import quanlythuvien.utils.XImage;

/**
 *
 * @author thuon
 */
public class DangNhapJDialog extends javax.swing.JDialog {

    NguoiDungDAO dao = new NguoiDungDAO();
    ThuVienMainJFrame tvfr;

    public DangNhapJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tvfr = (ThuVienMainJFrame) parent;
        init();
    }

    void init() {
        this.setLocation(399,101);
        this.setTitle("Đăng nhập");
        this.setIconImage(XImage.getAppIcon());
        txtTenDangNhap.setBackground(new Color(236, 238, 238, 0));
        txtMatKhau.setBackground(new Color(236, 238, 238, 0));
        chkRemember.setBackground(new Color(236, 238, 238, 0));
    }

    void dangnhap() {
        if (validateForm()) {
            NguoiDung nd = dao.selectById(txtTenDangNhap.getText());
            if (nd == null) {
                MsgBox.alert(this, "Sai tên đăng nhập!");
            } else {
                if (!nd.getMatKhau().equals(new String(txtMatKhau.getPassword()))) {
                    MsgBox.alert(this, "Sai mật khẩu!");
                } else {
                    Auth.user = nd;
                    this.dispose();
                    if (Auth.isManager() || Auth.isLibrarian()) {
                        new ThuVienQuanLyJFrame().setVisible(true);
                    } else {
                        new ThuVienUserJFrame().setVisible(true);
                    }
                }
            }
        }
    }

    boolean validateForm() {
        String reTenDangNhap = "^[a-zA-Z0-9_-]{2,10}$";
        if (txtTenDangNhap.getText().equals("")) {
            MsgBox.alert(this, "Vui lòng nhập tên đăng nhập!");
            return false;
        }
        if (!txtTenDangNhap.getText().matches(reTenDangNhap)) {
            MsgBox.alert(this, "Tên đăng nhập không hợp lệ!");
            return false;
        }
        if (new String(txtMatKhau.getPassword()).equals("")) {
            MsgBox.alert(this, "Vui lòng nhập mật khẩu!");
            return false;
        }
        return true;
    }

    public void saveLoginInfo(String username, String password) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("logininfo.txt"))) {
            writer.println(username);
            writer.println(password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTenDangNhap = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JPasswordField();
        btnQuenMatKhau = new javax.swing.JButton();
        btnDangNhap = new javax.swing.JButton();
        chkRemember = new javax.swing.JCheckBox();
        lblDangKy = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTenDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenDangNhap.setBorder(null);
        getContentPane().add(txtTenDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 310, 40));

        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMatKhau.setBorder(null);
        getContentPane().add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 310, 40));

        btnQuenMatKhau.setContentAreaFilled(false);
        btnQuenMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuenMatKhauActionPerformed(evt);
            }
        });
        getContentPane().add(btnQuenMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 380, 130, 20));

        btnDangNhap.setContentAreaFilled(false);
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        getContentPane().add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 360, 60));

        chkRemember.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        chkRemember.setForeground(new java.awt.Color(102, 102, 102));
        chkRemember.setText("Remember me");
        getContentPane().add(chkRemember, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, -1, 20));

        lblDangKy.setForeground(new java.awt.Color(51, 51, 255));
        lblDangKy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDangKy.setText("Đăng ký");
        lblDangKy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangKyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDangKyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDangKyMouseExited(evt);
            }
        });
        getContentPane().add(lblDangKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 510, -1, -1));

        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Bạn chưa có tài khoản?");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 510, -1, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlythuvien/icon/bgrLogin1.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        dangnhap();
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void lblDangKyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangKyMouseEntered
        lblDangKy.setText("<html><u>Đăng ký</u></html>");
    }//GEN-LAST:event_lblDangKyMouseEntered

    private void lblDangKyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangKyMouseExited
        lblDangKy.setText("Đăng ký");
    }//GEN-LAST:event_lblDangKyMouseExited

    private void lblDangKyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangKyMouseClicked
        this.dispose();
        tvfr.openDangKy();
    }//GEN-LAST:event_lblDangKyMouseClicked

    private void btnQuenMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuenMatKhauActionPerformed
        this.dispose();
        tvfr.openXacThuc();
    }//GEN-LAST:event_btnQuenMatKhauActionPerformed

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
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DangNhapJDialog dialog = new DangNhapJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnQuenMatKhau;
    private javax.swing.JCheckBox chkRemember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblDangKy;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTenDangNhap;
    // End of variables declaration//GEN-END:variables
}
