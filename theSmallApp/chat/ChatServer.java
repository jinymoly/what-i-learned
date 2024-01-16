package theSmallApp.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.HashMap;
import java.util.Map;

public class ChatServer {

    private static final int PORT = 7777;
    private static Map<ClientHandler, Boolean> clients = new HashMap<>();
    private static int count = 0;

    private static DateTimeFormatter serverTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("채팅 서버가 시작되었습니다. PORT : " + PORT);
            System.out.println("======== SERVER =======");

            while (true) {
                Socket clientSocket = serverSocket.accept(); // client 연결 대기
                incrementClientCount();
                System.out.println("[server]새로운 사용자" + count + "가 연결되었습니다." + getServerTime());
                broadcastToClient("### 새 접속자가 연결되었습니다.");
                broadcastToClient("[👋]현재 접속 중 사용자 수 : " + count);

                // client 핸들러 생성 및 실행
                ClientHandler clientHandler = new ClientHandler(clientSocket, clients);
                clients.put(clientHandler, true);

                new Thread(clientHandler).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getServerTime() {
        String WithTimeStamp = LocalDateTime.now().format(serverTimeFormatter);
        return "[" + WithTimeStamp + "]";
    }

    public static void broadcastToClient(String message) {
        for (Map.Entry<ClientHandler, Boolean> entry : clients.entrySet()) {
            ClientHandler client = entry.getKey();
            Boolean isOnline = entry.getValue();

            if (isOnline) {
                client.sendMessage(message);
            }
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
