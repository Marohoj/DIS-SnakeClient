import com.sun.security.ntlm.Client;

/**
 * Created by Mathias on 30-11-2015.
 */
public class ServerConnection {

    private String host;
    private int port;

    public ServerConnection(){

        this.host = "http://localhost";
        this.port = 8888;

    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getHost(){
        return host;
    }

    public void setPortNumber(int portNumber){
        this.port = port;
    }

    public int getPort(){
        return port;
    }

    public String get(String path){

        Client c = Client.create();

    }







}
