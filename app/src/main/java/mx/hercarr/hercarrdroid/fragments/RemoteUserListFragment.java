package mx.hercarr.hercarrdroid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.hercarr.hercarrdroid.R;

public class RemoteUserListFragment extends Fragment {

    public RemoteUserListFragment() {

    }

    public static RemoteUserListFragment newInstance() {
        RemoteUserListFragment fragment = new RemoteUserListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_remote_user_list, container, false);
    }

}
