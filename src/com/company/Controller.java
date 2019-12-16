package com.company;
import javax.swing.JSlider;
import javax.swing.event.*;


public class Controller{
    private JSlider vslider,vslider1;

    public Controller(Cube cube, Viewer v){
        this.vslider = v.vslider;
        vslider.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                int step = vslider.getValue();
                cube.rotate(step, 0, 0);
                v.repaint();
            }
        });
        this.vslider1 = v.vslider1;
        vslider1.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                int step = vslider1.getValue();
                cube.rotate(0, step, 0);
                v.repaint();
            }
        });

    }
}