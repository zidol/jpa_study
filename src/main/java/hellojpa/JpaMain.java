package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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
            List<Member> result = em.createQuery("select m from Member as m", Member.class) // 조회 대상이 Membmer 객체를 조회(JPQL)
                    .setFirstResult(5)
                    .setMaxResults(8)   //페이징 할때 사용
                    .getResultList();
            for (Member member : result) {
                System.out.println("member : " + member.getName());
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
