package uz.tripshare.tripservice.domain.Dto.Response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class BaseResponse {
    private Integer id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
