package fi.jamk.signal;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TelephonyManager mTelephonyManager;
    MyPhoneStateListener mPhoneStatelistener;
    int mSignalStrength = 0;
    int mCdmaStrength=0;
    int mStrength=0;
    TextView mText;
    TextView mText1;
    TextView mText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TelephonyManager telephonyManager = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
        //CellInfoLte cellinfogsm = (CellInfoLte)telephonyManager.getAllCellInfo().get(0);
        //CellSignalStrengthLte cellSignalStrengthGsm = cellinfogsm.getCellSignalStrength();
        //int i = cellSignalStrengthGsm.getDbm();



        mPhoneStatelistener = new MyPhoneStateListener();
        mTelephonyManager=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);

        mTelephonyManager.listen(mPhoneStatelistener,PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);



        mText=(TextView)findViewById(R.id.textview);

        mText1=(TextView)findViewById(R.id.textview1);

        mText2=(TextView)findViewById(R.id.textview2);


        }


    class MyPhoneStateListener extends PhoneStateListener {

        @Override
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            mSignalStrength = signalStrength.getGsmSignalStrength();
            mSignalStrength = (2 * mSignalStrength) - 113; // -> dBm

            mCdmaStrength = signalStrength.getCdmaDbm();

            mStrength = signalStrength.getGsmBitErrorRate();


            mText.setText(Integer.toString(mSignalStrength));
            mText1.setText(Integer.toString(mCdmaStrength));
            mText2.setText(Integer.toString(mStrength));
        }

    }
}
