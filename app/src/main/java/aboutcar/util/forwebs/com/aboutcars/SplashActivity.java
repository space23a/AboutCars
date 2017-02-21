package aboutcar.util.forwebs.com.aboutcars;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import aboutcar.util.forwebs.com.aboutcars.util.UtilCom;

public class SplashActivity extends AppCompatActivity {

    public static final String TAG = "SplashActivity";

    static Activity act;
    boolean thread_state = true;
    ProgressBar m_ProgressReceive;
    ProgressBar m_ProgressRoll;
    TextView info_states;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        m_ProgressReceive = (ProgressBar) findViewById(R.id.progressBar_intro);
        m_ProgressRoll = (ProgressBar) findViewById(R.id.info_progress);
        info_states = (TextView) findViewById(R.id.info_states);

        Activitydlr.sendEmptyMessage(0);

    }

    @SuppressLint("HandlerLeak")
    Handler Activitydlr = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            // 로딩바 100% - 메인페이지 이동

            try {

                if (m_ProgressReceive.getProgress() >= 100) {
                    // Log.e(TAG, "state:100");

                    Intent intent_login = new Intent(act, MainActivity.class);
                    startActivity(intent_login);
                    finish();


                    // 01.07 : 로딩바 0% -
                } else if (m_ProgressReceive.getProgress() <= 0) {
                    // Log.e(TAG, "state:00");

                    progressup(thread_state);

                    // 01.07 : 로딩바10% - internet connetting
                } else if (m_ProgressReceive.getProgress() == 10) {
                    // Log.e(TAG, "state:10");

                    progressup(thread_state);


                    // 01.07 : 로딩바20% - server info get
                } else if (m_ProgressReceive.getProgress() == 20) {
                    // Log.e(TAG, "state:20");

                    progressup(thread_state);

                    // 02.25 : 로딩바25% -벤 회원
                } else if (m_ProgressReceive.getProgress() == 25) {
                    // Log.e(TAG, "state:25");

                    progressup(thread_state);

                    // 01.07 : 로딩바30% - id 가져오기 ,로그인
                } else if (m_ProgressReceive.getProgress() == 30) {
                    // Log.e(TAG, "progress 30%");

                    progressup(thread_state);


                    // 01.07 : 로딩바40% - 오토 로그인
                } else if (m_ProgressReceive.getProgress() == 40) {
                    // Log.e(TAG, "progress 40%");

                    Log.e(TAG, "실행");
                    thread_state = false;
                    boolean flag = UtilCom.permissionAgree(act, "");

                    if (flag) {

                        progressup(thread_state);

                    }


                    // 01.07 : 로딩바50% -
                } else if (m_ProgressReceive.getProgress() == 50) {


                    progressup(thread_state);

                    // 01.07 : 로딩바 60% - 차단자 제어
                } else if (m_ProgressReceive.getProgress() == 60) {


                    progressup(thread_state);

                    // 01.07 : 로딩바 70% - JSON db 입력
                } else if (m_ProgressReceive.getProgress() == 70) {
                    // Log.e(TAG, "state:70");

                    progressup(thread_state);

                    // 01.07 : 로딩바 80% - 마켓 업데이트
                } else if (m_ProgressReceive.getProgress() == 80) {
                    // Log.e(TAG, "state:80");

                    progressup(thread_state);


                    // 로딩바 90% - 비회원 약관동의
                } else if (m_ProgressReceive.getProgress() == 90) {
                    // Log.e(TAG, "state:90");

                    progressup(thread_state);


                } else {
                    Log.e(TAG, "실행 ELSE");
                    progressup(thread_state);

                }

            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }

    };// handle exit

    // loading state
    public void progressup(boolean thread_state) {
        if (thread_state) {

            info_states.setText(Integer.toString(m_ProgressReceive.getProgress()) + "%");

            m_ProgressReceive.incrementProgressBy(5);

            setProgress(m_ProgressReceive.getProgress() * 100);
            Activitydlr.sendEmptyMessageDelayed(0, 120);

            Log.e(TAG, "splash state:" + m_ProgressReceive.getProgress());
        } else {

        }
    }
}
