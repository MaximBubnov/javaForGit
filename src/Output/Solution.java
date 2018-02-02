package Output;

import com.sun.deploy.panel.GeneralPanel;
import com.sun.prism.Graphics;
import org.omg.CORBA.MARSHAL;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.*;
import java.sql.Connection;

class MiniMusicPlayer3 implements ActionListener{

    JTextArea textArea;
    JCheckBox checkBox;
    JList list;

    public static void main(String[] args) {

        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go();
    }

    public void go() {

        JFrame frame = new JFrame("Example");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);

        JPanel panel = new JPanel();
        JButton button = new JButton("Just click it");

        button.addActionListener(this);

        textArea = new JTextArea(10, 20);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        panel.add(scrollPane);

        checkBox = new JCheckBox("Goes to 11");
        checkBox.addItemListener(this::itemStateChanged);

        String[] listEnter = {"max", "anna", "dima", "lena", "vini",
                "max", "anna", "dima", "lena", "vini"};
        list = new JList(listEnter);

        JScrollPane scrollPane1 = new JScrollPane(list);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        list.addListSelectionListener(this::valueChanger);
        JPanel panel1 = new JPanel();
        panel1.add(scrollPane1);

        list.setVisibleRowCount(4);


        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.WEST, checkBox);
        frame.getContentPane().add(BorderLayout.EAST, panel1);

        frame.setVisible(true);

    }

    public void itemStateChanged(ItemEvent ev) {
        String onOrOff = "off";
        if(checkBox.isSelected()) onOrOff = "on";
        textArea.append("Checkbox is : " + onOrOff + "\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textArea.append("button clicked \n");
    }

    public void valueChanger(ListSelectionEvent lse) {
        if(!lse.getValueIsAdjusting()) {
            String selection = (String) list.getSelectedValue();
            textArea.append(selection + "\n");
        }
    }
}







