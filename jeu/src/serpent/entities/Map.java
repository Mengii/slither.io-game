package serpent.entities;

import java.util.ArrayList;

import serpent.Jeu;

/**
* class Map with all 4 rooms
* @author Mengzhao DUAN and Zuo ZHANG
* @version 2018/04/17
*/
public class Map{
        public static int roomid;
        /** status : 0 for lose 1 for playing and 2 for win */
        public static int win ;  
        public Snake snake;
        public ArrayList<Room> rooms = new ArrayList<Room>();
        public ArrayList<Food> foods = new ArrayList<Food>(); //init food in map
        public static ArrayList<Wall> walls = new ArrayList<Wall>(); // stock wall in room2 room3
        public static ArrayList<Wall> movingwalls = new ArrayList<Wall>();
        public static int go=0;
        public static int room1agan = 0;// 1-> active moving wall 
        public Map(Snake snake){
          this.roomid=0;
           this.initroom();
            this.snake=snake;
            this.win=1;
            this.go=0;
            this.room1agan=0;
            this.win=1;
            
        }

        /**
        * fonction to initial the position of each 4 rooms of game
        */
        public void initroom(){
        //if(go==0){
            for(int i = walls.size()-1;i>=0;i--){
            walls.remove(i);
        }
         for(int i = movingwalls.size()-1;i>=0;i--){
            movingwalls.remove(i);
        }
         for(int i = rooms.size()-1;i>=0;i--){
            movingwalls.remove(i);
        }
        

        this.rooms.add(new Room(0,0,100,100));  
        this.rooms.add(new Room(-1000,0,100,100));  
        this.rooms.add(new Room(0,-600,100,100));  
        this.rooms.add(new Room(-1000,-600)); 
        newroomrule(0);
    Point2D p1 = new Point2D(230,220); 
    Point2D p2 = new Point2D(363,130); 
    Point2D p3 = new Point2D(363,355);
    Point2D p4 = new Point2D(497,210); 
    Point2D p7 = new Point2D(597,292); 
    Point2D p8 = new Point2D(630,224); 
    Point2D p9 = new Point2D(661,392); 
    Point2D p10 = new Point2D(763,355); 

Wall wall1  = new Wall(p1,1,5);
Wall wall2  = new Wall(p2,1,4);
Wall wall3  = new Wall(p3,1,4);
Wall wall4  = new Wall(p4,1,9);
Wall wall7  = new Wall(p7,1,1);
Wall wall8  = new Wall(p8,0,3);
Wall wall9  = new Wall(p9,1,1);
Wall wall10  = new Wall(p10,0,2);
this.walls.add(wall1);
this.walls.add(wall2);
this.walls.add(wall3);
this.walls.add(wall4);
this.walls.add(wall7);
this.walls.add(wall8);
this.walls.add(wall9);
this.walls.add(wall10);
     Point2D pm1 = new Point2D(200,100); 
    Point2D pm2 = new Point2D(400,100); 
    Point2D pm3 = new Point2D(600,100);
    Point2D pm4 = new Point2D(300,400); 
    Point2D pm5 = new Point2D(500,400); 
    Point2D pm6 = new Point2D(700,400);  
    Point2D pm7 = new Point2D(800,100);  
Wall mwall1  = new Wall(pm1,1,2,1);
Wall mwall2  = new Wall(pm2,1,2,1);
Wall mwall3  = new Wall(pm3,1,2,1);
Wall mwall4  = new Wall(pm4,1,2,0);
Wall mwall5  = new Wall(pm5,1,2,0);
Wall mwall6  = new Wall(pm6,1,2,0);
Wall mwall7  = new Wall(pm7,1,2,1);
this.movingwalls.add(mwall1);
this.movingwalls.add(mwall2);
this.movingwalls.add(mwall3);
this.movingwalls.add(mwall4);
this.movingwalls.add(mwall5);
this.movingwalls.add(mwall6);
this.movingwalls.add(mwall7);
//go=1;
//}

    }

