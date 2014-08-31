package gui.components;

import app.GitInfo;
import app.ShellCommand;
import gui.MainWindow;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class ButtonsPanel extends AppPanel{
    private JPanel opt1, opt2, opt3, main_opt;
    JTextPane text;
    private DevButton[] buttons;
    private int cycle_timer = 30;
    
    private GitInfo git;
    private boolean gitworking;
    
    public ButtonsPanel(MainWindow main) {
        super(new BorderLayout(), main);
        setOpaque(false); // default opac settings
        
        init();
    }
    
    private void init() {
        git = new GitInfo(""); // raspberrypi/linux
        gitworking = false;
        buttons = new DevButton[4];
        loadButtons();

        
        opt1 = new JPanel(new GridLayout(1,2));
        opt2 = new JPanel(new GridLayout(1,2));
        for (int i = 0; i < buttons.length; i++) {
            mainFrame.design.setButtonDesign(buttons[i], DesignController.LIGHT);
            
            if(i < 2){
                opt1.setOpaque(false);
                opt1.add(buttons[i]);
            }else{
                opt2.setOpaque(false);
                opt2.add(buttons[i]);
            }
        }
        
        main_opt = new JPanel(new GridLayout(2,1));
        main_opt.setOpaque(false);
        
        main_opt.add(opt1);
        main_opt.add(opt2);
        
        Font myforn = new Font("Sans Serif", Font.PLAIN, 20);
        
        text = new JTextPane();
        mainFrame.design.setJTextPaneDesign(text, DesignController.LIGHT);
        
        text.setText("Programming...");
        
        add(BorderLayout.CENTER, text);
        
        add(BorderLayout.SOUTH,main_opt);
    }
    
    private void loadButtons() {
        
        buttons[0] = new DevButton("Hidden files visible", mainFrame.design);
        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShellCommand.exec("defaults write com.apple.finder AppleShowAllFiles YES");
                ShellCommand.exec("killall -KILL Finder");
            }
        });
        
        buttons[1] = new DevButton("Hidden files invisible", mainFrame.design);
        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShellCommand.exec("defaults write com.apple.finder AppleShowAllFiles NO");
                ShellCommand.exec("killall -KILL Finder");
            }
        });
        
        buttons[2] = new DevButton("Launch Shell", mainFrame.design);
        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShellCommand.exec("open -n /Applications/Utilities/Terminal.app --args -AppCommandLineArgopen");
            }
        });
      
        buttons[3] = new DevButton("Options", mainFrame.design);
        buttons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int st = mainFrame.design.getStyle();
                mainFrame.design.setStyle(((st == -1) ? 0 : -1));
                mainFrame.refreshDesign();
            }
        });
    }

    @Override
    public void update() {}

    @Override
    public void designUpdate() throws Exception {
        for (DevButton devButton : buttons) {
            mainFrame.design.setButtonDesign(devButton, DesignController.LIGHT);
            mainFrame.design.setJTextPaneDesign(text, DesignController.LIGHT);
        }
    }
}
