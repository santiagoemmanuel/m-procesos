package com.medi.med.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.medi.med.modelo.FacDetalle;

public interface FacDetalleDao extends BaseDao<FacDetalle, Integer>, JpaSpecificationExecutor<FacDetalle> {

	
	///public List<FacDetalle> findFacNoFactura(Integer noFactura);
}
