////android:hardwareAccelerated="false"
//android:label="@string/app_name"

package com.twogev.dailyshedule;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class Main extends AppCompatActivity {

    ImageView image1,image2,image3;
    Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ShowMessages s = new ShowMessages();
        s.Configurate(getResources().getColor(R.color.colorPrimary));

        setContentView(R.layout.main_window);
        getSupportActionBar().hide();

        //Intent intent = new Intent(this, SignInActivity.class);
       // startActivity(intent);

       // this.finish();

        //image1 = (ImageView) findViewById(R.id.imageView);
        //image2 = (ImageView) findViewById(R.id.imageView_up);
        //image3 = (ImageView) findViewById(R.id.imageView_down);

        but = (Button) findViewById(R.id.button2);

        //ImageView imageView = (ImageView) findViewById(R.id.imageView);
        //GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageView);
        //imageViewTarget.
        //Glide.with(this).load(R.drawable.icon).into(imageViewTarget);
        //setContentView(gifView);

        //VectorDrawable v = new VectorDrawable(R.string.pos);

        final ImageView mIcDownloadAnimator = (ImageView) findViewById(R.id.imageView);
        //final Drawable drawable = mIcDownloadAnimator.getBackground();

        mIcDownloadAnimator.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //AnimatedVectorDrawable animatedVectorDrawable =
                        //        (AnimatedVectorDrawable) getDrawable(R.drawable.ic_button_news_press);
                        mIcDownloadAnimator.setImageResource(R.drawable.ic_mainnavigation_button_news_press);
                        Drawable drawable = mIcDownloadAnimator.getDrawable();
                        if (drawable instanceof Animatable) {
                            ((Animatable) drawable).start();
                        }
                        // Pressed down
                        return true;
                    case MotionEvent.ACTION_UP:
                        mIcDownloadAnimator.setImageResource(R.drawable.ic_mainnavigation_button_news_release);
                        Drawable drawable1 = mIcDownloadAnimator.getDrawable();
                        if (drawable1 instanceof Animatable) {
                            ((Animatable) drawable1).start();
                        }
                        // Released
                        return true;
                    case MotionEvent.ACTION_CANCEL:
                        mIcDownloadAnimator.setImageResource(R.drawable.ic_mainnavigation_button_news_release);
                        Drawable drawable2 = mIcDownloadAnimator.getDrawable();
                        if (drawable2 instanceof Animatable) {
                            ((Animatable) drawable2).start();
                        }
                        // Released - Dragged finger outside
                        return true;
                }
                return false;
            }
        });
    }


    /*private Button.OnClickListener oncl = new Button.OnClickListener()
    {
        void OnClick()
        {

        }
    }*/


}
