package drawingShit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class App /* extends JFrame */ {

    protected ArrayList<Shape> shapesList = new ArrayList<>();
    protected int kind = 0;
    protected Color color = Color.RED;
    protected boolean fill = true;
    protected Point startPoint = null, endPoint = null;
    protected DrawPanel drawPanel = new DrawPanel();
    JFrame frame = new JFrame("vevovan");

    public App() {

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        mainPanel.add(drawPanel);

        frame.setJMenuBar(new MenuOpt());
        frame.add(mainPanel);
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // contain option buttons
    class MenuOpt extends JMenuBar {
        public MenuOpt() {
            setBackground(Color.lightGray);
            JMenu fillOpt = new JMenu("Fill");
            JMenu ShapeMenu = new JMenu("Shape");
            JMenu ColorMenu = new JMenu("Color");
            JMenu ClearOpt = new JMenu("Erase");


            JMenuItem hollow = new JMenuItem("Hollow");
            hollow.addActionListener(e ->{
                fill = true;
            });
            JMenuItem outline = new JMenuItem("Outline");
            outline.addActionListener(e->{
                fill = false;
            });
            fillOpt.add(hollow); fillOpt.add(outline);


            JMenuItem line = new JMenuItem("Line");
            line.addActionListener(e->{
                kind = 0;
            });
            JMenuItem circle = new JMenuItem("Circle");
            circle.addActionListener(e->{
                kind = 1;
            });
            JMenuItem square = new JMenuItem("Square");
            square.addActionListener(e->{
                kind = 2;
            });
            JMenuItem triangle = new JMenuItem("Triangle");
            triangle.addActionListener(e->{
                kind = 3;
            });
            ShapeMenu.add(circle);ShapeMenu.add(square);ShapeMenu.add(triangle);


            String[] colorNames = {"Red", "Blue", "Green", "Yellow", "Black", "White"};
            Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.BLACK, Color.WHITE};
            for(int i =0 ; i<colorNames.length; i++){
                String name = colorNames[i]; Color setting = colors[i];
                JMenuItem currItem = new JMenuItem(name);
                currItem.addActionListener(e->{
                    color = setting;
                });
                ColorMenu.add(currItem);
            }


            JMenuItem clearAll = new JMenuItem("Clear");
            clearAll.addActionListener(e->{
                shapesList.clear();
                drawPanel.repaint();
            });
            ClearOpt.add(clearAll);

            add(fillOpt);add(ShapeMenu);add(ColorMenu);add(ClearOpt);
        }
    }

    // contain drawing listener
    class DrawPanel extends JPanel {
        public DrawPanel() {
            setBackground(Color.WHITE);
            MouseAdapter mouseAdapter = new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e){
                    startPoint = e.getPoint();
                    endPoint = startPoint;
                    if (kind != 0) { // Circle / Square (Continuous Mode)
                        shapesList.add(new Shape(kind, color, fill, startPoint, startPoint));
                        repaint();
                    }
                }

                @Override
                public void mouseDragged(MouseEvent e){
                    Point currentP = e.getPoint();
                    shapesList.add(new Shape(kind, color, fill, currentP, endPoint));
                    repaint();
                }
            };

            addMouseListener(mouseAdapter); addMouseMotionListener(mouseAdapter);
        }

        @Override
        protected void paintComponent(Graphics g){

            super.paintComponent(g);
            //change to graphics2d for anti alising => smooth edges
            Graphics2D gg = (Graphics2D) g;
            gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int R = 50;
            for(Shape s: shapesList){
                gg.setColor(s.colorShape);
                switch (s.kindShape) {
                    case 1:
                        if(s.fillShape){gg.fillOval(s.start.x-R/2, s.start.y-R/2, R, R);}
                        else{gg.drawOval(s.start.x-R/2, s.start.y-R/2, R, R);}
                        break;
                    
                    case 2:
                        if(s.fillShape){gg.fillRect(s.start.x-R/2, s.start.y-R/2, R, R);}
                        else{gg.drawRect(s.start.x-R/2, s.start.y-R/2, R, R);}
                        break;
                    
                    case 3:
                        int[] x = {s.start.x, s.start.x-R/2, s.start.x+R/2 };
                        int[] y = {s.start.y-R/2, s.start.y+R/2, s.start.y+R/2};
                        if(s.fillShape){gg.fillPolygon(x, y, 3);}
                        else{gg.drawPolygon(x, y, 3);}
                        break;
                    
                    default:
                        gg.drawLine(s.start.x, s.start.y, s.end.x, s.end.y);
                        break;
                }
            }
        }

    }

    class Shape {
        int kindShape = 0;
        Color colorShape = Color.RED;
        boolean fillShape = true;
        Point start = null, end = null;

        public Shape(int kindShape, Color colorShape, boolean fillShape, Point start, Point end) {
            this.kindShape = kindShape;
            this.colorShape = colorShape;
            this.fillShape = fillShape;
            this.start = start;
            this.end = end;
        }
        

    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> new App());
    }
}
