package theSmallApp.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {

    private static final String SERVER_IP = "127.0.0.1";
    private static final int PORT = 7777;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_IP, PORT);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("사용자 이름을 입력하세요: ");
            String userName = reader.readLine();
            out.println(userName);

            Thread messageThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            messageThread.start();

            System.out.println("채팅을 시작합니다. 종료하려면 '/exit' 입력");
            String userInput;
            
            while (true) {
                userInput = reader.readLine();
                if ("/exit".equals(userInput)) {
                    System.out.println("채팅이 종료되었습니다.");
                    break;
                }
                out.println(userInput);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
