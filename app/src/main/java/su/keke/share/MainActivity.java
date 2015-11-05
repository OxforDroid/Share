package su.keke.share;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView1;
    private Button button;
    private Button button_gen;
    private Button button_gen_tex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.textView);

        button = (Button) findViewById(R.id.share);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                share(textView1);

            }
        });

        button_gen = (Button) findViewById(R.id.gener);
        button_gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bildGum(v);


            }
        });

        button_gen_tex = (Button)findViewById(R.id.btn_tex_gen);
        button_gen_tex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bildTex(v);
            }
        });

    }
    public void share (TextView v)
    {
        String str = textView1.getText().toString();
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");

        //sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Я думаю что ");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, str);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
    public void bildGum (View v){

        String[]gum_list = getResources().getStringArray(R.array.gum_list);
// Вычисляем, сколько слов в каждом списке
        int gumLength = gum_list.length;
//Генерируем случайное число
        int randl = (int) (Math.random() * gumLength);
//Теперь строим фразу
        String phrase =  gum_list[randl];
        textView1.setText("");//очищаем поле
        textView1.setText(phrase);//вставляем фразу
    }

    public void bildTex (View v){
        String[]tex_list = getResources().getStringArray(R.array.tex_list);
        int texLength = tex_list.length;
        int rand3 = (int) (Math.random() * texLength);
        String phrase2 =  tex_list[rand3];

        textView1.setText("");
        textView1.setText(phrase2);

    }
}
