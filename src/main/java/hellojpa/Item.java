package hellojpa;

import javax.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED)   // 상속관계 매핑 : 조인전략
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//단일 테이블
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)//구현 클래스마다 테이블 전략
//@DiscriminatorColumn  //단일 테이블은 선언 안해도 자동으로 생성됨
public abstract class Item {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
