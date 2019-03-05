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

public class Main2Activity extends AppCompatActivity {

    private int[] price = {0, 0, 0, 0, 0, 0, 0};
    private int[] nowPrice = {0, 0, 0, 0, 0, 0, 0};
    private int intTotalPrice = 0;
    private int intInPrice = 0;
    private String strTotalPrice = "";

    private int intCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // アクションバーに前画面に戻る機能をつける
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        price = new int[]{15, 3, 2, 1, 1, 1, 1};//所持金額の数。
        intTotalPrice = getTotalPrice(price);//所持金額の合計。

        //チケット枚数を取得。
        Intent intent = getIntent();
        intCount = intent.getIntExtra("count",0);

        TextView tvCount = findViewById(R.id.tvCount);//枚数。
        tvCount.setText(String.valueOf(intCount)+"枚");

        TextView tvInprice = findViewById(R.id.tvInPrice);//投入された金額。
        tvInprice.setText("0円");

        //レイアウト変更。
        LinearLayout layout = findViewById(R.id.llPriceContent);
        layout.removeAllViews();
        getLayoutInflater().inflate(R.layout.price_button, layout);

    }

    //総額を求める。
    public int getTotalPrice(int[] price) {
        int total = 0;
        total = (price[0] * 10) + (price[1] * 50) + (price[2] * 100) + (price[3] * 500) + (price[4] * 1000) + (price[5] * 5000) + (price[6] * 10000);
        Log.d("getTotalPriceの確認!!", String.valueOf(total));
        return total;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemid = item.getItemId();
        switch (itemid) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 各金額のボタンをクリックした時。
     * @param view
     */
    public void onInPrice(View view){

        if (intInPrice<intTotalPrice) {
            switch (view.getId()) {
                case R.id.btPrice01:
                    if (price[0]>=nowPrice[0]+1) {
                        intInPrice += 10;
                        nowPrice[0] += 1;
                    } else {
                        Toast.makeText(Main2Activity.this , "それ以上その金種を持っていません。" , Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btPrice02:
                    if (price[1]>=nowPrice[1]+1) {
                        intInPrice += 50;
                        nowPrice[1] += 1;
                    } else {
                        Toast.makeText(Main2Activity.this , "それ以上その金種を持っていません。" , Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btPrice03:
                    if (price[2]>=nowPrice[2]+1) {
                        intInPrice += 100;
                        nowPrice[2] += 1;
                    } else {
                        Toast.makeText(Main2Activity.this , "それ以上その金種を持っていません。" , Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btPrice04:
                    if (price[3]>=nowPrice[3]+1) {
                        intInPrice += 500;
                        nowPrice[3] += 1;
                    } else {
                        Toast.makeText(Main2Activity.this , "それ以上その金種を持っていません。" , Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btPrice05:
                    if (price[4]>=nowPrice[4]+1) {
                        intInPrice += 1000;
                        nowPrice[4] += 1;
                    } else {
                        Toast.makeText(Main2Activity.this , "それ以上その金種を持っていません。" , Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btPrice06:
                    if (price[5]>=nowPrice[5]+1) {
                        intInPrice += 5000;
                        nowPrice[5] += 1;
                    } else {
                        Toast.makeText(Main2Activity.this , "それ以上その金種を持っていません。" , Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btPrice07:
                    if (price[6]>=nowPrice[6]+1) {
                        intInPrice += 10000;
                        nowPrice[6] += 1;
                    } else {
                        Toast.makeText(Main2Activity.this , "それ以上その金種を持っていません。" , Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
            TextView tvInprice = findViewById(R.id.tvInPrice);//投入された金額。
            tvInprice.setText(intInPrice + "円");

            int intTicketPrice = (130 * intCount);//チケットの総額。

            if (intInPrice>=intTicketPrice){
                //投入金額が、チケット料金より大きくなった時。
                Intent intent = new Intent(Main2Activity.this , Main3Activity.class);

                //投入した金額と、金種と枚数
                intent.putExtra("input", String.valueOf(intInPrice) + "円");//投入した金種と枚数。
                intent.putExtra("inputs", new int[]{nowPrice[0], nowPrice[1], nowPrice[2], nowPrice[3], nowPrice[4], nowPrice[5], nowPrice[6]});

                //お釣りの金額と、金種と枚数。
                int[] changePrice = getChangePrice(intInPrice - intTicketPrice);
                intent.putExtra("change", String.valueOf(intInPrice - intTicketPrice) + "円");
                intent.putExtra("changes", changePrice);

                //残額の金額と、金種と枚数。
                int[] intResultPrice = {price[0] - nowPrice[0] + changePrice[0], price[1] - nowPrice[1] + changePrice[1], price[2] - nowPrice[2] + changePrice[2], price[3] - nowPrice[3] + changePrice[3], price[4] - nowPrice[4] + changePrice[4], price[5] - nowPrice[5] + changePrice[5], price[6] - nowPrice[6] + changePrice[6]};
                intent.putExtra("price", String.valueOf(getTotalPrice(intResultPrice)) + "円");
                intent.putExtra("prices", intResultPrice);
                finish();
                startActivity(intent);
            }

        }else {
            Toast.makeText(Main2Activity.this , "所持金額を全て投入されました。。" , Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * クリアボタンがクリックされた時。
     * @param view
     */
    public void onClearPrice(View view){
        nowPrice = new int[]{0,0,0,0,0,0,0};
        intInPrice = 0;
        TextView tvInprice = findViewById(R.id.tvInPrice);
        tvInprice.setText(intInPrice + "円");
    }

    /**
     * お釣りの総額から、各金種の枚数を求める。
     * @param price
     * @return
     */
    public int[] getChangePrice(int price){
        int[] intChangePrice = {0,0,0,0,0,0,0};
        if(price >= 10000) {
            intChangePrice[6] = price / 10000;
            price = price % 10000;
        }
        if(price >= 5000) {
            intChangePrice[5] = price / 5000;
            price = price % 5000;
        }
        if(price >= 1000) {
            intChangePrice[4] = price / 1000;
            price = price % 1000;
        }
        if(price >= 500) {
            intChangePrice[3] = price / 500;
            price = price % 500;
        }
        if(price >= 100) {
            intChangePrice[2] = price / 100;
            price = price % 100;
        }
        if(price >= 50) {
            intChangePrice[1] = price / 50;
            price = price % 50;
        }
        if(price >= 10) {
            intChangePrice[0] = price / 10;
            price = price % 10;
        }
        return intChangePrice;
    }

    /**
     * 電子マネーボタンをクリック。
     * @param view
     */
    public void onPriceClick(View view){

        int intTicketPrice = 0;
        int intChangePrice = 0;

        Intent intent = new Intent(Main2Activity.this , Main4Activity.class);

        intInPrice = 1000;//電子マネー残額。

        intTicketPrice = (124 * intCount);//チケットの総額。

        if (intInPrice>=intTicketPrice) {

            intChangePrice = intInPrice - intTicketPrice;//お釣り。
            this.strTotalPrice = String.valueOf(intChangePrice) + "円";

            //サーバと通信。
            String[] strResult = getCommunication("カードのID",intTicketPrice);

            if (strResult[0] == "true") {

                //投入した金額と、金種と枚数。
                intent.putExtra("input", String.valueOf(intTicketPrice) + "円");

                //残った金額と、金種と枚数。
                intent.putExtra("price", strResult[1]);

                finish();
                startActivity(intent);

            }
        }
    }

    /**
     * サーバー通信。
     * @param id 電子マネーのカードのID。
     * @param price 利用した価格。
     * @return 結果。
     */
    public String[] getCommunication(String id,int price){
        //ここで通信する。
        String[] result = {"true",strTotalPrice};
        return result;//結果。
    }
}
