package org.workstack.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ArticleDto {

    @NotNull(message = "{field.not_null}")
    @Size(max = 30)
    private String topic;

    @NotNull(message = "{field.not_null}")
    @Size(max = 4000)
    private String content;
}
