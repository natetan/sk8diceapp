package yulongproductions.com.skatedice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class SkateDice extends Activity {
    private TrickManager mTrickManager = new TrickManager();
    private ColorWheel mColorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skate_dice);

        final TextView trickText = (TextView)findViewById(R.id.trickText);
        final RelativeLayout layout = (RelativeLayout)findViewById(R.id.layout);
        final Button trickButton = (Button)findViewById(R.id.trickButton);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trickText.setText(mTrickManager.printTrick());
                int color = mColorWheel.getColor();
                layout.setBackgroundColor(color);
                trickButton.setTextColor(color);
            }
        };
        trickButton.setOnClickListener(listener);
    }
}
