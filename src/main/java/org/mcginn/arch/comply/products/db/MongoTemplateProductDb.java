package org.mcginn.arch.comply.products.db;

import java.util.List;

import org.mcginn.arch.comply.products.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoClient;

public class MongoTemplateProductDb implements ProductDb {

	private MongoTemplate mongoTemplate;
	private final String collectionName;
	
	public MongoTemplateProductDb(MongoClient mongo, String databaseName, String collectionName) {
		this.mongoTemplate = new MongoTemplate(mongo, databaseName);
		this.collectionName = collectionName;
	}

	@Override
	public List<Product> getAllActive(boolean active) {
		return mongoTemplate.find(new Query(Criteria.where("active").is(true)).with(new Sort("name")), Product.class, collectionName);
	}

	@Override
	public void save(Product product) {
		mongoTemplate.save(product, collectionName);
	}
}
