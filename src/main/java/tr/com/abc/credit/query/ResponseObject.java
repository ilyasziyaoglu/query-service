package tr.com.abc.credit.query;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.time.LocalDateTime;
import java.util.List;

public class ResponseObject {
    LocalDateTime sorguTarihi;
    String sonuc;
    List<JsonObject> veri;

    public LocalDateTime getSorguTarihi() {
        return sorguTarihi;
    }

    public void setSorguTarihi(LocalDateTime sorguTarihi) {
        this.sorguTarihi = sorguTarihi;
    }

    public String getSonuc() {
        return sonuc;
    }

    public void setSonuc(String sonuc) {
        this.sonuc = sonuc;
    }

    public List<JsonObject> getVeri() {
        return veri;
    }

    public void setVeri(List<JsonObject> veri) {
        this.veri = veri;
    }

    @Override
    public String toString() {
        return "ResponseObject{" +
                "sorguTarihi=" + sorguTarihi +
                ", sonuc='" + sonuc + '\'' +
                ", veri=" + veri +
                '}';
    }
}
