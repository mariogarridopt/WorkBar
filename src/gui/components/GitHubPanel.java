package gui.components;

import app.GitInfo;
import gui.MainWindow;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class GitHubPanel extends AppPanel{
    private DevLabel commit1, commit2, commit3, info1, info2, resp1, resp2;
    private GridLayout layout;
    private JPanel showInfo1, showInfo2;
    
    private GitInfo git;
    
    private JFileChooser fc;
    private DevButton bt;
    
    private int cycle_timer = 20;
    
    public GitHubPanel(MainWindow main) {
        super(new GridLayout(6,1), main);
        setOpaque(false); // default opac settings
        
        init();
    }
    
    private void init() {
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        bt = new DevButton("Choose Repository", mainFrame.design);
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = fc.showOpenDialog(null);
        
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    mainFrame.setPath(fc.getSelectedFile().getPath());
                    git = new GitInfo(mainFrame.getPath());
                    cycle_timer = -1;
                }
            }
        });
        
        git = new GitInfo(mainFrame.getPath());
        ArrayList<String> r = git.getLastCommits();
        if(!r.isEmpty()){
            commit1 = new DevLabel("- "+r.get(0).substring(8), mainFrame.design);
            commit2 = new DevLabel("- "+r.get(1).substring(8), mainFrame.design);
            commit3 = new DevLabel("- "+r.get(2).substring(8), mainFrame.design);
        }else {
            commit1 = new DevLabel("- ", mainFrame.design);
            commit2 = new DevLabel("- ", mainFrame.design);
            commit3 = new DevLabel("- ", mainFrame.design);
        }
        
        info1 = new DevLabel("Commits: ", mainFrame.design);
        resp1 = new DevLabel(""+git.numOfCommits(), mainFrame.design);
        info2 = new DevLabel("Branch: ", mainFrame.design);
        resp2 = new DevLabel(git.currentBranch(), mainFrame.design);
        
        layout = new GridLayout(1,2);
        showInfo1 = new JPanel(layout);
        showInfo2 = new JPanel(layout);
        showInfo1.setOpaque(false);
        showInfo2.setOpaque(false);
        
        showInfo1.add(info1);
        showInfo1.add(resp1);
        showInfo2.add(info2);
        showInfo2.add(resp2);
        
        add(commit1);
        add(commit2);
        add(commit3);
        add(showInfo1);
        add(showInfo2);
        add(showInfo2);
        add(bt);
        
        
    }
    
    @Override
    public void update() {
        if(cycle_timer < 0){
            ArrayList<String> r = git.getLastCommits();
            if(!r.isEmpty()){
                commit1.setText("- "+r.get(0).substring(8));
                commit2.setText("- "+r.get(1).substring(8));
                commit3.setText("- "+r.get(2).substring(8));
            }
            
            resp1.setText(""+git.numOfCommits());
            resp2.setText(git.currentBranch());
            
            cycle_timer = 100;
        }else cycle_timer--;
    }

    @Override
    public void designUpdate() throws Exception {
        commit1.refresh();
        commit2.refresh();
        commit3.refresh();
        info1.refresh();
        info2.refresh();
        resp1.refresh();
        resp2.refresh();
        bt.refresh();
    }
    
}
