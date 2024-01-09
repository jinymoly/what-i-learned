package theSmallApp.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

    private static final int PORT = 7777;
    private static List<ClientHandler> clients = new ArrayList<>();
    private static int count = 0;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("채팅 서버가 시작되었습니다. PORT : " + PORT);
            System.out.println("======== SERVER =======");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                count++;
                System.out.println("새로운 클라이언트" + count + "가 연결되었습니다.");
                broadcast("현재 접속중인 클라이언트 수 : " + count);

                ClientHandler clientHandler = new ClientHandler(clientSocket, clients);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void broadcast(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    public static int getClientCount() {
        return count;
    }

    public static void decrementClientCount(){
        count--;
    }

}
