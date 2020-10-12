package hellojpa;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.IdentityHashMap;
//
//@Entity
////@Table(name = "MBR") // 테이블 이름 지정
////@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq")  //시퀀스 테이블마다 정해줄 때
//@SequenceGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        sequenceName = "MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름
//        initialValue = 1, allocationSize = 50)
//public class Member {
//
////    @Id
//////    @Column(name = "usnerId") //컬러몀 지정
////    private Long id;
////    @Column(unique = true, length = 10)
////    private String name;
////    private int age;
//
////    @Id
////    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,
//    generator = "MEMBER_SEQ_GENERATOR")
//    private Long id;
//
//    @Column(name = "name", nullable = false)          //디비 컬럼은 name
//    private String username;
//
//    private Integer age;
//
//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//    @Lob
//    private String description;
//
//    private LocalDate testLocalDate;
//    private LocalDateTime testLcalDateTime;
//
//    public Member(Long id, String username, Integer age, RoleType roleType, Date createdDate, Date lastModifiedDate, String description) {
//        this.id = id;
//        this.username = username;
//        this.age = age;
//        this.roleType = roleType;
//        this.createdDate = createdDate;
//        this.lastModifiedDate = lastModifiedDate;
//        this.description = description;
//    }
//
//    public Member() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public RoleType getRoleType() {
//        return roleType;
//    }
//
//    public void setRoleType(RoleType roleType) {
//        this.roleType = roleType;
//    }
//
//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public Date getLastModifiedDate() {
//        return lastModifiedDate;
//    }
//
//    public void setLastModifiedDate(Date lastModifiedDate) {
//        this.lastModifiedDate = lastModifiedDate;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//}


import com.sun.xml.internal.rngom.parse.host.Base;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;

//@Entity
//public class Member extends BaseEntity {
//    @Id
//    @GeneratedValue
//    private Long id;
//    @Column(name = "USERNAME")
//    private String name;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

//    @ManyToOne(fetch = FetchType.LAZY)  //프록시 객체 조회(지연로딩)
//    @ManyToOne(fetch = FetchType.EAGER)  //즉시로딩
//    @JoinColumn(name = "TEAM_ID")       //연관관계의 주인(진짜 매핑) : 연관관계 주인은 fk(왼래키)가 있는 객체, 다(many)가 있는곳(fk 있는곳)이 연관관계 주인
//    private Team team;

//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;

    /*
    @ManyToMany                         // 다대다 조인 테이블 설정
    @JoinTable(name = "MEMBER_PRODUCT")// 실무에서 사용하기 힘듬(연결만 하지 않고 다른 추가 데이터가 있을수 있기 때문)
    private List<Product> products = new ArrayList<Product>();
    */
//    @OneToMany(mappedBy = "member") //다대다 매핑 테이블이랑 연관관계
//    private List<MemberProduct> memberProducts = new ArrayList<MemberProduct>();



    //연관관계 편의 메소드
//    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }
//}


@Entity
public  class Member {
    // 임배디드 타입 테이블 매핑

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String userName;

    //기간 period
//    @Embedded
//    private Period workPeriod;

    //주소
    @Embedded
    private Address homeAddress;

    //값 타입 컬렉션
    //fetch 기본값 lazy
    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

    //실무에선 값타입으로 사용하지 않고 엔티티를 하나 만들어서 일대다 매칭함
//    @ElementCollection
//    @CollectionTable(name = "ADDRESS", joinColumns = @JoinColumn(name = "MEMBER_ID"))
//    private List<Address> addressHistory = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

    //주소
//    @Embedded   //homeAddress, workAddress 객체의 변수들이 같기때문에 오버라이드를 해야함
//    @AttributeOverrides({
//            @AttributeOverride(name = "city", column = @Column(name = "WORK_CITY")),
//            @AttributeOverride(name = "street", column = @Column(name = "WORK_STREET")),
//            @AttributeOverride(name = "zipcode", column = @Column(name = "WORK_ZIPCODE")),
//    })
//    private Address workAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }


    public List<AddressEntity> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<AddressEntity> addressHistory) {
        this.addressHistory = addressHistory;
    }
}