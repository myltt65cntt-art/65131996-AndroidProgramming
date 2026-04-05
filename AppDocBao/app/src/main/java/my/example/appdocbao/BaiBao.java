package my.example.appdocbao;
public class BaiBao {
    private String tieuDe;
    private String moTa;
    private String duongDan;

    public BaiBao(String tieuDe, String moTa, String duongDan) {
        this.tieuDe = tieuDe;
        this.moTa = moTa;
        this.duongDan = duongDan;
    }
    public String getTieuDe() {
        return tieuDe;
    }
    public String getMoTa() {
        return moTa;
    }
    public String getDuongDan() {
        return duongDan;
    }
}