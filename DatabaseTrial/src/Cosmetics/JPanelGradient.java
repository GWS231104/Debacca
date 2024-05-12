package Cosmetics;


import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class JPanelGradient extends JPanel {
    
    private Color colorStart = Color.BLACK;
    private Color colorEnd = Color.WHITE;

    public Color getColorStart() {
        return colorStart;
    }

    public void setColorStart(Color colorStart) {
        this.colorStart = colorStart;
    }

    public Color getColorEnd() {
        return colorEnd;
    }

    public void setColorEnd(Color colorEnd) {
        this.colorEnd = colorEnd;
    }
        
    public JPanelGradient() {   
    }
    
    @Override    
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(0, 0, colorStart, getWidth(), getHeight(), colorEnd);
        g2.setPaint(gradient);
        g2.fillRect(0, 0, getWidth(), getHeight());
       
    }
}
