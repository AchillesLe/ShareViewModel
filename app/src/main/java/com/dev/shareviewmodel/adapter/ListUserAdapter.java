package com.dev.shareviewmodel.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.shareviewmodel.model.User;
import com.dev.shareviewmodel.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserAdapter.UserViewHoder> {
    private List<User> list;
    private userClickListener listener;
//    public  ListUserAdapter(List<User> list){
//        this.list = list;
//    }
    @NonNull
    @Override
    public UserViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user,viewGroup,false);
        return new UserViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHoder userViewHoder, int i) {
        User user = list.get(i);
        userViewHoder.txt_email.setText(user.getEmail());
        userViewHoder.txt_firstname.setText(user.getFirst_name());
        if( user.getAvatar()!= null && !user.getAvatar().equals("") ){
            String url =  user.getAvatar(); //APIEndPoint.BASE_URL
            Picasso.get().load( url ).error(R.drawable.ic_launcher_background).resize(80, 80).into( userViewHoder.img_avatar );
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void setUsers(List<User> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public  User getUserAt(int i){
        return  list.get(i);
    }
    class UserViewHoder extends RecyclerView.ViewHolder {
        private TextView txt_email;
        private TextView txt_firstname;
        private ImageView img_avatar;
        public UserViewHoder(View view){
            super(view);
            this.img_avatar = view.findViewById(R.id.avatar);
            this.txt_email = view.findViewById(R.id.txt_view_email);
            this.txt_firstname = view.findViewById(R.id.txt_view_first_name);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if( listener != null &&  position != RecyclerView.NO_POSITION ){
                        listener.UserClick( list.get(position) );
                    }
                }
            });
        }
    }

    public interface userClickListener{
         void UserClick(User user);
    }

    public void setOnUserClick( userClickListener listener){
        this.listener = listener;
    }
}
