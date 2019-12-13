package com.company;

public class R3Vector
{
    private double x, y, z;
    public R3Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public R3Vector()
    {

    }
    public void out()
    {
        System.out.println("("+ x + ", "+ y + ", " + z +")");
    }
    public void print()
    {
        System.out.print("("+ x + ", "+ y + ", " + z +")");
    }
    public R3Vector sum(R3Vector a)
    {
        return new R3Vector(x+a.x, y+a.y, z+a.z);
    }

    public static R3Vector sum(R3Vector a, R3Vector b)
    {
        return new R3Vector(a.x+b.x, a.y+b.y, a.z+b.z);
    }
    public static  double Scalar(R3Vector a, R3Vector b)
    {
        return(a.x*b.x + a.y*b.y + a.z*b.z);
    }
    public static R3Vector Vvect(R3Vector a, R3Vector b)
    {
        return new R3Vector(a.y*b.z-a.z*b.y,a.z*b.x-a.x*b.z,a.x*b.y-a.y*b.x);
    }
    public void mash(double a)
    {
        x = x*a;
        y = y*a;
        z = z*a;
    }

    public void rotateX(double u) {
        double y0;
        double z0;
        y0 = y * Math.cos( Math.toRadians(u)) + z * Math.sin(Math.toRadians(u));
        z0 = z * Math.cos(Math.toRadians(u)) - y * Math.sin(Math.toRadians(u));
        y = y0;
        z = z0;
    }
    public void rotateY(double u) {
        double x0;
        double z0;
        x0 = x * Math.cos(Math.toRadians(u)) + z * Math.sin(Math.toRadians(u));
        z0 = z * Math.cos(Math.toRadians(u)) - x * Math.sin(Math.toRadians(u));
        x = x0;
        z = z0;
    }
    public void rotateZ(double u) {
        double x0;
        double y0;
        x0 = x * Math.cos(Math.toRadians(u)) + y * Math.sin(Math.toRadians(u));
        y0 = y * Math.cos(Math.toRadians(u)) - x * Math.sin(Math.toRadians(u));
        x = x0;
        y = y0;
    }
    public void rotate(double A, double B, double C)
    {
        rotateX(A);
        rotateY(B);
        rotateZ(C);
    }
    public static R3Vector perevod(R3Vector a, R3Vector b)
    {
      return new R3Vector(b.x-a.x,b.y-a.y,b.z-a.z);
    }
    public void moveX(double dx) {x += dx;}
    public void moveY(double dy) { y += dy;}
    public void moveZ(double dz) { z += dz;}
    public void move(double dx, double dy, double dz)
    {
        moveX(dx);
        moveY(dy);
        moveZ(dz);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
