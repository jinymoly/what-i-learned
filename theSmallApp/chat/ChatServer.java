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
                Socket clientSocket = serverSocket.accept(); // client 연결 대기
                incrementClientCount();
                System.out.println("[server]새로운 사용자" + count + "가 연결되었습니다.");
                broadcastToClient("### 새 접속자가 연결되었습니다.");
                broadcastToClient("[b]현재 접속 중 사용자 수 : " + count);

                // client 핸들러 생성 및 실행
                ClientHandler clientHandler = new ClientHandler(clientSocket, clients);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void broadcastToClient(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    public static int getClientCount() {
        return count;
    }

    public static void incrementClientCount() {
        count++;
    }

    public static void decrementClientCount() {
        count--;
    }

}
