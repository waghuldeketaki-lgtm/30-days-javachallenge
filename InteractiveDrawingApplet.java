*****InteractiveDrawingApplet.java***


import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

// Program Name: InteractiveDrawingApplet
public class InteractiveDrawingApplet extends Applet 
    implements ActionListener, MouseListener, MouseMotionListener 
{
    private int x1, y1, x2, y2;
    private String shape = "Line";
    private Color color = Color.BLACK;

    private Button lineBtn, rectBtn, ovalBtn, clearBtn;
    private Choice colorChoice;

    public void init() 
    {
        setLayout(new FlowLayout());

        lineBtn = new Button("Line");
        rectBtn = new Button("Rectangle");
        ovalBtn = new Button("Oval");
        clearBtn = new Button("Clear");

        colorChoice = new Choice();
        colorChoice.add("Black");
        colorChoice.add("Red");
        colorChoice.add("Blue");
        colorChoice.add("Green");

        add(lineBtn);
        add(rectBtn);
        add(ovalBtn);
        add(clearBtn);
        add(colorChoice);

        lineBtn.addActionListener(this);
        rectBtn.addActionListener(this);
        ovalBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == lineBtn)
            shape = "Line";
        else if (e.getSource() == rectBtn)
            shape = "Rectangle";
        else if (e.getSource() == ovalBtn)
            shape = "Oval";
        else if (e.getSource() == clearBtn)
            repaint();

        String selected = colorChoice.getSelectedItem();
        if (selected.equals("Red")) color = Color.RED;
        else if (selected.equals("Blue")) color = Color.BLUE;
        else if (selected.equals("Green")) color = Color.GREEN;
        else color = Color.BLACK;
    }

    public void paint(Graphics g) 
    {
        g.setColor(color);

        if (shape.equals("Line"))
            g.drawLine(x1, y1, x2, y2);
        else if (shape.equals("Rectangle"))
            g.drawRect(Math.min(x1, x2), Math.min(y1, y2),
                       Math.abs(x2 - x1), Math.abs(y2 - y1));
        else if (shape.equals("Oval"))
            g.drawOval(Math.min(x1, x2), Math.min(y1, y2),
                       Math.abs(x2 - x1), Math.abs(y2 - y1));
    }

    public void mousePressed(MouseEvent e) 
    {
        x1 = e.getX();
        y1 = e.getY();
    }

    public void mouseReleased(MouseEvent e) 
    {
        x2 = e.getX();
        y2 = e.getY();
        repaint();
    }

    public void mouseDragged(MouseEvent e) 
    {
        x2 = e.getX();
        y2 = e.getY();
        repaint();
    }

    // Unused methods
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
}
