package serpent.entities;

import java.util.ArrayList;

/**
* class Snake to eat food and get enough points to win the game
* @author Mengzhao DUAN and Zuo ZHANG
* @version 2018/04/17
*/
public class Snake{
        public int speed;
    /** position x of the snake's head */
    public int xhead;
    /** position y of the snake's head */
    public int yhead;
    /** radius of the snake's head */
    public int rhead;

    /** direction of horizontal axis */
    public int verx;
    /** direction of vertical axis */  
    public int very;
    /** directions : 0 for right 1 for left 2 for up and 3 for down */
    public int ver;
    /** radius of one node of the snake's body */
    public int rnode;

    /** number of food eaten by the snake */
    public static int nodeeated=0;
    /** body of snake */
    public ArrayList<Node> nodes = new ArrayList<Node>();

        public Snake(){
            this.speed=3; 
            this.xhead=310;
            this.yhead=110;
            this.rhead=55;
            this.ver=0;
            this.verx=0;
            this.very=0;
            this.rnode=35;
        }
    /**
    * fonction add one node to snake's body when one food eaten and be bigger when 10 food eaten
    */
    public void creernodes(int t){
        for(int i =0; i<t;i++)
        {
         
        this.nodes.add(new Node(this.xhead,this.yhead));   
            nodeeated++;
    }  // System.out.println("nodeeated:"+nodeeated);
        if(nodeeated%10==0){
            biggersnack();
            
        }
    }

    /**
    * fonction snake be bigger with bigger radius of head and body
    */
    public void biggersnack(){
        //System.out.println("bigger snack");
        this.rnode++;
        this.rhead++;
    }

    /**
    * fonction snake be smaller with smaller radius of head and body
    */
    public void smallersnack(){
        this.rnode--;
        this.rhead--;
    }

    ////move of sneck
    public void move(int controlnb, int roomid){
            if(controlnb==1){ // keyboard
        //    this.moveboardkey();
            if(this.ver==0){this.xhead=this.xhead+speed;}
            else if(this.ver==1){this.xhead=this.xhead-speed;}
            else if(this.ver==2){this.yhead=this.yhead-speed;}
            else if(this.ver==3){this.yhead=this.yhead+speed;}
            }
            else if (controlnb==2){//mouse
             this.moveboardkey();
            this.xhead=this.xhead+(int)((float)(this.speed)*getmovex(this.xhead,this.yhead,this.verx,this.very));
            this.yhead=this.yhead+(int)((float)(this.speed)*getmovey(this.xhead,this.yhead,this.verx,this.very));

            }
            
     }
     public void moveboss(){
         if(this.xhead+speed>=900)this.ver=1;
         if(this.xhead-speed<=10) this.ver=0;
         if(this.yhead+speed<=10) this.ver=3;
         if(this.yhead+speed>=500) this.ver=2;
         
            if(this.ver==0){this.xhead=this.xhead+speed;}
            else if(this.ver==1){this.xhead=this.xhead-speed;}
            else if(this.ver==2){this.yhead=this.yhead-speed;}
            else if(this.ver==3){this.yhead=this.yhead+speed;}

            int a=(int)(Math.random()*(100));
            if(a>95) this.changever();
     }
     public void changever(){
         
             this.ver = (int)(Math.random()*(4));
             //System.out.println(ver);
     }
    public void moveboardkey(){
     /*       if(roomid==3){
                if(this.xhead>this.jp.getWidth()){this.xhead=0;}
                else if(this.xhead<0){this.xhead=this.jp.getWidth();}
                else if(this.yhead>this.jp.getHeight()){this.yhead=0;}
                else if(this.yhead<0){this.yhead=this.jp.getHeight();}
            }
            else {
                if(this.xhead>this.jp.getWidth()){this.lose();}
                else if(this.xhead<0){this.lose();}
                 else if(this.yhead>this.jp.getHeight()){this.lose();}
                 else if(this.yhead<0){this.lose();}
            }*/
    }
/////move by mouse
public double getmovey(int x2, int y2, int x1, int y1){


   float angle = (float) Math.toDegrees(Math.atan2(y1 - y2, x1 - x2));

    if(angle < 0){
        angle += 360;
    }
return Math.sin(angle);
}
public double getmovex(int x2, int y2, int x1, int y1){


   float angle = (float) Math.toDegrees(Math.atan2(y1 - y2, x1 - x2));

    if(angle < 0){
        angle += 360;
    }
return Math.cos(angle);
}
    }