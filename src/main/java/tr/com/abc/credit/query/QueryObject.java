package tr.com.abc.credit.query;

public class QueryObject {
    int tckn;
    int krediNumarasi;
    String bankaAdi;
    String krediTuru;
    String dosyaTarihi;

    public QueryObject() { }

    public QueryObject(int tckn, int krediNumarasi, String bankaAdi, String krediTuru, String dosyaTarihi) {
        this.tckn = tckn;
        this.krediNumarasi = krediNumarasi;
        this.bankaAdi = bankaAdi;
        this.krediTuru = krediTuru;
        this.dosyaTarihi = dosyaTarihi;
    }

    public int getTckn() {
        return tckn;
    }

    public void setTckn(int tckn) {
        this.tckn = tckn;
    }

    public int getKrediNumarasi() {
        return krediNumarasi;
    }

    public void setKrediNumarasi(int krediNumarasi) {
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
}
