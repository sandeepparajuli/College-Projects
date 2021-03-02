package mrcof.code.senior_tech_support_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class Dashboard extends AppCompatActivity {

    //Variables
    Button regTVBtn, regPhoneBtn, regCallBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        //Hooks
        regTVBtn = (Button) findViewById(R.id.SelectedTV);
        regPhoneBtn = (Button) findViewById(R.id.SelectedPhone);
        regCallBtn = (Button) findViewById(R.id.callUs);

        regTVBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, TV.class); // From here to there

            //  go to next activity
            startActivity(intent);
            finish();
        });

        regPhoneBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, Phone.class); // From here to there

            // go to next activity
            startActivity(intent);
            finish();
        });

        regCallBtn.setOnClickListener(v -> {


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
}