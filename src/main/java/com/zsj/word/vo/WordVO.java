package com.zsj.word.vo;

import com.zsj.word.pojo.Tag;
import com.zsj.word.pojo.Word;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordVO {
    private Word word;
    private List<Tag> tags;
}
