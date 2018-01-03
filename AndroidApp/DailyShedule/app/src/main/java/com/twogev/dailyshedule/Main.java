////android:hardwareAccelerated="false"
//android:label="@string/app_name"

package com.twogev.dailyshedule;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;


public class Main extends AppCompatActivity {

    ImageView image1,image2,image3;
    Button but;
    boolean state1 = false;
    boolean canStart = true;
    boolean isStop = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ShowMessages s = new ShowMessages();
        s.Configurate(getResources().getColor(R.color.colorPrimary));

        //setContentView(R.layout.main_window);
        getSupportActionBar().hide();

        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);

        this.finish();

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


        final ImageView mIcDownloadAnimator1 = (ImageView) findViewById(R.id.imageView2);

        mIcDownloadAnimator1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //AnimatedVectorDrawable animatedVectorDrawable =
                        //        (AnimatedVectorDrawable) getDrawable(R.drawable.ic_button_news_press);
                        //mIcDownloadAnimator1.setImageResource(R.drawable.data4);
                        //Drawable drawable = mIcDownloadAnimator1.getDrawable();
                        //if (drawable instanceof Animatable) {
                       //     ((Animatable) drawable).start();
                       // }
                        // Pressed down
                        return true;
                    case MotionEvent.ACTION_UP:

                        return true;
                    case MotionEvent.ACTION_CANCEL:

                        return true;
                }
                return false;
            }
        });

        final LottieAnimationView animationView = (LottieAnimationView) findViewById(R.id.animation_view);
        //animationView.setAnimation("hello-world.json");
        //animationView.loop(true);

        final ConstraintLayout lay = (ConstraintLayout) findViewById(R.id.lay);
        final TextView text = (TextView) findViewById(R.id.test_text);

        animationView.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //animationView.setProgress((float)animation.getAnimatedValue());
                //text.setText(animation.getAnimatedValue().toString());
                if(((state1 == true) && ((float)animation.getAnimatedValue() >= 0.33F)) || (!state1))
                    ;//canStart = true;

                if(((float)animation.getAnimatedValue() >= 0.33F) && (state1 == true)) {
                    //if(isStop)
                    animationView.pauseAnimation();
                        //animationView.cancelAnimation();
                    //canStart = true;
                }

                /*if((float)animation.getAnimatedValue() >= 1F) {
                    animationView.setProgress(0f);
                    canStart = true;
                }*/
            }
        });

        animationView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        state1 = true;
                        //isStop = true;
                        //if(!canStart) return false;
                        //canStart = false;
                        //animationView.setProgress(0f);
                        animationView.playAnimation();

                        return true;
                    case MotionEvent.ACTION_UP:
                        //text.setText("up");
                        state1 = false;
                        //isStop = false;
                        //animationView.setProgress(0.33f);
                        animationView.playAnimation();
                        // Released
                        return true;
                    case MotionEvent.ACTION_CANCEL:
                        state1 = false;
                        //isStop = false;
                        //animationView.setProgress(0.33f);
                        animationView.playAnimation();
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
