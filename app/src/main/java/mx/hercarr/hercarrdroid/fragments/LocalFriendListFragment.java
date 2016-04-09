package mx.hercarr.hercarrdroid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mx.hercarr.hercarrdroid.R;
import mx.hercarr.hercarrdroid.adapters.FriendsAdapter;
import mx.hercarr.hercarrdroid.model.Friend;
import mx.hercarr.hercarrdroid.presenter.FriendsPresenter;
import mx.hercarr.hercarrdroid.util.DividerItemDecoration;
import mx.hercarr.hercarrdroid.view.IFriendsView;

public class LocalFriendListFragment extends Fragment
    implements IFriendsView {

    private FriendsPresenter presenter;

    private RecyclerView rvFriends;
    private TextView lblEmptyFriends;

    private FriendsAdapter adapter;

    public LocalFriendListFragment() {

    }

    public static LocalFriendListFragment newInstance() {
        LocalFriendListFragment fragment = new LocalFriendListFragment();
        return fragment;
    }

    public void init(View view) {
        presenter = new FriendsPresenter(this);
        rvFriends = (RecyclerView) view.findViewById(R.id.rvFriends);
        lblEmptyFriends = (TextView) view.findViewById(R.id.lblEmptyFriends);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_local_friend_list, container, false);
        init(view);
        presenter.findFriends();
        return view;
    }

    @Override
    public void loadFriendList(List<Friend> friends) {
        rvFriends.setVisibility(View.VISIBLE);
        lblEmptyFriends.setVisibility(View.GONE);
        setRecyclerView(friends);
    }

    @Override
    public void showEmptyMessage() {
        rvFriends.setVisibility(View.GONE);
        lblEmptyFriends.setVisibility(View.VISIBLE);
    }

    private void setRecyclerView(List<Friend> friends) {
        adapter = new FriendsAdapter(getActivity(), friends);
        rvFriends.setAdapter(adapter);
        rvFriends.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvFriends.setHasFixedSize(true);
        rvFriends.addItemDecoration(new DividerItemDecoration(getActivity(), null));
    }

}