    /**
    * fonction snake across from one room to another
    * @param r room id
    * @param snake the current snake 
    */
    public void changeroom(int r,Snake snake){
      Room room=this.rooms.get(roomid);
        int a = room.bordx;
        int b = 1000 - room.bordx;
        int c = room.bordy;
        int d = 600 - room.bordy;
        
    if(r==0){ //room0
        if(this.rooms.get(0).port3==true&&snake.xhead>=b&&snake.yhead>200&&snake.yhead<400){  //0 -> 1
            this.roomid=1;
            snake.xhead=a;
            this.newroomrule(1); // rule when snake come in to new room
            Jeu.score=0;
            this.rooms.get(0).port3=false;
        }   
    }
    else if(r==1){  //room1
        if(this.rooms.get(1).port3==true&&snake.xhead>=b&&snake.yhead>200&&snake.yhead<400){ // 1 -> 2
            this.roomid=2;
            snake.xhead=a;
            this.newroomrule(2);
            Jeu.score=0;
            this.rooms.get(1).port3=false;
        }
        else if(this.rooms.get(1).port2==true&&snake.yhead<=c&&snake.xhead>400&&snake.xhead<600){  //1 -> 3
            this.roomid=3;
            snake.yhead=d;
            this.newroomrule(3);
             Map.room1agan=0;
             Jeu.score=0;
             this.rooms.get(1).port2=false;
             Jeu.bossfight=1;
        }
         else if(this.rooms.get(1).port1==true&&snake.xhead<=a&&snake.yhead>200&&snake.yhead<400){  //1 -> 0
            this.roomid=0;
            snake.xhead=b;
            this.newroomrule(0);
            Jeu.score=0;
            this.rooms.get(1).port1=false;
        }
    }
    if(r==2){ //room2
        if(this.rooms.get(2).port1==true&&snake.xhead<=a&&snake.yhead>200&&snake.yhead<400){  //2-> 1
            this.roomid=1;
            snake.xhead=b;

            Map.room1agan=1;
            this.newroomrule(1);
            Jeu.score=0;
            this.rooms.get(2).port1=false;
        }   
    }
    if(r==3){ //room3
        if(this.rooms.get(3).port3==true&&snake.yhead>=d&&snake.xhead>400&&snake.xhead<600){  //3 -> 1
            this.roomid=1;
            snake.yhead=this.rooms.get(1).bordy;
            this.newroomrule(1);
            Jeu.score=0;
            this.rooms.get(3).port3=false;
           
        }   
    }
}


public void newroomrule(int roomid){
   
    if(roomid==0){
        creerfoodin(630,285);
    Jeu.scoreword="/1";     
    }
    else if(roomid == 1){
     
       
    removeallfood();
    creerfoods(5);
       if(Map.room1agan==1)
           Jeu.scoreword="/0"; 
       
       else Jeu.scoreword="/5";   
    }
    else if (roomid == 2){
    if(Map.room1agan==0){
        Jeu.scoreword="/1";     
    removeallfood( );
    creerfoodin(780,413);
    }
    else{ removeallfood( );creerfoodin(1300,1300);}
     
     Jeu.scoreword="/1";     
    }

    else if (roomid == 3){

    removeallfood();
    creerfoods(50);
       Jeu.scoreword="/100";    
    }
    
}
public boolean touch(Wall wall, int x, int y, int r){  // if a cercle et un quatrangle is touched

    return false;
}
public void movebord(){
     int t=1;
                int aaaa=0;
                int bbbb=0;
                int dis=0;
    Room room=this.rooms.get(roomid);
        int a = room.bordx;
        int b = 1000 - room.bordx; 
        int c = room.bordy;
        int d = 570 - room.bordy;
        
    if(this.roomid==3){ //room 3
                
                if(snake.xhead>b){snake.xhead=a;}
                else if(snake.xhead<a){snake.xhead=b;}
                else if(snake.yhead>d){snake.yhead=c;}
                else if(snake.yhead<c){snake.yhead=d;}
            }
    else { //room =1,2,4 lose when touch wall

                if(snake.xhead>b){this.lose();}
                else if(snake.xhead<a){this.lose();}
                else if(snake.yhead>d){this.lose();}
                else if(snake.yhead<c){this.lose();}
    }
    if(this.roomid==1&&this.room1agan==1){
        
        for(int i = 0; i<movingwalls.size();i++){
                aaaa=(snake.xhead-this.movingwalls.get(i).point.x    )*(snake.xhead-this.movingwalls.get(i).point.x    );      
                 if (aaaa<26&& snake.yhead-20>this.movingwalls.get(i).point.y && snake.yhead+20<this.movingwalls.get(i).point.y+this.movingwalls.get(i).longeur*30){
                            
                //if(touch(snake.xhead+snake.rhead,snake.yhead+snake.rhead,5,walls.get(i).point.x,walls.get(i).point.y,33,walls.get(i).longeur*33  )){
                   this.lose();
                 }
        /* 
          
                 aaaa=snake.xhead+snake.rhead-(this.walls.get(i).point.x+16);
                 bbbb=snake.yhead+snake.rhead-(this.walls.get(i).point.y+16*t);
                 dis=aaaa*aaaa+bbbb*bbbb;
                 if (dis<=snake.rhead*snake.rhead+900){
       System.out.println("1"+snake.xhead+" t "+snake.yhead+" t "+snake.rhead+" t "+walls.get(i).point.x+" t "+walls.get(i).point.y+" t "+33+" t "+walls.get(i).longeur*33 );
        
    }
     aaaa=snake.xhead+snake.rhead-(this.walls.get(i).point.x+16);
                 bbbb=snake.yhead+snake.rhead-(this.walls.get(i).point.y+16*3);
                dis=aaaa*aaaa+bbbb*bbbb;
                 if (dis<=snake.rhead*snake.rhead+900){
       System.out.println("1"+snake.xhead+" t "+snake.yhead+" t "+snake.rhead+" t "+walls.get(i).point.x+" t "+walls.get(i).point.y+" t "+33+" t "+walls.get(i).longeur*33 );
                 }
        */
        }
    }
   
    if(this.roomid==2){
    // System.out.println(touch(snake.xhead,snake.yhead,snake.rhead,walls.get(0).point.x,walls.get(0).point.y,33,walls.get(0).longeur*33  ));
    // System.out.println("1"+snake.xhead+" t "+snake.yhead+" t "+snake.rhead+" t "+walls.get(0).point.x+" t "+walls.get(0).point.y+" t "+33+" t "+walls.get(0).longeur*33 );
    // System.out.println(touch(244,254,56,230,220,33,1650));
                 
        for(int i = 0; i<walls.size();i++){
         // System.out.println("1"+snake.xhead+" t "+snake.yhead+" t "+snake.rhead+" t "+walls.get(i).point.x+" t "+walls.get(i).point.y+" t "+33+" t "+walls.get(i).longeur*33 );
                
            if(walls.get(i).ver==1){
               // System.out.println(touch(snake.xhead,snake.yhead,snake.rhead,walls.get(i).point.x,walls.get(i).point.y,walls.get(i).longeur*33,33  ));
                
                 t=1;
                
    
                //for(int j=1;j<=this.walls.get(i).longeur;j++)
                 //aaaa=snake.xhead+snake.rhead-(this.walls.get(i).point.x+16);
                 //bbbb=snake.yhead+snake.rhead-(this.walls.get(i).point.y-20+16*t);
                 //dis=aaaa*aaaa+bbbb*bbbb;
                // t=t+2;
                      aaaa=(snake.xhead-this.walls.get(i).point.x    )*(snake.xhead-this.walls.get(i).point.x    );      
                 if (aaaa<26&& snake.yhead-20>this.walls.get(i).point.y && snake.yhead+20<this.walls.get(i).point.y+this.walls.get(i).longeur*30){
                            
                //if(touch(snake.xhead+snake.rhead,snake.yhead+snake.rhead,5,walls.get(i).point.x,walls.get(i).point.y,33,walls.get(i).longeur*33  )){
                   this.lose();
              //  System.out.println("1"+snake.xhead+" t "+snake.yhead+" t "+snake.rhead+" t "+walls.get(i).point.x+" t "+walls.get(i).point.y+" t "+33+" t "+walls.get(i).longeur*33 );
                    

                }
                
            }
            else{ 
          
                 t=1;
               // for(int j=1;j<=this.walls.get(i).longeur;j++)
                 //aaaa=snake.xhead+snake.rhead-(this.walls.get(i).point.x+16*t);
                //bbbb=snake.yhead+snake.rhead-(this.walls.get(i).point.y-20+16);
                 //dis=aaaa*aaaa+bbbb*bbbb;
                 aaaa=(snake.yhead-this.walls.get(i).point.y    )*(snake.yhead-this.walls.get(i).point.y    );   
                 //if (dis<=snake.rhead*snake.rhead+20){
                   if (aaaa<26 && snake.xhead>this.walls.get(i).point.x && snake.xhead<this.walls.get(i).point.x+this.walls.get(i).longeur*30){
                
                        this.lose();
                // System.out.println("2"+snake.xhead+" t "+snake.yhead+" t "+snake.rhead+" t "+walls.get(i).point.x+" t "+walls.get(i).point.y+" t "+33+" t "+walls.get(i).longeur*33 );
                    
                 //}
             
            }
    }
        }
}
}

