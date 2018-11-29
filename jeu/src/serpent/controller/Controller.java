package serpent.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import serpent.entities.Snake;
import serpent.Jeu;

/**
* class Controller to mave snake by keyboard or mouse
* @author Mengzhao DUAN and Zuo ZHANG
* @version 2018/04/17
*/
 public class Controller implements KeyListener,MouseMotionListener,MouseListener,ActionListener{

        public int controlnb;//1->keyboard 2->mouse
        public int speedold;
        public boolean stop=false;
        
        public Controller(){
            this.controlnb=1; 
             this.speedold=Jeu.snake.speed;
        }
    
//////////////////////////////////////////////////////////////////////////////////////////////

/////    move by keyboard (mode 1)
    
//////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void keyTyped(KeyEvent e) {}

        

    @Override
    public void keyPressed(KeyEvent e) {
       if(this.controlnb==1){ 
          
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            
            
            
                
                
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            
                if(Jeu.snake.ver==1){Jeu.snake.speed=Jeu.snake.speed+10;}
            Jeu.snake.ver=1;
            
        }   
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            
                if(Jeu.snake.ver==2){Jeu.snake.speed=Jeu.snake.speed+10;}
            Jeu.snake.ver=2;
            
        }   
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            
                if(Jeu.snake.ver==3){Jeu.snake.speed=Jeu.snake.speed+10;}
            Jeu.snake.ver=3;
            
        }   
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if(Jeu.firstpage==0){
                System.out.println("1");
                Jeu.firstpage=1;
                Jeu.bg=1;
            }
            else{
                System.out.println("2");
                 if(Jeu.win!=1){
                     Jeu.bg=1;
                     Jeu.firstpage=0;
                     Jeu.win=1;
                     
                 }
                  this.stop=!this.stop;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(Jeu.firstpage==0){
       
            if(Jeu.snakeid==1)Jeu.snakeid=4;
            else Jeu.snakeid--;
        //System.out.println("a"+Jeu.snakeid);
        }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(Jeu.firstpage==0){
       
            if(Jeu.snakeid==4)Jeu.snakeid=1;
            else Jeu.snakeid++;
        //System.out.println("a"+Jeu.snakeid);
        }
           if(Jeu.snake.ver==0){Jeu.snake.speed=Jeu.snake.speed+10;}
                Jeu.snake.ver=0;
        }
    }
}

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        Jeu.snake.speed=this.speedold;
        
    }

//////////////////////////////////////////////////////////////////////////////////////////////

/////    move by mouse (mode 2 ne fonctionne pas parfaitement)
    
/////////////////////////////////////////////////////////////////////////////////////////////

@Override
public void mouseClicked(MouseEvent e) {
    System.out.println("x="+e.getX()+"  y="+e.getY());
  //  if(e.getClickCount()==1) {
       //  System.out.println("x="+e.getX()+"  y="+e.getY());
        if(Jeu.firstpage==0){
        if(e.getX()>320&&e.getX()<370&&e.getY()>320&&e.getY()<390) {
            if(Jeu.snakeid==1)Jeu.snakeid=4;
            else Jeu.snakeid--;
        //System.out.println("a"+Jeu.snakeid);
        }

        else if(e.getX()>620&&e.getX()<670&&e.getY()>320&&e.getY()<395) {
            if(Jeu.snakeid==4){Jeu.snakeid=1;}
            else Jeu.snakeid++;

        }
      }
 //   }else if(e.getClickCount()==2) {
  //      System.out.println("twice");
  //  }else if(e.getClickCount()==3) {
   //     System.out.println("three times");
   // }
}

@Override
public void mousePressed(MouseEvent e) {
    //System.out.println("mouse pressed");      
    Jeu.snake.speed=Jeu.snake.speed+5;
}


@Override
public void mouseReleased(MouseEvent e) {
    //System.out.println("mouse released");  
    Jeu.snake.speed=Jeu.snake.speed-5;   
}

@Override
public void mouseEntered(MouseEvent e) {
    
}

@Override
public void mouseExited(MouseEvent e) {
        
}

@Override
public void mouseDragged(MouseEvent e) {
           // String str="position mouse:("+e.getX()+","+e.getY()+")";
          
}

@Override
public void mouseMoved(MouseEvent e) {
        //System.out.println("mouse moved");  
        if(this.controlnb==2){
        Jeu.snake.verx=e.getX();
          Jeu.snake.very=e.getY();
        }  
}

public void actionPerformed(ActionEvent e) {
        // String name = (e.getSource()).getText();
     //System.out.println(name);
        
}
    }