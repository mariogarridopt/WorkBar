package gui.components;


import gui.MainWindow;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class NotesPanel extends AppPanel{
    JTextPane text;
    
    public NotesPanel(MainWindow main) {
        super(new BorderLayout(), main);
        setOpaque(false); // default opac settings
        
        init();
    }
    
    public void init() {
        Font myforn = new Font("Sans Serif", Font.PLAIN, 20);
        
        text = new JTextPane();
        mainFrame.design.setJTextPaneDesign(text, DesignController.LIGHT);
        
        text.setEditable(false);
        text.setText("\n\n\nWebCam");
        StyledDocument doc = text.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        
        add(BorderLayout.CENTER, text);
    }

    @Override
    public void update() {
       // Nothing to do
    }

    @Override
    public void designUpdate() throws Exception {
        mainFrame.design.setJTextPaneDesign(text, DesignController.LIGHT);
    }
    
}
