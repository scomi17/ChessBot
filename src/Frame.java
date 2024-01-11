import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JPanel implements ActionListener {
    public JFrame frame;
    public int width = 800;
    public int height = 700;
    private final Engine engine = new Engine(width, height, this);
    private final Board board = new Board(width, height, this, engine);
    private JCheckBox two_player;
    private JCheckBox random;
    private JCheckBox greedy;
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
        frame.setTitle("Chess");
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

        two_player = new JCheckBox("2 Player");
        two_player.setSelected(true);
        two_player.setBounds(700, 40, 100, 20);
        two_player.addActionListener(this);
        random = new JCheckBox("Random");
        random.setBounds(700, 60, 100, 20);
        random.addActionListener(this);
        greedy = new JCheckBox("Greedy");
        greedy.setBounds(700, 80, 100,20);
        greedy.addActionListener(this);

        ButtonGroup checkBoxes = new ButtonGroup();
        checkBoxes.add(two_player);
        checkBoxes.add(random);
        checkBoxes.add(greedy);

//        frame.add(fen);
//        frame.add(submit_fen);
        frame.add(board);
        frame.add(engine);
        frame.add(two_player);
        frame.add(random);
        frame.add(greedy);
        frame.setVisible(true);
    }

    public Board get_board() {
        return board;
    }

    public static void main(String[] args) {
        new Frame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == two_player){
            board.setDifficulty(0);
        }
        else if(e.getSource() == random){
            board.setDifficulty(1);
        }
        else if(e.getSource() == greedy){
            board.setDifficulty(2);
        }
    }
}
