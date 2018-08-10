package ru.yandex.yamblz.util;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import ru.yandex.yamblz.R;
import ru.yandex.yamblz.models.Artist;

public class ArtistManager {
    private static List<Artist> smArtistList;
    private Context mContext;

    public ArtistManager(Context context) {
        mContext = context;
    }

    public List<Artist> getArtistList() {
        if (smArtistList == null) {
            Type listType = new TypeToken<ArrayList<Artist>>(){}.getType();
            String json = ResourceManager.readToString(mContext.getResources(),
                    R.raw.some_app_data);

            return new Gson().fromJson(json, listType);
        }

        return smArtistList;
    }
}
