package entity;

public class Person {
    private Integer id;
    private String name;
    //级联操作，要写一个IdenCard属性
    private IdenCard card;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IdenCard getCard() {
        return card;
    }

    public void setCard(IdenCard card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", card=" + card +
                '}';
    }
}
