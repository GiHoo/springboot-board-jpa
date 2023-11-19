package com.prgrms.springbootboardjpa.dto;

import com.prgrms.springbootboardjpa.domain.user.Hobby;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private int age;
    private Hobby hobby;
}
