package software.ulpgc.kata7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    private JPanel jPanel;
    private JButton jNextcolor;
    private JButton jLastcolor;
    private int colorIndex;

    private Color[] colors = new Color[]{
            new Color(144, 238, 144),
            new Color(173, 216, 230),
            new Color(175, 238, 238),
            new Color(220, 220, 255),
            new Color(240, 188, 220),
            new Color(240, 128, 128),
            new Color(244, 164, 94),
            new Color(240, 230, 140),
            new Color(223, 240, 216),
            new Color(250, 250, 210), Color.black
    };

    public MainFrame(JPanel jPanel) throws HeadlessException{
        this.jPanel = jPanel;
        jNextcolor = new JButton("Next color");
        jLastcolor = new JButton("Last color");

        jNextcolor.addActionListener(e->nextColor(e));
        jLastcolor.addActionListener(e->lastColor(e));

        this.add(jNextcolor, BorderLayout.EAST);
        this.add(jLastcolor, BorderLayout.WEST);

        this.setTitle("Change color");
        this.setSize(750, 300);
        this.add(jPanel, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void lastColor(ActionEvent e) {
        colorIndex = (colorIndex-1)%colors.length;
        listIsNotOutOfRange(colorIndex);
        jPanel.setBackground(colors[colorIndex]);
    }

    private void listIsNotOutOfRange(int newIndex) {
        if (newIndex == -1){colorIndex=colors.length;}
        else if (newIndex == colors.length){colorIndex=0;}
    }

    private void nextColor(ActionEvent e) {
        colorIndex = (colorIndex+1)%colors.length;
        listIsNotOutOfRange(colorIndex);
        jPanel.setBackground(colors[colorIndex]);
    }
}
