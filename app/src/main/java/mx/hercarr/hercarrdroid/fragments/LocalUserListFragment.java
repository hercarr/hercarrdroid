package mx.hercarr.hercarrdroid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.hercarr.hercarrdroid.R;

public class LocalUserListFragment extends Fragment {

    public LocalUserListFragment() {

    }

    public static LocalUserListFragment newInstance() {
        LocalUserListFragment fragment = new LocalUserListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_local_user_list, container, false);
    }

}