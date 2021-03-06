package com.company;

import java.awt.*;
import java.awt.geom.Path2D;

public class Facet
{
        private R3Vector[] vertex;
        Color color;
        public Facet(R3Vector v1, R3Vector v2, R3Vector v3, R3Vector v4)
        {
            vertex = new R3Vector[4];
            vertex[0] = v1;
            vertex[1] = v2;
            vertex[2] = v3;
            vertex[3] = v4;
        }
        public void print()
        {
            for (int i = 0; i < 3; i++)
            {
                vertex[i].print();
                System.out.print("---");
                vertex[i+1].out();
            }
            vertex[3].out();
            System.out.print("---");
            vertex[0].out();
            System.out.println();
        }
        public R3Vector VectNormal()
        {
            R3Vector a = R3Vector.perevod(vertex[0], vertex[1]);
            R3Vector b = R3Vector.perevod(vertex[0], vertex[3]);
            return R3Vector.Vvect(a,b);
        }
        public void scale(double k)
        {
          for ( int i = 0 ; i < vertex.length; i++)
          {
            vertex[i].mash(k);
          }
        }
        public void translate(double dx, double dy, double dz)
        {
            for ( int i = 0 ; i < vertex.length;
                  i++)
            {
                vertex[i].move(dx,dy,dz);
            }
        }
        public void rotate(double dx, double dy, double dz)
        {
            for ( int i = 0 ; i < vertex.length;
                  i++)
            {
                vertex[i].rotate(dx,dy,dz);
            }
        }
        public void draw(Graphics2D g)
        {
            Path2D path = new Path2D.Double();
            path.moveTo(vertex[0].getX(), vertex[0].getY());
            path.lineTo(vertex[1].getX(), vertex[1].getY());
            path.lineTo(vertex[2].getX(), vertex[2].getY());
            path.lineTo(vertex[3].getX(), vertex[3].getY());
            path.lineTo(vertex[0].getX(), vertex[0].getY());
            path.closePath();
            g.draw(path);
        }
        public void drawPers(Graphics2D g, double k)
       {
        Path2D path = new Path2D.Double();
        double t[] = new double[4];
        t[0] = -k/(vertex[0].getZ()-k);
        t[1] = -k/(vertex[1].getZ()-k);
        t[2] = -k/(vertex[2].getZ()-k);
        t[3] = -k/(vertex[3].getZ()-k);
        R3Vector vector[] = new R3Vector[4];
        for (  int i=0; i<4; i++)
        {
            vector[i] = new R3Vector (vertex[i].getX()*t[i], vertex[i].getY()*t[i],vertex[i].getZ());
        }
           path.moveTo(vector[0].getX(), vector[0].getY());
           path.lineTo(vector[1].getX(), vector[1].getY());
           path.lineTo(vector[2].getX(), vector[2].getY());
           path.lineTo(vector[3].getX(), vector[3].getY());
           path.lineTo(vector[0].getX(), vector[0].getY());
           path.closePath();
           Facet facet = new Facet(vector[0], vector[1],vector[2], vector[3]);
           if (facet.light())
           {
               g.setColor(color);
               g.fill(path);
           }

       }
       public boolean light()
       {
           if (VectNormal().getZ() < 0)
           {
               return true;
           }
           else return false;
       }

    public void setColor(Color color)
    {
        this.color = color;
    }
}
