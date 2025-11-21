package com.example.temiboardgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {

    private Button btnSuccess;
    private Button btnFail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btnSuccess = findViewById(R.id.btnSuccess);
        btnFail = findViewById(R.id.btnFail);

        // ★ 여기: getIntent() 결과를 받는 변수 이름은 receivedIntent 등으로 만든다
        Intent receivedIntent = getIntent();
        int position = receivedIntent.getIntExtra("position", 1);

        // 성공 → 다시 MainActivity (주사위 굴리기 화면)
        btnSuccess.setOnClickListener(v -> {
            Intent goDice = new Intent(ResultActivity.this, MainActivity.class);
            goDice.putExtra("position", position);
            startActivity(goDice);
            finish();
        });

        // 실패 → 같은 칸 TileActivity로 돌아가기
        btnFail.setOnClickListener(v -> {
            Intent goTile = new Intent(ResultActivity.this, TileActivity.class);
            goTile.putExtra("position", position);
            startActivity(goTile);
            finish();
        });
    }
}
