package mrcof.code.senior_tech_support_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {

    //Variables
    TextInputLayout regName;
    Button regSkipBtn, regNextBtn, regCallBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        //Hooks
        regName = findViewById(R.id.username);
        regNextBtn = (Button) findViewById(R.id.next);
        regSkipBtn = (Button) findViewById(R.id.skip);
        regCallBtn = (Button) findViewById(R.id.callUs);

        //Init Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("Users");

        //Save data in Firebase on button click "NEXT"
        regNextBtn.setOnClickListener(view -> {

            // get all the values
            String name = regName.getEditText().getText().toString();

            UserHelperClass helperClass = new UserHelperClass(name);
            if(name.equals("")) {
                name = ("Senior");
            }
            reference.child(name).setValue(name);

            Intent intent = new Intent(Login.this, Dashboard.class); // From here to there

            // After saving user name go to next activity
            startActivity(intent);
            finish();

        });// end of "NEXT" button method

        regSkipBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, Dashboard.class); // From here to there

            // After saving user name go to next activity
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