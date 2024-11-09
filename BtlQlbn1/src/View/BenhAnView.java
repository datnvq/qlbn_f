/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

/**
 *
 * @author ducta
 */
import Model.BenhAn;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class BenhAnView extends javax.swing.JFrame {

    /**
     * Creates new form BenhANView
     */
    DocumentBuilderFactory dbf;
    DocumentBuilder db;
    Document doc;
    String filename = "src/XML/BenhAn.xml";
    DefaultTableModel dfmodel;

    public BenhAnView() {
        initComponents();
        HienThiBa();
        setLocationRelativeTo(null);
    }

    private void HienThiBa() {
        try {
            
            dbf = DocumentBuilderFactory.newDefaultInstance();
            db = dbf.newDocumentBuilder();
            doc = db.parse(filename );
            NodeList lId = doc.getElementsByTagName("Id");
            NodeList lTrieuChung = doc.getElementsByTagName("TrieuChung");
            NodeList lChanDoan = doc.getElementsByTagName("ChanDoan");
            NodeList lChiDinh = doc.getElementsByTagName("ChiDinh");
            NodeList lKetLuan = doc.getElementsByTagName("KetLuan");
            NodeList lDonThuoc = doc.getElementsByTagName("DonThuoc");
            ArrayList<BenhAn> lis = new ArrayList<>();
            for (int i = 0; i < lId.getLength(); i++) {
                BenhAn ba = new BenhAn();
                ba.setId(Integer.parseInt(lId.item(i).getTextContent()));
                ba.setTrieuChung(lTrieuChung.item(i).getTextContent());
                ba.setChanDoan(lChanDoan.item(i).getTextContent());
                ba.setChiDinh(lChiDinh.item(i).getTextContent());
                ba.setKetLuan(lKetLuan.item(i).getTextContent());
                ba.setDonThuoc(lDonThuoc.item(i).getTextContent());
                lis.add(ba);
            }
            dfmodel = new DefaultTableModel();
            dfmodel.setColumnCount(0);
            dfmodel.setRowCount(0);
            dfmodel.addColumn("Id");
            dfmodel.addColumn("Triệu chứng");
            dfmodel.addColumn("Chuẩn đoán");
            dfmodel.addColumn("Chỉ định");
            dfmodel.addColumn("Kết luận");
            dfmodel.addColumn("Đơn thuốc");

            for (BenhAn ba : lis) {
                Vector v = new Vector();
                v.add(ba.getId());
                v.add(ba.getTrieuChung());
                v.add(ba.getChanDoan());
                v.add(ba.getChiDinh());
                v.add(ba.getKetLuan());
                v.add(ba.getDonThuoc());
                dfmodel.addRow(v);
            }
            tblBenhAn.setModel(dfmodel);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DangKyKham2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DangKyKham2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DangKyKham2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Ghifile() {
        try {
            TransformerFactory tff = TransformerFactory.newInstance();
            Transformer tf = tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(filename);
            tf.transform(source, result);
            System.out.println("Ghi file thanh cong");
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(DangKyKham2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DangKyKham2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void XoaTextBox() {
        txtChiDinh.setText("");
        txtChuanDoan.setText("");
        txtDonThuoc.setText("");
        txtID.setText("");
        txtKetLuan.setText("");
        txtTrieuChung.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtChiDinh = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtTrieuChung = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDonThuoc = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtKetLuan = new javax.swing.JTextArea();
        txtID = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblBenhAn = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtChuanDoan = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Id:");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Chuẩn đoán:");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Chỉ định:");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("Kết luận:");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Đơn thuốc:");

        txtChiDinh.setColumns(20);
        txtChiDinh.setRows(5);
        jScrollPane2.setViewportView(txtChiDinh);

        txtTrieuChung.setColumns(20);
        txtTrieuChung.setRows(5);
        jScrollPane4.setViewportView(txtTrieuChung);

        txtDonThuoc.setColumns(20);
        txtDonThuoc.setRows(5);
        jScrollPane5.setViewportView(txtDonThuoc);

        txtKetLuan.setColumns(20);
        txtKetLuan.setRows(5);
        jScrollPane6.setViewportView(txtKetLuan);

        txtID.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        tblBenhAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Triệu chứng", "Chuẩn đoán", "Chỉ định", "Kết luận", "Đơn thuốc"
            }
        ));
        tblBenhAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBenhAnMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblBenhAn);

        btnAdd.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtChuanDoan.setColumns(20);
        txtChuanDoan.setRows(5);
        jScrollPane8.setViewportView(txtChuanDoan);

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setText("Triệu chứng:");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Khám bệnh");

        btnBack.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnBack.setText("Quay lại");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9))
                                        .addGap(50, 50, 50)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(54, 54, 54)
                                .addComponent(btnBack)))
                        .addContainerGap(302, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(430, 430, 430))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(81, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(37, 37, 37)
                                .addComponent(btnEdit)))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(btnBack))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        try {
            BenhAn ba = new BenhAn();
            if (txtID.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("ID không được để trống.");
            }
            ba.setId(Integer.parseInt(txtID.getText().trim()));
            if (txtTrieuChung.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Triệu chứng không được để trống.");
            }
            ba.setTrieuChung(txtTrieuChung.getText().trim());
            if (txtChuanDoan.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Chẩn đoán không được để trống.");
            }
            ba.setChanDoan(txtChuanDoan.getText().trim());
            if (txtChiDinh.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Chỉ định không được để trống.");
            }
            ba.setChiDinh(txtChiDinh.getText().trim());
            if (txtKetLuan.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Kết luận không được để trống.");
            }
            ba.setKetLuan(txtKetLuan.getText().trim());
            if (txtDonThuoc.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Đơn thuốc không được để trống.");
            }
            ba.setDonThuoc(txtDonThuoc.getText().trim());

            Element Id = doc.createElement("Id");
            Id.setTextContent(String.valueOf(ba.getId()));
            Element trieuChung = doc.createElement("TrieuChung");
            trieuChung.setTextContent(ba.getTrieuChung());
            Element chanDoan = doc.createElement("ChanDoan");
            chanDoan.setTextContent(ba.getChanDoan());
            Element chiDinh = doc.createElement("ChiDinh");
            chiDinh.setTextContent(ba.getChiDinh());
            Element ketLuan = doc.createElement("KetLuan");
            ketLuan.setTextContent(ba.getKetLuan());
            Element donThuoc = doc.createElement("DonThuoc");
            donThuoc.setTextContent(ba.getDonThuoc());

            Element hoSo = doc.createElement("HoSo");
            Element BenhAn = doc.getDocumentElement();
            BenhAn.appendChild(hoSo);

            hoSo.appendChild(Id);
            hoSo.appendChild(trieuChung);
            hoSo.appendChild(chanDoan);
            hoSo.appendChild(chiDinh);
            hoSo.appendChild(ketLuan);
            hoSo.appendChild(donThuoc);
            Ghifile();
            HienThiBa();
            XoaTextBox();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số cho trường ID.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void tblBenhAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBenhAnMouseClicked
        // TODO add your handling code here:
        int hang = tblBenhAn.getSelectedRow();
        int Id = (int) tblBenhAn.getValueAt(hang, 0);
        String trieuChung = (String) tblBenhAn.getValueAt(hang, 1);
        String chuanDoan = (String) tblBenhAn.getValueAt(hang, 2);
        String chiDinh = (String) tblBenhAn.getValueAt(hang, 3);
        String ketLuan = (String) tblBenhAn.getValueAt(hang, 4);
        String donThuoc = (String) tblBenhAn.getValueAt(hang, 5);
        txtID.setText(String.valueOf(Id));
        txtChiDinh.setText(chiDinh);
        txtChuanDoan.setText(chuanDoan);
        txtDonThuoc.setText(donThuoc);
        txtKetLuan.setText(ketLuan);
        txtTrieuChung.setText(trieuChung);
    }//GEN-LAST:event_tblBenhAnMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int id = Integer.parseInt(txtID.getText());
            String str = "BenhAn/HoSo[Id='" + id + "']";
            XPathFactory xf = XPathFactory.newInstance();
            XPath path = xf.newXPath();
            Element benhan = (Element) path.evaluate(str, doc, XPathConstants.NODE);
            Node parent = benhan.getParentNode();
            parent.removeChild(benhan);
            Ghifile();
            HienThiBa();
            XoaTextBox();
        } catch (XPathExpressionException ex) {
            Logger.getLogger(DangKyKham2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int id = Integer.parseInt(txtID.getText());
            String str = "BenhAn/HoSo[Id='" + id + "']";
            XPathFactory xf = XPathFactory.newInstance();
            XPath path = xf.newXPath();
            Element benhan = (Element) path.evaluate(str, doc, XPathConstants.NODE);
            NodeList children = benhan.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                if (children.item(i).getNodeName().equals("TrieuChung")) {
                    children.item(i).setTextContent(txtTrieuChung.getText());
                } else if (children.item(i).getNodeName().equals("ChanDoan")) {
                    children.item(i).setTextContent(txtChuanDoan.getText());
                } else if (children.item(i).getNodeName().equals("ChiDinh")) {
                    children.item(i).setTextContent(txtChiDinh.getText());
                } else if (children.item(i).getNodeName().equals("KetLuan")) {
                    children.item(i).setTextContent(txtKetLuan.getText());
                }
                if (children.item(i).getNodeName().equals("DonThuoc")) {
                    children.item(i).setTextContent(txtDonThuoc.getText());
                }
            }
            Ghifile();
            HienThiBa();
            XoaTextBox();
        } catch (XPathExpressionException ex) {
            Logger.getLogger(DangKyKham2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        GiaoDienChinh giaoDienChinh = new GiaoDienChinh();
        giaoDienChinh.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(BenhAnView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BenhAnView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BenhAnView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BenhAnView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BenhAnView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTable tblBenhAn;
    private javax.swing.JTextArea txtChiDinh;
    private javax.swing.JTextArea txtChuanDoan;
    private javax.swing.JTextArea txtDonThuoc;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextArea txtKetLuan;
    private javax.swing.JTextArea txtTrieuChung;
    // End of variables declaration//GEN-END:variables
}
