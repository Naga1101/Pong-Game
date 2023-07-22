import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Bola extends Rectangle{
    Random random;
    int velocidadeX;
    int velocidadeY;
 
    public Bola(int posX, int posY, int largura, int altura, int dir){
        super(posX, posY, largura, altura);
        random = new Random();
        if(dir == 0){
            int randomDirX = random.nextInt(2);
            if(randomDirX == 0) randomDirX--;
            setDirecaoX(4 * randomDirX);
        }
        if(dir == 1){
            setDirecaoX(-4);
        }
        if(dir == 2){
            setDirecaoX(4);
        }
        int randomDirY = random.nextInt(2);
        if(randomDirY == 0) randomDirY--;
        setDirecaoY(4 * randomDirY);
    }
    
    public void setDirecaoY(int dirY){
        velocidadeY = dirY;
    }
    
    public void setDirecaoX(int dirX){
        velocidadeX = dirX;
    }
    
    public int getDirecaoY(){
        return velocidadeY;
    }
    
    public int getDirecaoX(){
        return velocidadeX;
    }
    
    public void move(){
        x += velocidadeX;
        y += velocidadeY;
    }
    
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x, y, width, height);
    }
}
