import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SimpleSocketClient {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int port = 8080;

        try {

            Socket socket = new Socket(serverAddress, port);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String response = reader.readLine();
            System.out.println("Получен ответ: " + response);

            if ("OK".equals(response)) {
                System.out.println("Сервер ответил 'OK'");
            } else {
                System.out.println("Сервер ответил отличающимся сообщением");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
