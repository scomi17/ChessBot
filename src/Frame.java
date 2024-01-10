import javax.swing.*;
import java.awt.*;

public class Frame extends JPanel {
    public JFrame frame;
    public int width = 800;
    public int height = 700;
    private final Engine engine = new Engine(width, height);
    private final Board board = new Board(width, height, this, engine);
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

//        frame.add(fen);
//        frame.add(submit_fen);
        frame.add(board);
        frame.add(engine);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Frame();

    }
}
