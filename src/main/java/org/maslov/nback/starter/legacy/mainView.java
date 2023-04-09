/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.maslov.nback.starter.legacy;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.sleep;
import java.util.Date;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ButtonUI;


public class mainView extends JFrame {
    private String moveStr;
    Font   moveStrFont;
    private JButton startButton;
    private JButton stopButton;
    private JPanel  moveResultPanel;
    private JLabel moveStrPanel;
    private static int  Height = 500;
    private static int  Width = 400;    
    private NBackGame curGame;
    private Timer gameTimer;
    public void setGreenMoveResultPanel()
    {
        moveResultPanel.setBackground(Color.green);
    }        
    
    public void setRedMoveResultPanel()
    {
        moveResultPanel.setBackground(Color.red);
    }
    
    public final void setGreyMoveResultPanel()
    {
    moveResultPanel.setBackground(Color.gray);
    } 
    private static int panel_height = 200;
    private static int panel_width  = 450; 
    private static int moveStrFontSize  = 450;  
    private static int borderDelay      = 500;
    public mainView() {
        curGame = null;
        gameTimer = null;
        moveStrFont = new Font("Dialog", Font.PLAIN, 100);
        GridBagLayout grbLayout = new GridBagLayout();
        GridBagConstraints cnstr = new GridBagConstraints();
        this.getContentPane().setLayout(grbLayout);
        moveResultPanel = new JPanel();
        startButton = new JButton("Start");
        stopButton  = new JButton("Stop");
        //ButtonUI bUI= startButton.getUI();
        //JRootPane rootPane =this.getRootPane();

        moveStrPanel = new JLabel();
        moveStrPanel.setFont(moveStrFont);
        Dimension btnDim = new Dimension(200, 50);
        startButton.setPreferredSize(btnDim);
        stopButton.setPreferredSize(btnDim);
        //stopButton.setSize(btnDim);
        //stopButton.sets
        Dimension pnlDim = new Dimension(400, 450);
         moveStrPanel.setPreferredSize(pnlDim);
         cnstr.gridx = 0;
         cnstr.gridy = 0;
         cnstr.weightx = 1.0;
         cnstr.weighty = 1.0;
         cnstr.gridwidth = 2;
         cnstr.gridheight = 2;        
         grbLayout.setConstraints(moveStrPanel, cnstr);
 
         
         
         moveResultPanel.setPreferredSize(pnlDim);
         cnstr.gridx = 0;
         cnstr.gridy = 2;
         cnstr.weightx = 1.0;
         cnstr.weighty = 1.0;
         cnstr.gridwidth = 2;
         cnstr.gridheight = 1;        
         grbLayout.setConstraints(moveResultPanel, cnstr);
         
         cnstr.gridx = 0;
         cnstr.gridy = 3;
         cnstr.weightx = 1.0;
         cnstr.weighty = 1.0;
         cnstr.gridwidth = 1;
         cnstr.gridheight = 1;
         grbLayout.setConstraints(startButton, cnstr);
         cnstr.gridx = 1;
         cnstr.gridy = 3;
         cnstr.weightx = 1.0;
         cnstr.weighty = 1.0;
         cnstr.gridwidth = 1;
         cnstr.gridheight = 1;
         grbLayout.setConstraints(stopButton, cnstr);
         this.getContentPane().add(moveStrPanel);
         this.getContentPane().add(startButton);
         this.getContentPane().add(stopButton);
         this.getContentPane().add(moveResultPanel);
         moveStrPanel.setText("Text");
         moveStrPanel.addKeyListener(new spaceKeyHandler());
         moveStrPanel.setFocusable(true);
         this.setGreyMoveResultPanel();
         stopButton.setEnabled(false);
        moveResultPanel.setSize(panel_height, panel_width);
        startButton.addActionListener(new startButtonTsk());         
        stopButton.addActionListener(new stopButtonTsk());
        moveStrPanel.setMaximumSize(pnlDim);
        moveStrPanel.setMinimumSize(pnlDim);
        moveStrPanel.setPreferredSize(pnlDim);
       // moveStrPanel.setBorder(new LineBorder(Color.BLACK));
    }
    
   public String getMoveStr()
   {
        return moveStr;
   }

