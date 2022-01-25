# Week 1 Android Studio

First of all, welcome and thank you for choosing 300CEM - you did the right thing! No offense to anyone, but I believe Android (or mobile technology in general) is the way to the future! If you think about it - what the mobile phones were like 5 years ago and what they are like right now - you'll see how rapidly technologies have evolved. And this has affected our everyday life in every possible way!

## Lab 1 Introduction to Android Studio

This is the 1st of a series of 11-week exercises for Module 300CEM. In this 1st lab, you'll find out the things you need to have to become an Android developer. You'll also design and run your 1st Android app.

### What is Android?

First of all, let's ask a question - what is Android? Well, the answer depends on who you ask. There're several different levels to define Android: on the very deep level, it's a Linux operating system that controls a bunch of hardware and sensors. This is the same as any other operating systems such as Mac/Windows; on the very superficial level, Android are devices such as Samsung Galaxy or HTC; For us, Android developers, Android is an application runtime that we can develop codes which will turn into Dalvik virtual machines a.k.a. mobile apps.

![Android Framework](http://source.android.com/devices/tech/security/images/android_software_stack.png)

Android has been around for a while, hence we have different versions. For each version of Android, we have a 'sweet' codename with the latest being 'Nougat' (Android 7.0)

![Android Codename](http://www.geektech.in/wp-content/uploads/2016/07/Android-Nougat-Release-Date.png)

Different versions of Android offer slightly different features, and also they have different market shares. At the time of writing (1 October 2016), Lollipop (5.0/5.1) and KitKat (4.4) are dominating. As you can imagine as new devices are coming to the market and old ones are gradually phasing out, this market share evolves over time. As a developer, you have to consider your targeting devices/platforms. We'll come to that later on.

![Android distribution](https://chart.googleapis.com/chart?chl=Froyo%7CGingerbread%7CIce%20Cream%20Sandwich%7CJelly%20Bean%7CKitKat%7CLollipop%7CMarshmallow&chd=t%3A0.1%2C1.5%2C1.4%2C15.6%2C27.7%2C35.0%2C18.7&chf=bg%2Cs%2C00000000&chco=c4df9b%2C6fad0c&cht=p&chs=500x250)

> Click [here](https://source.android.com/source/build-numbers.html) for a list of Android version numbers and corresponding code names, [here](https://developer.android.com/about/dashboards/index.html) for an up-to-date distribution list. 

In this module, we concentrate on the developing *native* apps using Java, Android SDK, and Android Studio exclusively. Native apps offer many advantages such as platform integration and speed. But you should be aware that there're quite a number of other tools that you can use to develop apps for Android devices. These include [PhoneGap](http://phonegap.com/) and [Xamarin](https://xamarin.com/) for example.

### Installation

You'll need the following to be an Android developer:

> If you're looking at this in ECM15, you can quickly glance through this section now as everything you need has been done for you. We have also requested that the same thing is installed on every single machine in the EC building. But if you're looking at this on your own laptop, you need to read on carefully.

> I use Mac (most probably) to illustrate as you'll be using Macs in ECM15. But if you use Windows it shouldn't be too difficult to figure out the differences. If you get stuck, just ask!

1. Java JDK
2. Android Studio
3. Android SDK
4. A version of the Android system image
5. (optional but highly desirable) An Android device

A few words about Java: when you go to the [Java download page](http://www.oracle.com/technetwork/java/javase/downloads/index.html) click on the JDK, which will lead you to a different page to choose your platform. There you'll see two options, select the one without demos and samples as the size is smaller. Wondering the difference between JDK and JRE? Read [this](http://stackoverflow.com/questions/1906445/what-is-the-difference-between-jdk-and-jre).

Next, you'll need to [download](https://developer.android.com/studio/index.html) and install Android Studio. Once you click the download button from the previous link, you'll be automatically redirected to the [Install Android Studio](https://developer.android.com/studio/install.html) help page. You can get some help from there if something goes wrong. Otherwise just choose all default settings. Note once it's installed, next time you open it it will probably ask for permissions to update. My advice is that **don't update unless it's really necessary, at least for the duration of the module**. The reason is that configuring a working IDE for Android might take a considerable amount of time!

Once installed, click on the 'Configure' menu under 'Quick Start' tab, and then click 'SDK Manager', which will bring up the 'Android SDK' preference settings. Now check version 7.0 (Nougat) and click apply to download the SDK. Once again, next time you open it it will probably ask for permissions to update - DON'T!

> This way of installing SDK is easy when you first get started. But the drawback is it takes a lot of disk space. When you get your head around different SDK components, you might want to customize the installation using SDK Manager.

![SDK manager](images/sdk_manager.png)

If you click the 'Launch Standalone SDK Manager', you'll see the standalone SDK manager window (you guessed it!). Make sure that Intel Accelerator is installed. When you click the check box to install, what actually being installed is just the installation package. You'll need to find out where the installation package is and double click it. Read [this](https://software.intel.com/en-us/android/articles/installation-instructions-for-intel-hardware-accelerated-execution-manager-windows) to get more help.

![Intel accelerator](images/intel_acc.png)

When you finally write your own app you want to test and see how it works, that's why we need an Android system image and the optional Android device. From my own experience, real devices run much faster than AVDs (Android virtual devices). Well, I guess it's not just myself, other people are complaining too, see [here](http://stackoverflow.com/questions/1554099/why-is-the-android-emulator-so-slow-how-can-we-speed-up-the-android-emulator). So I would encourage you to use your own device. If you don't have one, don't worry, an ADV has been installed together with Android Studio. We'll come back to that later on.

> I had previously been shown with someone's Mac where Android Studio cannot figure out the installation path of Java. If that happens to you, did you install all these stuff in the right order? If you didn't, a 'brute force' fix would be to remove everything and install in the correct order. But if you want to configure properly, Java is normally installed under /Library/Java/JavaVirtualMachines/.

### Hello Android!

Follow the steps below to create and run your first Android app:

1. In Android Studio, click 'Start a new Android Studio project', and give it a name such as 'Hello Android'.
2. In 'Project location' settings select your desired location.
3. Next screen asks you to choose minimum SDK. The default value should do. If you want to know more about this minimum SDK, click on 'Help me choose' and read the info that comes up. Does it look familiar?

 ![Android_Platform_API_Version_Distribution](images/Android_Platform_API_Version_Distribution.png)

4. Use all default settings until you see Finish. Click Finish to create your first Android project. Your screen should look similar to below:

 ![activity_main_xml_-_Hello_Android](images/activity_main_xml_-_Hello_Android.png)
 
5. You're ready to run the app you just created. Before you do that, let's check if you have an emulator or Android device attached. Click Tools ==> Android ==> AVD Manager to show the AVD Manager. Make sure you have the default AVD installed. Click the littler green triangle next to the AVD to run it.

 If you do not have an AVD installed already, follow these instructions to create one: click 'Create Virtual Device' button to create a new one. The following settings for an AVD seem to work well on my machine: Phone, Nexus 5, targeting at latest Android 7.0 with Google APIs. Click 'Finish' and you'll have a new AVD.
 
5. Click Run ==> Run 'app' to run the app you just created. In the window that pops up, click 'Launch emulator' and choose the desired AVD if you have more than one. BTW, you should only have 1 AVD running, otherwise, the system will be rather slow. You will see HelloAndroid running in AVD similar to the one below.

 ![hello_android](images/hello_android.png)

6. If you are lucky enough to have an Android device attached to the computer you can use it for testing. But first of all, you'll need to make your device debuggable. Use your device with Macs is a two-step process:

 1. You need to enable Developer options. On Android 4.2 and higher, the Developer options screen is hidden by default. To make it visible, go to Settings ==> About phone and tap Build number seven times. 
 2. Enable USB debugging on your device. On most devices running Android 3.2 or older, you can find the option under Settings ==> Applications ==> Development. On Android 4.0 and newer, it's in Settings ==> Developer options.
 
 If you want to use your device with a Windows machine, you'll have to install USB driver for your device. The driver can normally be downloaded from your phone maker's website. Check [here](http://developer.android.com/tools/device.html) if you get stuck.
 
 Now return to our Hello Android app. When I run it on my Nexus it looks like the image below. Can you see any differences?
 
 ![hello_android](images/hello_nexus.png)

### Android Studio guided tour

Now it's time to go back to Android Studio and have a closer look at what we have done.

Android Studio is based on a Java IDE called IntelliJ IDEA. In fact, Google doesn't document Android Studio very well and sometimes you'll need to go to IntelliJ website to look for answers. The whole IDE window you saw earlier can be roughly divided into 5 areas:

![Android Studio UI](https://www.jetbrains.com/help/img/idea/large_mainWindow.png)
> The image above is from [Jetbrains website](https://www.jetbrains.com/help/idea/2016.2/guided-tour-around-the-user-interface.html).

1. Menus and toolbars. This is pretty standard, but it gives you quick access to some common commands. For example, you can click the little green triangle to run your project. 
2. Navigation bar that tells you which file you're viewing and their relative position in the project.
3. The status bar shows various warning and information messages. Sometimes you see a message like 'gradle is running...' and this can take some time to disappear.
4. The editor. This is the main area you'll be working on.
5. Tool windows  - secondary windows that provide access to various specific tasks.

In the editor window, there're some important keyboard shortcuts that you need to be aware of. Double click 'activity_main.xml' to open it if it's not opened already. Click on the lower 'Text' tab to make sure you're viewing the text view. First randomly enter some blank lines (press 'enter key' several times), then press 'cmd' + 'a' to select everything, then press 'alt' + 'cmd' + 'l' to reformat it. Does it look nicer now?

> For a full list of useful shortcuts, check [here](https://developer.android.com/studio/intro/keyboard-shortcuts.html)

Now take a look at the location you selected earlier to save the project. What you will see is that a bunch of files has been generated. Don't worry you don't need to know them all!

![Android Studio UI](images/hello_files.png)

The most important ones, however, are being contained in app/src/main. Actually when I download samples from Android website, sometimes I just go into this folder and ignore the rest.

![Android Studio UI](images/hello_files2.png)

1. activity_main.xml. This is the XML layout file for the activity you added when you created the project with Android Studio. In simple words, in Android activity represent a single screen where your users can perform certain tasks. Thus this xml defines your first (and only) screen in your app. The file at the moment includes a TextView only that displays the message "Hello world!".
2. MainActivity.java. This is the Java class that associates the xml layout file with different functions such as respond to a button click. When you build and run the app, the Activity class starts the activity and loads the layout file that says "Hello World!".
3. AndroidManifest.xml. The manifest file describes the fundamental characteristics of the app and defines each of its components. For example, it defines if your app needs to access the GPS sensor.

> On the official [Android developer website](https://developer.android.com/tools/projects/index.html), you'll see full descriptions of different files.

We were talking about Android Studio, but why all of a sudden we turned to our hard drive? Here is why - when you look at the 'Project' tool window to the left, you'll see some files being displayed. And those are the files we've just talked about! In this 'Project' mode, you'll see important files but not in their ordinary tree structure. There're several different modes in this tool window apart from the 'Android' mode. For example, if you choose 'Project' mode the window will display file trees that assemble what's available on your hard drive.

![Project window](https://developer.android.com/images/tools/projectview01.png)

### Android vs iOS

When talking about Android, you need to know what else there are in the market. It's very likely that in the future you'll be asked to develop an Android app as well as an iOS app. But biggest advantage Android offers is that it's free. That's probably why the market share is dominantly higher than its competitors.

![Android market share](http://www.idc.com/prodserv/smartphone-ms-img/chart-ww-smartphone-os-market-share.png)

Technically speaking, the two big players in the mobile OS market i.e. Android and iOS share a lot of things in common and at the same time have lots of differences. As a developer, you need to bear this in mind. One simple example is that Android has a physical or virtual back button, so there's no need to show a 'back' click on the screen. But for iOS, we definitely need one.

![Android iOS](https://cms-assets.tutsplus.com/uploads/users/810/posts/23616/image/global-elements.png)

## Lab 2 Debugging

In this 2nd lab, you'll go one step further from the previous lab by adding some UI elements to your activity. Also, you'll learn the basics of logging and debugging. In addition, I'll show you how to use Android Studio's built-in version control system.

### Hello Me!

Follow steps below to create another app:

1. In Android Studio, click 'Start a new Android Studio project', and give it a name such as 'Hello Me'.
2. In 'Project location' settings select your desired location. 
3. Use all default settings until you see Finish. These steps are the same as before and should become the *de facto* standard.
4. Double click to open 'activity_main.xml' if it’s not opened already.

 ![Content main](images/activity_main.png)

5. Under default settings, the 'Text' view will show. Click 'Preview' tool window to the right edge of the IDE to bring up the Preview window. Your whole workbench should look like below.

 ![Content main](images/text_view.png)

6. Delete texts contained between '<span>&lt;</span>TextView' and the closing '/>'. You'll see that the words 'Hello World' disappeared on the preview window.

7. Click the 'Design' tab to switch to the design view. Locate and drag the following four widgets from Palette to the layout one by one: TextView, (another) TextView, Plain Text, and Button. Your Component Tree should look at the following

 ![Content main](images/component_tree.png)

8. At this point, if you click one of the widgets you just dragged onto the graphical layout, you can change its properties using the Properties window. Try to change some of the properties to see the effects, and we’ll change them back later.

 > The graphical layout in the design view is not to be confused with preview in the text view. The preview tool is more powerful for example sometimes it gives error message 'Rendering Problems.
 
9. Click the 'Text' tab to go back to the text view. Manually edit the xml file, make it look like the following

 ```xml
 <TextView
        android:id="@+id/textViewDisplay"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentStart="true"
        android:layout_alignParentLeft="true"
        android:layout_alignParentTop="true"
        android:text="Hellow World"
        android:textSize="24sp"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/textViewDisplay"
        android:layout_alignStart="@+id/textViewDisplay"
        android:layout_alignLeft="@+id/textViewDisplay"
        android:layout_marginLeft="19dp"
        android:layout_marginTop="56dp"
        android:text="Name:"
        android:textAppearance="@style/TextAppearance.AppCompat.Small"
        app:layout_constraintLeft_toLeftOf="@+id/textViewDisplay"
        app:layout_constraintStart_toStartOf="@+id/textViewDisplay"
        app:layout_constraintTop_toBottomOf="@+id/textViewDisplay" />

    <EditText
        android:id="@+id/editText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBaseline="@id/textView2"
        android:layout_alignBottom="@id/textView2"
        android:layout_marginLeft="36dp"
        android:layout_toRightOf="@id/textView2"
        android:ems="10"
        android:inputType="textPersonName"
        app:layout_constraintBaseline_toBaselineOf="@id/textView2"
        app:layout_constraintBottom_toBottomOf="@id/textView2"
        app:layout_constraintLeft_toRightOf="@id/textView2" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/editText"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="22dp"
        android:text="Display"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText" />
 ```
 > Don't worry if you don't fully understand all these, we'll go through them later on.

10. Open MainActivity.java, create a method called onButtonClick that looks like below:

 ```kotlin
  fun onButtonClick(view : View){
        val editName = this.findViewById<EditText>(R.id.editText)
        val textDisplay = this.findViewById<TextView>(R.id.textViewDisplay)
        val nameToDisplay = editName.getText().toString()
        textDisplay.setText("Hello $nameToDisplay")
    }
 ```
 Note when you first use a class that hasn't been imported, Android Studio will show the class name in red. You'll need to import the class. The keyboard shortcut to do the importing is 'alt' + 'enter'.

11. Go back to the layout xml file you modified before, change the Button tag to include the following attribute:

 ```xml
 android:onClick="onButtonClick"
 ```
 > In order to create a method that responds to user clicks, the method needs to have a signature of 'public void doSomething(View view)'.

12. Now if you run this app, once you input something, for example your name and click Display, your name will appear in the greeting message. 

![hello jianhua](images/hello_jianhua.png)

