package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

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
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setName("member1");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            Team findTeam = findMember.getTeam();
            System.out.println("findTeam.getName() = " + findTeam.getName());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
