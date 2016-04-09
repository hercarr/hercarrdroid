package mx.hercarr.hercarrdroid.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mx.hercarr.hercarrdroid.R;
import mx.hercarr.hercarrdroid.model.Friend;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.FriendViewHolder> {

    private List<Friend> friends;

    public FriendsAdapter(List<Friend> friends) {
        this.friends = friends;
    }

    @Override
    public FriendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_friend, parent, false);
        return new FriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FriendViewHolder holder, int position) {
        holder.bindFriend(friends.get(position));
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    protected class FriendViewHolder extends RecyclerView.ViewHolder {

        private TextView lblName;
        private TextView lblEmail;
        private TextView lblCell;

        public FriendViewHolder(View itemView) {
            super(itemView);
            lblName = (TextView) itemView.findViewById(R.id.lblName);
            lblEmail = (TextView) itemView.findViewById(R.id.lblEmail);
            lblCell = (TextView) itemView.findViewById(R.id.lblCell);
        }

        public void bindFriend(Friend friend) {
            lblName.setText(friend.getFirstName() + " " + friend.getLastName());
            lblEmail.setText(friend.getEmail());
            lblCell.setText(friend.getCell());
        }

    }

}