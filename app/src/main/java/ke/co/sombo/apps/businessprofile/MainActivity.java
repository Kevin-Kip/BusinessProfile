package ke.co.sombo.apps.businessprofile;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import ke.co.sombo.apps.businessprofile.Fragments.ContactFragment;
import ke.co.sombo.apps.businessprofile.Fragments.LocationFragment;

public class MainActivity extends AppCompatActivity {

    private int parent = R.id.my_fragment;
    private static final int TIME_DELAY = 2000;
    private static long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(parent,new ContactFragment(),new ContactFragment().getTag());
    }//

    private void loadFragment(int parent_id, Fragment fragment,String tag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentManager.popBackStack();
        fragmentTransaction.add(parent_id,fragment,tag);
        fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commit();
    }//

    public void sendMail(View view) {
        Intent mail = new Intent(Intent.ACTION_SENDTO);
        mail.setData(Uri.parse("mailto:" + getString(R.string.email_address)));
        mail.putExtra(Intent.EXTRA_TEXT,getString(R.string.mail_body));
        mail.putExtra(Intent.EXTRA_SUBJECT,getString(R.string.mail_subject));
        Intent chooser = Intent.createChooser(mail,"mail");

        try{
            startActivity(chooser);
        }catch (ActivityNotFoundException e){
            Log.d("Mail Chooser",e.getMessage());
        }
    }//

    public void dialNumber(View view) {
        Intent dial = new Intent(Intent.ACTION_DIAL);
        dial.setData(Uri.parse("tel:0725777777"));

        try{
            startActivity(dial);
        }catch (ActivityNotFoundException e){
            Log.d("Dial: ",e.getMessage());
        }
    }//

    //opens whatsApp inbox directly
    public void whatsappText(View view) {
        Intent whatsapp = new Intent(Intent.ACTION_VIEW);
        whatsapp.setData(Uri.parse(getString(R.string.whatsapp_text)));

        try{
            startActivity(whatsapp);
        }catch (ActivityNotFoundException e){
            Log.d("Whatsapp",e.getMessage());
        }
    }//

    public void loadContactFragment(View view) {
        loadFragment(parent,new ContactFragment(),new ContactFragment().getTag());
    }

    public void loadLocationFragment(View view) {
        loadFragment(parent,new LocationFragment(),new LocationFragment().getTag());
    }//

    public void openWebsite(View view) {
        Intent web = new Intent(Intent.ACTION_VIEW);
        web.setData(Uri.parse("www.kevinkip.rf.gd"));
        try{
            startActivity(web);
        }catch (ActivityNotFoundException e){
            Log.d("Whatsapp",e.getMessage());
        }
    }//

    @Override
    public void onBackPressed() {
        if (TIME_DELAY + back_pressed > System.currentTimeMillis()){
            super.onBackPressed();
            finishAffinity();
            System.exit(0);
        }else {
            Toast.makeText(getApplicationContext(), getString(R.string.press_again), Toast.LENGTH_SHORT).show();
        }
        back_pressed = System.currentTimeMillis();
    }//
}
