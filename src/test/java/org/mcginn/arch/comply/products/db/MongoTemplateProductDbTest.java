package org.mcginn.arch.comply.products.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.UnknownHostException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mcginn.arch.comply.products.Product;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoTemplateProductDbTest {

	private static final String TEST_COLLECTION_NAME = "testProducts";
	
	private static MongoClient mongo;
	private static MongoTemplate mongoTemplate;
	private static MongoTemplateProductDb db;
	
	@BeforeClass
	public static void setupClass() {
		MongoClientURI uri = new MongoClientURI("mongodb://jmcginn:beavis@54.172.87.204/archScoreCards");
		try {
			mongo = new MongoClient(uri);
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
		mongoTemplate = new MongoTemplate(mongo, "archScoreCards");
		db = new MongoTemplateProductDb(mongo, "archScoreCards", TEST_COLLECTION_NAME);
	}
	
	@AfterClass
	public static void teardownClass() {
		mongo.close();
	}
	
	@After
	public void teardown() {
		mongoTemplate.dropCollection(TEST_COLLECTION_NAME);
	}
	
	@Test
	public void testSaveAndGetActiveProducts() {
		db.save(new Product.Builder().name("product1").description("My Product").build());
		List<Product> prods = db.getAllActive(true);
		assertEquals(1, prods.size());
		assertEquals("product1", prods.get(0).getName());
		assertEquals("My Product", prods.get(0).getDescription());
		assertEquals(true, prods.get(0).isActive());
		assertNotNull(prods.get(0).getId());
		assertNotNull(prods.get(0).getCreatedTimestamp());
	}
}
