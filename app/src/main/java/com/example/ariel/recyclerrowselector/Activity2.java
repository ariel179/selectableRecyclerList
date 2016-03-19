package com.example.ariel.recyclerrowselector;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.TextView;

        import org.w3c.dom.Text;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Bundle bundle = getIntent().getExtras();

        int position = bundle.getInt("position",0);

        TextView textView = (TextView) findViewById(R.id.textView2);

        textView.setText(position+"");

    }
}
