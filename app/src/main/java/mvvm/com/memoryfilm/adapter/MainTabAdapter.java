package mvvm.com.memoryfilm.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import mvvm.com.memoryfilm.view.fragment.HomeFragment;
import mvvm.com.memoryfilm.view.fragment.StudioFragment;
import mvvm.com.memoryfilm.view.fragment.UserFragment;

public class MainTabAdapter extends FragmentPagerAdapter {

    private HomeFragment homeFragment = HomeFragment.newInstance ();
    private StudioFragment studioFragment = StudioFragment.newInstance ();
    private UserFragment userFragment = UserFragment.newInstance ();


    public MainTabAdapter(FragmentManager fm) {
        super (fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return homeFragment;
            case 1:
                return studioFragment;
            case 2:
                return userFragment;
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
