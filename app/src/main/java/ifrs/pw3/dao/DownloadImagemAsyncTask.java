package ifrs.pw3.dao;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import ifrs.pw3.R;

public class DownloadImagemAsyncTask extends AsyncTask<String, Void, Bitmap> {
    private ProgressDialog dialog;
    private Activity atividade;


    public DownloadImagemAsyncTask(Activity atividade) {
        this.atividade = atividade;
    }

    @Override
    protected Bitmap doInBackground(String... urls) {
        Bitmap image = null;
        String url = urls[0];
        try {
            InputStream inputStream = new URL(url).openStream();
            image = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        Activity view;
//        ImageView imageView = (ImageView) view.findViewById(R.id.post_image);
//        imageView.setImageBitmap(bitmap);
        this.cancel(true);
    }
}