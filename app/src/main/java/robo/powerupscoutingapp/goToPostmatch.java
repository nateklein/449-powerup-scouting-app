package robo.powerupscoutingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class goToPostmatch extends Activity {

    // Input fields
    private RadioGroup dead;
    private RadioGroup defense;
    private EditText comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postmatch_page);
        dead = (RadioGroup) findViewById(R.id.dead);
        defense = (RadioGroup) findViewById(R.id.defense);
        comments = (EditText) findViewById(R.id.comments);
        comments.setText(MainActivity.db.comments);
        switch (MainActivity.db.dead) {
            case 0:
                dead.clearCheck();
                break;
            case 1:
                dead.check(R.id.deadNone);
                break;
            case 2:
                dead.check(R.id.deadBroke);
                break;
            case 3:
                dead.check(R.id.deadHalf);
                break;
            case 4:
                dead.check(R.id.deadDead);
                break;
        }
        switch (MainActivity.db.defense) {
            case 0:
                defense.clearCheck();
                break;
            case 1:
                defense.check(R.id.defenseNone);
                break;
            case 2:
                defense.check(R.id.defenseBad);
                break;
            case 3:
                defense.check(R.id.defenseMeh);
                break;
            case 4:
                defense.check(R.id.defenseGood);
                break;
        }
    }

    public void toEndgame(View v) {
        // Save values to database
        MainActivity.db.comments = comments.getText().toString();
        switch (dead.getCheckedRadioButtonId()) {
            case R.id.deadNone:
                MainActivity.db.dead = 1;
                break;
            case R.id.deadBroke:
                MainActivity.db.dead = 2;
                break;
            case R.id.deadHalf:
                MainActivity.db.dead = 3;
                break;
            case R.id.deadDead:
                MainActivity.db.dead = 4;
                break;
            default:
                MainActivity.db.dead = 0;
        }
        switch (defense.getCheckedRadioButtonId()) {
            case R.id.defenseNone:
                MainActivity.db.defense = 1;
                break;
            case R.id.defenseBad:
                MainActivity.db.defense = 2;
                break;
            case R.id.defenseMeh:
                MainActivity.db.defense = 3;
                break;
            case R.id.defenseGood:
                MainActivity.db.defense = 4;
                break;
            default:
                MainActivity.db.defense = 0;
        }
        // Switch pages
        Intent toEndgame = new Intent(this, goToEndgame.class);
        startActivity(toEndgame);
    }

    public void submit(View v) {
        // Save values to database
        MainActivity.db.comments = comments.getText().toString();
        switch (dead.getCheckedRadioButtonId()) {
            case R.id.deadNone:
                MainActivity.db.dead = 1;
                break;
            case R.id.deadBroke:
                MainActivity.db.dead = 2;
                break;
            case R.id.deadHalf:
                MainActivity.db.dead = 3;
                break;
            case R.id.deadDead:
                MainActivity.db.dead = 4;
                break;
            default:
                MainActivity.db.dead = 0;
        }
        switch (defense.getCheckedRadioButtonId()) {
            case R.id.defenseNone:
                MainActivity.db.defense = 1;
                break;
            case R.id.defenseBad:
                MainActivity.db.defense = 2;
                break;
            case R.id.defenseMeh:
                MainActivity.db.defense = 3;
                break;
            case R.id.defenseGood:
                MainActivity.db.defense = 4;
                break;
            default:
                MainActivity.db.defense = 0;
        }
        // Switch pages
        Intent submit = new Intent(this, goToEndgame.class);
        startActivity(submit);
    }
}
