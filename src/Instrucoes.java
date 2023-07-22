import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Instrucoes extends Rectangle{
    
    static int LARGURA_TELA;
    static int ALTURA_TELA;
    private int modo;
    private int chamada = 0;
    
    public Instrucoes(int LARGURA_TELA, int ALTURA_TELA, int modo){
        this.LARGURA_TELA = LARGURA_TELA;
        this.ALTURA_TELA = ALTURA_TELA;
        this.modo = modo;
    }
    
    public void draw(Graphics g){
        chamada++;
        Color vermelho = new Color(244,54,76);
        Color azul = new Color(85,118,209);
        g.setFont(new Font("Serif", Font.BOLD, 69));
        if(modo == 0){
            g.setColor(azul);
            g.drawString("Bot 1: ", LARGURA_TELA/4 - 183, 60);
            g.setColor(vermelho);
            g.drawString("Bot 2: ", 3*LARGURA_TELA/4 - 183, 60);
            g.setColor(Color.white);
            g.setFont(new Font("Serif", Font.BOLD, 25));
            if(chamada <= 1){
                g.drawString("Prima espaço para começar o jogo", LARGURA_TELA/8 - 10, 100);    
            }
        }
        else{
            g.setColor(Color.white);
            g.setFont(new Font("Serif", Font.BOLD, 69));
        
            g.setColor(azul);
            g.drawString("Jogador 1: ", LARGURA_TELA/4 - 315, 60);
                
            if(modo == 1){
                g.setColor(vermelho);
                g.drawString("Bot 1: ", 3*LARGURA_TELA/4 - 183, 60);
                
                g.setColor(Color.white);
                g.setFont(new Font("Serif", Font.BOLD, 25));
                g.drawString("Instruções: ", LARGURA_TELA/8 - 10, 100);
                g.drawString("Jogador 1 anda nas teclas W e S", LARGURA_TELA/8 - 10, 125);
                if(chamada <= 1){
                    g.drawString("Prima espaço para começar o jogo", LARGURA_TELA/8 - 10, 150);    
                }
                else{
                    g.drawString("Prima espaço para remover as instruções", LARGURA_TELA/8 - 10, 150);
                }
            
            }
        
            if(modo == 2){
                g.setColor(vermelho);
                g.drawString("Jogador 2: ", 3*LARGURA_TELA/4 - 315, 60);
                
                g.setColor(Color.white);
                g.setFont(new Font("Serif", Font.BOLD, 25));
                g.drawString("Instruções: ", LARGURA_TELA/8 - 10, 100);
                g.drawString("Jogador 1 anda nas teclas W e S", LARGURA_TELA/8 - 10, 125);
                g.drawString("Jogador 2 anda nas teclas Up e Down", LARGURA_TELA/8 - 10, 150);
                if(chamada <= 1){
                    g.drawString("Prima espaço para começar o jogo", LARGURA_TELA/8 - 10, 175);    
                }
                else{
                    g.drawString("Prima espaço para remover as instruções", LARGURA_TELA/8 - 10, 175);
                }
            }
        }
    }
    
    public void drawFim(Graphics g, int modo){
        g.setColor(Color.white);
        g.setFont(new Font("Serif", Font.BOLD, 25));
        g.drawString("Prima R para recomeçar este modo de jogo", LARGURA_TELA/8 - 10, 100);
        g.drawString("Prima ESC para voltar ao menu", LARGURA_TELA/8 - 10, 125);
        
        Color vermelho = new Color(244,54,76);
        Color azul = new Color(85,118,209);
        g.setFont(new Font("Serif", Font.BOLD, 69));
        if(modo == 0){
            g.setColor(azul);
            g.drawString("Bot 1: ", LARGURA_TELA/4 - 183, 60);
            g.setColor(vermelho);
            g.drawString("Bot 2: ", 3*LARGURA_TELA/4 - 183, 60);
            g.setColor(Color.white);
        }
        else{
            g.setColor(azul);
            g.drawString("Jogador 1: ", LARGURA_TELA/4 - 315, 60);
            if(modo == 1){
                g.setColor(vermelho);
                g.drawString("Bot 1: ", 3*LARGURA_TELA/4 - 183, 60);    
            }
            if(modo == 2){
                g.setColor(vermelho);
                g.drawString("Jogador 2: ", 3*LARGURA_TELA/4 - 315, 60);
            }
        }
    }
}
