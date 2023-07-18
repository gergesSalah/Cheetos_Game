package chester;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class frame extends JFrame implements ActionListener{
    
    JFrame Fram = new JFrame();
    boolean player1_turn;
    boolean player2_turn;
    boolean player3_turn;
    boolean player4_turn;
    int num_of_player;
    Random random = new Random();
    int whereGame;
    
    JPanel panelTitle = new JPanel();
    JLabel textField = new JLabel();
    
    JPanel button_panel = new JPanel();
    JButton buttons[][] = new JButton[5][5];
    
    JButton replay = new JButton();
    JPanel replayPanel = new JPanel();
    
    frame(){
        Fram.setSize(800, 800);
        Fram.setVisible(true);
        Fram.setLocation(350, 20);
        Fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Fram.setLayout(new BorderLayout());
        Fram.getContentPane().setBackground(new Color(50,50,50));
        
        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink free",Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("CHESTER");
        textField.setOpaque(true);
        
        panelTitle.setLayout(new BorderLayout());
        panelTitle.setBounds(0,0,800,100);
        
        panelTitle.add(textField);
        Fram.add(panelTitle,BorderLayout.NORTH);
        
        
        button_panel.setLayout(new GridLayout(5,5));
        button_panel.setBackground(new Color(150,150,150));
        
        for (int i = 0; i < 5; i++){
            for(int j = 0;j<5;j++){
                buttons[i][j] = new JButton();
                button_panel.add(buttons[i][j]);
                buttons[i][j].setFont(new Font("MV Boli",Font.BOLD,120));
                buttons[i][j].setFocusable(false);
                buttons[i][j].addActionListener(this);
                buttons[i][j].setBackground(new Color(200,240,200));
            }
        }
        
        Fram.add(button_panel);
        
        replay.setBackground(new Color(50,70,50));
        replay.setForeground(new Color(25,255,0));
        replay.setFont(new Font("Ink free",Font.BOLD,75));
        replay.setHorizontalAlignment(JLabel.CENTER);
        replay.setText("replay");
        replay.setOpaque(true);
        replay.addActionListener(this);
        
        replayPanel.setLayout(new BorderLayout());
        replayPanel.setBounds(0,0,800,100);
        
        replayPanel.add(replay,BorderLayout.CENTER);
        Fram.add(replayPanel,BorderLayout.SOUTH);
        
        determineNUMplayers();
        firstTurn();
        
        
        //Fram.add(buttonPanel);
        //Fram.add(replayPanel);

//        
//        button_panel.setLayout(new GridLayout(3,3));
//        button_panel.setBackground(new Color(150,150,150));
        
//        for (int i = 0; i < 9; i++) {
//            buttons[i] = new JButton();
//            button_panel.add(buttons[i]);
//            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
//            buttons[i].setFocusable(false);
//            buttons[i].addActionListener(this);
//            buttons[i].setBackground(new Color(180,200,180));
//        }
//        
        
//        frame.add(button_panel);
//        
//        firstTurn();
    }
    
    public void determineNUMplayers(){
        num_of_player = Integer.valueOf(JOptionPane.showInputDialog("enter the number of players"));
        while(num_of_player <2||num_of_player>4){
           JOptionPane.showMessageDialog(null, "the numpers of players must be more than 2 and less than 4");
           num_of_player = Integer.valueOf(JOptionPane.showInputDialog("enter the number of players"));
        }
        System.out.println("num of players = " +num_of_player);
    }
    
    public void firstTurn(){
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        whereGame = random.nextInt(num_of_player);
        System.out.println("whereGame = "+whereGame);
        if (whereGame == 0) {
            player1_turn = true;
            textField.setText("player1 Turn");
        }
        else if (whereGame == 1) {
            player2_turn = true;
            textField.setText("player2 Turn");
        }
        else if (whereGame == 2) {
            player3_turn = true;
            textField.setText("player3 Turn");
        }
        else if (whereGame == 3) {
            player4_turn = true;
            textField.setText("player4 Turn");
        }
    }
    
    public void FalsedPlayers(){
        player1_turn = false;
        player2_turn = false;
        player3_turn = false;
        player4_turn = false;
    }
    public void turn_on(){
        FalsedPlayers();
        if(whereGame>= (num_of_player-1)){
            whereGame = 0;
        }
        else{
            whereGame++;
        }
        if(whereGame == 0){
            player1_turn = true;
        }
        if(whereGame == 1){
            player2_turn = true;
        }
        if(whereGame == 2){
            player3_turn = true;
        }
        if(whereGame == 3){
            player4_turn = true;
        }
        
        System.out.println("whereGame in turnon = "+whereGame);
        textField.setText("player "+ (whereGame+1) + " Turn");
    }
    
    public void check(){
        //check player1_wins
        //raws
        if(buttons[0][0].getText() == "1"&&buttons[0][1].getText()=="1"&&buttons[0][2].getText()=="1"&&buttons[0][3].getText()=="1"&&buttons[0][4].getText()=="1")
            player1wins(0,0 , 0,1 , 0,2 , 0,3 , 0,4 );
        else if(buttons[1][0].getText() == "1"&&buttons[1][1].getText()=="1"&&buttons[1][2].getText()=="1"&&buttons[1][3].getText()=="1"&&buttons[1][4].getText()=="1")
            player1wins(1,0 , 1,1 , 1,2 , 1,3 , 1,4 );
        else if(buttons[2][0].getText() == "1"&&buttons[2][1].getText()=="1"&&buttons[2][2].getText()=="1"&&buttons[2][3].getText()=="1"&&buttons[2][4].getText()=="1")
            player1wins(2,0 , 2,1 , 2,2 , 2,3 , 2,4 );
        else if(buttons[3][0].getText() == "1"&&buttons[3][1].getText()=="1"&&buttons[3][2].getText()=="1"&&buttons[3][3].getText()=="1"&&buttons[3][4].getText()=="1")
            player1wins(3,0 , 3,1 , 3,2 , 3,3 , 3,4 );
        else if(buttons[4][0].getText() == "1"&&buttons[4][1].getText()=="1"&&buttons[4][2].getText()=="1"&&buttons[4][3].getText()=="1"&&buttons[4][4].getText()=="1")
            player1wins(4,0 , 4,1 , 4,2 , 4,3 , 4,4 );
        //sampoxa
        else if(buttons[0][0].getText() == "1"&&buttons[1][1].getText()=="1"&&buttons[2][2].getText()=="1"&&buttons[3][3].getText()=="1"&&buttons[4][4].getText()=="1")
            player1wins(0,0 , 1,1 , 2,2 , 3,3 , 4,4 );
        else if(buttons[0][4].getText() == "1"&&buttons[1][3].getText()=="1"&&buttons[2][2].getText()=="1"&&buttons[3][1].getText()=="1"&&buttons[4][0].getText()=="1")
            player1wins(0,4 , 1,3 , 2,2 , 3,1 , 4,0 );
        //colums
        else if(buttons[0][0].getText() == "1"&&buttons[1][0].getText()=="1"&&buttons[2][0].getText()=="1"&&buttons[3][0].getText()=="1"&&buttons[4][0].getText()=="1")
            player1wins(0,0 , 1,0 , 2,0 , 3,0 , 4,0 );
        else if(buttons[0][1].getText() == "1"&&buttons[1][1].getText()=="1"&&buttons[2][1].getText()=="1"&&buttons[3][1].getText()=="1"&&buttons[4][1].getText()=="1")
            player1wins(0,1 , 1,1 , 2,1 , 3,1 , 4,1 );
        else if(buttons[0][2].getText() == "1"&&buttons[1][2].getText()=="1"&&buttons[2][2].getText()=="1"&&buttons[3][2].getText()=="1"&&buttons[4][2].getText()=="1")
            player1wins(0,2 , 1,2 , 2,2 , 3,2 , 4,2 );
        else if(buttons[0][3].getText() == "1"&&buttons[1][3].getText()=="1"&&buttons[2][3].getText()=="1"&&buttons[3][3].getText()=="1"&&buttons[4][3].getText()=="1")
            player1wins(0,3 , 1,3 , 2,3 , 3,3 , 4,3 );
        else if(buttons[0][4].getText() == "1"&&buttons[1][4].getText()=="1"&&buttons[2][4].getText()=="1"&&buttons[3][4].getText()=="1"&&buttons[4][4].getText()=="1")
            player1wins(0,4 , 1,4 , 2,4 , 3,4 , 4,4 );
        
        
        
        //check player2_wins
        //raws
        if(buttons[0][0].getText() == "2"&&buttons[0][1].getText()=="2"&&buttons[0][2].getText()=="2"&&buttons[0][3].getText()=="2"&&buttons[0][4].getText()=="2")
            player2wins(0,0 , 0,1 , 0,2 , 0,3 , 0,4 );
        else if(buttons[1][0].getText() == "2"&&buttons[1][1].getText()=="2"&&buttons[1][2].getText()=="2"&&buttons[1][3].getText()=="2"&&buttons[1][4].getText()=="2")
            player2wins(1,0 , 1,1 , 1,2 , 1,3 , 1,4 );
        else if(buttons[2][0].getText() == "2"&&buttons[2][1].getText()=="2"&&buttons[2][2].getText()=="2"&&buttons[2][3].getText()=="2"&&buttons[2][4].getText()=="2")
            player2wins(2,0 , 2,1 , 2,2 , 2,3 , 2,4 );
        else if(buttons[3][0].getText() == "2"&&buttons[3][1].getText()=="2"&&buttons[3][2].getText()=="2"&&buttons[3][3].getText()=="2"&&buttons[3][4].getText()=="2")
            player2wins(3,0 , 3,1 , 3,2 , 3,3 , 3,4 );
        else if(buttons[4][0].getText() == "2"&&buttons[4][1].getText()=="2"&&buttons[4][2].getText()=="2"&&buttons[4][3].getText()=="2"&&buttons[4][4].getText()=="2")
            player2wins(4,0 , 4,1 , 4,2 , 4,3 , 4,4 );
        //sampoxa
        else if(buttons[0][0].getText() == "2"&&buttons[1][1].getText()=="2"&&buttons[2][2].getText()=="2"&&buttons[3][3].getText()=="2"&&buttons[4][4].getText()=="2")
            player2wins(0,0 , 1,1 , 2,2 , 3,3 , 4,4 );
        else if(buttons[0][4].getText() == "2"&&buttons[1][3].getText()=="2"&&buttons[2][2].getText()=="2"&&buttons[3][1].getText()=="2"&&buttons[4][0].getText()=="2")
            player2wins(0,4 , 1,3 , 2,2 , 3,1 , 4,0 );
        //colums
        else if(buttons[0][0].getText() == "2"&&buttons[1][0].getText()=="2"&&buttons[2][0].getText()=="2"&&buttons[3][0].getText()=="2"&&buttons[4][0].getText()=="2")
            player2wins(0,0 , 1,0 , 2,0 , 3,0 , 4,0 );
        else if(buttons[0][1].getText() == "2"&&buttons[1][1].getText()=="2"&&buttons[2][1].getText()=="2"&&buttons[3][1].getText()=="2"&&buttons[4][1].getText()=="2")
            player2wins(0,1 , 1,1 , 2,1 , 3,1 , 4,1 );
        else if(buttons[0][2].getText() == "2"&&buttons[1][2].getText()=="2"&&buttons[2][2].getText()=="2"&&buttons[3][2].getText()=="2"&&buttons[4][2].getText()=="2")
            player2wins(0,2 , 1,2 , 2,2 , 3,2 , 4,2 );
        else if(buttons[0][3].getText() == "2"&&buttons[1][3].getText()=="2"&&buttons[2][3].getText()=="2"&&buttons[3][3].getText()=="2"&&buttons[4][3].getText()=="2")
            player2wins(0,3 , 1,3 , 2,3 , 3,3 , 4,3 );
        else if(buttons[0][4].getText() == "2"&&buttons[1][4].getText()=="2"&&buttons[2][4].getText()=="2"&&buttons[3][4].getText()=="2"&&buttons[4][4].getText()=="2")
            player2wins(0,4 , 1,4 , 2,4 , 3,4 , 4,4 );
        
        
        
        //check player3_wins
        //raws
        if(buttons[0][0].getText() == "3"&&buttons[0][1].getText()=="3"&&buttons[0][2].getText()=="3"&&buttons[0][3].getText()=="3"&&buttons[0][4].getText()=="3")
            player3wins(0,0 , 0,1 , 0,2 , 0,3 , 0,4 );
        else if(buttons[1][0].getText() == "3"&&buttons[1][1].getText()=="3"&&buttons[1][2].getText()=="3"&&buttons[1][3].getText()=="3"&&buttons[1][4].getText()=="3")
            player3wins(1,0 , 1,1 , 1,2 , 1,3 , 1,4 );
        else if(buttons[2][0].getText() == "3"&&buttons[2][1].getText()=="3"&&buttons[2][2].getText()=="3"&&buttons[2][3].getText()=="3"&&buttons[2][4].getText()=="3")
            player3wins(2,0 , 2,1 , 2,2 , 2,3 , 2,4 );
        else if(buttons[3][0].getText() == "3"&&buttons[3][1].getText()=="3"&&buttons[3][2].getText()=="3"&&buttons[3][3].getText()=="3"&&buttons[3][4].getText()=="3")
            player3wins(3,0 , 3,1 , 3,2 , 3,3 , 3,4 );
        else if(buttons[4][0].getText() == "3"&&buttons[4][1].getText()=="3"&&buttons[4][2].getText()=="3"&&buttons[4][3].getText()=="3"&&buttons[4][4].getText()=="3")
            player3wins(4,0 , 4,1 , 4,2 , 4,3 , 4,4 );
        //sampoxa
        else if(buttons[0][0].getText() == "3"&&buttons[1][1].getText()=="3"&&buttons[2][2].getText()=="3"&&buttons[3][3].getText()=="3"&&buttons[4][4].getText()=="3")
            player3wins(0,0 , 1,1 , 2,2 , 3,3 , 4,4 );
        else if(buttons[0][4].getText() == "3"&&buttons[1][3].getText()=="3"&&buttons[2][2].getText()=="3"&&buttons[3][1].getText()=="3"&&buttons[4][0].getText()=="3")
            player3wins(0,4 , 1,3 , 2,2 , 3,1 , 4,0 );
        //colums
        else if(buttons[0][0].getText() == "3"&&buttons[1][0].getText()=="3"&&buttons[2][0].getText()=="3"&&buttons[3][0].getText()=="3"&&buttons[4][0].getText()=="3")
            player3wins(0,0 , 1,0 , 2,0 , 3,0 , 4,0 );
        else if(buttons[0][1].getText() == "3"&&buttons[1][1].getText()=="3"&&buttons[2][1].getText()=="3"&&buttons[3][1].getText()=="3"&&buttons[4][1].getText()=="3")
            player3wins(0,1 , 1,1 , 2,1 , 3,1 , 4,1 );
        else if(buttons[0][2].getText() == "3"&&buttons[1][2].getText()=="3"&&buttons[2][2].getText()=="3"&&buttons[3][2].getText()=="3"&&buttons[4][2].getText()=="3")
            player3wins(0,2 , 1,2 , 2,2 , 3,2 , 4,2 );
        else if(buttons[0][3].getText() == "3"&&buttons[1][3].getText()=="3"&&buttons[2][3].getText()=="3"&&buttons[3][3].getText()=="3"&&buttons[4][3].getText()=="3")
            player3wins(0,3 , 1,3 , 2,3 , 3,3 , 4,3 );
        else if(buttons[0][4].getText() == "3"&&buttons[1][4].getText()=="3"&&buttons[2][4].getText()=="3"&&buttons[3][4].getText()=="3"&&buttons[4][4].getText()=="3")
            player3wins(0,4 , 1,4 , 2,4 , 3,4 , 4,4 );
        
        //check player4_wins
        //raws
        if(buttons[0][0].getText() == "4"&&buttons[0][1].getText()=="4"&&buttons[0][2].getText()=="4"&&buttons[0][3].getText()=="4"&&buttons[0][4].getText()=="4")
            player4wins(0,0 , 0,1 , 0,2 , 0,3 , 0,4 );
        else if(buttons[1][0].getText() == "4"&&buttons[1][1].getText()=="4"&&buttons[1][2].getText()=="4"&&buttons[1][3].getText()=="4"&&buttons[1][4].getText()=="4")
            player4wins(1,0 , 1,1 , 1,2 , 1,3 , 1,4 );
        else if(buttons[2][0].getText() == "4"&&buttons[2][1].getText()=="4"&&buttons[2][2].getText()=="4"&&buttons[2][3].getText()=="4"&&buttons[2][4].getText()=="4")
            player4wins(2,0 , 2,1 , 2,2 , 2,3 , 2,4 );
        else if(buttons[3][0].getText() == "4"&&buttons[3][1].getText()=="4"&&buttons[3][2].getText()=="4"&&buttons[3][3].getText()=="4"&&buttons[3][4].getText()=="4")
            player4wins(3,0 , 3,1 , 3,2 , 3,3 , 3,4 );
        else if(buttons[4][0].getText() == "4"&&buttons[4][1].getText()=="4"&&buttons[4][2].getText()=="4"&&buttons[4][3].getText()=="4"&&buttons[4][4].getText()=="4")
            player4wins(4,0 , 4,1 , 4,2 , 4,3 , 4,4 );
        //sampoxa
        else if(buttons[0][0].getText() == "4"&&buttons[1][1].getText()=="4"&&buttons[2][2].getText()=="4"&&buttons[3][3].getText()=="4"&&buttons[4][4].getText()=="4")
            player4wins(0,0 , 1,1 , 2,2 , 3,3 , 4,4 );
        else if(buttons[0][4].getText() == "4"&&buttons[1][3].getText()=="4"&&buttons[2][2].getText()=="4"&&buttons[3][1].getText()=="4"&&buttons[4][0].getText()=="4")
            player4wins(0,4 , 1,3 , 2,2 , 3,1 , 4,0 );
        //colums
        else if(buttons[0][0].getText() == "4"&&buttons[1][0].getText()=="4"&&buttons[2][0].getText()=="4"&&buttons[3][0].getText()=="4"&&buttons[4][0].getText()=="4")
            player4wins(0,0 , 1,0 , 2,0 , 3,0 , 4,0 );
        else if(buttons[0][1].getText() == "4"&&buttons[1][1].getText()=="4"&&buttons[2][1].getText()=="4"&&buttons[3][1].getText()=="4"&&buttons[4][1].getText()=="4")
            player4wins(0,1 , 1,1 , 2,1 , 3,1 , 4,1 );
        else if(buttons[0][2].getText() == "4"&&buttons[1][2].getText()=="4"&&buttons[2][2].getText()=="4"&&buttons[3][2].getText()=="4"&&buttons[4][2].getText()=="4")
            player4wins(0,2 , 1,2 , 2,2 , 3,2 , 4,2 );
        else if(buttons[0][3].getText() == "4"&&buttons[1][3].getText()=="4"&&buttons[2][3].getText()=="4"&&buttons[3][3].getText()=="4"&&buttons[4][3].getText()=="4")
            player4wins(0,3 , 1,3 , 2,3 , 3,3 , 4,3 );
        else if(buttons[0][4].getText() == "4"&&buttons[1][4].getText()=="4"&&buttons[2][4].getText()=="4"&&buttons[3][4].getText()=="4"&&buttons[4][4].getText()=="4")
            player4wins(0,4 , 1,4 , 2,4 , 3,4 , 4,4 );
        
        //end
    }
    
    public void player1wins(int a,int b,int c,int d,int e,int f,int g,int h,int i,int j){
        buttons[a][b].setBackground(Color.GREEN);
        buttons[c][d].setBackground(Color.GREEN);
        buttons[e][f].setBackground(Color.GREEN);
        buttons[g][h].setBackground(Color.GREEN);
        buttons[i][j].setBackground(Color.GREEN);
        
        for (int k = 0; k < 5; k++) {
            for (int l = 0; l < 5; l++) {
                buttons[k][l].setEnabled(false);
            }
        }
        
        textField.setText("player1 Win");
    }
    
    public void player2wins(int a,int b,int c,int d,int e,int f,int g,int h,int i,int j){
        buttons[a][b].setBackground(Color.GREEN);
        buttons[c][d].setBackground(Color.GREEN);
        buttons[e][f].setBackground(Color.GREEN);
        buttons[g][h].setBackground(Color.GREEN);
        buttons[i][j].setBackground(Color.GREEN);
        
        for (int k = 0; k < 5; k++) {
            for (int l = 0; l < 5; l++) {
                buttons[k][l].setEnabled(false);
            }
        }
        
        textField.setText("player2 Win");
    }
    
    public void player3wins(int a,int b,int c,int d,int e,int f,int g,int h,int i,int j){
        buttons[a][b].setBackground(Color.GREEN);
        buttons[c][d].setBackground(Color.GREEN);
        buttons[e][f].setBackground(Color.GREEN);
        buttons[g][h].setBackground(Color.GREEN);
        buttons[i][j].setBackground(Color.GREEN);
        
        for (int k = 0; k < 5; k++) {
            for (int l = 0; l < 5; l++) {
                buttons[k][l].setEnabled(false);
            }
        }
        
        textField.setText("player3 Win");
    }
    
    public void player4wins(int a,int b,int c,int d,int e,int f,int g,int h,int i,int j){
        buttons[a][b].setBackground(Color.GREEN);
        buttons[c][d].setBackground(Color.GREEN);
        buttons[e][f].setBackground(Color.GREEN);
        buttons[g][h].setBackground(Color.GREEN);
        buttons[i][j].setBackground(Color.GREEN);
        
        for (int k = 0; k < 5; k++) {
            for (int l = 0; l < 5; l++) {
                buttons[k][l].setEnabled(false);
            }
        }
        
        textField.setText("player4 Win");
    }
    
    public void newGame(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
                buttons[i][j].setBackground(new Color(200,240,200));
            }
        }
            
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        for (int i = 0; i < 5; i++){
            for(int j = 0; j<5;j++){
                if (e.getSource() == buttons[i][j]) {
                    if(player1_turn){
                        if(buttons[i][j].getText() == ""){// getText()== ""     in {setText(" ")  ///buttons[i][j].getBackground() == Color.gray
                            buttons[i][j].setBackground(Color.yellow);
                            buttons[i][j].setForeground(new Color(111, 116, 0));
                            buttons[i][j].setText("1");
                            
                            turn_on();
                            check();
                        }
                    }
                    else if(player2_turn){
                        if(buttons[i][j].getText() == ""){
                            
                            buttons[i][j].setForeground(new Color(130,0,0));
                            buttons[i][j].setText("2");
                            buttons[i][j].setBackground(Color.PINK);
                            turn_on();
                            check();
                        }
                    }   
                    else if(player3_turn){
                        if(buttons[i][j].getText() == ""){
                            buttons[i][j].setForeground(new Color(114, 60, 2));
                            buttons[i][j].setText("3");
                            buttons[i][j].setBackground(new Color(255, 131, 0));
                            turn_on();
                            check();
                        }
                    }
                    else{//player4
                        if(buttons[i][j].getText() == ""){
                            buttons[i][j].setForeground(Color.blue);
                            buttons[i][j].setText("4");
                            buttons[i][j].setBackground(Color.cyan);
                            turn_on();
                            check();
                        }
                    }
                    
                    
                    
                    
                    //System.out.println("i = "+i+" j = "+j );
                }
                else if(e.getSource() == replay){
                    newGame();
                    
                }
                
                
                
            }
        }
    }   
}


//
//for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                if(e.getSource()==buttons[i][j]){
//                    if(player1_turn){
//                        if(buttons[i][j].getBackground() == new Color(180,200,180)){  /////////////////////
//                            buttons[i][j].setBackground(Color.yellow);
//                            turn_on();
//                            check();
//                        }
//                    }
//                
//                    else if(player2_turn){
//                        if(buttons[i][j].getBackground() == new Color(180,200,180)){  /////////////////////
//                            buttons[i][j].setBackground(Color.MAGENTA);
//                            turn_on();
//                            check();
//                        }
//                    }
//                    else if(player3_turn){
//                        if(buttons[i][j].getBackground() == new Color(180,200,180)){  /////////////////////
//                            buttons[i][j].setBackground(Color.PINK);
//                            turn_on();
//                            check();
//                        }
//                    }
//                    else if(player4_turn){
//                        if(buttons[i][j].getBackground() == new Color(180,200,180)){  /////////////////////
//                            buttons[i][j].setBackground(Color.magenta);
//                            turn_on();
//                            check();
//                        }
//                    }
//                }
//            }
//        }
