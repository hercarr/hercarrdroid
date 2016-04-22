package mx.hercarr.hercarrdroid.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.hercarr.hercarrdroid.R;

public class ViewPagerFragment extends Fragment
    implements TabLayout.OnTabSelectedListener {

    private AppBarLayout appBarLayout;
    private TabLayout tabLayout;

    private LocalFriendListFragment localFriendListFragment;
    private RemoteFriendListFragment remoteFriendListFragment;

    public ViewPagerFragment() {

    }

    public static ViewPagerFragment newInstance() {
        ViewPagerFragment fragment = new ViewPagerFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        init();
        return inflater.inflate(R.layout.fragment_view_pager, container, false);
    }

    private void init() {
        appBarLayout = (AppBarLayout) getActivity().findViewById(R.id.appBarLayout);
        localFriendListFragment = LocalFriendListFragment.newInstance();
        remoteFriendListFragment = RemoteFriendListFragment.newInstance();
        setTabLayout();
        setTabs();
    }

    private void setTabLayout() {
        AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(AppBarLayout.LayoutParams.MATCH_PARENT, AppBarLayout.LayoutParams.WRAP_CONTENT);
        tabLayout = new TabLayout(getActivity());
        tabLayout.setLayoutParams(layoutParams);
        tabLayout.setOnTabSelectedListener(this);
        appBarLayout.addView(tabLayout);
    }

    private void setTabs() {
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_list_white_24dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_cloud_white_24dp));
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.frameVPLayout, fragment)
                .commit();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int position = tab.getPosition();
        switch (position) {
            case 0:
                replaceFragment(localFriendListFragment);
                break;
            case 1:
                replaceFragment(remoteFriendListFragment);
                break;
            default:
                break;
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {}

    @Override
    public void onTabReselected(TabLayout.Tab tab) {}

}