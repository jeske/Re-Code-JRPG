package com.namone.simplegui;

/**
 * Created by David on 1/3/2015.
 */
public abstract class Component {
    public float locx,locy;
    public float width,height;

    public abstract void draw();
    public abstract void mouseDown();
}
