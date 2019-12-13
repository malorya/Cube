package com.company;


public class Main
{
    public static void main(String[] args) {
        R3Vector a = new R3Vector(10, 20, 30);
        R3Vector b = new R3Vector(30, 20, 10);
        a.out();
        //(a.sum(a).sum(a.sum(a))).out();
        R3Vector.sum(R3Vector.sum(a, a), a).out();
        System.out.println("Скалярное произведение =");
        System.out.println(R3Vector.Scalar(a, b));
        System.out.println("Векторное произведение =");
        R3Vector c = R3Vector.Vvect(a, b);
        c.out();
        b.out();
        b.mash(10);
        b.out();
        b.rotate(0, 0, 180);
        b.out();
        Facet f = new Facet(new R3Vector(0, 0, 0), new R3Vector(1, 0, 0), new R3Vector(1, 1, 0), new R3Vector(0, 1, 0));
        f.print();
        R3Vector d = f.VectNormal();
        d.out();
        Cube k = new Cube();
        k.scale(200);
        k.rotate(45,30,90);
        Viewer v = new Viewer(k);
    }
}
