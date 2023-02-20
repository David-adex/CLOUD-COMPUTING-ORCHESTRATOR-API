 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package Services;
//imported libaries
import java.io.BufferedReader;
import java.io.InputStreamReader;;
import javax.ws.rs.QueryParam;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author david
 */
@Path("getWeather")
public class Weather {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Weather
     */
    public Weather() {
    }

    /**
     * Retrieves representation of an instance of Services.Weather
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("location") String location, @QueryParam("Start") String Start, @QueryParam("end") String end) throws Exception{
        //QueryParam defines the parameters needed to get the weather info in json format  
        //code to get the weather info json from an external rest api 
        URL url = new URL("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" + location +"/"+ Start + "/"+ end + "?unitGroup=uk&include=days&key=68R9B3V8ER9ZEMSC8QZ3A4TCN&contentType=json");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();
// Get the response
BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream()));
String response = in.readLine();
return response;
    }

    /**
     * PUT method for updating or creating an instance of Weather
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
        
    }
}
