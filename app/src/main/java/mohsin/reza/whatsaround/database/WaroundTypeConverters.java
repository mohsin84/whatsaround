package mohsin.reza.whatsaround.database;

import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.util.StringUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Collections;
import java.util.List;

import mohsin.reza.whatsaround.vo.Categories;
import mohsin.reza.whatsaround.vo.Venue;

/**
 * Created by User on 10/6/2017.
 */

public class WaroundTypeConverters {
    @TypeConverter
    public static List<Integer> stringToIntList(String data) {
    if (data == null) {
        return Collections.emptyList();
    }

    return StringUtil.splitToIntList(data);
    }

    @TypeConverter
    public static String intListToString(List<Integer> ints) {
        return StringUtil.joinIntoString(ints);
    }

}
