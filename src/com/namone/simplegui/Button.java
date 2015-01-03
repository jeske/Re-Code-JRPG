package com.namone.simplegui;

import org.newdawn.slick.Image;

/**
 * Created by David on 1/3/2015.
 */
public class Button extends Component {
    float locx,locy;
    Image btnImage;

    public interface ButtonAction {
        public void onClick();
    }

    ButtonAction action;

    public Button(Image btnImage, float locx, float locy, ButtonAction action) {
        this.action = action;
        this.locx = locx;
        this.locy = locy;
        this.btnImage = btnImage;
        this.width = btnImage.getWidth();
        this.height = btnImage.getHeight();
    }

    @Override
    public void draw() {
        btnImage.draw(locx,locy);
    }

    @Override
    public void mouseDown() {
        if (this.action != null) {
            this.action.onClick();
        }
    }
}
