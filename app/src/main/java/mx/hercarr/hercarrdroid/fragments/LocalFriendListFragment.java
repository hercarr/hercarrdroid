package mx.hercarr.hercarrdroid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.hercarr.hercarrdroid.R;

public class LocalFriendListFragment extends Fragment {

    public LocalFriendListFragment() {

    }

    public static LocalFriendListFragment newInstance() {
        LocalFriendListFragment fragment = new LocalFriendListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_local_friend_list, container, false);
    }

}