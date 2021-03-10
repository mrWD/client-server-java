import com.itest.Phone;

import java.io.*;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        try (
                ServerSocket server = new ServerSocket(8000);
                Phone phone = new Phone(server);
        ) {
            new Thread(() -> {
                String request = phone.readLine();

                String response = (int) (Math.random() * 30 - 10) + "";

                try {
                    Thread.sleep(4000);

                    phone.writeLine(response);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
