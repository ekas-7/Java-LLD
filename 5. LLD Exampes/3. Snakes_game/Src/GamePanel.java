import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    public static final int TILE_SIZE = 20;
    public static final int COLUMNS = 30;
    public static final int ROWS = 20;
    public static final int WIDTH = TILE_SIZE * COLUMNS;
    public static final int HEIGHT = TILE_SIZE * ROWS;

    private LinkedList<Point> snake;
    private Direction direction = Direction.RIGHT;
    private Point food;
    private Timer timer;
    private boolean running = false;
    private int score = 0;
    private Random rand = new Random();

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        initGame();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (direction != Direction.DOWN) direction = Direction.UP;
                        break;
                    case KeyEvent.VK_DOWN:
                        if (direction != Direction.UP) direction = Direction.DOWN;
                        break;
                    case KeyEvent.VK_LEFT:
                        if (direction != Direction.RIGHT) direction = Direction.LEFT;
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (direction != Direction.LEFT) direction = Direction.RIGHT;
                        break;
                    case KeyEvent.VK_SPACE:
                        if (!running) startGame();
                        break;
                }
            }
        });
    }

    private void initGame() {
        snake = new LinkedList<>();
        snake.add(new Point(COLUMNS/2, ROWS/2));
        snake.add(new Point(COLUMNS/2 - 1, ROWS/2));
        snake.add(new Point(COLUMNS/2 - 2, ROWS/2));
        placeFood();
        timer = new Timer(120, this);
    }

    public void startGame() {
        running = true;
        score = 0;
        direction = Direction.RIGHT;
        timer.start();
    }

    public void stopGame() {
        running = false;
        timer.stop();
    }

    private void placeFood() {
        while (true) {
            int x = rand.nextInt(COLUMNS);
            int y = rand.nextInt(ROWS);
            Point p = new Point(x, y);
            if (!snake.contains(p)) {
                food = p;
                break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkCollision();
            checkFood();
        }
        repaint();
    }

    private void move() {
        Point head = snake.getFirst();
        Point newHead = new Point(head.x, head.y);
        switch (direction) {
            case UP: newHead.y -= 1; break;
            case DOWN: newHead.y += 1; break;
            case LEFT: newHead.x -= 1; break;
            case RIGHT: newHead.x += 1; break;
        }
        snake.addFirst(newHead);
        snake.removeLast();
    }

    private void checkFood() {
        Point head = snake.getFirst();
        if (head.equals(food)) {
            score += 10;
            // grow: add another head copy
            snake.addFirst(new Point(food.x, food.y));
            placeFood();
        }
    }

    private void checkCollision() {
        Point head = snake.getFirst();
        // wall collision
        if (head.x < 0 || head.x >= COLUMNS || head.y < 0 || head.y >= ROWS) {
            stopGame();
            return;
        }
        // self collision
        for (int i = 1; i < snake.size(); i++) {
            if (head.equals(snake.get(i))) {
                stopGame();
                return;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // grid
        g.setColor(Color.DARK_GRAY);
        for (int x = 0; x <= WIDTH; x += TILE_SIZE) {
            g.drawLine(x, 0, x, HEIGHT);
        }
        for (int y = 0; y <= HEIGHT; y += TILE_SIZE) {
            g.drawLine(0, y, WIDTH, y);
        }
        // food
        if (food != null) {
            g.setColor(Color.RED);
            g.fillOval(food.x * TILE_SIZE + 2, food.y * TILE_SIZE + 2, TILE_SIZE - 4, TILE_SIZE - 4);
        }
        // snake
        g.setColor(Color.GREEN);
        for (Point p : snake) {
            g.fillRect(p.x * TILE_SIZE, p.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }
        // score / status
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.BOLD, 14));
        g.drawString("Score: " + score, 10, 16);
        if (!running) {
            g.setFont(new Font("Consolas", Font.BOLD, 32));
            g.drawString("GAME OVER", WIDTH/2 - 100, HEIGHT/2);
            g.setFont(new Font("Consolas", Font.PLAIN, 16));
            g.drawString("Press SPACE to restart", WIDTH/2 - 110, HEIGHT/2 + 30);
        }
    }
}
