import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

/**
 * Created by Mathias on 30-11-2015.
 */
public class ServerConnection {

    private String hostUrl = "http://localhost";
    private int portNumber = 8888;

    public String getHost(){
        return hostUrl;
    }

    public int getPort(){
        return portNumber;
    }

    public String get(String path){

        Client c = Client.create();
        WebResource wResource = c.resource(getHost() + ":" + getPort() + "/api/" + path);
        ClientResponse cResponse = wResource.type("application/json").get(ClientResponse.class);

        String output = cResponse.getEntity(String.class);
        System.out.print(output);

        return output;
    }

}
