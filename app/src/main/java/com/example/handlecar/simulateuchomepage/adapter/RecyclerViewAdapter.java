package com.example.handlecar.simulateuchomepage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.handlecar.simulateuchomepage.R;

/**
 Created by handlecar on 2017/1/13.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter {
	Context context;
	private LayoutInflater inflater;

	public RecyclerViewAdapter(Context context) {
		this.context = context;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		inflater = LayoutInflater.from(context);
		View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
		return new MyViewHolder(view);
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

	}

	@Override
	public int getItemCount() {
		return 30;
	}

	class MyViewHolder extends RecyclerView.ViewHolder {
		ImageView iv_item;
		TextView tv_title;

		public MyViewHolder(View itemView) {
			super(itemView);
			iv_item = (ImageView) itemView.findViewById(R.id.iv_item);
			tv_title = (TextView) itemView.findViewById(R.id.tv_title);
		}
	}
}
