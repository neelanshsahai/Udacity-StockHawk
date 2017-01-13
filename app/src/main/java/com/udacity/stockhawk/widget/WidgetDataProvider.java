package com.udacity.stockhawk.widget;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.udacity.stockhawk.R;
import com.udacity.stockhawk.data.Contract;

import java.util.ArrayList;
import java.util.HashMap;


public class WidgetDataProvider implements RemoteViewsService.RemoteViewsFactory {
    private ArrayList<HashMap<String, String>> mCollections = new ArrayList<>();
    private final String LOG_TAG = "WDP";
    Context mContext = null;

    public WidgetDataProvider(Context context, Intent intent){
        mContext = context;
    }

    @Override
    public int getCount(){
        return mCollections.size();
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public void onCreate() {
        initData();
    }

    @Override
    public void onDataSetChanged() {
        initData();
    }

    @Override
    public void onDestroy() {
    }

    private void initData() {
        mCollections.clear();
//        Log.v(LOG_TAG, "init data");
//        ContentResolver cr = mContext.getContentResolver();
//        Log.v(LOG_TAG, "cr done");
//        Cursor cursor = cr.query(Contract.Quote.makeBaseUri(), null, null, null, null);
//        Log.v(LOG_TAG, "cursor done");
//        if (cursor != null){
//            Log.v(LOG_TAG, "in cursor not null");
//            while (cursor.moveToNext()){
//                HashMap<String, String> map = new HashMap<>();
//                map.put("symbol", cursor.getString(Contract.Quote.POSITION_SYMBOL));
//                map.put("price", cursor.getString(Contract.Quote.POSITION_PRICE));
//                map.put("change_percent", cursor.getString(Contract.Quote.POSITION_PERCENTAGE_CHANGE));
//                Log.v(LOG_TAG, map.toString());
//                mCollections.add(map);
//            }
//            Log.v(LOG_TAG, "size " + mCollections.size());
//            cursor.close();
//        }
        for (int i = 1; i <= 10; i++) {
            mCollections.add(new HashMap<String, String>());
        }
        Log.v(LOG_TAG, "size " + mCollections.size());
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews mView = new RemoteViews(mContext.getPackageName(), R.layout.list_item_quote);
        Log.v(LOG_TAG, "get view" + mCollections.size());
        mView.setTextViewText(R.id.symbol, "symbol");
        mView.setTextViewText(R.id.price, "23");
        mView.setTextViewText(R.id.change, "22%");
//        HashMap<String, String> temp = mCollections.get(position);
//        mView.setTextViewText(R.id.symbol, temp.get("symbol"));
//        mView.setTextViewText(R.id.price, temp.get("price"));
//        mView.setTextViewText(R.id.change, temp.get("change_percent"));
//        mView.setTextViewText(android.R.id.text1, (CharSequence) mCollections.get(position));
//        mView.setTextColor(android.R.id.text1, Color.BLACK);
        return mView;
    }
}