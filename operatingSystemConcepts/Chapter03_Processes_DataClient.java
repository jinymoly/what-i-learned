package operatingSystemConcepts;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Chapter03_Processes_DataClient {
    
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1", 7078);

        InputStream in = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        /* read date from the socket */
        String line = null;
        while((line = br.readLine()) != null)
            System.out.println(line);

        /* close the socket connections */
        socket.close();
    }
}
