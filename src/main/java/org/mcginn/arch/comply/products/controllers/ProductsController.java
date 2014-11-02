package org.mcginn.arch.comply.products.controllers;

import java.util.List;

import org.mcginn.arch.comply.products.Product;
import org.mcginn.arch.comply.products.db.ProductDb;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsController {

	private ProductDb productDb;
	
	@RequestMapping(method=RequestMethod.GET, produces={"application/json"})
	public List<Product> getAllActiveProducts() {
		return this.productDb.getAllActive(true);
	}

	public void setProductDb(ProductDb productDb) {
		this.productDb = productDb;
	}
}
