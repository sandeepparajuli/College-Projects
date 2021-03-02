package mrcof.code.senior_tech_support_app;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

import static mrcof.code.senior_tech_support_app.R.id.brand_name;
import static mrcof.code.senior_tech_support_app.R.id.parent_layout;
import static mrcof.code.senior_tech_support_app.R.id.position;
import static mrcof.code.senior_tech_support_app.R.id.result_list;

public class TV extends AppCompatActivity {

    private static final String TAG = TV.class.getName();
    private EditText mSearchField;
    private ImageButton mSearchBtn, mBackBtn;
    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    //private FirebaseRecyclerAdapter adapter;
    //private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_tv);

        mSearchField = (EditText) findViewById(R.id.search_field);
        mSearchBtn = (ImageButton) findViewById(R.id.search_btn);
        mBackBtn = (ImageButton) findViewById(R.id.back_btn);

        recyclerView = (RecyclerView) findViewById(result_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        databaseReference = FirebaseDatabase.getInstance().getReference("TV"); // TV in Database

        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String searchText = mSearchField.getText().toString();

                firebaseSearch(searchText);

            }
        });

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TV.this, Dashboard.class); // From here to there

                // After saving user name go to next activity
                startActivity(intent);
                finish();
            }
        });

    }


    private void firebaseSearch(String searched){
        String query = searched; // query is set to User Input in Search Bar
        Query firebaseSearchQuery = databaseReference.orderByChild("brand").startAt(query).endAt( query + "\uf8ff");

        //Use firebaseSearchQuery  to setQuery
        FirebaseRecyclerOptions<Users> options = new FirebaseRecyclerOptions.Builder<Users>().setQuery(firebaseSearchQuery, Users.class).setLifecycleOwner(this).build();

        FirebaseRecyclerAdapter<Users, ViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Users, ViewHolder>(options) {
            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
                return new ViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Users model) {
                holder.setDetails(getApplicationContext(), model.getBrand(), model.getImage());
            }
        };

        firebaseRecyclerAdapter.startListening();
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    // It must databaseReference instead of firebaseRecyclerAdapter like in firebaseSearch() otherwise firebase will ignore images
    @Override
    protected void onStart() {
        super.onStart(); // Start Pulling from Database
        //Use databaseReference  to setQuery
        FirebaseRecyclerOptions<Users> options = new FirebaseRecyclerOptions.Builder<Users>().setQuery(databaseReference, Users.class).setLifecycleOwner(this).build();

        FirebaseRecyclerAdapter<Users, ViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Users, ViewHolder>(options) {
            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
                return new ViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Users model) {
                holder.setDetails(getApplicationContext(), model.getBrand(), model.getImage());
            }

        };

        firebaseRecyclerAdapter.startListening();
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    //Use a recyclerview to storage the items
    public static class ViewHolder extends RecyclerView.ViewHolder{

        View mView;
        TextView brand;
        ImageView brand_img;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            mView = itemView;


        }

        //This is where it gets the context that is store in the firebase
        public void setDetails(Context ctx, String brandName, String brandImage){

            brand = (TextView) mView.findViewById(R.id.brand_name); // brand name
            brand_img = (ImageView) mView.findViewById(R.id.brand_image); // brand image
            parentLayout = mView.findViewById(R.id.parent_layout); // Parent Layout is list_layout.xml

            brand.setText(brandName);

            Glide.with(ctx).load(brandImage).into(brand_img);

            parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onclick on"+brandName);

                    Context context = v.getContext();
                    Intent intent = new Intent(context, TvInfo.class);
                    intent.putExtra("brand_img",brandImage);
                    intent.putExtra("brand_name",brandName);
                    context.startActivity(intent);


                }
            });

        }

    }

}