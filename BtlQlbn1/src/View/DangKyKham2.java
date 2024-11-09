/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

/**
 *
 * @author ducta
 */
import Model.BenhNhan;
import java.io.File;
import java.io.FileNotFoundException;
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

public class DangKyKham2 extends javax.swing.JFrame {

    DocumentBuilderFactory dbf;
    DocumentBuilder db;
    Document doc;
    String filename = "src/XML/BenhNhan.xml";
    DefaultTableModel model;

    /**
     * Creates new form DangKyKham2
     */
    private void Ghifile() {
        try {
            

            TransformerFactory tff = TransformerFactory.newInstance();
            Transformer tf = tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(filename);

            tf.transform(source, result);
            System.out.println("Ghi file thành công");
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(DangKyKham2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DangKyKham2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void HienThi() {
        try {
            dbf = DocumentBuilderFactory.newDefaultInstance();
            db = dbf.newDocumentBuilder();

            // Đọc tệp XML từ tài nguyên trong JAR hoặc thư mục src
            

            doc = db.parse(filename);

            // Tiếp tục xử lý các phần khác...
            NodeList lId = doc.getElementsByTagName("Id");
            NodeList lTen = doc.getElementsByTagName("Ten");
            NodeList lNgay = doc.getElementsByTagName("NgayKham");
            NodeList lTuoi = doc.getElementsByTagName("Tuoi");
            NodeList lSex = doc.getElementsByTagName("GioiTinh");
            NodeList lDiaChi = doc.getElementsByTagName("DiaChi");
            NodeList lDienThoai = doc.getElementsByTagName("SoDienThoai");
            NodeList lYeuCau = doc.getElementsByTagName("YeuCau");

            ArrayList<BenhNhan> li = new ArrayList<>();
            for (int i = 0; i < lId.getLength(); i++) {
                BenhNhan bn = new BenhNhan();
                bn.setId(Integer.parseInt(lId.item(i).getTextContent()));
                bn.setHoTen(lTen.item(i).getTextContent());
                bn.setNgayKham(lNgay.item(i).getTextContent());
                bn.setTuoi(Integer.parseInt(lTuoi.item(i).getTextContent()));
                bn.setGioiTinh(lSex.item(i).getTextContent());
                bn.setDiaChi(lDiaChi.item(i).getTextContent());
                bn.setDienThoai(lDienThoai.item(i).getTextContent());
                bn.setYeuCau(lYeuCau.item(i).getTextContent());
                li.add(bn);
            }

            // Hiển thị vào bảng (table) tương tự như hiện tại...
            model = new DefaultTableModel();
            model.setColumnCount(0);
            model.setRowCount(0);
            model.addColumn("Id");
            model.addColumn("Họ và tên");
            model.addColumn("Ngày khám");
            model.addColumn("Tuổi");
            model.addColumn("Giới tính");
            model.addColumn("Số điện thoại");
            model.addColumn("Địa chỉ");
            model.addColumn("Yêu cầu");

            for (BenhNhan bn : li) {
                Vector v = new Vector();
                v.add(bn.getId());
                v.add(bn.getHoTen());
                v.add(bn.getNgayKham());
                v.add(bn.getTuoi());
                v.add(bn.getGioiTinh());
                v.add(bn.getDienThoai());
                v.add(bn.getDiaChi());
                v.add(bn.getYeuCau());
                model.addRow(v);
            }
            tblBenhNhan.setModel(model);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(DangKyKham2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DangKyKham2() {
        initComponents();
        HienThi();
        setLocationRelativeTo(null);
    }

    // Hàm kiểm tra tính hợp lệ của ngày
    private boolean isValidDate(int day, int month, int year) {
        // Kiểm tra tháng có 30 ngày
        if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
            return false;
        }
        // Kiểm tra tháng 2 (năm nhuận và không nhuận)
        if (month == 2) {
            if (isLeapYear(year) && day > 29) {
                return false;
            }
            if (!isLeapYear(year) && day > 28) {
                return false;
            }
        }
        return true;
    }

    // Hàm kiểm tra năm nhuận
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtYeuCau = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBenhNhan = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        txtDay = new javax.swing.JTextField();
        txtMonth = new javax.swing.JTextField();
        txtYear = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnAdd1 = new javax.swing.JButton();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtID.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Họ và tên:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Id:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Ngày khám:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Tuổi:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Giới tính:");

        txtName.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtAge.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtPhone.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtAddress.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Yêu cầu:");

        txtYeuCau.setColumns(20);
        txtYeuCau.setRows(5);
        jScrollPane2.setViewportView(txtYeuCau);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Số điện thoại:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Địa chỉ:");

        tblBenhNhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Họ và tên", "Ngày khám", "Tuổi", "Giới tính", "Số điện thoại", "Địa chỉ", "Yêu cầu"
            }
        ));
        tblBenhNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBenhNhanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBenhNhan);

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

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel9.setText("Đăng ký khám");

        btnBack.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnBack.setText("Quay lại");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtDay.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtMonth.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtYear.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("/");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setText("/");

        btnSearch.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnSearch.setText("Tìm kiếm theo ID");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnThongKe.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnThongKe.setText("Thống kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        btnAdd1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAdd1.setText("Hủy");
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });

