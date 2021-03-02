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

public class TvInfo extends AppCompatActivity {

    private static final String TAG = "TV Info";

    ImageButton mBackBtn; // Back Button
    Button mQuesBtn, mQuesBtn2, mQuesBtn3; //Questions Button related to topic

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_tvinfo);
        Log.d(TAG, "onCreate started.");

        getIncomingIntent();

        mBackBtn = (ImageButton) findViewById(R.id.back_btn2);

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TvInfo.this, TV.class); // From here to there

                // After saving user name go to next activity
                startActivity(intent);
                finish();
            }
        });

    }

    private void getIncomingIntent(){
        Log.d(TAG,"checking for incoming intent.");
        if(getIntent().hasExtra("brand_img") && getIntent().hasExtra("brand_name")){
            Log.d(TAG, "found some extras");

            String brandImg = getIntent().getStringExtra("brand_img");
            String brandName = getIntent().getStringExtra("brand_name");


            setContentInfo(brandName, brandImg);


        }

    }

    @SuppressLint("SetTextI18n")
    private void setContentInfo(String brand_Name, String brand_Img){
        TextView name = findViewById(R.id.brand_name);
        TextView mQu = findViewById(R.id.ques_name);
        TextView mQu2 = findViewById(R.id.ques_name2);
        TextView mQu3 = findViewById(R.id.ques_name3);
        mQuesBtn = (Button) findViewById(R.id.QuesBtn);
        mQuesBtn2 = (Button) findViewById(R.id.QuesBtn2);
        mQuesBtn3 = (Button) findViewById(R.id.QuesBtn3);

        name.setText(brand_Name);

        if(brand_Name.equals("Samsung")){
            Log.d(TAG, "Samsung Selected");
            mQu.setText("How to use Samsung remote?");

            mQuesBtn.setOnClickListener((View v) -> {
                String url ="https://www.samsung.com/us/support/answer/ANS00050204/";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu2.setText("How to use samsung smart tv with Alexa?");

            mQuesBtn2.setOnClickListener((View v) -> {
                String url ="https://www.tomsguide.com/us/samsung-smart-tv-alexa-how-to,news-29557.html";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu3.setText("Need to talk to an Samsung Rep?");

            mQuesBtn3.setOnClickListener((View v) -> {
                String url ="https://www.samsung.com/us/support/";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });


        }
        else if (brand_Name.equals("Sony")){
            Log.d(TAG, "Sony Selected");

            mQu.setText("How to use Sony remote?");

            mQuesBtn.setOnClickListener((View v) -> {
                String url ="https://www.sony.com/electronics/support/remote-controls-remotes-for-tv/manuals";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu2.setText("How to access the channel guide on a Sony tv?");

            mQuesBtn2.setOnClickListener((View v) -> {
                String url ="https://www.tomsguide.com/us/sony-tv-settings-guide,review-5605-4.html";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu3.setText("Would you like to speak with us?");

            mQuesBtn3.setOnClickListener((View v) -> {
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
        else if (brand_Name.equals("LG")){
            Log.d(TAG, "LG Selected");

            mQu.setText("How to use LG remote?");

            mQuesBtn.setOnClickListener((View v) -> {
                String url ="https://www.lg.com/us/support/help-library/remote-control-troubleshooting-operation-hdtv-netcast-webos-CT10000018-1427121727809";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu2.setText("How do I fix my LG Smart TV remote?");

            mQuesBtn2.setOnClickListener((View v) -> {
                String url ="https://www.lg.com/us/support/help-library/remote-control-troubleshooting-operation-hdtv-netcast-webos-CT10000018-1427121727809";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu3.setText("Would you like to speak with us?");

            mQuesBtn3.setOnClickListener((View v) -> {
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
        else if (brand_Name.equals("TCL")){
            Log.d(TAG, "TCL Selected");

            mQu.setText("How to use TCL remote?");

            mQuesBtn.setOnClickListener((View v) -> {
                String url ="https://www.tcl.com/content/dam/tcl-dam/region/au/au-mediacenter/downloads/P8S_User_Manual.pdf";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu2.setText("How to connect a remote app to TCL Smart TV?");

            mQuesBtn2.setOnClickListener((View v) -> {
                String url ="https://www.youtube.com/watch?v=BMpyOMM5oyg&ab_channel=TamilTechNews";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu3.setText("Would you like to speak with us?");

            mQuesBtn3.setOnClickListener((View v) -> {
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
        else if (brand_Name.equals("Hisense")){
            Log.d(TAG, "Hisense Selected");

            mQu.setText("How do I use Hisense tv remote?");

            mQuesBtn.setOnClickListener((View v) -> {
                String url ="https://www.directutor.com/content/remote-control-codes-hisense-tvs";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu2.setText("How to use Hisense smart tv?");

            mQuesBtn2.setOnClickListener((View v) -> {
                String url ="https://www.hisense-usa.com/support/";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu3.setText("Would you like to speak with us?");

            mQuesBtn3.setOnClickListener((View v) -> {
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
        else if (brand_Name.equals("Vizio")){
            Log.d(TAG, "Vizio Selected");

            mQu.setText("How to use Vizio remote?");

            mQuesBtn.setOnClickListener((View v) -> {
                String url ="https://cdn.vizio.com/documents/downloads/hdtv/M3D650SV/1185QSG_M3D650SV_B.pdf";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu2.setText("How to use Vizio smart tv?");

            mQuesBtn2.setOnClickListener((View v) -> {
                String url ="https://www.youtube.com/watch?v=OAqxy889Ndo";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            });

            mQu3.setText("Would you like to speak with us?");

            mQuesBtn3.setOnClickListener((View v) -> {
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

        ImageView image = findViewById(R.id.brand_image);
        Glide.with(this).load(brand_Img).into(image);

    }
}
