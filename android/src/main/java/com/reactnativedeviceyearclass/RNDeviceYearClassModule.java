package com.reactnativedeviceyearclass;

/**
 * Created by yaska on 17-11-15.
 */

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNDeviceYearClassModule extends ReactContextBaseJavaModule {
    private static final String TAG = "DeviceYearClass";
    private static final String GET_ERROR = "GET_ERROR";
    private ReactApplicationContext reactContext;

    public RNDeviceYearClassModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void get(Promise promise) {
      try {
        int year = YearClass.get(this.reactContext); // or getReactApplicationContext()
        promise.resolve(year);
      } catch (Exception e) {
        promise.reject(GET_ERROR, e);
      }
    }
}
