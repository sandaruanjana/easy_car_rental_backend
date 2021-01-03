package lk.easyrental.spring.repo;

import lk.easyrental.spring.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRoleRepo extends JpaRepository<UserRole,String> {
    @Query(value = "select * from userrole where role_type=:name", nativeQuery = true)
    UserRole getUserRoleIdUsingName(@Param("name")String name);
}
