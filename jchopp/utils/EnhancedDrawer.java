package jchopp.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class EnhancedDrawer {
    /**
     *  Useful methods for drawing different more complex details.
     */

    /**
     * Draws a circle with the center in a specific point.
     * @param g ~ Graphics;
     * @param x ~ x coordinate of the specific point;
     * @param y ~ y coordinate of the specific point;
     * @param r ~ radius of the circle;
     * @param col ~ filling color;
     */
    public static void drawCenteredCircle(Graphics g, int x, int y, int r, Color col) {
        x = x - (r / 2);
        y = y - (r / 2);
        g.setColor(col);
        g.fillOval(x, y, r, r);
    }

    /**
     * Parses an RGB color from the specific format.
     * @param hex ~ Color string in the format '#abcdef';
     * @return parsed color.
     */
    public static Color parseColorRGB(final String hex) {
        return new Color(Integer.parseInt(hex.substring(1), 16));
    }

    /**
     * Draws a string centred in a rectangle with a specific font.
     * @param g ~ Graphics;
     * @param text ~ test to be drawn;
     * @param rect ~ rectangle into which the text will be centered;
     * @param font ~ the font chosen for the text;
     */
    public static void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);

        int x = (int)(rect.getX() + (rect.getWidth() - metrics.stringWidth(text)) / 2);
        int y = (int)(rect.getY() + ((rect.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent());

        g.setFont(font);

        g.drawString(text, x, y);
    }

}
