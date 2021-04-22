# Location Services and Google Maps

Most, if not all, Android devices have built-in sensors such as motion sensors to detect screen orientation and position sensors to detect your current position. Among many sensors that are available, the most widely used one is the location sensor.

## Lab 1 Location Services

There are different ways of determining an Android device's location. Two widely used APIs are the built-in Android location (android.location) and the Google Play services. The Google Play services location APIs, which are part of Google Play Services, are preferred over the Android framework location APIs (android.location) as it offers simpler interfaces and better battery usage.

In the following exercise, we’ll use the Google Play services location APIs to create an app that is capable of determining a device's location. In addition, the app can interpret the device's location in terms of latitude/longitude and turn it into a meaningful address.

### The app

Follow steps below to download the sample app from module's GitHub page and run it on your own machine.

> The demo project is a remix and simplified version of several official Android samples on [Making Your App Location-Aware
](https://developer.android.com/training/location/index.html)

1. Make sure Google play service is available on your system. In Android Studio, click Tools ==> Android ==> SDK Manager, this will bring up the Preference tool window Android SDK settings page. Make sure that Google Play services are installed.
    
    ![](.md_images/sdk.png)
    
2. Install the app. Download sample project called MyLocation from module's GitHub page, and open it in Android Studio. Click Build ==> Rebuild Project. In case that the system complains about Google Play services version required is different from what is installed, you'll need to delete existing dependency and replace it with the one you have.
    
    ![](.md_images/dependency.png)
    
    <!-- > Depending on the version of your Android Studio SDK and version of your AVD/device, you might receive an error message saying something like 'W/GooglePlayServicesUtil: Google Play services out of date. Requires 10084000 but found 9877470'. This basically means that you declare a dependency of com.google.android.gms:play-services in build.gradle that is newer than the version installed in AVD/device. If you are running on a real device, you need to update your version of Google Play Services. [If you running on an emulator, you will need to downgrade build.gradle to version 9.8.0 or 9.6.1 of the Play Services. There is no released emulator image that supports version 10.0.0](http://stackoverflow.com/questions/40740372/cannot-create-a-user-with-latest-firebase-version-i-get-a-w-dynamitemodule-and). -->
3. Get the permission. Run the app on an AVD (preferably not a real device, as you'll need to mock locations later), the first screen you'll see is something like below. These are really placeholders.
    
    ![](.md_images/app_1st.png)
    
    Now if you click On/Off button, it'll ask your permission to access device location. Click Allow.
    
    ![](.md_images/app_allow.png)
    
4. Simulate location changes in AVD. In the Extended controls window for AVD, in the Location tab, insert the following location for latitude and longitude respectively, 52.191064 and -1.707510, and click Send.
    
    ![](.md_images/app_mock.png)
    
5. Determine current location and display Address. If you click the Locate button in the app you'll see that the above latitude/longitude corresponds to an address in Stratford (Shakespeare birthplace). If you then decide to mock a new location and send to the AVD, the app should pick this new location automatically for you.
    
    ![](.md_images/app_locate.png)

### Source code

In following sections, some important concepts used in the demo app are explained. More importantly, the sample project is well documented. You should study the source code carefully and read comments. You should also try and change some source code to explore and see what different functions the altered software offers.

__Get the permission__

The app needs to access the device's location. There're two parts to get this done:

1. First of all, declare 'uses-permission' in manifest file, contained within the `manifest` tag
    
    ```xml
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
    ```
    
2. In MainActivity.java, check if permission is granted or not. If not, request that permission. You'll only need to do this once.
    
    ```java
   if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
           PackageManager.PERMISSION_GRANTED) {
       ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
               REQUEST_LOCATION);
   }
    ```
    
    How Android system handles permission has changed. The old way was to require all permissions upon installation. And the new way is to require individual permission on first use.

__Get last known location__

The app builds the GoogleApiClient to begin with. Once it is built, the client connects to Google Play services in the background. If it connects successfully, getting the last known location is just a single line of code

```java
mLastLocation = LocationServices.getFusedLocationProviderClient(this).getLastLocation().getResult();
```

Note here even though at the very beginning of this document we mentioned that the Google Play services location APIs are preferred over the Android framework location APIs, `getLastLocation()` function will, in fact, return an `android.location.Location` object.

__Receive location updates__

To receive location updates, i.e. get notified each time the device has a new location, use the following code

```java
LocationServices.getFusedLocationProviderClient(this).requestLocationUpdates(req, callback, Looper.myLooper());
```

In the above code, `this` pass the current object as the listener by implementing the `onLocationChanged()` method.

```java
LocationCallback callback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                super.onLocationResult(locationResult);
                Location location = locationResult.getLastLocation();
            }
        };
```

__Turn geographic location into addresses__

To convert geographic location into an address, or the opposite, you'll need the Geocoder class from android.location.

```java
List<Address> addresses = mGeocoder.getFromLocation(mLastLocation.getLatitude(), mLastLocation.getLongitude(), 1);
```

In fact, the three classes we need from android.location are Address, Geocoder, and Location.

__Support library__

If you open build.gradle (Module: app) file, you'll see that you have one support library added

```xml
apply plugin: 'com.android.application'
    ...

    dependencies {
        compile 'com.google.android.gms:play-services-location:18.0.0'
    }
```

Note that the simplest way of including Google Play Services in Android is to include everything in it

```xml
apply plugin: 'com.android.application'
    ...

    dependencies {
        compile 'com.google.android.gms:play-services:11.0.4'
    }
```

However, this is not a good practice as it'll include everything in your project and make it unnecessarily large. Take a look at the [Official guide on Setting Up Google Play Services](https://developers.google.com/android/guides/setup)

## Lab 2 Google Maps

The first app allows you to manipulate devices' location without touching the actual Map. However, it'll be much nicer to see how the app interacts with the user on a real map. 

### Get started

Before moving to the next step, follow instructions here [Getting Started on Google Maps Android API](https://developers.google.com/maps/documentation/android-api/start) to create your first 'Get started' app. 

![](.md_images/gm_gs.png)

Note in the above tutorial 'Step 4. Get a Google Maps API key', when you go to Google developer console to create a new project, the default project name is also 'My Project'. If that name annoys you too, it can be changed through Google Cloud Platform page, on the right-hand-side under Project settings.

![](.md_images/project_name.png)

Take a note of the API key you created, you'll need it for later.

![](.md_images/api.png)

Also, note the default restrictions. If your app needs to use the API, it's fingerprint has to appear in the table.

![](.md_images/restriction.png)

### The app

Uninstall any MyLocation apps on your AVD/devices if exists. Download our demo project MyMap and replace the contents of google_maps_api.xml with the key you generated in 'Get started' project. Run this project and you'll see that on the first load, the app looks like below

![](.md_images/app2_1st.png)

In AVD Extended controls window, set the initial location to be 38.6347 and -90.2941 for latitude and longitude respectively, click Send. Next, download [a sample GPX file from Geovative](http://www.geovative.com/GeoToursWebApp/DownloadFile.aspx?vq=JD2QD3JVBAUEBGEIFBQ8L7PURB92NJ&q190y1nqgB2r=Tck&y1tQ190y1nqgB2r=Tck&y1th5r4Vq=) and load it into AVD Extended controls window.

![](.md_images/ec.png)

In the app, click On/Off button, this will start/stop the GoogleApiClient. This will also enable the other buttons. Click on Map Frag, which stands for map fragment. Then click on the green triangle in AVD Extended controls window to start GPS playback. You'll see that as mock location changes, the app draws polylines joining some (not all!) of its determined locations.

![](.md_images/app2_lines.png)

### Source code 

__Add a map__

The app shows you two ways to add a map to an app: one uses a fragment, the other uses a MapView. Special attentions need to be paid when using MapView as one needs to [forward some activity lifecycle methods e.g. `onResume()`](https://developers.google.com/android/reference/com/google/android/gms/maps/MapView).

```java
//map using fragment
SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(mapFrag);
        mapFragment.getMapAsync(this);
```

```java
//map using mapview
mapView = (MapView) findViewById(R.id.mapFrag);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
```

__Sync location data__

To synchronize location data from MainActivity to MapFragActivity, the app uses [the observer pattern](https://en.wikipedia.org/wiki/Observer_pattern). This is very similar to other OnXXListeners in the SDK.

> [Read Stack Overflow discussions on How to make listener to a custom variable](http://stackoverflow.com/questions/9879780/android-how-to-make-listener-to-a-custom-variable)

The MainActivity declares an interface, a member variable that belongs to that interface, and some actions this variable will take

```java
public interface OnCurrentLocationChangeListener {
    void onCurrentLocationChange(Location location);
}

static private OnCurrentLocationChangeListener mOnCurrentLocationChangeListener;

@Override
public void onLocationChanged(Location location) {
    mOnCurrentLocationChangeListener.onCurrentLocationChange(location);
}
```

Then, MapFragActivity implements that interface, and trace back the class and sets its listener

```java
public class MapFragActivity extends FragmentActivity implements MainActivity.OnCurrentLocationChangeListener {

MainActivity.setOnCurrentLocationChangeListener(this);

@Override
    public void onCurrentLocationChange(Location location) {
    }

```
