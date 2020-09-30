package edu.wofford;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JButton.*;


public class GuiMain extends JFrame implements ActionListener {

    private JButton[] button;
    private JLabel label;
    private JTextField textField;
    private TicTacToeModel ticTac;

    public GuiMain() {
        ticTac = new TicTacToeModel();
        setTitle("Tic Tac Toe");
        setLayout(new BorderLayout());
        label = new JLabel("This is a label.");
        add(label);

        // border layout that is whole window

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        label = new JLabel("Result");
        label.setName("result");
        add(label, BorderLayout.NORTH);
        button = new JButton[9];
        for (int i = 0; i < 9; i++) {
            button[i] = new JButton();
            if (i == 0) {
                button[i].setName("location00");
            } else if (i == 1) {
                button[i].setName("location01");
            } else if (i == 2) {
                button[i].setName("location02");
            } else if (i == 3) {
                button[i].setName("location10");
            } else if (i == 4) {
                button[i].setName("location11");
            } else if (i == 5) {
                button[i].setName("location12");
            } else if (i == 6) {
                button[i].setName("location20");
            } else if (i == 7) {
                button[i].setName("location21");
            } else if (i == 8) {
                button[i].setName("location22");
            }
            button[i].addActionListener(this);
            panel.add(button[i]);
        }
        add(panel, BorderLayout.CENTER);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        //setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        //TicTacToeModel ticTac = new TicTacToeModel();
        JButton b = (JButton)event.getSource();
        String name = b.getName();
        //int row = Integer.parseInt(name.substring(name.length() - 2));
        //int col = Integer.parseInt(name.substring(name.length() - 2))
        int row = Integer.parseInt(String.valueOf(name.charAt(name.length() - 2)));
        int col = Integer.parseInt(String.valueOf(name.charAt(name.length() - 1)));
        //label.setText("clicked " + row + " " + col);
        //while(!ticTac.isWinner()) {
        //if (ticTac.playerMove(row, col)) {
        if (!ticTac.isWinner() ) {
            ticTac.playerMove(row, col);
            b.setText(ticTac.getIndexValue(row, col));
        } 
        //}
        if (ticTac.isWinner()) {
            label.setText(ticTac.getResult());
            //frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            //System.exit(0); // stop program
            //dispose(); // close window
            //setVisible(false); // hide window
        }
    }

    
	public static void main(String[] args) {
        GuiMain window = new GuiMain();
        window.setVisible(true);
	}
}