package mrcof.code.senior_tech_support_app;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import static mrcof.code.senior_tech_support_app.R.id.result_list;

public class Phone extends AppCompatActivity {

    private static final String TAG = Phone.class.getName();
    private EditText mSearchField;
    private ImageButton mSearchBtn,mBackBtn;
    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    //private FirebaseRecyclerAdapter adapter;
    //private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_phone);

        //databaseReference = FirebaseDatabase.getInstance().getReference("TV"); // TV in Database

        mSearchField = (EditText) findViewById(R.id.search_field);
        mSearchBtn = (ImageButton) findViewById(R.id.search_btn);
        mBackBtn = (ImageButton) findViewById(R.id.back_btn);

        recyclerView = (RecyclerView) findViewById(result_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        databaseReference = FirebaseDatabase.getInstance().getReference("Phone"); // TV in Database

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
                Intent intent = new Intent(Phone.this, Dashboard.class); // From here to there

                // After saving user name go to next activity
                startActivity(intent);
                finish();
            }
        });

    }


    private void firebaseSearch(String searched){
        String query = searched;
        Query firebaseSearchQuery = databaseReference.orderByChild("socialmedia").startAt(query).endAt( query + "\uf8ff");

        FirebaseRecyclerOptions<socialMedia> options = new FirebaseRecyclerOptions.Builder<socialMedia>().setQuery(firebaseSearchQuery, socialMedia.class).setLifecycleOwner(this).build();

        FirebaseRecyclerAdapter<socialMedia, ViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<socialMedia, ViewHolder>(options) {
            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.phone_list_layout, parent, false);
                return new ViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull socialMedia model) {
                holder.setDetails(getApplicationContext(), model.getSocialmedia(), model.getImage());
            }
        };

        firebaseRecyclerAdapter.startListening();
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<socialMedia> options = new FirebaseRecyclerOptions.Builder<socialMedia>().setQuery(databaseReference, socialMedia.class).setLifecycleOwner(this).build();

        FirebaseRecyclerAdapter<socialMedia, ViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<socialMedia, ViewHolder>(options) {
            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.phone_list_layout, parent, false);
                return new ViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull socialMedia model) {
                holder.setDetails(getApplicationContext(), model.getSocialmedia(), model.getImage());
            }
        };

        firebaseRecyclerAdapter.startListening();
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    //Use a recyclerview to storage the items
    public static class ViewHolder extends RecyclerView.ViewHolder {

        View mView;
        TextView socialMedia;
        ImageView socialMedia_img;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            mView = itemView;


        }

        //This is where it gets the context that is store in the firebase
        public void setDetails(Context ctx, String socialmedia, String socialMediaImage){

            socialMedia = (TextView) mView.findViewById(R.id.sm_name);
            socialMedia_img = (ImageView) mView.findViewById(R.id.sm_image);
            parentLayout = mView.findViewById(R.id.parent_layout); // Parent Layout is list_layout.xml

            socialMedia.setText(socialmedia);

            Glide.with(ctx).load(socialMediaImage).into(socialMedia_img);

            parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onclick on"+socialmedia);

                    Context context = v.getContext();
                    Intent intent = new Intent(context, PhoneInfo.class);
                    intent.putExtra("socialMediaImage",socialMediaImage);
                    intent.putExtra("socialMedia",socialmedia);
                    context.startActivity(intent);


                }
            });



        }

    }

}