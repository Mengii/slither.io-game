package serpent.entities;

/**
* class wall - the snake will die when hit the wall
* @author Mengzhao DUAN and Zuo ZHANG
* @version 2018/04/17
*/

public class Wall{

	public Point2D point; //left top point
	/** position of the wall : 0 for vertical and 1 for horizontal */
	protected int ver; 
	protected int longeur;
	/** direction of the wall : 0 for up and 1 for down */
	protected int movever; 

	public Wall(Point2D point, int ver, int longeur){
		this.point=point;
		this.ver=ver;
		this.longeur=longeur;   //this
	}

	public Wall(Point2D point, int ver, int longeur, int movever){
		this.point=point;
		this.ver=ver;
		this.longeur=longeur;   //this
		this.movever=movever;
	}
	
	/**
	* fontion to make a wall with automatically movement 
	*/
	public void movewall(){ 
    	if(this.point.y<100) this.movever=1;
    	else if(this.point.y>400) this.movever=0;
    	if(this.movever==0) this.point.y=this.point.y-2;
    	else this.point.y=this.point.y+2;
    }

}