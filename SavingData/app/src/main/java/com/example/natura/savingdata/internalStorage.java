package com.example.natura.savingdata;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class internalStorage extends Activity {

    EditText et_savedata, et_readdata;
    TextView tv;
    private final int BUFFERSIZE = 1024;
    private final String FILENAME = "MyInternalFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);
        et_savedata = findViewById(R.id.et_save);
        et_readdata = findViewById(R.id.et_read);
        tv = findViewById(R.id.tv_info);
    }

    public void saveData (View view) {
        String data = et_savedata.getText().toString();
        File file = getFilesDir();
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(data.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        tv.setText(FILENAME + " Write succesfully to " + file.getAbsolutePath());
    }
    public void readData(View view) {
        File file = getFilesDir();
        StringBuffer stringBuffer = new StringBuffer();
        FileInputStream fis = null;
        try {
            fis = openFileInput(FILENAME);
            int readMessage = -1;
            byte[] byteBuffer = new byte[BUFFERSIZE];
            while ((readMessage = fis.read(byteBuffer, 0, BUFFERSIZE)) != -1) {
                stringBuffer.append(new String(byteBuffer, 0, readMessage));
                et_readdata.setText(stringBuffer.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        tv.setText(FILENAME + " Read succesfully from " + file);
    }
}
