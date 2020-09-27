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


import javax.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "USERNAME")
    private String name;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")       //연관관계의 주인(진짜 매핑) : 연관관계 주인은 fk(왼래키)가 있는 객체, 다(many)가 있는곳(fk 있는곳)이 연관관계 주인
    private Team team;

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
