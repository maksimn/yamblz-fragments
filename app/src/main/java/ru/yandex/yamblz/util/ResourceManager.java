package ru.yandex.yamblz.util;

import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class ResourceManager {
    public static String readToString(Resources resources, int resourceId) {
        InputStream is = resources.openRawResource(resourceId);
        Writer writer = new StringWriter();
        char[] buffer = new char[10000];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (Exception e) {
            return null;
        } finally {
            try {
                is.close();
            } catch (Exception e) {
                return null;
            }
        }

        return writer.toString();
    }
}
