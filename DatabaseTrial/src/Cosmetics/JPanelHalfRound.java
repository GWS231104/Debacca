/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cosmetics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author hilmi
 */
public class JPanelHalfRound extends JPanel{
    
    private int roundTopLeft = 0;
    private int roundTopRight = 0;

    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
        repaint();

    }

    public int getRoundTopRight() {
        return roundTopRight;
    }

    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
        repaint();
    }
    
    public JPanelHalfRound() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        Area area = new Area(createRoundTopLeft());
        if (roundTopRight > 0){
            area.intersect(new Area(createRoundTopRight()));
        }

  

        g2d.fill(area);
        g2d.dispose();
    }
    
    private Shape createRoundTopLeft() {
        int width = getWidth();
        int height =getHeight();
        int roundX = Math.min(width, roundTopLeft);
        int roundY = Math.min(height, roundTopLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX/2, 0, width - roundX/2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY/2, width, height - roundY/2)));
        return area;
    }
    
    private Shape createRoundTopRight() {
        int width = getWidth();
        int height =getHeight();
        int roundX = Math.min(width, roundTopRight);
        int roundY = Math.min(height, roundTopRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX/2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY/2, width, height - roundY/2)));
        return area;
    }
}
