package com.INFS3634.ass3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.INFS3634.ass3.Entities.ChuckNorrisResponse;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    String joke = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvQuote = findViewById(R.id.tvQuote);
        Button btn = findViewById(R.id.btGetQuote);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/FredokaOneRegular.ttf");

        tvQuote.setTypeface(font);
        btn.setTypeface(font);
    }

    public void generateJoke (View view) {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        JokeService service = retrofit.create(JokeService.class);

        Call<ChuckNorrisResponse> jokeCall = service.getRandomJoke();

        jokeCall.enqueue(new Callback<ChuckNorrisResponse>() {
            @Override
            public void onResponse(Call<ChuckNorrisResponse> call, Response<ChuckNorrisResponse> response) {
                if(response.isSuccessful()) {
                    joke =response.body().getValue();
                    TextView tvQuote = findViewById(R.id.tvQuote);
                    tvQuote.setText(joke);
                    Log.d(TAG, "GOT-JOKE");
                }else{
                    Log.d(TAG, "ERROR IS: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ChuckNorrisResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: ON FAILURE IS: "+t.getLocalizedMessage());
            }
        });

    }
}
