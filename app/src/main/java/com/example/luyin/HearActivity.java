package com.example.luyin;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import static java.security.AccessController.getContext;

public class HearActivity extends AppCompatActivity {

    ImageButton rightImageBtn;
    PopupMenu popupMenu;
    Menu menu;

    ImageButton goBackBtn;


    String menuTitle = "[黄景瑜]海若有因 矢志不渝";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏标题栏
        setContentView(R.layout.activity_hear);

        rightImageBtn = (ImageButton) findViewById(R.id.title_jubao);
        popupMenu = new PopupMenu(this, rightImageBtn);
        menu = popupMenu.getMenu();
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.jubao_menu,menu);
        //点击右按钮弹出菜单
        rightImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu.show();
            }
        });

        //点击菜单栏item
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item){
                switch (item.getItemId()){
                    case R.id.jubao:
                        Intent intent = new Intent(HearActivity.this,Jubao.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        goBackBtn = (ImageButton) findViewById(R.id.title_back);
        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }



}