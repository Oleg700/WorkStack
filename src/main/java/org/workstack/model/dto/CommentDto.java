package org.workstack.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CommentDto {

    @NotNull(message = "{field.not_null}")
    @Size(max = 500)
    private String content;
}
