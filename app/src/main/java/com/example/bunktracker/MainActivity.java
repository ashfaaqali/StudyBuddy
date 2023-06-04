package com.example.bunktracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private long backPressedTime = 0;    // used by onBackPressed()
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    TextView name, email;
    Button signOut;

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.main_view_pager);

        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Sharing"));
        tabLayout.addTab(tabLayout.newTab().setText("Schedule"));
        tabLayout.addTab(tabLayout.newTab().setText("My Notes"));
        tabLayout.addTab(tabLayout.newTab().setText("More"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                viewPagerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

//        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
//        gsc = GoogleSignIn.getClient(this, gso);
//
//        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
//        if (acct!=null){
//            String username = acct.getDisplayName();
//            name.setText(username);
//            String emailAddress = acct.getEmail();
//            email.setText(emailAddress);
//        }
////        signOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //If the user who logged in with google account is currently logged in
//                if (acct!=null){
//                    gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            finish();
//                            startActivity(new Intent(getApplicationContext(), IntroductoryActivity.class));
//                            finish();
//
//                        }
//                    });
//                } else{
//                    FirebaseAuth.getInstance().signOut();
//                    finish();
//                    startActivity(new Intent(getApplicationContext(), IntroductoryActivity.class));
//                    finish();
//                }
//
//            }
//        });
    }
    @Override
    public void onBackPressed() {        // to prevent irritating accidental logouts
        long t = System.currentTimeMillis();
        if (t - backPressedTime > 2000) {    // 2 secs
            backPressedTime = t;
            Toast.makeText(this, "Press back again to exit",
                    Toast.LENGTH_SHORT).show();
        } else {    // this guy is serious
            // clean up
            super.onBackPressed();       // bye
        }
    }
}