package de.kathistutz;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Colour[] dice = { Colour.RED, Colour.BLUE, Colour.GREEN, Colour.YELLOW };
    private List<ImageButton> diceButtons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton dice1 = findViewById(R.id.dice1);
        ImageButton dice2 = findViewById(R.id.dice2);
        ImageButton dice3 = findViewById(R.id.dice3);
        ImageButton dice4 = findViewById(R.id.dice4);
        ImageButton dice5 = findViewById(R.id.dice5);
        ImageButton dice6 = findViewById(R.id.dice6);
        diceButtons.add(dice1);
        diceButtons.add(dice2);
        diceButtons.add(dice3);
        diceButtons.add(dice4);
        diceButtons.add(dice5);
        diceButtons.add(dice6);

        for (ImageButton diceButton:diceButtons) {
            diceButton.setScaleType(ImageView.ScaleType.CENTER);
            diceButton.setAdjustViewBounds(true);
        }
    }

    public void rollDice(View view) {
        for (ImageButton diceButton:diceButtons) {
            diceButton.setImageResource(R.drawable.black_dice);
        }

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (ImageButton diceButton:diceButtons) {
                    int number = random.nextInt(6) + 1;
                    diceButton.setImageDrawable(getCorrectImage(number));
                }
            }
        }, 10);
//        for (ImageButton diceButton:diceButtons) {
//            int number = random.nextInt(6) + 1;
//            diceButton.setImageDrawable(getCorrectImage(number));
//        }
    }

    private Drawable getCorrectImage(int number) {
        Resources res = getResources();
        switch(number) {
            case 1:
                return ResourcesCompat.getDrawable(res, R.drawable.number1, null);
            case 2:
                return ResourcesCompat.getDrawable(res, R.drawable.number2, null);
            case 3:
                return ResourcesCompat.getDrawable(res, R.drawable.number3, null);
            case 4:
                return ResourcesCompat.getDrawable(res, R.drawable.number4, null);
            case 5:
                return ResourcesCompat.getDrawable(res, R.drawable.number5, null);
            case 6:
                return ResourcesCompat.getDrawable(res, R.drawable.number6, null);
        }
        return null;
    }

    public void removeDice() {
        //TODO: Remove dice from List according to colour
    }

    private enum Colour {
        RED,
        BLUE,
        YELLOW,
        GREEN,
        WHITE;
    }
}