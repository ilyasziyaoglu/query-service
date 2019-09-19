package tr.com.abc.credit.query;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @GetMapping(path = "query/tckn={tckn}&bankaAdi={bankaAdi}&krediTutari={krediTutari}&dosyaTarihi={dosyaTarihi}&krediNumarasi={krediNumarasi}")
    public QueryObject fetchQuery(
            @PathVariable(name = "tckn", required = false) Integer tckn,
            @PathVariable(name = "bankaAdi", required = false) String bankaAdi,
            @PathVariable(name = "krediTuru", required = false) String krediTuru,
            @PathVariable(name = "dosyaTarihi", required = false) String dosyaTarihi,
            @PathVariable(name = "krediNumarasi", required = false) Integer krediNumarasi){

        QueryObject queryObject = new QueryObject(tckn, krediNumarasi, bankaAdi, krediTuru, dosyaTarihi);
        return queryObject;
    }
}
