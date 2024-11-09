/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ducta
 */
public class BenhNhan  {

    private int Id;
    private String hoTen;
    private int tuoi;
    private String gioiTinh;
    private String diaChi;
    private String dienThoai;
    private String ngayKham;
    private String yeuCau;
    public BenhNhan() {
    }
    public BenhNhan(int Id, String hoTen, int tuoi, String gioiTinh, String diaChi, String dienThoai, String ngayKham, String yeuCau) {
        this.Id = Id;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.ngayKham = ngayKham;
        this.yeuCau = yeuCau;
    }

    

    public String getYeuCau() {
        return yeuCau;
    }

    public void setYeuCau(String yeuCau) {
        this.yeuCau = yeuCau;
    }


    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;

    }

    public String getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(String ngayKham) { 
        this.ngayKham = ngayKham;
    }

}
