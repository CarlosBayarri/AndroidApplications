package com.example.natura.savingdata;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.provider.Telephony.Mms.Part.FILENAME;

public class ExternalStorage extends Activity {

    EditText et_savedata, et_readdata;
    TextView tv;
    private final int BUFFERSIZE = 1024;
    private final String PUBEXTFILENAME = "MyPublicFile";
    private final String PRIVEXTFILENAME = "MyPrivateFile";

    File publicFolder, publicFile, privateFolder, privateFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);
        et_savedata = findViewById(R.id.et_save);
        et_readdata = findViewById(R.id.et_read);
        tv = findViewById(R.id.tv_info);

        publicFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        publicFile = new File(publicFolder, PUBEXTFILENAME);

        privateFolder = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        privateFile = new File(privateFolder, PRIVEXTFILENAME);
    }

    public void saveToPublicStorage(View view) {
        saveData(publicFile);
    }
    public void saveToPrivateStorage(View view) {
        saveData(privateFile);
    }
    public void readFromPublicStorage(View view) {
        readData(publicFile);
    }
    public void readFromPrivateStorage(View view) {
        readData(privateFile);
    }

    void saveData (File fileName) {
        String data = et_savedata.getText().toString();
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(fileName);
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
        tv.setText(" Write succesfully to " + fileName.getAbsolutePath());
    }
    void readData(File fileName) {
        StringBuffer stringBuffer = new StringBuffer();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
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
        tv.setText(" Read succesfully from " + fileName.getAbsolutePath());
    }

}