package tr.com.abc.credit.query;

public class QueryObject {
    private Integer tckn;
    private Integer krediNumarasi;
    private String bankaAdi;
    private String krediTuru;
    private String dosyaTarihi;

    public QueryObject() { }

    public QueryObject(Integer tckn, Integer krediNumarasi, String bankaAdi, String krediTuru, String dosyaTarihi) {
        this.tckn = tckn;
        this.krediNumarasi = krediNumarasi;
        this.bankaAdi = bankaAdi;
        this.krediTuru = krediTuru;
        this.dosyaTarihi = dosyaTarihi;
    }

    @Override
    public String toString() {
        return "QueryObject{" +
                "tckn=" + tckn +
                ", krediNumarasi=" + krediNumarasi +
                ", bankaAdi='" + bankaAdi + '\'' +
                ", krediTuru='" + krediTuru + '\'' +
                ", dosyaTarihi='" + dosyaTarihi + '\'' +
                '}';
    }

    public Integer getTckn() {
        return tckn;
    }

    public void setTckn(Integer tckn) {
        this.tckn = tckn;
    }

    public Integer getKrediNumarasi() {
        return krediNumarasi;
    }

    public void setKrediNumarasi(Integer krediNumarasi) {
        this.krediNumarasi = krediNumarasi;
    }

    public String getBankaAdi() {
        return bankaAdi;
    }

    public void setBankaAdi(String bankaAdi) {
        this.bankaAdi = bankaAdi;
    }

    public String getKrediTuru() {
        return krediTuru;
    }

    public void setKrediTuru(String krediTuru) {
        this.krediTuru = krediTuru;
    }

    public String getDosyaTarihi() {
        return dosyaTarihi;
    }

    public void setDosyaTarihi(String dosyaTarihi) {
        this.dosyaTarihi = dosyaTarihi;
    }
}
