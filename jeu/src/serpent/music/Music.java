package serpent.music;

import java.io.IOException;
import javax.sound.sampled.*;

/**
* class Music to add somme sound effect when game
* @author Mengzhao DUAN and Zuo ZHANG
* @version 2018/04/17
*/
public class Music{
    private Clip clip;
    
    public Music(String fichier){
        try{
            AudioInputStream ai = AudioSystem.getAudioInputStream(getClass().getResource(fichier));
            clip = AudioSystem.getClip();
            clip.open(ai);
        }catch(UnsupportedAudioFileException |IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }


    public void play(){clip.start();}
  
    public void stop(){clip.stop();}
    
    public Clip getMusic(){
        return clip;
    }   
    
    public static void playMusic(String music){
        Music m = new Music(music) ;
        m.play();
    }
}
