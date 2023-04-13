package coatocl.exaatocl.roomdb_basic;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "details")
public class CustomModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "detail_id")
    long detail_id;
    @ColumnInfo(name = "name")
    String name;
    @ColumnInfo(name = "duration")
    String duration;
    @ColumnInfo(name = "description")
    String description;

    public CustomModel(String name, String duration, String description) {
        this.name = name;
        this.duration = duration;
        this.description = description;
    }

    public long getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(long detail_id) {
        this.detail_id = detail_id;
    }

    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }
}
