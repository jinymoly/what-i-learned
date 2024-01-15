package theSmallApp.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collections;
import java.util.List;

public class ClientHandler implements Runnable {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private List<ClientHandler> clients;

    public boolean isOnline = false;

    public static final String EXIT_MESSAGE = "/exit";

    public ClientHandler(Socket clientSocket, List<ClientHandler> clients) {
        this.clientSocket = clientSocket;
        this.clients = Collections.synchronizedList(clients);

        try {
            // 클라이언트와의 입력스트림
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
            System.out.println("[server]새로운 사용자 입장 : " + userName);
            ChatServer.broadcastToClient("[b]새로운 사용자 입장 : " + userName);
            isOnline = true;
            sendMessage("\n[welcome] 현재 접속 중 사용자 수 : " + ChatServer.getClientCount() + "\n");
            System.out.println("[server]현재 접속 중 사용자 수 : " + ChatServer.getClientCount());

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("[server]" + userName + "님(" + isOnline + ") : " 
                                    + message + ChatServer.getServerTime());
                ChatServer.broadcastToClient("[b]" + userName + "님: " + message);

                if (EXIT_MESSAGE.equals(message)) {
                    isOnline = false;
                    System.out.println("[server]" + userName + "님(" + isOnline+")" + ChatServer.getServerTime());
                    ChatServer.broadcastToClient(userName + "님[b]이 나가셨습니다.");
                    System.out.println("[server]" + userName + "님 퇴장 " + ChatServer.getServerTime());

                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            synchronized (clients) {
                clients.remove(this);
            }
            ChatServer.decrementClientCount();
            ChatServer.broadcastToClient("[b]현재 접속 중 사용자 수 :" + ChatServer.getClientCount());

            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }

}
