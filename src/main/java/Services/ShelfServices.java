package Services;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Business.BusinessShelf;
import dto.ShelfDTO;
import model.Shelf;



@Path("/shelves")
public class ShelfServices {
	BusinessShelf businessShelf = new BusinessShelf();

	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ShelfDTO createShelfServices(Shelf input){
	return businessShelf.createShelf(input);

	}
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ShelfDTO getShelfServices(@PathParam("id")long productId){
		return businessShelf.getShelf(productId);
	}
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteShelfServices(@PathParam("id")long productId){
		businessShelf.deleteShelf(productId);
		return "prateleira apagada";
	}
	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ShelfDTO updateShelfServices(@PathParam("id")long shelfId, Shelf input){
		return businessShelf.updateShelf(input);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public  Collection<ShelfDTO> getAllShelvesServices(){
		return businessShelf.getAll();
	}
	@GET
	@Path("/product/{productId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<ShelfDTO> getAllShelvesWithProductID(@PathParam("productId")long productId, Shelf input){
		return businessShelf.getAllShelvesWithProductID(productId);
	}
}
