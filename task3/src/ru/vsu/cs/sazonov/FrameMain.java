package ru.vsu.cs.sazonov;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class FrameMain extends JFrame {
    private JTextArea player1;
    private JTextArea player2;
    private JButton buttonNext;
    private JButton buttonStart;
    private JPanel panelMain;
    private JCheckBox check;
    private SimpleLinkedListQueue simpleQueue1;
    private SimpleLinkedListQueue simpleQueue2;
    private Queue queue1;
    private Queue queue2;
    public FrameMain() {
        this.setTitle("Пьяница");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if(check.isSelected()){
                    Task.nextSimpleQueue(simpleQueue1, simpleQueue2);
                    player1.setText(simpleQueue1.toString());
                    player2.setText(simpleQueue2.toString());}
                    else {
                        Task.nextQueue(queue1,queue2);
                        player1.setText(String.valueOf(queue1));
                        player2.setText(String.valueOf(queue2));
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if(check.isSelected()){
                    simpleQueue1 =new SimpleLinkedListQueue();
                    simpleQueue2 =new SimpleLinkedListQueue();
                    Task.startSimpleQueue(simpleQueue1, simpleQueue2);
                    player1.setText(simpleQueue1.toString());
                    player2.setText(simpleQueue2.toString());}
                    else {
                        queue1=new LinkedList();
                        queue2=new LinkedList();
                        Task.startQueue(queue1,queue2);
                        player1.setText(String.valueOf(queue1));
                        player2.setText(String.valueOf(queue2));
                    }

                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }

}
