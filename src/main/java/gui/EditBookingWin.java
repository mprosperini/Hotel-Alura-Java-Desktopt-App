package gui;

import javax.swing.ComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logic.Booking;
import logic.ControllerLogic;


public class EditBookingWin extends javax.swing.JFrame {
    
    ControllerLogic controllerLogic;
    Booking bookingToEdit;
    SearchSystem searchSystem;
    
    int reservationPrice;


    public EditBookingWin(Booking bookingToEdit, ControllerLogic controllerLogic, SearchSystem searchSystem) {
        this.controllerLogic = controllerLogic;
        this.bookingToEdit = bookingToEdit;
        this.searchSystem = searchSystem;
        
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSaveChanges = new javax.swing.JButton();
        cmbPaymentMethod = new javax.swing.JComboBox<>();
        dateCheckIn = new com.toedter.calendar.JDateChooser();
        dateCheckOut = new com.toedter.calendar.JDateChooser();
        txtPrice = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnBack = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("/home/lancer5500ryz/NetBeansProjects/HotelAluraChallenge/src/main/resources/images/aH-150px.png")); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("/home/lancer5500ryz/NetBeansProjects/HotelAluraChallenge/src/main/resources/images/reservas-img-3.png")); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("X");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 540, 580));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("Booking Edition");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("RESERVATION PRICE:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("CHECK IN DATE:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("CHECK OUT DATE:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("PAYMENT METHOD:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        btnSaveChanges.setBackground(new java.awt.Color(0, 102, 204));
        btnSaveChanges.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnSaveChanges.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveChanges.setText("Save Changes");
        btnSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangesActionPerformed(evt);
            }
        });
        jPanel1.add(btnSaveChanges, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 160, 40));

        cmbPaymentMethod.setBackground(new java.awt.Color(0, 102, 204));
        cmbPaymentMethod.setForeground(new java.awt.Color(255, 255, 255));
        cmbPaymentMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "CREDIT CARD", "DEBIT CARD", "CASH" }));
        jPanel1.add(cmbPaymentMethod, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, -1, -1));

        dateCheckIn.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateCheckInPropertyChange(evt);
            }
        });
        jPanel1.add(dateCheckIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 190, -1));

        dateCheckOut.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateCheckOutPropertyChange(evt);
            }
        });
        jPanel1.add(dateCheckOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 190, -1));

        txtPrice.setBackground(new java.awt.Color(204, 204, 204));
        txtPrice.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        txtPrice.setForeground(new java.awt.Color(0, 102, 0));
        txtPrice.setText("Price USD");
        jPanel1.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 120, 20));

        btnBack.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        btnBack.setForeground(new java.awt.Color(0, 0, 0));
        btnBack.setText("<");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        JFrame frame = new JFrame("EXIT");
        if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit the app?", "EXIT", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void btnSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangesActionPerformed
        // TODO add your handling code here:
        if(reservationPrice <=0) {
            controllerLogic.showMessage("Please, select valid dates to make a reservation", "error", "No valid Dates");

        }
        else if (cmbPaymentMethod.getSelectedIndex() == 0) {
            controllerLogic.showMessage("Please, select a payment method", "error", "Select Payment Method");

        }
        else{
            //Edit Booking on DataBase
            controllerLogic.editBooking(bookingToEdit,reservationPrice, dateCheckIn.getDate(), dateCheckOut.getDate(), (String)cmbPaymentMethod.getSelectedItem());
            controllerLogic.showMessage("Edit Sucesfull", "info", "Edit Sucesfull");

            
            //IGo back to Precvious Window
            this.dispose();
            searchSystem.setVisible(true);
        }
    }//GEN-LAST:event_btnSaveChangesActionPerformed

    private void dateCheckInPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateCheckInPropertyChange
        // TODO add your handling code here:
        if (dateCheckIn.getDate() != null && dateCheckOut.getDate() != null){

            int diffBetweenDates = controllerLogic.calcDifferenceBetweenDates(dateCheckIn.getDate(), dateCheckOut.getDate());

            reservationPrice = controllerLogic.calcReservationPrice(diffBetweenDates);

            txtPrice.setText(reservationPrice + " USD");
        }
    }//GEN-LAST:event_dateCheckInPropertyChange

    private void dateCheckOutPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateCheckOutPropertyChange
        // TODO add your handling code here:

        if (dateCheckIn.getDate() != null && dateCheckOut.getDate() != null){

            int diffBetweenDates = controllerLogic.calcDifferenceBetweenDates(dateCheckIn.getDate(), dateCheckOut.getDate() );

            reservationPrice = controllerLogic.calcReservationPrice(diffBetweenDates);

            txtPrice.setText(reservationPrice + " USD");
        }
    }//GEN-LAST:event_dateCheckOutPropertyChange

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        txtPrice.setText(Integer.toString(bookingToEdit.getPrice()));
        dateCheckIn.setDate(bookingToEdit.getCheckInDate());
        dateCheckOut.setDate(bookingToEdit.getCheckOutDate());
        
        String cmbStringToEdit = bookingToEdit.getPaymentMethod();
        ComboBoxModel<String> cmbList = cmbPaymentMethod.getModel();
        int cmbIndex ;
        
        for(cmbIndex=0; cmbIndex<cmbList.getSize() ; cmbIndex++){
            
            if(cmbStringToEdit.equals((String)cmbList.getElementAt(cmbIndex))){
                break;
            }
        }
        
        cmbPaymentMethod.setSelectedIndex(cmbIndex);
    }//GEN-LAST:event_formWindowOpened

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        // TODO add your handling code here:
        this.dispose();
        searchSystem.setVisible(true);
    }//GEN-LAST:event_btnBackMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBack;
    private javax.swing.JButton btnSaveChanges;
    private javax.swing.JComboBox<String> cmbPaymentMethod;
    private com.toedter.calendar.JDateChooser dateCheckIn;
    private com.toedter.calendar.JDateChooser dateCheckOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel txtPrice;
    // End of variables declaration//GEN-END:variables
}
