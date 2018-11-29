package serpent;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.TimerTask;
import javax.imageio.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.text.AbstractDocument.LeafElement;
import java.awt.image.*;

import serpent.entities.Node;
import serpent.entities.Food;
import serpent.entities.Room;
import serpent.entities.Snake;
import serpent.entities.Map;
import serpent.controller.Controller;
//import serpent.music.Music;

/**
* class Jeu for the game frame
* @author Mengzhao DUAN and Zuo ZHANG
* @version 2018/04/18
*/
public class Jeu extends JFrame /*,ActionListener*/ {
    public static int bossfight=0;
    public static Snake boss;
    public static int bossid=1;
    public static int snakeid=1;
    public JPanel jp;
    public JPanel jps;
    public static Snake snake;
    public static Map map;
    public static Controller control;
    public JButton jbgo;
    public JButton stop;
    public JButton keyboard;
    public JButton mouse;
    public JPanel Begin;
    public static int bg=1;
    public static int firstpage=0;

    public JPanel jstar;
    public JPanel jstop;
    public JPanel jlose;
    public JPanel jwin;
    public static int win=1;
    public int j=1;
    public static int score=0;
    public static String scoreword=score+"";
    public static BufferedImage head1;
    public static BufferedImage head2;
    public static BufferedImage head3;
    public static BufferedImage head4;

    public static BufferedImage head;
    public static BufferedImage headleft;
    public static BufferedImage headright;
    public static BufferedImage headback;
    public static BufferedImage body;

    public static BufferedImage bhead;
    public static BufferedImage bheadleft;
    public static BufferedImage bheadright;
    public static BufferedImage bheadback;
    public static BufferedImage bbody;

    public static BufferedImage mappicture;

    public static BufferedImage egg1;
    public static BufferedImage egg2;
    public static BufferedImage egg3;
    public static BufferedImage egg4;
    public static BufferedImage eggdead;

    public static BufferedImage mwallig;

    public static BufferedImage loseig;
    public static BufferedImage winig;
    public static BufferedImage stopig;


    public static BufferedImage open1ig;
    public static BufferedImage open2ig;
    public static BufferedImage open3ig;
    public static BufferedImage open4ig;


    public static BufferedImage leftig;
    public static BufferedImage rightig;
    public JButton left;
    public JButton right;
    public static BufferedImage starig;


