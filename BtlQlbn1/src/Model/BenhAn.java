package Model;

public class BenhAn {
    private int id;
    
    private String chanDoan;
    private String chiDinh;
    private String ketLuan;
    private String donThuoc;
    private String trieuChung;
    public BenhAn(){
        
    }
    public BenhAn(int id, String trieuChung ,String chanDoan, String chiDinh, String ketLuan, String donThuoc) {
        this.id = id;
        this.chanDoan = chanDoan;
        this.chiDinh = chiDinh;
        this.ketLuan = ketLuan;
        this.donThuoc = donThuoc;
        this.trieuChung = trieuChung;
    }

    public String getTrieuChung() {
        return trieuChung;
    }

    public void setTrieuChung(String trieuChung) {
        this.trieuChung = trieuChung;
    }

    public int getId() {
        return id;
    }

    public String getChanDoan() {
        return chanDoan;
    }

    public String getChiDinh() {
        return chiDinh;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setChanDoan(String chanDoan) {
        this.chanDoan = chanDoan;
    }

    public void setChiDinh(String chiDinh) {
        this.chiDinh = chiDinh;
    }

    public void setKetLuan(String ketLuan) {
        this.ketLuan = ketLuan;
    }

    public void setDonThuoc(String donThuoc) {
        this.donThuoc = donThuoc;
    }

    public String getKetLuan() {
        return ketLuan;
    }

    public String getDonThuoc() {
        return donThuoc;
    }
}
