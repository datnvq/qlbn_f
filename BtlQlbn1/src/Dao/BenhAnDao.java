package Dao;

import Model.BenhAn;
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

public class BenhAnDao {

    // Biến tĩnh để lưu giá trị Id hiện tại

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            // Tạo bệnh án mới với Id tự động tăng
            BenhAn ba1 = new BenhAn(1,"Ho", "Viêm phổi", "Chụp X-quang", "Viêm phổi nhẹ", "Paracetamol, Kháng sinh");

            Element BenhAn = doc.createElement("BenhAn");
            doc.appendChild(BenhAn);
            writeMedicalRecord(doc, BenhAn, ba1);

            TransformerFactory tff = TransformerFactory.newInstance();
            try {
                Transformer tf = tff.newTransformer();
                tf.setOutputProperty(OutputKeys.INDENT, "yes");
                tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult("src/XML/BenhAn.xml");
                try {
                    tf.transform(source, result);
                    System.out.println("Ghi file thanh cong");
                } catch (TransformerException ex) {
                    Logger.getLogger(BenhAnDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (TransformerConfigurationException ex) {
                Logger.getLogger(BenhAnDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(BenhAnDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static private void writeMedicalRecord(Document doc, Element BenhAn, BenhAn ba) {
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
        BenhAn.appendChild(hoSo);
        hoSo.appendChild(Id);
        hoSo.appendChild(trieuChung);
        hoSo.appendChild(chanDoan);
        hoSo.appendChild(chiDinh);
        hoSo.appendChild(ketLuan);
        hoSo.appendChild(donThuoc);
    }
}
