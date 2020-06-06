import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import static javax.swing.GroupLayout.*;

public class MainFrame extends javax.swing.JFrame{
    private final int HEIGHT = 1000, WIDTH = 1000;
    javax.swing.GroupLayout menuPanelLayout;
    JButton newGame;
    JButton highScores;
    JLabel snakeLbl = new JLabel();
    ImageIcon snakeImg = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("snakeDisplay.png")));

    //MENU PANEL
    public JPanel menuPanel = new JPanel(){
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            GradientPaint gradient = new GradientPaint(0, 0, Color.BLACK.brighter().brighter(), 0, getHeight(), Color.WHITE.darker().darker());
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        }
    };

    //CONSTRUCTOR
    public MainFrame(){
        initComponent();

        Image snakeDisplay = snakeImg.getImage().getScaledInstance(230,230, Image.SCALE_SMOOTH);
        snakeLbl.setIcon(new ImageIcon(snakeDisplay));
    }

    private void initComponent(){
        //NEW GAME BUTTON
        {
            newGame = new JButton("NEW GAME");
            newGame.setBackground(Color.gray);
            newGame.setForeground(Color.WHITE.darker());
            newGame.addActionListener(this::newGameClickled);
        }
        //HIGH SCORES BUTTON
        {
            highScores = new JButton("HIGH SCORES");
            highScores.setBackground(Color.gray);
            highScores.setForeground(Color.WHITE.darker());
            highScores.addActionListener(this::highScoreClicked);
        }
        //GROUP LAYOUT
        {
            menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
            menuPanelLayout.setHorizontalGroup(
                    menuPanelLayout.createParallelGroup(Alignment.LEADING)
                            .addGroup(menuPanelLayout.createSequentialGroup()
                                    .addGap(384,384,384)
                                    .addGroup(menuPanelLayout.createParallelGroup(Alignment.LEADING,false)
                                            .addComponent(newGame,PREFERRED_SIZE,230,PREFERRED_SIZE)
                                            .addComponent(snakeLbl, PREFERRED_SIZE,230, PREFERRED_SIZE)
                                            .addComponent(highScores,PREFERRED_SIZE,230,PREFERRED_SIZE)))
            );
            menuPanelLayout.setVerticalGroup(
                    menuPanelLayout.createParallelGroup(Alignment.LEADING)
                            .addGroup(menuPanelLayout.createSequentialGroup()
                                    .addGap(127,127,127)
                                    .addComponent(snakeLbl,PREFERRED_SIZE,230,PREFERRED_SIZE)
                                    .addGap(40,40,40)
                                    .addComponent(newGame,PREFERRED_SIZE,50,PREFERRED_SIZE)
                                    .addGap(40,40,40)
                                    .addComponent(highScores,PREFERRED_SIZE,50,PREFERRED_SIZE))
            );
        }
        //MENU PANEL
        {
            menuPanel.setLayout(menuPanelLayout);
        }
        //MAIN FRAME
        {
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("snkImage.png")));
            setDefaultCloseOperation(3);
            pack();
            setTitle("Snake");
            setSize(WIDTH, HEIGHT);
            setContentPane(menuPanel);
            setResizable(false);
            setLocationRelativeTo(null);
        }
    }

    //ACTION PERFORMED...
    private void newGameClickled(ActionEvent actionEvent) {
        StartingPanel startingPanel = new StartingPanel();
        remove(menuPanel);
        setContentPane(startingPanel.startPanel());
        validate();
    }

    private void highScoreClicked(ActionEvent actionEvent) {
        HighScorePanel highScoresPanel = new HighScorePanel();
        remove(menuPanel);
        setContentPane(highScoresPanel.showHighScores());
        validate();
    }


    //HIGH SCORE PANEL CLASS
    private class HighScorePanel {
        private GroupLayout highScoreLayout;
        JLabel snakeLbl = new JLabel();
        ImageIcon snakeImg = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("snakeDisplay.png")));
        JButton backButton = new JButton("BACK");

        //Top 5 Scores..
        JLabel top1 = new JLabel("Top 1",SwingConstants.CENTER),
                top2 = new JLabel("Top 2",SwingConstants.CENTER),
                top3 = new JLabel("Top 3",SwingConstants.CENTER),
                top4 = new JLabel("Top 4",SwingConstants.CENTER),
                top5 = new JLabel("Top 5",SwingConstants.CENTER);

        JPanel highScorePanel = new JPanel(){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gradient = new GradientPaint(0, 0, Color.BLACK.brighter().brighter(), 0, getHeight(), Color.WHITE.darker().darker());
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
            }
        };

        public void initComponents(){
            //SETTING THE LAYOUT
            {
                highScoreLayout = new GroupLayout(highScorePanel);
                highScoreLayout.setHorizontalGroup(
                        highScoreLayout.createParallelGroup(Alignment.LEADING, false)
                                .addGroup(highScoreLayout.createSequentialGroup()
                                        .addGap(384,384,384)
                                        .addGroup(highScoreLayout.createParallelGroup()
                                                .addComponent(snakeLbl,PREFERRED_SIZE,230,PREFERRED_SIZE)
                                                .addComponent(top1,PREFERRED_SIZE,230,PREFERRED_SIZE)
                                                .addComponent(top2,PREFERRED_SIZE,230,PREFERRED_SIZE)
                                                .addComponent(top3,PREFERRED_SIZE,230,PREFERRED_SIZE)
                                                .addComponent(top4,PREFERRED_SIZE,230,PREFERRED_SIZE)
                                                .addComponent(top5,PREFERRED_SIZE,230,PREFERRED_SIZE)
                                                .addComponent(backButton,PREFERRED_SIZE,230,PREFERRED_SIZE)))

                );
                highScoreLayout.setVerticalGroup(
                        highScoreLayout.createParallelGroup(Alignment.LEADING, false)
                                .addGroup(highScoreLayout.createSequentialGroup()
                                        .addGap(100,100,100)
                                        .addComponent(snakeLbl,PREFERRED_SIZE,230,PREFERRED_SIZE)
                                        .addGap(30,30,30)
                                        .addComponent(top1,PREFERRED_SIZE,DEFAULT_SIZE,PREFERRED_SIZE)
                                        .addGap(30,30,30)
                                        .addComponent(top2,PREFERRED_SIZE,DEFAULT_SIZE,PREFERRED_SIZE)
                                        .addGap(30,30,30)
                                        .addComponent(top3,PREFERRED_SIZE,DEFAULT_SIZE,PREFERRED_SIZE)
                                        .addGap(30,30,30)
                                        .addComponent(top4,PREFERRED_SIZE,DEFAULT_SIZE,PREFERRED_SIZE)
                                        .addGap(30,30,30)
                                        .addComponent(top5,PREFERRED_SIZE,DEFAULT_SIZE,PREFERRED_SIZE)
                                        .addGap(30,30,30)
                                        .addComponent(backButton,PREFERRED_SIZE,50,PREFERRED_SIZE))
                );
            }
            //LABELS
            {
                top1.setForeground(Color.WHITE);
                top2.setForeground(Color.WHITE);
                top3.setForeground(Color.WHITE);
                top4.setForeground(Color.WHITE);
                top5.setForeground(Color.WHITE);
            }
            //BUTTON
            {
                backButton.addActionListener(this::backButton);
                backButton.setForeground(Color.WHITE.darker());
                backButton.setBackground(Color.GRAY);
            }

        }

        private void backButton(ActionEvent actionEvent) {
            remove(highScorePanel);
            setContentPane(menuPanel);
            validate();

        }

        public HighScorePanel(){
            initComponents();
            Image snakeDisplay = snakeImg.getImage().getScaledInstance(230,230, Image.SCALE_SMOOTH);
            snakeLbl.setIcon(new ImageIcon(snakeDisplay));
        }

        public JPanel showHighScores(){
            highScorePanel.setLayout(highScoreLayout);
            return highScorePanel;
        }
    }

    //Starting Panel
    public class StartingPanel{
        private ImageIcon snakeImg = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("snakeDisplay.png")));
        private JLabel snakeLbl = new JLabel();
        private JTextField nameField = new JTextField("");
        private JButton startGameButton = new JButton("START GAME");


        private JPanel startPanel = new JPanel(){
            public void paintComponent(Graphics g){
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, Color.BLACK.brighter().brighter(), 0, getHeight(), Color.WHITE.darker().darker());
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setPaint(gradient);
                g2d.fillRect(0,0,this.getWidth(),this.getHeight());
            }
        };
        private final GroupLayout startPanelLayout = new GroupLayout(startPanel);

        public StartingPanel(){
            Image snakeDisplay = snakeImg.getImage().getScaledInstance(230,230, Image.SCALE_SMOOTH);
            snakeLbl.setIcon(new ImageIcon(snakeDisplay));

            initComponent();
        }

        public void initComponent(){
            //BUTTONS
            {
                startGameButton.addActionListener(this::startClicked);
                startGameButton.setForeground(Color.WHITE.darker());
                startGameButton.setBackground(Color.GRAY);
            }
            //TEXT FIELD
            {
                nameField.setHorizontalAlignment(SwingConstants.CENTER);
            }
            //LAYOUT
            {
                startPanelLayout.setHorizontalGroup(
                        startPanelLayout.createParallelGroup(Alignment.LEADING, false)
                                .addGroup(startPanelLayout.createSequentialGroup()
                                        .addGap(384,384,384)
                                        .addGroup(startPanelLayout.createParallelGroup()
                                                .addComponent(snakeLbl,PREFERRED_SIZE,230,PREFERRED_SIZE)
                                                .addComponent(nameField,PREFERRED_SIZE,230,PREFERRED_SIZE)
                                                .addComponent(startGameButton,PREFERRED_SIZE,230,PREFERRED_SIZE)))
                );
                startPanelLayout.setVerticalGroup(
                        startPanelLayout.createParallelGroup(Alignment.LEADING, false)
                                .addGroup(startPanelLayout.createSequentialGroup()
                                        .addGap(130,130,130)
                                        .addComponent(snakeLbl,PREFERRED_SIZE,230,PREFERRED_SIZE)
                                        .addGap(30,30,30)
                                        .addComponent(nameField,PREFERRED_SIZE,30,PREFERRED_SIZE)
                                        .addGap(30,30,30)
                                        .addComponent(startGameButton,PREFERRED_SIZE,40,PREFERRED_SIZE))
                );
            }
        }

        private void startClicked(ActionEvent actionEvent) {
            if(nameField.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Enter your Game Name");
            }else{
                GamePanel game = new GamePanel(nameField.getText().trim());
                remove(startPanel);
                setContentPane(game);
                validate();
            }
        }

        public JPanel startPanel(){
            startPanel.setLayout(startPanelLayout);

            return startPanel;
        }
    }

    public void startGame(){
        setVisible(true);
    }

    public static void main(String[] args){
        MainFrame main = new MainFrame();
        main.startGame();
    }

    class GamePanel extends JPanel implements Runnable, KeyListener {
        private String gameName;
        private int score = 0;
        private int foodPoints = 100;

        private boolean running;

        private Thread thread;

        private BodyPart b;
        private ArrayList<BodyPart> snake;

        private Food f;
        private ArrayList<Food> food;

        private Random r;

        private int xCoor = 20, yCoor = 20, size = 5;

        private int ticks = 0;

        private boolean right = false, up = false, left = false, down = false;

        public void paint(Graphics g) {
            requestFocus(true);
            //ADDING COLOR TO THE BACKGROUND
            Graphics2D g2d = (Graphics2D) g;
            GradientPaint gradient = new GradientPaint(0, 0, Color.BLACK, 0, this.getHeight(), Color.WHITE);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

            GradientPaint gradient2 = new GradientPaint(0, 0, Color.WHITE, 0, this.getHeight(), Color.BLACK);
            g2d.setPaint(gradient2);

            for (int i = 0; i < this.getWidth() / 20; i++) {
                g.drawLine(0, i * 20, this.getWidth(), i * 20);
            }
            for (int i = 0; i < this.getHeight(); i++) {
                g.drawLine(i * 20, 0, i * 20, this.getHeight());
            }
            for (int i = 0; i < snake.size(); i++) {
                snake.get(i).drawSnake(g);
            }
            for (int i = 0; i < food.size(); i++) {
                food.get(i).putFood(g);
            }

            g2d.setColor(Color.GREEN);
            Font font = g2d.getFont().deriveFont(g2d.getFont().getSize() * 1.5F);
            g2d.setFont(font);
            g2d.drawString(Integer.toString(score), 10, 20);
        }

        public void start() {
            running = true;
            thread = new Thread(this);
            thread.start();
        }

        public void stop() {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void tick() {
            if (snake.size() == 0) {
                b = new BodyPart(xCoor, yCoor, 20);
                snake.add(b);
            }
            ticks++;

            if (ticks > 400000) {
                if (right) xCoor++;
                if (left) xCoor--;
                if (up) yCoor--;
                if (down) yCoor++;

                ticks = 0;

                b = new BodyPart(xCoor, yCoor, 20);
                snake.add(b);

                if (snake.size() > size) {
                    snake.remove(0);
                }
            }
            if (food.size() == 0) {
                int xCoor = r.nextInt(49);
                int yCoor = r.nextInt(49);

                f = new Food(xCoor, yCoor, 20);
                food.add(f);
            }

            for (int i = 0; i < food.size(); i++) {
                if (xCoor == food.get(i).getxCoor() && yCoor == food.get(i).getyCoor()) {
                    size++;
                    score += foodPoints;
                    food.remove(i);
                    i++;
                }
            }

            if (xCoor < 0 || xCoor > 49 || yCoor < 0 || yCoor > 49) {
                int choice = JOptionPane.showConfirmDialog(null, "YOU DIED!\nDo you want to try again?");

                if (choice == 0) {
                    remove(this);
                    setContentPane(menuPanel);
                    validate();
                    stop();
                }
                if (choice == 1){
                    System.exit(0);
                }
            }
        }

        @Override
        public void run() {
            while (running) {
                tick();
                repaint();
            }
        }

        public GamePanel(String name) {
            setFocusable(true);
            addKeyListener(this);

            snake = new ArrayList<BodyPart>();
            food = new ArrayList<Food>();

            r = new Random();

            start();
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == 39 | key == KeyEvent.VK_D && !left) {
                right = true;
                up = false;
                down = false;
            }
            if (key == 37 | key == KeyEvent.VK_A && !right) {
                left = true;
                up = false;
                down = false;
            }
            if (key == 38 | key == KeyEvent.VK_W && !down) {
                up = true;
                left = false;
                right = false;
            }
            if (key == 40 | key == KeyEvent.VK_S && !up) {
                down = true;
                right = false;
                left = false;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }


    }
}