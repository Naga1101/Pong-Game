import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MenuPanel extends JPanel{
    
    static final int LARGURA_TELA = 1280;
    static final int ALTURA_TELA = (int)(LARGURA_TELA*(0.5555));
    static final Dimension TAMANHO_JANELA = new Dimension (LARGURA_TELA, ALTURA_TELA);
    
    GamePanel0 botPanel;
    GamePanel1 umJogPanel;
    GamePanel2 doisJogPanel;
    JButton botButton;
    JButton umJogButton;
    JButton doisJogButton;
    
    public MenuPanel()
    {
        botPanel = new GamePanel0();
        umJogPanel = new GamePanel1();
        doisJogPanel = new GamePanel2();
        
        doisJogButton = new JButton("2 Jogadores");
        doisJogButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
                iniciaJogo(2);
            }
        }); 
        
        umJogButton = new JButton("1 Jogador");
        umJogButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
                iniciaJogo(1);
            }
        }); 
        
        botButton = new JButton("Duelo de bots");
        botButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
                iniciaJogo(0);
            }
        });
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(botButton);
        buttonPanel.add(umJogButton);
        buttonPanel.add(doisJogButton);

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.CENTER);
        setPreferredSize(TAMANHO_JANELA);
    }

    public void iniciaJogo(int numJog){
        if(numJog == 0){
            GameFrame frame = (GameFrame) SwingUtilities.getWindowAncestor(this);
            umJogPanel.requestFocusInWindow(); 
            frame.setPanel(botPanel);
        }
        if(numJog == 1){
            GameFrame frame = (GameFrame) SwingUtilities.getWindowAncestor(this);
            umJogPanel.requestFocusInWindow(); 
            frame.setPanel(umJogPanel);
        }
        if(numJog == 2){
            GameFrame frame = (GameFrame) SwingUtilities.getWindowAncestor(this);
            doisJogPanel.requestFocusInWindow(); 
            frame.setPanel(doisJogPanel);
        }
    }
}
