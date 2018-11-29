package serpent.entities;

/**
* class Food for snake to obtain some points and be bigger
* @author Mengzhao DUAN and Zuo ZHANG
* @version 2018/04/17
*/
public class Food{
	public int x;
	public int y;
    /** value of food corresponding points obtained (-1 for poison) */
    public int value;  
    
    public Food(int x,int y){
        this.x=x;
        this.y=y;
        this.value=(int)(Math.random()*(8+1))-1;  
        if (this.value==0||this.value==1){this.value=1;}
        else if (this.value==-1) this.value=-1;
        else this.value=this.value/2;
    }
    public Food(int x,int y,int value){
        this.x=x;
        this.y=y;
        this.value=value;  
    }

    /**
    * fonction when food eaten by snake
    * @param xman the position x of snake
    * @param yman the position y of snake
    * @param snake the current snake
    * @return the value of food eaten
    */  
    public int beeat(int xman, int yman, Snake snake){
        int dis=(snake.xhead-this.x)*(snake.xhead-this.x)+(snake.yhead-this.y)*(snake.yhead-this.y);
            
        if (dis<=snake.rhead*snake.rhead){
            //System.out.println("x y:"+this.x+","+this.y);
            //rman=rman+1;
            //rnode=rnode+1;
            if(this.value==-1) Map.win=0;//if food is toxic snake dead
                return this.value;
        }
        else return 0;
    }

}