package c.phannguyen.doan_android;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TabHost;
import android.app.TabActivity;
import  android.widget.TabHost.TabSpec;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class TrangChu extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
TabHost tabHost;
Button date;
String[] arr= {"Thu","Chi"};
Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        sp=(Spinner)findViewById(R.id.spiner1);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arr);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        sp.setAdapter(adapter);
        addTab();
        date=(Button)findViewById(R.id.btn_time);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dp=new DataPickerFragment();
                dp.show(getSupportFragmentManager(),"dp");
            }
        });
    }


    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar c=Calendar.getInstance();
        c.set(Calendar.YEAR,i);
        c.set(Calendar.MONTH,i1);
        c.set(Calendar.DAY_OF_MONTH,i2);
        String current= DateFormat.getDateInstance().format(c.getTime());
        TextView textView=(TextView)findViewById(R.id.timepker);
        textView.setText(current);
    }
    public void addTab()
    {
        tabHost=(TabHost)findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec t1=tabHost.newTabSpec("t1");
        t1.setIndicator("Chi tiêu");
        t1.setContent(R.id.tab1);
        tabHost.addTab(t1);

        TabHost.TabSpec t2=tabHost.newTabSpec("t2");
        t2.setIndicator("Tài khoản");
        t2.setContent(R.id.tab2);
        tabHost.addTab(t2);

        TabHost.TabSpec t3=tabHost.newTabSpec("t3");
        t3.setIndicator("Hạn mục chi");
        t3.setContent(R.id.tab3);

        tabHost.addTab(t3);
        TabHost.TabSpec t4=tabHost.newTabSpec("t4");
        t4.setIndicator("Báo cáo");
        t4.setContent(R.id.tab4);
        tabHost.addTab(t4);

        TabHost.TabSpec t5=tabHost.newTabSpec("t5");
        t5.setIndicator("Cài đặt");
        t5.setContent(R.id.tab5);
        tabHost.addTab(t5);
    }
}
