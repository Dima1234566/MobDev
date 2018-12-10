package e.dimas.lab6;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder> {


        private List<Photo> mDataList;
        public void loadData(List<Photo> mDataList){
            this.mDataList = mDataList;
        }


        class CustomViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.coverImage)
            ImageView coverImage;
            @BindView(R.id.name)
            TextView name;
            CustomViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
        @NonNull
        @Override
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.photo, parent, false);
            return new CustomViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

            final Photo photo = mDataList.get(position);
            Picasso.get().load(photo.getThumbnailUrl()).into(holder.coverImage);
            holder.name.setText(photo.getTitle());

        }
        @Override
        public int getItemCount() {
            return mDataList == null ? 0 : mDataList.size();
        }
    }

