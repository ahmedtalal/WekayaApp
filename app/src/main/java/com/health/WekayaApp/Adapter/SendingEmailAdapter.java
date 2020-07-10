package com.health.WekayaApp.Adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.health.WekayaApp.UI.MainActivity;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;

public class SendingEmailAdapter extends AsyncTask<Message, String , String > {
    private ProgressDialog progressDialog ;
    Context context ;

    public SendingEmailAdapter(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("ارسال المسج.....");
        progressDialog.setTitle("من فضلك انتظر بضع لحظات");
        progressDialog.show();
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    }

    @Override
    protected String doInBackground(Message... messages) {
        try {
            Transport.send(messages[0]);
            return "Success" ;
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error" ;
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        progressDialog.dismiss();
        if (s.equals("Success")){
            //Toast.makeText(context , "شكرا علي محاولتك لعطائنا رأيك " , Toast.LENGTH_LONG).show();
            Intent intent =  new Intent(context , MainActivity.class) ;
            context.startActivity(intent);
            ((MainActivity)context).finish();
        }else {
            Intent intent =  new Intent(context , MainActivity.class) ;
            context.startActivity(intent);
            ((MainActivity)context).finish();
        }
    }
}
