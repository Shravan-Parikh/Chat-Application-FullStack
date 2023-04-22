package com.zos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zos.modal.Chat;

public interface ChatRepository extends JpaRepository<Chat, Integer> {

	@Query("select c from Chat c join c.users u where u.id=:userId")
	public List<Chat> findChatByUserId(Integer userId);
	
	@Query("select c from Chat c Where c.is_group=false And :userId Member of c.users And :reqUserId Member of c.users")
	public Chat findSingleChatByUsersId(@Param("userId") Integer userId,@Param("reqUserId")Integer reqUserId);
}
