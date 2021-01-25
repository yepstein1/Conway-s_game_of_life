import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Oscillater extends JFrame {

    private Oscillater grid;


    Life life = new Life(7);

    public Oscillater() throws InterruptedException {

        if (Panel_drop_down.toad)
            life.toad();
        else if (Panel_drop_down.blinker)
            life.blinker();
        else if (Panel_drop_down.block)
            life.block();

        add(new CellLines(), BorderLayout.CENTER);
        setDefaultCloseOperation(3);
        setSize(500, 500);
        setVisible(true);

    }

    class CellLines extends JPanel {
        private JButton[][] gridButtons = new JButton[life
                .GRID_SIZE][life.GRID_SIZE];


        public CellLines() throws InterruptedException {
            setLayout(new GridLayout(life.GRID_SIZE, life.
                    GRID_SIZE));
            makeGrid();
            life.metaLiveNeighborCount();
            cellsTimeOne();

            Timer timer = new Timer(1000, new
                    ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent
                                                            actionEvent) {
                            life.metaLiveNeighborCount();
                            life.isAliveNextGen();
                            cellsTimeTwo();
                        }

                    });
            timer.start();

        }

        public void cellsTimeOne() {

            changeColorGrid(life.BLINKER_GRID);


        }

        public void cellsTimeTwo() {

            changeColorGrid(life.blinkerGridNextGen);

        }


        public void changeColorGrid(boolean[][] blinkerGridNextGen) {
            for (int i = 0; i < life.GRID_SIZE; i++) {
                for (int in = 0; in < life.GRID_SIZE; in++
                ) {

                    if (blinkerGridNextGen[i][in])
                        gridButtons[i][in].setBackground(Color.black);
                    else
                        gridButtons[i][in].setBackground(
                                Color.white);


                }

            }


        }

        public void makeGrid() {
            for (int i = 0; i < life.GRID_SIZE; i++) {
                for (int in = 0; in < life.GRID_SIZE; in++) {
                    gridButtons[i][in] = new JButton();
                    Font font = new Font("ariel", 15, 15);
                    gridButtons[i][in].setFont(font);
                    gridButtons[i][in].setText(i + "," + in);
                    add(gridButtons[i][in]);
                }
            }
        }

    }
}
