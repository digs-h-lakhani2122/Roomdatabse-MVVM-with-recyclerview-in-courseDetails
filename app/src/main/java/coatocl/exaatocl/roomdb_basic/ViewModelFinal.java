package coatocl.exaatocl.roomdb_basic;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModelFinal extends AndroidViewModel
{
    Repository repository;
    private final LiveData<List<CustomModel>> allCourses;

    public ViewModelFinal(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        allCourses = repository.getAllCourses();
    }

    public void insert(CustomModel model) {
        repository.insert(model);
    }

    public void update(CustomModel model) {
        repository.update(model);
    }

    public void delete(CustomModel model) {
        repository.delete(model);
    }

    public void deleteAllCourses() {
        repository.deleteAllCourses();
    }

    public LiveData<List<CustomModel>> getAllCourses() {
        return allCourses;
    }
}
