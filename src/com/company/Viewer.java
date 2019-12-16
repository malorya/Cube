package com.company;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class Viewer extends JFrame {
    private Cube cube;
    private Container pane;
    private JPanel renderPanel;
    public JSlider vslider,vslider1;
    public Viewer( Cube c)
    {
        cube = c;
        setSize(800, 800);
        pane = this.getContentPane();
        pane.setLayout(new BorderLayout());

        renderPanel = new JPanel()
        {
            @Override
            public void paintComponent(Graphics gr)
            {
            Graphics2D g =(Graphics2D)gr;
            g.translate(getWidth()/2, getHeight()/2);
            g.setColor(Color.white);
            g.fillRect(-getWidth()/2, -getHeight()/2, getWidth(), getHeight());
            g.setColor(Color.black);
            cube.drawPers(g, 500);
            }
        };

        pane.add(renderPanel,BorderLayout.CENTER);
        vslider = new JSlider(SwingConstants.VERTICAL, 0, 100 ,50);
        pane.add(vslider,BorderLayout.EAST);
        vslider1 = new JSlider(SwingConstants.HORIZONTAL,0,100,50);
        pane.add(vslider1, BorderLayout.SOUTH);
        vslider.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                int step = vslider.getValue();
                cube.rotate(step, 0, 0);
                repaint();
            }
        });
        vslider1.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                int step = vslider1.getValue();
                cube.rotate(step, 0, 0);
                repaint();
            }
        });

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /*@Override
    public void paint(Graphics gr)
    {
    Graphics2D g =(Graphics2D)gr;
    g.translate(getWidth()/2, getHeight()/2);
    g.setColor(Color.white);
    g.fillRect(-getWidth()/2, -getHeight()/2, getWidth(), getHeight());
    g.setColor(Color.black);
    cube.drawPers(g, 500);
    }*/

}
