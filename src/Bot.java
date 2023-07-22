import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Bot extends Rectangle{
    int jogador;
    int velocidadeY;
    int velocidade = 15;
    GamePanel1 gamePanel1;
    GamePanel0 gamePanel0;
    private int bot;
    private int modo;
    private int Com;
    private int MEIO_TELA;
    private boolean botIrMeio = false; 
    
    public Bot(int x, int y, int larguraCom, int alturaCom, GamePanel1 gamePanel){
        super(x, y, larguraCom, alturaCom);
        this.gamePanel1 = gamePanel;
        this.modo = 1;
        this.Com = alturaCom / 2;
        this.MEIO_TELA = gamePanel.ALTURA_TELA / 2 - Com;
    }
    
    public Bot(int x, int y, int larguraCom, int alturaCom, int bot, GamePanel0 gamePanel){
        super(x, y, larguraCom, alturaCom);
        this.gamePanel0 = gamePanel;
        this.modo = 0;
        this.bot = bot;
        this.Com = alturaCom / 2;
        this.MEIO_TELA = gamePanel.ALTURA_TELA / 2 - Com;
    }
    
    // apenas anda para cima e para baixo
    public void setDirecaoY(int dirY){
        velocidadeY = dirY;
    }
    
    public void move(){
        if(modo == 0){
            if(bot == 1){
                int xBola = gamePanel0.bola.getDirecaoX();
                if(xBola > 0 && Com != MEIO_TELA){  // bot bateu na bola
                    botIrMeio = true;
                }
            
                if(botIrMeio){
                    if(y > MEIO_TELA){
                        y -= velocidade;
                        if(y <= MEIO_TELA){
                            y = (int)(MEIO_TELA);
                            botIrMeio = false;
                        }
                    }
                    else{
                        y += velocidade;
                        if(y >= MEIO_TELA){
                            y = (int)(MEIO_TELA);
                            botIrMeio = false;
                        }
                    }
                }
 
                if(xBola < 0){ // têm de acertar na bola
                    botIrMeio = false;
                    int yBola = gamePanel0.bola.getDirecaoY();
                    if(yBola > 0 && y < gamePanel0.bola.y || yBola < 0 && y > gamePanel0.bola.y){
                        y = y + yBola;
                    }
                    if(yBola > 0 && y > gamePanel0.bola.y || yBola < 0 && y < gamePanel0.bola.y){  
                        y = y + yBola;
                    }
                }
            }
            if(bot == 2){
                int xBola = gamePanel0.bola.getDirecaoX();
                if(xBola < 0 && Com != MEIO_TELA){  // bot bateu na bola
                    botIrMeio = true;
                }
            
                if(botIrMeio){
                    if(y > MEIO_TELA){
                        y -= velocidade;
                        if(y <= MEIO_TELA){
                            y = (int)(MEIO_TELA);
                            botIrMeio = false;
                        }
                    }
                    else{
                        y += velocidade;
                        if(y >= MEIO_TELA){
                            y = (int)(MEIO_TELA);
                            botIrMeio = false;
                        }
                    }
                }
 
                if(xBola > 0){ // têm de acertar na bola
                    botIrMeio = false;
                    int yBola = gamePanel0.bola.getDirecaoY();
                    if(yBola > 0 && y < gamePanel0.bola.y || yBola < 0 && y > gamePanel0.bola.y){
                        y = y + yBola;
                    }
                    if(yBola > 0 && y > gamePanel0.bola.y || yBola < 0 && y < gamePanel0.bola.y){  
                        y = y + yBola;
                    }
                }
            }
        }
        if(modo == 1){
            int xBola = gamePanel1.bola.getDirecaoX();
            if(xBola < 0 && Com != MEIO_TELA){  // bot bateu na bola
                botIrMeio = true;
            }
            
            if(botIrMeio){
                if(y > MEIO_TELA){
                    y -= velocidade;
                    if(y <= MEIO_TELA){
                        y = (int)(MEIO_TELA);
                        botIrMeio = false;
                    }
                }
                else{
                    y += velocidade;
                    if(y >= MEIO_TELA){
                        y = (int)(MEIO_TELA);
                        botIrMeio = false;
                    }
                }
            }
 
            if(xBola > 0){ // têm de acertar na bola
                botIrMeio = false;
                int yBola = gamePanel1.bola.getDirecaoY();
                if(yBola > 0 && y < gamePanel1.bola.y || yBola < 0 && y > gamePanel1.bola.y){
                    y = y + yBola;
                }
                if(yBola > 0 && y > gamePanel1.bola.y || yBola < 0 && y < gamePanel1.bola.y){  
                    y = y + yBola;
                }
            }
        }
    }
    
    public void draw(Graphics g){
        if(modo == 0){
            if(bot == 1){
                g.setColor(Color.blue);
            }
            else{
                g.setColor(Color.red);
            }
        }
        if(modo == 1 || modo == 2){
            g.setColor(Color.red);
        }
        
        g.fillRect(x, y , width, height);
    }
}
