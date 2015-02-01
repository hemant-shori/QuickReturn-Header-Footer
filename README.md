# QuickReturn-Header-Footer
Animated header like Google search Mobile App [Google Search](https://play.google.com/store/apps/details?id=com.google.android.googlequicksearchbox&hl=en)

#This is Default preview without Animated Header

<img src="https://github.com/hemant-shori/QuickReturn-Header-Footer/blob/master/Raw-Art/default.gif" alt="Demo" style="max-width:100%;">

#Here is ther Demo with Animated Header

<img src="https://github.com/hemant-shori/QuickReturn-Header-Footer/blob/master/Raw-Art/header.gif" alt="Demo" style="max-width:100%;">

#Here is the Demo with Animated Footer

<img src="https://github.com/hemant-shori/QuickReturn-Header-Footer/blob/master/Raw-Art/bottom.gif" alt="Demo" style="max-width:100%;">

#Integration
1) Add as a dependency to your `build.gradle`:

      dependencies {
        compile 'com.android.support:recyclerview-v7:21.0.+'
      }
   

2) Frame Layout for sticky header



    <?xml version="1.0" encoding="utf-8"?>
    <FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
      android:layout_width="match_parent"
      android:layout_height="match_parent">
      
    <android.support.v7.widget.RecyclerView
        android:id="@+id/mQuickRecyclerView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
        
    <TextView
        android:id="@+id/sticky"
        android:layout_width="match_parent"
        android:layout_height="@dimen/header_height"
        android:background="#00F"
        android:gravity="center"
        android:layout_marginTop="@dimen/header_margin_top"
        android:textAppearance="@android:style/TextAppearance.Medium"
        android:textColor="#FFF" />
    </FrameLayout>

# Code For Recylerview [Guide lines](https://developer.android.com/training/material/lists-cards.html#Dependencies)
3) Java code initializing Recyclerview.

       RecyclerView mListView = (RecyclerView) view.findViewById(R.id.mQuickRecyclerView);
        mListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        
        // Clip to padding is necessary to allow list cover the whole screen while scrolling
        mListView.setClipToPadding(false);
        
        //Adding extra space to show the 1st item of list
        
        mQuickFieldHeight = getResources().getDimensionPixelSize(R.dimen.header_height)
          /*getting dimen
            of header*/ 
        + getResources().getDimensionPixelSize(R.dimen.header_margin_top)
          /*getting dimen
           of upper padding given to  header*/ 
        + getResources().getDimensionPixelSize(R.dimen.header_margin_top);
          /*getting dimen
           of lower padding given to header*/
        
        // Padding is necessary to show the upper items of the recycler view here header_height is defined in dimen
        
        mListView.setPadding(10,mQuickFieldHeight, 10, 0);
        mListView.setHasFixedSize(true);
        mListView.setAdapter(new RecyclerListAdapter(array));

#Final and the Most Important Thing.
4) Setting dimensions of header, footer and padding in dimens.xml


      <resources>
      <dimen name="header_height">60dp</dimen>
      <dimen name="header_margin_top">15dp</dimen>
      <dimen name="footer_height">60dp</dimen>
      </resources>
