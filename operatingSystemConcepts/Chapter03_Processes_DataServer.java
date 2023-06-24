package operatingSystemConcepts;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Chapter03_Processes_DataServer {
    public static void main(String[] args) throws Exception{
        
        @SuppressWarnings("resource")
        ServerSocket server = new ServerSocket(7078);

        /* Now listen for connections */
        while(true){
            System.out.println("Listening...");
            Socket client = server.accept();
            PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
            System.out.println("New client is connected...");

            /* write the Date to the socket */
            pout.println(new java.util.Date().toString());

            /* close the socket and resume */
            /* listening for connections */
            client.close();
        }
    }
}
