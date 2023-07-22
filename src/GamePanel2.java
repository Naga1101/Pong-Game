import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel2 extends JPanel implements Runnable{
    
    static final int LARGURA_TELA = 1280;
    static final int ALTURA_TELA = (int)(LARGURA_TELA*(0.5555));
    static final Dimension TAMANHO_JANELA = new Dimension (LARGURA_TELA, ALTURA_TELA);
    static final int DIAMETRO_BOLA = 20;
    static final int LARGURA_COMANDO = 25;
    static final int ALTURA_COMANDO = 150;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Comandos comando1;
    Comandos comando2;
    Bola bola;
    Resultado res; 
    Instrucoes inst;
    boolean jogo = true; 
    boolean start = true;
    boolean recomeca = false;
    boolean voltaMenu = false;
   
    public GamePanel2(){
        novosComandos();
        novaBola(0);
        res = new Resultado(LARGURA_TELA, ALTURA_TELA);
        inst = new Instrucoes(LARGURA_TELA, ALTURA_TELA, 2);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new AL());
        this.setPreferredSize(TAMANHO_JANELA);
            
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void novaBola(int dir){
        bola = new Bola((LARGURA_TELA/2) - (DIAMETRO_BOLA/2), (ALTURA_TELA/2) - (DIAMETRO_BOLA/2), DIAMETRO_BOLA, DIAMETRO_BOLA, dir);      
    }
    
    public void novosComandos(){
        int MEIO_TELA = (ALTURA_TELA/2) - (ALTURA_COMANDO/2);
        comando1 = new Comandos(0, MEIO_TELA, LARGURA_COMANDO, ALTURA_COMANDO, 1);
        comando2 = new Comandos((LARGURA_TELA - LARGURA_COMANDO), MEIO_TELA, LARGURA_COMANDO, ALTURA_COMANDO, 2);    
    }
    
    public void paint(Graphics g){
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g){
        if(start && jogo){
            inst.draw(g);
        }
        if(!jogo){
            inst.drawFim(g, 2);
        }
        comando1.draw(g);
        comando2.draw(g);
        bola.draw(g);
        res.draw(g);
    }
    
    public void move(){
        comando1.move();
        comando2.move();
        bola.move();
    }
    
    public void verificaColisoes(){
        /// impede os jogadores de sairem do ecra
        int FIM_TELA = ALTURA_TELA - ALTURA_COMANDO;
        if(comando1.y <= 0){
            comando1.y = 0;
        }
        if(comando1.y >= FIM_TELA){
            comando1.y = FIM_TELA;
        }
        if(comando2.y <= 0){
            comando2.y = 0;
        }
        if(comando2.y >= FIM_TELA){
            comando2.y = FIM_TELA;
        }
        /// impede a bola de sair da tela
        if(bola.y <= 0){
            bola.setDirecaoY(-bola.velocidadeY);
        }
        if(bola.y >= (ALTURA_TELA - DIAMETRO_BOLA)){
            bola.setDirecaoY(-bola.velocidadeY);
        }
        /// verifica se acertou no jogador
        if(bola.intersects(comando1)){
            bola.velocidadeX = Math.abs(bola.velocidadeX);
            bola.velocidadeX++;
            if(bola.velocidadeY > 0) bola.velocidadeY++;
            else bola.velocidadeY--;
        }
        if(bola.intersects(comando2)){
            bola.velocidadeX = -bola.velocidadeX;
            bola.velocidadeX--;
            if(bola.velocidadeY > 0) bola.velocidadeY++;
            else bola.velocidadeY--;
        }
        /// marca o ponto e recomeça o jogo
        if(bola.x <= 0){
            res.jogador2++;
            novaBola(1);
        }
        if(bola.x >= LARGURA_TELA){
            res.jogador1++;
            novaBola(2);
        }
    }
    
    public void run(){ // loop
        while (start) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        long tempoIni = System.nanoTime();
        double numTicks = 60.0;
        double ns = 1000000000 / numTicks;
        double delta = 0;
        
        /// true pode ser um boolean com um nome qualquer
        while(jogo){
            long now = System.nanoTime();
            delta += (now - tempoIni)/ns;
            tempoIni = now;
            if(delta >= 1){
                move();
                verificaColisoes();
                repaint();
                delta--;
            }
            if(res.jogador1 == 11 && res.jogador2 < 10){
                jogo = false;
                start = true;
                // jogador 1 ganhou
            }
            if(res.jogador2 == 11 && res.jogador1 < 10){
                jogo = false;
                start = true;
                // jogador 2 ganhou
            }
            if(res.jogador1 >= 10 && res.jogador2 >= 10 && res.jogador1 == 2+res.jogador2){
                jogo = false;
                start = true;
                // jogador 1 ganhou
            }
            if(res.jogador1 >= 10 && res.jogador2 >= 10 && res.jogador2 == 2+res.jogador1){
                jogo = false;
                // jogador 2 ganhou
            }
        }
        
        while(!jogo){
            if(recomeca){
                recomecaJogo();
            }
            if(voltaMenu){
                voltarMenu();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void recomecaJogo(){
        res.jogador1 = 0;
        res.jogador2 = 0;
        novaBola(0);
        novosComandos();
        jogo = true;
        recomeca = false;
        run();
    }
    
    public void iniciaJogo(){
        start = !start;
    }
    
    private void voltarMenu() {
        jogo = true;
        recomeca = false;
        GameFrame frame = (GameFrame) SwingUtilities.getWindowAncestor(this);
        MenuPanel menuPanel = new MenuPanel();
        frame.setPanel(menuPanel);
    }
    
    public class AL extends KeyAdapter{  // action listener
        public void keyPressed(KeyEvent e){
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                iniciaJogo();
            }
            if (e.getKeyCode() == KeyEvent.VK_R) {
                if(!jogo){
                    recomeca = true;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                if(!jogo){
                    voltaMenu = true;
                }
            }
            comando1.teclaPrimida(e);
            comando2.teclaPrimida(e);
        }
        
        public void keyReleased(KeyEvent e){
            comando1.teclaLargada(e);
            comando2.teclaLargada(e);
        }
    }
}
