package com.example.movieapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;


public class CustomBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        Bundle bundle = intent.getExtras();

        Object messages[] = (Object[]) bundle.get("pdus");
        SmsMessage smsMessage[] = new SmsMessage[messages.length];

        for (int n = 0; n < messages.length; n++)
        {
            smsMessage[n] = SmsMessage.createFromPdu((byte[]) messages[n]);
        }
        String receivedMessage = smsMessage[0].getMessageBody().toString().toUpperCase();
        String originatingAddress = smsMessage[0].getOriginatingAddress();
        originatingAddress = (originatingAddress!=null && originatingAddress.length()>3)?(originatingAddress.substring(3)):("") ;

        Toast.makeText(context,"Sms received from "+originatingAddress+" maybe watch film with them?",Toast.LENGTH_LONG).show();
    }
}