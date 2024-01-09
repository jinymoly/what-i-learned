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
            sendMessage("현재 접속 중 클라이언트 수 :" + ChatServer.getClientCount());

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println(userName + "님 : " + message);
                for (ClientHandler client : clients) {
                    client.sendMessage(userName + "님 : " + message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            clients.remove(this);
            ChatServer.decrementClientCount();
            sendMessage("현재 접속 중 클라이언트 수 :" + ChatServer.getClientCount());

            try {
                clientSocket.close();
            } catch (IOException e) {
            }
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }

}
