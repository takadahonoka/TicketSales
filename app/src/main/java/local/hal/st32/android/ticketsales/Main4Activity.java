package local.hal.st32.android.ticketsales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Toast.makeText(Main4Activity.this , "切符を購入されました。" , Toast.LENGTH_SHORT).show();

        Intent intent = getIntent();
        String strInputPrice = intent.getStringExtra("input");//使用した金額。
        String strTotalPrice = intent.getStringExtra("price");//電子マネー残高。

        TextView tvInputPrice = findViewById(R.id.tvInputPrice);
        tvInputPrice.setText(strInputPrice);
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
