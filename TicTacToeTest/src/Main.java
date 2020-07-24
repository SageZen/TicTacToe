import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Main implements ActionListener {
    static JButton buttons[] = new JButton[9];
    static int round = 0;
    static int turn = 1;
    static boolean gameOn = true;
    static String letter = "";
    static String winner = "";
    static char[] ticArray = new char[9];
    static JLabel label;
    static JLabel label2;
    static JLabel label3;


    Main() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(3,3,1,3));
        panel.setLayout(new GridLayout(4, 3));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setPreferredSize(new Dimension(250, 250));
            buttons[i].addActionListener(this);
            buttons[i].setFont(new Font("Dialog", Font.BOLD, 100));
            panel.add(buttons[i]);
        }

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setTitle("test");
        frame.pack();
        frame.setVisible(true);

        label = new JLabel("Plr");
        label.setFont(new Font("Dialog", Font.BOLD, 100));
        label2 = new JLabel("1's");
        label2.setFont(new Font("Dialog", Font.BOLD, 100));
        label3 = new JLabel("turn");
        label3.setFont(new Font("Dialog", Font.BOLD, 100));

        panel.add(label);
        panel.add(label2);
        panel.add(label3);


    }

    public static void main(String[] args) {
        new Main();
        System.out.println("Hello World!");
    }

    public static char rowWin(char[] array, char test) {
        if ((array[0] == test) && (array[0] == array[1]) && (array[1] == array[2])) {
            return array[0];
        } else if ((array[3] == test) && (array[3] == array[4]) && (array[4] == array[5])) {
            return array[3];
        } else if ((array[6] == test) && (array[6] == array[7]) && (array[7] == array[8])) {
            return array[6];
        } else {
            return 'n';
        }
    }

    public static char columnWin(char[] array, char test) {
        if ((array[0] == test) && (array[0] == array[3]) && (array[3] == array[6])) {
            return array[0];
        } else if ((array[1] == test) && (array[1] == array[4]) && (array[4] == array[7])) {
            return array[1];
        } else if ((array[2] == test) && (array[2] == array[5]) && (array[5] == array[8])) {
            return array[2];
        } else {
            return 'n';
        }
    }

    public static char diagonalWin(char[] array, char test) {
        if ((array[0] == test) && (array[0] == array[4]) && (array[4] == array[8])) {
            return array[0];
        } else if ((array[2] == test) && (array[2] == array[4]) && (array[4] == array[6])) {
            return array[2];
        } else {
            return 'n';
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            if (gameOn == true) {
                if (turn == 1) {
                    letter = "X";
                    if (((JButton) e.getSource()).getText().isEmpty()) {
                        ((JButton) e.getSource()).setText(letter);
                        int test = Arrays.asList(buttons).indexOf(e.getSource());
                        ticArray[test] = 'X';
                        round++;
                        System.out.println(round);
                        turn = 2;
                        label2.setText("2's");
                    }
                    if (rowWin(ticArray, 'X') == ('X') || columnWin(ticArray, 'X') == ('X') || diagonalWin(ticArray, 'X') == ('X')) {
                        System.out.println("Player 1 won");
                        winner = "Player One";
                        JOptionPane.showMessageDialog(null, winner + " has won!");
                        gameOn = false;
                    } else if (round >= 9) {
                        System.out.println("you tied");
                        JOptionPane.showMessageDialog(null, "It is a tie!");
                        gameOn = false;
                    }
                } else if (turn == 2) {
                    letter = "O";
                    if (((JButton) e.getSource()).getText().isEmpty()) {
                        ((JButton) e.getSource()).setText(letter);
                        int test = Arrays.asList(buttons).indexOf(e.getSource());
                        ticArray[test] = 'O';
                        round++;
                        System.out.println(round);
                        turn = 1;
                        label2.setText("1's");
                    }
                    if (rowWin(ticArray, 'O') == ('O') || columnWin(ticArray, 'O') == ('O') || diagonalWin(ticArray, 'O') == ('O')) {
                        System.out.println("Player 2 won");
                        winner = "Player Two";
                        JOptionPane.showMessageDialog(null, winner + " has won!");
                        gameOn = false;
                    } else if (round >= 9) {
                        System.out.println("you tied");
                        JOptionPane.showMessageDialog(null, "It is a tie!");
                        gameOn = false;
                    }
                }
            }
        }
    }

}
