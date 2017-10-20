package edu.austral.view.score;

import edu.austral.Constants;
import edu.austral.model.Player;
import org.classpath.icedtea.pulseaudio.PulseAudioMixerProvider;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class PlayerStatsRenderer {

    PlayerStatsHeader playerStatsHeader = new PlayerStatsHeader(710, 10, 180, 60);
    List<PlayerStatsView> playerStatsViews = new ArrayList<>();
    private int nextStatsYCoordinate = 60;

    public void addPlayerStats(Player player){
        playerStatsViews.add(new PlayerStatsView(player, 710, nextStatsYCoordinate, 60, 110));
        nextStatsYCoordinate += nextStatsYCoordinate;
    }

    public void render(PApplet sketch){
        playerStatsHeader.render(sketch);
        for(PlayerStatsView p: playerStatsViews){
            p.render(sketch);
        }
    }
}
