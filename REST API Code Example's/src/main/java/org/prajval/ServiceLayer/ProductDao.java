package org.prajval.ServiceLayer;

import java.util.List;

import org.prajval.EntityLayer.Product;
import org.prajval.RepositoryLayer.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDao {

	@Autowired
	ProductRepo productRepo;
	
	
	//INSERT
	public Product insert(Product p)
	{
		if(p.getProductcategory().equals("Electronics"))
		{
			p.setDiscount(0.15);
			p.setGst(18);
			p.setDeliverycharge(350);
		} else
			if(p.getProductcategory().equals("Home Appliances"))
			{
				p.setDiscount(0.22);
				p.setGst(24);
				p.setDeliverycharge(800);
			} else
				if(p.getProductcategory().equals("Clothing"))
				{
					p.setDiscount(0.40);
					p.setGst(12);
					p.setDeliverycharge(0);
				} else
					if(p.getProductcategory().equals("Furniture"))
					{
						p.setDiscount(0.10);
						p.setGst(18);
						p.setDeliverycharge(300);
					}
		double Applied_Dicount = p.getDiscount() * p.getProductprice();
		p.setDiscount(Applied_Dicount); //this is calculate the Discount
		
		double GST_Amount = (p.getProductprice() * p.getGst()) / 100;
//		double Total_GSTApply = p.getProductprice() + GST_Amount;
		p.setGst(GST_Amount);// this is calculate the GST

		double finalprice = (p.getProductprice() - p.getDiscount()) + p.getGst();
		p.setFinalPrice(finalprice);// this is calculate the finalprice
		
		return productRepo.save(p);// this will save all record's
	}
	
	
	//this method will return all record's
	public List<Product> getProducts()
	{
		return productRepo.findAll();
	}
	
	//DELETE
	public String DeleteByid(int id) {
		productRepo.deleteById(id);
		return "deleted the id value:"+id; 
	}

	//UPDATE
	public Product update(Product p, int id) {
		Product pp =productRepo.findById(p.getProductid());
        pp.setProductname(p.getProductname());
        pp.setProductprice(p.getProductprice());
        pp.setProducttype(p.getProducttype());
        return productRepo.save(pp);
}
}





