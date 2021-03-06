package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //애플리케이션 처음 실행 될때

        EntityManager em = emf.createEntityManager(); // 사용자 요청시

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
//            Member member = new Member();

            //조회 코드
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id : " + findMember.getId());
//            System.out.println("findMember.name : " + findMember.getName());
            //수정 코드
//            findMember.setName("HelloJPA");
//            List<Member> result = em.createQuery("select m from Member as m", Member.class) // 조회 대상이 Membmer 객체를 조회(JPQL)
//                    .setFirstResult(5)
//                    .setMaxResults(8)   //페이징 할때 사용
//                    .getResultList();
//            for (Member member : result) {
//                System.out.println("member : " + member.getName());
//            }
            //2020.09.22
            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//            //영속
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");
//
//            Member findMember = em.find(Member.class, 101L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);       // 1차 캐쉬에서 가져오기때문에 위에서 쿼리 한번만 날림
//
//            System.out.println("result = " + (findMember1 == findMember2));     //영속 엔티티의 돌일성 보장

            //영속
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);    //한번에 insert를 실행함
//            System.out.println(" ==================== ");
//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZZ");   //트랜잭션에서 commit 하기전 값이 변경된것을 감지하여 update 함(엔티티와 스냅샷 비교) -> 변경감지(Dirty Checking)
//            System.out.println("==============");
//            Member member = new Member(200L, "A");
//            em.persist(member);
//
//            em.flush(); //영속성 컨텍스트의 변경내용을 데이터베이스에 동기화
//
//            System.out.println("==============");

            //영속
//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAA");// 변경감지
//
////            em.detach(member);  //준영속 상태 -> update 하지 않음 영속성 context에서 제거
//            em.clear(); // 영속 통으로 날림
//            Member member2 = em.find(Member.class, 150L);       //쿼리 2번나감
//            System.out.println("==============");

