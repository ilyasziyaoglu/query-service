package tr.com.abc.credit.query;

import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping(path = "/query")
    public String fetchQuery(
            @RequestParam(name = "tckn", required = false) Integer tckn,
            @RequestParam(name = "bankaAdi", required = false) String bankaAdi,
            @RequestParam(name = "krediTuru", required = false) String krediTuru,
            @RequestParam(name = "dosyaTarihi", required = false) String dosyaTarihi,
            @RequestParam(name = "krediNumarasi", required = false) Integer krediNumarasi){

        // Sorgu objeso tanimlama
        QueryObject queryObject = new QueryObject(tckn, krediNumarasi, bankaAdi, krediTuru, dosyaTarihi);

        return new QueryService().doQuery(queryObject).toString();
    }
}
