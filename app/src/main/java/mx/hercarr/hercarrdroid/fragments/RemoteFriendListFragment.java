package mx.hercarr.hercarrdroid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
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
import mx.hercarr.hercarrdroid.view.IFriendsView;

public class RemoteFriendListFragment extends Fragment
    implements IFriendsView {

    private FriendsPresenter presenter;

    private RecyclerView rvFriends;
    private TextView lblEmptyFriends;
    private SwipeRefreshLayout srlRemoteFriends;

    private FriendsAdapter adapter;

    public RemoteFriendListFragment() {

    }

    public static RemoteFriendListFragment newInstance() {
        RemoteFriendListFragment fragment = new RemoteFriendListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remote_friend_list, container, false);
        init(view);
        presenter.findRemoteFriends();
        return view;
    }

    @Override
    public void loadFriendList(List<Friend> friends) {
        rvFriends.setVisibility(View.VISIBLE);
        lblEmptyFriends.setVisibility(View.GONE);
        setRecyclerView(friends);
        if (srlRemoteFriends.isRefreshing()) {
            srlRemoteFriends.setRefreshing(false);
        }
    }

    @Override
    public void showEmptyMessage() {
        rvFriends.setVisibility(View.GONE);
        lblEmptyFriends.setVisibility(View.VISIBLE);
    }

    private void init(View view) {
        presenter = new FriendsPresenter(this);
        rvFriends = (RecyclerView) view.findViewById(R.id.rvFriends);
        lblEmptyFriends = (TextView) view.findViewById(R.id.lblEmptyFriends);
        srlRemoteFriends = (SwipeRefreshLayout) view.findViewById(R.id.srlRemoteFriends);
        setRecyclerView(null);
        setSwipeRefreshLayout();
    }

    private void setRecyclerView(List<Friend> friends) {
        adapter = new FriendsAdapter(getActivity(), friends, R.layout.card_view_friend);
        rvFriends.setAdapter(adapter);
        rvFriends.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvFriends.setHasFixedSize(true);
    }

    private void setSwipeRefreshLayout() {
        srlRemoteFriends.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.findRemoteFriends();
            }
        });
        srlRemoteFriends.setColorSchemeColors(
                ContextCompat.getColor(getActivity(), R.color.primary_dark),
                ContextCompat.getColor(getActivity(), R.color.accent),
                ContextCompat.getColor(getActivity(), R.color.primary_dark)
        );
    }

}