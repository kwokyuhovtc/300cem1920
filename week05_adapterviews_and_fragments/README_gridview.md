### Grid View

<!--https://developer.android.com/guide/topics/ui/layout/gridview.html-->
Previous two examples used default ArrayAdapter and customized (extended) ArrayAdapter. In fact, ArrayAdapter is a subclass of BaseAdapter. Let's now go one step further and see how to customize (extend) BaseAdapter. In the following example, you'll learn how to create a GridView and provide a customized BaseAdaptor for it.

1. Create a new Activity using the 'Empty Activity' template and name it GridAcitivty. Open activity_grid.xml and change the container layout from RelativeLayout to GridView. Insert the following attributes into the opening tag of GridView:
    
    ```xml
    android:columnWidth="90dp"
    android:gravity="center"
    android:horizontalSpacing="10dp"
    android:numColumns="auto_fit"
    android:stretchMode="columnWidth"
    android:verticalSpacing="10dp"
    ```
    
    There are new attributes, but they are quite self-explanatory.
    
2. Open GridActivity.java, insert the following code into `onCreate()` just before the ending curly brackets '}'.
    
    ```java
    GridView gridview = (GridView) findViewById(R.id.activity_grid);
    gridview.setAdapter(new ImageAdapter(this));

    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            Toast.makeText(getBaseContext(), "At position " + position + " is " + getResources().getStringArray(R.array.candidateNames)[position], Toast.LENGTH_SHORT).show();
        }
    });
    ```
    The only thing new here is the ImageAdapter, which we'll look at next.
    
3. Create a new class called ImageAdapter. Replace the auto-generated class with the following
    
    ```java
    public class ImageAdapter extends BaseAdapter {

        private int[] candidatePhotos = PhotoListActivity.candidatePhotos;
        private Context context;

        public ImageAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return candidatePhotos.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(candidatePhotos[position]);
            return imageView;
        }

    }
    ```
    
    BaseAdapter is the superclass of different Adapters, but it's an abstract class. That means you have to provide concrete implementations for all abstract methods. That's why you see `getItem()` and `getItemId()` above. Although we don't use those two methods in our example we have to implement them. `getCount()` return the size of the data. The most important one is still `getView()`. Here instead of using layout resource file, we programmatically add layout widgets into the parent and set it's properties. `GridView.LayoutParams()` creates an GridView.LayoutParams object that resides inside the parent view, which is a GridView in our case.
    
5. Insert the following into activity_main.xml, just before the ListView
    
    ```xml
    <Button
        android:id="@+id/gridView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@id/complexList"
        android:onClick="onButtonClick"
        android:text="Grid View" />
    ```
    
    Change the ListView attribute `android:layout_below` value from `"@id/complexList"` to `"@id/gridView"`.
    
10. Open MainActivity.java, insert the following into the class
    
    ```java
    public void onButtonClick(View v){
        startActivity(new Intent(this, PhotoListActivity.class));
    }
    ```
6. Open MainActivity.java, replace contents of `onButtonClick()` with the following
    
    ```java
    switch (v.getId()) {
        case R.id.complexList:
            startActivity(new Intent(this, PhotoListActivity.class));
            break;
        case R.id.gridView:
            startActivity(new Intent(this, GridActivity.class));
            break;
    }
    ```
    
If you run the app and click on 'GridView', you'll see something similar to below

![grid](.md_images/grid.png)