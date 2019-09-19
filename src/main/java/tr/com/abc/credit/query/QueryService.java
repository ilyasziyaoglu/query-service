package tr.com.abc.credit.query;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueryService {

    public String readFileAsString(String fileName)throws Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }



    public void doQuery(QueryObject query){
        if (query.dosyaTarihi == null){ // eger dosya tarihi girildi ise sadece o dosyada ara
        }
        else { // eger dosya tarihi girilmedi ise butun dosyalarda ara
            try {
                String data = readFileAsString("/home/ilyas/Desktop/credits.json");
                JsonArray jsonArray = new JsonParser().parse(data).getAsJsonArray();

                List<JsonElement> jsonElements = new ArrayList(Collections.singleton(jsonArray));
                jsonElements.stream()
                        .filter(obj -> {
                            return obj.getAsJsonObject().get("tckn").getAsLong() == query.tckn || query.tckn == null;
                        })
                        .filter(obj -> {
                            return obj.getAsJsonObject().get("bankaAdi").getAsString() == query.bankaAdi || query.bankaAdi == null;
                        })
                        .filter(obj -> {
                            return obj.getAsJsonObject().get("krediTuru").getAsString() == query.krediTuru || query.krediTuru == null;
                        })
                        .filter(obj -> {
                            return obj.getAsJsonObject().get("krediNumarasi").getAsLong() == query.krediNumarasi || query.krediNumarasi == null;
                        })
                        .forEach(System.out::println);

                /*jsonArray.forEach(obj -> {
                    System.out.println(obj.getAsJsonObject().get("bankaAdi").getAsString());
                });*/

            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }
}
