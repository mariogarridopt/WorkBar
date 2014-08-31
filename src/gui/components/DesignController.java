package gui.components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class DesignController {
    private final Color BlackForeground = Color.BLACK;
    private final Color WhiteForeground = Color.WHITE;
    
    private final Color BlackBackground_LIGHT = new Color(0, 0, 0, (float) 0.1);
    private final Color WhiteBackground_LIGHT = new Color(1, 1, 1, (float) 0.1);
    private final Color BlackBackground_NORMAL = new Color(0, 0, 0, (float) 0.3);
    private final Color WhiteBackground_NORMAL = new Color(1, 1, 1, (float) 0.3);
    private final Color BlackBackground_STRONG = new Color(0, 0, 0, (float) 0.5);
    private final Color WhiteBackground_STRONG = new Color(1, 1, 1, (float) 0.5);

    public static final int LIGHT = 0;
    public static final int NORMAL = 1;
    public static final int STRONG = 3;
    
    public static final int INVERT = -1;
    
    private int style;
    
    public DesignController(int style){
        this.style = style;
    }

    public void setButtonDesign(JButton btn, int type) {
        btn.setBorderPainted(false);
        btn.setOpaque(true);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        switch (type) {
            case LIGHT:
                if(getStyle() == INVERT){
                    btn.setBackground(WhiteBackground_LIGHT);
                    btn.setForeground(BlackForeground);
                }else{
                    btn.setBackground(BlackBackground_LIGHT);
                    btn.setForeground(WhiteForeground);
                }
                break;
            case STRONG:
                if(getStyle() == INVERT){
                    btn.setBackground(WhiteBackground_STRONG);
                    btn.setForeground(BlackForeground);
                }else{
                    btn.setBackground(BlackBackground_STRONG);
                    btn.setForeground(WhiteForeground);
                }
            break;
            default:
                if(getStyle() == INVERT){
                    btn.setBackground(WhiteBackground_NORMAL);
                    btn.setForeground(BlackForeground);
                }else{
                    btn.setBackground(BlackBackground_NORMAL);
                    btn.setForeground(WhiteForeground);
                }
            break;
        }
    }
    
     public void setMainWindowDesign(JFrame frame, int type) {
        switch (type) {
            case LIGHT:
                if(getStyle() == INVERT){
                    frame.setBackground(WhiteBackground_LIGHT);
                }else{
                    frame.setBackground(BlackBackground_LIGHT);
                }
                break;
            case STRONG:
                if(getStyle() == INVERT){
                    frame.setBackground(WhiteBackground_STRONG);
                }else{
                    frame.setBackground(BlackBackground_STRONG);
                }
            break;
            default:
                if(getStyle() == INVERT){
                    frame.setBackground(WhiteBackground_NORMAL);
                }else{
                    frame.setBackground(BlackBackground_NORMAL);
                }
            break;
        }
    }
     
     public void setLabelDesign(JLabel lbl) {
        if(getStyle() == INVERT){
            lbl.setForeground(BlackForeground);
        }else{
            lbl.setForeground(WhiteForeground);
        }
    }
     
     public void setTextAreaDesign(JTextArea txt, int type) {
         Font myforn = new Font("Sans Serif", Font.PLAIN, 20);
        txt.setOpaque(true);
        txt.setBorder(new LineBorder(new Color(0, 0, 0, (float) 0.0), 10, true));
        txt.setFont(myforn);
        
        switch (type) {
            case LIGHT:
                if(getStyle() == INVERT){
                     txt.setBackground(WhiteBackground_LIGHT);
                     txt.setForeground(BlackForeground);
                }else{
                    txt.setBackground(BlackBackground_LIGHT);
                    txt.setForeground(WhiteForeground);
                }
                break;
            case STRONG:
                if(getStyle() == INVERT){
                     txt.setBackground(WhiteBackground_STRONG);
                     txt.setForeground(BlackForeground);
                }else{
                    txt.setBackground(BlackBackground_STRONG);
                    txt.setForeground(WhiteForeground);
                }
            break;
            default:
                if(getStyle() == INVERT){
                     txt.setBackground(WhiteBackground_NORMAL);
                     txt.setForeground(BlackForeground);
                }else{
                    txt.setBackground(BlackBackground_NORMAL);
                    txt.setForeground(WhiteForeground);
                }
            break;
        }
    } 
     
     public void setJTextPaneDesign(JTextPane txt, int type) {
         Font myforn = new Font("Sans Serif", Font.PLAIN, 20);
        txt.setOpaque(true);
        txt.setBorder(new LineBorder(new Color(0, 0, 0, (float) 0.0), 10, true));
        txt.setFont(myforn);
        
        switch (type) {
            case LIGHT:
                if(getStyle() == INVERT){
                     txt.setBackground(WhiteBackground_LIGHT);
                     txt.setForeground(BlackForeground);
                }else{
                    txt.setBackground(BlackBackground_LIGHT);
                    txt.setForeground(WhiteForeground);
                }
                break;
            case STRONG:
                if(getStyle() == INVERT){
                     txt.setBackground(WhiteBackground_STRONG);
                     txt.setForeground(BlackForeground);
                }else{
                    txt.setBackground(BlackBackground_STRONG);
                    txt.setForeground(WhiteForeground);
                }
            break;
            default:
                if(getStyle() == INVERT){
                     txt.setBackground(WhiteBackground_NORMAL);
                     txt.setForeground(BlackForeground);
                }else{
                    txt.setBackground(BlackBackground_NORMAL);
                    txt.setForeground(WhiteForeground);
                }
            break;
        }
    } 

    /**
     * @return the style
     */
    public int getStyle() {
        return style;
    }

    /**
     * @param style the style to set
     */
    public void setStyle(int style) {
        this.style = style;
    }
}
