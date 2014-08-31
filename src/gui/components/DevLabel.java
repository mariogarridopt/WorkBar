package gui.components;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DevLabel extends JLabel {
    private DesignController dc;

    public static final int SET_CENTER = SwingConstants.CENTER;
    public static final int SET_LEFT = SwingConstants.LEFT;
    public static final int SET_RIGHT = SwingConstants.RIGHT;

    public DevLabel(String str, DesignController dc) {
        this(str, 20, dc);
    }

    public DevLabel(String str, int size, DesignController dc) {
        this(str, SET_LEFT, size, dc);
    }

    public DevLabel(String str, int align, int size, DesignController dc) {
        super(str);
        this.dc = dc;
        conf();
        setFontSize(size);
        setHorizontalAlignment(align);
    }

    private void conf() {
        dc.setLabelDesign(this);
    }

    private void setFontSize(int size) {
        setFont(new Font("Sans Serif", Font.PLAIN, size));
    }
    
    public void refresh(){
        conf();
    }
}