    /** 
    * fonction test if the Wall touched by snake
    * @return truc if touched false if not 
    */
    static boolean touch(int xc, int yc, int rc, int x, int y, int h, int l){
        int x0= x+l/2;
        int y0= y+h/2;

int disx=xc-x0;
int disy=yc-y0;

if(disx<0) disx=-disx;
if(disy<0) disy=-disy;



Vector2 v= new Vector2(disx,disy);
Vector2 hh= new Vector2(l/2,h/2);
Vector2 aa= v.moin(hh);
if (aa.x<0) aa.x=0;
if (aa.y<0) aa.y=0;
int dis = aa.x*aa.x+aa.y*aa.y;
// System.out.println(i1+"aa"+rc*rc);
                    

if(dis<rc*rc){return true;}else return false ;

}

    /**
    * fonction to create some food in the current room
    * @param nbrfoods number of food to be created
    */
    public void creerfoods(int nbrfoods){
        Room room=this.rooms.get(this.roomid);
        int a = room.bordx;
        int b = 1000 - room.bordx;
        int c = room.bordy;
        int d = 600 - room.bordy;
        for(int i =0; i<nbrfoods;i++)
        {
         
        //int xx=ran(0,this.rooms.get()./10)*10;
         int xx = (int)(Math.random()*(b-a+1))+a;
        //int yy=ran(0,this.jp.getWidth()/10)*10;
        int yy = (int)(Math.random()*(d-c+1))+c;
        this.foods.add(new Food(xx,yy));   
        }
    }
    public void creerfoodin(int x,int y){
            this.foods.add(new Food(x,y,4));

    }
    public void remove1food(){  
       foods.remove(foods.size() - 1);

    }
    public void removeallfood(){
        for(int i = foods.size()-1;i>=0;i--){
            foods.remove(i);
        }
    }
    public void lose(){
        this.win=0;
    }

    }

