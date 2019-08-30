package com.example.keyaanapplication.activities;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.keyaanapplication.fragments.InboxFragment;
import com.example.keyaanapplication.fragments.MeFragment;
import com.example.keyaanapplication.R;
import com.example.keyaanapplication.fragments.WMGDealsFragment;

import de.hdodenhof.circleimageview.CircleImageView;

public class Navigation_drawer extends AppCompatActivity {


    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private CircleImageView imgNavHeaderBg;
    CircleImageView imgProfile;
    private TextView txtName, txtWebsite;
    private Toolbar toolbar;

    public static int navItemIndex = 0;

    // tags used to attach the fragments
    private static final String TAG_ME = "me";

    private static final String TAG_INBOX = "inbox";
    private static final String TAG_WMGDEALS = "wmg_deals";
    private static final String TAG_jOINWEDDING = "join_a_wdding";
    private static final String TAG_CREATEWEDDING = "create_wedding";
    private static final String TAG_GENIESERVICE = "genie_service";
    private static final String TAG_WRITEREVIEW = "write_a_review";
    private static final String TAG_PROMOTIONS = "promotions";
    private static final String TAG_CONTACTSUPPORT = "contact_support";
    private static final String TAG_RATEPLAYSTORE = "rate_playstore";
    private static final String TAG_SHAREAPP = "share_app";
    private static final String TAG_ABOUT = "about";
    public static String CURRENT_TAG = TAG_INBOX;

    // toolbar titles respected to selected nav menu item
    private String[] activityTitles;

    // flag to load home fragment when user presses back key
    private boolean shouldLoadHomeFragOnBackPress = true;
    private Handler mHandler;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mHandler = new Handler();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);

        // Navigation view header
        navHeader = navigationView.getHeaderView(0);


        imgNavHeaderBg = (CircleImageView) navHeader.findViewById(R.id.img_header_bg);

        // load the store fragment by default
        navigationView.setBackgroundColor(getResources().getColor(R.color.colorPrimaryWhite));

        setUpNavigationView();

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_ME;
            loadHomeFragment();
        }
    }

    @Override
    public void onBackPressed() {

        doExit();
    }

    private void doExit() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                Navigation_drawer.this);

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialog.setNegativeButton("No", null);

        alertDialog.setMessage("Do you want to exit?");
        alertDialog.setTitle("AppTitle");

        AlertDialog dialog = alertDialog.create();
        dialog.show();

        dialog.getWindow().setBackgroundDrawableResource(android.R.color.darker_gray);
// Get the alert dialog buttons reference
        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);

        // Change the alert dialog buttons text and background color
        positiveButton.setTextColor(Color.parseColor("#FF0B8B42"));
//        positiveButton.setBackgroundColor(Color.parseColor("#FFE1FCEA"));

        negativeButton.setTextColor(Color.parseColor("#FFFF0400"));
//        negativeButton.setBackgroundColor(Color.parseColor("#FFFCB9B7"));





    }

    private void loadHomeFragment() {
        selectNavMenu();

        // set toolbar title
        setToolbarTitle();

        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();
            return;
        }

        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }


        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }

    private void setToolbarTitle() {
        getSupportActionBar().setTitle(activityTitles[navItemIndex]);
    }


    private void selectNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }

    private Fragment getHomeFragment() {

        switch (navItemIndex) {
            case 0:
                // home
                MeFragment meFragment = new MeFragment();
                return meFragment;
            case 1:
                // home
                InboxFragment inboxFragment = new InboxFragment();
                return inboxFragment;
            case 2:
                // photos
                WMGDealsFragment wmgdealsFragment1 = new WMGDealsFragment();
                return wmgdealsFragment1;
            case 3:
                // movies fragment
                InboxFragment inboxFragment2 = new InboxFragment();
                return inboxFragment2;
            case 4:
                // notifications fragment
                InboxFragment notificationsFragment = new InboxFragment();
                return notificationsFragment;

            case 5:
                // settings fragment
                InboxFragment settingsFragment = new InboxFragment();
                return settingsFragment;
            case 6:
                // home
                InboxFragment inboxFragment3 = new InboxFragment();
                return inboxFragment3;
            case 7:
                // photos
                InboxFragment inboxFragment1 = new InboxFragment();
                return inboxFragment1;
            case 8:
                // movies fragment
                InboxFragment inboxFragment4 = new InboxFragment();
                return inboxFragment4;
            case 9:
                // notifications fragment
                InboxFragment notificationsFragment1 = new InboxFragment();
                return notificationsFragment1;

            case 10:
                // settings fragment
                InboxFragment settingsFragment1 = new InboxFragment();
                return settingsFragment1;
            case 11:
                // settings fragment
                InboxFragment settingsFragment2 = new InboxFragment();
                return settingsFragment2;
            default:
                return new MeFragment();
        }
    }

    private void setUpNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.nav_me:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_ME;
                        break;
                    case R.id.nav_inbox:
                        navItemIndex = 1;
                        CURRENT_TAG = TAG_INBOX;
                        break;
                    case R.id.nav_wmg_deals:
                        navItemIndex = 2;
                        CURRENT_TAG = TAG_WMGDEALS;
                        break;
                    case R.id.nav_join_wedding:
                        navItemIndex = 3;
                        CURRENT_TAG = TAG_jOINWEDDING;
                        break;
                    case R.id.nav_create_wedding:
                        navItemIndex = 4;
                        CURRENT_TAG = TAG_CREATEWEDDING;
                        break;
                    case R.id.nav_genie_services:
                        navItemIndex = 5;
                        CURRENT_TAG = TAG_GENIESERVICE;
                        break;
                    case R.id.nav_write_review:
                        navItemIndex = 6;
                        CURRENT_TAG = TAG_WRITEREVIEW;
                        break;

                    case R.id.nav_Promotions:
                        navItemIndex = 7;
                        CURRENT_TAG = TAG_PROMOTIONS;
                        break;

                    case R.id.nav_contact_support:
                        navItemIndex = 8;
                        CURRENT_TAG = TAG_CONTACTSUPPORT;
                        break;
                    case R.id.nav_Rate_Play_Store:
                        navItemIndex = 10;
                        CURRENT_TAG = TAG_RATEPLAYSTORE;
                        break;
                    case R.id.nav_share_app:
                        navItemIndex = 11;
                        CURRENT_TAG = TAG_SHAREAPP;
                        break;
                    case R.id.nav_about:
                        navItemIndex = 12;
                        CURRENT_TAG = TAG_ABOUT;
                        break;

                    default:
                        navItemIndex = 0;
                }

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                loadHomeFragment();

                return true;
            }
        });

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }

}



