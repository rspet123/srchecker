
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KATTE
 */
public class srGUI extends JFrame implements ActionListener{
    private srTeam team1;
    private JLabel addLabel;
    private JLabel teamBlock;
    private JButton addButton;
    private JButton removeButton;
    private JButton displayButton;
    private JButton createButton;
    private JTextField TeamName;
    private JTextField PlayerName;
    private JTextField result;
    
    public void actionPerformed(ActionEvent e){
        try{
        team1.addPlayer(new srPlayer(TeamName.getText()));
        }catch(Exception d){
            d.printStackTrace();
        }
        
    }
    public srGUI(){
        super();
        setTitle("CalculatorGUI");
        setLayout(new GridBagLayout());
        GridBagConstraints grid1 = new GridBagConstraints();
        grid1.gridx = 0;
        grid1.gridy = 0;
        grid1.insets = new Insets(10,10,10,10);
        addLabel = new JLabel("Insert Team");
        addButton = new JButton("Add Player");
        removeButton = new JButton("Remove Player");
        displayButton = new JButton("Display Team");
        createButton = new JButton("Create Team");
        teamBlock = new JLabel("waiting for team");
        TeamName = new JTextField();
        PlayerName = new JTextField();
        result = new JTextField();
        TeamName.setPreferredSize(new Dimension(100,20));
        TeamName.setMinimumSize(TeamName.getPreferredSize());

        PlayerName.setPreferredSize(new Dimension(100,20));
        PlayerName.setMinimumSize(PlayerName.getPreferredSize());

        teamBlock.setPreferredSize(new Dimension(1000,3000));
        result.setMinimumSize(result.getPreferredSize());
        

        add(addButton,grid1);
        grid1.gridx = 0;
        grid1.gridy = 2;
        add(addButton,grid1);
        addButton.addActionListener(this);
        
        grid1.gridx = 0;
        grid1.gridy = 1;
        add(TeamName,grid1);
        
        
        grid1.gridx = 0;
        grid1.gridy = 3;
        add(removeButton,grid1);
        removeButton.addActionListener(new SubtractListener());
        
        grid1.gridx = 0;
        grid1.gridy = 4;
        add(displayButton,grid1);
        displayButton.addActionListener(new DivideListener());
        
        grid1.gridx = 0;
        grid1.gridy = 5;
        add(createButton,grid1);
        createButton.addActionListener(new MultiplyListener());
        
        grid1.gridx = 0;
        grid1.gridy = 6;
        add(teamBlock,grid1);

    }
            class SubtractListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
        //calculateLabel.setText("Button Pressed");
        team1.removePlayer(TeamName.getText());

        
    }
    }
    class MultiplyListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
        //calculateLabel.setText("Button Pressed");
        team1 = new srTeam(TeamName.getText());
        createButton.setText("Team Created");
        
    }
    }
    class DivideListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                String f = (team1.getTeamName() + " \n");
                for(int j = 0; j < team1.getTeamSize();j++){
                    f = f.concat(team1.getPlayer(j).getName() + " " + team1.getPlayer(j).getTopHero() + " \n ");
                }
                teamBlock.setText(f);
        
    }
    }
}