    public Jeu(){
        super("SUPER SNAKE 2");
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        snake = new Snake();
        boss=new Snake();
        control = new Controller();
    
        this.addKeyListener(control);
        this.addMouseListener(control);
        this.addMouseMotionListener(control);
        
        keyboard = new JButton("keyboard");
        mouse = new JButton("mouse");
        //keyboard.addActionListener(this);
        //mouse.addActionListener(this);

      
             try{starig= ImageIO.read(new File("./images/start.png"));}catch(IOException e){ e.printStackTrace();}
             try{leftig= ImageIO.read(new File("./images/left.png"));}catch(IOException e){ e.printStackTrace();}
             try{rightig= ImageIO.read(new File("./images/right.png"));}catch(IOException e){ e.printStackTrace();}
             try{head1 = ImageIO.read(new File("./images/head1.png"));}catch(IOException e){ e.printStackTrace();}try{head = ImageIO.read(new File("./images/head.png"));}catch(IOException e){ e.printStackTrace();}
             try{head2 = ImageIO.read(new File("./images/head2.png"));}catch(IOException e){ e.printStackTrace();}
             try{head3 = ImageIO.read(new File("./images/head3.png"));}catch(IOException e){ e.printStackTrace();}
             try{head4 = ImageIO.read(new File("./images/head4.png"));}catch(IOException e){ e.printStackTrace();}
                map=new Map(snake);
      
             try{head = ImageIO.read(new File("./images/head"+snakeid+".png"));}catch(IOException e){ e.printStackTrace();}
             try{headleft = ImageIO.read(new File("./images/headleft"+snakeid+".png"));}catch(IOException e){ e.printStackTrace();}
             try{headright = ImageIO.read(new File("./images/headright"+snakeid+".png"));}catch(IOException e){ e.printStackTrace();}
             try{headback = ImageIO.read(new File("./images/headback"+snakeid+".png"));}catch(IOException e){ e.printStackTrace();}
             try{body = ImageIO.read(new File("./images/body"+snakeid+".png"));}catch(IOException e){ e.printStackTrace();}
              
             try{bhead = ImageIO.read(new File("./images/head"+bossid+".png"));}catch(IOException e){ e.printStackTrace();}
             try{bheadleft = ImageIO.read(new File("./images/headleft"+bossid+".png"));}catch(IOException e){ e.printStackTrace();}
             try{bheadright = ImageIO.read(new File("./images/headright"+bossid+".png"));}catch(IOException e){ e.printStackTrace();}
             try{bheadback = ImageIO.read(new File("./images/headback"+bossid+".png"));}catch(IOException e){ e.printStackTrace();}
             try{bbody = ImageIO.read(new File("./images/body"+bossid+".png"));}catch(IOException e){ e.printStackTrace();}
            
             try{mappicture = ImageIO.read(new File("./images/map.png"));}catch(IOException e){ e.printStackTrace();}
        
             try{egg1 = ImageIO.read(new File("./images/egg1.png"));}catch(IOException e){ e.printStackTrace();}
             try{egg2 = ImageIO.read(new File("./images/egg2.png"));}catch(IOException e){ e.printStackTrace();}
             try{egg3 = ImageIO.read(new File("./images/egg3.png"));}catch(IOException e){ e.printStackTrace();}
             try{egg4 = ImageIO.read(new File("./images/egg4.png"));}catch(IOException e){ e.printStackTrace();}
             try{eggdead = ImageIO.read(new File("./images/egg-1.png"));}catch(IOException e){ e.printStackTrace();}

             try{mwallig= ImageIO.read(new File("./images/wall.png"));}catch(IOException e){ e.printStackTrace();}
        
             try{loseig= ImageIO.read(new File("./images/lose.png"));}catch(IOException e){ e.printStackTrace();}
             try{winig= ImageIO.read(new File("./images/win.png"));}catch(IOException e){ e.printStackTrace();}
             try{stopig= ImageIO.read(new File("./images/stop.png"));}catch(IOException e){ e.printStackTrace();}
              
             try{open1ig= ImageIO.read(new File("./images/open1.png"));}catch(IOException e){ e.printStackTrace();}
             try{open2ig= ImageIO.read(new File("./images/open2.png"));}catch(IOException e){ e.printStackTrace();}
             try{open3ig= ImageIO.read(new File("./images/open3.png"));}catch(IOException e){ e.printStackTrace();}
             try{open4ig= ImageIO.read(new File("./images/open4.png"));}catch(IOException e){ e.printStackTrace();}
              
             
             
             jp = new JPanel(){
                 public void paintComponent(Graphics g){
                     
           if(firstpage==0){
             

            snake = new Snake();
              boss=new Snake();
            
             map=new Map(snake);

               try{head = ImageIO.read(new File("./images/head"+snakeid+".png"));}catch(IOException e){ e.printStackTrace();}
             try{headleft = ImageIO.read(new File("./images/headleft"+snakeid+".png"));}catch(IOException e){ e.printStackTrace();}
             try{headright = ImageIO.read(new File("./images/headright"+snakeid+".png"));}catch(IOException e){ e.printStackTrace();}
             try{headback = ImageIO.read(new File("./images/headback"+snakeid+".png"));}catch(IOException e){ e.printStackTrace();}
             try{body = ImageIO.read(new File("./images/body"+snakeid+".png"));}catch(IOException e){ e.printStackTrace();}
                jstop.setVisible(false);
                  jlose.setVisible(false);
                    jwin.setVisible(false);
            
                 Graphics2D g2 = (Graphics2D)g;
                 AffineTransform tx = new AffineTransform();

                 g.drawImage(starig,0,0,1000,600,null);//draw map
                 g2.drawImage(leftig,320,320,50,50,null);
                 g2.drawImage(rightig,620,320,50,50,null);
                 if(snakeid==1)g2.drawImage(head1,443,310,100,100,null);
                 else if(snakeid==2)g2.drawImage(head2,443,310,100,100,null);
                 else if (snakeid==3)g2.drawImage(head3,443,310,100,100,null);
                 else g2.drawImage(head4,443,310,100,100,null);
                 if(firstpage==0){bossid=(int)(Math.random()*(3))+1;
                 if(bossid==snakeid) bossid=(int)(Math.random()*(3))+1;

             try{bhead = ImageIO.read(new File("./images/head1"+bossid+".png"));}catch(IOException e){ e.printStackTrace();}
             try{bheadleft = ImageIO.read(new File("./images/headleft1"+bossid+".png"));}catch(IOException e){ e.printStackTrace();}
             try{bheadright = ImageIO.read(new File("./images/headright1"+bossid+".png"));}catch(IOException e){ e.printStackTrace();}
             try{bheadback = ImageIO.read(new File("./images/headback1"+bossid+".png"));}catch(IOException e){ e.printStackTrace();}
             try{bbody = ImageIO.read(new File("./images/body1"+bossid+".png"));}catch(IOException e){ e.printStackTrace();}
                }
                }
            else{  //snake = new snake();
              //boss=new snake();
            //  control = new Controller(snake);
            // map=new MAP(snake);
            //  this.addKeyListener(control);
             // this.addMouseListener(control);
              //this.addMouseMotionListener(control);

                
//g.setColor(Color.RED);
                 //this.setBackground(Color.blue);
                 // g.fillOval(snake.xhead, snake.yhead, snake.rhead, snake.rhead);

                 Graphics2D g2 = (Graphics2D)g;
                 AffineTransform tx = new AffineTransform();
            
           
                 Node nod1=new Node(snake.xhead,snake.yhead); //list of node of snake
                  Node nod2=new Node(boss.xhead,boss.yhead); //list of node of boss
                
                  snake.nodes.set(0,nod1);// head of snake
                
                    boss.nodes.set(0,nod2);// head of snake

            
                 g.drawImage(mappicture,map.rooms.get(map.roomid).mapx,map.rooms.get(map.roomid).mapy,null);//draw map


//open port

                
                   
                        if(map.rooms.get(map.roomid).port1==true) g2.drawImage(open1ig,45,220,70,170,null);
               
                        if(map.rooms.get(map.roomid).port2==true) g2.drawImage(open2ig,427,40,null);
               
                        if(map.rooms.get(map.roomid).port3==true) g2.drawImage(open3ig,890,220,70,170,null);
               
                        if(map.rooms.get(map.roomid).port4==true) g2.drawImage(open4ig,300,500,null);
               
//paintfood
            
                 for(j =0;j<map.foods.size();j++){
                 //g.fillOval(map.foods.get(j).x, map.foods.get(j).y, 10, 10);// draw map.foods
                     if(map.foods.get(j).value==1)
                     g2.drawImage(egg1,map.foods.get(j).x, map.foods.get(j).y,40,40,null);
                     else if(map.foods.get(j).value==2) 
                     g2.drawImage(egg2,map.foods.get(j).x, map.foods.get(j).y,40,40,null);
                     else if(map.foods.get(j).value==3) 
                     g2.drawImage(egg3,map.foods.get(j).x, map.foods.get(j).y,40,40,null);
                     else if(map.foods.get(j).value==4) 
                     g2.drawImage(egg4,map.foods.get(j).x, map.foods.get(j).y,40,40,null);
                     else if(map.foods.get(j).value==-1) 
                     g2.drawImage(eggdead,map.foods.get(j).x, map.foods.get(j).y,40,40,null);
               
                 
                }

//paint moving wall in room 1
                 if (Map.room1agan==1){
                 //System.out.println("mw");
                     for(int i =0 ; i< Map.movingwalls.size();i++){
                          //System.out.println("paint "+Map.movingwalls.get(i).point.x);
                          g2.drawImage(mwallig,Map.movingwalls.get(i).point.x, Map.movingwalls.get(i).point.y,36,66,null);
                        }
                 }


                
 //body //getxy
                 for(int b =1;b<snake.nodes.size();b++){
                     int j= snake.nodes.size()-b; 
                     snake.nodes.set(j,snake.nodes.get(j-1));
                 }
            //body //paintbody
                 if(snake.ver!=2){
                     int s=snake.nodes.size();
                     for(j=1;j<snake.nodes.size()-4;j++){
                         //g.fillOval(snake.nodes.get(j).x, snake.nodes.get(j).y, snake.rnode, snake.rnode); //draw node of snake
                         if(j%4==3){
                                g2.drawImage(body,snake.nodes.get(s-j).x,snake.nodes.get(s-j).y,snake.rnode,snake.rnode,null);
                             
                             }  
                     }
                }
            //painthead
                 int r=snake.rnode;
                 if(snake.ver==0)     g2.drawImage(headright,snake.xhead-r/4,snake.yhead-r/2+4,snake.rhead,snake.rhead,null);
                 else if(snake.ver==1)g2.drawImage(headleft,snake.xhead-r/4,snake.yhead-r/2+4,snake.rhead,snake.rhead,null);
                 else if(snake.ver==3)g2.drawImage(head,snake.xhead-r/4,snake.yhead-r/2,snake.rhead,snake.rhead,null);
                 else if(snake.ver==2){
                     g2.drawImage(headback,snake.xhead-r/4,snake.yhead-r/4,snake.rhead,snake.rhead,null);
                     for(j =2;j<snake.nodes.size()-4;j++){
                         if(j%4==3){
                             g2.drawImage(body,snake.nodes.get(j).x,snake.nodes.get(j).y,snake.rnode,snake.rnode,null);
                        }
                    }
                 }
                 // g.fillRect(snake.xhead-r/4, snake.yhead-r/4, snake.rhead, snake.rhead);
      //           System.out.println("    "+Map.walls.get(6).point.x+"ss"+Map.walls.get(6).point.y);
       // for(int i=0;i<Map.walls.size();i++){
         //  if(Map.walls.get(i).ver==1){
           
           //  g.fillRect(Map.walls.get(i).point.x,Map.walls.get(i).point.y-20, 33, 33*Map.walls.get(i).longeur);}
           // else  g.fillRect(Map.walls.get(i).point.x,Map.walls.get(i).point.y-20, 33*Map.walls.get(i).longeur, 33);
        //}
//boss fight
                 if(bossfight==1){
                    for(int b =1;b<boss.nodes.size();b++){
                     int j= boss.nodes.size()-b; 
                        
                     boss.nodes.set(j,boss.nodes.get(j-1));
                 }
                      /*for(int b =1;b<boss.nodes.size();b++){
                     int j= boss.nodes.size()-b; 
                     boss.nodes.set(j,boss.nodes.get(j-1));
                   
                 }*/
            //body //paintbody
                 if(boss.ver!=2){
                     int s=boss.nodes.size();
                     for(j=1;j<boss.nodes.size()-4;j++){
                         //g.fillOval(snake.nodes.get(j).x, snake.nodes.get(j).y, snake.rnode, snake.rnode); //draw node of snake
                         if(j%4==2){
                                g2.drawImage(bbody,boss.nodes.get(s-j).x,boss.nodes.get(s-j).y,boss.rnode,boss.rnode,null);
                                
                               
                                
                                
                                 int dis=(snake.xhead-boss.nodes.get(s-j).x)*(snake.xhead-boss.nodes.get(s-j).x)+(snake.yhead-boss.nodes.get(s-j).y)*(snake.yhead-boss.nodes.get(s-j).y);
            
                                 if (dis<=snake.rhead*snake.rhead*2){
                                {map.lose();}}
                                 
                             
                             }  
                     }
                }
            //painthead
                  r=boss.rnode;
                 if(boss.ver==0)     g2.drawImage(bheadright,boss.xhead-r/4,boss.yhead-r/2+4,boss.rhead,boss.rhead,null);
                 else if(boss.ver==1)g2.drawImage(bheadleft,boss.xhead-r/4,boss.yhead-r/2+4,boss.rhead,boss.rhead,null);
                 else if(boss.ver==3)g2.drawImage(bhead,boss.xhead-r/4,boss.yhead-r/2,boss.rhead,boss.rhead,null);
                 else if(boss.ver==2){
                     g2.drawImage(bheadback,boss.xhead-r/4,boss.yhead-r/4,boss.rhead,boss.rhead,null);
                     for(j =2;j<boss.nodes.size()-4;j++){
                         if(j%4==2){
                             g2.drawImage(bbody,boss.nodes.get(j).x,boss.nodes.get(j).y,boss.rnode,boss.rnode,null);
                           int dis=(snake.xhead-boss.nodes.get(j).x)*(snake.xhead-boss.nodes.get(j).x)+(snake.yhead-boss.nodes.get(j).y)*(snake.yhead-boss.nodes.get(j).y);
            
                                
                                 if (dis<=snake.rhead*snake.rhead*2){
                                {map.lose();}}
                        }
                    }
                 }   
                } 



            }




                 }
            };
            
        
        
        
          
           
            //jps=new JPanel();
            //this.getContentPane().add(jps,BorderLayout.SOUTH);
             //jps.add(jl);
         //jps.add(keyboard);
             //jps.add(mouse);
    //jps.setBackground(Color.GRAY);
              //jl.setText("score="+score);
   
    //jstar
/*
    jstar=new JPanel(){ public void paintComponent(Graphics g){
          super.paintComponent(g);  
        g.drawImage(starig, 0, 0,this.getWidth(), this.getHeight(), this);  
    }};
        //jstop.setLocation(300,300);
    jstar.setBackground(null);  
    jstar.setOpaque(false); 
    jstar.setPreferredSize(new Dimension(1000, 600));
    jp.add(jstar);
    jstop.setVisible(true);
    left=new JButton();
    right=new JButton();
    this.add(left);
    this.add(right);
    left.setLocation(500,400);
    right.setLocation(500,600);
    left.addActionListener(control);
    right.addActionListener(control);
*/
//jstop
             jstop=new JPanel(){ public void paintComponent(Graphics g){
                 Graphics2D g2= (Graphics2D)g;
                 super.paintComponent(g);  
                 g.drawImage(stopig, 0, 0,this.getWidth(), this.getHeight(), this);
                 FontMetrics fm = g.getFontMetrics();
                  g.setColor(Color.RED);
                 Font f = new Font ("Courier",Font.BOLD,30);
                  g.setFont(f);
                  g2.drawString(score+scoreword,123,147);  
             }};
        
             jstop.setBackground(null);  
             jstop.setOpaque(false); 
             jstop.setPreferredSize(new Dimension(300, 400));
    
             jp.add(jstop);
             jstop.setVisible(false);
//jlose
             jlose=new JPanel(){ public void paintComponent(Graphics g){
                 super.paintComponent(g);  
                 g.drawImage(loseig, 0, 0,this.getWidth(), this.getHeight(), this);  
             }};
            //jstop.setLocation(300,300);
             jlose.setBackground(null);  
             jlose.setOpaque(false); 

             jlose.setPreferredSize(new Dimension(300, 400));
       
             jp.add(jlose);
             jlose.setVisible(false);

  //jwin
             jwin=new JPanel(){ public void paintComponent(Graphics g){
                 super.paintComponent(g);  
                  g.drawImage(winig, 0, 0,this.getWidth(), this.getHeight(), this);  
              }};
                //jstop.setLocation(300,300);
             jwin.setBackground(null);  
             jwin.setOpaque(false);  //jstop.setLocation(300,300);
             jwin.setPreferredSize(new Dimension(300, 400));
             jp.add(jwin);
             jwin.setVisible(false);
        



         this.getContentPane().add(jp ,BorderLayout.CENTER);
         jp.setVisible(true);
         setSize(1000,600);
         this.setVisible(true);
    }

   
public static void main(String args[]){
      Jeu j = new Jeu();
        
       while(true){ 

        if(bg==0){
        
        }
        else if(bg==1){
            if(firstpage==0){
                  bg=0;
                 
                 java.util.Timer t = new java.util.Timer();
                 t.schedule(new TimerTask(){
                public void run(){
                     j.repaint();
                } },0,20);
                
            }
            else{
            bg=0;
            //System.out.println("go");
            
            java.util.Timer t = new java.util.Timer();
            j.snake.creernodes(10);
             j.boss.creernodes(40);
            t.schedule(new TimerTask(){
            public void run(){
//stop
                while(j.control.stop==true){
                    j.jstop.setVisible(true);//when stop
                    try{
                    Thread.currentThread().sleep(500);}
                    catch(InterruptedException e){
                    e.printStackTrace();
                    }
                }
                j.jstop.setVisible(false);
///game
                j.map.changeroom(j.map.roomid, j.snake);
                j.map.movebord();
                j.snake.move(j.control.controlnb,j.map.roomid);
                if(j.bossfight==1){
                j.boss.moveboss();
                }
               // System.out.println(j.boss.xhead+"aa"+j.boss.yhead);

                j.repaint();

                if(j.map.roomid==0){ //if room = 0
                    if(j.map.foods.get(0).beeat(j.snake.xhead,j.snake.yhead,j.snake)!=0){
                          j.map.rooms.get(0).openport(3);  
                          j.map.removeallfood();
                          j.map.creerfoodin(1300,1300);
                         j.score=1;
                    }
                }
                else if(j.map.roomid==2){ //if room = 2
                    if(j.map.foods.get(0).beeat(j.snake.xhead,j.snake.yhead,j.snake)!=0){
                        j.map.rooms.get(2).openport(1);  
                         j.map.rooms.get(1).openport(2);  
                        j.map.removeallfood();
                        j.map.creerfoodin(1300,1300);
                         j.score=1;
                    }
                }
                else if(j.map.roomid==1&&Map.room1agan==1){
                    j.map.removeallfood();
                    j.map.creerfoodin(1300,1300);
                     j.score=0;
                }
                for(Food fo : j.map.foods){ //when eat food
                    if(fo.beeat(j.snake.xhead,j.snake.yhead,j.snake)!=0){ 
                     //Music.playMusique("./musique/eat.wav");
                    
                         j.score=j.score+fo.value;
                           //j.jl.setText("score:"+j.score);
                         j.snake.creernodes(fo.beeat(j.snake.xhead,j.snake.yhead,j.snake));
                           //System.out.println("eat!");
                          Room room=j.map.rooms.get(j.map.roomid);
                         int a = room.bordx;
                         int b = 1000 - room.bordx;
                         int c = room.bordy;
                         int d = 540 - room.bordy;
                          fo.x=(int)(Math.random()*(b-a+1))+a;
                          fo.y=(int)(Math.random()*(d-c+1))+c;
                            //j.map.foods.remove(idfood);
                          // j.map.creerfoods(1);
                        }
                }
                 //open door
                if(j.map.roomid==1){
                    if(j.score>=5){
                        j.map.rooms.get(1).openport(3);
                        //System.out.println("open");
                    }
                     //   j.map.foods.remove(0);
                }
                   
                else if(j.map.roomid==3){
                    if(j.score>100){
                        j.map.win=2;
                    }
                }
                //moving wall
                if (Map.room1agan==1){
                    for(int i =0 ; i< Map.movingwalls.size();i++){
                         Map.movingwalls.get(i).movewall();
                      
                    }
                }
                //win lose
                if(j.map.win!=1){
                    Map.room1agan=0;
                    bossfight=0;
                   

                    if(j.map.win==0){ j.jlose.setVisible(true);} //lose
                    if(j.map.win==2){ j.jwin.setVisible(true);} //win
                    win=0;
                        
                    t.cancel();

                }
            }
            },0,20);
        }
        }
     System.out.println("go"+win);
       
        }
    
}

/////control




          /*  public void actionPerformed(ActionEvent e) {
                String name= ((JButton)e.getSource()).getText();
                System.out.println("1 1 controle"+control+"name"+name);
                if(name == "keyboard"){
                    control=1;
                    System.out.println("22 controle"+control);
                }
                if(name == "mouse"){
                    control=2;
                    System.out.println("33 controle"+control);
                }
            }*/

   
public boolean lose(){
    boolean bl=false;
    for(int b =3;b<snake.nodes.size();b++){
            
        if(b==-1)bl= true;}
         return bl;

    }
    

/////////////tool//////
public  static int ran(double num1,double num2){  
    int s=(int)num1+(int)(Math.random()*(num2-num1)); 
    return s; 
}


}

