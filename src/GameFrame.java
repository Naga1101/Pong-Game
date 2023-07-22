import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GameFrame extends JFrame{
    
    MenuPanel menuPanel; /// dentro da tela
    GamePanel1 umJogPanel;
    GamePanel2 doisJogPanel;
    
    public GameFrame(){  //////// o que está a volta da tela vom os botões de minimizar etc
        menuPanel = new MenuPanel();
        doisJogPanel = new GamePanel2();
        setPanel(menuPanel);
        
        this.setTitle("Pong");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    public void setPanel(JPanel panel) {
        this.getContentPane().removeAll();
        this.getContentPane().add(panel);
        panel.requestFocusInWindow(); 
        this.revalidate();
        this.repaint();
    }
}
