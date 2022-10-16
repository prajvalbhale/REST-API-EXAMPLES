package org.prajval.RepositoryLayer;

import org.prajval.EntityLayer.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

	
	@Query("select pname from Product pname where pname.productname=?1")
	public Product findByname(String productname);
	
	@Query("select pid from Product pid where pid.productid=?1")
	public Product findById(int productid);

}