        rdoMale.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rdoMale.setText("Nam");

        rdoFemale.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        rdoFemale.setText("Nữ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(rdoMale, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(142, 142, 142)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtYear)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(123, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(399, 399, 399))
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(btnSearch)
                .addGap(11, 11, 11)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdd1)
                .addGap(111, 111, 111)
                .addComponent(btnThongKe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel9)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoMale)
                            .addComponent(rdoFemale)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete)
                    .addComponent(btnBack)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThongKe)
                    .addComponent(btnAdd1))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            BenhNhan bn = new BenhNhan();

            // Kiểm tra ID
            if (txtID.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("ID không được để trống.");
            }
            bn.setId(Integer.parseInt(txtID.getText().trim()));

            // Kiểm tra Họ Tên
            if (txtName.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Họ tên không được để trống.");
            }
            bn.setHoTen(txtName.getText().trim());

            // Kiểm tra Ngày Khám
            if (txtDay.getText().trim().isEmpty() || txtMonth.getText().trim().isEmpty() || txtYear.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Ngày khám không được để trống.");
            }
            int day = Integer.parseInt(txtDay.getText().trim());
            int month = Integer.parseInt(txtMonth.getText().trim());
            int year = Integer.parseInt(txtYear.getText().trim());
            if (day < 1 || day > 31) {
                throw new IllegalArgumentException("Ngày không hợp lệ (phải từ 1 đến 31).");
            }
            if (month < 1 || month > 12) {
                throw new IllegalArgumentException("Tháng không hợp lệ (phải từ 1 đến 12).");
            }
            if (!isValidDate(day, month, year)) {
                throw new IllegalArgumentException("Ngày, tháng, năm không hợp lệ.");
            }
            bn.setNgayKham(day + "/" + month + "/" + year);

            // Kiểm tra Tuổi
            if (txtAge.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Tuổi không được để trống.");
            }
            bn.setTuoi(Integer.parseInt(txtAge.getText().trim()));

            // Kiểm tra Giới Tính
            if (rdoMale.isSelected()) {
                bn.setGioiTinh("Nam");
            } else if (rdoFemale.isSelected()) {
                bn.setGioiTinh("Nữ");
            } else {
                throw new IllegalArgumentException("Giới tính không được để trống. Vui lòng chọn Nam hoặc Nữ.");
            }

            // Kiểm tra Số Điện Thoại
            if (txtPhone.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Số điện thoại không được để trống.");
            }
            bn.setDienThoai(txtPhone.getText().trim());

            // Kiểm tra Địa Chỉ
            if (txtAddress.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Địa chỉ không được để trống.");
            }
            bn.setDiaChi(txtAddress.getText().trim());

            // Kiểm tra Yêu Cầu
            if (txtYeuCau.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Yêu cầu không được để trống.");
            }
            bn.setYeuCau(txtYeuCau.getText().trim());

            // Tạo các phần tử XML
            Element Id = doc.createElement("Id");
            Id.setTextContent(String.valueOf(bn.getId()));
            Element name = doc.createElement("Ten");
            name.setTextContent(bn.getHoTen());
            Element ngayKham = doc.createElement("NgayKham");
            ngayKham.setTextContent(bn.getNgayKham());
            Element age = doc.createElement("Tuoi");
            age.setTextContent(String.valueOf(bn.getTuoi()));
            Element gioiTinh = doc.createElement("GioiTinh");
            gioiTinh.setTextContent(bn.getGioiTinh());
            Element diachi = doc.createElement("DiaChi");
            diachi.setTextContent(bn.getDiaChi());
            Element phone = doc.createElement("SoDienThoai");
            phone.setTextContent(bn.getDienThoai());
            Element yeuCau = doc.createElement("YeuCau");
            yeuCau.setTextContent(bn.getYeuCau());

            // Thêm vào tài liệu XML
            Element BenhNhan = doc.getDocumentElement();
            Element thongTin = doc.createElement("ThongTin");
            BenhNhan.appendChild(thongTin);
            thongTin.appendChild(Id);
            thongTin.appendChild(name);
            thongTin.appendChild(ngayKham);
            thongTin.appendChild(age);
            thongTin.appendChild(diachi);
            thongTin.appendChild(phone);
            thongTin.appendChild(gioiTinh);
            thongTin.appendChild(yeuCau);
            BenhNhan.appendChild(thongTin);

            // Ghi file, hiển thị và xóa textbox
            Ghifile();
            HienThi();
            XoaTextBox(); // Xóa các trường nhập liệu sau khi thêm thành công

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số cho các trường ID, Tuổi, Ngày, Tháng, Năm.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblBenhNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBenhNhanMouseClicked
        // TODO add your handling code here:
        int hang = tblBenhNhan.getSelectedRow();

        // Lấy các giá trị từ dòng được chọn
        int Id = (int) tblBenhNhan.getValueAt(hang, 0);
        String Ten = (String) tblBenhNhan.getValueAt(hang, 1);

        // Tách ngày, tháng, năm
        String[] dateParts = tblBenhNhan.getValueAt(hang, 2).toString().split("/");
        if (dateParts.length == 3) {
            txtDay.setText(dateParts[0]);
            txtMonth.setText(dateParts[1]);
            txtYear.setText(dateParts[2]);
        }

        int Tuoi = (int) tblBenhNhan.getValueAt(hang, 3);
        String Sex = (String) tblBenhNhan.getValueAt(hang, 4); // Giới tính (Nam hoặc Nữ)
        String Phone = (String) tblBenhNhan.getValueAt(hang, 5);
        String Address = (String) tblBenhNhan.getValueAt(hang, 6);
        String Yc = (String) tblBenhNhan.getValueAt(hang, 7);

        // Cập nhật các trường nhập liệu
        txtAddress.setText(Address);
        txtID.setText(String.valueOf(Id));
        txtAge.setText(String.valueOf(Tuoi));
        txtName.setText(Ten);
        txtPhone.setText(Phone);
        txtYeuCau.setText(Yc);

        // Cập nhật RadioButton cho giới tính
        if (Sex.equals("Nam")) {
            rdoMale.setSelected(true);  // Nam
            rdoFemale.setSelected(false);  // Bỏ chọn Nữ
        } else if (Sex.equals("Nữ")) {
            rdoFemale.setSelected(true);  // Nữ
            rdoMale.setSelected(false);  // Bỏ chọn Nam
        }
    }//GEN-LAST:event_tblBenhNhanMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            // TODO add your handling code here:
            int id = Integer.parseInt(txtID.getText());
            String str = "BenhNhan/ThongTin[Id='" + id + "']";
            XPathFactory xf = XPathFactory.newInstance();
            XPath path = xf.newXPath();
            Element benhnhan = (Element) path.evaluate(str, doc, XPathConstants.NODE);
            Node parent = benhnhan.getParentNode();
            parent.removeChild(benhnhan);
            Ghifile();
            HienThi();
            XoaTextBox();
        } catch (XPathExpressionException ex) {
            Logger.getLogger(DangKyKham2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            // Lấy ID từ trường txtID và tìm kiếm thông tin bệnh nhân
            int id = Integer.parseInt(txtID.getText().trim());
            String xPathExpression = "/BenhNhan/ThongTin[Id='" + id + "']";

            // Khởi tạo đối tượng XPath
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();

            // Lấy nút bệnh nhân dựa trên ID
            Element benhNhan = (Element) xPath.evaluate(xPathExpression, doc, XPathConstants.NODE);

            if (benhNhan == null) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy bệnh nhân với ID: " + id, "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Cập nhật các trường thông tin của bệnh nhân
            NodeList children = benhNhan.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                Node currentNode = children.item(i);

                if (currentNode.getNodeName().equals("Ten")) {
                    currentNode.setTextContent(txtName.getText().trim());
                } else if (currentNode.getNodeName().equals("NgayKham")) {
                    currentNode.setTextContent(txtDay.getText().trim() + "/" + txtMonth.getText().trim() + "/" + txtYear.getText().trim());
                } else if (currentNode.getNodeName().equals("Tuoi")) {
                    currentNode.setTextContent(txtAge.getText().trim());
                } else if (currentNode.getNodeName().equals("DiaChi")) {
                    currentNode.setTextContent(txtAddress.getText().trim());
                } else if (currentNode.getNodeName().equals("SoDienThoai")) {
                    currentNode.setTextContent(txtPhone.getText().trim());
                } else if (currentNode.getNodeName().equals("GioiTinh")) {
                    // Sử dụng if-else để kiểm tra tình trạng của radio button
                    if (rdoMale.isSelected()) {
                        currentNode.setTextContent("Nam");
                    } else if (rdoFemale.isSelected()) {
                        currentNode.setTextContent("Nữ");
                    }
                } else if (currentNode.getNodeName().equals("YeuCau")) {
                    currentNode.setTextContent(txtYeuCau.getText().trim());
                }
            }

            // Ghi lại thay đổi vào tệp XML và làm mới hiển thị
            Ghifile();
            HienThi();
            XoaTextBox();

        } catch (XPathExpressionException ex) {
            Logger.getLogger(DangKyKham2.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Lỗi xử lý XPath: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID phải là số.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        GiaoDienChinh giaoDienChinh = new GiaoDienChinh();
        giaoDienChinh.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        // Lấy ID từ ô nhập liệu
        int im = Integer.parseInt(txtSearch.getText()); // Lấy ID tìm kiếm từ ô txtSearch
        try {
            // Khởi tạo bộ phân tích XML
            dbf = DocumentBuilderFactory.newDefaultInstance();
            db = dbf.newDocumentBuilder();
            doc = db.parse(filename);

            // Lấy các danh sách dữ liệu từ XML
            NodeList lId = doc.getElementsByTagName("Id");
            NodeList lTen = doc.getElementsByTagName("Ten");
            NodeList lNgay = doc.getElementsByTagName("NgayKham");
            NodeList lTuoi = doc.getElementsByTagName("Tuoi");
            NodeList lSex = doc.getElementsByTagName("GioiTinh");
            NodeList lDiaChi = doc.getElementsByTagName("DiaChi");
            NodeList lDienThoai = doc.getElementsByTagName("SoDienThoai");
            NodeList lYeuCau = doc.getElementsByTagName("YeuCau");

            ArrayList<BenhNhan> li = new ArrayList<>();

            // Tạo danh sách các đối tượng BenhNhan từ dữ liệu XML
            for (int i = 0; i < lId.getLength(); i++) {
                BenhNhan bn = new BenhNhan();
                bn.setId(Integer.parseInt(lId.item(i).getTextContent()));
                bn.setHoTen(lTen.item(i).getTextContent());
                bn.setNgayKham(lNgay.item(i).getTextContent());
                bn.setTuoi(Integer.parseInt(lTuoi.item(i).getTextContent()));
                bn.setGioiTinh(lSex.item(i).getTextContent());
                bn.setDiaChi(lDiaChi.item(i).getTextContent());
                bn.setDienThoai(lDienThoai.item(i).getTextContent());
                bn.setYeuCau(lYeuCau.item(i).getTextContent());
                li.add(bn);
            }

            // Kiểm tra xem có bệnh nhân nào có ID trùng với giá trị tìm kiếm không
            boolean found = false;
            for (BenhNhan bn : li) {
                if (im == bn.getId()) {
                    // Nếu tìm thấy bệnh nhân có ID trùng, hiển thị thông tin lên bảng
                    DefaultTableModel model = (DefaultTableModel) tblBenhNhan.getModel();
                    model.setRowCount(0); // Xóa dữ liệu cũ trong bảng

                    // Thêm thông tin bệnh nhân vào bảng
                    model.addRow(new Object[]{
                        bn.getId(),
                        bn.getHoTen(),
                        bn.getNgayKham(),
                        bn.getTuoi(),
                        bn.getGioiTinh(),
                        bn.getDiaChi(),
                        bn.getDienThoai(),
                        bn.getYeuCau()
                    });

                    found = true;
                    break;
                }
            }

            // Nếu không tìm thấy bệnh nhân với ID nhập vào, hiển thị thông báo
            if (!found) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy bệnh nhân với ID: " + im, "Kết quả tìm kiếm", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DangKyKham2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DangKyKham2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DangKyKham2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        // TODO add your handling code here:
        try {
            // Khởi tạo bộ phân tích XML
            dbf = DocumentBuilderFactory.newDefaultInstance();
            db = dbf.newDocumentBuilder();
            doc = db.parse(filename);

            // Lấy các danh sách dữ liệu từ XML
            NodeList lId = doc.getElementsByTagName("Id");
            NodeList lTen = doc.getElementsByTagName("Ten");
            NodeList lNgay = doc.getElementsByTagName("NgayKham");
            NodeList lTuoi = doc.getElementsByTagName("Tuoi");
            NodeList lSex = doc.getElementsByTagName("GioiTinh");
            NodeList lDiaChi = doc.getElementsByTagName("DiaChi");
            NodeList lDienThoai = doc.getElementsByTagName("SoDienThoai");
            NodeList lYeuCau = doc.getElementsByTagName("YeuCau");

            // Danh sách bệnh nhân
            ArrayList<BenhNhan> li = new ArrayList<>();

            // Duyệt qua dữ liệu XML và tạo danh sách bệnh nhân
            for (int i = 0; i < lId.getLength(); i++) {
                BenhNhan bn = new BenhNhan();
                bn.setId(Integer.parseInt(lId.item(i).getTextContent()));
                bn.setHoTen(lTen.item(i).getTextContent());
                bn.setNgayKham(lNgay.item(i).getTextContent());
                bn.setTuoi(Integer.parseInt(lTuoi.item(i).getTextContent()));
                bn.setGioiTinh(lSex.item(i).getTextContent());
                bn.setDiaChi(lDiaChi.item(i).getTextContent());
                bn.setDienThoai(lDienThoai.item(i).getTextContent());
                bn.setYeuCau(lYeuCau.item(i).getTextContent());
                li.add(bn);
            }

            // Tính tổng số bệnh nhân
            int totalPatients = li.size();  // Đếm số lượng bệnh nhân trong danh sách

            // Hiển thị kết quả tổng số bệnh nhân
            JOptionPane.showMessageDialog(this, "Tổng số bệnh nhân: " + totalPatients,
                    "Kết quả thống kê", JOptionPane.INFORMATION_MESSAGE);

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DangKyKham2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DangKyKham2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DangKyKham2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        // TODO add your handling code here:
        HienThi();
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void XoaTextBox() {
        txtAddress.setText("");
        txtID.setText("");
        txtAge.setText("");
        txtName.setText("");
        txtPhone.setText("");
        txtYeuCau.setText("");
        txtDay.setText("");
        txtMonth.setText("");
        txtYear.setText("");
        rdoMale.setSelected(false);
        rdoFemale.setSelected(false);
    }

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
            java.util.logging.Logger.getLogger(DangKyKham2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangKyKham2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangKyKham2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangKyKham2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangKyKham2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTable tblBenhNhan;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtDay;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMonth;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtYear;
    private javax.swing.JTextArea txtYeuCau;
    // End of variables declaration//GEN-END:variables
}
