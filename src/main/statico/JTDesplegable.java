
package main.statico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;


public class JTDesplegable extends Timer{
    private final int actualY;
    private int actualX;
    
    public JTDesplegable(int intervalo, int distancia, int inicial, int limite, JPanel Desplegable, ActionListener al) {
        super(intervalo, al);
        
        this.actualY = Desplegable.getY();
        this.actualX = Desplegable.getX();
        addActionListener((ActionEvent ae) -> {
            
            if (inicial < limite) {
                JTDesplegableActionRight(distancia, limite, Desplegable);
            }else{
                JTDesplegableActionLeft(distancia, limite, Desplegable);
            }
        });
    }
    
    private void JTDesplegableActionLeft(int distancia, int limite, JPanel Desplegable){
        this.actualX -= distancia;
        
        Desplegable.setLocation(this.actualX, actualY);
        
        if (actualX <= limite) {
            stop();
        }
    }
    private void JTDesplegableActionRight(int distancia, int limite, JPanel Desplegable){
        this.actualX += distancia;
        
        Desplegable.setLocation(actualX, actualY);
        
        if (this.actualX >= limite) {
            stop();
        }
    }

}
