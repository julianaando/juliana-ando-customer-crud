package br.ada.customer.crud.integration.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MemoryDatabase {

    private static final MemoryDatabase INSTANCE = new MemoryDatabase();
    private final Map<String, List> database = new HashMap<>();

    private MemoryDatabase() {
    }

    public static MemoryDatabase getInstance() {
        return INSTANCE;
    }

    public <T> T saveOrUpdate(T object) {
        String key = makeKey(object);
        List<T> objects = database.getOrDefault(key, new ArrayList<>());
        objects.add(object);
        database.put(key, objects);
        return object;
    }

    public <T> List<T> listAll(Class<T> clazz) {
        String key = makeKey(clazz);
        return database.get(key);
    }

    public <T> List<T> find(Class<T> clazz, Predicate<T> predicate) {
        String key = makeKey(clazz);
        List<T> objects = database.getOrDefault(key, new ArrayList<>());
        List<T> found = objects.stream().filter(predicate)
                .collect(Collectors.toList());
        return found;
    }

    public <T> T delete(T object) {
        String key = makeKey(object);
        List<T> objects = database.getOrDefault(key, new ArrayList<>());
        objects.remove(object);
        return object;
    }

    private String makeKey(Object object) {
        return object.getClass().getName();
    }

    private String makeKey(Class clazz) {
        return clazz.getName();
    }

}
