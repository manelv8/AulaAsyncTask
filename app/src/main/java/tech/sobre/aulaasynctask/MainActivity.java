package tech.sobre.aulaasynctask;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvCount;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCount = findViewById(R.id.tvCount);
        btnStart = findViewById(R.id.btnStart);
    }

    public void startCount(View view) {
        new MyTask(btnStart,tvCount).execute(10);
    }

    private static class  MyTask extends AsyncTask<Integer,Integer,Void>{


        Button button;
        TextView textView;

        public MyTask(Button button,TextView textView){
            this.button = button;
            this.textView = textView;
        }

        @Override
        protected Void doInBackground(Integer... params) {
            int maxCount = params[0];

            for(int i = 0; i <= maxCount; i++){
                SystemClock.sleep(500);
                publishProgress(i);
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
//            super.onPreExecute();
            button.setEnabled(false);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
            button.setEnabled(true);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
//            super.onProgressUpdate(values);
            int valor = values[0];
            textView.setText(String.valueOf(valor));
        }
    }

}
