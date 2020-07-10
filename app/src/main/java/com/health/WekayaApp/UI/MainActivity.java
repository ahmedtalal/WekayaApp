package com.health.WekayaApp.UI;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.health.WekayaApp.Adapter.MyReciever;
import com.health.WekayaApp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.toolbar_id)
    Toolbar toolbarId;
    @BindView(R.id.framelayout_id)
    FrameLayout framelayoutId;
    @BindView(R.id.bottomNavigation_id)
    BottomNavigationView bottomNavigationId;
    @BindView(R.id.navigationview_id)
    NavigationView navigationviewId;
    @BindView(R.id.drawer_id)
    DrawerLayout drawerId;

    private ActionBarDrawerToggle aToggle ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme4);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        navigationviewId.setItemIconTintList(null);
        aToggle = new ActionBarDrawerToggle(this , drawerId , toolbarId , R.string.close , R.string.open) ;
        drawerId.addDrawerListener(aToggle);
        aToggle.syncState();
        navigationviewId.setNavigationItemSelectedListener(this::onNavigationItemSelected);
        bottomNavigationId.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
        loadFragment(new StatisticsFragment(MainActivity.this));
        createNotification() ;
    }

    // this method is used to call the myreciever class to create notification when app is closed
    private void createNotification() {
        // set the first time
        Calendar calendar = Calendar.getInstance() ;
        calendar.set(Calendar.HOUR_OF_DAY , 8);
        calendar.set(Calendar.MINUTE , 30);
        calendar.set(Calendar.SECOND , 0);
        calendar.set(Calendar.MILLISECOND , 0);
        Calendar car = Calendar.getInstance() ;
        if (car.after(calendar)){
            calendar.add(Calendar.DATE , 1);
        }
        AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
            Intent intent = new Intent(this, MyReciever.class);
            //intent.putExtra("myAction", "mDoNotify");
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 10006, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY , pendingIntent);


            // set the second time ----------------------->>>>>>---------------------- >>
        Calendar calendar2 = Calendar.getInstance() ;
        calendar2.set(Calendar.HOUR_OF_DAY , 13);
        calendar2.set(Calendar.MINUTE , 30);
        calendar2.set(Calendar.SECOND , 0);
        calendar2.set(Calendar.MILLISECOND , 0);
        Calendar car2 = Calendar.getInstance() ;
        if (car2.after(calendar2)){
            calendar2.add(Calendar.DATE , 1);
        }
        AlarmManager am2 = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent intent2 = new Intent(this, MyReciever.class);
        //intent.putExtra("myAction", "mDoNotify");
        PendingIntent pendingIntent2 = PendingIntent.getBroadcast(this, 10007, intent2, PendingIntent.FLAG_UPDATE_CURRENT);
        am2.setRepeating(AlarmManager.RTC_WAKEUP, calendar2.getTimeInMillis(),AlarmManager.INTERVAL_DAY , pendingIntent2);

        // set the third time ----------------------->>>>>>>>>--------------------------->>>
        Calendar calendar3 = Calendar.getInstance() ;
        calendar3.set(Calendar.HOUR_OF_DAY , 18);
        calendar3.set(Calendar.MINUTE , 20);
        calendar3.set(Calendar.SECOND , 0);
        calendar3.set(Calendar.MILLISECOND , 0);
        Calendar car3 = Calendar.getInstance() ;
        if (car3.after(calendar3)){
            calendar3.add(Calendar.DATE , 1);
        }
        AlarmManager am3 = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent intent3 = new Intent(this, MyReciever.class);
        //intent.putExtra("myAction", "mDoNotify");
        PendingIntent pendingIntent3 = PendingIntent.getBroadcast(this, 10008, intent3, PendingIntent.FLAG_UPDATE_CURRENT);
        am3.setRepeating(AlarmManager.RTC_WAKEUP, calendar3.getTimeInMillis(),AlarmManager.INTERVAL_DAY , pendingIntent3);

        // set the fourth time ----------------------->>>>>>>>>--------------------------->>>
        Calendar calendar4 = Calendar.getInstance() ;
        calendar4.set(Calendar.HOUR_OF_DAY , 22);
        calendar4.set(Calendar.MINUTE , 10);
        calendar4.set(Calendar.SECOND , 0);
        calendar4.set(Calendar.MILLISECOND , 0);
        Calendar car4 = Calendar.getInstance() ;
        if (car4.after(calendar4)){
            calendar4.add(Calendar.DATE , 1);
        }
        AlarmManager am4 = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent intent4 = new Intent(this, MyReciever.class);
        //intent.putExtra("myAction", "mDoNotify");
        PendingIntent pendingIntent4 = PendingIntent.getBroadcast(this, 10009, intent4, PendingIntent.FLAG_UPDATE_CURRENT);
        am4.setRepeating(AlarmManager.RTC_WAKEUP, calendar4.getTimeInMillis(),AlarmManager.INTERVAL_DAY , pendingIntent4);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId() ;
        Fragment fragment = null ;
        switch (id){
            case R.id.share :
                movingBetweenApp(1) ;
                break;
            case R.id.Rate :
                movingBetweenApp(2) ;
                break;
            case R.id.Aboutus :
                movingBetweenApp(3) ;
                break;
            case R.id.contactus :
                movingBetweenApp(4) ;
                break;
            case R.id.nav_stats :
                toolbarId.setTitle("الاحصائيات");
                fragment = new StatisticsFragment(MainActivity.this) ;
                loadFragment(fragment ) ;
                break;
            case R.id.nav_news :
                toolbarId.setTitle("الاخبار اليوميه");
                fragment = new NewsFragment(MainActivity.this) ;
                loadFragment(fragment );
                break;
            case R.id.nav_proection :
                toolbarId.setTitle("طرق الوقايه");
                fragment = new ProtectionFragment(MainActivity.this) ;
                loadFragment(fragment );
                break;
            case R.id.nav_covid :
                toolbarId.setTitle("معلومات عن كوفيد 19");
                fragment = new CovquestionsFragment(MainActivity.this) ;
                loadFragment(fragment );
                break;

        }
        return true;
    }

    // this method is used to load fragment
    private void loadFragment(Fragment fragment ) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction() ;
        transaction.replace(R.id.framelayout_id , fragment ) ;
        //transaction.addToBackStack(null);
        transaction.commit() ;
    }


    // moving between activities
    private void movingBetweenApp(int i) {
        Intent intent ;
        switch (i){
            case 1 :
                intent = new Intent(MainActivity.this , ShareActivity.class) ;
                startActivity(intent);
                finish();
                break;
            case 2 :
                intent = new Intent(MainActivity.this , RatingActivity.class) ;
                startActivity(intent);
                finish();
                break;
            case 3 :
                intent = new Intent(MainActivity.this , AboutusActivity.class) ;
                startActivity(intent);
                finish();
                break;
            case 4 :
                intent = new Intent(MainActivity.this , ContactusActivity.class) ;
                startActivity(intent);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation_id) ;
        if (bottomNavigationView.getSelectedItemId() == R.id.nav_stats){
            super.onBackPressed();
            finish();
        }else {
            bottomNavigationView.setSelectedItemId(R.id.nav_stats);
        }
    }

}
