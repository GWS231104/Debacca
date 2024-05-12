package Cosmetics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class JPanelRound extends JPanel {
    private int roundTopLeft = 0;


    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
        repaint();
    }

    public JPanelRound() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());

        // Create an area with rounded corners for the entire panel
        Area area = new Area(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(),
                roundTopLeft, roundTopLeft));

  

        g2d.fill(area);
        g2d.dispose();
    }
}
