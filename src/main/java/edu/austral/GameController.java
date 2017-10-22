package edu.austral;

import edu.austral.controllers.LevelController;
import edu.austral.controllers.PlayerController;
import edu.austral.controllers.ShotController;
import edu.austral.controllers.configuration.GameConfiguration;
import edu.austral.controllers.configuration.KeyConfiguration;
import edu.austral.controllers.configuration.lifter.ConfigLifter;
import edu.austral.controllers.configuration.lifter.GameConfigurationLifter;
import edu.austral.controllers.configuration.lifter.KeyConfigurationLifter;
import edu.austral.model.Game;
import edu.austral.util.Vector2;
import edu.austral.util.generator.Generator;
import edu.austral.util.generator.PositionPlayerGenerator;
import edu.austral.view.View;
import processing.core.PApplet;
import processing.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class GameController extends GameFramework {
    public static void main(String args[]) {
        PApplet.main("edu.austral.GameController");
    }

    private List<PlayerController> playerControllers = new ArrayList<>();
    public ShotController shotController = new ShotController();
    public View view = new View();
    private Game game = Game.getINSTANCE();
    private GameConfiguration gameConfiguration = new GameConfiguration();
    private List<KeyConfiguration> keyConfigurations;
    private LevelController levelController;

    public static GameController INSTANCE;

    public GameController(){
        INSTANCE = this;
        setGameConfiguration();
        setKeyConfigurations();
        checkAmountOfPlayersWithAmountOfKeys();
        createPlayers();
        setupGame();
        startGame();
        game.addView(view);
        levelController = new LevelController();
    }

    private void setupGame(){

    }

    private void startGame(){

    }

    private void createPlayers(){
        int i = 0;
        List<Vector2> positions = generatePlayerPositions();
        while (i < gameConfiguration.amountOfPlayers()){
            KeyConfiguration keyConfiguration = keyConfigurations.get(i);
            String playerName = gameConfiguration.playerNames.get(i+1);
            PlayerController playerController = new PlayerController(keyConfiguration);
            playerController.createPlayer(playerName, i, positions.get(i));
            view.add(playerController.getPlayer());
            playerControllers.add(playerController);
            i++;
        }
    }

    private void setGameConfiguration(){
        ConfigLifter<GameConfiguration> lifter = new GameConfigurationLifter();
        gameConfiguration = lifter.lift();
        if(!gameConfiguration.hasPlayerNames()) throw new RuntimeException("There are no players set in config!");
    }

    private List<Vector2> generatePlayerPositions(){

        Generator<Vector2> playerVectorGenerators = new PositionPlayerGenerator();
        int xBound = game.getMap().getXLength();
        int yBound = game.getMap().getYLength();
        return playerVectorGenerators.generate(gameConfiguration.amountOfPlayers(), xBound, yBound);
    }

    private void setKeyConfigurations(){
        ConfigLifter<List<KeyConfiguration>> keyConfigurationConfigLifter = new KeyConfigurationLifter();
        keyConfigurations = keyConfigurationConfigLifter.lift();
        if(keyConfigurations.size() == 0) throw new RuntimeException("There is no configuration for the player keys!");
    }

    private void checkAmountOfPlayersWithAmountOfKeys(){
        if(gameConfiguration.amountOfPlayers() > keyConfigurations.size()) throw new RuntimeException("There are more players than key configs !!");
    }

    @Override public void draw(float time, PApplet graphics) {
        if(allPlayersAlive()) {
            view.render(graphics);
            game.iterate();
            levelController.operate();
        }else{
            view.displayGameOver(graphics);
        }
    }

    @Override public void keyPressed(KeyEvent event) {
        for(PlayerController p: playerControllers){
            p.keyPressed(event);
        }
    }

    private boolean allPlayersAlive(){
        for(PlayerController pc: playerControllers){
            if(!pc.playerIsAlive()) return false;
        }
        return true;
    }
}
