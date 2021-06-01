package com.creatures.mycustomnavigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SNavigationDrawer s_navigation_drawer;
    Class aClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s_navigation_drawer=(SNavigationDrawer)findViewById(R.id.my_navigation_drawer);
        //Initialize menu item
        List<MenuItem> menu_items = new ArrayList<>();
        //ADD MENU ITEMS
        menu_items.add(new MenuItem("Show Event",R.drawable.new_event_1));
        menu_items.add(new MenuItem("Add Events",R.drawable.message_bg));



        //Set Menu Item list
        s_navigation_drawer.setMenuItemList(menu_items);
        //Set Default Title
        s_navigation_drawer.setAppbarTitleTV("Events");

        s_navigation_drawer.setAppbarColor(R.color.white);
        //Set Default Fragment
        aClass=ShowEventFragment.class;
        //Open Fragment
        openFragment();
        //Menu item Click listener
        s_navigation_drawer.setOnMenuItemClickListener(new SNavigationDrawer.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int position) {
                switch (position)
                {
                    case 0:
                        aClass=ShowEventFragment.class;

                        s_navigation_drawer.setMenuiconTintColor(R.color.green);
                        break;
                    case 1:
                        aClass=AddEventsFragment.class;

                        s_navigation_drawer.setMenuiconTintColor(R.color.yellow);
                        break;
                }
            }
        });

        s_navigation_drawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {
            @Override
            public void onDrawerOpening() {

            }

            @Override
            public void onDrawerClosing() {
                //Open Fragment
                openFragment();
            }

            @Override
            public void onDrawerOpened() {

            }

            @Override
            public void onDrawerClosed() {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    private void openFragment() {
        try
        {
            //Initialize fragment
            Fragment fragment = (Fragment) aClass.newInstance();
            //open fragment
            getSupportFragmentManager().beginTransaction().setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out).replace(R.id.navigation_frame_Layout,fragment).commit();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }


    }


}