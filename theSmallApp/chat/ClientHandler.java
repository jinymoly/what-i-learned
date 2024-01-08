package theSmallApp.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ClientHandler implements Runnable {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private List<ClientHandler> clients;

    public ClientHandler(Socket clientSocket, List<ClientHandler> clients) {
        this.clientSocket = clientSocket;
        this.clients = clients;

        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String userName = in.readLine();
            System.out.println("새로운 사용자 입장 : " + userName);

            for (ClientHandler client : clients) {
                client.sendMessage(userName + " 님이 입장하셨습니다.");
            }

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println(userName + " : " + message);
                for (ClientHandler client : clients) {
                    client.sendMessage(userName + " : " + message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            clients.remove(this);
            try {
                clientSocket.close();
            } catch (IOException e) {
            }
        }
    }

    private void sendMessage(String message) {
        out.println(message);
    }

}
