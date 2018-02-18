package robo.powerupscoutingapp;

/*
 * PowerUpDatabase is a class that stores all data being collected.
 *
 * Used for preventing data loss between page flips and for submission.
 *
 * Created by Nate on 10/10/2017.
 */

import java.util.ArrayList;

public class PowerUpDatabase {                         // game will change each year

    // All data being collected
    // Prematch
    public String scoutName;
    public int matchNumber;
    public int teamNumber;
    public boolean noShow;
    // Auto
    public boolean autoBaseline;
    public int autoSwitch;
    public int autoSwitchTime;
    public int autoScale;
    public int autoScaleTime;
    public boolean grabbedSecondCube;
    // Teleop
    public int vaultCubes;
    public int switchDeliv;
    public int switchDrop;
    public int switchWrong;
    public int scaleDeliv;
    public int scaleDrop;
    public int scaleWrong;
    public ArrayList<String> intakes;
    public int cubesDroppedInTransit;
    // Endgame
    public int climbType;
    public int climb;
    public int climbTime;
    public int park;
    public int numPossAssists;
    public int numAssists;
    // Postmatch
    public int dead;
    public int defense;
    public String comments;

    // Default entries
    public PowerUpDatabase() {
        // Prematch
        scoutName = "";
        matchNumber = 0;
        teamNumber = 0;
        noShow = false;
        // Auto
        autoBaseline = false;
        autoSwitch = 0;
        autoSwitchTime = 0;
        autoScale = 0;
        autoScaleTime = 0;
        grabbedSecondCube = false;
        // Teleop
        vaultCubes = 0;
        switchDeliv = 0;
        switchDrop = 0;
        switchWrong = 0;
        scaleDeliv = 0;
        scaleDrop = 0;
        scaleWrong = 0;
        intakes = new ArrayList<>();
        cubesDroppedInTransit = 0;
        // Endgame
        climbType = 0;
        climb = 0;
        climbTime = 0;
        park = 0;
        numPossAssists = 0;
        numAssists = 0;
        // Postmatch
        dead = 0;
        defense = 0;
        comments = "";
    }

    @Override
    public String toString() {
        String intakeString = "";
        for (String intake : intakes) {
            intakeString += intake;
        }
        return scoutName+","+matchNumber+","+teamNumber+","+(noShow ? 1 : 0)+","+(autoBaseline ? 1 : 0)+","+
                autoSwitch+","+autoSwitchTime+","+autoScale+","+autoScaleTime+","+(grabbedSecondCube ? 1 : 0)+
                ","+vaultCubes+","+switchDeliv+","+switchDrop+","+switchWrong+","+scaleDeliv+","+scaleDrop+
                ","+scaleWrong+","+intakeString+","+cubesDroppedInTransit+","+climbType+","+climb+","+
                climbTime+","+park+","+numPossAssists+","+numAssists+","+dead+","+defense+","+comments;
    }

    public String checkData() {
        String errors = "";
        return errors;
    }
}