package org.mcginn.arch.comply.products.db;

import java.util.List;

import org.mcginn.arch.comply.products.Product;

public interface ProductDb {
	
	public List<Product> getAllActive(boolean active);
	
	public void save(Product product);
}
