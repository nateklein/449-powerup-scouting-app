package robo.powerupscoutingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

public class goToAuto extends Activity {

    // Text fields that display current value
    private TextView switchTimeText;
    private TextView scaleTimeText;

    // Input fields
    private CheckBox crossBaseline;
    private RadioGroup autoSwitch;
    private RadioGroup autoScale;
    private CheckBox grabbedSecondCube;

    // Data trackers
    private int switchTime;
    private int scaleTime;

    // Displays auto page on activity call
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autonomous_page);
        switchTime = MainActivity.db.autoSwitchTime;
        scaleTime = MainActivity.db.autoScaleTime;
        switchTimeText = (TextView) findViewById(R.id.switchTime);
        switchTimeText.setText(Integer.toString(switchTime));
        scaleTimeText = (TextView) findViewById(R.id.scaleTime);
        scaleTimeText.setText(Integer.toString(scaleTime));
        crossBaseline = (CheckBox) findViewById(R.id.crossBaseline);
        crossBaseline.setChecked(MainActivity.db.autoBaseline);
        autoSwitch = (RadioGroup) findViewById(R.id.autoSwitch);
        autoScale = (RadioGroup) findViewById(R.id.autoScale);
        grabbedSecondCube = (CheckBox) findViewById(R.id.grabbedSecondCube);
        grabbedSecondCube.setChecked(MainActivity.db.grabbedSecondCube);
        switch (MainActivity.db.autoSwitch) {
            case 0:
                autoSwitch.clearCheck();
                break;
            case 1:
                autoSwitch.check(R.id.noAttemptSwitch);
                break;
            case 2:
                autoSwitch.check(R.id.alignedSwitch);
                break;
            case 3:
                autoSwitch.check(R.id.missedSwitch);
                break;
            case 4:
                autoSwitch.check(R.id.wrongSideSwitch);
                break;
            case 5:
                autoSwitch.check(R.id.successSwitch);
                break;
            case 6:
                autoSwitch.check(R.id.twoCubesSwitch);
                break;
        }
        switch (MainActivity.db.autoScale) {
            case 0:
                autoScale.clearCheck();
                break;
            case 1:
                autoScale.check(R.id.noAttemptScale);
                break;
            case 2:
                autoScale.check(R.id.alignedScale);
                break;
            case 3:
                autoScale.check(R.id.missedScale);
                break;
            case 4:
                autoScale.check(R.id.wrongSideScale);
                break;
            case 5:
                autoScale.check(R.id.successScale);
                break;
            case 6:
                autoScale.check(R.id.twoCubesScale);
                break;
        }
    }

    public void plusScaleTime(View v) {
        scaleTime++;
        scaleTimeText.setText(Integer.toString(scaleTime));
    }

    public void minusScaleTime(View v) {
        if (scaleTime > 0) {
            scaleTime--;
            scaleTimeText.setText(Integer.toString(scaleTime));
        }
    }

    public void plusSwitchTime(View v) {
        switchTime++;
        switchTimeText.setText(Integer.toString(switchTime));
    }

    public void minusSwitchTime(View v) {
        if (switchTime > 0) {
            switchTime--;
            switchTimeText.setText(Integer.toString(switchTime));
        }
    }

    // Calls activity to go to teleop page
    public void toTeleop(View v) {
        // Save values to database
        MainActivity.db.autoSwitchTime = switchTime;
        MainActivity.db.autoScaleTime = scaleTime;
        switch (autoSwitch.getCheckedRadioButtonId()) {
            case R.id.noAttemptSwitch:
                MainActivity.db.autoSwitch = 1;
                break;
            case R.id.alignedSwitch:
                MainActivity.db.autoSwitch = 2;
                break;
            case R.id.missedSwitch:
                MainActivity.db.autoSwitch = 3;
                break;
            case R.id.wrongSideSwitch:
                MainActivity.db.autoSwitch = 4;
                break;
            case R.id.successSwitch:
                MainActivity.db.autoSwitch = 5;
                break;
            case R.id.twoCubesSwitch:
                MainActivity.db.autoSwitch = 6;
                break;
            default:
                MainActivity.db.autoSwitch = 0;
        }
        switch (autoScale.getCheckedRadioButtonId()) {
            case R.id.noAttemptScale:
                MainActivity.db.autoScale = 1;
                break;
            case R.id.alignedScale:
                MainActivity.db.autoScale = 2;
                break;
            case R.id.missedScale:
                MainActivity.db.autoScale = 3;
                break;
            case R.id.wrongSideScale:
                MainActivity.db.autoScale = 4;
                break;
            case R.id.successScale:
                MainActivity.db.autoScale= 5;
                break;
            case R.id.twoCubesScale:
                MainActivity.db.autoScale = 6;
                break;
            default:
                MainActivity.db.autoScale = 0;
        }
        MainActivity.db.autoBaseline = crossBaseline.isChecked();
        MainActivity.db.grabbedSecondCube = grabbedSecondCube.isChecked();
        // Switch pages
        Intent toTeleop = new Intent(this, goToTeleop.class);
        startActivity(toTeleop);
    }

    // Calls activity to go to prematch page
    public void toPrematch(View v) {
        // Save values to Database
        MainActivity.db.autoSwitchTime = switchTime;
        MainActivity.db.autoScaleTime = scaleTime;
        switch (autoSwitch.getCheckedRadioButtonId()) {
            case R.id.noAttemptSwitch:
                MainActivity.db.autoSwitch = 1;
                break;
            case R.id.alignedSwitch:
                MainActivity.db.autoSwitch = 2;
                break;
            case R.id.missedSwitch:
                MainActivity.db.autoSwitch = 3;
                break;
            case R.id.wrongSideSwitch:
                MainActivity.db.autoSwitch = 4;
                break;
            case R.id.successSwitch:
                MainActivity.db.autoSwitch = 5;
                break;
            case R.id.twoCubesSwitch:
                MainActivity.db.autoSwitch = 6;
                break;
            default:
                MainActivity.db.autoSwitch = 0;
        }
        switch (autoScale.getCheckedRadioButtonId()) {
            case R.id.noAttemptScale:
                MainActivity.db.autoScale = 1;
                break;
            case R.id.alignedScale:
                MainActivity.db.autoScale = 2;
                break;
            case R.id.missedScale:
                MainActivity.db.autoScale = 3;
                break;
            case R.id.wrongSideScale:
                MainActivity.db.autoScale = 4;
                break;
            case R.id.successScale:
                MainActivity.db.autoScale= 5;
                break;
            case R.id.twoCubesScale:
                MainActivity.db.autoScale = 6;
                break;
            default:
                MainActivity.db.autoScale = 0;
        }
        MainActivity.db.autoBaseline = crossBaseline.isChecked();
        MainActivity.db.grabbedSecondCube = grabbedSecondCube.isChecked();
        // Switches pages
        Intent toPrematch = new Intent(this, goToPrematch.class);
        startActivity(toPrematch);
    }
}