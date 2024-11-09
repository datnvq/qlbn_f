/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author ducta
 */
import Model.BenhNhan;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class BenhNhanDao {

    private static int currentId = 1;

    public static void main(String[] args) throws ParseException {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            BenhNhan bn1 = new BenhNhan(currentId++, "Nguyen Van A", 40, "Nam", "123 Nguyen Trai, Ha Noi", "0912356517", "17/10/2004", "Ho khan");

            Element BenhNhan = doc.createElement("BenhNhan");
            doc.appendChild(BenhNhan);
            writeExam(doc, BenhNhan, bn1);
            TransformerFactory tff = TransformerFactory.newInstance();
            try {
                Transformer tf = tff.newTransformer();
                tf.setOutputProperty(OutputKeys.INDENT, "yes");
                tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult("src/XML/BenhNhan.xml");
                try {
                    tf.transform(source, result);
                    System.out.println("Ghi file thanh cong");
                } catch (TransformerException ex) {
                    Logger.getLogger(BenhNhanDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (TransformerConfigurationException ex) {
                Logger.getLogger(BenhNhanDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(BenhNhanDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static private void writeExam(Document doc, Element BenhNhan, BenhNhan bn) {
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
        phone.setTextContent(String.valueOf(bn.getDienThoai()));
        Element yeuCau = doc.createElement("YeuCau");
        yeuCau.setTextContent(bn.getYeuCau());
        Element thongTin = doc.createElement("ThongTin");
        

        thongTin.appendChild(Id);
        thongTin.appendChild(name);
        thongTin.appendChild(ngayKham);
        thongTin.appendChild(age);
        thongTin.appendChild(diachi);
        thongTin.appendChild(phone);
        thongTin.appendChild(gioiTinh);
        thongTin.appendChild(yeuCau);
        BenhNhan.appendChild(thongTin);
    }

}
