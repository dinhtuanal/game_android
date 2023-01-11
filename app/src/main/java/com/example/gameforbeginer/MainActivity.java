package com.example.gameforbeginer;

import static java.lang.Integer.parseInt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.gameforbeginer.databinding.ActivityMainBinding;

import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    Button btnGuess;
    Button btnHelpMeHelpMe;
    Button btnReset;
    EditText inputText;
    TextView tvResult;
    TextView tvResultShow;
    TextView tvNumberCorrect;
    int random;
    int numberGuessSuccess = 0;
    int indexRandomMessage;
    String[] moreThan = {
            "Lớn hơn xíu nữa như số cớ crush tránh xa bạn",
            "Thêm xíu nữa thôi là đúng rồi",
            "Số bạn đoán còn nhỏ quá, gấp đôi",
            "Bạn chưa nghe câu 30 chưa phải là tết à, 31 thử xem",
            "Số nhỏ vậy mà cũng đoán được à, bạn đùa tôi đúng không",
            "Cao như số điểm của Tuân vào ngày thứ 6",
            "Cao xíu nữa",
            "Nhỏ quá ạ",
            "Cộng 10 nữa xem đúng không"
    };

    String[] lessThan = {
            "Nhỏ hơn xíu nữa như cách nyc từ bỏ bạn",
            "Nhỏ như lương IT thôi",
            "Số 0 thử coi",
            "Số này nhỏ lắm, bạn đoán trên trời vậy...",
            "Nhỏ như số cơ hội bạn có được họ",
            "Nhỏ như hạt đậu",
            "Nhỏ tí nữa là đúng",
            "Trừ thêm 10 nữa may ra mới đúng nha"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.gameforbeginer);
        tvResult = (TextView) findViewById(R.id.textViewResult);
        tvResultShow = (TextView) findViewById(R.id.textView3);
        btnGuess = (Button) findViewById(R.id.buttonGuess);
        inputText = (EditText) findViewById(R.id.inputText);
        btnHelpMeHelpMe = (Button) findViewById(R.id.buttonHelpMe);
        btnReset = (Button) findViewById(R.id.buttonPlayAgain);
        tvNumberCorrect = (TextView) findViewById(R.id.tvNumber);

        random = new Random().nextInt(10) + 1;
        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    int inputTextParseInt = Integer.parseInt(String.valueOf(inputText.getText()));
                    if(random > inputTextParseInt){
                        indexRandomMessage = new Random().nextInt(moreThan.length);
                        tvResult.setText(moreThan[indexRandomMessage]);
                    }
                    else if(random < inputTextParseInt){
                        indexRandomMessage = new Random().nextInt(lessThan.length);
                        tvResult.setText(lessThan[indexRandomMessage]);
                    }
                    else{
                        numberGuessSuccess += 1;
                        tvResult.setText("Chính xác, rồi bạn cũng vậy, đi tìm số khác nhé, cũng như đi tìm lấy tình yêu của bạn");
                        tvNumberCorrect.setText(String.valueOf(numberGuessSuccess));
                        inputText.setText("");
                        random = new Random().nextInt(10) + 1;
                    }
                }catch(Exception ex){
                    tvResult.setText("I suggest you input number??");
                }
            }
        });

        btnHelpMeHelpMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText("Đó là số " + random + " !!! Gà");
                inputText.setText("");
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                random = new Random().nextInt(10) + 1;
                tvResult.setText("Chơi kém vậy, tôi đã cất công tạo ra cái app này đấy");
                inputText.setText("");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}