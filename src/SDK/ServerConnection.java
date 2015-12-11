package SDK;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

/**
 * Created by Mathias on 30-11-2015.
 */

//Class that contains the methods GET, PUT, POST and DELETE for connecting to the server
//and altering in the database
public class ServerConnection {

    //Declare variables for the url and port number used for connection to the server in each method
    private String hostUrl = "http://localhost";
    private int portNumber = 8888;

    //Creates getter for hostUrl
    public String getHost(){
        return hostUrl;
    }

    //Creates getter for portNumber
    public int getPort(){
        return portNumber;
    }

    //Method that connects to the server and sends a GET-request
    public String get(String path){

        Client c = Client.create();

        WebResource wResource = c.resource(getHost() + ":" + getPort() + "/api/" + path);
        ClientResponse cResponse = wResource.type("application/json").get(ClientResponse.class);

        String output = cResponse.getEntity(String.class);
        System.out.print(output);

        return output;
    }

    //Method that connects to the server and sends a POST-request
    public String post(String json, String path){

        Client c = Client.create();

        WebResource wResource = c.resource(getHost() + ":" + getPort() + "/api/" + path);
        ClientResponse cResponse = wResource.type("application/json").post(ClientResponse.class, json);

        String output = cResponse.getEntity(String.class);
        System.out.println(output);

        return output;
    }

    //Method that connects to the server and sends a DELETE-request
    public String delete(String path){

        Client c = Client.create();

        WebResource wResource = c.resource(getHost() + ":" + getPort() + "/api/" + path);
        ClientResponse cResponse = wResource.type("application/json").delete(ClientResponse.class);

        String output = cResponse.getEntity(String.class);
        System.out.println(output);

        return output;
    }

    //Method that connects to the server and sends a PUT-request
    public String put(String path, String json){

        Client c = Client.create();

        WebResource wResource = c.resource(getHost() + ":" + getPort() + "/api/" + path);
        ClientResponse cResponse = wResource.type("application/json").put(ClientResponse.class, json);

        String output = cResponse.getEntity(String.class);
        System.out.println(output);

        return output;
    }

}
