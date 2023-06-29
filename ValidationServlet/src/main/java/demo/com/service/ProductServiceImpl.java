package demo.com.service;

import java.util.List;

import demo.com.beans.Product;
import demo.com.dao.ProductDao;
import demo.com.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {

	private  ProductDao pd;
	
		public ProductServiceImpl() {
		
		pd = new ProductDaoImpl();
	}
		
	@Override
	public List<Product> showAllProduct() {
		return pd.showAll();
	}

}
