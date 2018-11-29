package serpent.entities;

/**
* class of 4 rooms of the game
* @author Mengzhao DUAN and Zuo ZHANG
* @version 2018/04/17
*/  
public class Room{

    /** position x of the current room */
    public int mapx; 
    /** position y of the current room */
    public int mapy;
    public int bordx; // the point0 of bord of this room  
    public int bordy;
    
    /** left door of the current room */ 
    public boolean port1; 
    /** top door of the current room */
    public boolean port2; 
    /** right door of the current room */
    public boolean port3; 
    /** down door of the current room */
    public boolean port4; 
    
    public Room(int mapx,int mapy){
        this.mapx=mapx;
        this.mapy=mapy;
        this.port1=false;
        this.port2=false;
        this.port3=false;
        this.port4=false;
        this.bordx=0;
        this.bordy=0;
    }
    
    public Room(int mapx,int mapy,int bordx, int bordy){
        this.mapx=mapx;
        this.mapy=mapy;
        this.port1=false;
        this.port2=false;
        this.port3=false;
        this.port4=false;
        this.bordx=bordx;
        this.bordy=bordy;
    }
     
    /** fonction to open the door when snake across */   
    public void openport(int i){
        if(i==1) this.port1=true;
        else if (i==2) this.port2= true;
        else if (i==3) this.port3= true;
        else if (i==4) this.port4= true;
    }

    /** fonction to close door */
    public void closeport(int i){
        if(i==1) this.port1=false;
        else if (i==2) this.port2= false;
        else if (i==3) this.port3= false;
        else if (i==4) this.port4= false;
    }
}