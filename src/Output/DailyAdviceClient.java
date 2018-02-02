package Output;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceClient {

    String[] adviceList ={"Eat low portion", "buy new jeans", "two words : not good", "Be cool today"};
    public static void main(String[] args) {

        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }

    public void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(4242);

            while (true) {
                Socket sock = serverSocket.accept();

                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        }
        catch (Exception e ) {
            e.printStackTrace();
        }
    }

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }


}
