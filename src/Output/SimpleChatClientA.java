package Output;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Externalizable;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleChatClientA {
    JTextField outgoing;
    PrintWriter writer;
    Socket sock;

    public void go() {
        JFrame frame = new JFrame("Simple Chat Client");
        JPanel panel = new JPanel();
        outgoing= new JTextField(20);
        JButton buttonSend = new JButton("Send");
        buttonSend.addActionListener(new SendButtonListner());
        panel.add(outgoing);
        panel.add(buttonSend);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        setUpNetworking();
        frame.setSize(400,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

    }

    public void setUpNetworking() {
        try {
            sock = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("networking established");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class SendButtonListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                writer.println(outgoing.getText());
                writer.flush();
            }
            catch (Exception e1) {
                e1.printStackTrace();
            }

            outgoing.setText("");
            outgoing.requestFocus();
        }
    }
    public static void main(String[] args) {
        new SimpleChatClientA().go();
    }
}
