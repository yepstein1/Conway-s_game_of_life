import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Panel_drop_down extends JFrame {

    private JComboBox box;
    private static String[] osc = {"choose item.....", "toad", "blinker", "block"};
    public static boolean toad = false, blinker = false, block = false;

    public Panel_drop_down() {
        super("Conways g£me of life");
        setLayout(new FlowLayout());
        box = new JComboBox(osc);
        box.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(
                            ActionEvent event) {

                        if (box.getSelectedIndex() == 0) return;
                        else if (box.getSelectedIndex() == 1)
                            toad = true;
                        else if (box.getSelectedIndex() ==
                                2) blinker = true;
                        else if (box.getSelectedIndex() ==
                                3)
                            block = true;

                        box.setEnabled(false);


                        try {
                            Oscillater os = new Oscillater();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

        );
        add(box);

        setSize(500, 500);

        setVisible(true);
    }
}


