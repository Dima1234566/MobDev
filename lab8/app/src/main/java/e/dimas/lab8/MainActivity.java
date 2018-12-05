package e.dimas.lab8;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import e.dimas.lab8.favourite.FavouriteFragment;
import e.dimas.lab8.list.ListFragment;
import e.dimas.lab8.navigation.FragmentNavigation;


public class MainActivity extends AppCompatActivity {
    FragmentNavigation fragmentNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentNavigation = new FragmentNavigation(getSupportFragmentManager());
        fragmentNavigation.swapFragments(ListFragment.newInstance());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {

            case R.id.home:
                fragment = ListFragment.newInstance();
                break;
            case R.id.favorites:
                fragment = FavouriteFragment.newInstance();
                break;
        }
        fragmentNavigation.swapFragments(fragment);
        return false;
    }

}
