package org.prajval.EntityLayer;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Product 
{	
	@Id
	private int productid;
	private String productname;
	private String producttype;
	private String productcategory;
	private int productprice;
	
	private double discount;
	private double gst;
	private double deliverycharge;
	
	private double FinalPrice;
}
