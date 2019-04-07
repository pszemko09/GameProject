package com.game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasa pobierająca nazwę gracza oraz kod premium
 */

public class DataPanel extends JDialog implements ActionListener {

    private JLabel lPlayer, lPassword, lText;
    private JTextField tPlayerName;
    private JPasswordField pGameCode;
    private JButton bOK, bCancel;
    private boolean okData;

    public DataPanel(JFrame owner){
        super(owner, "Wprowadzanie danych", true);
        setSize(300,300);
        setLayout(null);
        setLocation(635,250);

        String text = "<html> W miejsce pola Kod Gry wpisz kod do konta premium lub jeśli nie posiadasz wpisz 0!<html>";
        lText = new JLabel(text, JLabel.CENTER);
        lText.setBounds(50,20, 200,50);
        add(lText);

        lPlayer = new JLabel("Nazwa Gracza", JLabel.RIGHT);
        lPlayer.setBounds(0,100, 100,20);
        add(lPlayer);

        tPlayerName = new JTextField();
        tPlayerName.setBounds(150,100, 100,20);
        add(tPlayerName);

        lPassword = new JLabel("Kod Gry", JLabel.RIGHT);
        lPassword.setBounds(0,150, 100,20);
        add(lPassword);

        pGameCode = new JPasswordField();
        pGameCode.setBounds(150,150, 100,20);
        add(pGameCode);

        bOK = new JButton("OK");
        bOK.setBounds(50, 200, 80,50);
        bOK.addActionListener(this);
        add(bOK);

        bCancel = new JButton("Wyjście");
        bCancel.setBounds(150, 200, 80,50);
        bCancel.addActionListener(this);
        add(bCancel);
    }

    public String getPlayerName(){
        return tPlayerName.getText();
    }

    public String getGameCode(){
        return new String(pGameCode.getPassword());
    }

    public boolean isOK(){
        return okData;
    }

    public void setFocus(){
        tPlayerName.requestFocusInWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == bOK)
            okData = true;
        else
            okData = false;

        setVisible(false);
    }
}