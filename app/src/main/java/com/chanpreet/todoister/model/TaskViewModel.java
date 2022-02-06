package com.chanpreet.todoister.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.chanpreet.todoister.data.TaskRepository;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {
    private final TaskRepository repository;
    private final LiveData<List<Task>> list;

    public TaskViewModel(@NonNull Application application) {
        super(application);
        repository = new TaskRepository(application);
        list = repository.getAll();
    }

    public LiveData<Task> get(long id) {
        return repository.get(id);
    }

    public void insert(Task task) {
        repository.insert(task);
    }

    public void update(Task task) {
        repository.update(task);
    }

    public void delete(Task task) {
        repository.delete(task);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public LiveData<List<Task>> getAll() {
        return list;
    }
}
