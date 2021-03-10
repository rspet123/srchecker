/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KATTE
 */
import java.util.ArrayList;

public class srTeam {
    private ArrayList<srPlayer> playerList = new ArrayList<srPlayer>();
    private int avgSR = 0;
    private int sumSR = 0;
    private int teamSize = 0;
    private String teamName;
    
    public srTeam(String name){
        teamName = name;
        avgSR = 0;
    }
    public void addPlayer(srPlayer player){
        playerList.add(player);
        sumSR += player.getMaxRank();
        avgSR = sumSR/(playerList.size());
        teamSize++;
    }
    public int getAvgSr(){
        avgSR = sumSR/(playerList.size());
        return avgSR;
    }
    public void printTeam(){
        System.out.println(teamName + " AVG SR: " + avgSR);
        for(int i = 0; i <playerList.size();i++){
            System.out.println(playerList.get(i).getName()+ " > Top: " + playerList.get(i).getMaxRank());
            System.out.println("Top Hero:   \n" + playerList.get(i).getTopHero());
            System.out.println("DPS:    " + playerList.get(i).getDPSRank());
            System.out.println("TANK:   " + playerList.get(i).getTankRank());
            System.out.println("SUPPORT:" + playerList.get(i).getSuppRank() + "\n- - - - - - - - - - - -");
        }
    }
    public void removePlayer(srPlayer player){
        playerList.remove(player);
        sumSR -= player.getMaxRank();
        teamSize--;
    }
    public void removePlayer(String player){
        for(int i = 0; i<playerList.size();i++){
            if(playerList.get(i).getName().equals(player)){
                playerList.remove(i);
                sumSR -= playerList.get(i).getMaxRank();
                teamSize--;
            }
        }
    }
    public srPlayer getPlayer(String playerName){
        int playerLoc = 0;
        for(int i = 0; i<playerList.size();i++){
            if(playerList.get(i).getName().equals(playerName)){
                playerLoc = i;
            }
        }
        return playerList.get(playerLoc);
    }
    public srPlayer getPlayer(int index){
        return playerList.get(index);
    }
    public int getTeamSize(){
        return playerList.size();
    }
    public String getTeamName(){
        return teamName;
    }
    
    
    
}
