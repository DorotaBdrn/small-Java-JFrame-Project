package com.company;

import sun.tools.jps.Jps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {



    public static void main(String[] args) {

        new Main().setVisible(true);
    }

    private Main(){
        super("Dorota");
        setSize(600, 600);//1024x768, 800x600
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JPanel top = new JPanel(new BorderLayout());
        JPanel bottom = new JPanel();


        JButton one = new JButton("one");
        JButton two = new JButton("two");
        JButton button = new JButton("Click me ");
        JButton button1 = new JButton("hello");

        top.add(one, BorderLayout.WEST);
        top.add(two, BorderLayout.EAST);
        bottom.add(button);
        bottom.add(button1);

        button.setActionCommand("click");
        button1.setActionCommand("hello");


        button.addActionListener(this);
        button1.addActionListener(this);

        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem newMemenuItem = new JMenuItem("new");
        JMenuItem edit = new JMenuItem("edit");
        JMenuItem save =  new JMenu("save");
        JMenuItem close = new JMenuItem("Exit");
        close.addActionListener(this);

        JMenuItem extra = new JMenu("Extra");
        JMenuItem hello  = new JMenuItem("Hello");
        JMenuItem hello2 = new JMenuItem("Heloo2");

        extra.add(hello);
        extra.add(hello2);


        file.add(newMemenuItem);
        file.add(save);
        file.add(edit);
        file.add(extra);
        file.addSeparator();
        bar.add(file);
        file.add(close);




        setJMenuBar(bar);





    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if(action.equals("click")){
            System.out.println("Click click");
        }else if( action.equals("hello")){
            System.out.println("Hello Dorota ");
        }else if(action.equals("Exit")){
            System.out.println("Closed");
            System.exit(0);
        }

    }
}
