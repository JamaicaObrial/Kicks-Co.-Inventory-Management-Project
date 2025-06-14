import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class shoeInventoryForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(shoeInventoryForm.class.getName());
    //Variables storing maximum and minimum
    private static double sizeMin = 1.0;
    private static double sizeMax = 100.0; 
    private static int qtyMax = 99;
    private static double priceMax = 10000.00;
    public shoeInventoryForm() {
        initComponents();
        Connect();
        LoadShoeNo();
        Fetch();
    }
    
    Connection con;
    PreparedStatement pst; //for SQL Statements
    ResultSet rs;
    
    //establishes connection with the database
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3307/shoeinventory";
            String user = "root";
            String password = "";
            con = DriverManager.getConnection(url, user, password );
        } catch (ClassNotFoundException ex) {
            System.getLogger(shoeInventoryForm.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (SQLException ex) {
            System.getLogger(shoeInventoryForm.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
   
    //Stores ID numbers into the "Shoe ID" Combo Box/ Dropdown Option
    public void LoadShoeNo(){
        try {
            pst = con.prepareStatement("SELECT id FROM shoe_tbl");
            rs = pst.executeQuery();
            txtShoeID.removeAllItems();
            while(rs.next()){
                txtShoeID.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.getLogger(shoeInventoryForm.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    //updates data in the table
    private void Fetch(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM shoe_tbl");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int a = 1; a<= q; a++){
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("shoeName"));
                    v2.add(rs.getString("brand"));
                    v2.add(rs.getString("size"));
                    v2.add(rs.getString("qty"));
                    v2.add(rs.getString("price"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            System.getLogger(shoeInventoryForm.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    //UI / FrontEnd Organization Code
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtBrand = new javax.swing.JTextField();
        txtShoeName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSize = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        btnClearField = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtQty = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtShoeID = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setSize(new java.awt.Dimension(767, 671));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Untitled design (1) (1).png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Inventory");

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Manager");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButton1))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jButton1)
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9)))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 720));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 337, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        txtBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBrandActionPerformed(evt);
            }
        });

        txtShoeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtShoeNameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        jLabel5.setText("Price: ");

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        jLabel2.setText("Brand:");

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        jLabel3.setText("Size:");

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        jLabel4.setText("Quantity:");

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        jLabel1.setText("Shoe Name:");

        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });

        btnClearField.setBackground(new java.awt.Color(0, 0, 0));
        btnClearField.setForeground(new java.awt.Color(255, 255, 255));
        btnClearField.setText("Clear Fields");
        btnClearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFieldActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 0, 0));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/saveplus (1).png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtShoeName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnClearField)
                                .addGap(46, 46, 46)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtShoeName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClearField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Shoe ID", "Shoe Name", "Brand", "Size", "Qty", "Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setFont(new java.awt.Font("Leelawadee UI", 1, 30)); // NOI18N
        jLabel7.setText("Inventory Manager ");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1749571237023 (4).png"))); // NOI18N
        jLabel8.setText("jLabel8");

        txtShoeID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtShoeID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtShoeIDActionPerformed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(0, 0, 0));
        btnSearch.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trashload (2) (1).png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 0, 0));
        btnUpdate.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/saveload (1).png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 0, 0));
        btnDelete.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 51, 51));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trashload (1).png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Shoe ID:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtShoeID, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtShoeID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
        );

        btnDelete.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 930, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void txtBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBrandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBrandActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    //Displays Record in Text Field
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            //Get Data from  the Table with the same id as the input
            String shoeID = txtShoeID.getSelectedItem().toString();
            pst = con.prepareStatement("SELECT * FROM shoe_tbl WHERE id = ?");
            pst.setString(1, shoeID);
            rs=pst.executeQuery();
            
            //Display Record details
            if(rs.next()==true){
                txtShoeName.setText(rs.getString(2));
                txtBrand.setText(rs.getString(3));
                txtSize.setText(rs.getString(4));
                txtQty.setText(rs.getString(5));
                txtPrice.setText(rs.getString(6));
            }else{
                JOptionPane.showMessageDialog(this, "Error: No record found");
            }
        } catch (SQLException ex) {
            System.getLogger(shoeInventoryForm.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtyActionPerformed

  
    //Adds A record to the Table once "Add" button is pressed.
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            // Trim and get input text from fields
            String shoeName = txtShoeName.getText().trim();
            String brand = txtBrand.getText().trim();
            String sizeStr = txtSize.getText().trim();
            String qtyStr = txtQty.getText().trim();
            String priceStr = txtPrice.getText().trim();
            String errorMessage;

            // If Empty, do not Record
            if (shoeName.isEmpty() || brand.isEmpty() || sizeStr.isEmpty() || qtyStr.isEmpty() || priceStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: All fields must be filled out.");
                return;
            }

            //Fixes Non-uniform typings (e.g. SamPle InPUt)
            shoeName = shoeName.substring(0,1).toUpperCase() + shoeName.substring(1).toLowerCase();
            brand = brand.substring(0,1).toUpperCase() + brand.substring(1).toLowerCase();
            
            // Convert String Input to Numeric Values
            double size = Double.parseDouble(sizeStr);
            int qty = Integer.parseInt(qtyStr);
            double price = Double.parseDouble(priceStr);
            
            
            // If invalid names, has negative values or higher than max values, do not record
            errorMessage = "Error:\n";
            if (!shoeName.matches("[a-zA-Z ]+") || !brand.matches("[a-zA-Z ]+") || size < sizeMin || size > sizeMax || qty < 0  || qty > qtyMax || price < 0 || price > priceMax) {
                if (!shoeName.matches("[a-zA-Z ]+")){
                    errorMessage = errorMessage + "- Shoe Name must contain only letters and spaces.\n";
                }
                
                if (!brand.matches("[a-zA-Z ]+")){
                    errorMessage = errorMessage + "- Brand must contain only letters and spaces.\n";
                }
                if(size < sizeMin || size > sizeMax){
                    errorMessage = errorMessage + "- Size must be in range [" + sizeMin +" - " + sizeMax + "]\n";
                }
                if(qty < 0  || qty > qtyMax){
                    errorMessage = errorMessage + "- Quantity must be in range [" + 0 + " - " + qtyMax + "]\n";
                }
                if(price < 0 || price > priceMax){
                    errorMessage += "- Price must be in range [0 - " + priceMax + "]\n";
                }
                JOptionPane.showMessageDialog(this, errorMessage);
                return;
            }

            // Prepare "Insert to Table" SQL Statement
            pst = con.prepareStatement("INSERT INTO shoe_tbl (shoeName, brand, size, qty, price) VALUES (?, ?, ?, ?, ?)");
            pst.setString(1, shoeName);
            pst.setString(2, brand);
            pst.setDouble(3, size);
            pst.setInt(4, qty);
            pst.setDouble(5, price);

            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Record Added Successfully");
                txtShoeName.setText("");
                txtBrand.setText("");
                txtSize.setText("");
                txtQty.setText("");
                txtPrice.setText("");
                //Adds the record to the table, and id to the search combo box
                LoadShoeNo();
                Fetch();
            } else {
                JOptionPane.showMessageDialog(this, "Error: Record Failed To Save");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Please enter valid numeric values for size, quantity, and price.");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(shoeInventoryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtShoeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtShoeNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtShoeNameActionPerformed

    //Clears text from the text fields.
    private void btnClearFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFieldActionPerformed
        txtShoeName.setText("");
        txtBrand.setText("");
        txtSize.setText("");
        txtQty.setText("");
        txtPrice.setText("");
    }//GEN-LAST:event_btnClearFieldActionPerformed

    //Updates the changes made by the user to a specific record
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            // Trim and get input text from fields
            String shoeName = txtShoeName.getText().trim();
            String brand = txtBrand.getText().trim();
            String sizeStr = txtSize.getText().trim();
            String qtyStr = txtQty.getText().trim();
            String priceStr = txtPrice.getText().trim();
            String shoeID = txtShoeID.getSelectedItem().toString(); 
            String errorMessage;

            //If empty, do not record.
            if (shoeName.isEmpty() || brand.isEmpty() || sizeStr.isEmpty() || qtyStr.isEmpty() || priceStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: All fields must be filled out.");
                return;
            }

            //Fixes Non-uniform typings (e.g. SamPle InPUt)
            shoeName = shoeName.substring(0, 1).toUpperCase() + shoeName.substring(1).toLowerCase();
            brand = brand.substring(0, 1).toUpperCase() + brand.substring(1).toLowerCase();

            //Converts String input to numeric values
            double size = Double.parseDouble(sizeStr);
            int qty = Integer.parseInt(qtyStr);
            double price = Double.parseDouble(priceStr);

           
            //If invalid names, has negative values or higher than max values, do not record
            errorMessage = "Error:\n";

            if (!shoeName.matches("[a-zA-Z ]+") || !brand.matches("[a-zA-Z ]+") || size < sizeMin || size > sizeMax || qty < 0 || qty > qtyMax || price < 0 || price > priceMax) {
                if (!shoeName.matches("[a-zA-Z ]+")) {
                    errorMessage += "- Shoe Name must contain only letters and spaces.\n";
                }
                if (!brand.matches("[a-zA-Z ]+")) {
                    errorMessage += "- Brand must contain only letters and spaces.\n";
                }
                if (size < sizeMin || size > sizeMax) {
                    errorMessage += "- Size must be in range [" + sizeMin + " - " + sizeMax + "]\n";
                }
                if (qty < 0 || qty > qtyMax) {
                    errorMessage += "- Quantity must be in range [0 - " + qtyMax + "]\n";
                }
                if (price < 0 || price > priceMax) {
                    errorMessage += "- Price must be in range [0 - " + priceMax + "]\n";
                }
                JOptionPane.showMessageDialog(this, errorMessage);
                return;
            }

            //Prepare Update Statement
            pst = con.prepareStatement("UPDATE shoe_tbl SET shoeName = ?, brand = ?, size = ?, qty = ?, price = ? WHERE id = ?");
            pst.setString(1, shoeName);
            pst.setString(2, brand);
            pst.setDouble(3, size);
            pst.setInt(4, qty);
            pst.setDouble(5, price);
            pst.setString(6, shoeID);

            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Record Updated Successfully");

                // Clear form
                txtShoeName.setText("");
                txtBrand.setText("");
                txtSize.setText("");
                txtQty.setText("");
                txtPrice.setText("");
                txtShoeName.requestFocus();
                LoadShoeNo(); 
                Fetch();      
            } else {
                JOptionPane.showMessageDialog(this, "Error: Record Failed To Update");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Please enter valid numeric values for size, quantity, and price.");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(shoeInventoryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    //Deletes a record from the table
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            String shoeID = txtShoeID.getSelectedItem().toString();
            pst=con.prepareStatement("DELETE FROM shoe_tbl WHERE id = ?");
            pst.setString(1, shoeID);
            
            int k = pst.executeUpdate();
            if(k==1){
                JOptionPane.showMessageDialog(this, "Record has been successfully deleted");
                txtShoeName.setText("");
                txtBrand.setText("");
                txtSize.setText("");
                txtQty.setText("");
                txtPrice.setText("");
                txtShoeName.requestFocus();
                LoadShoeNo();
                Fetch();
            }
            else{
               JOptionPane.showMessageDialog(this, "Error: Record failed to delete");

            }
        } catch (SQLException ex) {
            System.getLogger(shoeInventoryForm.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtShoeIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtShoeIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtShoeIDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Show only the Login Form at the Start of the Program
        java.awt.EventQueue.invokeLater(() -> new LoginForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClearField;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQty;
    private javax.swing.JComboBox<String> txtShoeID;
    private javax.swing.JTextField txtShoeName;
    private javax.swing.JTextField txtSize;
    // End of variables declaration//GEN-END:variables
}
