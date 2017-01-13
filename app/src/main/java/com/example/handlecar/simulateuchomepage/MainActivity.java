package com.example.handlecar.simulateuchomepage;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.example.handlecar.simulateuchomepage.adapter.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

	private RecyclerView rv_content;
	private LinearLayout title_view;
	private LinearLayout header_view;
	private NestedScrollView nsv_content;
	private Toolbar toolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		title_view = (LinearLayout) findViewById(R.id.title_view);
		header_view = (LinearLayout) findViewById(R.id.header_view);
		nsv_content = (NestedScrollView) findViewById(R.id.nsv_content);
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		rv_content = (RecyclerView) findViewById(R.id.rv_content);
		RecyclerViewAdapter adapter = new RecyclerViewAdapter(this);
		rv_content.setAdapter(adapter);
		rv_content.setLayoutManager(new LinearLayoutManager(this));

		toolbar.setTag("toolbar");
	}
}
