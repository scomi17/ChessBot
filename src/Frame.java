import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JPanel implements ActionListener {
    public JFrame frame;
    public JCheckBox twoPlayerBox;
    public JCheckBox easyBotBox;
    public JCheckBox mediumBotBox;
    public int width = 800;
    public int height = 700;
    public int easyBot = 1;
    public int mediumBot = 2;
    private final Engine engine = new Engine(width, height);
    private final Board board = new Board(width, height, this, engine, 0);
    JTextField fen;

    Frame() {
        setLayout(null);
        setFocusable(true);
        requestFocus();

        frame = new JFrame();
        frame.setContentPane(this);
        frame.getContentPane().setPreferredSize(new Dimension(width, height));
        frame.setSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Chess Buddy");
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(0x423D5E));
        Dimension d;

        fen = new JTextField();
        fen.setBounds(
                100, 10, (width - 100) / 2, 20
        );
        fen.setVisible(true);

        JButton submit_fen = new JButton("submit");
        d = submit_fen.getPreferredSize();
        submit_fen.setBounds(fen.getX() + fen.getWidth() + 5, 10, d.width, 20);
        submit_fen.setVisible(true);

        twoPlayerBox = new JCheckBox("2 Player");
        twoPlayerBox.setBounds(700, 40, 100, 20);
        twoPlayerBox.setSelected(true);
        twoPlayerBox.addActionListener(this);
        easyBotBox = new JCheckBox("Easy");
        easyBotBox.setBounds(700, 60, 100, 20);
        easyBotBox.addActionListener(this);
        mediumBotBox = new JCheckBox("Medium");
        mediumBotBox.setBounds(700, 80, 100, 20);
        mediumBotBox.addActionListener(this);

        ButtonGroup checkBoxes = new ButtonGroup();
        checkBoxes.add(twoPlayerBox);
        checkBoxes.add(easyBotBox);
        checkBoxes.add(mediumBotBox);

//        frame.add(submit_fen);
        frame.add(board);
        frame.add(engine);
        frame.add(twoPlayerBox);
        frame.add(easyBotBox);
        frame.add(mediumBotBox);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Frame();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == twoPlayerBox){
            board.setDifficulty(0);
        }
        else if(e.getSource() == easyBotBox){
            board.setDifficulty(1);
        }
        else if(e.getSource() == mediumBotBox){
            board.setDifficulty(2);
        }
    }
}
