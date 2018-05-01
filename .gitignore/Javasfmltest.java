
package javasfmltest;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.graphics.View;
import org.jsfml.system.Clock;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;
import org.jsfml.window.Keyboard;
import static org.jsfml.window.VideoMode.getDesktopMode;
 
public class Javasfmltest {
    
    public static void main(String[] args) throws IOException {
        int x=0;
        Event myevent;
        Sprite mySprite=new Sprite();
        
        ArrayList<Sprite> tab;
        tab=new ArrayList();
        tab.add(mySprite);
        tab.add(mySprite);
        Texture forestTexture=new Texture();
	forestTexture.loadFromFile(Paths.get("forest.jpg"));
        
        Texture grassTexture=new Texture();
        grassTexture.loadFromFile(Paths.get("grass.jpg"));
        //mySprite=new Sprite(forestTexture);
        //mySprite.setTexture(forestTexture);
        tab.get(0).setTexture(forestTexture);
        tab.get(1).setTexture(grassTexture);
        
        //RenderWindow window(new getDesktopMode(), "Archers 1.0");
        RenderWindow window= new RenderWindow(getDesktopMode(),"Archers 6.9");
        window.setFramerateLimit(60);
        System.out.println(x);
        Vector2i mouseP= new Vector2i(0,0);
        Vector2i mouse= new Vector2i(-800,0);
        Vector2f poczatek=new Vector2f(0,0);
        View view1 = new View(new FloatRect(new Vector2f(-100, 480), new Vector2f(1000, 1000)));
        view1.setCenter(0,0);
        
        View view2 = new View(new FloatRect(new Vector2f(-100, 480), new Vector2f(1000, 1000)));
        window.setView(view2);
        
        //RenderWindow myWindow;
        Clock myClock=new Clock();
        Arrow chojarrow;
        Background chojback;
        chojback=new Background(window);
        chojarrow=new Arrow(mouseP,mouse,poczatek,window,myClock);
        while(window.isOpen()){
            window.clear();
            //Event myevent;
            myevent=window.pollEvent();
            while(myevent!=null){
                switch(myevent.type){
                    case CLOSED:
                       window.close();
                       break;
                    case KEY_PRESSED:
                        if(myevent.asKeyEvent().key==Keyboard.Key.SPACE){
                           x++;
                           if(x>10){
                           window.draw(tab.get(0));
                           }else{
                               window.draw(tab.get(1));
                           }
                           chojarrow=new Arrow(mouseP,mouse,poczatek,window,myClock);
                           
                        }
                        if(myevent.asKeyEvent().key==Keyboard.Key.RIGHT){
                           view2.move(50,0);
                           window.setView(view2);                       
                        }
                        if(myevent.asKeyEvent().key==Keyboard.Key.LEFT){
                           view2.move(-50,0);
                           window.setView(view2);  
                        }
                        if(myevent.asKeyEvent().key==Keyboard.Key.UP){
                            view2.move(0,-50);
                           window.setView(view2);  
                           
                        }
                        if(myevent.asKeyEvent().key==Keyboard.Key.DOWN){
                            view2.move(0,50);
                           window.setView(view2);  
                           
                        }
                        System.out.println(x);
                        break;
                    default:
                        break;

                }
                //chojarrow.update(window,view1,myClock);
                myevent=null; //CO to kurwa robi xdddddddddddddddddddddd
            }
            //window.draw(mySprite);
            //window.clear();
            //window.draw(mySprite);
            //chojback.displayBackground(window);
            chojarrow.update(window,view1,myClock);
            //window.draw(tab.get(0));
            window.draw(chojarrow);
            //window.draw(tab.get(0));
            chojback.displayBackground(window);
            window.display();
        }
        System.out.println(x);
    }
    
}
