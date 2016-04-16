package mx.hercarr.hercarrdroid.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import mx.hercarr.hercarrdroid.R;
import mx.hercarr.hercarrdroid.model.Friend;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.FriendViewHolder> {

    private final Context context;
    private final int layoutId;
    private List<Friend> friends;

    public FriendsAdapter(Context context, List<Friend> friends, int layoutId) {
        this.context = context;
        this.layoutId = layoutId;
        if (friends != null)
            this.friends = friends;
        else
            this.friends = new ArrayList<>();
    }

    @Override
    public FriendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(layoutId, parent, false);
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

        private ImageView imgProfile;
        private TextView lblName;
        private TextView lblEmail;
        private TextView lblCell;

        public FriendViewHolder(View itemView) {
            super(itemView);
            imgProfile = (ImageView) itemView.findViewById(R.id.imgProfile);
            lblName = (TextView) itemView.findViewById(R.id.lblName);
            lblEmail = (TextView) itemView.findViewById(R.id.lblEmail);
            lblCell = (TextView) itemView.findViewById(R.id.lblCell);
        }

        public void bindFriend(Friend friend) {
            loadPicture(friend.getPicture());
            lblName.setText(friend.getFirstName() + " " + friend.getLastName());
            lblEmail.setText(friend.getEmail());
            lblCell.setText(friend.getCell());
        }

        private void loadPicture(String pictureUrl) {
            Glide.with(context)
                 .load(pictureUrl)
                 .centerCrop()
                 .error(android.R.drawable.sym_def_app_icon)
                 .crossFade()
                 .into(imgProfile);
        }

    }

}