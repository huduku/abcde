package com.abcde.validator;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Validator {

    private String path;

    private String absolutePath;

    public Validator(String path) {
        this.path = path;
        URL url = this.getClass().getClassLoader().getResource(this.path);
        absolutePath = url.getFile();
    }

    public HashMap<String, Valid> validMap () throws IOException {
        Gson gson = new Gson();
        HashMap<String , Valid> map = gson.fromJson(reader() , new TypeToken<Map<String , Valid>>(){}.getType());
        return map;
    }

    public Reader reader() throws FileNotFoundException {
        return new FileReader(getAbsolutePath());
    }

    private String readConf () throws IOException {
        //1. define return data : content
        StringBuilder contentSb = new StringBuilder();

        BufferedReader br = null;
        try {
            //2. fetch file resources of config  : validateCTIF-TEST.json
            br = new BufferedReader(reader());

            //3. read content from the config file
            String line = null;
            while ((line = br.readLine()) != null) {
                contentSb.append(line);
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (null != br) {
                br.close();
            }
        }

        String content = contentSb.toString();
        return "".equals(content) ? null : content;
    }




    public String getPath() {
        return path;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }
}
