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
        Cube cube = new Cube();
        /*cube.scale(200);
        cube.translate(-50, -50, -50);
        cube.rotate(125,125,125);
        Viewer v = new Viewer(cube);
        Controller k = new Controller(cube,v);*/
        int scale = 200;
        cube.scale(scale);
        cube.translate(-scale/2, -scale/2, -scale/2);
        cube.rotate(125,125,125);//Если закомментируем, сможем проверить центр
        Viewer v = new Viewer(cube);
        Controller k = new Controller(cube,v);
    }
}
