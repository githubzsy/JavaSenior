package com.atguigu.java.network;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {
    @Test
    public void test() throws IOException {
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            URL url = new URL("http://9.pic.paopaoche.net/up/2014-6/201462516851.jpg");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            inputStream = urlConnection.getInputStream();
            fileOutputStream = new FileOutputStream("201462516851.jpg");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileOutputStream!=null){
                fileOutputStream.close();
            }
            
            if(inputStream!=null){
                inputStream.close();
            }
            
            if(urlConnection!=null){
                urlConnection.disconnect();
            }

        }



    }
}
