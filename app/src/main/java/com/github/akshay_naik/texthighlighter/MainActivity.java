package com.github.akshay_naik.texthighlighter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.github.akshay_naik.texthighlighterapi.TextHighlighter;


public class MainActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextHighlighter highlighter=new TextHighlighter();

        highlighter.setColorForTheToken("awesome","red");
        highlighter.setColorForTheToken("text","purple");
        highlighter.setColorForTheToken("highlighter","blue");

        mTextView= (TextView) findViewById(R.id.mytextview);

        mTextView.setText(Html.fromHtml(highlighter.getHighlightedText("Awesome text highlighter")));
    }
}
