package gui.components;

import gui.MainWindow;
import java.awt.LayoutManager;
import javax.swing.JPanel;

public abstract class AppPanel extends JPanel {
    protected MainWindow mainFrame;
    
    protected AppPanel(LayoutManager layout, MainWindow mainFrame){
        super(layout);
        this.mainFrame = mainFrame;
    }
    
    public abstract void update() throws Exception;
    
    public abstract void designUpdate() throws Exception;
}
