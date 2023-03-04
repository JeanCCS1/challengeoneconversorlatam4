package com.jean;

public class App 
{
    public static void main( String[] args )
    {
        Intefraz intefraz = new Intefraz("Bienvenido",400,400);
        intefraz.add(new Menu(intefraz),"Menu");
    }
}
