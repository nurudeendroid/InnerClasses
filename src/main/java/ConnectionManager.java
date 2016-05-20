/**
 * Created by nurudeenlawal on 5/19/16.
 */
public class ConnectionManager {
    int numberOfConnections;
    int connectionsLimit = 10;
    boolean closed;
    public ManagedConnection addConnection(String newIP,String newProtocol){
        if (numberOfConnections <= connectionsLimit) {
            numberOfConnections ++;
            return new ManagedConnection(newIP,1,newProtocol);
        }else return null;
    }
    public ManagedConnection addConnection(String newIP,int newPort){
        if (numberOfConnections <= connectionsLimit) {
            numberOfConnections ++;
            return new ManagedConnection(newIP,newPort,"HTTP");
        }else return null;
    }
    public ManagedConnection addConnection(String newIp, int newPort,String newProtocol) {
        if (numberOfConnections <= connectionsLimit) {
            numberOfConnections++;
            return new ManagedConnection(newIp, newPort, newProtocol);
        }else return null;
    }
    public ConnectionManager(){
       this.connectionsLimit = 10;
    }
    private class ManagedConnection implements Connection{
        String ip;
        int port;
        String protocol;

    public ManagedConnection(String newIp,int newPort, String newProtocol){
         ip = newIp;
         port = newPort;
         protocol = newProtocol;
    }

        public String getProtocol() {
            if(closed){
                return "Error";
            }
            return protocol;
        }

        public int getPort() {
            if(closed){
                return  0;
            }
            return port;
        }

        public String getIp() {
            if(closed){
                return "Error";
            }
            return ip;
        }

        public String connect() {
            if(closed){
                return "Closed";
            }
            return "Connected";
        }

        public void close() {
            numberOfConnections --;
            closed = true;
        }
    }
}
