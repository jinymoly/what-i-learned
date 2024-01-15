package theSmallApp.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ClientHandler implements Runnable {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private Map<ClientHandler, Boolean> clients = new HashMap<>();

    public boolean isOnline = true;

    public static final String EXIT_MESSAGE = "/exit";

    public ClientHandler(Socket clientSocket, Map<ClientHandler, Boolean> clients) {
        this.clientSocket = clientSocket;
        this.clients = clients;

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
            String userName = getUserNameWithValidator(
                    new BufferedReader(new InputStreamReader(clientSocket.getInputStream())));
            clients.put(this, true);
            System.out.println("[server]새로운 사용자 입장 : " + userName);
            ChatServer.broadcastToClient("[b]새로운 사용자 입장 : " + userName);
            sendMessage("\n[welcome] 현재 접속 중 사용자 수 : " + ChatServer.getClientCount() + "\n");
            System.out.println("[server]현재 접속 중 사용자 수 : " + ChatServer.getClientCount());

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("[server]" + userName + "님(" + isOnline + ") : "
                        + message + ChatServer.getServerTime());
                ChatServer.broadcastToClient("[bㄴ]" + userName + "님: " + message);

                if (EXIT_MESSAGE.equals(message)) {
                    synchronized (clients) {
                        isOnline = false;
                        ChatServer.broadcastToClient("으아아아아 " + userName);
                        exitNoti(userName);
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            synchronized (clients) {
                Iterator<Map.Entry<ClientHandler, Boolean>> iterator = clients.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<ClientHandler, Boolean> entry = iterator.next();
                    if (entry.getValue() == false) {
                        iterator.remove();
                    }
                }
                ChatServer.decrementClientCount();
                ChatServer.broadcastToClient("[b-]현재 접속 중 사용자 수 :" + ChatServer.getClientCount());
            }

            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getUserNameWithValidator(BufferedReader reader) throws IOException {
        String userName;
        do {
            sendMessage("사용자 이름을 입력하세요. ");
            userName = reader.readLine().trim();
        } while (userName.isEmpty());
        sendMessage(userName + "님, 종료하려면 '" + EXIT_MESSAGE + "' 입력하세요.");
        return userName;
    }

    public static void exitNoti(String userName) {
        String notiText = userName + "님이 나가셨습니다.";
        ChatServer.broadcastToClient(notiText);
    }

    public void sendMessage(String message) {
        out.println(message);
    }

}
