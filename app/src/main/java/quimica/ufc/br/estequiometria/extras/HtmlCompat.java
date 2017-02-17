package quimica.ufc.br.estequiometria.extras;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;

/**
 * Created by alysson on 11/11/16.
 */

public class HtmlCompat {

    @SuppressLint("NewApi")
    public static Spanned fromHtml(String text){

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(text,Html.FROM_HTML_MODE_COMPACT);
        }else{
            return Html.fromHtml(text);
        }

    }

}
