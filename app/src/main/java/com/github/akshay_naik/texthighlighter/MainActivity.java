package com.github.akshay_naik.texthighlighter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.EditText;
import android.widget.TextView;

import com.github.akshay_naik.texthighlighterapi.TextHighlighter;



public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextHighlighter highlighter=new TextHighlighter();

        String code="#include  &lt; iostream.h > <br/>  <br/> void main (  )  <br/>  {  <br/> &nbsp;&nbsp; int s1, s2, s3, s4, s5, sum, total = 500; <br/> &nbsp;&nbsp; float per; <br/> &nbsp;&nbsp; cout &lt;&lt; \"\\nEnter marks of 5 subjects :\"; <br/> &nbsp;&nbsp; cin >>s1>>s2>>s3>>s4>>s5; <br/> &nbsp;&nbsp;  <br/> &nbsp;&nbsp; sum = s1 + s2 + s3 + s4 + s5; <br/> &nbsp;&nbsp; cout &lt;&lt; \"\\nSum :\" &lt;&lt; sum; <br/> &nbsp;&nbsp;  <br/> &nbsp;&nbsp; per =  ( sum * 100 ) /500; <br/> &nbsp;&nbsp; /* percentage formula*/ <br/> &nbsp;&nbsp; cout &lt;&lt; \"\\nPercentage :\" &lt;&lt; per; <br/>  }  <br/>  <br/> Output: <br/>  <br/> Enter marks of % subjects : <br/> 89 81 79 85 75 <br/> sum: 409 <br/> Percentage: 81.00000 <br/> ";

/*        highlighter.setDefaultColor("black");

        highlighter.setColorForTheToken("awesome","red");
        highlighter.setColorForTheToken("text","purple");
        highlighter.setColorForTheToken("highlighter","blue");

        highlighter.setStyleForTheToken("Awesome",TextHighlighter.BOLD);
        highlighter.setStyleForTheToken("Text",TextHighlighter.UNDERLINE);
        highlighter.setStyleForTheToken("Highlighter",TextHighlighter.ITALIC);

*/
       highlighter.setLanguage(highlighter.JAVA);
        mTextView= (TextView) findViewById(R.id.mytextview);


        String highlightedText=highlighter.getHighlightedText(code);
        String styledText=highlighter.getStyledText(highlightedText);

        mTextView.setText(Html.fromHtml(highlightedText));

    }
}
