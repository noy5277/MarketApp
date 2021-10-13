package com.example.market_app;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemViewHolder {
    public ImageView image;
    public TextView title;
    public TextView description;

    ItemViewHolder(View v)
    {
        image=v.findViewById(R.id.imageView);
        title=v.findViewById(R.id.title);
        description=v.findViewById(R.id.description);
    }

}
