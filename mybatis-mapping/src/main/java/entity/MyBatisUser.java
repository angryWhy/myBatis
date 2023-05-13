package entity;

import java.util.List;

public class MyBatisUser {
    private String name;
    private Integer id;
    private List<MyBatisPet> pets;

    public List<MyBatisPet> getMyBatisPetList() {
        return pets;
    }

    public void setMyBatisPetList(List<MyBatisPet> myBatisPetList) {
        this.pets = myBatisPetList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MyBatisUser{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
