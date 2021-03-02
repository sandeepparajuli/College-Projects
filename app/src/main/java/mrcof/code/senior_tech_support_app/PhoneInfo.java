package mrcof.code.senior_tech_support_app;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.bumptech.glide.Glide;

import javax.annotation.Nullable;

public class PhoneInfo extends AppCompatActivity {

    private static final String TAG = "Phone Info";

    ImageButton mBackBtn;
    Button mSMQuesBtn, mSMQuesBtn2, mSMQuesBtn3; //Questions Button related to topic

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_phoneinfo);
        Log.d(TAG, "onCreate started.");

        getIncomingIntent();

        mBackBtn = (ImageButton) findViewById(R.id.back_btn3);

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhoneInfo.this, Phone.class); // From here to there

                // After saving user name go to next activity
                startActivity(intent);
                finish();
            }
        });

    }

    private void getIncomingIntent(){
        Log.d(TAG,"checking for incoming intent.");
        if(getIntent().hasExtra("socialMediaImage") && getIntent().hasExtra("socialMedia")){
            Log.d(TAG, "found some extras");


            String socialSMediaImg = getIntent().getStringExtra("socialMediaImage");
            String socialSMediaName = getIntent().getStringExtra("socialMedia");

            setImage(socialSMediaName, socialSMediaImg);
        }
    }

    @SuppressLint("SetTextI18n")
    private void setImage(String sm_Name, String smImg){
        TextView SMace = findViewById(R.id.sm_name);
        TextView mQu = findViewById(R.id.smques_name);
        TextView mQu2 = findViewById(R.id.smques_name2);
        TextView mQu3 = findViewById(R.id.smques_name3);
        mSMQuesBtn = (Button) findViewById(R.id.smQuesBtn);
        mSMQuesBtn2 = (Button) findViewById(R.id.smQuesBtn2);
        mSMQuesBtn3 = (Button) findViewById(R.id.smQuesBtn3);

        SMace.setText(sm_Name);

        if(sm_Name.equals("Facebook")){
            Log.d(TAG, "Facebook Selected");
            mQu.setText("How to watch a facebook live video?");

            mSMQuesBtn.setOnClickListener((View v) -> {
                String url ="https://www.facebook.com/help/840953929731188";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu2.setText("How to join a facebook video call?");

            mSMQuesBtn2.setOnClickListener((View v) -> {
                String url ="https://www.facebook.com/help/messenger-app/1414800065460231";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu3.setText("How to message on facebook?");

            mSMQuesBtn3.setOnClickListener((View v) -> {
                String url ="https://www.youtube.com/watch?v=SAmOfkn1Tfg&ab_channel=Techboomers";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });


        }
        else if (sm_Name.equals("Twitter")){
            Log.d(TAG, "Twitter Selected");

            mQu.setText("How to create an account on Twitter?");

            mSMQuesBtn.setOnClickListener((View v) -> {
                String url ="https://metricool.com/create-a-twitter-account/";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu2.setText("How to customize your profile on Twitter?");

            mSMQuesBtn2.setOnClickListener((View v) -> {
                String url ="https://help.twitter.com/en/managing-your-account/how-to-customize-your-profile";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu3.setText("Want a quick tour on how to use twitter?");

            mSMQuesBtn3.setOnClickListener((View v) -> {
                String url ="https://easytechseniors.com/beginners-guide-to-twitter-for-seniors/";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            });

        }
        else if (sm_Name.equals("Instagram")){
            Log.d(TAG, "Instagram Selected");

            mQu.setText("How to watch an instagram live?");

            mSMQuesBtn.setOnClickListener((View v) -> {
                String url ="https://help.instagram.com/699289326902954?helpref=search&sr=5&query=How%20do%20I%20share%20a%20live%20video%20to%20IGTV%20on%20Instagram%20after%20it%27s%20ended%3F";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu2.setText("How to send someone a message on Instagram?");

            mSMQuesBtn2.setOnClickListener((View v) -> {
                String url ="https://www.facebook.com/help/instagram/155540431448273";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu3.setText("How to like a picture on instagram?");

            mSMQuesBtn3.setOnClickListener((View v) -> {
                String url ="https://www.facebook.com/help/instagram/459307087443937";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            });

        }
        else if (sm_Name.equals("Whatsapp")){
            Log.d(TAG, "Whatsapp Selected");

            mQu.setText("How to send a message on whatsapp with Android?");

            mSMQuesBtn.setOnClickListener((View v) -> {
                String url ="https://www.androidcentral.com/how-send-messages-whatsapp-android";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu2.setText("How to call someone on whatsapp?");

            mSMQuesBtn2.setOnClickListener((View v) -> {
                String url ="https://faq.whatsapp.com/android/voice-and-video-calls/how-to-make-a-voice-call/?lang=en";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu3.setText("Would you like to speak with us?");

            mSMQuesBtn3.setOnClickListener((View v) -> {
                Intent intent = new Intent(Intent.ACTION_CALL); // From here to there
                intent.setData(Uri.parse("tel:2817405102"));
                // After saving user name go to next activity
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            });

        }
        else if (sm_Name.equals("Snapchat")){
            Log.d(TAG, "Snapchat Selected");

            mQu.setText("How to send a snapchat message?");

            mSMQuesBtn.setOnClickListener((View v) -> {
                String url ="https://support.snapchat.com/en-US/a/chat";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu2.setText("How to send a picture message on snapchat?");

            mSMQuesBtn2.setOnClickListener((View v) -> {
                String url ="https://support.snapchat.com/en-US/a/send-snap";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu3.setText("How to record a video on snapchat?");

            mSMQuesBtn3.setOnClickListener((View v) -> {
                String url ="https://www.wikihow.com/Make-a-Video-in-Snapchat";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            });

        }
        else if (sm_Name.equals("Zoom")){
            Log.d(TAG, "Zoom Selected");

            mQu.setText("How to join a zoom meeting?");

            mSMQuesBtn.setOnClickListener((View v) -> {
                String url ="https://support.zoom.us/hc/en-us/articles/201362193-Joining-a-meeting";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu2.setText("How to host/create a zoom meeting?");

            mSMQuesBtn2.setOnClickListener((View v) -> {
                String url ="https://support.zoom.us/hc/en-us/articles/201362613-How-Do-I-Host-A-Video-Meeting-";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu3.setText("How to message on zoom?");

            mSMQuesBtn3.setOnClickListener((View v) -> {
                String url ="https://support.zoom.us/hc/en-us/articles/203650445-Using-in-meeting-chat";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            });

        }

        ImageView image = findViewById(R.id.sm_image);
        Glide.with(this).load(smImg).into(image);

    }
}
