/*package com.example.RetailSalesSQL;

import com.example.RetailSalesSQL.model.Sales;
import com.example.RetailSalesSQL.repository.SalesRepository;
import com.example.RetailSalesSQL.service.SalesService;
import com.example.RetailSalesSQL.service.SalesServiceImpl;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.io.*;
import java.util.*;
import org.json.JSONArray;
import org.json.simple.*;
import org.json.simple.parser.*;

class JSONReadFromTheFileTest {
	public JSONArray readJson(int customerId) throws FileNotFoundException {
		try {
			JSONParser parser = new JSONParser();
			Reader reader = new FileReader("src/main/resources/retailSales.json");
			JSONObject jsonObject = (JSONObject) parser.parse(reader);
			JSONArray customers = (JSONArray) jsonObject.get("customerId");
			JSONArray result = new JSONArray();
			for (int i = 0; i < customers.length(); i++) {
				JSONObject element = (JSONObject) customers.get(i);
				if (element.get("customerId").equals(customerId)) {
					result.join(element.toJSONString());
				}
			}
			return result;
		} catch (JSONException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
@SpringBootTest
class RetailSalesSqlApplicationTests {
	@Autowired
	SalesService salesService;
	@Autowired
	SalesRepository salesRepository;

	@Test
	void findTransactionsByCustomerTest() throws FileNotFoundException {
		List<Sales> customer_transactions = salesService.findTransactionsByCustomer(1);
		JSONReadFromTheFileTest jsonFile = new JSONReadFromTheFileTest();
		JSONArray result = jsonFile.readJson(1);

//		assetEquals(customer_transactions, )
	}
}

//	@Test
//	void saveDetailsUnitTest() {
//		SalesServiceImpl salesService = new SalesServiceImpl();
//		Sales new_customer = new Sales(6, "Clothing", 200, 1, 0);
//
//
//	}



*/
