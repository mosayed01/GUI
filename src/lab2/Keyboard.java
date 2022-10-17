package lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard extends JFrame implements KeyListener {
    ///text area
    private static JTextArea _text;
    private static JScrollPane text;
    private static final JButton[] buttons = new JButton[57];
    private static final JPanel keyHolder = new JPanel();


    public Keyboard() {
        super("Keyboard");
        _text = new JTextArea("");
        text = new JScrollPane(_text);
        ////////////////B/////////////////////

        add(text, BorderLayout.CENTER);
        handle(buttons);
        add(keyHolder, BorderLayout.SOUTH);

        ////////////////E//////////////////////
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void handle(JButton[] buttons) {

//        System.out.println(helper.length()); // 58

        String helper = "~1234567890-+AAqwertyuiop[]|Aasdfghjkl;'AAzxcvbnm,./ AAAA";
//              13 14 28 40 41 53 54 55 56
        for (int i = 0; i < 57; i++) {
//            if (helper.charAt(i) == 'A') System.out.print(i+" ");
            buttons[i] = new JButton();

            if (helper.charAt(i) == 'A') {
                if (i == 13) buttons[i].setText("backspace");
                if (i == 14) buttons[i].setText("CapsLock");
                if (i == 28) buttons[i].setText("Enter");
                if (i == 40) buttons[i].setText("Shift");
                if (i == 41) buttons[i].setText("/");
                if (i == 53) buttons[i].setText("left");
                if (i == 54) buttons[i].setText("up");
                if (i == 55) buttons[i].setText("right");
                if (i == 56) buttons[i].setText("down");
            } else {
                buttons[i].setText(helper.charAt(i) + "");
            }
            buttons[i].addKeyListener(this);
            buttons[i].setFocusable(false);

            keyHolder.add(buttons[i]);
        }
    }

    public static void main(String[] args) {
        new Keyboard();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
