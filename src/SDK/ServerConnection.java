package SDK;

import GUI.ScreenFrame;
import Logic.Controller;
import GUI.JoinScreen;

import Model.Game;
import com.google.gson.Gson;
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

    public String post(String json, String path){

        Client c = Client.create();

        WebResource wResource = c.resource(getHost() + ":" + getPort() + "/api/" + path);
        ClientResponse cResponse = wResource.type("application/json").post(ClientResponse.class, json);

        String output = cResponse.getEntity(String.class);
        System.out.println(output);
        if (cResponse != null) {
            return output;
        }

        return "";
    }

    public String delete(String path){

        Client c = Client.create();

        WebResource wResource = c.resource(getHost() + ":" + getPort() + "/api/" + path);
        ClientResponse cResponse = wResource.type("application/json").delete(ClientResponse.class);

        String output = cResponse.getEntity(String.class);
        System.out.println(output);

        return output;

    }

    public String put(String path, String json){

        Client c = Client.create();

        WebResource wResource = c.resource(getHost() + ":" + getPort() + "/api/" + path);
        ClientResponse cResponse = wResource.type("application/json").put(ClientResponse.class, json);

        String output = cResponse.getEntity(String.class);
        System.out.println(output);
        if (cResponse != null) {
            return output;
        }

        return "";


    }

}
