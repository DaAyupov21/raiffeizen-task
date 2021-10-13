package org.ayupov.raiffeisentask.repositries;

import org.ayupov.raiffeisentask.models.Sock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SockRepository extends JpaRepository<Sock, Long> {
    Optional<Sock> findSockByColorAndCottonPart(String color, Byte cottonPart);
    List<Sock> findSocksByColor(String color);
    List<Sock> findSocksByColorAndCottonPartGreaterThanEqual(String color, Byte cottonPart);
    List<Sock> findSockByColorAndCottonPartLessThanEqual(String color, Byte cottonPart);
}
