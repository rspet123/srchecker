/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KATTE
 */
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONArray;
import org.json.JSONObject;

public class srPlayer {
    private String urlHolder = "https://ow-api.com/v1/stats/pc/us/";
    private String playerTag = "adara-21451";
    private String urlBack = "/complete";
    private String playerName;
    private int tankSR = 0;
    private int suppSR = 0;
    private int dpsSR = 0;
    private int totalSR = 0;
    private JSONArray roleSRs;
    private String[] ishansHeroes = {"dva", "orisa", "reinhardt", "roadhog", "sigma", "winston", "wreckingBall", "zarya", "ashe", "bastion", "doomfist", "echo", "genji", "hanzo", "junkrat", "mccree", "mei", "pharah", "reaper", "soldier76", "sombra", "symmetra", "torbjorn", "tracer", "widowmaker", "ana", "baptiste", "brigitte", "lucio", "mercy", "moira", "zenyatta"};
    String[][] heroTimeArray = new String[32][2];
    private JSONObject heroPool;
    private int[] srArray = new int[3];
    private int maxSR = -1000;
    private int arrayIndex = 0;
    
    public srPlayer(String tag) throws Exception {
        playerName = playerTag;
        HttpResponse <JsonNode> response = Unirest.get(urlHolder + tag.replace("#", "-") + urlBack).asJson();
        JSONObject playerJSON = new JSONObject(response.getBody().toString());
        playerName = playerJSON.getString("name");
        roleSRs = playerJSON.getJSONArray("ratings");
        for(int i = 0; i <roleSRs.length();i++){
                if(roleSRs.getJSONObject(i).get("role").equals("tank")){
                    tankSR = roleSRs.getJSONObject(i).getInt("level");
                    srArray[i] = tankSR;
                    maxSR = tankSR;
                    
                }
                if(roleSRs.getJSONObject(i).get("role").equals("support")){
                    suppSR = roleSRs.getJSONObject(i).getInt("level");
                    srArray[i] = tankSR;
                    if(suppSR>maxSR){
                        maxSR = suppSR;
                    }
                }
                if(roleSRs.getJSONObject(i).get("role").equals("damage")){
                    dpsSR = roleSRs.getJSONObject(i).getInt("level");
                    if(dpsSR>maxSR){
                        maxSR = dpsSR;
                    }
                }
                totalSR = (dpsSR + suppSR + tankSR)/3;
            }
        heroPool = playerJSON.getJSONObject("competitiveStats").getJSONObject("topHeroes");
            for(int j = 0; j < ishansHeroes.length;j++){
                heroTimeArray[j][0]=ishansHeroes[j];
                try{
                heroTimeArray[j][1]=(heroPool.getJSONObject(ishansHeroes[j]).get("timePlayed").toString());
                } catch(Exception e){
                    heroTimeArray[j][1]="0";
                }
            }
    }
    public String getTopHero(){
        int maxTime = -100;
        String topHero;
        int maxHeroIndex = 0;
        for(int k = 0; k<32;k++){
            if(Integer.parseInt(heroTimeArray[k][1].replace(":", ""))>maxTime){
                maxTime = Integer.parseInt(heroTimeArray[k][1].replace(":", ""));
                maxHeroIndex = k;
            }
        }
        topHero = heroTimeArray[maxHeroIndex][0];
        return heroTimeArray[maxHeroIndex][0] +":   " +heroTimeArray[maxHeroIndex][1];
    }
    public int getDPSRank(){
        return dpsSR;
    }
    public int getSuppRank(){
        return suppSR;
    }
    public int getTankRank(){
        return tankSR;
    }
    public int getTotalRank(){
        return totalSR;
    }
    public String[][] getHeroPool(){
        return heroTimeArray;
    }
    public String getName(){
        return playerName;
    }
    public int getMaxRank(){
        return maxSR;
    }
    
    
}
