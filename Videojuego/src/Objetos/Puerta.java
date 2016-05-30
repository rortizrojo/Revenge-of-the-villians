/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;


import Armas.Punto;
import Armas.Sprite;
import Armas.SpriteMovil;
import Armas.Vector;
import Engine.GestorColision;
import Engine.IColisionable;
import Personajes.Personaje;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import java.awt.Font;
/**
 *
 * @author Usuario
 */
public class Puerta implements IColisionable {

    
    private Rectangle areaColision; 
    private SpriteSheet sheetPuerta;
    private Animation animationPuerta;
    private float anchoSprite;
    private float altoSprite;
    private float anchoDibujado;
    private float altoDibujado;
    private int numeroFrames;
    private float posPuertaX;
    private float posPuertaY;
    private float posIniX;
    private float posIniY;
    private GestorColision gestor;
    
        
    public Puerta(float x, float y, float velocidad, GestorColision gestor) throws SlickException{
        
    
        this.posPuertaX = x;
        this.posPuertaY = y;
        this.gestor = gestor;

        anchoSprite = 122;
        altoSprite = 123;
        anchoDibujado = anchoSprite *1f;
        altoDibujado = altoSprite *1f;
        
        animationPuerta = new Animation();
        sheetPuerta = new SpriteSheet("res/animations/animation.png", (int) anchoSprite, (int) altoSprite);
        animationPuerta = new Animation();
         numeroFrames = 2;
       for (int i = 1; i >=0; i--) {
            animationPuerta.addFrame(sheetPuerta.getSprite(i, 0), 150);
        }
        areaColision = new Rectangle(x,y,anchoDibujado,altoDibujado);
        gestor.registrarCuerpo(this);
    }
    
    public void setPosicion(float x, float y){
        posPuertaX = x;
        posPuertaY = y;
        
    }
       
    public void draw(){


        animationPuerta.draw(posPuertaX, posPuertaY, anchoDibujado, altoDibujado);

        
    }
    
    
    public void update(int delta){
        
        
        sincronizarArea();
    }

            
    @Override
    public Shape getAreaColision() {
        return areaColision;
    }

    @Override
    public void alColisionar(IColisionable colision) {
       
    }

    @Override
    public void sincronizarArea() {
        areaColision.setX(posPuertaX);
        areaColision.setY(posPuertaY);
    }
    
}
