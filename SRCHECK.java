/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
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
import java.net.URLEncoder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.JSONException;
import org.json.JSONObject;
import com.jayway.jsonpath.JsonPath;
import java.util.*;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import net.minidev.json.JSONValue;
import com.gargoylesoftware.htmlunit.BrowserVersion;
/**
 *
 * @author KATTE
 */
public class SRCHECK {
    public static void main(String args[]){
        Scanner scan1 = new Scanner(System.in);
        String urlHolder = "https://ow-api.com/v1/stats/pc/us/";
        String playerTag = "adara-21451";
        String urlBack = "/complete";
        String[] ishansHeroes = {"dva", "orisa", "reinhardt", "roadhog", "sigma", "winston", "wreckingBall", "zarya", "ashe", "bastion", "doomfist", "echo", "genji", "hanzo", "junkrat", "mccree", "mei", "pharah", "reaper", "soldier76", "sombra", "symmetra", "torbjorn", "tracer", "widowmaker", "ana", "baptiste", "brigitte", "lucio", "mercy", "moira", "zenyatta"};
        JSONObject heroPool;
        JSONArray roleSRs;
        final WebClient client1 = new WebClient(BrowserVersion.CHROME);
        client1.getOptions().setCssEnabled(false);  
        client1.getOptions().setJavaScriptEnabled(false);
        client1.getOptions().setThrowExceptionOnFailingStatusCode(false);
        client1.getOptions().setThrowExceptionOnScriptError(false);
        client1.getOptions().setUseInsecureSSL(true);
        try{
        srPlayer Player1 = new srPlayer("Stellar-11528");
        srPlayer Player2 = new srPlayer("PeachInfams-2341");
        srPlayer Player3 = new srPlayer("ImSpecial-21836");
        srPlayer Player4 = new srPlayer("A10-21682");
        srPlayer Player5 = new srPlayer("Ojee-11919");
        srPlayer Player6 = new srPlayer("lhcloudy-2273");
        srTeam stackedTeam = new srTeam("stackerzzz");
        stackedTeam.addPlayer(Player1);
        stackedTeam.addPlayer(Player2);
        stackedTeam.addPlayer(Player3);
        stackedTeam.addPlayer(Player4);
        stackedTeam.addPlayer(Player5);
        stackedTeam.addPlayer(Player6);
        stackedTeam.printTeam();
        }catch(Exception e){
            System.out.println("ee");
            e.printStackTrace();
        }
        try{
        srGUI calc1 = new srGUI();
        calc1.pack();
        calc1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc1.setVisible(true);
        }catch(Exception NumberFormatException){
            System.out.println("Not a number");
        }
        

    }
    
}
