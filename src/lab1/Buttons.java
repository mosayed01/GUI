package lab1;

import javax.swing.*;
import java.awt.*;

public class Buttons extends JFrame {
    private static final JButton btn1 = new JButton("Press Me");
    private static final JButton btn2 = new JButton("Press Me2");

    /**
     * simple example of 2 JButtons in a frame
     * @throws HeadlessException
     *     Thrown when code that is dependent on a keyboard,
     *     display, or mouse is called in an environment that does not support a keyboard,
     *     display, or mouse.
     *     Any code that depends on any of those devices should firstly ensure their availability using the GraphicsEnvironment.
     *     isHeadless() method and throw HeadlessException if the latter returns true.
     */
    public Buttons() throws HeadlessException {
        super("Test"); //title

        ///buttons handel
        handelBtn(btn1);
        handelBtn(btn2);

        ///panel
        JPanel panel = new JPanel();
        panel.add(btn1);
        panel.add(btn2);

        add(panel, BorderLayout.SOUTH);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }

    /**
     * seperated method for handle button
     * @param btn from type JButton
     */
    private void handelBtn(JButton btn) {
        btn.setFocusable(false);
        btn.setSize(40,30);
    }

    /**
     * entry point for run the frame
     */
    public static void main(String[] args) {
        new Buttons();
    }
}
