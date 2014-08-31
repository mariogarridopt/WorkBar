package gui.components;

import javax.swing.JButton;

public class DevButton extends JButton{
    private DesignController dc;
    public DevButton(String str, DesignController dc) {
        super(str);
        this.dc = dc;
        init();
    }
    
    private void init() {
        dc.setButtonDesign(this, DesignController.NORMAL);
    }
    
    public void refresh(){
        init();
    }
}
