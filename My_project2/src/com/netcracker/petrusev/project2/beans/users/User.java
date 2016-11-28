package com.netcracker.petrusev.project2.beans.users;

/**
 * Created by Asus on 13.11.2016.
 */
public class User {
    private String page = null;
    private String login = null;
    private String firstName = null;
    private String secondName = null;
    private String mail = null;
    private String password = null;
    private String priority = null;

    private int id;

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getPage() {
        return page;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "User{" +
                "page='" + page + '\'' +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (page != null ? !page.equals(user.page) : user.page != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (secondName != null ? !secondName.equals(user.secondName) : user.secondName != null) return false;
        if (mail != null ? !mail.equals(user.mail) : user.mail != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return priority != null ? priority.equals(user.priority) : user.priority == null;

    }

    @Override
    public int hashCode() {
        int result = page != null ? page.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        return result;
    }
}
