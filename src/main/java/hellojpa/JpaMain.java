package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{
            /**
             * - 회원 저장
             *      Member member = new Member();
             *      member.setId(2L);
             *      member.setName("HelloB");
             *      em.persist(member);
             */

            // 회원 수정
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());
//            findMember.setName("HelloJPA");

            // 회원 조회
//            List<Member> resultList = em.createQuery("select m from Member as m", Member.class)
//                    .getResultList();
//
//            for (Member member : resultList) {
//                System.out.println("member.getName() = " + member.getName());
//            }

            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            // 영속
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");
//
//            Member findMember = em.find(Member.class, 101L);
//
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

//            Member member = new Member();
//            member.setId(2L);
//            member.setUsername("B");
//            member.setRoleType(RoleType.USER);
//
//            em.persist(member);


            /** mappedBy 는 readOnly 이기 때문에 memberId가 null로 들어감
             * Member member = new Member();
             * member.setUsername("member1");
             * //  member.setTeamId(team.getId());
             *  em.persist(member);
             *
             * Team team = new Team();
             * team.setName("TeamA");
             * team.getMembers().add(member);
             * em.persist(team);
             */

//            Team team = new Team();
//            team.setName("TeamA");
////            team.getMembers().add(member);
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
////            member.setTeamId(team.getId());
//            member.setTeam(team);
//            em.persist(member);



//            Member findMember = em.find(Member.class, member.getId());
//            Team findTeam = findMember.getTeam();
//
//            System.out.println("findTeam = " + findTeam.getName());

//            em.flush();
//            em.clear();
//
//            Team findTeam = em.find(Team.class, team.getId()); // 1차 캐시
//            List<Member> members = findTeam.getMembers();
//
//            for (Member m : members) {
//                System.out.println("m = " + m.getUsername());
//            }

//            Member findMember = em.find(Member.class, member.getId());
//            List<Member> members = findMember.getTeam().getMembers();
//
//            for (Member m : members) {
//                System.out.println("m = " + m.getUsername());
//            }

            Member member = new Member();
            member.setUsername("member1");

            em.persist(member);

            Team team = new Team();
            team.setName("teamA");

            //  MEMBER 테이블에 있는 외래키가 업데이트 됨.
            team.getMembers().add(member);

            em.persist(team);

            tx.commit(); // 저장시, 실제로 DB에 저장되는 시점
        }catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
