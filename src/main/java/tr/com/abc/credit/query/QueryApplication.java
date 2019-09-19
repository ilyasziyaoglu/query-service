package tr.com.abc.credit.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileReader;

@SpringBootApplication
public class QueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueryApplication.class, args);

		QueryService qs = new QueryService();
		QueryObject queryObject = new QueryObject(123, 123, "Isbank", "", "");
		qs.doQuery(queryObject);
	}

}
