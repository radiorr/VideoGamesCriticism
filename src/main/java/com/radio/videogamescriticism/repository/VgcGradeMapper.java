package com.radio.videogamescriticism.repository;

import com.radio.videogamescriticism.domain.VgcGrade;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VgcGradeMapper {

    @Select("SELECT * FROM vgc_grade")
    public List<VgcGrade> getAll();



}
