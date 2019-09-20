package tr.com.abc.credit.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileReader;
import java.util.List;

@SpringBootApplication
public class QueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueryApplication.class, args);

		QueryService qs = new QueryService();
		QueryObject queryObject = new QueryObject(null, null, "Isbank", null, null);

		ResponseObject results =  qs.doQuery(queryObject);
		System.out.println(results.toString());
	}

}
