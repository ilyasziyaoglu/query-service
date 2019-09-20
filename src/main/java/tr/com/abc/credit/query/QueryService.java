package tr.com.abc.credit.query;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QueryService {

    public String readFileAsString(String fileName)throws Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }



    public ResponseObject doQuery(QueryObject query){

        final List<JsonObject> results = new ArrayList<>();

        // Response objesi olusturma
        ResponseObject responseObject = new ResponseObject();

        // Sorgu tarihini set etme
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        responseObject.setSorguTarihi(LocalDateTime.now());

        if (query.getDosyaTarihi() == null){ // eger dosya tarihi girildi ise sadece o dosyada ara
            try (Stream<Path> paths = Files.walk(Paths.get("/Users/ilyasziyaoglu/Desktop/credits"))) {
                paths
                        .filter(Files::isRegularFile)
                        .forEach(file -> {
                            String fileName = file.getFileName().toString().split("\\.(?=[^\\.]+$)")[0];
                            results.addAll(doQueryFromSingleFile(query, fileName));
                        });
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        else { // eger dosya tarihi girilmedi ise butun dosyalarda ara
             results.addAll(this.doQueryFromSingleFile(query, query.getDosyaTarihi()));
        }

        // Result message
        if(results.size() > 0){
            responseObject.sonuc = "Veri Bulundu";
        }
        else {
            responseObject.sonuc = "Veri Bulunamadi";
        }

        // Sorgu servisini cagirarak sorgu
        responseObject.setVeri(results);

        return responseObject;
    }

    private List<JsonObject> doQueryFromSingleFile (QueryObject query, String date){
        List<JsonObject> results = null;

        try {
            String data = readFileAsString("/Users/ilyasziyaoglu/Desktop/credits/" + date + ".json");
            JsonArray jsonArray = new JsonParser().parse(data).getAsJsonArray();

            List<JsonObject> jsonObjects = new ArrayList<JsonObject>();
            jsonArray.forEach(obj -> {
                jsonObjects.add(obj.getAsJsonObject());
            });

            results = jsonObjects.stream()
                    .filter(obj -> {
                        return query.getTckn() == null || obj.get("tckn").getAsLong() == query.getTckn();
                    })
                    .filter(obj -> {
                        return query.getBankaAdi() == null || obj.get("bankaAdi").getAsString().equals(query.getBankaAdi());
                    })
                    .filter(obj -> {
                        return query.getKrediTuru() == null || obj.get("krediTuru").getAsString().equals(query.getKrediTuru());
                    })
                    .filter(obj -> {
                        return query.getKrediNumarasi() == null || obj.get("krediNumarasi").getAsLong() == query.getKrediNumarasi();
                    })
                    .map(obj -> {
                        obj.addProperty("dosyaTarihi", date);
                        return obj;
                    })
                    .collect(Collectors.toCollection(ArrayList::new));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }
}
