package Services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import Business.BusinessProduct;
import dto.ProductDTO;
import model.Product;

@Path("/product")
public class ProductServices {
	BusinessProduct businessProduct = new BusinessProduct();
	ProductDTO productDTO = new ProductDTO();
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ProductDTO createProductServices(Product input) {
		return businessProduct.createProduct(input); 
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProductDTO getProductServices(@PathParam("id") long productId) {
		return businessProduct.getProduct(productId);
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteProductServices(@PathParam("id") long productId) {
		businessProduct.deleteProduct(productId);
		return "produto apagado";
	}

	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ProductDTO updateProductServices(@PathParam("id") long productId, Product input) {
		return businessProduct.updateproduct(input);
	}
}
