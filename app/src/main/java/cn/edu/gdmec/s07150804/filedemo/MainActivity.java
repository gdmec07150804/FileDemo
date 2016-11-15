package cn.edu.gdmec.s07150804.filedemo;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
private TextView tv1;
    private File  fphoneDicectory;
    private File fexternalstoragepublicDicectory;
    private File fexternalstorageDicectory;
    private File fdataStorage;
    private File fdownloadcacheDicectory;
    private File frootDicectory;
    private String name,path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.result);
        fphoneDicectory=this.getFilesDir();
        fexternalstoragepublicDicectory= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        fexternalstorageDicectory=Environment.getExternalStorageDirectory();
        fdataStorage=Environment.getDataDirectory();
        fdownloadcacheDicectory=Environment.getDownloadCacheDirectory();
        frootDicectory=Environment.getRootDirectory();
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_REMOVED)){
            Button btn=(Button)findViewById(R.id.externalstorageDicectory);
            btn.setEnabled(false);
        }
    }
    public void phoneDicectory(View v){
        path=fphoneDicectory.getPath();

        try {
            FileOutputStream fos=openFileOutput("test.txt",MODE_PRIVATE);
            fos.write("hello".getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ListFiles(path);
    }
    public void externalstoragepublicDicectory(View v){
        path=fexternalstoragepublicDicectory.getAbsolutePath();
        ListFiles(path);
    }
    public void externalstorageDicectory(View v){
        path=fexternalstorageDicectory.getAbsolutePath();
        ListFiles(path);
    }
    public void dataStorage(View v){
        path=fdataStorage.getAbsolutePath();
        ListFiles(path);
    }
    public void downloadcacheDicectory(View v){
        path=fdownloadcacheDicectory.getAbsolutePath();
        ListFiles(path);
    }
    public void rootDicectory(View v){
        path=frootDicectory.getAbsolutePath();
        ListFiles(path);
    }

    private boolean ListFiles(String path) {
        name="路径："+path+"\n文件清单:\n";
        File file=new File(path);
        if (file.listFiles()!=null&&file.listFiles().length>0){
            for (File f : file.listFiles()){
                path=f.getAbsolutePath();
                name=name+f.listFiles()+"\n";
            }
        }
        tv1.setText(name);
        return true;
    }
}
