/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package Services;
//imported libaries
import java.io.BufferedReader;
import java.io.InputStreamReader;;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author david
 */
@Path("getUserID")
public class UserID {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserID
     */
    public UserID() {
    }

    /**
     * Retrieves representation of an instance of Services.UserID
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getJson()throws Exception{ 
        //code to get a randon munber for the userID from an external rest api
        URL url = new URL("http://www.randomnumberapi.com/api/v1.0/random?min=1000&max=10000");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();
// Get the response
BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
String response = in.readLine();

return response;           
    }

    /**
     * PUT method for updating or creating an instance of UserID
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putJson(String content) {
        
    }
}
