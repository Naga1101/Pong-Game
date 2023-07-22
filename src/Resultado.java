import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Resultado extends Rectangle{
    
    static int LARGURA_TELA;
    static int ALTURA_TELA;
    int jogador1 = 0;
    int jogador2 = 0;
    
    public Resultado(int LARGURA_TELA, int ALTURA_TELA){
        Resultado.LARGURA_TELA = LARGURA_TELA;
        Resultado.ALTURA_TELA = ALTURA_TELA;
    }
    
    public void draw(Graphics g){
        Color vermelho = new Color(244,54,76);
        Color azul = new Color(85,118,209);
        g.setColor(Color.white);
        g.setFont(new Font("Serif", Font.BOLD, 75));
        g.drawLine(LARGURA_TELA/2, 0, LARGURA_TELA/2, ALTURA_TELA);
        g.setColor(azul);
        g.drawString(String.valueOf(jogador1/10) + String.valueOf(jogador1%10), LARGURA_TELA/4, 60);
        g.setColor(vermelho);
        g.drawString(String.valueOf(jogador2/10) + String.valueOf(jogador2%10), 3*LARGURA_TELA/4, 60);
        
        g.setFont(new Font("Serif", Font.BOLD, 25));
        if(jogador1 == 10 && jogador2 < 10){
            g.setColor(azul);
            g.drawString("Match Point", LARGURA_TELA/4 - 18, 80);
        }
        if(jogador1 >= 10 && jogador2 >= 10 && jogador1 == jogador2+1){
            g.setColor(azul);
            g.drawString("Match Point", LARGURA_TELA/4 - 18, 80);
        }
        if(jogador1 == 11 && jogador2 < 10 || jogador1 >= 10 && jogador2 >= 10 && jogador1 == 2 + jogador2){
            g.setColor(azul);
            g.drawString("Vencedor", LARGURA_TELA/4 - 16, 80);
        }
        if(jogador2 == 10 && jogador1 < 10){
            g.setColor(vermelho);
            g.drawString("Match Point", 3*LARGURA_TELA/4 - 18, 80);
        }
        if(jogador1 >= 10 && jogador2 >= 10 && jogador2 == jogador1+1){
            g.setColor(vermelho);
            g.drawString("Match Point", 3*LARGURA_TELA/4 - 18, 80);
        }
        if(jogador2 == 11 && jogador1 < 10 || jogador1 >= 10 && jogador2 >= 10 && jogador2 == 2 + jogador1){
            g.setColor(vermelho);
            g.drawString("Vencedor", 3*LARGURA_TELA/4 - 16, 80);
        }
    }
}
