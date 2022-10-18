package lab2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard extends JFrame implements KeyListener, ActionListener {
    ///text area
    private static JTextArea _textArea;
    private static JScrollPane textPane;
    private static final JButton[] buttons = new JButton[57];
    private static final JPanel keyHolder = new JPanel(new BorderLayout(5, 5));
    private static final JPanel innerKeyHolder1 = new JPanel();
    private static final JPanel innerKeyHolder2 = new JPanel();
    private static boolean capsFlag;


    public Keyboard() {
        super("Keyboard");

        ///text area
        _textArea = new JTextArea("");
        textPane = new JScrollPane(_textArea);
        ///margin
        textPane.setBorder(new EmptyBorder(10, 10, 1, 10));
//        keyHolder.setBorder(new EmptyBorder(1,1,5,1));
        ////////////////B/////////////////////
        setLayout(new GridLayout(2, 1, 40, 10));

        add(textPane);
        handleButtons();
        add(keyHolder);

        ////////////////E//////////////////////
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private void handleButtons() {

//        System.out.println(helper.length()); // 58

        String helper = "~1234567890-+AAqwertyuiop[]|Aasdfghjkl;'AAzxcvbnm,./AAAAA";
//              13 14 28 40 41 53 54 55 56
        for (int i = 0; i < 57; i++) {
//            if (helper.charAt(i) == 'A') System.out.print(i+" ");
            buttons[i] = new JButton();

            if (helper.charAt(i) == 'A') {
                if (i == 13) buttons[i].setText("Backspace");
                if (i == 14) buttons[i].setText("CapsLock");
                if (i == 28) buttons[i].setText("Enter");
                if (i == 40) buttons[i].setText("Shift");
                if (i == 41) buttons[i].setText("/");
                if (i == 52) buttons[i].setText("                                     ");
                if (i == 53) buttons[i].setText("Left");
                if (i == 54) buttons[i].setText("Up");
                if (i == 55) buttons[i].setText("Right");
                if (i == 56) buttons[i].setText("Down");
            } else {
                buttons[i].setText(helper.charAt(i) + "");
            }

            buttons[i].addActionListener(this); ///action listen
            buttons[i].setFocusable(false);

            if (i >= 52)
                innerKeyHolder1.add(buttons[i]);
            else
                innerKeyHolder2.add(buttons[i]);

            //handel def color
            buttons[i].setBackground(Color.lightGray);
            buttons[i].setForeground(Color.white);
        }
        keyHolder.add(innerKeyHolder2, BorderLayout.CENTER);
        keyHolder.add(innerKeyHolder1, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        new Keyboard();
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        System.out.println(((JButton) e.getSource()).getText());

    }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println(((JButton) e.getSource()).getText());

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(e.getSource() instanceof JButton)) return;

//        System.out.println(((JButton)e.getSource()).getText());
        JButton btn = ((JButton) e.getSource());
        String text = btn.getText();

        switch (text) {
            case "Backspace" -> { ///from https://stackoverflow.com/questions/25319104/jtextarea-backspace-and-clear
                try {
                    Document doc = _textArea.getDocument();
                    if (doc.getLength() > 0) {
                        doc.remove(doc.getLength() - 1, 1);
                    }
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            }
            case "CapsLock" -> {
                capsFlag = !capsFlag;

                if (capsFlag) {
                    btn.setBackground(Color.darkGray);
                } else {
                    btn.setBackground(Color.lightGray);
                }
            }
            case "Enter" -> {

            }
            case "Shift" -> {

            }
            case "                                     " -> {

            }
            case "Left" -> {

            }
            case "Up" -> {

            }
            case "Right" -> {

            }
            case "Down" -> {

            }
        }


    }
}
