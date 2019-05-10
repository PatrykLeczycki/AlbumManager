package pl.coderslab.dto;

import lombok.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class UserDto {

    @NotNull
    @Size(min = 5, max = 20, message = "Username must have from 5 to 20 characters")
    private String username;

    @Pattern(regexp = "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}",
            message = "Wrong e-mail address format")
    private String email;

    @Size(min = 8, message = "Password must have at least 8 characters")
    private String password;

    private String matchingPassword;

    private Boolean enabled;

}
