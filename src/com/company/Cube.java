package com.company;

import java.awt.*;

public class Cube
{
    private Facet[] facets;
    public Cube()
    {
        facets = new Facet[6];
        facets[0] = new Facet(new R3Vector(0,0,0), new R3Vector(1,0,0), new R3Vector(1,1,0), new R3Vector(0,1,0));
        facets[1] = new Facet(new R3Vector(1,0,1), new R3Vector(1,1,1), new R3Vector(1,1,0), new R3Vector(1,0,0));
        facets[2] = new Facet(new R3Vector(0,0,0), new R3Vector(0,1,0), new R3Vector(0,1,1), new R3Vector(0,0,1));
        facets[3] = new Facet(new R3Vector(0,0,0), new R3Vector(0,0,1), new R3Vector(1,0,1), new R3Vector(1,0,0));
        facets[4] = new Facet(new R3Vector(0,1,0), new R3Vector(1,1,0), new R3Vector(1,1,1), new R3Vector(0,1,1));
        facets[5] = new Facet(new R3Vector(0,0,1), new R3Vector(0,1,1), new R3Vector(1,1,1), new R3Vector(1,0,1));
        facets[0].setColor(Color.yellow);
        facets[1].setColor(Color.blue);
        facets[2].setColor(Color.red);
        facets[3].setColor(Color.magenta);
        facets[4].setColor(Color.green);
        facets[5].setColor(Color.gray);


    }
    public void scale(double k)
    {
        for ( int i = 0 ; i < facets.length;
        i++)
        {
            facets[i].scale(k);
        }
    }
    public void translate(double x, double y, double z)
    {
        for ( int i = 0 ; i < facets.length;
              i++)
        {
            facets[i].translate(x,y,z);
        }
    }
    public void rotate(double dx, double dy, double dz)
    {
        for ( int i = 0 ; i < facets.length;
              i++)
        {
            facets[i].rotate(dx,dy,dz);
        }
    }
    public void draw(Graphics2D g)
    {
        for ( int i = 0 ; i < facets.length;
              i++)
        {
            facets[i].draw(g);
        }
    }
    public void drawPers(Graphics2D g, double k)
    {
        for ( int i = 0 ; i < facets.length;
              i++)
        {
            facets[i].drawPers(g,k);
        }
    }
}
