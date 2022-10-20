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
    private static final int KEYS_SIZE = 56;
    ///text area
    private static JTextArea textArea;
    private static final JButton[] buttons = new JButton[KEYS_SIZE];
    private static final JPanel keyHolder = new JPanel(new BorderLayout(8, 8));
    private static final JPanel innerKeyHolder1 = new JPanel();
    private static final JPanel innerKeyHolder2 = new JPanel();
    private static final JPanel arrowsKeyHolder = new JPanel(new BorderLayout(3, 3));
    private static boolean capsFlag;


    public Keyboard() {
        super("Keyboard");

        ///text area
        textArea = new JTextArea("");
        JScrollPane textPane = new JScrollPane(textArea);
        ///margin
        textPane.setBorder(new EmptyBorder(16, 16, 1, 16));
        ////////////////B/////////////////////
        setLayout(new GridLayout(2, 1, 40, 10));

        add(textPane);
        handleButtons();
        add(keyHolder);

        ////////////////E//////////////////////
        setSize(720, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);  //center
        setVisible(true);
    }

    private void handleButtons() {


        String helper = "~1234567890-+AAqwertyuiop[]Aasdfghjkl;'AzAxcvbnm,./AAAAA";
//        System.out.println(helper.length()); // 56
//              13 14 27 39 40 51 52 53 54 55
        for (int i = 0; i < KEYS_SIZE; i++) {
//            if (helper.charAt(i) == 'A') System.out.print(i+" ");
            buttons[i] = new JButton();

            if (helper.charAt(i) == 'A') {
                if (i == 13) buttons[i].setText("Backspace");
                if (i == 14) buttons[i].setText("CapsLock");
                if (i == 27) buttons[i].setText("Enter");
                if (i == 39) buttons[i].setText("\\");
                if (i == 41) buttons[i].setText("        Shift        ");
                if (i == 51) {
                    buttons[i].setText("                                           ");
                    innerKeyHolder1.add(buttons[i]);
                }
                if (i == 52) {
                    buttons[i].setText("Left");
                    arrowsKeyHolder.add(buttons[i], BorderLayout.WEST);
                }
                if (i == 53) {
                    buttons[i].setText("Up");
                    arrowsKeyHolder.add(buttons[i], BorderLayout.NORTH);
                }
                if (i == 54) {
                    buttons[i].setText("Right");
                    arrowsKeyHolder.add(buttons[i], BorderLayout.EAST);
                }
                if (i == 55) {
                    buttons[i].setText("Down");
                    arrowsKeyHolder.add(buttons[i], BorderLayout.SOUTH);
                }
            } else {
                buttons[i].setText(helper.charAt(i) + "");
            }

            buttons[i].addActionListener(this); ///action listen
            buttons[i].setFocusable(false);

            if (i < 51)
                innerKeyHolder2.add(buttons[i]);

            //handel def color
            buttons[i].setBackground(Color.lightGray);
            buttons[i].setForeground(Color.white);
        }
        keyHolder.add(innerKeyHolder2, BorderLayout.CENTER);
        JPanel helperPanel = new JPanel();
        helperPanel.add(innerKeyHolder1);
        helperPanel.add(arrowsKeyHolder);
        keyHolder.add(helperPanel, BorderLayout.SOUTH);
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
        if (!(e.getSource() instanceof JButton btn)) return;

//        System.out.println(((JButton)e.getSource()).getText());
        String textBtn = btn.getText();

        switch (textBtn) {
            case "Backspace" -> { /// from https://stackoverflow.com/questions/25319104/jtextarea-backspace-and-clear
                try {
                    Document doc = textArea.getDocument();
                    if (doc.getLength() > 0) {
                        doc.remove(doc.getLength() - 1, 1);
                    }
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
//                _textArea.setText(_textArea.getText().replace(_textArea.getSelectedText(),""));
            }
            case "CapsLock" -> {
                capsFlag = !capsFlag;

                if (capsFlag)
                    btn.setBackground(Color.darkGray);
                else
                    btn.setBackground(Color.lightGray);
            }
            case "Enter" -> textArea.append("\n");
            case "        Shift        " -> {
                // TODO: Shift action
            }
            case "                                           " -> textArea.append(" ");
            case "Left" -> {
                // TODO: left action
            }
            case "Up" -> {
                // TODO: up action
            }
            case "Right" -> {
                // TODO: right action
            }
            case "Down" -> {
                // TODO: down action
            }
            default -> {
                if (capsFlag)
                    textArea.append(textBtn.toUpperCase());
                else
                    textArea.append(textBtn);
            }
        }
    }
}
