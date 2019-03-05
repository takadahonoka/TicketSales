package local.hal.st32.android.ticketsales;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    private int[] intTotalPrice = {0,0,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Toast.makeText(Main3Activity.this , "切符を購入されました。" , Toast.LENGTH_SHORT).show();

        Intent intent = getIntent();
        String strInputPrice = intent.getStringExtra("input");//投入金額と、金種の枚数。
        int[] intInputPrice = intent.getIntArrayExtra("inputs");
        String strChangePrice = intent.getStringExtra("change");//お釣りの金額と、金種の枚数。
        int[] intChangePrice = intent.getIntArrayExtra("changes");
        String strTotalPrice = intent.getStringExtra("price");//残額の金額と、金種の枚数。
        intTotalPrice = intent.getIntArrayExtra("prices");


        //各表に表示。
        TextView tvPrice01 = findViewById(R.id.include_views_1).findViewById(R.id.tvPrice01);
        tvPrice01.setText(String.valueOf(intInputPrice[6]));
        TextView tvPrice02 = findViewById(R.id.include_views_1).findViewById(R.id.tvPrice02);
        tvPrice02.setText(String.valueOf(intInputPrice[5]));
        TextView tvPrice03 = findViewById(R.id.include_views_1).findViewById(R.id.tvPrice03);
        tvPrice03.setText(String.valueOf(intInputPrice[4]));
        TextView tvPrice04 = findViewById(R.id.include_views_1).findViewById(R.id.tvPrice04);
        tvPrice04.setText(String.valueOf(intInputPrice[3]));
        TextView tvPrice05 = findViewById(R.id.include_views_1).findViewById(R.id.tvPrice05);
        tvPrice05.setText(String.valueOf(intInputPrice[2]));
        TextView tvPrice06 = findViewById(R.id.include_views_1).findViewById(R.id.tvPrice06);
        tvPrice06.setText(String.valueOf(intInputPrice[1]));
        TextView tvPrice07 = findViewById(R.id.include_views_1).findViewById(R.id.tvPrice07);
        tvPrice07.setText(String.valueOf(intInputPrice[0]));

        tvPrice01 = findViewById(R.id.include_views_2).findViewById(R.id.tvPrice01);
        tvPrice01.setText(String.valueOf(intChangePrice[6]));
        tvPrice02 = findViewById(R.id.include_views_2).findViewById(R.id.tvPrice02);
        tvPrice02.setText(String.valueOf(intChangePrice[5]));
        tvPrice03 = findViewById(R.id.include_views_2).findViewById(R.id.tvPrice03);
        tvPrice03.setText(String.valueOf(intChangePrice[4]));
        tvPrice04 = findViewById(R.id.include_views_2).findViewById(R.id.tvPrice04);
        tvPrice04.setText(String.valueOf(intChangePrice[3]));
        tvPrice05 = findViewById(R.id.include_views_2).findViewById(R.id.tvPrice05);
        tvPrice05.setText(String.valueOf(intChangePrice[2]));
        tvPrice06 = findViewById(R.id.include_views_2).findViewById(R.id.tvPrice06);
        tvPrice06.setText(String.valueOf(intChangePrice[1]));
        tvPrice07 = findViewById(R.id.include_views_2).findViewById(R.id.tvPrice07);
        tvPrice07.setText(String.valueOf(intChangePrice[0]));

        tvPrice01 = findViewById(R.id.include_views_3).findViewById(R.id.tvPrice01);
        tvPrice01.setText(String.valueOf(intTotalPrice[6]));
        tvPrice02 = findViewById(R.id.include_views_3).findViewById(R.id.tvPrice02);
        tvPrice02.setText(String.valueOf(intTotalPrice[5]));
        tvPrice03 = findViewById(R.id.include_views_3).findViewById(R.id.tvPrice03);
        tvPrice03.setText(String.valueOf(intTotalPrice[4]));
        tvPrice04 = findViewById(R.id.include_views_3).findViewById(R.id.tvPrice04);
        tvPrice04.setText(String.valueOf(intTotalPrice[3]));
        tvPrice05 = findViewById(R.id.include_views_3).findViewById(R.id.tvPrice05);
        tvPrice05.setText(String.valueOf(intTotalPrice[2]));
        tvPrice06 = findViewById(R.id.include_views_3).findViewById(R.id.tvPrice06);
        tvPrice06.setText(String.valueOf(intTotalPrice[1]));
        tvPrice07 = findViewById(R.id.include_views_3).findViewById(R.id.tvPrice07);
        tvPrice07.setText(String.valueOf(intTotalPrice[0]));


        TextView tvInputPrice = findViewById(R.id.tvInputPrice);
        tvInputPrice.setText(strInputPrice);
        TextView tvChangePrice = findViewById(R.id.tvChangePrice);
        tvChangePrice.setText(strChangePrice);
        TextView tvTotalPrice = findViewById(R.id.tvTotalPrice);
        tvTotalPrice.setText(strTotalPrice);

    }

    /**
     * 終了ボタンをクリックした時。
     * @param view
     */
    public void onFinishButton(View view){
        finish();
    }
}
