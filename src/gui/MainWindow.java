package gui;

import gui.components.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.Timer;

public class MainWindow extends JFrame{
    private static final Dimension windowSize = new Dimension(1920, 1080);
    private static final Dimension appSize = new Dimension(windowSize.width, 200);
    private String mainPath;
    public DesignController design;
    
    
    Timer t = new Timer(1000, new ReloadPage());
    
    ArrayList<AppPanel> panels;
 
    public MainWindow() {
        super("WorkBar");
            init();
            addComponents();

            // default open/close window
            design.setMainWindowDesign(this, DesignController.NORMAL);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setVisible(true);

            t.start();
    }
    
    private void init() {
        panels = new ArrayList<AppPanel>();
        setPath("~/");
        design = new DesignController(DesignController.NORMAL);
        
        // window size and location on the screen
        setSize(appSize);
        setLocation(new Point(0, (windowSize.height - appSize.height)));
        
        // Some design twik's
        setUndecorated(true); // remove the top bar
        setAlwaysOnTop(true); // made the window alway's show on top of every other window
        setResizable(false); // dont allow user's to resize
        
        // set layout
        GridLayout mainLayout = new GridLayout(1,4,50,0);
        setLayout(mainLayout);
    }

    private void addComponents() {
        ClockPanel panel1 = new ClockPanel(this);
        NotesPanel panel2 = new NotesPanel(this);
        GitHubPanel panel3 = new GitHubPanel(this);
        ButtonsPanel panel4 = new ButtonsPanel(this);
        
        panels.add(panel1);
        add(panel1);
        panels.add(panel2);
        add(panel2);
        panels.add(panel3);
        add(panel3);
        panels.add(panel4);
        add(panel4);
    }
    
    public void refreshDesign() {
        design.setMainWindowDesign(this, DesignController.NORMAL);
        for(AppPanel app : panels){
            try {
                app.designUpdate();
            } catch (Exception ex) {System.out.println("ERROR refresh design:" +ex.getMessage());}
        }
        
    }
    
    protected class ReloadPage implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for(AppPanel app : panels){
                try {
                    app.update();
                } catch (Exception ex) {
                    System.out.println("ERROR UPDATE: "+ex.getMessage());
                }
            }
        }
    }
    
    public String getPath() {
        return mainPath;
    }

    public void setPath(String mainPath) {
        this.mainPath = mainPath;
    }
    
}
