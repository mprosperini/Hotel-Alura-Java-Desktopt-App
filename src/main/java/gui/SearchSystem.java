package gui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import logic.Booking;
import logic.ControllerLogic;
import logic.Guest;

public class SearchSystem extends javax.swing.JFrame {
    
    ControllerLogic controllerLogic;
    UserMenuWin usrMenuWin;
    
    private JTable selectedTable;
    private int selectedTab;
    
    String defaultSearchText = "Search by Guest LastName or Booking Id" ;


    public SearchSystem(ControllerLogic controllerLogic, UserMenuWin usrMenuWin) {
        this.controllerLogic = controllerLogic;
        this.usrMenuWin = usrMenuWin;
        
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
        btnBack = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        btnSearch = new java.awt.Button();
        btnDelete = new java.awt.Button();
        btnEdit = new java.awt.Button();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGuest = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBooking = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        txtSearch = new javax.swing.JTextField();
        btnRefreshTable = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        btnExit.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        btnExit.setForeground(new java.awt.Color(0, 0, 0));
        btnExit.setText("X");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, -1, -1));

        btnSearch.setBackground(new java.awt.Color(0, 102, 204));
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setLabel("SEARCH");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 100, 110, 40));

        btnDelete.setBackground(new java.awt.Color(0, 102, 204));
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setLabel("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 650, 110, 40));

        btnEdit.setBackground(new java.awt.Color(0, 102, 204));
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setLabel("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 650, 110, 40));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("Guest Registry");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("/home/lancer5500ryz/NetBeansProjects/HotelAluraChallenge/src/main/resources/images/Ha-100px.png")); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(0, 102, 255));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblGuest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblGuest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGuestMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGuest);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1100, 360));

        jTabbedPane1.addTab("Guest", new javax.swing.ImageIcon("/home/lancer5500ryz/NetBeansProjects/HotelAluraChallenge/src/main/resources/images/pessoas.png"), jPanel3); // NOI18N

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblBooking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBookingMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBooking);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1100, 370));

        jTabbedPane1.addTab("Bookling", new javax.swing.ImageIcon("/home/lancer5500ryz/NetBeansProjects/HotelAluraChallenge/src/main/resources/images/reservado.png"), jPanel4); // NOI18N

        jPanel2.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 20, 1120, 430));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 1150, 480));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 580, 20));

        txtSearch.setBackground(new java.awt.Color(204, 204, 204));
        txtSearch.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(0, 0, 0));
        txtSearch.setBorder(null);
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        jPanel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 550, 30));

        btnRefreshTable.setBackground(new java.awt.Color(0, 102, 204));
        btnRefreshTable.setForeground(new java.awt.Color(255, 255, 255));
        btnRefreshTable.setIcon(new javax.swing.ImageIcon("/home/lancer5500ryz/NetBeansProjects/HotelAluraChallenge/src/main/resources/images/icons8-refresh-40.png")); // NOI18N
        btnRefreshTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshTableActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefreshTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 100, 50, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        // TODO add your handling code here:
        this.dispose();
        usrMenuWin.setVisible(true);
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        JFrame frame = new JFrame("EXIT");
        if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit the app?", "EXIT", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if(selectedTab == 0) {
            uploadTableGuest();
        }
        
        else if (selectedTab == 1){
            //Checkin the search contains only numbers with regex
            if(txtSearch.getText().matches("\\d+")){
                uploadTableBooking();
            }
            else {
                controllerLogic.showMessage("Needs to insert a number", "error", "Number not detected");
            }
        }
        

    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       if (selectedTable.getRowCount() > 0) {

            //Checking table row has been selected
            if (selectedTable.getSelectedRow() != -1) {

                //geting the id of the Booking/Guest to delete
                int selectedTableId = Integer.parseInt(String.valueOf(selectedTable.getValueAt(selectedTable.getSelectedRow(), 0)));

                //Calling delete method & Uploading Table
                if (selectedTable == tblBooking){
                    controllerLogic.deleteBooking(selectedTableId);
                    this.uploadTableBooking();
                    
                }
                else {
                    controllerLogic.deleteGuest(selectedTableId);
                    this.uploadTableGuest();
                }

                //Show message Delete Sucesfull
                controllerLogic.showMessage("Delete Sucesfull", "info", "Delete Sucesfull");
                
            } else {
                controllerLogic.showMessage("You have to select a row from table", "error", "Error Trying to Delete");
            }
        } else {
            controllerLogic.showMessage("Table is empty", "error", "Error Trying to Delete");
        }


    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (selectedTab == 0) {
            selectedTable = tblGuest;
        } else {
            selectedTable = tblBooking;
        }

        //Checking table is not empty
        if (selectedTable.getRowCount() > 0) {

            //Checking table row has been selected
            if (selectedTable.getSelectedRow() != -1) {

                //geting the id of the Booking/Guest to edit
                int selectedId = Integer.parseInt(selectedTable.getValueAt(selectedTable.getSelectedRow(), 0).toString());
                
                if(selectedTable == tblBooking){
                    
                    Booking bookingToEdit = controllerLogic.findBooking(selectedId);
                    
                    EditBookingWin editBookingWin = new EditBookingWin(bookingToEdit, controllerLogic, this);
                    editBookingWin.setVisible(true);
                    editBookingWin.setLocationRelativeTo(null);
                    
                    this.setVisible(false);
                
                }
                else {
                    
                    Guest guestToEdit = controllerLogic.findGuest(selectedId);
                    EditGuestWin editGuestWin = new EditGuestWin(guestToEdit, controllerLogic, this);
                    editGuestWin.setVisible(true);
                    editGuestWin.setLocationRelativeTo(null);
                    this.setVisible(false);
                    
                    
//                    
//                    Guest guestToEdit = controllerLogic.findGuest(selectedId);
//                    EditBookingWin editBookingWin = new EditBookingWin(guestToEdit, controllerLogic, this);
//                    editBookingWin.setVisible(true);
//                    editBookingWin.setLocationRelativeTo(null);
//                    this.setVisible(false);
System.out.println("Guest Edit code here");

                }

            } else {
                controllerLogic.showMessage("You have to select a row", "error", "Error Trying to Edit");
            }
        } else {
            controllerLogic.showMessage("Table is empty", "error", "Error Trying to Edit");
        }
        
        
        
        
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.uploadTableBooking();
        this.uploadTableGuest();
        txtSearch.setText(defaultSearchText);
    }//GEN-LAST:event_formWindowOpened

    private void tblGuestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGuestMouseClicked
        // TODO add your handling code here:
        selectedTable = tblGuest;
    }//GEN-LAST:event_tblGuestMouseClicked

    private void tblBookingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookingMouseClicked
        // TODO add your handling code here:
        selectedTable = tblBooking;
    }//GEN-LAST:event_tblBookingMouseClicked

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        // TODO add your handling code here:
        if(txtSearch.getText().equals(defaultSearchText)){
            txtSearch.setText("");
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        // TODO add your handling code here:
        if (txtSearch.getText().isEmpty()) {
            txtSearch.setText(defaultSearchText);
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here:
        selectedTab= jTabbedPane1.getSelectedIndex();
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void btnRefreshTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshTableActionPerformed
        // TODO add your handling code here:
        txtSearch.setText("");
        if (selectedTab == 0) {
            uploadTableGuest();
        } else if  (selectedTab == 1) {
            uploadTableBooking();
        }
        
    }//GEN-LAST:event_btnRefreshTableActionPerformed


    private void uploadTableBooking() {
        //Defining the model we want for the modelTable
        DefaultTableModel modelTable = new DefaultTableModel() {

            //making row and columns non editables
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        //We set the column names 
        String tittles[] = {"idBooking", "CheckIn Date", "CheckOut Date", "Price", "Payment Method"};
        modelTable.setColumnIdentifiers(tittles);
        
        //Setting Table Data from DataBase
        List<Booking> bookingList = controllerLogic.getBookingList();

        //Iterating through the list and displaying each element in the table
        if (bookingList != null) {
            
            //If an Id Search was maded//
            if (txtSearch.getText().matches("\\d+")) {
                 //Booking booking =controllerLogic.findBooking(Integer.parseInt(txtSearch.getText()));
                 //Filter the List using a Stream 
                 bookingList = bookingList.stream().filter(element -> String.valueOf(element.getIdBooking()).startsWith(txtSearch.getText())).collect(Collectors.toList());
                 
                 for(Booking booking : bookingList) {
                     Object[] object = {booking.getIdBooking(), formatDate(booking.getCheckInDate()), formatDate(booking.getCheckOutDate()), booking.getPrice(), booking.getPaymentMethod()};
                     modelTable.addRow(object);
                             
                 }
                 
            }

            
            else{
                for (Booking booking : bookingList) {
                    Object[] object = {booking.getIdBooking(), formatDate(booking.getCheckInDate()), formatDate(booking.getCheckOutDate()), booking.getPrice(), booking.getPaymentMethod()};
                    modelTable.addRow(object);
                }
            
            }

        }

        tblBooking.setModel(modelTable);
        
        
        // Adjust Column Width
        TableColumnModel columnModel = tblBooking.getColumnModel();
        for (int columnIndex = 0; columnIndex < columnModel.getColumnCount(); columnIndex++) {
            TableColumn column = columnModel.getColumn(columnIndex);
            int maxTextWidth = getMaxTextWidth(tblBooking, columnIndex);
            column.setPreferredWidth(maxTextWidth);
        }
    }

    
    
    private void uploadTableGuest() {
        //Defining the model we want for the modelTable
        DefaultTableModel modelTable = new DefaultTableModel() {

            //making row and columns non editables
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        //We set the column names 
        String tittles[] = {"Guest_Id","FirstName", "LastName", "BirthDate", "Nationality", "PhoneNumber"};
        modelTable.setColumnIdentifiers(tittles);

        //Setting Table Data from DataBase
        List<Guest> guestList = controllerLogic.getGuestList();

        //Iterating through the list and displaying each element in the table
        if (guestList != null) {
            
            //Applying Filter IF btnSearch was executed
            if(txtSearch.getText().length() > 0){
                
                
               List<Guest> filteredGuestList = guestList.stream().filter(guest -> guest.getGuestLastName().startsWith(txtSearch.getText())).collect(Collectors.toList());
                for (Guest guest : filteredGuestList) {                                                                                        
                    Object[] object = {guest.getIdGuest(), guest.getGuestName(), guest.getGuestLastName(), formatDate(guest.getGuestBirthDate()), guest.getGuestNationality(), guest.getGuestPhone()};

                    modelTable.addRow(object);
                }
            }
            
            else{
                for (Guest guest : guestList) {                                                                                                       
                    Object[] object = {guest.getIdGuest(), guest.getGuestName(), guest.getGuestLastName(), formatDate(guest.getGuestBirthDate()), guest.getGuestNationality(), guest.getGuestPhone()};

                    modelTable.addRow(object);
                }
            }

        }

        tblGuest.setModel(modelTable);
        
        // Adjust Colum width
        TableColumnModel columnModel = tblGuest.getColumnModel();
        for (int columnIndex = 0; columnIndex < columnModel.getColumnCount(); columnIndex++) {
            TableColumn column = columnModel.getColumn(columnIndex);
            int maxTextWidth = getMaxTextWidth(tblGuest, columnIndex);
            column.setPreferredWidth(maxTextWidth);
        }
    }

    
    //Get MaxTextWidht to fix the colum width
    private int getMaxTextWidth(JTable table, int columnIndex) {
        int maxTextWidth = 0;
        for (int rowIndex = 0; rowIndex < table.getRowCount(); rowIndex++) {
            Object value = table.getValueAt(rowIndex, columnIndex);
            int textWidth = table.getFontMetrics(table.getFont()).stringWidth(String.valueOf(value));
            maxTextWidth = Math.max(maxTextWidth, textWidth);
        }
        return maxTextWidth;

    }

    //Format any Date to "dd/MM/yy format"    
    private String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yyyy");
        return format.format(date);
    }



    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBack;
    private java.awt.Button btnDelete;
    private java.awt.Button btnEdit;
    private javax.swing.JLabel btnExit;
    private javax.swing.JButton btnRefreshTable;
    private java.awt.Button btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblBooking;
    private javax.swing.JTable tblGuest;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables



}

