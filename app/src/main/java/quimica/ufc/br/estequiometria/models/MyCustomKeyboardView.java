package quimica.ufc.br.estequiometria.models;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import android.util.Log;

import java.util.List;

import quimica.ufc.br.estequiometria.R;

/**
 * Created by aluno on 22/02/2017.
 */

public class MyCustomKeyboardView extends KeyboardView{
    public MyCustomKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        List<Keyboard.Key> keys = getKeyboard().getKeys();
        for (Keyboard.Key key : keys) {
            if (key.label!= null && key.label.length() > 5) {

                Drawable dr = (Drawable) getResources().getDrawable(R.drawable.edittext);
                dr.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
                dr.draw(canvas);

            }
        }
    }



}

