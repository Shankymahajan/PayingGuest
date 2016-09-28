package com.example.uddishverma.pg_app_beta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//TODO complete the click events of addPg and deletePg

/**
 * This activity gets called when the user clicks on the My Account section in the navigation drawer
 */
public class MyAccountPage extends AppCompatActivity {

    public static final String TAG = "MyAccountPage";

    TextView name, email, noOfPg;
    Button addPG, deletePG, signOut, deleteAccount;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account_page);

        name = (TextView) findViewById(R.id.myacc_name);
        email = (TextView) findViewById(R.id.myacc_id);
        noOfPg = (TextView) findViewById(R.id.myacc_no);

        addPG = (Button) findViewById(R.id.myacc_addpg);
        deletePG = (Button) findViewById(R.id.myacc_deletepg);
        signOut = (Button) findViewById(R.id.myacc_signout);
        deleteAccount = (Button) findViewById(R.id.myacc_deleteacc);

        firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser user = firebaseAuth.getCurrentUser();

        name.setText(user.getDisplayName().toString());
        email.setText(user.getEmail());
        Log.d(TAG, "onCreate: " + user.getPhotoUrl());

        //Setting the click events on the sign out button
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                Toast.makeText(MyAccountPage.this, "You Are Signed Out!", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        //Setting click events on the Delete Account button
        deleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterPG.firebaseRef  = new Firebase("https://pgapp-c51ce.firebaseio.com/");
//                RegisterPG.firebaseRef.removeUser();
            }
        });

    }
}
