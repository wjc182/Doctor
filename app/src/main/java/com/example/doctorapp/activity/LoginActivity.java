package com.example.doctorapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doctorapp.R;
import com.example.doctorapp.login.contract.LoginContract;
import com.example.doctorapp.login.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginContract.iLoginView {

    private ImageView loginImage;
    private EditText loginName;
    private EditText loginPassword;
    private Button login;
    private TextView liner;
    private ImageView qq;
    private ImageView weiXin;
    private ImageView weiBo;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        //准备数据
        initData();
    }

    private void initData() {
        loginPresenter = new LoginPresenter(this);
    }

    private void initView() {
        loginImage = (ImageView) findViewById(R.id.login_image);
        loginName = (EditText) findViewById(R.id.login_name);
        loginPassword = (EditText) findViewById(R.id.login_password);
        login = (Button) findViewById(R.id.login);
        liner = (TextView) findViewById(R.id.liner);
        qq = (ImageView) findViewById(R.id.qq);
        weiXin = (ImageView) findViewById(R.id.weiXin);
        weiBo = (ImageView) findViewById(R.id.weiBo);

        login.setOnClickListener((v)->{
                if (!TextUtils.isEmpty(loginName.getText().toString()) && !TextUtils.isEmpty(loginPassword.getText().toString())) {
                    loginPresenter.getLoginPresenter(loginName.getText().toString(),loginPassword.getText().toString());
                } else {
                    Toast.makeText(LoginActivity.this, "用户名密码账号不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        );

        qq.setOnClickListener((v)-> {
                    Toast.makeText(this, "qq分享未做", Toast.LENGTH_SHORT).show();
                }
        );

        weiXin.setOnClickListener((v)-> {
                    Toast.makeText(this, "微信分享未做", Toast.LENGTH_SHORT).show();
                }
        );

        weiBo.setOnClickListener((v)-> {
                    Toast.makeText(this, "微博分享未做", Toast.LENGTH_SHORT).show();
                }
        );


    }

    @Override
    public void onLoginSuccess() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

    @Override
    public void onLoginFail(String error) {
        Log.e("TAG","登陆错误"+error);
    }
}