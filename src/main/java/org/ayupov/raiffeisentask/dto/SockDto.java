package org.ayupov.raiffeisentask.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ayupov.raiffeisentask.models.Sock;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SockDto {
    private String color;
    @Min(value = 0, message = "Cotton part cannot be less than 0%")
    @Max(value = 100, message = "Cotton part cannot be more than 100%")
    private Byte cottonPart;
    @Min(value = 0, message = "The quantity cannot be less than 0")
    private Integer quantity;

    static public SockDto from (Sock sock) {
        return SockDto.builder()
                .color(sock.getColor())
                .quantity(sock.getQuantity())
                .cottonPart(sock.getCottonPart()).build();
    }

    static public List<SockDto> from (List<Sock> socks) {
        return socks.stream().map(SockDto::from).collect(Collectors.toList());
    }
}
