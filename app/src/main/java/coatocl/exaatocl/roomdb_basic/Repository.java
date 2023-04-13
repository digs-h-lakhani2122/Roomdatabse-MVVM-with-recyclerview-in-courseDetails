package coatocl.exaatocl.roomdb_basic;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {
    private final Dao dao;
    LiveData<List<CustomModel>> allCourses;

    public Repository(Application application) {
        Database databaseIncome = Database.getInstance(application);
        dao = databaseIncome.Dao();
        allCourses = dao.getAllData();
    }

    void insert(CustomModel customModel) {
        new InsertAsyncTask(dao).execute(customModel);
    }

    void update(CustomModel customModel) {
        new UpdateAsyncTask(dao).execute(customModel);
    }

    void delete(CustomModel customModel) {
        new DeleteAsyncTask(dao).execute(customModel);
    }

    public void deleteAllCourses() {
        new DeleteAllCoursesAsyncTask(dao).execute();
    }

    LiveData<List<CustomModel>> getAllCourses() {
        return allCourses;
    }

    private static class InsertAsyncTask extends AsyncTask<CustomModel, Void, Void> {
        Dao dao;

        public InsertAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(CustomModel... customModels) {
            dao.insert(customModels[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<CustomModel, Void, Void> {
        Dao dao;

        public UpdateAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(CustomModel... customModels) {
            dao.update(customModels[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<CustomModel, Void, Void> {
        Dao dao;

        public DeleteAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(CustomModel... customModels) {
            dao.delete(customModels[0]);
            return null;
        }
    }

    private static class DeleteAllCoursesAsyncTask extends AsyncTask<Void, Void, Void> {
        private Dao dao;
        private DeleteAllCoursesAsyncTask(Dao dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllCourses();
            return null;
        }
    }
}
