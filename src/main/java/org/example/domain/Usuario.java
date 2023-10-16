package org.example.domain;

public class Usuario {
    private int iduser;
    private String name;
    private String password;

    public Usuario() {
    }

    public Usuario(int id) {
        this.iduser = id;
    }

    public Usuario(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Usuario(int id, String name, String password) {
        this.iduser = id;
        this.name = name;
        this.password = password;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "iduser=" + iduser +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
