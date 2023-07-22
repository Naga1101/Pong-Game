import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Comandos extends Rectangle{
    int jogador;
    int velocidadeY;
    int velocidade = 15;
    
    public Comandos(int x, int y, int larguraCom, int alturaCom, int jogador){
        super(x, y, larguraCom, alturaCom);
        this.jogador = jogador;
    }
    
    public void teclaPrimida(KeyEvent e){
        switch(jogador){
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W){
                    setDirecaoY(-velocidade);
                    move();
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    setDirecaoY(velocidade);
                    move();
                }
                break;
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    setDirecaoY(-velocidade);
                    move();
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    setDirecaoY(velocidade);
                    move();
                }
                break;
        }
    }
    
    public void teclaLargada(KeyEvent e){
        switch(jogador){
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W){
                    setDirecaoY(0);
                    move();
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    setDirecaoY(0);
                    move();
                }
                break;
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    setDirecaoY(0);
                    move();
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    setDirecaoY(0);
                    move();
                }
                break;
        }
    }
    
    // apenas anda para cima e para baixo
    public void setDirecaoY(int dirY){
        velocidadeY = dirY;
    }
    
    public void move(){
        y = y + velocidadeY;
    }
    
    public void draw(Graphics g){
        if(jogador == 1){
            g.setColor(Color.blue);
        }
        else{
            g.setColor(Color.red);
        }
        
        g.fillRect(x, y , width, height);
    }
}
