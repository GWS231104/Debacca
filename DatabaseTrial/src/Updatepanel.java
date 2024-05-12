
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author hilmi
 */
public class Updatepanel extends javax.swing.JFrame {
    private User user;
    private String title;
    private String author;    
    private Map<Integer, String> genreMap;    
    private static final String url = "jdbc:mysql://localhost:3306/debacca";  
    private static final String userName = "root";
    private static final String passwordDB = "";    
    /**
     * Creates new form Updatepanel
     */
    public Updatepanel(User user, String title, String author) {
        this.user = user;
        this.title = title;
        this.author = author;        
        initComponents();
        initGenreMap();
        txt_update();
        txtTitle.setText("" + title);
    }
    
    private int txt_update() {        
    int user_id = user.getID();
    int genre_id = getSelectedGenreId();
        try {
        
            Class.forName("com.mysql.cj.jdbc.Driver");    
            //proses pemanggilan file database
            String url = "jdbc:MySQL://localhost:3306/debacca";
            String user = "root";
            String pass = "";
            String query = "SELECT s.id, s.text FROM stories AS s WHERE s.title = ?";
            
            //proses koneksi
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, title);            
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {
                StoryArea.setText(rs.getString("text"));
                int storyId = rs.getInt("id");
                return storyId;
            } else {
                StoryArea.setText("No story found with title: " + title);
            }            
            
        // Close database resources
        rs.close();
        statement.close();
        con.close();        
        } catch (Exception e) {
            System.err.println("error" + e);
            
        } 
        return 0;
    }      

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelGradient1 = new Cosmetics.JPanelGradient();
        jPanelHalfRound1 = new Cosmetics.JPanelHalfRound();
        jLabel1 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        GenreBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        StoryArea = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        jButtonGradient1 = new Cosmetics.JButtonGradient();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelGradient1.setColorEnd(new java.awt.Color(232, 28, 255));
        jPanelGradient1.setColorStart(new java.awt.Color(64, 201, 255));

        jPanelHalfRound1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelHalfRound1.setRoundTopLeft(100);
        jPanelHalfRound1.setRoundTopRight(100);

        jLabel1.setText("Title");

        GenreBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horror", "Action", "Fantasy", "Romance", "Sci-Fi", "Mystery", "Adventure", "Comedy" }));
        GenreBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenreBoxActionPerformed(evt);
            }
        });

        StoryArea.setColumns(20);
        StoryArea.setRows(5);
        jScrollPane1.setViewportView(StoryArea);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        DeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bin.png"))); // NOI18N
        DeleteButton.setBorderPainted(false);
        DeleteButton.setContentAreaFilled(false);
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        jButtonGradient1.setText("Save");
        jButtonGradient1.setColor1(new java.awt.Color(232, 28, 255));
        jButtonGradient1.setColor2(new java.awt.Color(64, 201, 255));
        jButtonGradient1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGradient1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelHalfRound1Layout = new javax.swing.GroupLayout(jPanelHalfRound1);
        jPanelHalfRound1.setLayout(jPanelHalfRound1Layout);
        jPanelHalfRound1Layout.setHorizontalGroup(
            jPanelHalfRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHalfRound1Layout.createSequentialGroup()
                .addGroup(jPanelHalfRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanelHalfRound1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151)
                        .addComponent(DeleteButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelHalfRound1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanelHalfRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(GenreBox, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHalfRound1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanelHalfRound1Layout.setVerticalGroup(
            jPanelHalfRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHalfRound1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanelHalfRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(GenreBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanelHalfRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteButton))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanelGradient1Layout = new javax.swing.GroupLayout(jPanelGradient1);
        jPanelGradient1.setLayout(jPanelGradient1Layout);
        jPanelGradient1Layout.setHorizontalGroup(
            jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGradient1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jPanelHalfRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanelGradient1Layout.setVerticalGroup(
            jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGradient1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jPanelHalfRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Profile(user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void GenreBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenreBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GenreBoxActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed

        int storyId = txt_update();
        if (storyId > 0) {
            int option = JOptionPane.showConfirmDialog(new JFrame(), "Are you sure you want to delete this story?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                deleteStory(storyId);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "No story found with title: " + title, "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void jButtonGradient1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGradient1ActionPerformed

        String title = txtTitle.getText();
        String text = StoryArea.getText();        
        int user_id = user.getID();
        int genre_id = getSelectedGenreId();
        int retrievedStoryId = txt_update();
        try (Connection con = DriverManager.getConnection(url, userName, passwordDB)){
            String  query = "UPDATE stories SET title = ?, user_id = ?, genre_id = ?, text = ? WHERE id = ?";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, title);
            st.setInt(2, user_id);
            st.setInt(3, genre_id);
            st.setString(4, text);
            st.setInt(5, retrievedStoryId);            
            
            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(new JFrame(), "Story updated successfully", "Success", JOptionPane.OK_OPTION);
                    new Updatepanel(user, title, author).setVisible(true);
                    this.dispose();
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Failed to update story", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.err.println("error" + e);
        }        
        
    }//GEN-LAST:event_jButtonGradient1ActionPerformed
    
    
    private void initGenreMap() {
        genreMap = new HashMap<>();
        genreMap.put(1, "Horror");
        genreMap.put(2, "Action");
        genreMap.put(3, "Fantasy");
        genreMap.put(4, "Romance");
        genreMap.put(5, "Sci-Fi");
        genreMap.put(6, "Mystery");
        genreMap.put(7, "Adventure");
        genreMap.put(8, "Comedy");

        GenreBox.setModel(new DefaultComboBoxModel<>(genreMap.values().toArray(new String[0])));
    }    
    
    private int getSelectedGenreId() {
        String selectedGenreName = (String) GenreBox.getSelectedItem();
        for (Map.Entry<Integer, String> entry : genreMap.entrySet()) {
            if (entry.getValue().equals(selectedGenreName)) {
                return entry.getKey();
            }
        }
        return -1; // Return a default value if no genre is selected
    }    
    
    private void deleteStory(int storyId) {
        try (Connection con = DriverManager.getConnection(url, userName, passwordDB)) {
            String query = "DELETE FROM stories WHERE id = ?";
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, storyId);
            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(new JFrame(), "Story deleted successfully", "Success", JOptionPane.OK_OPTION);
                new Profile(user).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Failed to delete story", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.err.println("error" + e);
        }
    }    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[], User user, String title, String author) {
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
            java.util.logging.Logger.getLogger(Updatepanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Updatepanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Updatepanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Updatepanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Updatepanel(user, title, author).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteButton;
    private javax.swing.JComboBox<String> GenreBox;
    private javax.swing.JTextArea StoryArea;
    private javax.swing.JButton jButton2;
    private Cosmetics.JButtonGradient jButtonGradient1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private Cosmetics.JPanelGradient jPanelGradient1;
    private Cosmetics.JPanelHalfRound jPanelHalfRound1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
