package Cosmetics;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.EmptyBorder;

public class JButtonGradient extends JButton {
    private Color color1 = Color.BLACK;
    private Color color2 = Color.WHITE;

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }
    
    private boolean isRippling = false;

    public JButtonGradient() {
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setBorder(new EmptyBorder(10, 20, 10, 20));
        setFont(new Font("Segoe_UI", Font.BOLD, 15));

        // Add a mouse listener to handle the ripple animation
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isRippling = true;
                repaint();

                // Simulate a delay for the ripple effect
                new Thread(() -> {
                    try {
                        Thread.sleep(300); // Adjust the duration as needed
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    isRippling = false;
                    repaint();
                }).start();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Create an area with rounded corners for the entire button
        int cornerRadius = 30; // Adjust the corner radius as needed
        Shape roundedSquare = new RoundRectangle2D.Double(0, 0, width, height, cornerRadius, cornerRadius);
        Area area = new Area(roundedSquare);

        // Apply the ripple effect if clicked
        if (isRippling) {
            g2.setColor(new Color(255, 255, 255, 100)); // Semi-transparent white
            g2.fill(area);
        }

        // Apply the gradient background
        GradientPaint gra = new GradientPaint(0, 0, color1, width, 0, color2);
        g2.setPaint(gra);
        g2.fill(area);

        g2.dispose();
        super.paintComponent(g);
    }
}



