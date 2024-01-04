package com.youquiz.youquiz.DTO;

import com.youquiz.youquiz.Enum.Sender;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ChatDTO {
    private long student_id;
    private long trainer_id;
    //@NotBlank(message = "message is required")
    private String message;
    private LocalDateTime messageTime;
    //@NotBlank(message = "the sender is required")
    private Sender sender;
    @NotBlank(message = "room id is required")
    @Min(value = 1)
    private Long room_id;
}
