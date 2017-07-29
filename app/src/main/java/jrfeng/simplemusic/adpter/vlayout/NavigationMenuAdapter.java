package jrfeng.simplemusic.adpter.vlayout;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;

import jrfeng.simplemusic.R;
import jrfeng.simplemusic.activity.navigation.NavigationContract;

public class NavigationMenuAdapter extends DelegateAdapter.Adapter<NavigationMenuAdapter.ViewHolder> {
    private Context mContext;
    private NavigationContract.Presenter mPresenter;

    private int[] imageIds = {R.mipmap.ic_all_music, R.mipmap.ic_love, R.mipmap.ic_music_list, R.mipmap.ic_album, R.mipmap.ic_artist, R.mipmap.ic_scan};
    private String[] titles = {"所有音乐", "我喜欢", "歌单", "专辑", "歌手", "扫描"};
    private String[] descriptions = {"0首音乐", "0首音乐", "0张歌单", "0张专辑", "0位歌手", "扫描本地音乐"};

    public NavigationMenuAdapter(Context context, NavigationContract.Presenter presenter) {
        mContext = context;
        mPresenter = presenter;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        GridLayoutHelper layoutHelper = new GridLayoutHelper(2, 6, 1, 1);
        layoutHelper.setBgColor(mContext.getResources().getColor(R.color.colorGrey300));
        return layoutHelper;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.widget_menu_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.ivIcon.setImageResource(imageIds[position]);
        holder.tvTitle.setText(titles[position]);
        holder.tvDescription.setText(descriptions[position]);

        //TODO 添加点击事件监听器
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIcon;
        TextView tvTitle;
        TextView tvDescription;

        public ViewHolder(View itemView) {
            super(itemView);

            ivIcon = itemView.findViewById(R.id.ivMenuIcon);
            tvTitle = itemView.findViewById(R.id.tvMenuTitle);
            tvDescription = itemView.findViewById(R.id.tvMenuDescription);
        }
    }
}