package robo.powerupscoutingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class goToTeleop extends Activity {

    // Data trackers
    private int vaultCubes;
    private int switchDeliv;
    private int switchDrop;
    private int switchWrong;
    private int scaleDeliv;
    private int scaleDrop;
    private int scaleWrong;
    private int cubesDroppedInTransit;
    // Text fields that display current value
    private TextView vaultText;
    private TextView switchDelivText;
    private TextView switchDropText;
    private TextView switchWrongText;
    private TextView scaleDelivText;
    private TextView scaleDropText;
    private TextView scaleWrongText;
    private TextView transitText;
    // Input fields
    private CheckBox groundPickup;
    private CheckBox portalIntake;

    // Displays teleop page on activity call
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teleop_page);
        vaultCubes = MainActivity.db.vaultCubes;
        switchDeliv = MainActivity.db.switchDeliv;
        switchDrop = MainActivity.db.switchDrop;
        switchWrong = MainActivity.db.switchWrong;
        scaleDeliv = MainActivity.db.scaleDeliv;
        scaleDrop = MainActivity.db.scaleDrop;
        scaleWrong = MainActivity.db.scaleWrong;
        cubesDroppedInTransit = MainActivity.db.cubesDroppedInTransit;
        vaultText = (TextView) findViewById(R.id.vaultCubes);
        vaultText.setText(Integer.toString(vaultCubes));
        switchDelivText = (TextView) findViewById(R.id.switchDeliv);
        switchDelivText.setText("Success: " + Integer.toString(switchDeliv));
        switchDropText = (TextView) findViewById(R.id.switchDrop);
        switchDropText.setText("Dropped: " + Integer.toString(switchDrop));
        switchWrongText = (TextView) findViewById(R.id.switchWrong);
        switchWrongText.setText("Wrong Side: " + Integer.toString(switchWrong));
        scaleDelivText = (TextView) findViewById(R.id.scaleDeliv);
        scaleDelivText.setText("Success: " + Integer.toString(scaleDeliv));
        scaleDropText = (TextView) findViewById(R.id.scaleDrop);
        scaleDropText.setText("Dropped: " + Integer.toString(scaleDrop));
        scaleWrongText = (TextView) findViewById(R.id.scaleWrong);
        scaleWrongText.setText("Wrong Side: " + Integer.toString(scaleWrong));
        transitText = (TextView) findViewById(R.id.droppedInTransit);
        transitText.setText(Integer.toString(cubesDroppedInTransit));
        groundPickup = (CheckBox) findViewById(R.id.groundPickup);
        groundPickup.setChecked(MainActivity.db.groundPickup);
        portalIntake = (CheckBox) findViewById(R.id.portalIntake);
        portalIntake.setChecked(MainActivity.db.portalIntake);
    }

    public void minusVault(View v) {
        if (vaultCubes > 0) {
            vaultCubes--;
            vaultText.setText(Integer.toString(vaultCubes));
        }
    }

    public void plusVault(View v) {
        vaultCubes++;
        vaultText.setText(Integer.toString(vaultCubes));
    }

    public void plusSwitchDeliv(View v) {
        switchDeliv++;
        switchDelivText.setText("Success: " + Integer.toString(switchDeliv));
    }

    public void minusSwitchDeliv(View v) {
        if (switchDeliv > 0) {
            switchDeliv--;
            switchDelivText.setText("Success: " + Integer.toString(switchDeliv));
        }
    }

    public void plusSwitchDrop(View v) {
        switchDrop++;
        switchDropText.setText("Dropped: " + Integer.toString(switchDrop));
    }

    public void minusSwitchDrop(View v) {
        if (switchDrop > 0) {
            switchDrop--;
            switchDropText.setText("Dropped: " + Integer.toString(switchDrop));
        }
    }

    public void plusSwitchWrong(View v) {
        switchWrong++;
        switchWrongText.setText("Wrong Side: " + Integer.toString(switchWrong));
    }

    public void minusSwitchWrong(View v) {
        if (switchWrong > 0) {
            switchWrong--;
            switchWrongText.setText("Wrong Side: " + Integer.toString(switchWrong));
        }
    }

    public void plusScaleDeliv(View v) {
        scaleDeliv++;
        scaleDelivText.setText("Success: " + Integer.toString(scaleDeliv));
    }

    public void minusScaleDeliv(View v) {
        if (scaleDeliv > 0) {
            scaleDeliv--;
            scaleDelivText.setText("Success: " + Integer.toString(scaleDeliv));
        }
    }

    public void plusScaleDrop(View v) {
        scaleDrop++;
        scaleDropText.setText("Dropped: " + Integer.toString(scaleDrop));
    }

    public void minusScaleDrop(View v) {
        if (scaleDrop > 0) {
            scaleDrop--;
            scaleDropText.setText("Dropped: " + Integer.toString(scaleDrop));
        }
    }

    public void plusScaleWrong(View v) {
        scaleWrong++;
        scaleWrongText.setText("Wrong Side: " + Integer.toString(scaleWrong));
    }

    public void minusScaleWrong(View v) {
        if (scaleWrong > 0) {
            scaleWrong--;
            scaleWrongText.setText("Wrong Side: " + Integer.toString(scaleWrong));
        }
    }

    public void minusTransitDrop(View v) {
        if (cubesDroppedInTransit > 0) {
            cubesDroppedInTransit--;
            transitText.setText(Integer.toString(cubesDroppedInTransit));
        }
    }

    public void plusTransitDrop(View v) {
        cubesDroppedInTransit++;
        transitText.setText(Integer.toString(cubesDroppedInTransit));
    }

    // Calls activity to go to auto page
    public void toAuto(View v) {
        // Save values to PowerUpDatabase
        MainActivity.db.vaultCubes = vaultCubes;
        MainActivity.db.switchDeliv = switchDeliv;
        MainActivity.db.switchDrop = switchDrop;
        MainActivity.db.switchWrong = switchWrong;
        MainActivity.db.scaleDeliv = scaleDeliv;
        MainActivity.db.scaleDrop = scaleDrop;
        MainActivity.db.scaleWrong = scaleWrong;
        MainActivity.db.cubesDroppedInTransit = cubesDroppedInTransit;
        MainActivity.db.groundPickup = groundPickup.isChecked();
        MainActivity.db.portalIntake = portalIntake.isChecked();
        // Switches pages
        Intent toAuto = new Intent(this, goToAuto.class);
        startActivity(toAuto);
    }

    // Calls activity to go to endgame page
    public void toEndgame(View v) {
        // Save values to PowerUpDatabase
        MainActivity.db.vaultCubes = vaultCubes;
        MainActivity.db.switchDeliv = switchDeliv;
        MainActivity.db.switchDrop = switchDrop;
        MainActivity.db.switchWrong = switchWrong;
        MainActivity.db.scaleDeliv = scaleDeliv;
        MainActivity.db.scaleDrop = scaleDrop;
        MainActivity.db.scaleWrong = scaleWrong;
        MainActivity.db.cubesDroppedInTransit = cubesDroppedInTransit;
        MainActivity.db.groundPickup = groundPickup.isChecked();
        MainActivity.db.portalIntake = portalIntake.isChecked();
        // Switches pages
        Intent toEndgame = new Intent(this, goToEndgame.class);
        startActivity(toEndgame);
    }
}