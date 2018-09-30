package c.phannguyen.doan_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button dk;
Button dn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dk=(Button)findViewById(R.id.btn_dangky);
        dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getApplicationContext(),FormDangKy.class);
                startActivity(intent1);
            }
        });

        dn =(Button)findViewById(R.id.btn_dangnhap);
        dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),TrangChu.class);
                startActivity(intent);
            }
        });

    }
}
