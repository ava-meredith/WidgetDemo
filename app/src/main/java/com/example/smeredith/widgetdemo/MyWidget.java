package com.example.smeredith.widgetdemo;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * Created by smeredith on 5/31/2018.
 */

public class MyWidget extends AppWidgetProvider {

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){
        for(int i = 0; i < appWidgetIds.length; i++){
            int currentWidgetId = appWidgetIds[i];
            String url = "https://developer.android.com/guide/topics/appwidgets/";

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse(url));

            PendingIntent pending = PendingIntent.getActivity(context, 0, intent, 0);
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.my_widget);

            views.setOnClickPendingIntent(R.id.button, pending);
            appWidgetManager.updateAppWidget(currentWidgetId, views);
            Toast.makeText(context, "widget added", Toast.LENGTH_SHORT).show();
        }

    }

}
