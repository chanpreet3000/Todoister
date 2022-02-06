package com.chanpreet.todoister.data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.chanpreet.todoister.model.Task;
import com.chanpreet.todoister.util.TaskRoomDatabase;

import java.util.List;

public class TaskRepository {
    private static TaskDao taskDao;
    private static LiveData<List<Task>> list;

    public TaskRepository(Application application) {
        TaskRoomDatabase database = TaskRoomDatabase.getInstance(application);
        taskDao = database.taskDao();
        list = taskDao.getAll();
    }

    public LiveData<Task> get(long id) {
        return taskDao.get(id);
    }

    public void insert(Task task) {
        new InsertAsyncTask().execute(task);
    }

    public void update(Task task) {
        new UpdateAsyncTask().execute(task);
    }

    public void delete(Task task) {
        new DeleteAsyncTask().execute(task);
    }

    public void deleteAll() {
        new DeleteAllAsyncTask().execute();
    }

    public LiveData<List<Task>> getAll() {
        return list;
    }

    private static class GetAsyncTask extends AsyncTask<Long, Void, LiveData<Task>> {

        @Override
        protected LiveData<Task> doInBackground(Long... longs) {
            return taskDao.get(longs[0]);
        }
    }

    private static class InsertAsyncTask extends AsyncTask<Task, Void, Void> {

        @Override
        protected Void doInBackground(Task... tasks) {
            taskDao.insert(tasks[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<Task, Void, Void> {

        @Override
        protected Void doInBackground(Task... tasks) {
            taskDao.update(tasks[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<Task, Void, Void> {

        @Override
        protected Void doInBackground(Task... tasks) {
            taskDao.delete(tasks[0]);
            return null;
        }
    }

    private static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... Voids) {
            taskDao.deleteAll();
            return null;
        }
    }
}
