package az.company.turbo.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ErrorResponse {
    private int code;
    private LocalDateTime dateTime;
    private String message;
}