    public void setMoveStr(String moveStr) {
        this.moveStr = moveStr;
        moveStrPanel.setText(moveStr);
        
    }
    public static void main(String[] args) throws InterruptedException
    {
        //Thread.State st = Thread.currentThread().getState();
        //System.out.println(st);
        mainView mV;
        mV = new mainView();
        mV.setSize(Width, Height);
        mV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mV.setVisible(true);
        Date dt = new Date();
        System.out.println(dt);
    }        
    
 
    class showMoveResultTsk implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
        mainView.this.setGreyMoveResultPanel();
       // long time_in_sec  = System.nanoTime() / 1000000000L;
       // System.out.println("Hide time in sec " + time_in_sec);
        }
    }
    
    class startButtonTsk implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            mainView.this.startButton.setEnabled(false);
            mainView.this.stopButton.setEnabled(true);
            mainView.this.curGame = new NBackGame(2, 10, 3, 0.5);
            NBackGame game = mainView.this.curGame;
            mainView.this.curGame.generateGame();
            System.out.println("START GAME");
            mainView.this.curGame.printGeneratedGame();
            mainView.this.setMoveStr(game.getCurMoveStr());
            mainView.this.moveStrPanel.setBorder(new LineBorder(Color.BLACK));
            Timer tmr = new Timer(borderDelay, new BorderDeleter());
            tmr.setRepeats(false);
            tmr.start();
            mainView.this.moveStrPanel.requestFocus();
            gameTimer = new Timer(game.getMoveTime()* 1000, new gameTimerListener());
            gameTimer.setRepeats(true);
            gameTimer.start();
        }
    }
    class stopButtonTsk implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            mainView.this.stopButton.setEnabled(false);
            mainView.this.startButton.setEnabled(true);
        }
    
    }
    class BorderDeleter implements ActionListener 
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            mainView.this.moveStrPanel.setBorder(null);
        }
    
    }
    
    class gameTimerListener implements ActionListener
    {
        private Timer moveResultTimer;
        private static final int moveResultDelay = 400;
        public gameTimerListener() {
            moveResultTimer = new Timer(moveResultDelay, new  showMoveResultTsk());
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            NBackGame game = mainView.this.curGame;
            System.out.println("Num move " + game.getCurMove());
            if(game.getGameMarkCurMove() == game.getGamerMarkCurMove())
            {
                //mainView.this.setGreenMoveResultPanel();
                game.incrementNum_match();
            }
            else
            {
                //mainView.this.setRedMoveResultPanel();
                game.incrementNum_miss();
            }
            if(game.getGamerMarkCurMove() || game.getGameMarkCurMove())
            {
                if(game.getGameMarkCurMove() == game.getGamerMarkCurMove())
                {
                    mainView.this.setGreenMoveResultPanel();
   
                }
                else
                {
                    mainView.this.setRedMoveResultPanel();
   
                }
                moveResultTimer.setRepeats(false);
                moveResultTimer.setDelay(moveResultDelay);
                moveResultTimer.start();
            }    

            game.incrementMove();
            if(mainView.this.curGame.lastMove())
            {
               // Код завершения игры 
               System.out.println("GAME OVER");
               Timer ref_timer = (Timer)ae.getSource();
               ref_timer.stop();
               System.out.println("Num match" + game.getNum_match());
               System.out.println("Num miss" + game.getNum_miss());
               Telemetry tel= new Telemetry();
               tel.setGame(game);
               tel.setGamerName("Gamer0");
               Thread thr = new Thread(tel);
               thr.start();
               mainView.this.startButton.setEnabled(true);
               
            }
            else
            {
                System.out.println(game.getCurMoveStr());
                mainView.this.setMoveStr(game.getCurMoveStr());
                mainView.this.moveStrPanel.setBorder(new LineBorder(Color.BLACK));
                Timer tmr = new Timer(borderDelay, new BorderDeleter());
                tmr.setRepeats(false);
                tmr.start();
            }    
        }
    
    
    }
    
    
    
    
class spaceKeyHandler implements KeyListener
{
   @Override
    public void keyTyped(KeyEvent ke) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    if(ke.getKeyCode() == KeyEvent.VK_SPACE)
    {
        mainView.this.curGame.serGamerMarkCurMove();
    }
 
  
    }

    @Override
    public void keyReleased(KeyEvent ke) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

}

