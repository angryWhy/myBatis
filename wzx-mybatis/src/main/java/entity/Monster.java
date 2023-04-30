package entity;

import lombok.*;

import java.util.Date;

//和monster表有映射关系
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
//@Data包含以上的
public class Monster {
    //属性和表的字段有对应关系
    private Integer id;
    private Integer age;
    private String name;
    private String email;
    private Date birthday;
    private Double salary;
    private Integer gender;
}