package mx.hercarr.hercarrdroid.fragments;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mx.hercarr.hercarrdroid.R;

public class ViewPagerFragment extends Fragment {

    private AppBarLayout appBarLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public ViewPagerFragment() {

    }

    public static ViewPagerFragment newInstance() {
        ViewPagerFragment fragment = new ViewPagerFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);
        init(view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        appBarLayout.removeView(tabLayout);
    }

    private void init(View view) {
        appBarLayout = (AppBarLayout) getActivity().findViewById(R.id.appBarLayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        setViewPager();
        setTabLayout();
        setIcons();
    }

    public void setViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(LocalFriendListFragment.newInstance());
        adapter.addFragment(RemoteFriendListFragment.newInstance());
        viewPager.setAdapter(adapter);
    }

    private void setTabLayout() {
        AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(AppBarLayout.LayoutParams.MATCH_PARENT, AppBarLayout.LayoutParams.WRAP_CONTENT);
        tabLayout = new TabLayout(getActivity());
        tabLayout.setLayoutParams(layoutParams);
        tabLayout.setupWithViewPager(viewPager);
        appBarLayout.addView(tabLayout);
    }

    public void setIcons() {
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_list_white_24dp);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_cloud_white_24dp);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments;

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
            fragments = new ArrayList<>();
        }

        public void addFragment(Fragment fragment) {
            fragments.add(fragment);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

    }

}