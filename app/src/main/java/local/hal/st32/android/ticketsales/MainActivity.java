package local.hal.st32.android.ticketsales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int[] price = {0, 0, 0, 0, 0, 0, 0};
    private int intTotalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //チケットの金額。
        TextView tvTicket = findViewById(R.id.tvTicket);
        tvTicket.setText("130円");
    }

    /**
     * 枚数ボタンがクリックされた時(1〜4枚まで)。
     * @param view
     */
    public void onCountClick(View view){
        int intCount = 0;
        switch (view.getId()){
            case R.id.btCount01:
                intCount = 1;
                break;
            case R.id.btCount02:
                intCount = 2;
                break;
            case R.id.btCount03:
                intCount = 3;
                break;
            case R.id.btCount04:
                intCount = 4;
                break;
        }
        Intent intent = new Intent(MainActivity.this , Main2Activity.class);
        intent.putExtra("count" , intCount);
        startActivity(intent);
    }
}
