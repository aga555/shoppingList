package com.example.shoppinglist;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ApiActivity extends AppCompatActivity {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        ButterKnife.bind(this);
        progressBar.setVisibility(View.INVISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ThreadClass().execute("URL", "URL2", "URL3");

            }
        });


    }

    private class ThreadClass extends AsyncTask<String, Integer, Float> {
        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            textView.setText("" + System.currentTimeMillis());
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0]);
            super.onProgressUpdate(values);
        }


        @Override
        protected void onCancelled( Float f) {
            super.onCancelled(f);
        }

        @Override
        protected void onPostExecute(Float f) {
            progressBar.setVisibility(View.INVISIBLE);
            textView.setText(textView.getText() + "  " + "" + System.currentTimeMillis());
            super.onPostExecute(f);

        }

        @Override
        protected Float doInBackground(String... params) {
            String url = params[0];

            String a = url;
            for (int i = 0; i < 1000000; i++) {
                a = a + url;
                if (i>0 && i % 100 == 0)

                    publishProgress( i/1000);
            }
            return null;
        }

        public void execute(String url) {
        }
    }
}
