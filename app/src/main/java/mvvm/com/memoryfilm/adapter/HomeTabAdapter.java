package mvvm.com.memoryfilm.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class HomeTabAdapter extends FragmentPagerAdapter {

    private Fragment fragment1 = new Fragment ();
    private Fragment fragment2 = new Fragment ();
    private Fragment fragment3 = new Fragment ();

    public HomeTabAdapter(FragmentManager fm) {
        super (fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return fragment1;
            case 1:
                return fragment2;
            case 2:
                return fragment3;
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
