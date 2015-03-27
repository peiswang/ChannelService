package com.wps.channelservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent arg1) {
		// TODO Auto-generated method stub
		Intent service = new Intent();
		service.setClass(context, ChannelService.class);
		context.startService(service);
	}

}
