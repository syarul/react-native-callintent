package com.syarul.callintent;

import android.content.Intent;
import android.net.Uri;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.common.MapBuilder;

/**
 * {@link NativeModule} that allows JS to open the default browser
 *  for an url.
 */
public class RNCallIntentModule extends ReactContextBaseJavaModule {

  ReactApplicationContext reactContext;

  public RNCallIntentModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "CallIntent";
  }

  @ReactMethod
  public void open(String phoneNumber) {
    String uri = "tel:" + phoneNumber;    
    Intent intent = new Intent(Intent.ACTION_CALL);
    intent.setData(Uri.parse(uri));
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    this.reactContext.startActivity(intent);
  }
}
