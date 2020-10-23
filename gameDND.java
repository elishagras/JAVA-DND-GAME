import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import java.awt.*;
//import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Container;
import java.awt.Dimension;

//try deleting  all these extra libraries

public class gameDND{
    int playerhp;
    String playerweapon,playerPosition;

    JFrame window;
    Container contain;
    JPanel titleName,mainTextPanel,choiceButtonPanel,playerPanel;
    JLabel titleLabel,a;
    JLabel HPLabel, HP, weaponlabel, weaponName;
    JLabel subtitle;
    JButton startButton,choiceButton1,choiceButton2,choiceButton3,choiceButton4;
    JTextArea mainTextArea;
    Font titleFont = new Font("Ariel",Font.BOLD,50);
    Font subtitleFont = new Font("Ariel",Font.PLAIN,25);

    secondScreen screenOne = new secondScreen();
    playerHandler pHandler = new playerHandler();
     public static void main(String args[]){
         
         new gameDND();
     }
     public gameDND(){
         //.
         //from here
         window = new JFrame();
         window.setSize(800,600);
         window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         window.getContentPane().setBackground(Color.black);
         window.setLayout(null);
         
         contain = window.getContentPane();

         titleName = new JPanel();
         titleName.setBounds(250, 100, 600, 300);
         titleName.setBackground(Color.BLACK);
         titleLabel = new JLabel("<html><center>Dungeons & Dragons</center></html>");
         titleLabel.setForeground(Color.WHITE);
         titleLabel.setFont(titleFont);
         titleName.add(titleLabel);
         subtitle = new JLabel("A Fantasy RPG ");
         subtitle.setFont(subtitleFont);
         subtitle.setText(
             "<html><center>A Fantasy RPG <br> Inspired By Critical Role</center></html>"
         );
         startButton = new JButton("Start");
         startButton.setBounds(400, 900, 100, 40);
         startButton.setBackground(Color.BLACK);
         startButton.setForeground(Color.WHITE);
         startButton.setFont(subtitleFont);
         startButton.addActionListener(screenOne);
         
         titleLabel.setForeground(Color.WHITE);
         contain.add(titleName);
         titleName.add(subtitle);
         //window.add(a);
         titleName.setLayout(new BoxLayout(titleName, BoxLayout.Y_AXIS));
         titleLabel.setFont(subtitleFont);
         titleName.add(Box.createRigidArea(new Dimension(0,10)));
         titleName.add(startButton);
         
         
         
        
        
         window.setVisible(true);

     }
     // to here kuch change mat karna
     //this is done
     public void createGameScreen(){
         titleName.setVisible(false);
         startButton.setVisible(false);
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.CYAN);
        contain.add(mainTextPanel);

