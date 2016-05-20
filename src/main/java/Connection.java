/**
 * Created by nurudeenlawal on 5/19/16.
 */
public interface Connection {
    String getProtocol();
    int getPort();
    String getIp ();
    String connect();
    void close();
}
