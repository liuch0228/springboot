package com.lch.springboot04.repo.base;

import com.lch.springboot04.repository.BaseRepository;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class BaseRepositoryImpl<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID>
        implements BaseRepository<T, ID> {

    private final EntityManager entityManager;
    private Class<T> clazz;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.clazz = domainClass;
        this.entityManager = entityManager;
    }

    @Override
    public List<T> listBySql(String sql) {
        return entityManager.createNamedQuery(sql, clazz).getResultList();
    }

    @Override
    public List listObjectBySql(String sql) {
        return entityManager.createNativeQuery(sql).getResultList();
    }

    @Override
    public <S> List<S> listBySql(String sql, Class<T> clazz) {
        return entityManager.createNativeQuery(sql, clazz).getResultList();
    }

    @Override
    public List<Map<String, Object>> listMapBySql(String sql) {
        return entityManager.createNativeQuery(sql).unwrap(SQLQuery.class).setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
    }

    @Override
    public Object getObjectBySql(String sql) {
        List<Object[]> list = entityManager.createNativeQuery(sql).getResultList();
        if (list != null && list.size() > 0 && list.get(0) != null) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public int executeSql(String sql) {
        return entityManager.createNativeQuery(sql).executeUpdate();
    }
}