        mainTextArea = new JTextArea(
            "Welcome to the Dwarvern City of KragHammer.You are invited to visit the Mayor of the city Lord ThunderBrand " 
        );
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setLineWrap(true);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextPanel.add(mainTextArea);
        mainTextArea.setFont(subtitleFont);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.GREEN);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        contain.add(choiceButtonPanel);

        choiceButton1= new JButton("Choice 1");
        choiceButton1.setBackground(Color.BLACK);
        choiceButton1.setForeground(Color.WHITE);
        choiceButton1.setFont(subtitleFont);
        choiceButton1.setActionCommand("c1");
        choiceButton1.addActionListener(pHandler);
        choiceButtonPanel.add(choiceButton1);

        choiceButton2= new JButton("Choice 2");
        choiceButton2.setBackground(Color.BLACK);
        choiceButton2.setForeground(Color.WHITE);
        choiceButton2.setFont(subtitleFont);
        choiceButton2.setActionCommand("c2");
        choiceButton2.addActionListener(pHandler);
        choiceButtonPanel.add(choiceButton2);

        choiceButton3= new JButton("Choice 3");
        choiceButton3.setBackground(Color.BLACK);
        choiceButton3.setForeground(Color.WHITE);
        choiceButton3.setFont(subtitleFont);
        choiceButton3.setActionCommand("c3");
        choiceButton3.addActionListener(pHandler);
        choiceButtonPanel.add(choiceButton3);

        choiceButton4= new JButton("Choice 4");
        choiceButton4.setBackground(Color.BLACK);
        choiceButton4.setForeground(Color.WHITE);
        choiceButton4.setFont(subtitleFont);
        choiceButton4.setActionCommand("c4");
        choiceButton4.addActionListener(pHandler);
        choiceButtonPanel.add(choiceButton4);

        playerPanel = new JPanel();
        playerPanel.setBounds(100,15,600,50);
        playerPanel.setLayout(new GridLayout(1,4));
        playerPanel.setBackground(Color.green);
        contain.add(playerPanel);

         HPLabel = new JLabel("HP:");
         HPLabel.setFont(subtitleFont);
         HPLabel.setForeground(Color.white);
         playerPanel.add(HPLabel);

         HP = new JLabel();
         HP.setFont(subtitleFont);
         HP.setForeground(Color.white);
         playerPanel.add(HP);

         weaponlabel = new JLabel("Weapon:");
         weaponlabel.setFont(subtitleFont);
         weaponlabel.setForeground(Color.white);
         playerPanel.add(weaponlabel);

         weaponName = new JLabel();
         weaponName.setFont(subtitleFont);
         weaponName.setForeground(Color.white);
         playerPanel.add(weaponName);

         playerSetup();
        

     }
     // ye wala createGameScreen bhi thik hai
     //no need to change this
     
     public void playerSetup(){
         playerhp =20;
         playerweapon ="Dagger";
         weaponName.setText(playerweapon);
         HP.setText(""+playerhp);
         mayorHouse();
         
     }

     public void mayorHouse(){
         playerPosition ="mayorHouse";
         mainTextArea.setText(
        "Lord ThunderBrand: \nWelcome Traveller to my beautiful city.\n I have a quest for you. \n Are you ready for it?");
        choiceButton1.setText("Accept Quest");
        choiceButton2.setText("Decline Quest");
        choiceButton3.setText("");
        choiceButton4.setText("");
     }

     public void acceptQuest(){
         playerPosition ="acceptQuest";
         mainTextArea.setText("Thats the spirit!");
         choiceButton1.setText("Continue");
         choiceButton2.setText("");
         choiceButton3.setText("");
        choiceButton4.setText("");

     }
     public void declineQuest(){
         playerPosition="declineQuest";
         mainTextArea.setText(
         "I thought better of you");
         choiceButton1.setText("Accept");
         choiceButton2.setText("");
         choiceButton3.setText("");
         choiceButton4.setText("");
     }
     public void continueQuest(){
         playerPosition="continueQuest";
         mainTextArea.setText(
         "You are to retrieve a precious artifact for me. \n 'The necklace of thousand moons' found only in \n Shademirk Bog." );
         choiceButton1.setText("continue");
         choiceButton2.setText("");
         choiceButton3.setText("");
         choiceButton4.setText("");
     }
     public void continue1Quest(){
        playerPosition="continue1Quest";
        mainTextArea.setText(
        "You will face many challenges but I'm sure you will \nemerge successful. \nSafe travel's adventurer!" );
        choiceButton1.setText("Travel to Shademirk Bog");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
     }
     public void continue2Quest(){
        playerPosition="continue2Quest";
        mainTextArea.setText(
        "You arrive at Shademirk Bog.\nThe road diverges in front of you. \nWhat do you do?" );
        choiceButton1.setText("Go Left");
        choiceButton2.setText("Go Right");
        choiceButton3.setText("");
        choiceButton4.setText("");
     }
     public void leftQuest(){
        playerPosition="leftQuest";
        mainTextArea.setText(
        "You found a healing potion. \nWhat do you do?" );
        choiceButton1.setText("Drink potion and Go");
        choiceButton2.setText("Run away");
        choiceButton3.setText("");
        choiceButton4.setText("");
     }
     public void DrinkQuest(){
        playerPosition="DrinkQuest";
        mainTextArea.setText(
        "Oh no! You encountered a Goblin. \nWhat do you do?" );
        choiceButton1.setText("Attack");
        choiceButton2.setText("Run away");
        choiceButton3.setText("");
        choiceButton4.setText("");
     }
     public void RunQuest(){
        playerPosition="RunQuest";
        mainTextArea.setText(
        "Lord Uriel: I thought you were braver. You ran away! \n                           QUEST FAILED!          ");
        choiceButton1.setText("");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
     }
     public void RightQuest(){
        playerPosition="RightQuest";
        mainTextArea.setText(
        "Oh no! You encountered a Goblin. \nWhat do you do?" );
        choiceButton1.setText("Attack");
        choiceButton2.setText("Run away");
        choiceButton3.setText("");
        choiceButton4.setText("");
     }
    
     public void AttackQuest(){
        playerPosition="AttackQuest";
        mainTextArea.setText(
        "The Goblin dropped the necklace of thousand moons." );
        choiceButton1.setText("Pick it up");
        choiceButton2.setText("Pick and search cave");
        choiceButton3.setText("");
        choiceButton4.setText("");
     }
     public void PickQuest(){
        playerPosition="PickQuest";
        mainTextArea.setText(
        "You found the artifact!" );
        choiceButton1.setText("Go back to Emon");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
     }
     public void searchQuest(){
        playerPosition="searchQuest";
        mainTextArea.setText(
        "You found a great Sword!" );
        choiceButton1.setText("Equip");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
     }
     public void equipQuest(){
      playerPosition="equipQuest";
      mainTextArea.setText(
      "You found the artifact!" );
      choiceButton1.setText("Go back to Emon");
      choiceButton2.setText("");
      choiceButton3.setText("");
      choiceButton4.setText("");
   }
     public void backQuest(){
        playerPosition="backQuest";
        mainTextArea.setText(
        "Lord Uriel: Welcome back adventurer! \nI see you found the necklace. I knew I could trust you. \nExcellent job!" );
        choiceButton1.setText("");
        choiceButton2.setText("");
        choiceButton3.setText("");
        choiceButton4.setText("");
     }

     
     

     // idhar se start adding methods
     //dont forget to add playerposition to each method
     //plis watch previous videos to get full context
     // c1 matlab choicebutton 1
     //c2 matlab choice button 2
     //c3 matlbab choice button 3
     //c4 matlab choice button 4

     //your choice will read c1,c2,c3,c4
     // playerposition will help jump from scene to scene

     //isme you need to now add hp ka counter for attack sequences and healing potion wala thingy
     //equip dagger kiya to playerweapon wala string badalna chahiye


     // bryan if you can figure how to separate these into separate classes then plis do
     //nahi toh rehne do
     public class secondScreen implements ActionListener {
    
        public void actionPerformed(ActionEvent event){
            createGameScreen();
        }
    }
    public class playerHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String yourChoice = event.getActionCommand();

            switch(playerPosition)
            {
                case "mayorHouse":
                 switch(yourChoice){
                     case "c1": acceptQuest(); break;
                     case "c2": declineQuest(); break;
                     case "c3": break;
                     case "c4": break;
                 }
                 break;
                case "declineQuest":
                 switch(yourChoice){
                    case "c1": acceptQuest(); break;
                    case "c2": break;
                    case "c3": break;
                    case "c4": break;
                 }
                 break;
                    //idhar na abhi ek aur case continue ke baad
                    //thats the spirit wale kidhar hia?
                    //ruk ek min
                    //use kuch nahi hoga java doesnt care
                    //braces ka zhol hua hai
                    //rehne de kal dekhte hai
                    //sound ke bina samjhega nahi
                    //ok?
                    //aram se
                    //kal kab
                    //ha 
                    //byeeeee
                case "acceptQuest":
                 switch(yourChoice){
                    case "c1": continueQuest(); break;
                    case "c2": break;
                    case "c3": break;
                    case "c4": break;

                }
                break;
                case "continueQuest":
                 switch(yourChoice){
                    case "c1": continue1Quest(); break;
                    case "c2": break;
                    case "c3": break;
                    case "c4": break;
                 }
                 break;
                case "continue1Quest":
                 switch(yourChoice){
                    case "c1": continue2Quest(); break;
                    case "c2": break;
                    case "c3": break;
                    case "c4": break;
                 }
                 break;
                case "continue2Quest":
                 switch(yourChoice){
                    case "c1": leftQuest(); break;
                    case "c2": RightQuest(); break;
                    case "c3": break;
                    case "c4": break;
                 }
                 break;
                case "leftQuest":
                 switch(yourChoice){
                    case "c1": DrinkQuest(); break;
                    case "c2": RunQuest(); break;
                    case "c3": break;
                    case "c4": break;
                 }
                 break;
                case "DrinkQuest":
                 switch(yourChoice){
                    case "c1": AttackQuest(); break;
                    case "c2": RunQuest(); break;
                    case "c3": break;
                    case "c4": break;
                 }
                 break;
                 case "RunQuest":
                 switch(yourChoice){
                    case "c1": AttackQuest(); break;
                    case "c2": break;
                    case "c3": break;
                    case "c4": break;
                 }
                case "RightQuest":
                 switch(yourChoice){
                    case "c1": AttackQuest(); break;
                    case "c2": RunQuest(); break;
                    case "c3": break;
                    case "c4": break;
                 }
                 break;
                case "AttackQuest":
                 switch(yourChoice){
                    case "c1": PickQuest(); break;
                    case "c2": searchQuest(); break;
                    case "c3": break;
                    case "c4": break;
                 }
                 break;
                 case "PickQuest":
                 switch(yourChoice){
                    case "c1": backQuest(); break;
                    case "c2": searchQuest(); break;
                    case "c3": break;
                    case "c4": break;
                 }
                 break;
                 case "searchQuest":
                 switch(yourChoice){
                    case "c1": equipQuest(); break;
                    case "c2": backQuest(); break;
                    case "c3": break;
                    case "c4": break;
                 }
                 break;
                 case "equipQuest":
                 switch(yourChoice){
                    case "c1": backQuest(); break;
                    case "c2": break;
                    case "c3": break;
                    case "c4": break;
                 }


                



                

                 

                 
                 

               

            }

        }
    }
    
   
 }

 