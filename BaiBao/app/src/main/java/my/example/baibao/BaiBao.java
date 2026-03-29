package my.example.baibao;

public class BaiBao {
        String tenFileAnh;
        String tieuDe;
        String duongDan;
        String Mota;
    public BaiBao(String tenFileAnh, String tieuDe, String duongDan,String  Mota) {
        this.tenFileAnh = tenFileAnh;
        this.tieuDe = tieuDe;
        this.duongDan = duongDan;
            this.Mota =     Mota;
        }

    public String getTenFileAnh() {
        return tenFileAnh;
    }

    public void setTenFileAnh(String tenFileAnh) {
        this.tenFileAnh = tenFileAnh;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        this.Mota = Mota;
    }

    public String getDuongDan() {
        return duongDan;
    }

    public void setDuongDan(String duongDan) {
        this.duongDan = duongDan;
    }
}