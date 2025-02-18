import javax.swing.*;
import java.io.*;

/**
 *
 * @author prate
 */
public class LoginPage extends JFrame {

    /**
     * Creates new form LoginPage
     */
    public LoginPage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The contentṬ of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new JLabel();
        T1 = new JTextField();
        jLabel2 = new JLabel();
        P1 = new JPasswordField();
        jCheckBox1 = new JCheckBox();
        jButton1 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setLocation(new java.awt.Point(600, 250));
        setPreferredSize(new java.awt.Dimension(400, 350));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jLabel1.setText("Password :");

        T1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Unique ID :");

        jCheckBox1.setText("Show Password");
        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseClicked(evt);
            }
        });
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addGap(30, 30, 30).addGroup(layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jCheckBox1)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2).addComponent(jLabel1,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 75,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(76, 76, 76)
                                        .addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(T1).addComponent(P1,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 165,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createSequentialGroup().addGap(167, 167, 167).addComponent(jButton1,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(T1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1)
                        .addComponent(P1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44).addComponent(jCheckBox1).addGap(18, 18, 18).addComponent(jButton1)
                .addContainerGap(50, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>

    private void T1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String userName = T1.getText();
        char[] password = P1.getPassword();
        String pas = new String(password);

        try {
            /*
             * if (userName.length() == 6) { Admin ob = new Admin(); ob =
             * ob.getAdmin(userName); if (pas.equals(ob.getPass)) {
             *
             * } else { javax.swing.JOptionPane.showMessageDialog(this,
             * "Wrong username or password! !!!"); T1.setText(""); P1.setText(""); } } else
             */ if (userName.length() == 9) {
                int batch = Integer.parseInt(userName.substring(0, 4));

                Student ob = new Student(batch);
                int rollNum = Integer.parseInt(userName);
                // javax.swing.JOptionPane.showMessageDialog(this, "Hii" + rollNum);
                Student ob1 = ob.getStudent(rollNum);
                ob1.readDetails(rollNum);
                javax.swing.JOptionPane.showMessageDialog(this, "Hii" + ob1.getRollNo());

                if (pas.equals(ob1.getPass())) {
                    StudentGUI Frame = new StudentGUI(ob1);
                    Frame.setVisible(true);

                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Wrong username or password! !!!");
                    T1.setText("");
                    P1.setText("");
                }
            } /*
               * else if (userName.length() == 6) { Professor ob = new Professor(); ob =
               * ob.getProfessor(userName); if (pas.equals(ob.getPass)) { } else {
               * javax.swing.JOptionPane.showMessageDialog(this,
               * "Wrong username or password! !!!"); T1.setText(""); P1.setText(""); } }
               */

            else {
                javax.swing.JOptionPane.showMessageDialog(this, "Wrong username or password! !!!");
                T1.setText("");
                P1.setText("");
            }

        } catch (InvalidClassException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jCheckBox1MouseClicked(java.awt.event.MouseEvent evt) {
        P1.setEchoChar((char) 0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
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
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JPasswordField P1;
    private javax.swing.JTextField T1;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration
}
