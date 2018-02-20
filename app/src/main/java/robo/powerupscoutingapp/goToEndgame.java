package robo.powerupscoutingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class goToEndgame extends Activity {

    // Data trackers
    private int climbTime;
    private int numPossAssists;
    private int numAssists;
    // Input fields
    private RadioGroup climbType;
    private RadioGroup climb;
    private RadioGroup park;
    // Text display
    private TextView climbTimeText;
    private TextView numPossAssistsText;
    private TextView numAssistsText;

    // Displays endgame page on activity call
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endgame_page);
        climbTime = MainActivity.db.climbTime;
        numPossAssists = MainActivity.db.numPossAssists;
        numAssists = MainActivity.db.numAssists;
        climbTimeText = (TextView) findViewById(R.id.climbTime);
        climbTimeText.setText(Integer.toString(climbTime));
        numPossAssistsText = (TextView) findViewById(R.id.numPossAssists);
        numPossAssistsText.setText(Integer.toString(numPossAssists));
        numAssistsText = (TextView) findViewById(R.id.numAssists);
        numAssistsText.setText(Integer.toString(numAssists));
        climbType = (RadioGroup) findViewById(R.id.climbType);
        climb = (RadioGroup) findViewById(R.id.climb);
        park = (RadioGroup) findViewById(R.id.park);
        switch (MainActivity.db.climbType) {
            case 0:
                climbType.clearCheck();
                break;
            case 1:
                climbType.check(R.id.climbTypeNoAttempt);
                break;
            case 2:
                climbType.check(R.id.climbTypeRung);
                break;
            case 3:
                climbType.check(R.id.climbTypeAssisting);
                break;
            case 4:
                climbType.check(R.id.climbTypeAssisted);
                break;
        }
        switch (MainActivity.db.climb) {
            case 0:
                climb.clearCheck();
                break;
            case 1:
                climb.check(R.id.climbNoAttempt);
                break;
            case 2:
                climb.check(R.id.climbFailed);
                break;
            case 3:
                climb.check(R.id.climbFell);
                break;
            case 4:
                climb.check(R.id.climbSuccess);
                break;
        }
        switch (MainActivity.db.park) {
            case 0:
                park.clearCheck();
                break;
            case 1:
                park.check(R.id.parkNoAttempt);
                break;
            case 2:
                park.check(R.id.parkFailed);
                break;
            case 3:
                park.check(R.id.parkSuccess);
                break;
        }
    }

    public void plusClimbTime(View v) {
        climbTime++;
        climbTimeText.setText(Integer.toString(climbTime));
    }

    public void minusClimbTime(View v) {
        if (climbTime > 0) {
            climbTime--;
            climbTimeText.setText(Integer.toString(climbTime));
        }
    }

    public void plusNumPossAssists(View v) {
        numPossAssists++;
        numPossAssistsText.setText(Integer.toString(numPossAssists));
    }

    public void minusNumPossAssists(View v) {
        if (numPossAssists > 0) {
            numPossAssists--;
            numPossAssistsText.setText(Integer.toString(numPossAssists));
        }
    }

    public void plusNumAssists(View v) {
        numAssists++;
        numAssistsText.setText(Integer.toString(numAssists));
    }

    public void minusNumAssists(View v) {
        if (numAssists > 0) {
            numAssists--;
            numAssistsText.setText(Integer.toString(numAssists));
        }
    }

    // Calls activity to go to teleop page
    public void toTeleop(View v) {
        // Save values to Database
        MainActivity.db.climbTime = climbTime;
        MainActivity.db.numPossAssists = numPossAssists;
        MainActivity.db.numAssists = numAssists;
        switch (climbType.getCheckedRadioButtonId()) {
            case R.id.climbTypeNoAttempt:
                MainActivity.db.climbType = 1;
                break;
            case R.id.climbTypeRung:
                MainActivity.db.climbType = 2;
                break;
            case R.id.climbTypeAssisting:
                MainActivity.db.climbType = 3;
                break;
            case R.id.climbTypeAssisted:
                MainActivity.db.climbType = 4;
                break;
            default:
                MainActivity.db.climbType = 0;
                break;
        }
        switch (climb.getCheckedRadioButtonId()) {
            case R.id.climbNoAttempt:
                MainActivity.db.climb = 1;
                break;
            case R.id.climbFailed:
                MainActivity.db.climb = 2;
                break;
            case R.id.climbFell:
                MainActivity.db.climb = 3;
                break;
            case R.id.climbSuccess:
                MainActivity.db.climb = 4;
                break;
            default:
                MainActivity.db.climb = 0;
                break;
        }
        switch (park.getCheckedRadioButtonId()) {
            case R.id.parkNoAttempt:
                MainActivity.db.park = 1;
                break;
            case R.id.parkFailed:
                MainActivity.db.park = 2;
                break;
            case R.id.parkSuccess:
                MainActivity.db.park = 3;
                break;
            default:
                MainActivity.db.park = 0;
                break;
        }
        // Switches pages
        Intent toTeleop = new Intent(this, goToTeleop.class);
        startActivity(toTeleop);
    }

    // Calls activity to submit
    public void toPostmatch(View v) {
        // Save values to Database
        MainActivity.db.climbTime = climbTime;
        MainActivity.db.numPossAssists = numPossAssists;
        MainActivity.db.numAssists = numAssists;
        switch (climbType.getCheckedRadioButtonId()) {
            case R.id.climbTypeNoAttempt:
                MainActivity.db.climbType = 1;
                break;
            case R.id.climbTypeRung:
                MainActivity.db.climbType = 2;
                break;
            case R.id.climbTypeAssisting:
                MainActivity.db.climbType = 3;
                break;
            case R.id.climbTypeAssisted:
                MainActivity.db.climbType = 4;
                break;
            default:
                MainActivity.db.climbType = 0;
                break;
        }
        switch (climb.getCheckedRadioButtonId()) {
            case R.id.climbNoAttempt:
                MainActivity.db.climb = 1;
                break;
            case R.id.climbFailed:
                MainActivity.db.climb = 2;
                break;
            case R.id.climbFell:
                MainActivity.db.climb = 3;
                break;
            case R.id.climbSuccess:
                MainActivity.db.climb = 4;
                break;
            default:
                MainActivity.db.climb = 0;
                break;
        }
        switch (park.getCheckedRadioButtonId()) {
            case R.id.parkNoAttempt:
                MainActivity.db.park = 1;
                break;
            case R.id.parkFailed:
                MainActivity.db.park = 2;
                break;
            case R.id.parkSuccess:
                MainActivity.db.park = 3;
                break;
            default:
                MainActivity.db.park = 0;
                break;
        }
        // Switches pages
        Intent postmatch = new Intent(this, goToPostmatch.class);
        startActivity(postmatch);
    }
}