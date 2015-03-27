package com.wps.channelservice;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;


public class ChannelService extends Service{
	
	private static final String TAG = "ChannelService";
	private Handler handler;
	private static Socket socket = null;

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.i(TAG, "service created");
		try {
			socket = new Socket("127.0.0.1", 6665);
			InputStream inputStream = socket.getInputStream();
			byte[] buffer = new byte[4096];
			while( inputStream.read(buffer) != -1 )
			{
				
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*handler = new Handler(Looper.getMainLooper());
		handler.post(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Service onCreate", Toast.LENGTH_LONG).show();
				//Intent it = new Intent(Intent.ACTION_VIEW);
				//it.setDataAndType(Uri.parse("/sdcard/hands.mp4"), "video/mp4");
				//getApplicationContext().startActivity(it);
			}
			
		});*/
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.i(TAG, "service destroyed");
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.onDestroy();
	}

}
