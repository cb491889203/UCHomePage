package com.example.handlecar.simulateuchomepage;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.example.handlecar.simulateuchomepage.adapter.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

	private RecyclerView rv_content;
	private LinearLayout ll_title;
	private LinearLayout ll_header;
	private NestedScrollView nsv_content;
	private Toolbar toolbar;
	private LinearLayout ll_type;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		ll_title = (LinearLayout) findViewById(R.id.ll_title);
		ll_header = (LinearLayout) findViewById(R.id.ll_header);
		ll_type = (LinearLayout) findViewById(R.id.ll_type);
		nsv_content = (NestedScrollView) findViewById(R.id.nsv_content);
//		toolbar = (Toolbar) findViewById(R.id.toolbar);
		rv_content = (RecyclerView) findViewById(R.id.rv_content);
		RecyclerViewAdapter adapter = new RecyclerViewAdapter(this);
		rv_content.setAdapter(adapter);
		rv_content.setLayoutManager(new LinearLayoutManager(this));

//		toolbar.setTag("toolbar");
		setTag();
	}

	private void setTag() {
		ll_title.setTag("ll_title");
		ll_header.setTag("ll_header");
		ll_type.setTag("ll_type");
		nsv_content.setTag("nsv_content");
		rv_content.setTag("rv_content");

		ll_title.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ll_type.setTag(11);
			}
		});
	}
}
