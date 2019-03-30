package com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainWindow extends JFrame {

    private PumpkinObject[] tableOfPumpkins = new PumpkinObject[5];
    private ImageLoader imageLoader = new ImageLoader();
    private JLabel[] labelTable = new JLabel[5];

    private JFrame mainFrame;
    private JPanel panel_01 = new JPanel();
    private JPanel panel_02 = new JPanel();

    private String text = "<html>Liczba żyć: <br/><br/><br/>Czas gry: <br/><br/><br/>Liczba punktów: </html>";
    JLabel panel_02text = new JLabel(text);

    public MainWindow() {

        panel_02text.setForeground(Color.RED);
        panel_01.setLayout(null);

        panel_01.setBackground(new Color(88, 216,  131));
        panel_02.setBackground(Color.DARK_GRAY);
        panel_02.add(panel_02text);


        mainFrame = new JFrame(Game.TITLE);
        mainFrame.setDefaultCloseOperation(mainFrame.getDefaultCloseOperation());
        mainFrame.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        mainFrame.getContentPane().setBackground(Color.BLACK);

        mainFrame.add(panel_01, BorderLayout.CENTER);
        mainFrame.add(panel_02, BorderLayout.EAST);


        mainFrame.pack();
        mainFrame.setResizable(true);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

        init();

    }

    public void init(){
        for(int i = 0; i < tableOfPumpkins.length; i++){
            tableOfPumpkins[i] = new PumpkinObject(imageLoader.loadImage("/pumpkin.png"));
        }
    }

    public void drawPumpkinObjects() throws IOException {

        for(int i = 0; i < tableOfPumpkins.length; i++) {
            BufferedImage image = tableOfPumpkins[i].image;
            Image resized = PumpkinObject.resize(image, tableOfPumpkins[i].getSizeOfObject());

            labelTable[i] = new JLabel(new ImageIcon(resized));
            labelTable[i].setBounds(tableOfPumpkins[i].getX_coordinate(), tableOfPumpkins[i].getY_coordinate(), (int) (tableOfPumpkins[i].getSizeOfObject() * Game.WIDTH * 0.01), (int) (tableOfPumpkins[i].getSizeOfObject() * Game.WIDTH * 0.01));
            panel_01.add(labelTable[i]);
            panel_01.repaint();
            mainFrame.repaint();
        }
    }

}