//            Member member = new Member();
//            System.out.println("==============");
//            em.persist(member);
//            System.out.println("member.getId() = " + member.getId());
//            System.out.println("==============");

            //jpa 연관관계 저장코드
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setName("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            Member findMember = em.find(Member.class, member.getId());
////            Team findTeam = findMember.getTeam();
////            System.out.println("findTeam.getName() = " + findTeam.getName());
//            List<Member> members = findMember.getTeam().getMembers();
//
//            for (Member member1 : members) {
//                System.out.println("member1.getName() = " + member1.getName());
//            }

            //저장
//            Team team = new Team();
//            team.setName("TeamA");
////            team.getMembers().add(member);    //연관관계 주인에게만 값을 세팅해야함
//            em.persist(team);
//
//            Member member = new Member();
//            member.setName("member1");
////            member.changeTeam(team);           //연관 관계 주인에게 값 세팅
//            em.persist(member);
//
////            team.getMembers().add(member);  //양방향에선 모두 값 세팅
//
//            team.addMember(member);
//
//            em.flush();
//            em.clear();
//
//            Team findTeam = em.find(Team.class, team.getId());
//            List<Member> members = findTeam.getMembers();
//
//            System.out.println("=============");
//            for (Member m : members) {
//                System.out.println("m.getName() = " + findTeam);
//            }
//            System.out.println("=============");
//            Movie movie = new Movie();
//            movie.setDirector("aaaa");
//            movie.setActor("bbbb");
//            movie.setName("바람과함께사라지다");
//            movie.setPrice(10000);
//            em.persist(movie);
//
//            em.flush();
//            em.clear();

//            Movie findMovie = em.find(Movie.class, movie.getId());
//            System.out.println("findMovie = " + findMovie);
            // 구현 클래스마다테이블 전략  단점
//            Item item = em.find(Item.class, movie.getId());
//            System.out.println("item = " + item);
            //@MappedSuperClass ex
//            Member member = new Member();
//            member.setName("user1");
//            member.setCreatedBy("kim");
//            member.setCreatedDate(LocalDateTime.now());
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();

            //프록시
//            Member member = new Member();
//            member.setName("hello");
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();

//            Member findMember = em.find(Member.class, member.getId());
//            Member findMember = em.getReference(Member.class, member.getId());
//            System.out.println("findMember.getClass() = " + findMember.getClass());
//            System.out.println("findMember.getId() = " + findMember.getId());       //디비에서 가져오지 않음(파라미터) ->getReference
//            System.out.println("findMember.getName() = " + findMember.getName());   //최초에 한번만 select
//            System.out.println("findMember.getName() = " + findMember.getName());   //프록시 객체에 있는거 조회
            //프록시 객체는 원본 엔티티를 상속받음, 따라서 타입 체크시 주의해야함 (== 비교 실패, 대신 instance of 사용)

//            Member member1 = new Member();
//            member1.setName("memger1");
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setName("memger1");
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
//            Member m1 = em.find(Member.class, member1.getId());
//            Member m2 = em.getReference(Member.class, member2.getId());
//
//            logic(m1, m2);

//            Member member1 = new Member();
//            member1.setName("memger1");
//            em.persist(member1);
//
//            em.flush();
//            em.clear();
//
//            Member m1 = em.find(Member.class, member1.getId());
//            System.out.println("m1.getClass() = " + m1.getClass());
//
//            Member reference = em.getReference(Member.class, member1.getId());  //프록시 객체에서 가져 오지 않고 영속성 컨텍스트에 실제 엔티티 가져옴
//            System.out.println("reference.getClass() = " + reference.getClass());
//            System.out.println("a == a : " + (m1 == reference));

//            Member member1 = new Member();
//            member1.setName("memger1");
//            em.persist(member1);
//
//            em.flush();
//            em.clear();
//
//            Member refMember = em.getReference(  Member.class, member1.getId());
//            System.out.println("refMember.getClass() = " + refMember.getClass());
//
//            Member findMember = em.find(Member.class, member1.getId());
//            System.out.println("findMember.getClass() = " + findMember.getClass()); //프록시에사 가져옴
//            System.out.println("a == a : " + (refMember == findMember));    // true

//            Member member1 = new Member();
//            member1.setName("memger1");
//            em.persist(member1);
//
//            em.flush();
//            em.clear();
//
//            Member refMember = em.getReference(  Member.class, member1.getId());
//            System.out.println("refMember.getClass() = " + refMember.getClass()); //porxy

//            em.detach(refMember);
//            em.clear(); //예외 발생
//            System.out.println("refMember.getName() = " + refMember.getName());
//            refMember.getName();    //강제 초기화( JPA 표준은 강제 초기화 없음)
//            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));
//            Hibernate.initialize(refMember);    //강제 초기화

            // 지연 로딩, 즉시 로딩
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Team teamB = new Team();
//            team.setName("teamB");
//            em.persist(teamB);
//
//            Member member1 = new Member();
//            member1.setName("memger1");
//            member1.setTeam(team);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setName("memger2");
//            member2.setTeam(teamB);
//            em.persist(member2);
//
//            em.flush();
//            em.clear();

//            Member m = em.find(Member.class, member1.getId());

//            System.out.println("m = " + m.getTeam().getClass());    //즉시 로딩에선 진짜 객체가 나옴
//
//            System.out.println("=========================");
//            m.getTeam().getName();// 프록시 초기화(DB에서 team 가져옴, team의 객체에서 데이터를 꺼낼때 쿼리 발생)
//            System.out.println("=========================");

            //즉시로딩 N+1 예제
//            List<Member> members = em.createQuery("select m from Member m", Member.class)   //Member에 Team이 EAGER로 되어 있는것을 보고 리스트에 담겨있는 member 하나하나
//                    .getResultList();                                                               //Team을 조회하는 쿼리를 발생시킴


            //Cascade 영속성 전이
//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            Parent parent = new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
//            em.persist(child1);
//            em.persist(child2);
//
//            em.flush();
//            em.clear();
//
//            Parent findParent = em.find(Parent.class, parent.getId());
//            findParent.getChildList().remove(0);  //CascadeType.ALL 예제
//            em.remove(findParent);  //orphanRemoval 예제

            //임베디트 타입 사용
//            Member member = new Member();
//            member.setUserName("hello");
//            member.setHomeAddress(new Address("city", "street", "zipcode"));
//            member.setWorkPeriod(new Period());
//
//            em.persist(member);

            //값 타입과 불변의 객체
//            Address address = new Address("city", "street", "10000");

//            Member member = new Member();
//            member.setUserName("member1");
//            member.setHomeAddress(address);
//            em.persist(member);
//
//            Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());
//            Member member2 = new Member();
//            member2.setUserName("member2");
//            member2.setHomeAddress(copyAddress);
//            em.persist(member2);

            //값 타입의 실제 인스턴스인 값을 공유하는 것은 위험
            //대신 값(인스턴스)를 복사해서 사용
//            member.getHomeAddress().setCity("newCity");     //member, member2 모두 city가 바뀜

            //값 타입 컬렉션 사용 예제
//            Member member = new Member();
//            member.setUserName("member1");
//            member.setHomeAddress(new Address("homeCity", "street", "10000"));
//
//            member.getFavoriteFoods().add("치킨");
//            member.getFavoriteFoods().add("족발");
//            member.getFavoriteFoods().add("피자");
//
//            member.getAddressHistory().add(new AddressEntity("old1", "street", "10000"));
//            member.getAddressHistory().add(new AddressEntity("old2", "street", "10000"));
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();

            //값 타입 컬렉션은 지연로딩
//            System.out.println("============== START ================");
//            Member findMember = em.find(Member.class, member.getId());

            //값 타입 커렉션 조회
//            List<Address> addressHistory = findMember.getAddressHistory();
//            for (Address address1 : addressHistory) {
//                System.out.println("address1.getCity() = " + address1.getCity());
//            }
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for (String favoriteFood : favoriteFoods) {
//                System.out.println("favoriteFood = " + favoriteFood);
//            }

            //값 타입  수정
            //homeCity -> newcity
//            findMember.getHomeAddress().setCity("newCity");   x(잘못됨, 값타입에선..)
//            Address a = findMember.getHomeAddress();
//            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode())); //값 타입은 새로운 객체를 만들어서 통으로 바꿔야함

            //값 타입 컬렉션 수정
//            //치킨 -> 한식
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");

            //주소 변경
//            findMember.getAddressHistory().remove(new Address("old1", "street", "10000"));  // equals  완벽히 재구현 해줘야함
//            findMember.getAddressHistory().add(new Address("newCity1", "street", "10000"));

            //JPQL
//            List<Member> resultList = em.createQuery(
//                    "select m From Member m where m.userName like '%kim%'",
//                    Member.class
//            ).getResultList();
//            for (Member member : resultList) {
//                System.out.println("member = " + member);
//            }
            //Criteria 사용 준비
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Member> query = cb.createQuery(Member.class);
//
//            Root<Member> m = query.from(Member.class);
//
//            CriteriaQuery<Member> cq = query.select(m);

            //동적 쿼리 예
//            String username = "aaaa";
//            if (username != null) {
//                cq.where(cb.equal(m.get("userName"), "kim"));
//            }
//
//            List<Member> resultList = em.createQuery(cq).getResultList();
            Member member = new Member();
            member.setUserName("member1");
            em.persist(member);

            List<Member> resultList = em.createNativeQuery("select MEMBER_ID, city, street, zipcode, USERNAME from Member", Member.class).getResultList();

            for (Member member1 : resultList) {
                System.out.println("member = " + member1);
            }


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void logic(Member m1, Member m2) {
//        System.out.println("m1 == m2 " + (m1.getClass() == m2.getClass()));
        System.out.println("m1 instanceof Member = " + (m1 instanceof Member));
        System.out.println("m2 instanceof Member = " + (m2 instanceof Member));
    }
}
