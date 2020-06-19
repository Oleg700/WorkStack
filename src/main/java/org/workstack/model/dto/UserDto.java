package org.workstack.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.workstack.model.Article;
import org.workstack.model.Resume;
import org.workstack.model.Role;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;
import java.util.SortedSet;

@Getter
@Setter
public class UserDto {

    @NotNull(message = "{field.not_null}")
    @Size(max = 30)
    private String name;

    @NotNull(message = "{field.not_null}")
    @Size(max = 30)
    private String lastName;

    @NotNull(message = "{field.not_null}")
    @Size(max = 30)
    private String username;

    @NotNull(message = "{field.not_null}")
    @Size(max = 50)
    private String email;

    @NotNull(message = "{field.not_null}")
    @Size(max = 50)
    private String city;

    @NotNull(message = "{field.not_null}")
    private LocalDate birthDate;

    @NotNull(message = "{field.not_null}")
    @Size(max = 30)
    private String password;

    private SortedSet<Article> articles;

    private Resume resume;

    private Set<Role> roles;
}
