package model;

import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static Model instance = new Model();
    private List<User> model;

    public static Model getInstance(){
        return instance;
    }
    private Model(){
        model = new ArrayList<>();
    }
    public void add(User user){
        model.add(user);
    }
    public List<String> getlist(){
        return model.stream().map(User::getName)
                .collect(Collectors.toList());
    }
}
