package com.example.eslam.navigatiodrawerdemooooo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.eslam.navigatiodrawerdemooooo.Fragments.EventFragments;
import com.example.eslam.navigatiodrawerdemooooo.Fragments.HomeFragments;
import com.example.eslam.navigatiodrawerdemooooo.Fragments.ProfileFragments;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Button mHome;
    private Button mEvents;
    private Button mProfile;
    private Fragment mFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindWidget();

        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mFragment = new HomeFragments();
        setFragment(mFragment);

        mHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFragment = new HomeFragments();
                setFragment(mFragment);
                mDrawerLayout.closeDrawer(GravityCompat.START);
                Snackbar.make(view, "Welcome To Home Page", Snackbar.LENGTH_SHORT).show();

            }
        });
        mEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFragment = new EventFragments();
                setFragment(mFragment);
                mDrawerLayout.closeDrawer(GravityCompat.START);
                Snackbar.make(view, "Welcome To Events Page", Snackbar.LENGTH_SHORT).show();

            }
        });
        mProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFragment = new ProfileFragments();
                setFragment(mFragment);
                mDrawerLayout.closeDrawer(GravityCompat.START);
                Snackbar.make(view, "Welcome To Profile Page", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    private void bindWidget() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        mHome = (Button) findViewById(R.id.home);
        mEvents = (Button) findViewById(R.id.event);
        mProfile = (Button) findViewById(R.id.profile);
    }

    private void setFragment(Fragment mFragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content_frame, mFragment);
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
