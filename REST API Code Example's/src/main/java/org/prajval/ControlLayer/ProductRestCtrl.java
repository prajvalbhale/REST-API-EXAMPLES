package org.prajval.ControlLayer;

import java.util.List;

import org.prajval.EntityLayer.Product;
import org.prajval.ServiceLayer.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestCtrl {

	@Autowired
	ProductDao dao;

	/* THIS METHOD WILL ADD ONE RECORD AT A TIME */
	@PostMapping("/Add") 
	public Product insert(@RequestBody Product p) {
		return dao.insert(p);
	}

	/* THIS METHOD WILL GET ALL RECORD'S PRESENT IN DB */
	@GetMapping("/getProducts") 
	public List<Product> getProducts() {
		return dao.getProducts();
	}

	/*THIS METHOD WILL UPDATE THE RECORD*/
	@PutMapping("/update/{id}") 
	public Product update(@RequestBody Product p ,@PathVariable int id) {
		return dao.update(p, id);
	}

	/* THIS METHOD WILL DELETE ONE RECORD AT A TIME */
	@DeleteMapping("/Delete/{id}") 
	public String deleteByid(@PathVariable int id) {
		return dao.DeleteByid(id);
	}
}
