package com.lch.springboot04.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 原生sql 查询接口
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface BaseRepository<T,ID extends Serializable> extends JpaRepository<T,ID> {

    List<T> listBySql(String sql);

    List listObjectBySql(String sql);

    <S> List<S> listBySql(String sql,Class<T> clazz);

    List<Map<String,Object>> listMapBySql(String sql);

    Object getObjectBySql(String sql);

    int executeSql(String sql);

}
