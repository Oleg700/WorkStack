package org.workstack.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ResumeDto {

    @NotNull(message = "{field.not_null}")
    @Size(max = 30)
    private String jobPosition;

    @NotNull(message = "{field.not_null}")
    @Size(max = 1000)
    private String description;
}
