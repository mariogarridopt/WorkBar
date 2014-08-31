package gui.components;

import app.*;
import gui.MainWindow;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class ClockPanel extends AppPanel{
    private String time;
    private DevLabel timeLabel, dateLabel, realtimeLabel;
    private DevLabel timestamp1, timestamp2;
    private DevButton taketimestamp;
    
    private Clock clock;
    
    public ClockPanel(MainWindow main) {
        super(new GridLayout(6,1), main);
        setOpaque(false); // default opac settings
        
        init();
    }
    
    private void init()  {
        clock = new Clock();
        timeLabel = new DevLabel(clock.getPastTime(), DevLabel.SET_CENTER ,40, mainFrame.design);
        realtimeLabel = new DevLabel(clock.getCurrentTime()+"  GTM+0", DevLabel.SET_CENTER ,15, mainFrame.design);
        dateLabel = new DevLabel(clock.getDate() ,DevLabel.SET_CENTER ,15, mainFrame.design);
        timestamp1 = new DevLabel("", DevLabel.SET_CENTER ,20, mainFrame.design);
        timestamp2 = new DevLabel("", DevLabel.SET_CENTER ,20, mainFrame.design);
        taketimestamp = new DevButton("Take Time stamp", mainFrame.design);
        taketimestamp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timestamp2.setText(timestamp1.getText());
                timestamp1.setText(timeLabel.getText() + "   " + realtimeLabel.getText() + "   " + dateLabel.getText());
            }
        });
        
        timeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        timeLabel.addMouseListener(new MouseAdapter() {  
    public void mouseClicked(MouseEvent e) {  
        String s = (String)JOptionPane.showInputDialog(timeLabel, "Select the initial time:", "Set time", JOptionPane.PLAIN_MESSAGE, null, null, clock.toString());
        if ((s != null) && (s.length() > 0)) {
            clock.setStartTime(s);
        }
    }  
}); 
        
        add(realtimeLabel);
        add(timeLabel);
        add(dateLabel);
        add(timestamp1);
        add(timestamp2);
        add(taketimestamp);
    }

    @Override
    public void update() {
        timeLabel.setText(clock.getPastTime());
        realtimeLabel.setText(clock.getCurrentTime() + "  GTM+0");
        dateLabel.setText(clock.getDate());
    }    

    @Override
    public void designUpdate() throws Exception {
        realtimeLabel.refresh();
        timeLabel.refresh();
        dateLabel.refresh();
        timestamp1.refresh();
        timestamp2.refresh();
        taketimestamp.refresh();
    }
}
