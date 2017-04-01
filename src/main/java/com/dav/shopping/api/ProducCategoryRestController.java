package com.dav.shopping.api;



import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dav.shopping.entity.ProductCategory;
import com.dav.shopping.service.ProductCategoryService;
import com.dav.shopping.utils.PaginationSet;


@RestController
@RequestMapping("rest/categoryproduct")
public class ProducCategoryRestController {

	private ProductCategoryService productCategoryService;

	@Autowired(required = true)
	@Qualifier(value = "productCategoryService")
	public void setPersonService(ProductCategoryService productCategoryService) {
		this.productCategoryService = productCategoryService;
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET, produces ={MediaType.APPLICATION_JSON_VALUE})
	public List<ProductCategory> getAll() {
		return productCategoryService.getAll();
	}
	
	@RequestMapping(value = "/getall/page", params = { "page", "pageSize" }, method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public PaginationSet<ProductCategory> getAllByPage(@RequestParam(value = "page") int page,
			@RequestParam(value = "pageSize") int pageSize) {

		return productCategoryService.getAllByPage(page, pageSize);
	}

	@RequestMapping(value = "/getall/page", params = { "page", "pageSize",
			"keyword" }, method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public PaginationSet<ProductCategory> searchByKeyword(@RequestParam(value = "page") int page,
			@RequestParam(value = "pageSize") int pageSize, @RequestParam(value = "keyword") String keyword) {

		return productCategoryService.getAllByKeyword(page, pageSize, keyword);
	}
	
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> create(@RequestBody String jsProductCategory) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		ProductCategory productCategory = mapper.readValue(jsProductCategory, ProductCategory.class);
		
		if(productCategory == null){
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		if (productCategory.getId()!=null && productCategoryService.isExist(productCategory)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		Boolean result = productCategoryService.create(productCategory);
		if (result == false) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}


	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT )
	public ResponseEntity<ProductCategory> update(@PathVariable("id") Integer id, 
			@RequestBody String jsProductCategory) {
		
		return null;
	}
}
