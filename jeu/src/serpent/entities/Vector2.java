package serpent.entities;

/**
* class util for class Map 
* @author Mengzhao DUAN and Zuo ZHANG
* @version 2018/04/17
*/

public class Vector2{
	public int x;
	public int y;
	
	public Vector2(){};
	
	public Vector2(int x, int y){
		this.x=x;
		this.y=y;
	}

	public Vector2 moin( Vector2 b){
 		Vector2 c= new Vector2();
 		c.x=this.x-b.x;
 		c.y=this.y-b.y;
 		return c;
	}

}