package com.example.hw2.tasks;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class TaskListContent {

    public static final List<Task> ITEMS = new ArrayList<Task>();
    public static final Map<String, Task> ITEM_MAP = new HashMap<String, Task>();

   // private static final int COUNT = 5;

    static {
        //items
        addItem ( new Task ( String.valueOf ( 1 ), "Opel Kadett", "Zielony", "Klasyk"));
        addItem ( new Task ( String.valueOf ( 2 ), "Kamaz", "Zielony", "Wywrotka"));
        addItem ( new Task ( String.valueOf ( 3 ), "Żuk", "Zielony", "Po prostu żuk") );
    }

    public static void addItem(Task item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }


    /**
     * A dummy item representing a piece of content.
     */
    public static class Task implements Parcelable {
        public final String id;
        public String picPath;
        public final String model;
        public final String color;
        public final String details;

        public Task(String id, String model, String color, String details) {
            this.id = id;
            this.model=model;
            this.details=details;
            this.color=color;
            this.picPath="";

        }
        public Task(String id, String model, String color, String details, String picPath) {
            this.id = id;
            this.model=model;
            this.details=details;
            this.color=color;
            this.picPath=picPath;
        }

        protected Task(Parcel in) {
            id = in.readString();
            picPath = in.readString();
            model = in.readString();
            color = in.readString();
            details = in.readString();
        }

        public static final Creator<Task> CREATOR = new Creator<Task>() {
            @Override
            public Task createFromParcel(Parcel in) {
                return new Task(in);
            }

            @Override
            public Task[] newArray(int size) {
                return new Task[size];
            }
        };

        @Override
        public String toString() {
            return model;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(picPath);
            dest.writeString(model);
            dest.writeString(color);
            dest.writeString(details);
        }

        public void setPicPath(String path)
        {
            this.picPath = path;
        }
    }
    public static void removeItem(int position)
    {
        String itemId = ITEMS.get ( position ).id;

        ITEMS.remove ( position );

        ITEM_MAP.remove ( itemId );
    }
    public static void clearList()
    {
        ITEMS.clear ();
        ITEM_MAP.clear ();
    }
}
