package org.ayupov.raiffeisentask.services;

import org.ayupov.raiffeisentask.dto.SockDto;
import org.ayupov.raiffeisentask.exceptions.ValidationErrorCode;
import org.ayupov.raiffeisentask.exceptions.ValidationException;
import org.ayupov.raiffeisentask.models.Sock;
import org.ayupov.raiffeisentask.repositries.SockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SockService {

    @Autowired
    private SockRepository sockRepository;

    public SockDto addSocks(SockDto sockDto){
        Optional<Sock> requestAnswer = sockRepository.findSockByColorAndCottonPart(sockDto.getColor(), sockDto.getCottonPart());
        Sock sock;
        if(requestAnswer.isPresent()) {
            sock = requestAnswer.get();
            sock.setQuantity(sock.getQuantity() + sockDto.getQuantity());
            sockRepository.save(requestAnswer.get());
            return SockDto.from(sock);
        } else {
            sock = Sock.builder()
                    .color(sockDto.getColor())
                    .cottonPart(sockDto.getCottonPart())
                    .quantity(sockDto.getQuantity())
                    .build();
            sockRepository.save(sock);
            return SockDto.from(sock);
        }
    }

    public SockDto takeSocks(SockDto sockDto){
        Optional<Sock> requestAnswer = sockRepository.findSockByColorAndCottonPart(sockDto.getColor(), sockDto.getCottonPart());
        if(requestAnswer.isPresent()) {
            Sock sock = requestAnswer.get();
            if (sock.getQuantity() - sockDto.getQuantity() >= 0) {
                sock.setQuantity(sock.getQuantity() - sockDto.getQuantity());
                sockRepository.save(sock);
                return SockDto.from(sock);
            }
            else {
                throw new  ValidationException(ValidationErrorCode.INCORRECT_PARAMS);
            }

        } else {
            throw new  ValidationException(ValidationErrorCode.INCORRECT_PARAMS);
        }
    }

    public List<Sock> getSocksByParam(SockDto sockDto, String operation) {
        List<Sock> socks = new ArrayList<>();
        switch (operation){
            case ("moreThan"):
                socks = sockRepository.findSocksByColorAndCottonPartGreaterThanEqual(sockDto.getColor(),
                        sockDto.getCottonPart());
                break;
            case ("lessThan"):
                socks = sockRepository.findSockByColorAndCottonPartLessThanEqual(sockDto.getColor(),
                        sockDto.getCottonPart());
                break;
            case ("equal"):
                socks.add(sockRepository.findSockByColorAndCottonPart(sockDto.getColor(),
                        sockDto.getCottonPart()).orElseThrow(IllegalArgumentException::new));
                break;
            default:
                throw new ValidationException(ValidationErrorCode.SERVER_CRASH);
        }
        return socks;
    }

    public List<Sock> getAllSocks(){
        return sockRepository.findAll();
    }
}
