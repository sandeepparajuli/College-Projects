//Created by Axell Martinez aka Mr.Coffee Code
package mrcof.code.senior_tech_support_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 4000; // To set delay

    //Variables
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView  slogan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Remove Top Bar of File Name
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Calls Activity
        setContentView(R.layout.activity_main);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //Hooks
        image = findViewById(R.id.imageView); // Logo
        slogan = findViewById(R.id.welcome); // Slogan

        image.setAnimation(topAnim); // Set Logo to Top Animation
        slogan.setAnimation(bottomAnim); // Set Logo to Bottom Animation

        //To Handle the Delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Login.class); // From here to there
               // Pair[] pairs = new Pair[2];
               // pairs[0] = new Pair<View,String>(image, "logo_name");
               // pairs[1] = new Pair<View,String>(slogan, "logo_text");

               // ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
               // startActivity(intent, options.toBundle());
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);

    }
}