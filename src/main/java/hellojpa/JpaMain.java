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
//
            /* ============================================================ */
//            Member member = new Member();
//            member.setUsername("member1");
//
//            em.persist(member);
//
//            Team team = new Team();
//            team.setName("teamA");
//
//            //  MEMBER 테이블에 있는 외래키가 업데이트 됨.
//            team.getMembers().add(member);
//
//            em.persist(team);

            /* ============================================================ */

//            Movie movie = new Movie();
//            movie.setDirector("최동훈");
//            movie.setActor("김윤석");
//            movie.setName("도둑들");
//            movie.setPrice(10000);
//
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//
//            Movie findMovie = em.find(Movie.class, movie.getId());
//            System.out.println("findMovie: " + findMovie);

//            Member member1 = new Member();
//            member1.setUsername("member1");
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
//            Member m1 = em.find(Member.class, member1.getId());
//            Member m2 = em.getReference(Member.class, member2.getId());
//
//            logic(m1, m2);

//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            Member findMember = em.find(Member.class, member.getId());
//            System.out.println("member = " + findMember.getTeam().getClass()); // 지연로딩을 사용하면 프록시 객체 사용
//
//            System.out.println("=======================");
//            member.getTeam().getName(); //이때 프록시를 초기화하고 db에서 조회해옴
//            System.out.println("=======================");

            Parent parent = new Parent();

            Child child1 = new Child();
            Child child2 = new Child();

            em.persist(parent); //cascade = CascadeType.ALL 옵션으로 child1, child2까지 모두 persist됨.


            tx.commit(); // 저장시, 실제로 DB에 저장되는 시점
        }catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

    private static void logic(Member m1, Member m2) {
        System.out.println("m1 == m2 : " + (m1.getClass() == m2.getClass())); // 타입비교를 == 으로 하면 안됨.
        System.out.println("m1 : " + (m1 instanceof Member));
        System.out.println("m2 : " + (m2 instanceof Member));
    }
}
