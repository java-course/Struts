package ru.javacourse.struts.data;

import ru.javacourse.struts.form.UserForm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gb
 * Date: 23.03.13
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class UserDataSourse {

    private static List<UserForm> users = null;


    static {
        users = new ArrayList<UserForm>();
        users.add(new UserForm(1, "Ivan", "ivan@yandex.ru", 20));
        users.add(new UserForm(2, "Vova", "vovan@mail.ru", 30));
        users.add(new UserForm(3, "Sergey", "sergo@pochta.ru", 25));
    }

    public static void add(UserForm form) throws Exception{
        if (form.getId() < 1)
            throw new Exception();
        users.add(form);
    }

    public static UserForm getById(int id){
        for (UserForm user : users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    public static List<UserForm> getUsers() {
        return users;
    }
}
