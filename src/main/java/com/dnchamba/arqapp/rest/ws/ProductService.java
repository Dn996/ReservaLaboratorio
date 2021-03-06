package com.dnchamba.arqapp.rest.ws;
import com.dnchamba.arqapp.rest.dao.ProductDAO;
import com.dnchamba.arqapp.rest.model.Product;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
/**
 *
 * @author Dayana
 */
@Path("product")
public class ProductService {
    private static ProductDAO productDAO = new ProductDAO();

    public ProductService() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProducts(){
        return productDAO.getProducts();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("id") int id){
        Product output = productDAO.getProduct(id);
        
        if (output != null) {
            return Response.ok(output).build();
            
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(Product product, @Context UriInfo uriInfo){
        Product newProduct = productDAO.addProduct(product);
        
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        
        URI newUri = uriBuilder.path(String.valueOf(newProduct.getIid())).build();
        
        
        
        return Response.created(newUri).entity(newProduct).build();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Product updateProduct(@PathParam("id")int id, Product product){
        product.setIid(id);
        return productDAO.updateProduct(product);
    }
    
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") int id){
        if (productDAO.deleteProduct(id)) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
