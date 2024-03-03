package com.medi.med.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.medi.med.modelo.FacDetalle;


public interface DetalleDao extends BaseDao<FacDetalle, Integer>, JpaSpecificationExecutor<FacDetalle> {

}
