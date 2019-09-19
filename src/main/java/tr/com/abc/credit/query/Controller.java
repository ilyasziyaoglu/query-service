package tr.com.abc.credit.query;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @GetMapping(path = "/")
    public String helloWorld(){
        return "Hello World!";
    }

    @GetMapping(path = "query/tckn={tckn}&bankaAdi={bankaAdi}&krediNumarasi={krediNumarasi}")
    public QueryObject fetchQuery(
            @PathVariable(name = "tckn", required = false) int tckn,
            @PathVariable(name = "bankaAdi", required = false) String bankaAdi,
            @PathVariable(name = "krediTuru", required = false) String krediTuru,
            @PathVariable(name = "dosyaTarihi", required = false) String dosyaTarihi,
            @PathVariable(name = "krediNumarasi", required = false) int krediNumarasi){

        QueryObject queryObject = new QueryObject(tckn, krediNumarasi, bankaAdi, krediTuru, dosyaTarihi);
        System.out.println(queryObject.toString());
        return queryObject;
    }
}
