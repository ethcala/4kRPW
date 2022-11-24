package net.mightypork.rpw.gui.widgets;

import net.mightypork.rpw.gui.Gui;

import javax.swing.*;
import java.awt.*;


public class HBox extends RpwBox {
    public HBox() {
        super(BoxLayout.X_AXIS);
    }


    @Override
    public void gap_small() {
        add(Gui.hgap_small());
    }


    @Override
    public void gap_large() {
        add(Gui.hgap_large());
    }


    @Override
    public void glue() {
        add(Gui.hglue());
    }


    @Override
    public JSeparator sep() {
        JSeparator sep;
        add(sep = new JSeparator(SwingConstants.VERTICAL));

        // BEHOLD, MAGIC
        // ugly fix for Swing bug (separator with weird size)
        // http://stackoverflow.com/a/7515903/2180189
        final Dimension size = new Dimension(sep.getPreferredSize().width, sep.getMaximumSize().height);
        sep.setMaximumSize(size);

        return sep;
    }
}
