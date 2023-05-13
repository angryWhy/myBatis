package entity;

public class MyBatisPet {
    private Integer id;
    private String nickname;
    private MyBatisUser users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public MyBatisUser getMyBatisUser() {
        return users;
    }

    public void setMyBatisUser(MyBatisUser myBatisUser) {
        this.users = myBatisUser;
    }

    @Override
    public String toString() {
        return "MyBatisPet{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", myBatisUser=" + users +
                '}';
    }
}
